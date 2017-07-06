package br.uff.ic.taxi;

import java.math.BigDecimal;
import java.util.List;

import br.com.taxi.model.Arrow;
import br.com.taxi.model.Circle;
import br.com.taxi.model.Square;
import br.com.taxi.model.Taxi;

public class JavaScript {
	
	// TODO drawCircle
	public static Circle drawCircle(String prefix, String color, double value, BigDecimal lat, BigDecimal lng) {
		
		Circle circle = new Circle();
		
		circle.setColor(color);
		circle.setFill(color);
		circle.setPrefix(prefix);
		circle.setValue(value);
		circle.setX(lat);
		circle.setY(lng);
		
		StringBuilder code = new StringBuilder();
		code.append("\tvar circle = L.circle([");
		code.append(lat);
		code.append(", ");
		code.append(lng);
		code.append("], {\n");
		code.append("\t\tcolor: '");
		code.append(color);
		code.append("',\n");
		code.append("\t\tfillColor: '");
		code.append(color);
		code.append("',\n");
		code.append("\t\tfillOpacity: 0.5,\n");
		code.append("\t\tradius: 100\n");
		code.append("\t}).addTo(map)\n");
		code.append("\t\t.bindPopup('");
		code.append(prefix);
		code.append(": ");
		code.append(value);
		code.append("')\n");
		code.append("\t\t.openPopup();\n");
		code.append("\tcircle");
		code.append(prefix);
		code.append(".matriz.push(circle);\n");
		code.append("\tcircle");
		code.append(prefix);
		code.append(".group.addLayer(circle);\n");
		
		circle.setDraw(code.toString());
		
		return circle;
	}

	// TODO drawMap
	public static String drawMap(Config config) {
		StringBuilder code = new StringBuilder();
		code.append("function loadMap() {\n");
		code.append("\tmap = L.map('map').setView([");
		code.append(config.getLatitude());
		code.append(", ");
		code.append(config.getLongitude());
		code.append("], " + config.getZoomPadrao() + ");\n");
		code.append("\tL.tileLayer('https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token=pk.eyJ1IjoibmF0YW5jYXJkb3NvIiwiYSI6ImNpemFmcnIyZzAyOXAzM3RldWk0bWZvcW0ifQ.loouyvopATvlsskQFXEjhw', {\n");
		code.append("\t\tmaxZoom: 18,\n");
		code.append("\t\tattribution: 'Map data &copy; <a href=\"http://openstreetmap.org\">OpenStreetMap</a> contributors, ' +\n");
		code.append("\t\t\t'<a href=\"http://creativecommons.org/licenses/by-sa/2.0/\">CC-BY-SA</a>, ' +\n");
		code.append("\t\t\t'Imagery © <a href=\"http://mapbox.com\">Mapbox</a>',\n");
		code.append("\t\tid: 'mapbox.streets'\n");
		code.append("\t}).addTo(map);\n");
		code.append("}\n\n");
		return code.toString();
	}

	// TODO drawArrow
	public static Arrow drawArrow(Count dst, List<Point> listPonto) {
		
		Arrow arrow = new Arrow();
		
		StringBuilder code = new StringBuilder();
		code.append("\tvar polygon = L.polygon([\n");

		arrow.setX1(listPonto.get(0).getLatitude());
		arrow.setY1(listPonto.get(0).getLongitude());
		arrow.setX2(listPonto.get(1).getLatitude());
		arrow.setY2(listPonto.get(1).getLongitude());
		arrow.setX3(listPonto.get(2).getLatitude());
		arrow.setY3(listPonto.get(2).getLongitude());
		arrow.setX4(listPonto.get(3).getLatitude());
		arrow.setY4(listPonto.get(3).getLongitude());		
		arrow.setX5(listPonto.get(4).getLatitude());
		arrow.setY5(listPonto.get(4).getLongitude());
		arrow.setX6(listPonto.get(5).getLatitude());
		arrow.setY6(listPonto.get(5).getLongitude());
		arrow.setX7(listPonto.get(6).getLatitude());
		arrow.setY7(listPonto.get(6).getLongitude());
		arrow.setX8(listPonto.get(7).getLatitude());
		arrow.setY8(listPonto.get(7).getLongitude());
		
		// Base
		code.append("\t\t[");
		code.append(listPonto.get(0).getLatitude());
		code.append(", ");
		code.append(listPonto.get(0).getLongitude());
		code.append("],\n");
		code.append("\t\t[");
		code.append(listPonto.get(1).getLatitude());
		code.append(", ");
		code.append(listPonto.get(1).getLongitude());
		code.append("],\n");
		// Lado Direito
		code.append("\t\t[");
		code.append(listPonto.get(2).getLatitude());
		code.append(", ");
		code.append(listPonto.get(2).getLongitude());
		code.append("],\n");
		code.append("\t\t[");
		code.append(listPonto.get(3).getLatitude());
		code.append(", ");
		code.append(listPonto.get(3).getLongitude());
		code.append("],\n");
		// Topo
		code.append("\t\t[");
		code.append(listPonto.get(4).getLatitude());
		code.append(", ");
		code.append(listPonto.get(4).getLongitude());
		code.append("],\n");
		// Lado Esquerdo
		code.append("\t\t[");
		code.append(listPonto.get(5).getLatitude());
		code.append(", ");
		code.append(listPonto.get(5).getLongitude());
		code.append("],\n");
		code.append("\t\t[");
		code.append(listPonto.get(6).getLatitude());
		code.append(", ");
		code.append(listPonto.get(6).getLongitude());
		code.append("],\n");
		// Fecha
		code.append("\t\t[");
		code.append(listPonto.get(7).getLatitude());
		code.append(", ");
		code.append(listPonto.get(7).getLongitude());
		code.append("],\n");
		code.append("\t], {color: 'green'});\n");
		code.append("\tpolygon.addTo(map);\n");
		code.append("\tarrow.matriz.push(polygon);\n");
		code.append("\tarrow.group.addLayer(polygon);\n");
		
		arrow.setDraw(code.toString());
		
		return arrow;
	}

