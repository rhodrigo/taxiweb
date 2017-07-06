package br.com.taxi.model;

import java.math.BigDecimal;
import java.util.Date;

public class Filtro {

	private String ddd;

	private Date dataInicio;

	private Date dataFim;

	private Integer vizinhos;
	
	private Integer quantidadeMapas;

	private Long tamanho;

	private BigDecimal latitude;

	private BigDecimal longitude;

	private Integer zoom;

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public Integer getVizinhos() {
		return vizinhos;
	}

	public void setVizinhos(Integer vizinhos) {
		this.vizinhos = vizinhos;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public Integer getZoom() {
		return zoom;
	}

	public void setZoom(Integer zoom) {
		this.zoom = zoom;
	}

	public Long getTamanho() {
		return tamanho;
	}

	public void setTamanho(Long tamanho) {
		this.tamanho = tamanho;
	}

	public Integer getQuantidadeMapas() {
		return quantidadeMapas;
	}

	public void setQuantidadeMapas(Integer quantidadeMapas) {
		this.quantidadeMapas = quantidadeMapas;
	}

}
