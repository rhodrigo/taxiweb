package br.com.taxi.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.taxi.util.DataUtils;

public class Mapa {

	private String dataInicio;

	private String dataFim;

	private BigDecimal lat;

	private BigDecimal lon;

	private int zoom;

	private int maxZoom;

	private List<Square> squares = new ArrayList<>();

	private List<Taxi> taxis = new ArrayList<>();

	private List<Circle> circles = new ArrayList<>();

	private List<Arrow> arrows = new ArrayList<>();

	public BigDecimal getLat() {
		return lat;
	}

	public void setLat(BigDecimal lat) {
		this.lat = lat;
	}

	public BigDecimal getLon() {
		return lon;
	}

	public void setLon(BigDecimal lon) {
		this.lon = lon;
	}

	public int getZoom() {
		return zoom;
	}

	public void setZoom(int zoom) {
		this.zoom = zoom;
	}

	public int getMaxZoom() {
		return maxZoom;
	}

	public void setMaxZoom(int maxZoom) {
		this.maxZoom = maxZoom;
	}

	public List<Square> getSquares() {
		return squares;
	}

	public List<Taxi> getTaxis() {
		return taxis;
	}

	public void put(Taxi taxi) {
		if (taxi != null) {
			this.taxis.add(taxi);
		}
	}

	public void put(Square square) {
		if (square != null) {
			this.squares.add(square);
		}
	}

	public void put(Circle circle) {
		if (circle != null && circle.isValid()) {
			this.circles.add(circle);
		}
	}

	public void put(Arrow arrow) {
		if (arrow != null && arrow.isValid()) {
			this.arrows.add(arrow);
		}
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = DataUtils.format(dataInicio, DataUtils.DD_MM_YYYY_HH_MM);
	}

	public String getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = DataUtils.format(dataFim, DataUtils.DD_MM_YYYY_HH_MM);
	}

	public List<Circle> getCircles() {
		return circles;
	}

	public void setCircles(List<Circle> circles) {
		this.circles = circles;
	}

	public List<Arrow> getArrows() {
		return arrows;
	}

	public void setArrows(List<Arrow> arrows) {
		this.arrows = arrows;
	}

}
