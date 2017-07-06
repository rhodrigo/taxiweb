
function loadMap() {
	map = L.map('map').setView([-22.90, -43.25], 13);
	L.tileLayer('https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token=pk.eyJ1IjoibWFwYm94IiwiYSI6ImNpandmbXliNDBjZWd2M2x6bDk3c2ZtOTkifQ._QA7i5Mpkd_m30IGElHziw', {
		maxZoom: 18,
		attribution: 'Map data &copy; <a href="http://openstreetmap.org">OpenStreetMap</a> contributors, ' +
			'<a href="http://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, ' +
			'Imagery © <a href="http://mapbox.com">Mapbox</a>',
		id: 'mapbox.streets'
	}).addTo(map);
}

function loadSquare() {
	// Celula 1
	var polygon = L.polygon([
		[-22.925, -43.275],
		[-22.915, -43.275],
		[-22.915, -43.265],
		[-22.925, -43.265]
	], {color: '#430000'});
	polygon.addTo(map);
	square.matriz.push(polygon);
	square.group.addLayer(polygon);
	// Celula 2
	var polygon = L.polygon([
		[-22.925, -43.265],
		[-22.915, -43.265],
		[-22.915, -43.255],
		[-22.925, -43.255]
	], {color: '#bf0000'});
	polygon.addTo(map);
	square.matriz.push(polygon);
	f.group.addLayer(polygon);
	// Celula 3
	var polygon = L.polygon([
		[-22.925, -43.255],
		[-22.915, -43.255],
		[-22.915, -43.245],
		[-22.925, -43.245]
	], {color: '#770000'});
	polygon.addTo(map);
	square.matriz.push(polygon);
	square.group.addLayer(polygon);
	// Celula 4
	var polygon = L.polygon([
		[-22.925, -43.245],
		[-22.915, -43.245],
		[-22.915, -43.235],
		[-22.925, -43.235]
	], {color: '#770000'});
	polygon.addTo(map);
	square.matriz.push(polygon);
	square.group.addLayer(polygon);
	// Celula 5
	var polygon = L.polygon([
		[-22.925, -43.235],
		[-22.915, -43.235],
		[-22.915, -43.225],
		[-22.925, -43.225]
	], {color: '#6f0000'});
	polygon.addTo(map);
	square.matriz.push(polygon);
	square.group.addLayer(polygon);
	// Celula 6
	var polygon = L.polygon([
		[-22.915, -43.275],
		[-22.905, -43.275],
		[-22.905, -43.265],
		[-22.915, -43.265]
	], {color: '#630000'});
	polygon.addTo(map);
	square.matriz.push(polygon);
	square.group.addLayer(polygon);
	// Celula 7
	var polygon = L.polygon([
		[-22.915, -43.265],
		[-22.905, -43.265],
		[-22.905, -43.255],
		[-22.915, -43.255]
	], {color: '#3b0000'});
	polygon.addTo(map);
	square.matriz.push(polygon);
	square.group.addLayer(polygon);
	// Celula 8
	var polygon = L.polygon([
		[-22.915, -43.255],
		[-22.905, -43.255],
		[-22.905, -43.245],
		[-22.915, -43.245]
	], {color: '#430000'});
	polygon.addTo(map);
	square.matriz.push(polygon);
	square.group.addLayer(polygon);
	// Celula 9
	var polygon = L.polygon([
		[-22.915, -43.245],
		[-22.905, -43.245],
		[-22.905, -43.235],
		[-22.915, -43.235]
	], {color: '#5b0000'});
	polygon.addTo(map);
	square.matriz.push(polygon);
	square.group.addLayer(polygon);
	// Celula 10
	var polygon = L.polygon([
		[-22.915, -43.235],
		[-22.905, -43.235],
		[-22.905, -43.225],
		[-22.915, -43.225]
	], {color: '#5b0000'});
	polygon.addTo(map);
	square.matriz.push(polygon);
	square.group.addLayer(polygon);
	// Celula 11
	var polygon = L.polygon([
		[-22.905, -43.275],
		[-22.895, -43.275],
		[-22.895, -43.265],
		[-22.905, -43.265]
	], {color: '#570000'});
	polygon.addTo(map);
	square.matriz.push(polygon);
	square.group.addLayer(polygon);
	// Celula 12
	var polygon = L.polygon([
		[-22.905, -43.265],
		[-22.895, -43.265],
		[-22.895, -43.255],
		[-22.905, -43.255]
	], {color: '#4f0000'});
	polygon.addTo(map);
	square.matriz.push(polygon);
	square.group.addLayer(polygon);
	// Celula 13
	var polygon = L.polygon([
		[-22.905, -43.255],
		[-22.895, -43.255],
		[-22.895, -43.245],
		[-22.905, -43.245]
	], {color: '#4b0000'});
	polygon.addTo(map);
	square.matriz.push(polygon);
	square.group.addLayer(polygon);
	// Celula 14
	var polygon = L.polygon([
		[-22.905, -43.245],
		[-22.895, -43.245],
		[-22.895, -43.235],
		[-22.905, -43.235]
	], {color: '#430000'});
	polygon.addTo(map);
	square.matriz.push(polygon);
	square.group.addLayer(polygon);
	// Celula 15
	var polygon = L.polygon([
		[-22.905, -43.235],
		[-22.895, -43.235],
		[-22.895, -43.225],
		[-22.905, -43.225]
	], {color: '#3f0000'});
	polygon.addTo(map);
	square.matriz.push(polygon);
	square.group.addLayer(polygon);
	// Celula 16
	var polygon = L.polygon([
		[-22.895, -43.275],
		[-22.885, -43.275],
		[-22.885, -43.265],
		[-22.895, -43.265]
	], {color: '#3b0000'});
	polygon.addTo(map);
	square.matriz.push(polygon);
	square.group.addLayer(polygon);
	// Celula 17
	var polygon = L.polygon([
		[-22.895, -43.265],
		[-22.885, -43.265],
		[-22.885, -43.255],
		[-22.895, -43.255]
	], {color: '#370000'});
	polygon.addTo(map);
	square.matriz.push(polygon);
	square.group.addLayer(polygon);
	// Celula 18
	var polygon = L.polygon([
		[-22.895, -43.255],
		[-22.885, -43.255],
		[-22.885, -43.245],
		[-22.895, -43.245]
	], {color: '#3f0000'});
	polygon.addTo(map);
	square.matriz.push(polygon);
	square.group.addLayer(polygon);
	// Celula 19
	var polygon = L.polygon([
		[-22.895, -43.245],
		[-22.885, -43.245],
		[-22.885, -43.235],
		[-22.895, -43.235]
	], {color: '#3b0000'});
	polygon.addTo(map);
	square.matriz.push(polygon);
	square.group.addLayer(polygon);
	// Celula 20
	var polygon = L.polygon([
		[-22.895, -43.235],
		[-22.885, -43.235],
		[-22.885, -43.225],
		[-22.895, -43.225]
	], {color: '#3f0000'});
	polygon.addTo(map);
	square.matriz.push(polygon);
	square.group.addLayer(polygon);
	// Celula 21
	var polygon = L.polygon([
		[-22.885, -43.275],
		[-22.875, -43.275],
		[-22.875, -43.265],
		[-22.885, -43.265]
	], {color: '#3b0000'});
	polygon.addTo(map);
	square.matriz.push(polygon);
	square.group.addLayer(polygon);
	// Celula 22
	var polygon = L.polygon([
		[-22.885, -43.265],
		[-22.875, -43.265],
		[-22.875, -43.255],
		[-22.885, -43.255]
	], {color: '#470000'});
	polygon.addTo(map);
	square.matriz.push(polygon);
	square.group.addLayer(polygon);
	// Celula 23
	var polygon = L.polygon([
		[-22.885, -43.255],
		[-22.875, -43.255],
		[-22.875, -43.245],
		[-22.885, -43.245]
	], {color: '#430000'});
	polygon.addTo(map);
	square.matriz.push(polygon);
	square.group.addLayer(polygon);
	// Celula 24
	var polygon = L.polygon([
		[-22.885, -43.245],
		[-22.875, -43.245],
		[-22.875, -43.235],
		[-22.885, -43.235]
	], {color: '#3b0000'});
	polygon.addTo(map);
	square.matriz.push(polygon);
	square.group.addLayer(polygon);
	// Celula 25
	var polygon = L.polygon([
		[-22.885, -43.235],
		[-22.875, -43.235],
		[-22.875, -43.225],
		[-22.885, -43.225]
	], {color: '#3b0000'});
	polygon.addTo(map);
	square.matriz.push(polygon);
	square.group.addLayer(polygon);
}

