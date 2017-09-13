var map = null;

function create() {
	var object = new Object();
	object.matriz = [];
	object.group = null;
	object.hide = false;
	object.button = null;
	return object;
}

var srcTaxi = create();
var dstTaxi = create();
var arrow = create();
var square = create();
var circleUMax = create();
var circleUMin = create();
var circleSMax = create();
var circleSMin = create();

function changeState(draw, demoState, hideDraw) {
	if (hideDraw) {
		if (demoState)
			map.removeLayer(draw);
		else
			map.addLayer(draw);
	}
}

function hide(managerDraw) {
	if (!managerDraw.hide) {
		managerDraw.hide = true;
		managerDraw.group.eachLayer(function(layer) {
			changeState(layer, true, managerDraw.hide);
		});
	} else {
		managerDraw.group.eachLayer(function(layer) {
			changeState(layer, false, managerDraw.hide);
		});
		managerDraw.hide = false;
	}
	return managerDraw;
}

var srcIcon = L.icon({
	iconUrl : 'leaflet/images/marker-icon.png',
	shadowUrl : 'leaflet/images/marker-shadow.png',

	iconSize : [ 25, 41 ], // size of the icon
	shadowSize : [ 41, 41 ], // size of the shadow
	iconAnchor : [ 12, 40 ], // point of the icon which will correspond to
								// marker's location
	shadowAnchor : [ 12, 40 ], // the same for the shadow
	popupAnchor : [ 12, 12 ]
// point from which the popup should open relative to the iconAnchor
});

srcTaxi.button = L.easyButton({
	states : [ {
		stateName : 'hide-src-taxis', // name the state
		icon : 'glyphicon glyphicon-star-empty', // and define its properties
		title : 'Hide src taxis demo', // like its title
		onClick : function(control) {
			srcTaxi = hide(srcTaxi);
			control.state('show-src-taxis');
		}
	}, {
		stateName : 'show-src-taxis',
		icon : 'glyphicon glyphicon-star-empty',
		title : 'Hide src taxis demo',
		onClick : function(control) {
			srcTaxi = hide(srcTaxi);
			control.state('hide-src-taxis');
		}
	} ]
});

dstTaxi.button = L.easyButton({
	states : [ {
		stateName : 'hide-dst-taxis',
		icon : 'glyphicon glyphicon-star',
		title : 'Hide dst taxis demo',
		onClick : function(control) {
			dstTaxi = hide(dstTaxi);
			control.state('show-dst-taxis');
		}
	}, {
		stateName : 'show-dst-taxis',
		icon : 'glyphicon glyphicon-star',
		title : 'Hide dst taxis demo',
		onClick : function(control) {
			dstTaxi = hide(dstTaxi);
			control.state('hide-dst-taxis');
		}
	} ]
});

arrow.button = L.easyButton({
	states : [ {
		stateName : 'hide-arrows', // name the state
		icon : 'glyphicon glyphicon-arrow-up', // and define its properties
		title : 'Hide arrows demo', // like its title
		onClick : function(control) {
			arrow = hide(arrow);
			control.state('show-arrows');
		}
	}, {
		stateName : 'show-arrows',
		icon : 'glyphicon glyphicon-arrow-up',
		title : 'Hide arrows demo',
		onClick : function(control) {
			arrow = hide(arrow);
			control.state('hide-arrows');
		}
	} ]
});

square.button = L.easyButton({
	states : [ {
		stateName : 'hide-squares', // name the state
		icon : 'glyphicon glyphicon-th-large', // and define its properties
		title : 'Hide squares demo', // like its title
		onClick : function(control) {
			square = hide(square);
			control.state('show-squares');
		}
	}, {
		stateName : 'show-squares',
		icon : 'glyphicon glyphicon-th-large',
		title : 'Hide squares demo',
		onClick : function(control) {
			square = hide(square);
			control.state('hide-squares');
		}
	} ]
});

