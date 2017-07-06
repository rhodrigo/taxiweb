package br.uff.ic.taxi;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ResourceBundle;

import br.com.taxi.model.Filtro;

public class Config {

	ResourceBundle bundle = ResourceBundle.getBundle("config");
	
	private String ddd = "21";
	private Timestamp dataHoraInicio = Timestamp.valueOf("2016-06-22 12:00:00");
	private Timestamp dataHoraFim = Timestamp.valueOf("2016-06-22 12:03:00");
	private Long tamanhoLateral = 100000000000l;
	private Integer vizinhos = 100;
	private Integer mapas = 1;
	private BigDecimal latitude = new BigDecimal(-22.90);
	private BigDecimal longitude = new BigDecimal(-43.25);
	private Integer width = 1200;
	private Integer height = 800;
	private Integer zoomPadrao;
	private BigDecimal latitudeMin;
	private BigDecimal latitudeMax;
	private BigDecimal longitudeMin;
	private BigDecimal longitudeMax;
	private Long raio;
	private Integer marcas = 1;
	public BigDecimal FRACAO = new BigDecimal(10000000000000l);

	public Config() throws IOException {
		load();
	}

	public Config(Filtro filtro) {
		setDdd(filtro.getDdd());
		setDataHoraInicio(new Timestamp(filtro.getDataInicio().getTime()));
		setDataHoraFim(new Timestamp(filtro.getDataFim().getTime()));
		setLatitude(filtro.getLatitude());
		setLongitude(filtro.getLongitude());
		setTamanhoLateral(filtro.getTamanho() * 100000000l);
		setVizinhos(filtro.getVizinhos());
		setMapas(filtro.getQuantidadeMapas());
		setWidth(500);
		setHeight(450);
		setMarcas(Integer.parseInt(bundle.getString("marcas")));
		setZoomPadrao(filtro.getZoom());
	}

	public BigDecimal getLatitudeMin() {
		return latitudeMin;
	}

	public BigDecimal getLatitudeMax() {
		return latitudeMax;
	}

	public BigDecimal getLongitudeMin() {
		return longitudeMin;
	}

	public BigDecimal getLongitudeMax() {
		return longitudeMax;
	}

	public Long getRaio() {
		return raio;
	}

	public Timestamp getDataHoraInicio() {
		return dataHoraInicio;
	}

	public void setDataHoraInicio(Timestamp dataHoraInicio) {
		this.dataHoraInicio = dataHoraInicio;
	}

	public Timestamp getDataHoraFim() {
		return dataHoraFim;
	}

	public void setDataHoraFim(Timestamp dataHoraFim) {
		this.dataHoraFim = dataHoraFim;
	}

	public Long getTamanhoLateral() {
		return tamanhoLateral;
	}

	public void setTamanhoLateral(Long tamanhoLateral) {
		this.tamanhoLateral = tamanhoLateral;
		Long a = (long) Math.sqrt(Math.pow(tamanhoLateral, 2) + Math.pow(tamanhoLateral, 2));
		raio = a + (a * getVizinhos() * 2);
		BigDecimal tL = new BigDecimal(tamanhoLateral);
		BigDecimal lado = tL.divide(FRACAO);
		BigDecimal v = new BigDecimal(getVizinhos());
		BigDecimal dois = new BigDecimal(2l);
		latitudeMin = getLatitude().subtract(lado.divide(dois)).subtract(lado.multiply(v));
		latitudeMax = getLatitude().add(lado.divide(dois)).add(lado.multiply(v));
		longitudeMin = getLongitude().subtract(lado.divide(dois)).subtract(lado.multiply(v));
		longitudeMax = getLongitude().add(lado.divide(dois)).add(lado.multiply(v));
	}

	public Integer getVizinhos() {
		//vizinhos = 1;
		return vizinhos;
	}

	public void setVizinhos(Integer vizinhos) {
		this.vizinhos = vizinhos;
		Long a = (long) Math.sqrt(Math.pow(getTamanhoLateral(), 2) + Math.pow(getTamanhoLateral(), 2));
		raio = a + (a * vizinhos * 2);
		BigDecimal tL = new BigDecimal(tamanhoLateral);
		BigDecimal lado = tL.divide(FRACAO);
		BigDecimal v = new BigDecimal(getVizinhos());
		BigDecimal dois = new BigDecimal(2l);
		latitudeMin = getLatitude().subtract(lado.divide(dois)).subtract(lado.multiply(v));
		latitudeMax = getLatitude().add(lado.divide(dois)).add(lado.multiply(v));
		longitudeMin = getLongitude().subtract(lado.divide(dois)).subtract(lado.multiply(v));
		longitudeMax = getLongitude().add(lado.divide(dois)).add(lado.multiply(v));
	}

	public Integer getMapas() {
		return mapas;
	}

	public void setMapas(Integer mapas) {
		this.mapas = mapas;
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

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getMarcas() {
		return marcas;
	}

	public void setMarcas(Integer marcas) {
		this.marcas = marcas;
	}

	private void load() throws IOException {
		setDdd(bundle.getString("ddd"));
		setDataHoraInicio(Timestamp.valueOf(bundle.getString("data.hora.inicio")));
		setDataHoraFim(Timestamp.valueOf(bundle.getString("data.hora.fim")));
		setLatitude(new BigDecimal(bundle.getString("latitude")));
		setLongitude(new BigDecimal(bundle.getString("longitude")));
		setTamanhoLateral(Long.parseLong(bundle.getString("tamanho.lateral")));
		setVizinhos(Integer.parseInt(bundle.getString("vizinhos")));
		setMapas(Integer.parseInt(bundle.getString("mapas")));
		setWidth(Integer.parseInt(bundle.getString("width")));
		setHeight(Integer.parseInt(bundle.getString("height")));
		setMarcas(Integer.parseInt(bundle.getString("marcas")));
		setZoomPadrao(Integer.parseInt(bundle.getString("zoom")));
	}

	public Integer getZoomPadrao() {
		return zoomPadrao;
	}

	public void setZoomPadrao(Integer zoomPadrao) {
		this.zoomPadrao = zoomPadrao;
	}
}
