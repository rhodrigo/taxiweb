package br.com.taxi.matriz;

import br.com.taxi.matriz.MatrizVizinhos.Vizinho;

public class LeitorMatriz {

	private double[][] matriz;

	public LeitorMatriz(double[][] matriz) {
		this.matriz = matriz;
	}

	public Double getVizinho(int x, int y, Vizinho operations) {
		Posicao posicao = operations.apply(x, y);
		return getValor(posicao);
	}

	public boolean ehMaiorQueVizinhos(int x, int y) {

		Posicao posicao = new Posicao(x, y);
		Posicao maiorVizinho = obterMaiorVizinho(posicao);

		if (getValor(posicao) > getValor(maiorVizinho)) {
//			System.out.println(posicao + " com valor " + getValor(posicao) + " é o maior dos vizinhos");
			return true;
		}

//		System.out.println(posicao + " com valor " + getValor(posicao) + " não é o maior dos vizinhos, o maior é: " + maiorVizinho + " com valor: " + getValor(maiorVizinho));

		return false;

	}
	
	public boolean ehMenorQueVizinhos(int x, int y) {

		Posicao posicao = new Posicao(x, y);
		Posicao menorVizinho = obterMenorVizinho(posicao);

		if (getValor(posicao) < getValor(menorVizinho)) {
//			System.out.println(posicao + " com valor " + getValor(posicao) + " é o menor dos vizinhos");
			return true;
		}

//		System.out.println(posicao + " com valor " + getValor(posicao) + " não é o menor dos vizinhos, o menor é: " + menorVizinho + " com valor: " + getValor(menorVizinho));

		return false;

	}

	public Posicao obterMaiorVizinho(Posicao posicao) {

		Posicao maiorVizinho = null;

		for (Vizinho vizinho : Vizinho.values()) {

			Posicao posicaoAtual = vizinho.apply(posicao.getX(), posicao.getY());

			if (ehUmVizinhoValido(posicaoAtual)) {

				if (maiorVizinho == null) {
					maiorVizinho = posicaoAtual;
				}

				if (getValor(posicaoAtual) > getValor(maiorVizinho)) {
					maiorVizinho = posicaoAtual;
				}
			}
		}

		return maiorVizinho;
	}
	
	public Posicao obterMenorVizinho(Posicao posicao) {

		Posicao menorVizinho = null;

		for (Vizinho vizinho : Vizinho.values()) {

			Posicao posicaoAtual = vizinho.apply(posicao.getX(), posicao.getY());

			if (ehUmVizinhoValido(posicaoAtual)) {

				if (menorVizinho == null) {
					menorVizinho = posicaoAtual;
				}

				if (getValor(posicaoAtual) < getValor(menorVizinho)) {
					menorVizinho = posicaoAtual;
				}
			}
		}

		return menorVizinho;

	}

	public Double getValor(Posicao posicao) {
		if (ehUmVizinhoValido(posicao)) {
			return matriz[posicao.getX()][posicao.getY()];
		}
		return 0.0;
	}

	/*
	 * Apenas para monitorar se posição está fora da matriz
	 */
	@SuppressWarnings("unused")
	private boolean ehUmVizinhoValido(Posicao posicao) {
		try {
			Double valor = matriz[posicao.getX()][posicao.getY()];
			return true;
		} catch (ArrayIndexOutOfBoundsException e) {
			return false;
		}
	}
}
