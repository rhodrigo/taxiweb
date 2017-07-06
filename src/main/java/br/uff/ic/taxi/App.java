package br.uff.ic.taxi;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.nio.charset.Charset;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.DecompositionSolver;
import org.apache.commons.math3.linear.LUDecomposition;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.math3.linear.SingularValueDecomposition;
import org.apache.log4j.Logger;

import br.com.taxi.exception.ErroTaxi;
import br.com.taxi.matriz.LeitorMatriz;
import br.com.taxi.model.Arrow;
import br.com.taxi.model.Circle;
import br.com.taxi.model.Mapa;
import br.com.taxi.model.Mapas;
import br.com.taxi.model.Square;
import br.com.taxi.model.Taxi;

public class App {

	private static List<Count> oldListCount = null;

	private static Logger LOG = Logger.getLogger(App.class);

	public static void main(String[] args) throws IOException {
		new App().geraMapas(new Config());
	}

	public Mapas geraMapaWeb(Config config) throws ErroTaxi {

		int oldI = -1;
		List<Point> oldListTaxi = null;

		try {

			Mapas mapas = new Mapas();
			Database database = new Database();

			for (int i = 0; i < config.getMapas(); i++) {

				List<Point> listTaxi = database.getListTaxi(i, config);

				Mapa mapa = buildMapJS(config, i, listTaxi, oldI, oldListTaxi);

				mapa.setDataInicio(database.getStart());
				mapa.setDataFim(database.getEnd());
				mapa.setLat(config.getLatitude());
				mapa.setLon(config.getLongitude());
				mapa.setZoom(config.getZoomPadrao());
				mapa.setMaxZoom(18);

				oldI = i;
				oldListTaxi = listTaxi;

				mapas.put(mapa);

			}

			ajusta(mapas);

			database.close();

			return mapas;

		} catch (Exception e) {
			throw new ErroTaxi("Erro na Aplicação", e);
		}

	}

	private void ajusta(Mapas mapas) {

		int maxTaxisSquare = mapas.getMaxTaxiOnSquare();

		for (Mapa mapa : mapas.getMapaList()) {
			for (Square square : mapa.getSquares()) {
				square.updateBackground(maxTaxisSquare);
			}
		}
	}

	private void geraMapas(Config config) {

		int oldI = -1;
		Timestamp oldStart = null;
		Timestamp oldEnd = null;
		List<Point> oldListTaxi = null;

		try {

			Database database = new Database();

			for (int i = 0; i < config.getMapas(); i++) {

				List<Point> listTaxi = database.getListTaxi(i, config);

				Timestamp dataInicio = database.getStart();
				Timestamp dataFim = database.getEnd();

				LOG.info("|- " + listTaxi.size() + " Pontos encotrados: " + dataInicio + " - " + dataFim);

				buildIndexHtml(config, i, dataInicio, dataFim, oldI, oldStart, oldEnd);
				buildMapJS(config, i, listTaxi, oldI, oldListTaxi);

				oldI = i;
				oldStart = dataInicio;
				oldEnd = dataFim;
				oldListTaxi = listTaxi;

			}

			database.close();

		} catch (Exception e) {
			LOG.error("|- Erro ao executar Aplicação", e);
		}
	}

