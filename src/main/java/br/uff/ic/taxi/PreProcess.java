package br.uff.ic.taxi;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class PreProcess {
	
	public static br.com.taxi.model.Arrow arrow(Count org, Count dst, Config config) throws IOException {
		
		StringBuilder seta = new StringBuilder();
		br.com.taxi.model.Arrow arrow = new br.com.taxi.model.Arrow();
		
		if (!org.getCelula().equals(dst.getCelula())) {
			BigDecimal tL = new BigDecimal(config.getTamanhoLateral());
			BigDecimal lado = tL.divide(config.FRACAO);
			BigDecimal v = new BigDecimal(config.getVizinhos());

			BigDecimal lat = config.getLatitude().subtract(v.multiply(lado));
			BigDecimal lng = config.getLongitude().subtract(v.multiply(lado));
			Integer linha = (config.getVizinhos()*2)+1;
			Integer conta=1;
			for (int i=1;i<org.getCelula();i++) {
				lng = lng.add(lado);
				conta++;
				if (conta>linha) {
					lat = lat.add(lado);
					lng = config.getLongitude().subtract(v.multiply(lado));
					conta=1;
				}
			}
			
			// Define como centro o lat lng do ponto de origem
			BigDecimal centroLat = lat;
			BigDecimal centroLng = lng;

			// Posiciona a seta na parte superior do quadrado
			lat = lat.subtract(lado.divide(new BigDecimal(4*5)).multiply(new BigDecimal(3)));
			lng = lng.subtract(lado.divide(new BigDecimal(4*5)).multiply(new BigDecimal(3)));			
			lat = lat.add(lado.divide(new BigDecimal(4)));
			
			BigDecimal grau = null;
			if (dst.getCelula().equals(org.getCelula()+linha)) { 			// Acima
				grau = new BigDecimal(0);
			} else if (dst.getCelula().equals(org.getCelula()+linha+1)) { 	// Acima e a direita
				grau = new BigDecimal(45);
			} else if (dst.getCelula().equals(org.getCelula()+1)) { 		// A direita
				grau = new BigDecimal(90);
			} else if (dst.getCelula().equals(org.getCelula()-linha+1)) { 	// Abaixo e a direita
				grau = new BigDecimal(135);
			} else if (dst.getCelula().equals(org.getCelula()-linha)) { 	// Abaixo 
				grau = new BigDecimal(180);
			} else if (dst.getCelula().equals(org.getCelula()-linha-1)) { 	// Abaixo e a esquerda 
				grau = new BigDecimal(225);
			} else if (dst.getCelula().equals(org.getCelula()-1)) { 		// A esquerda 
				grau = new BigDecimal(270);
			} else if (dst.getCelula().equals(org.getCelula()+linha-1)) {	// Acima e a esquerda 
				grau = new BigDecimal(315);
			}			

			List<Point> listPonto = Arrow.getPoints(lado, lat, lng);
			listPonto = Arrow.rotate(grau, listPonto, centroLat, centroLng);
			
			arrow = JavaScript.drawArrow(dst, listPonto);
			seta.append(arrow.getDraw());
		}
		return arrow;
	}

	public static String circle(Count count) throws IOException {
		Config config = new Config();
		BigDecimal tL = new BigDecimal(config.getTamanhoLateral());
		BigDecimal lado = tL.divide(config.FRACAO);
		BigDecimal v = new BigDecimal(config.getVizinhos());

		BigDecimal lat = config.getLatitude().subtract(v.multiply(lado));
		BigDecimal lng = config.getLongitude().subtract(v.multiply(lado));
		Integer linha = (config.getVizinhos()*2)+1;
		Integer conta=1;
		for (int i=1;i<count.getCelula();i++) {
			lng = lng.add(lado);
			conta++;
			if (conta>linha) {
				lat = lat.add(lado);
				lng = config.getLongitude().subtract(v.multiply(lado));
				conta=1;
			}
		}
		// return JavaScript.drawCircle(count, lat, lng);
		return "";
	}	

}