circleUMax.button = L.easyButton({
	states : [ {
		stateName : 'hide-circle-u-max', // name the state
		icon : 'glyphicon glyphicon-adjust', // and define its properties
		title : 'Hide circle u max demo', // like its title
		onClick : function(control) {
			circleUMax = hide(circleUMax);
			control.state('show-circle-u-max');
		}
	}, {
		stateName : 'show-circle-u-max',
		icon : 'glyphicon glyphicon-adjust',
		title : 'Hide circle u max demo',
		onClick : function(control) {
			circleUMax = hide(circleUMax);
			control.state('hide-circle-u-max');
		}
	} ]
});

circleUMin.button = L.easyButton({
	states : [ {
		stateName : 'hide-circle-u-min', // name the state
		icon : 'glyphicon glyphicon-adjust', // and define its properties
		title : 'Hide circle u min demo', // like its title
		onClick : function(control) {
			circleUMin = hide(circleUMin);
			control.state('show-circle-u-min');
		}
	}, {
		stateName : 'show-circle-u-min',
		icon : 'glyphicon glyphicon-adjust',
		title : 'Hide circle u min demo',
		onClick : function(control) {
			circleUMin = hide(circleUMin);
			control.state('hide-circle-u-min');
		}
	} ]
});

circleSMax.button = L.easyButton({
	states : [ {
		stateName : 'hide-circle-s-max', // name the state
		icon : 'glyphicon glyphicon-adjust', // and define its properties
		title : 'Hide circle s max demo', // like its title
		onClick : function(control) {
			circleSMax = hide(circleSMax);
			control.state('show-circle-s-max');
		}
	}, {
		stateName : 'show-circle-s-max',
		icon : 'glyphicon glyphicon-adjust',
		title : 'Hide circle s max demo',
		onClick : function(control) {
			circleSMax = hide(circleSMax);
			control.state('hide-circle-s-max');
		}
	} ]
});

circleSMin.button = L.easyButton({
	states : [ {
		stateName : 'hide-circle-s-min', // name the state
		icon : 'glyphicon glyphicon-adjust', // and define its properties
		title : 'Hide circle s min demo', // like its title
		onClick : function(control) {
			circleSMin = hide(circleSMin);
			control.state('show-circle-s-min');
		}
	}, {
		stateName : 'show-circle-s-min',
		icon : 'glyphicon glyphicon-adjust',
		title : 'Hide circle s min demo',
		onClick : function(control) {
			circleSMin = hide(circleSMin);
			control.state('hide-circle-s-min');
		}
	} ]
});

function setupButtons() {
	srcTaxi.button.setPosition('bottomright');
	srcTaxi.button.addTo(map);
	dstTaxi.button.setPosition('bottomright');
	dstTaxi.button.addTo(map);
	arrow.button.setPosition('bottomright');
	arrow.button.addTo(map);
	square.button.setPosition('bottomright');
	square.button.addTo(map);
	circleUMax.button.setPosition('bottomright');
	circleUMax.button.addTo(map);
	circleUMin.button.setPosition('bottomright');
	circleUMin.button.addTo(map);
	circleSMax.button.setPosition('bottomright');
	circleSMax.button.addTo(map);
	circleSMin.button.setPosition('bottomright');
	circleSMin.button.addTo(map);
}

function loadSquare(quadrado, map) {
	
	var polygon = L.polygon(
		[ 
			[ quadrado.x1, quadrado.y1 ],
			[ quadrado.x2, quadrado.y2 ], 
			[ quadrado.x3, quadrado.y3 ],
			[ quadrado.x4, quadrado.y4 ], 
		], 
		{
			'color' : '#726f6f',
		    'fillColor': quadrado.color,
		    'fillOpacity': 0.7,
		    'weight': 2
		}
	);

	polygon.addTo(map);
	square.matriz.push(polygon);
	square.group.addLayer(polygon);
};