	// TODO drawSrcTaxi
	public static Taxi drawSrcTaxi(Point point) {
		
		Taxi taxi = new Taxi();
		taxi.setX(point.getLatitude());
		taxi.setY(point.getLongitude());
		
		StringBuilder code = new StringBuilder();
		code.append("\tvar taxi = L.marker([");
		code.append(point.getLatitude());
		code.append(", ");
		code.append(point.getLongitude());
		code.append("], {icon: srcIcon});\n");
		code.append("\ttaxi.addTo(map);\n");
		code.append("\tsrcTaxi.matriz.push(taxi);\n");
		code.append("\tsrcTaxi.group.addLayer(taxi);\n");
		
		taxi.draw(code.toString());
		
		return taxi;
	}

	// TODO drawDstTaxi
	public static Taxi drawDstTaxi(Point point) {
		
		Taxi taxi = new Taxi();
		taxi.setX(point.getLatitude());
		taxi.setY(point.getLongitude());
		
		StringBuilder code = new StringBuilder();
		code.append("\tvar taxi = L.marker([");
		code.append(point.getLatitude());
		code.append(", ");
		code.append(point.getLongitude());
		code.append("]);\n");
		code.append("\ttaxi.addTo(map);\n");
		code.append("\tdstTaxi.matriz.push(taxi);\n");
		code.append("\tdstTaxi.group.addLayer(taxi);\n");
		
		taxi.draw(code.toString());
		
		return taxi;
	}

	// TODO drawSquare
	public static String drawSquare(BigDecimal lat, BigDecimal lng, BigDecimal lado) {
		StringBuilder code = new StringBuilder();
		code.append("\tvar polygon = L.polygon([\n");
		code.append("\t\t[");
		code.append(lat);
		code.append(", ");
		code.append(lng);
		code.append("],\n");
		code.append("\t\t[");
		code.append(lat.add(lado));
		code.append(", ");
		code.append(lng);
		code.append("],\n");
		code.append("\t\t[");
		code.append(lat.add(lado));
		code.append(", ");
		code.append(lng.add(lado));
		code.append("],\n");
		code.append("\t\t[");
		code.append(lat);
		code.append(", ");
		code.append(lng.add(lado));
		code.append("]\n");
		code.append("\t]);\n");
		code.append("\tpolygon.addTo(map);\n");
		code.append("\tsquare.matriz.push(polygon);\n");
		code.append("\tsquare.group.addLayer(polygon);\n");
		return code.toString();
	}

	// TODO drawSquare
	public static Square drawSquare(BigDecimal lat, BigDecimal lng, BigDecimal lado, Integer total, Integer celula) {

		Square square = new Square();

		Integer r = (total * 200 / 50) + 55;
		String hex = String.format("#%02x%02x%02x", r, 0, 0);

		square.setX1(lat);
		square.setY1(lng);
		square.setX2(lat.add(lado));
		square.setY2(lng);
		square.setX3(lat.add(lado));
		square.setY3(lng.add(lado));
		square.setX4(lat);
		square.setY4(lng.add(lado));
		square.setColor(hex);
		square.setTotal(total);

		StringBuilder code = new StringBuilder();
		code.append("\t// Celula ");
		code.append(celula);
		code.append("\n\tvar polygon = L.polygon([\n");
		code.append("\t\t[");
		code.append(lat);
		code.append(", ");
		code.append(lng);
		code.append("],\n");
		code.append("\t\t[");
		code.append(lat.add(lado));
		code.append(", ");
		code.append(lng);
		code.append("],\n");
		code.append("\t\t[");
		code.append(lat.add(lado));
		code.append(", ");
		code.append(lng.add(lado));
		code.append("],\n");
		code.append("\t\t[");
		code.append(lat);
		code.append(", ");
		code.append(lng.add(lado));
		code.append("]\n");
		code.append("\t], {color: '");
		code.append(hex);
		code.append("'});\n");
		code.append("\tpolygon.addTo(map);\n");
		code.append("\tsquare.matriz.push(polygon);\n");
		code.append("\tsquare.group.addLayer(polygon);\n");

		square.draw(code.toString());

		return square;
	}

}
