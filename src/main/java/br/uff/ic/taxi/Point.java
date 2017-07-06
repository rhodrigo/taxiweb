package br.uff.ic.taxi;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Point {
	
	private int i = -1;
	
	private BigDecimal latitude = BigDecimal.ZERO;
	private BigDecimal longitude = BigDecimal.ZERO;
	private BigDecimal s = BigDecimal.ZERO;
	private BigDecimal u = BigDecimal.ZERO;
	private BigDecimal x = BigDecimal.ZERO;
	private BigDecimal y = BigDecimal.ZERO;
	public Point() {

	}
	
	public Point(BigDecimal latitude, BigDecimal longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}
	public Point(Integer i, BigDecimal x, BigDecimal y) {
		super();
		this.x = x;
		this.y = y;
		this.i = i;
	}
	
	public Point(Integer i, double x, double y) {
		super();
		this.x = new BigDecimal(x);
		this.y = new BigDecimal(y);
		this.i = i;
	}
	
	public int getI() {
		return i;
	}
	public BigDecimal getLatitude() {
		latitude.setScale(10, RoundingMode.HALF_UP);
		return latitude.round(new MathContext(10, RoundingMode.HALF_UP));
	}
	public BigDecimal getLatitudeReal() {
		return latitude;
	}
	public BigDecimal getLongitude() {
		longitude.setScale(10, RoundingMode.HALF_UP);
		return longitude.round(new MathContext(10, RoundingMode.HALF_UP));
	}
	public BigDecimal getLongitudeReal() {
		return longitude;
	}
	public BigDecimal getS() {
		s.setScale(10, RoundingMode.HALF_UP);
		return s.round(new MathContext(10, RoundingMode.HALF_UP));
	}
	public BigDecimal getU() {
		u.setScale(10, RoundingMode.HALF_UP);
		return u.round(new MathContext(10, RoundingMode.HALF_UP));
	}
	public double getV() {
		/*if ((x.compareTo(BigDecimal.ZERO) == 0) && (y.compareTo(BigDecimal.ZERO) == 0)) {
			return 0.0;
		} else {
			return 1.0;
		}*/
		return 1.0;
	}
	public BigDecimal getX() {
		return x;
	}
	public BigDecimal getY() {
		return y;
	}
	public void setI(int i) {
		this.i = i;
	}
	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}
	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}
	public void setS(BigDecimal s) {
		this.s = s;
	}
	public void setS(double s) {
		setS(new BigDecimal(s));
	}
	public void setU(BigDecimal u) {
		this.u = u;
	}
	public void setU(double u) {
		setU(new BigDecimal(u));
	}
	public void setX(BigDecimal x) {
		this.x = x;
	}
	public void setY(BigDecimal y) {
		this.y = y;
	}
	@Override
	public String toString() {
		return "Point [latitude=" + latitude + ", longitude=" + longitude + ", x=" + x + ", y=" + y + "]";
	}

}