	// TODO buildIndexHtml
	private static void buildIndexHtml(Config config, Integer i, Timestamp start, Timestamp end, Integer oldI, Timestamp oldStart, Timestamp oldEnd) throws IOException {

		try {

			LOG.info("|- Construindo HTML");

			StringBuilder pagination = new StringBuilder();
			pagination.append("\t<ul class=\"pagination\">\n");
			for (int j = 0; j < config.getMapas(); j++) {
				if (i == j) {
					pagination.append("\t<li class=\"active\"><a href=\"../map");
					pagination.append(j);
					pagination.append("/index.html\">");
				} else {
					pagination.append("\t<li><a href=\"../map");
					pagination.append(j);
					pagination.append("/index.html\">");
				}
				pagination.append(j);
				pagination.append("</a></li>\n");
			}
			pagination.append("</ul>\n\n");

			pagination = new StringBuilder();

			StringBuilder titleDst = new StringBuilder();
			titleDst.append("\t<p>Mapa ");
			titleDst.append(i);
			titleDst.append(" : ");
			titleDst.append(start);
			titleDst.append(" .. ");
			titleDst.append(end);
			titleDst.append("</p>\n");

			StringBuilder map = new StringBuilder();
			map.append("\t<div id=\"map\" style=\"width: 100%;");
			map.append("height: 100%;");
			map.append("position: relative;\"></div>\n");

			StringBuilder titleSrcDst = new StringBuilder();
			titleSrcDst.append("\t<p>Mapa ");

			titleSrcDst.append(i);
			titleSrcDst.append(" : ");
			titleSrcDst.append(start);
			titleSrcDst.append(" .. ");
			titleSrcDst.append(end);

			if (oldI > -1) {
				titleSrcDst.append(" + Mapa ");
				titleSrcDst.append(oldI);
				titleSrcDst.append(" : ");
				titleSrcDst.append(oldStart);
				titleSrcDst.append(" .. ");
				titleSrcDst.append(oldEnd);
			}

			titleSrcDst.append("</p>\n");

			titleSrcDst = new StringBuilder();
			titleDst = new StringBuilder();

			String cabecalho = Util.readFile("cabecalhoDensidade.txt", Charset.defaultCharset());
			StringBuilder conteudo = new StringBuilder();
			conteudo.append(pagination.toString());
			conteudo.append(titleDst.toString());
			conteudo.append(map.toString());
			String rodape = Util.readFile("rodape.txt", Charset.defaultCharset());
			Util.buildFile("densidade", "index.html", i, cabecalho, conteudo.toString(), rodape);

			cabecalho = Util.readFile("cabecalhoDeslocamento.txt", Charset.defaultCharset());
			conteudo = new StringBuilder();
			conteudo.append(pagination.toString());
			conteudo.append(titleSrcDst.toString());
			conteudo.append(map.toString());
			Util.buildFile("deslocamento", "index.html", i, cabecalho, conteudo.toString(), rodape);

		} catch (IOException e) {
			throw e;
		}
	}