function loadTaxi(taxi, map) {
	var taxi = L.marker([ taxi.x, taxi.y ]);
	taxi.addTo(map);
	dstTaxi.matriz.push(taxi);
	dstTaxi.group.addLayer(taxi);
};

function loadArrow(seta, mapa) {
	
	var polygon = L.polygon([
		[seta.x1, seta.y1],
		[seta.x2, seta.y2],
		[seta.x3, seta.y3],
		[seta.x4, seta.y4],
		[seta.x5, seta.y5],
		[seta.x6, seta.y6],
		[seta.x7, seta.y7],
		[seta.x8, seta.y8],
	], {color: 'green'});
	polygon.addTo(mapa);
	
	arrow.matriz.push(polygon);
	arrow.group.addLayer(polygon);
}

function loadCircle(circulo, mapa) {
	
	var circle = L.circle([circulo.x, circulo.y], {
		color: circulo.color,
		fillColor: circulo.fill,
		fillOpacity: 0.5,
		radius: 100
	}).addTo(mapa)
		.bindPopup(circulo.prefix + ':' + circulo.value)
		.openPopup();
	
	if(circulo.prefix == 'Sorvedouro'){
		circleUMax.matriz.push(circle);
		circleUMax.group.addLayer(circle);
	}
	if(circulo.prefix == 'Fonte'){
		circleUMin.matriz.push(circle);
		circleUMin.group.addLayer(circle);
	}	
	if(circulo.prefix == 'Rotacional Max'){
		circleSMax.matriz.push(circle);
		circleSMax.group.addLayer(circle);
	}
	if(circulo.prefix == 'Rotacional Min'){
		circleSMin.matriz.push(circle);
		circleSMin.group.addLayer(circle);
	}
	
}


