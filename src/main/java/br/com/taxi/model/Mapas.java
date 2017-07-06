package br.com.taxi.model;

import java.util.List;

import com.google.common.collect.Lists;

public class Mapas {

	private List<Mapa> mapaList = Lists.newArrayList();
	
	public void put(Mapa mapa){
		this.mapaList.add(mapa);
	}

	public List<Mapa> getMapaList() {
		return mapaList;
	}

	public int getMaxTaxiOnSquare() {
		int maxTaxiOnSquare = 0;
		
		for (Mapa mapa : mapaList) {
			
			for (Square square : mapa.getSquares()) {
				
				if(maxTaxiOnSquare <= square.getTotal()){
					maxTaxiOnSquare = square.getTotal();
				}
			}
		}
		
		return maxTaxiOnSquare;
	}

}