	// TODO buildMapJS
	private static Mapa buildMapJS(Config config, Integer i, List<Point> listTaxi, Integer oldI, List<Point> oldListTaxi) throws IOException {

		LOG.info("|- Construindo JS");

		Mapa mapa = new Mapa();

		List<Count> listCount = new ArrayList<Count>();

		/*
		 * Desenha o mapa (trecho comum aos dois mapas)
		 */
		String map = JavaScript.drawMap(config);

		StringBuilder quadrados = new StringBuilder();
		quadrados.append("function loadSquare() {\n");
		BigDecimal tL = new BigDecimal(config.getTamanhoLateral());
		BigDecimal lado = tL.divide(config.FRACAO);
		BigDecimal lat = config.getLatitudeMin();
		Integer celula = 1;

		while (lat.compareTo(config.getLatitudeMax()) < 0) {

			BigDecimal lng = config.getLongitudeMin();

			while (lng.compareTo(config.getLongitudeMax()) < 0) {

				/*
				 * Conta quantos Taxis tem dentro do quadrado (trecho comum aos
				 * dois mapas)
				 */
				Integer total = 0;

				for (Point taxi : listTaxi) {
					if ((taxi.getLatitude().compareTo(lat) >= 0 && taxi.getLatitude().compareTo(lat.add(lado)) <= 0)
							&& (taxi.getLongitude().compareTo(lng) >= 0 && taxi.getLongitude().compareTo(lng.add(lado)) <= 0)) {
						total++;
					}
				}

				/*
				 * Desenha os quadrados (trecho comum aos dois mapas)
				 */
				listCount.add(new Count(i, celula, total, lat, lng, lado));

				Square square = JavaScript.drawSquare(lat, lng, lado, total, celula);
				quadrados.append(square.draw());

				mapa.put(square);

				lng = lng.add(lado);
				celula++;
			}
			lat = lat.add(lado);
		}
		quadrados.append("}\n\n");

		/*
		 * Desenha cada taxi (mapa de densidade)
		 */
		StringBuilder taxisDst = new StringBuilder();

		taxisDst.append("function loadTaxi() {\n");

		for (Point point : listTaxi) {
			Taxi taxi = JavaScript.drawDstTaxi(point);
			mapa.put(taxi);
			taxisDst.append(taxi.draw());
		}

		taxisDst.append("}\n\n");

		/*
		 * Desenha cada taxi (mapa de deslocamento)
		 */
		StringBuilder taxisSrcDst = new StringBuilder();
		taxisSrcDst.append("function loadTaxi() {\n");
		if (oldI > -1) { // Se existe mapa anterior (não ocorre no Mapa 0)
			for (Point point : oldListTaxi) {
				Taxi taxi = JavaScript.drawSrcTaxi(point);
				taxisSrcDst.append(taxi.draw());
			}
		}
		for (Point point : listTaxi) {
			Taxi taxi = JavaScript.drawDstTaxi(point);
			taxisSrcDst.append(taxi.draw());
		}
		taxisSrcDst.append("}\n\n");

		/*
		 * Desenha as setas (mapa de densidade)
		 */
		List<Point> listPonto = new ArrayList<Point>();
		int c = 0;
		StringBuilder setasDst = new StringBuilder();
		setasDst.append("function loadArrow() {\n");
		for (Count org : listCount) {

//			System.out.println("|--------------------");

			Util.showDados(org, listCount, config);
			Count dst = Search.maxNeighbor(i, org, listCount, config);

//			System.out.println("-Maior Vizinho é: " + (dst.getCelula() - 1) + " Total: " + dst.getTotal());

			if (org.getTotal() > 0) {

				Arrow arrow = PreProcess.arrow(org, dst, config);
				setasDst.append(arrow.getDraw());
				// Não usado

			}

			listPonto.add(Util.setPonto(c, org, dst));
			c++;
		}
		setasDst.append("}\n\n");

		// printList("Lista escalar do mapa "i, listPonto);

		Point[][] v = matriz(config, listPonto);
		print(config, "Mapa densidade: Matriz escalar do ", i, v);

		double[][] u = mdfU(config, i, listPonto.size(), v);
		int t = config.getVizinhos().intValue() * 2 + 1;
		print("Mapa densidade: Matriz u de ", i, u, t);

		/*
		 * Desenha os circulos (mapa de densidade)
		 */

		StringBuilder circulosDst = new StringBuilder();

		double[][] s = mdfS(config, i, listPonto.size(), v);
		print("Matriz s de ", i, s, t);
		System.out.println("\n");

		circulosDst.append(setUS(config, u, s, v, mapa, listCount));

		/*
		 * Desenha as setas (mapa de deslocamento)
		 */
		StringBuilder setasSrcDst = new StringBuilder();
		StringBuilder circulosSrcDst = new StringBuilder();
		if (oldI > -1) { // Se existir mapa anterior (não ocorre no Mapa 0)
			listPonto = new ArrayList<Point>();
			c = 0;
			setasSrcDst.append("function loadArrow() {\n");
			for (Count org : oldListCount) {
				// Util.ShowDados(org, listCount);
				Count dst = Search.maxNeighbor(i, org, listCount, config);
				if (org.getTotal() > 0) {

					Arrow arrow = PreProcess.arrow(org, dst, config);
					setasSrcDst.append(arrow.getDraw());
					mapa.put(arrow);
				}
				listPonto.add(Util.setPonto(c, org, dst));
				c++;
			}
			setasSrcDst.append("}\n\n");

			// printList("Lista escalar do mapa "i, listPonto);

			v = matriz(config, listPonto);
			print(config, "Mapa deslocamento: Matriz escalar do mapa ", i, v);

			u = mdfU(config, i, listPonto.size(), v);
			t = config.getVizinhos().intValue() * 2 + 1;
			print("Mapa deslocamento: Matriz u de ", i, u, t);

			/*
			 * Desenha os circulos (mapa de deslocamento)
			 */

			s = mdfS(config, i, listPonto.size(), v);
			print("Mapa deslocamento: Matriz s de ", i, s, t);
			System.out.println("\n");

			circulosSrcDst.append(setUS(config, u, s, v, mapa, listCount));
		} else {
			setasSrcDst.append("function loadArrow() {\n");
			setasSrcDst.append("\t// Não tem mapa anterior, não há o que fazer aqui.\n");
			setasSrcDst.append("}\n\n");
			circulosSrcDst.append("function loadCircle() {\n");
			circulosSrcDst.append("\t// Não tem mapa anterior, não há o que fazer aqui.\n");
			circulosSrcDst.append("}\n\n");
		}

		StringBuilder conteudo = new StringBuilder();
		conteudo.append(map.toString());
		conteudo.append(quadrados.toString());
		conteudo.append(taxisDst.toString());
		conteudo.append(setasDst.toString());
		conteudo.append(circulosDst.toString());
		Util.buildFile("densidade", "map.js", i, "", conteudo.toString(), "");

		conteudo = new StringBuilder();
		conteudo.append(map.toString());
		conteudo.append(quadrados.toString());
		conteudo.append(taxisSrcDst.toString());
		conteudo.append(setasSrcDst.toString());
		conteudo.append(circulosSrcDst.toString());
		Util.buildFile("deslocamento", "map.js", i, "", conteudo.toString(), "");

		oldListCount = listCount;

		return mapa;
	}