var gerenciador = {
	coordenadas : [],
	mapaPrincipal: {},
	mapa1: {},
	mapa2: {},
	mapa3: {},
	ativaMapaPrimario: function(){
		$("body").removeClass("mapa-secundario-ativo").addClass("mapa-principal-ativo");
	},	
	ativaMapaSecundario: function(){
		$("body").removeClass("mapa-principal-ativo").addClass("mapa-secundario-ativo");
		$(".pagination").show();
	},
	params:{
		latitude: function(){
			return $("#inputLatitude").val();
		},
		longitude: function(){
			return $("#inputLongitude").val();
		}, 
		zoom: function(){
			return $("#inputZoom").val();
		},
		maxzoom: function(){
			return 18;
		}
	},
	inicializaMapa: function(id){
		
		var params = gerenciador.params;
		
		var mapa = L.map(id).setView([ params.latitude(), params.longitude() ], params.zoom());
		L.tileLayer('https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token=pk.eyJ1IjoibmF0YW5jYXJkb3NvIiwiYSI6ImNpemFmcnIyZzAyOXAzM3RldWk0bWZvcW0ifQ.loouyvopATvlsskQFXEjhw',
		{
			maxZoom : params.maxzoom(),
			attribution : 'Map data &copy; <a href="http://openstreetmap.org">OpenStreetMap</a> contributors, '
					+ '<a href="http://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, '
					+ 'Imagery © <a href="http://mapbox.com">Mapbox</a>',
			id : 'mapbox.streets'
		}).addTo(mapa);
		
		return mapa;		
	},
	plotaSquares: function(posicao, mapa){
		
		if(gerenciador.coordenadas[posicao] == undefined){
			return;
		}
		
		$(gerenciador.coordenadas[posicao].squares).each(function() {
			var square = $(this)[0];
			loadSquare(square, mapa);
		});
	},
	plotaTaxis: function(posicao, mapa){
		
		if(gerenciador.coordenadas[posicao] == undefined){
			return;
		}
		
		$(gerenciador.coordenadas[posicao].taxis).each(function() {
			var taxi = $(this)[0]; 
			loadTaxi(taxi, mapa);
		});
	},
	plotaCircles: function(posicao, mapa){
		
		if(gerenciador.coordenadas[posicao] == undefined){
			return;
		}
		
		$(gerenciador.coordenadas[posicao].circles).each(function() {
			var circle = $(this)[0];
			loadCircle(circle, mapa);
		});
	},
	plotaArrows: function(posicao, mapa){
		
		if(gerenciador.coordenadas[posicao] == undefined){
			return;
		}
		
		$(gerenciador.coordenadas[posicao].arrows).each(function() {
			var arrow = $(this)[0];
			loadArrow(arrow, mapa);
		});
	},
	plotaCoordenadas: function(){
		
		if(gerenciador.paginate.isLast()){
			return;
		}
		
		gerenciador.clearMaps();
		gerenciador.paginate.updateData();
		var pagina = gerenciador.paginate.current;
		
		if($("#tipo-densidade").is(":checked")){
		
			gerenciador.plotaTaxis(pagina, gerenciador.mapa1);
			gerenciador.plotaSquares(pagina, gerenciador.mapa1);
			
			gerenciador.plotaTaxis(pagina + 1, gerenciador.mapa2);
			gerenciador.plotaSquares(pagina + 1, gerenciador.mapa2);
			
			gerenciador.plotaSquares(pagina + 1, gerenciador.mapa3);
			gerenciador.plotaCircles(pagina + 1, gerenciador.mapa3);
			gerenciador.plotaArrows(pagina + 1, gerenciador.mapa3);
		
		}else{
			
			gerenciador.plotaSquares(pagina + 1, gerenciador.mapa1);
			gerenciador.plotaArrows(pagina + 1, gerenciador.mapa1);
			gerenciador.plotaCircles(pagina + 1, gerenciador.mapa1);
			
			gerenciador.plotaSquares(pagina + 2, gerenciador.mapa2);
			gerenciador.plotaArrows(pagina + 2, gerenciador.mapa2);
			gerenciador.plotaCircles(pagina + 2, gerenciador.mapa2);
			
			gerenciador.plotaSquares(pagina + 3, gerenciador.mapa3);
			gerenciador.plotaArrows(pagina + 3, gerenciador.mapa3);
			gerenciador.plotaCircles(pagina + 3, gerenciador.mapa3);
			
		}
		
		
	},
	clearMaps: function(){
		
		gerenciador.clear(dstTaxi.matriz);
		gerenciador.clear(arrow.matriz);
		gerenciador.clear(square.matriz);
		gerenciador.clear(circleUMax.matriz);
		gerenciador.clear(circleUMin.matriz);
		gerenciador.clear(circleSMax.matriz);
		gerenciador.clear(circleSMin.matriz);
		
	},
	clear: function(layers){
		$.each(layers, function(index, layer){
			gerenciador.mapa1.removeLayer(layer);
			gerenciador.mapa2.removeLayer(layer);
			gerenciador.mapa3.removeLayer(layer)
		});
	},
	init : function(){
		
		srcTaxi.group = L.layerGroup();
		dstTaxi.group = L.layerGroup();
		arrow.group = L.layerGroup();
		square.group = L.layerGroup();
		circleUMax.group = L.layerGroup();
		circleUMin.group = L.layerGroup();
		circleSMax.group = L.layerGroup();
		circleSMin.group = L.layerGroup();
		
		gerenciador.mapaPrincipal = gerenciador.inicializaMapa('mapa-principal');
		
		gerenciador.mapaPrincipal.on('click', function(e) {
			$("#inputLatitude").val(e.latlng.lat);
			$("#inputLongitude").val(e.latlng.lng);
		});
		
	},
	paginate:{
		current: 0,
		previus: function(){
			var posicao = gerenciador.paginate.current;
			
			if(posicao > 0){
				gerenciador.paginate.current = gerenciador.paginate.current - 1;
				gerenciador.plotaCoordenadas();
			}
			gerenciador.paginate.updatePaginate();
		},
		next: function(){
			var posicao = gerenciador.paginate.current;
			var totalMapas = gerenciador.coordenadas.length - 1; 
				
			if(posicao < totalMapas){
				gerenciador.paginate.current = gerenciador.paginate.current + 1;
				gerenciador.plotaCoordenadas();
			}
			gerenciador.paginate.updatePaginate();
		},
		updateData: function(){
			
			var posicaoAtual = gerenciador.paginate.current;
			
			if($("#tipo-deslocamento").is(":checked")){
				posicaoAtual = posicaoAtual + 1;
			}else{
				$("#mapa-3").parent().find(".titulo").html("Mapa de Deslocamento");
			}
			
			if(gerenciador.coordenadas[posicaoAtual] != undefined){
				var dataInicio1 = gerenciador.coordenadas[posicaoAtual].dataInicio;
				$("#mapa-1").parent().find(".titulo").html(dataInicio1);
			}
			
			if(gerenciador.coordenadas[posicaoAtual + 1] != undefined){
				var dataInicio2 = gerenciador.coordenadas[posicaoAtual + 1].dataInicio;
				$("#mapa-2").parent().find(".titulo").html(dataInicio2);
			}
			
			if($("#tipo-deslocamento").is(":checked")){
				if(gerenciador.coordenadas[posicaoAtual + 2] != undefined){
					var dataInicio3 = gerenciador.coordenadas[posicaoAtual + 2].dataInicio;
					$("#mapa-3").parent().find(".titulo").html(dataInicio3);
				}
			}
		},
		isLast: function(){
			return gerenciador.paginate.current == gerenciador.coordenadas.length - 1;
		},
		isFirst: function(){
			return gerenciador.paginate.current == 0;
		},
		updatePaginate: function(){
			
			if(gerenciador.paginate.isLast()){
				$(".next").hide();
			}else{
				$(".next").show();
			}
			
			if(gerenciador.paginate.isFirst()){
				$(".previus").hide();
			}else{
				$(".previus").show();
			}
		}
	}
};
	
