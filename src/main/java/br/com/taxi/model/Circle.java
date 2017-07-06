package br.com.taxi.model;

import java.math.BigDecimal;

import com.thoughtworks.xstream.annotations.XStreamOmitField;

public class Circle {

	// -22.890, -43.240], {
	// color: 'blue',
	// fillColor: 'blue',
	// fillOpacity: 0.5,
	// radius: 100
	// }).addTo(map)
	// .bindPopup('UMin: -0.70833')

	private BigDecimal x;

	private BigDecimal y;

	private String color;

	private String fill;

	private String prefix;

	private double value;

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getFill() {
		return fill;
	}

	public void setFill(String fill) {
		this.fill = fill;
	}

	public String getDraw() {
		return draw;
	}

	public void setDraw(String draw) {
		this.draw = draw;
	}

	public String draw() {
		return draw;
	}

	public void draw(String draw) {
		this.draw = draw;
	}

	public boolean isValid() {
		return x != null && y != null;
	}

}