function loadTaxi() {
	var taxi = L.marker([-22.91936412, -43.23366884]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91291027, -43.24364014]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.89677430, -43.27247606]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.89677430, -43.27247606]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91365496, -43.23582479]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.88386415, -43.22854844]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91315850, -43.26573869]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.92035699, -43.26789465]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91390319, -43.22531450]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.92482483, -43.25900133]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.89652604, -43.27274555]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.92358378, -43.22666198]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91340673, -43.26951162]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.92060521, -43.25037750]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91713013, -43.25091649]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.92085342, -43.25873183]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91291027, -43.26654718]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91415142, -43.25199447]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91861946, -43.26169627]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.88460900, -43.26385223]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.90248417, -43.26978111]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.90149117, -43.25765385]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.89553300, -43.27301505]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.90372542, -43.25846234]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.92408020, -43.25145548]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.89503647, -43.26250476]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.90794556, -43.26816414]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.90794556, -43.22773996]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.87964326, -43.26007931]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.90273242, -43.24364014]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.92482483, -43.25792335]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.92234271, -43.26412172]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.89553300, -43.23744176]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.87765691, -43.26142678]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91663368, -43.23555530]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.92060521, -43.25927082]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91315850, -43.24983851]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.92358378, -43.26385223]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91315850, -43.27274555]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.92383199, -43.25873183]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.89528473, -43.23744176]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91737835, -43.25091649]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.92259093, -43.26034880]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.89255381, -43.23043490]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.90595963, -43.27032010]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91042794, -43.23232136]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91663368, -43.25145548]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.90397366, -43.25954032]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91861946, -43.26169627]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.92482483, -43.25657588]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91067617, -43.22639248]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.90074641, -43.25468941]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.88659525, -43.25118598]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91017970, -43.24471811]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.92283914, -43.23097389]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91663368, -43.22881793]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91663368, -43.22881793]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.88436072, -43.24876053]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91539256, -43.23232136]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91539256, -43.23232136]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.89453994, -43.22504501]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.89503647, -43.27301505]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91489610, -43.23151288]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.92209450, -43.26250476]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.92457662, -43.25199447]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.92134986, -43.23798075]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91737835, -43.24175367]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91241381, -43.24121468]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91489610, -43.24175367]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.92457662, -43.25873183]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91737835, -43.24175367]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.90521489, -43.26816414]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91439965, -43.23339934]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91961234, -43.25873183]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.90273242, -43.27032010]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91315850, -43.22720097]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91812302, -43.25118598]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.92060521, -43.25927082]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91291027, -43.26654718]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91961234, -43.25900133]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91613723, -43.27490151]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91340673, -43.27005061]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.90124292, -43.24876053]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.90422191, -43.26412172]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91663368, -43.24983851]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91787480, -43.25118598]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91713013, -43.24175367]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91713013, -43.24175367]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91365496, -43.26412172]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91961234, -43.23878923]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91911590, -43.26304375]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.92060521, -43.25927082]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.89081592, -43.24229266]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91688190, -43.26088779]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.90124292, -43.25415042]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91588901, -43.24040620]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91588901, -43.24040620]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91191734, -43.23986721]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91514433, -43.26573869]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.92085342, -43.25900133]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91861946, -43.26277425]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91911590, -43.26223526]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.90322892, -43.24687407]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91166911, -43.26816414]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91961234, -43.25064700]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91861946, -43.26196577]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.89751908, -43.26762515]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.92060521, -43.25954032]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91762657, -43.24552660]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.92085342, -43.22585349]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91688190, -43.26088779]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.92358378, -43.22989591]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.89404341, -43.27247606]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91042794, -43.23232136]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91291027, -43.24256216]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91514433, -43.24337064]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.92134986, -43.25873183]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.88013984, -43.25388093]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.92110164, -43.23339934]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.92110164, -43.23339934]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91142088, -43.23905873]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.89453994, -43.25118598]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.92184629, -43.23744176]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91762657, -43.23528580]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.89503647, -43.26304375]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.92134986, -43.26169627]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.89727082, -43.22639248]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91365496, -43.23555530]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.88361587, -43.26007931]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.92283914, -43.26439122]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.90024991, -43.24552660]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91837124, -43.23609429]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.87914667, -43.26681667]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91936412, -43.26169627]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91539256, -43.24202317]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.88088471, -43.23905873]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91092441, -43.22720097]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91464787, -43.25010801]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91936412, -43.26304375]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.89677430, -43.23447732]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91787480, -43.25415042]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91713013, -43.23690277]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.92035699, -43.26007931]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.92184629, -43.25037750]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91911590, -43.26277425]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91886768, -43.26277425]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91886768, -43.26412172]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.88063642, -43.25361144]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91812302, -43.25415042]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.92308735, -43.23663328]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91564078, -43.23232136]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.90546314, -43.27382353]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91837124, -43.25037750]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.91961234, -43.25064700]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.92259093, -43.23205187]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
	var taxi = L.marker([-22.92259093, -43.23205187]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
}

function loadArrow() {
	// Não tem mapa anterior, não há o que fazer aqui.
}

function loadCircle() {
	// Não tem mapa anterior, não há o que fazer aqui.
}