$(function(){
	
	gerenciador.init();
	
	$("#filter-map").submit(function(event) {
		
		var form = $(this);
		var url = form.prop("action");

		$.ajax({
			method : "post",
			url : url,
			data : form.serialize(),
			beforeSend : function() {
				$('<img class="loader" src="img/loader.gif">').prependTo($("#btn-gerar").parent());
				$("#btn-gerar").hide();
				$(".message-loader").show();
			},
			success : function(json) {
				
				if(json instanceof Array && json[0].hasOwnProperty("message")){
					$("#btn-gerar").show();
					$('.loader').remove();
					$(".message-loader").hide();
					alert(json[0].message);
					return;
				}
				
				$("html").removeClass("menu-ativo");
				
				gerenciador.ativaMapaSecundario();
				
				gerenciador.mapa1 = gerenciador.inicializaMapa('mapa-1');
				gerenciador.mapa2 = gerenciador.inicializaMapa('mapa-2');
				gerenciador.mapa3 = gerenciador.inicializaMapa('mapa-3');
				
				gerenciador.coordenadas = json.mapaList;
				gerenciador.plotaCoordenadas();
				
				$("#btn-gerar").hide();
			},
			complete : function() {
				$('.loader').remove();
				$(".message-loader").hide();
			}
		});

		event.preventDefault();

	});
	
	$("#btn-limpa-filtro").click(function(){
		//gerenciador.ativaMapaPrimario();
		location.reload();
	});
	
	$(".menu-abrir").click(function(){
		$("html").toggleClass("menu-ativo");
	});
	
	$(".previus").click(function(){
		gerenciador.paginate.previus();
	});
	
	$(".next").click(function(){
		gerenciador.paginate.next();
	});
	
	$(".tipoMapa").click(function(){
		gerenciador.plotaCoordenadas();
	});
	
});