	// TODO setUS
	private static String setUS(Config config, double[][] u, double[][] s, Point[][] v, Mapa mapa, List<Count> celulaList) {
		int o = config.getVizinhos() * 2 + 1;

		List<Point> listPoint = new ArrayList<Point>();

		for (int i = 0; i < o; i++) {
			for (int j = 0; j < o; j++) {
				v[i][j].setU(u[i][j]);
				v[i][j].setS(s[i][j]);
				listPoint.add(v[i][j]);
			}
		}

		// Alteração ponto 5
		Collections.sort(listPoint, new Comparator<Point>() {
			public int compare(Point p2, Point p1) {
				return p1.getU().compareTo(p2.getU());
			}
		});

		StringBuilder code = new StringBuilder();
		code.append("function loadCircle() {\n");

		
		LeitorMatriz leitor = new LeitorMatriz(u);
		
		for (int i = 0; i < o; i++) {
			for (int j = 0; j < o; j++) {

				Point point = v[i][j];
				Count celula = obterCelulaPor(point, celulaList); 

				double resultadoU = round(point.getU().doubleValue(), 5);

				if (leitor.ehMaiorQueVizinhos(i, j) && celula.possuiTaxi()) {
					Circle circle = JavaScript.drawCircle("UMax", "red", resultadoU, point.getLatitude(), point.getLongitude());
					code.append(circle.draw());
					mapa.put(circle);
				}

				if (leitor.ehMenorQueVizinhos(i, j) && celula.possuiTaxi()) {
					Circle circle = JavaScript.drawCircle("UMin", "blue", resultadoU, point.getLatitude(), point.getLongitude());
					code.append(circle.draw());
					mapa.put(circle);
				}
			}
		}

//		for (int i = 0; i < listPoint.size(); i++) {
//
//			double resultadoU = round(listPoint.get(i).getU().doubleValue(), 5);
//
//			if (i < config.getMarcas()) {
//				Circle circle = JavaScript.drawCircle("UMax", "red", resultadoU, listPoint.get(i).getLatitude(), listPoint.get(i).getLongitude());
//				code.append(circle.draw());
//				mapa.put(circle);
//			}
//			if (i >= (listPoint.size() - config.getMarcas())) {
//				Circle circle = JavaScript.drawCircle("UMin", "blue", resultadoU, listPoint.get(i).getLatitude(), listPoint.get(i).getLongitude());
//				code.append(circle.draw());
//				mapa.put(circle);
//			}
//			System.out.println(resultadoU);
//		}

		// Alteração ponto 9
		Collections.sort(listPoint, new Comparator<Point>() {
			public int compare(Point p2, Point p1) {
				return p1.getS().compareTo(p2.getS());
			}
		});

				
		leitor = new LeitorMatriz(s);
		
		for (int i = 0; i < o; i++) {
			for (int j = 0; j < o; j++) {

				Point point = v[i][j];
				
				Count celula = obterCelulaPor(point, celulaList); 
				double resultadoS = round(point.getS().doubleValue(), 5);

				if (leitor.ehMaiorQueVizinhos(i, j) && celula.possuiTaxi()) {
					Circle circle = JavaScript.drawCircle("SMax", "orange", resultadoS, point.getLatitude(), point.getLongitude());
					code.append(circle.draw());
					mapa.put(circle);
				}

				if (leitor.ehMenorQueVizinhos(i, j) && celula.possuiTaxi()) {
					Circle circle = JavaScript.drawCircle("SMin", "yellow", resultadoS, point.getLatitude(), point.getLongitude());
					code.append(circle.draw());
					mapa.put(circle);
				}
			}
		}
		
//		for (int i = 0; i < listPoint.size(); i++) {
//			
//			double resultadoS = round(listPoint.get(i).getS().doubleValue(), 5);
//			
//			if (i < config.getMarcas()) {
//				Circle circle = JavaScript.drawCircle("SMax", "orange", resultadoS, listPoint.get(i).getLatitude(), listPoint.get(i).getLongitude());
//				code.append(circle.getDraw());
//				mapa.put(circle);
//			}
//			if (i >= (listPoint.size() - config.getMarcas())) {
//				Circle circle = JavaScript.drawCircle("SMin", "yellow", resultadoS, listPoint.get(i).getLatitude(), listPoint.get(i).getLongitude());
//				code.append(circle.getDraw());
//
//				mapa.put(circle);
//			}
//			
//			System.out.println(resultadoS);
//		}

		code.append("}");

		return code.toString();
	}

