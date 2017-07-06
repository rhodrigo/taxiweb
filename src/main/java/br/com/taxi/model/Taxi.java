package br.com.taxi.model;

import java.math.BigDecimal;

import com.thoughtworks.xstream.annotations.XStreamOmitField;

public class Taxi {

	private BigDecimal x;

	private BigDecimal y;

	@XStreamOmitField
	private String draw;

	public BigDecimal getX() {
		return x;
	}

	public void setX(BigDecimal x) {
		this.x = x;
	}

	public BigDecimal getY() {
		return y;
	}

	public void setY(BigDecimal y) {
		this.y = y;
	}

	public void draw(String draw) {
		this.draw = draw;
	}

	public String draw() {
		return draw;
	}

}
