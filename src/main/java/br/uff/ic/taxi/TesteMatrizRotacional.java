package br.uff.ic.taxi;

import java.io.IOException;
import java.math.BigDecimal;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.DecompositionSolver;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.math3.linear.SingularValueDecomposition;

public class TesteMatrizRotacional {

	public static void main(String[] args) throws IOException {
		new TesteMatrizRotacional().start();
	}

	private void start() throws IOException {

		Config config = new Config();

		Point[][] v = {

				{ new Point(0, 0.010, 0.010), new Point(1, 0.010, 0.000), new Point(2, 0.000, 0.000) }, { new Point(3, 0.010, 0.000), new Point(4, 0.010, -0.010), new Point(5, 0.000, -0.010) },
				{ new Point(6, 0.010, -0.010), new Point(7, 0.010, -0.010), new Point(8, 0.000, -0.010) }

		};

		mdfS(config, 0, 9, v);

	}

	private static double[][] mdfS(Config config, Integer map, Integer size, Point[][] v) {
		int side = config.getVizinhos().intValue() * 2 + 1;
		BigDecimal h = new BigDecimal(config.getTamanhoLateral()).divide(config.FRACAO);
		double k[] = new double[9];
		double u[] = new double[9];
		double m[][] = new double[9][9];
		int c = 0;
		for (int j = 0; j < 3; j++) {
			for (int i = 0; i < 3; i++) {

				BigDecimal r = BigDecimal.ZERO;
				BigDecimal l = BigDecimal.ZERO;
				BigDecimal t = BigDecimal.ZERO;
				BigDecimal b = BigDecimal.ZERO;
				// Verifica se existe vizinho no lado direito e pega o Y do
				// vetor
				if ((i + 1) < 3) {

					r = v[j][i + 1].getY();
				}

				// Verifica se existe vizinho no lado esquerdo e pega o Y vetor
				if ((i - 1) >= 0) {
					l = v[j][i - 1].getY();
				}

				// Verifica se existe vizinho em cima e pega o X do vetor
				if ((j + 1) < 3) {

					t = v[j + 1][i].getX();
				}
				// Verifica se existe vizinho embaixo e pega o X do vetor
				if ((j - 1) >= 0) {
					b = v[j - 1][i].getX();
				}
				System.out.println("r Y:" + r);
				System.out.println("l Y:" + l);
				System.out.println("b X:" + b);
				System.out.println("t X:" + t);
				System.out.println("j :" + j);
				System.out.println("i :" + i);
				System.out.println("-----Fim do " + c + "---------");
				BigDecimal part1 = r.subtract(l).divide(h.multiply(new BigDecimal(2)));
				BigDecimal part2 = t.subtract(b).divide(h.multiply(new BigDecimal(2)));

				part2 = part2.multiply(new BigDecimal(-1));
				k[c] = part1.add(part2).doubleValue();
				c++;
			}
		}
		printList("MDF de s, matriz com os totais de ", map, k);
		for (int j = 0; j < 3; j++) {
			for (int i = 0; i < 3; i++) {
				m[i][j] = 0;
			}
		}
		for (int d = 0; d < 3; d++) {
			m[d][d] = -4;
		}
		c = 0;
		// TODO - Ponto 7 da documentação
		for (int j = 0; j < 3; j++) {
			for (int i = 0; i < 3; i++) {
				Point r = new Point();
				if ((i + 1) < 3) {
					r = v[i + 1][j];
				}
				Point t = new Point();
				if ((j + 1) < 3) {
					t = v[i][j + 1];
				}
				Point l = new Point();
				if ((i - 1) > -1) {
					l = v[i - 1][j];
				}
				Point b = new Point();
				if ((j - 1) > -1) {
					b = v[i][j - 1];
				}
				if (r.getI() != -1) {
					m[r.getI()][c] = r.getV();
				}
				if (t.getI() != -1) {
					m[t.getI()][c] = t.getV();
				}
				if (l.getI() != -1) {
					m[l.getI()][c] = l.getV();
				}
				if (b.getI() != -1) {
					m[b.getI()][c] = b.getV();
				}
				c++;
			}
		}
		int t = config.getVizinhos().intValue() * 2 + 1;
		t = t * t;
		// print("MDF de s, matriz m de ", map, m, t);
		RealMatrix coefficients = new Array2DRowRealMatrix(m, false);
		DecompositionSolver solver = new SingularValueDecomposition(coefficients).getSolver();
		RealVector constants = new ArrayRealVector(k, false);
		RealVector solution = solver.solve(constants);

		for (int d = 0; d < 3; d++) {
			u[d] = solution.getEntry(d);
		}
		return matriz(config, u);
	}

	private static void print(String title, int n, double[][] v, int t) {
		System.out.print(title);
		System.out.println(n);
		for (int j = (t - 1); j >= 0; j--) {
			System.out.print("[");
			for (int i = 0; i < t; i++) {
				System.out.print(App.round(v[i][j], 3));
				if (i != (t - 1)) {
					System.out.print(", ");
				}
			}
			System.out.println("]");
		}

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

}