	private static Count obterCelulaPor(Point point, List<Count> celulaList) {
		for (Count celula : celulaList) {
			if(celula.getLatitudeCentral().equals(point.getLatitudeReal()) && celula.getLongitudeCentral().equals(point.getLongitudeReal())){
				return celula;
			}
		}
		throw new NoSuchElementException("Não foi encontrado a celula: "+point);
	}

	private static Point getCoordenada(Point[][] v, int i, int j) {
		return v[i][j];
	}

	// TODO printList
	private static void printList(String title, int i, double[] k) {
		System.out.print(title);
		System.out.println(i);
		int c = 0;
		for (double ponto : k) {
			System.out.print(c);
			System.out.print("[");
			System.out.print(ponto);
			System.out.println("]");
			c++;
		}
	}

	private static void printList(String title, int i, List<Point> listPoint) {
		System.out.print(title);
		System.out.println(i);
		int c = 0;
		for (Point ponto : listPoint) {
			System.out.print(c);
			System.out.print(" ");
			System.out.print(ponto.getX());
			System.out.print(" ");
			System.out.println(ponto.getY());
			c++;
		}
	}

	// TODO mdfS
	private static double[][] mdfS(Config config, Integer map, Integer size, Point[][] v0) {
		int o = config.getVizinhos() * 2 + 1;

		Point[][] v = new Point[o][o];
		for (int i = 0; i < o; i++) {
			for (int j = 0; j < o; j++) {
				Point a = v0[i][j];
				Point n = new Point(a.getLatitude(), a.getLongitude());
				n.setI(a.getI());
				n.setX(a.getY());
				// n.setY(a.getX().multiply(new BigDecimal(-1)));
				n.setY(a.getX());
				v[i][j] = n;
			}
		}
		int side = config.getVizinhos().intValue() * 2 + 1;
		BigDecimal h = new BigDecimal(config.getTamanhoLateral()).divide(config.FRACAO);
		double k[] = new double[size];
		double u[] = new double[size];
		double m[][] = new double[size][size];
		int c = 0;
		for (int j = 0; j < side; j++) {
			for (int i = 0; i < side; i++) {
				BigDecimal r = BigDecimal.ZERO;
				BigDecimal l = BigDecimal.ZERO;
				BigDecimal t = BigDecimal.ZERO;
				BigDecimal b = BigDecimal.ZERO;
				// Verifica se existe vizinho no lado direito e pega o X do
				// vetor
				if ((i + 1) < side) {
					r = v[i + 1][j].getX();
				}

				// Verifica se existe vizinho no lado esquerdo e pega o X vetor
				if ((i - 1) >= 0) {
					l = v[i - 1][j].getX();
				}

				// Verifica se existe vizinho em cima e pega o Y do vetor
				if ((j + 1) < side) {

					t = v[i][j + 1].getY();
				}
				// Verifica se existe vizinho embaixo e pega o Y do vetor
				if ((j - 1) >= 0) {
					b = v[i][j - 1].getY();
				}

				BigDecimal part1 = r.subtract(l).divide(h.multiply(new BigDecimal(2)));
				BigDecimal part2 = t.subtract(b).divide(h.multiply(new BigDecimal(2)));
				//part2 = part2.multiply(new BigDecimal(-1)); alteração do sinal
				part1 = part1.multiply(new BigDecimal(-1));
				k[c] = part1.add(part2).doubleValue();
				c++;
			}
		}
		printList("MDF de s, matriz com os totais de ", map, k);
		for (int j = 0; j < size; j++) {
			for (int i = 0; i < size; i++) {
				m[i][j] = 0;
			}
		}
		for (int d = 0; d < size; d++) {
			m[d][d] = -4;
		}
		c = 0;
		// TODO - Ponto 7 da documentação
		for (int j = 0; j < side; j++) {
			for (int i = 0; i < side; i++) {
				Point r = new Point();
				if (((i + 1) < side)) { // Tem vizinho do lado direito
					r = v[i + 1][j];
					m[r.getI()][c] = 1;
				}

				Point l = new Point();
				if (((i - 1) >= 0)) // Tem vizinho do lado esquerdo
				{
					l = v[i - 1][j];
					m[l.getI()][c] = 1;
				}

				Point t = new Point();
				if ((j + 1) < side) { // Tem vizinho em cima
					t = v[i][j + 1];
					m[t.getI()][c] = 1;
				}

				Point b = new Point();
				if ((j - 1) >= 0) { // Tem vizinho embaixo
					b = v[i][j - 1];
					m[b.getI()][c] = 1;
				}

				if ((((j + 1) < side) && ((j - 1) < 0)) && (((i + 1) < side) && ((i - 1) < 0))) {
					/*
					 * Tem vizinho em cima, mas não tem embaixo e tem na direita
					 * mas não na esquerda
					 */
					m[t.getI()][c] = 2;
					m[r.getI()][c] = 2;
				}

				if ((((j + 1) < side) && ((j - 1) < 0)) && (((i + 1) >= side) && ((i - 1) >= 0))) {
					/*
					 * Tem vizinho em cima, mas não tem embaixo e não tem na
					 * direita e tem na esquerda
					 */
					m[t.getI()][c] = 2;
					m[l.getI()][c] = 2;

				}

				if ((((j - 1) >= 0) && ((j + 1) >= side)) && (((i + 1) < side) && ((i - 1) < 0))) {
					/*
					 * Tem vizinho embaixo, mas não em cima e tem na direita mas
					 * não na esquerda
					 */
					m[b.getI()][c] = 2;
					m[r.getI()][c] = 2;

				}

				if ((((j - 1) >= 0) && ((j + 1) >= side)) && (((i - 1) >= 0) && ((i + 1) >= side))) {
					/*
					 * Tem vizinho embaixo, mas não em cima e tem esquerdo mas
					 * não direito
					 */
					m[b.getI()][c] = 2;
					m[l.getI()][c] = 2;

				}
				c++;
			}
		}
		int t = config.getVizinhos().intValue() * 2 + 1;
		t = t * t;
		print("MDF de s, matriz m de ", map, m, t);
		RealMatrix coefficients = new Array2DRowRealMatrix(m, false);
		
		RealMatrix transpose_m = coefficients.transpose();
		//System.out.println("Matriz transposta" + transpose_m);
		//DecompositionSolver solver = new LUDecomposition(coefficients).getSolver();
		DecompositionSolver solver = new LUDecomposition(transpose_m).getSolver();
		RealVector constants = new ArrayRealVector(k, false);
		RealVector solution = solver.solve(constants);

		for (int d = 0; d < size; d++) {
			u[d] = solution.getEntry(d);
		}
		return matriz(config, u);
	}

