package br.uff.ic.taxi;

import java.math.BigDecimal;

public class Count {
	
	private Integer celula;
	private BigDecimal latitudeCentral;
	private BigDecimal longitudeCentral;
	private Integer mapa;
	private Integer total;
	
	public Count(Integer mapa, Integer celula, Integer total, BigDecimal latitude, BigDecimal longitude, BigDecimal lado) {
		this.mapa=mapa;
		this.celula=celula;
		this.total=total;
		this.latitudeCentral = latitude.add(lado.divide(new BigDecimal(2)));
		this.longitudeCentral = longitude.add(lado.divide(new BigDecimal(2)));
	}
	
	public Integer getCelula() {
		return celula;
	}
	
	public BigDecimal getLatitudeCentral() {
		return latitudeCentral;
	}
	public BigDecimal getLongitudeCentral() {
		return longitudeCentral;
	}
	public Integer getMapa() {
		return mapa;
	}
	public Integer getTotal() {
		return total;
	}
	public void setCelula(Integer celula) {
		this.celula = celula;
	}
	public void setLatitudeCentral(BigDecimal latitudeCentral) {
		this.latitudeCentral = latitudeCentral;
	}
	public void setLongitudeCentral(BigDecimal longitudeCentral) {
		this.longitudeCentral = longitudeCentral;
	}
	public void setMapa(Integer mapa) {
		this.mapa = mapa;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "Count [mapa=" + mapa + ", celula=" + celula + ", total=" + total + ", latitudeCentral=" + latitudeCentral + ", longitudeCentral=" + longitudeCentral + "]";
	}

	public boolean possuiTaxi() {
		return total > 0;
	}
}