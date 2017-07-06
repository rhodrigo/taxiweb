package br.com.taxi.model;

import java.math.BigDecimal;

import com.thoughtworks.xstream.annotations.XStreamOmitField;

public class Arrow {

	/*
	function loadArrow(mapa) {
		
		var map = mapa;
		
		var polygon = L.polygon([
			[-22.91950000, -43.26850000],
			[-22.92050000, -43.26850000],
			[-22.92050000, -43.26750000],
			[-22.92100000, -43.26750000],
			[-22.92000000, -43.26650000],
			[-22.91900000, -43.26750000],
			[-22.91950000, -43.26750000],
			[-22.91950000, -43.26850000],
		], {color: 'green'});
		polygon.addTo(map);
		arrow.matriz.push(polygon);
		arrow.group.addLayer(polygon);
	}	 
	 */
	
	private BigDecimal x1;

	private BigDecimal y1;

	private BigDecimal x2;

	private BigDecimal y2;

	private BigDecimal x3;

	private BigDecimal y3;

	private BigDecimal x4;

	private BigDecimal y4;

	private BigDecimal x5;

	private BigDecimal y5;

	private BigDecimal x6;

	private BigDecimal y6;

	private BigDecimal x7;

	private BigDecimal y7;

	private BigDecimal x8;

	private BigDecimal y8;

	@XStreamOmitField
	private String draw;

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

	public BigDecimal getX5() {
		return x5;
	}

	public void setX5(BigDecimal x5) {
		this.x5 = x5;
	}

	public BigDecimal getY5() {
		return y5;
	}

	public void setY5(BigDecimal y5) {
		this.y5 = y5;
	}

	public BigDecimal getX6() {
		return x6;
	}

	public void setX6(BigDecimal x6) {
		this.x6 = x6;
	}

	public BigDecimal getY6() {
		return y6;
	}

	public void setY6(BigDecimal y6) {
		this.y6 = y6;
	}

	public BigDecimal getX7() {
		return x7;
	}

	public void setX7(BigDecimal x7) {
		this.x7 = x7;
	}

	public BigDecimal getY7() {
		return y7;
	}

	public void setY7(BigDecimal y7) {
		this.y7 = y7;
	}

	public BigDecimal getX8() {
		return x8;
	}

	public void setX8(BigDecimal x8) {
		this.x8 = x8;
	}

	public BigDecimal getY8() {
		return y8;
	}

	public void setY8(BigDecimal y8) {
		this.y8 = y8;
	}

	public String getDraw() {
		if(draw == null){
			return "";
		}
		return draw;
	}

	public void setDraw(String draw) {
		this.draw = draw;
	}

	public boolean isValid() {
		return x1 != null && y1 != null;
	}

}