	// TODO mdfU
	private static double[][] mdfU(Config config, Integer map, Integer size, Point[][] v) {
		int side = config.getVizinhos().intValue() * 2 + 1;
		BigDecimal h = new BigDecimal(config.getTamanhoLateral()).divide(config.FRACAO);
		double k[] = new double[size];
		double u[] = new double[size];
		double m[][] = new double[size][size];
		int c = 0;
		for (int j = 0; j < side; j++) {
			for (int i = 0; i < side; i++) {
				BigDecimal r = BigDecimal.ZERO;
				BigDecimal l = BigDecimal.ZERO;
				BigDecimal t = BigDecimal.ZERO;
				BigDecimal b = BigDecimal.ZERO;
				// Verifica se existe vizinho no lado direito e pega o X do
				// vetor
				if ((i + 1) < side) {
					r = v[i + 1][j].getX();
				}

				// Verifica se existe vizinho no lado esquerdo e pega o X vetor
				if ((i - 1) >= 0) {
					l = v[i - 1][j].getX();
				}

				// Verifica se existe vizinho em cima e pega o Y do vetor
				if ((j + 1) < side) {

					t = v[i][j + 1].getY();
				}
				// Verifica se existe vizinho embaixo e pega o Y do vetor
				if ((j - 1) >= 0) {
					b = v[i][j - 1].getY();
				}

				BigDecimal part1 = r.subtract(l).divide(h.multiply(new BigDecimal(2)));
				BigDecimal part2 = t.subtract(b).divide(h.multiply(new BigDecimal(2)));
				k[c] = part1.add(part2).doubleValue();
				c++;
			}
		}
		printList("MDF de u, matriz com os totais de ", map, k);
		for (int j = 0; j < size; j++) {
			for (int i = 0; i < size; i++) {
				m[i][j] = 0;
			}
		}
		for (int d = 0; d < size; d++) {
			m[d][d] = -4;
		}
		c = 0;
		// TODO - Ponto 3 da documentação
		for (int j = 0; j < side; j++) {
			for (int i = 0; i < side; i++) {
				Point r = new Point();
				if (((i + 1) < side) && ((i - 1) < 0)) { // Tem vizinho do lado
															// direito, mas não
															// tem no lado
															// esquerdo
					r = v[i + 1][j];
					m[r.getI()][c] = 2;
				} else if (((i + 1) < side) && ((i - 1) >= 0)) { // Tem vizinho
																	// do lado
																	// direito e
																	// do lado
																	// esquerdo
					r = v[i + 1][j];
					m[r.getI()][c] = 1;
				}

				Point t = new Point();
				if (((j + 1) < side) && ((j - 1) < 0)) { // Tem vizinho em cima,
															// mas não tem
															// embaixo
					t = v[i][j + 1];
					m[t.getI()][c] = 2;
				} else if (((j + 1) < side) && ((j - 1) >= 0)) { // Tem vizinho
																	// em cima e
																	// embaixo
					t = v[i][j + 1];
					m[t.getI()][c] = 1;
				}

				Point l = new Point();
				if (((i - 1) >= 0) && ((i + 1) >= side)) { // Tem vizinho do
															// lado esquerdo,
															// mas não tem do
															// lado direito
					l = v[i - 1][j];
					m[l.getI()][c] = 2;
				} else if (((i - 1) >= 0) && ((i + 1) < side)) { // Tem vizinho
																	// do lado
																	// direito e
																	// do lado
																	// esquerdo
					l = v[i - 1][j];
					m[l.getI()][c] = 1;
				}

				Point b = new Point();
				if (((j - 1) >= 0) && ((j + 1) >= side)) { // Tem vizinho
															// embaixo, mas não
															// tem acima
					b = v[i][j - 1];
					m[b.getI()][c] = 2;
				} else if (((j - 1) >= 0) && ((j + 1) < side)) { // Tem vizinho
																	// embaixo e
																	// em cima
					b = v[i][j - 1];
					m[b.getI()][c] = 1;
				}
				c++;
			}
		}
		int t = config.getVizinhos().intValue() * 2 + 1;
		t = t * t;
		print("MDF de u, matriz m de ", map, m, t);
		RealMatrix coefficients = new Array2DRowRealMatrix(m, false);
		
		//Cálculo da transposta
		RealMatrix transpose_m = coefficients.transpose();
		//System.out.println("Matriz m" + coefficients );
		//System.out.println("Matriz transposta m" + transpose_m);
		//RealMatrix multiply_m = coefficients.multiply(transpose_m);
		//DecompositionSolver solver = new LUDecomposition(multiply_m).getSolver();
		
		//DecompositionSolver solver = new SingularValueDecomposition(coefficients).getSolver();
		DecompositionSolver solver = new SingularValueDecomposition(transpose_m).getSolver();
		
	//	RealMatrix constants = new Array2DRowRealMatrix(k);
		RealVector constants = new ArrayRealVector(k, false);
		//RealMatrix solution = solver.solve(constants);
		RealVector solution = solver.solve(constants);

	
		for (int d = 0; d < size; d++) {
			u[d] = solution.getEntry(d);
		}
		return matriz(config, u);
	}

