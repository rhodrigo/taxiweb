package br.uff.ic.taxi;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.DecompositionSolver;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.math3.linear.SingularValueDecomposition;

public class TesteMatriz {

	public static void main(String[] args) {
		new TesteMatriz().start();
	}

	private void start() {

		double m[][] = new double[9][9];

		add(m, 8, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 2.0d, 0.0d, 2.0d, -4.0d);
		add(m, 7, 0.0d, 0.0d, 0.0d, 0.0d, 2.0d, 0.0d, 1.0d, -4.0d, 1.0d);
		add(m, 6, 0.0d, 0.0d, 0.0d, 2.0d, 0.0d, 0.0d, -4.0d, 2.0d, 0.0d);
		add(m, 5, 0.0d, 0.0d, 1.0d, 0.0d, 2.0d, -4.0d, 0.0d, 0.0d, 1.0d);
		add(m, 4, 0.0d, 1.0d, 0.0d, 1.0d, -4.0d, 1.0d, 0.0d, 1.0d, 0.0d);
		add(m, 3, 1.0d, 0.0d, 0.0d, -4.0d, 2.0d, 0.0d, 1.0d, 0.0d, 0.0d);
		add(m, 2, 0.0d, 2.0d, -4.0d, 0.0d, 0.0d, 2.0d, 0.0d, 0.0d, 0.0d);
		add(m, 1, 1.0d, -4.0d, 1.0d, 0.0d, 2.0d, 0.0d, 0.0d, 0.0d, 0.0d);
		add(m, 0, -4.0d, 2.0d, 0.0d, 2.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d);

		double[] k = { 0.0d, -1.0d, 0.0d, -1.0d, -2.0d, -1.0d, 0.0d, -1.0d, 0.0d };

		RealMatrix coefficients = new Array2DRowRealMatrix(m, false);
		DecompositionSolver solver = new SingularValueDecomposition(coefficients).getSolver();
		RealVector constants = new ArrayRealVector(k, false);

		System.out.println(solver.solve(constants));

	}

	private void add(double[][] m, int range, Double... values) {

		int contador = 0;

		for (Double valor : values) {
			m[range][contador] = valor;
			contador++;
		}

	}

}
