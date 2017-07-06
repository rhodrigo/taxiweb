package br.com.taxi.matriz;

import org.junit.Assert;
import org.junit.Test;

import br.com.taxi.matriz.MatrizVizinhos.Vizinho;

public class LeitorMatrizTest {

	private double[][] matriz = { 
			{ 1.0, 2.0, 5.0 }, 
			{ 3.0, 7.0, 8.0 }, 
			{ -2.0, 9.0, 0.0 } 
	};

	private LeitorMatriz leitor = new LeitorMatriz(matriz);

	@Test
	public void deveBuscarValorDoTopo() {
		Double resultado = leitor.getVizinho(1, 1, Vizinho.TOP);
		Assert.assertTrue(resultado.equals(2.0));
	}

	@Test
	public void deveBuscarValorDaEsquerda() {
		Double resultado = leitor.getVizinho(1, 1, Vizinho.LEFT);
		Assert.assertTrue(resultado.equals(3.0));
	}

	@Test
	public void deveBuscarValorDaEsquerdaTopo() {
		Double resultado = leitor.getVizinho(1, 1, Vizinho.TOPLEFT);
		Assert.assertTrue(resultado.equals(1.0));
	}

	@Test
	public void deveBuscarValorAbaixo() {
		Double resultado = leitor.getVizinho(1, 1, Vizinho.BOTTOM);
		Assert.assertTrue(resultado.equals(9.0));
	}

	@Test
	public void deveBuscarValorDaEsquerdaAbaixo() {
		Double resultado = leitor.getVizinho(1, 1, Vizinho.BOTTOMLEFT);
		Assert.assertTrue(resultado.equals(-2.0));
	}

	@Test
	public void deveBuscarValorDaDireita() {
		Double resultado = leitor.getVizinho(1, 1, Vizinho.RIGHT);
		Assert.assertTrue(resultado.equals(8.0));
	}

	@Test
	public void deveBuscarValorDaDireitaAbaixo() {
		Double resultado = leitor.getVizinho(1, 1, Vizinho.RIGHTBOTTOM);
		Assert.assertTrue(resultado.equals(0.0));
	}

	@Test
	public void deveBuscarValorDaDireitaAcima() {
		Double resultado = leitor.getVizinho(1, 1, Vizinho.TOPRIGTH);
		Assert.assertTrue(resultado.equals(5.0));
	}

	@Test
	public void deveBuscarValorZeradoQuandoBorda() {
		Double resultado = leitor.getVizinho(0, 0, Vizinho.LEFT);
		Assert.assertTrue(resultado.equals(0.0));
	}

	@Test
	public void deveBuscarValorZeradoQuandoBordaInferior() {
		Double resultado = leitor.getVizinho(2, 2, Vizinho.BOTTOM);
		Assert.assertTrue(resultado.equals(0.0));
	}

	@Test
	public void ehMaiorQueVizinhos() {
		Assert.assertTrue(leitor.ehMaiorQueVizinhos(2, 1));
	}

	@Test
	public void ehMenorQueVizinhos() {
		Assert.assertTrue(leitor.ehMenorQueVizinhos(2, 0));
	}
	
	@Test
	public void testaBuscaMaiorVizinho() {
		Posicao posicaoMaiorVizinho = leitor.obterMaiorVizinho(new Posicao(0, 0));
		Assert.assertTrue(posicaoMaiorVizinho.equals(new Posicao(1, 1)));
	}

	@Test
	public void testaBuscaMenorVizinho() {
		Posicao posicao = leitor.obterMenorVizinho(new Posicao(1, 1));
		Assert.assertTrue(posicao.equals(new Posicao(2,0)));
	}
}