	// TODO print
	private static void print(Config config, String title, int n, Point[][] v) {
		System.out.print(title);
		System.out.println(n);
		int t = config.getVizinhos().intValue() * 2 + 1;
		for (int j = (t - 1); j >= 0; j--) {
			System.out.print("[");
			for (int i = 0; i < t; i++) {
				System.out.print("{");
				System.out.print(v[i][j].getX());
				System.out.print(",");
				System.out.print(v[i][j].getY());
				if (i == (t - 1)) {
					System.out.print("}");
				} else {
					System.out.print("}, ");
				}
			}
			System.out.println("]");
		}

	}

	private static void print(String title, int n, double[][] v, int t) {
		System.out.print(title);
		System.out.println(n);
		for (int j = (t - 1); j >= 0; j--) {
			System.out.print("[");
			for (int i = 0; i < t; i++) {
				System.out.print(round(v[i][j], 10));
				if (i != (t - 1)) {
					System.out.print(", ");
				}
			}
			System.out.println("]");
		}

	}

	// TODO round
	public static double round(double value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();

		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.round(new MathContext(places, RoundingMode.HALF_UP)).doubleValue();
	}

	// TODO matriz
	private static Point[][] matriz(Config config, List<Point> listPonto) {
		int i = config.getVizinhos() * 2 + 1;
		int j = i;
		Point[][] v = new Point[i][j];
		int x = 0;
		int y = 0;
		for (Point ponto : listPonto) {

			v[x][y] = ponto;

			x++;
			if (x == i) {
				x = 0;
				y++;
			}
		}
		return v;
	}

	private static double[][] matriz(Config config, double[] u) {
		int i = config.getVizinhos() * 2 + 1;
		int j = i;
		double[][] v = new double[i][j];
		int x = 0;
		int y = 0;
		for (double ponto : u) {
			v[x][y] = ponto;
			x++;
			if (x == i) {
				x = 0;
				y++;
			}
		}
		return v;
	}
}