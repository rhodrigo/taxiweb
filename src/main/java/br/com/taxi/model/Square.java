package br.com.taxi.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.thoughtworks.xstream.annotations.XStreamOmitField;

public class Square {

	private static final String[] RANGE_COLORS = new String[] { "#fff5f0", "#fee0d2", "#fcbba1", "#fc9272", "#fb6a4a", "#ef3b2c", "#cb181d", "#a50f15", "#67000d" };

	private BigDecimal x1;

	private BigDecimal y1;

	private BigDecimal x2;

	private BigDecimal y2;

	private BigDecimal x3;

	private BigDecimal y3;

	private BigDecimal x4;

	private BigDecimal y4;

	private String color;

	@XStreamOmitField
	private String draw;

	private int total;

	public BigDecimal getX1() {
		return x1;
	}

	public void setX1(BigDecimal x1) {
		this.x1 = x1;
	}

	public BigDecimal getY1() {
		return y1;
	}

	public void setY1(BigDecimal y1) {
		this.y1 = y1;
	}

	public BigDecimal getX2() {
		return x2;
	}

	public void setX2(BigDecimal x2) {
		this.x2 = x2;
	}

	public BigDecimal getY2() {
		return y2;
	}

	public void setY2(BigDecimal y2) {
		this.y2 = y2;
	}

	public BigDecimal getX3() {
		return x3;
	}

	public void setX3(BigDecimal x3) {
		this.x3 = x3;
	}

	public BigDecimal getY3() {
		return y3;
	}

	public void setY3(BigDecimal y3) {
		this.y3 = y3;
	}

	public BigDecimal getX4() {
		return x4;
	}

	public void setX4(BigDecimal x4) {
		this.x4 = x4;
	}

	public BigDecimal getY4() {
		return y4;
	}

	public void setY4(BigDecimal y4) {
		this.y4 = y4;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String draw() {
		return draw;
	}

	public void draw(String draw) {
		this.draw = draw;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public void updateBackground(Integer max) {

		String selectedColor = RANGE_COLORS[0];
		
		if (total == 0) {
			selectedColor = "transparent";

		} else if (max < 9) {
			selectedColor = RANGE_COLORS[total];

		} else {

			BigDecimal maxRange = new BigDecimal(RANGE_COLORS.length);
			BigDecimal proporcao = maxRange.divide(new BigDecimal(max), 5, RoundingMode.DOWN);
			int posicao = proporcao.multiply(new BigDecimal(total)).intValue();

			if (posicao >= RANGE_COLORS.length) {
				posicao = RANGE_COLORS.length - 1;
			}

			selectedColor = RANGE_COLORS[posicao];
		}

		this.color = selectedColor;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

}
