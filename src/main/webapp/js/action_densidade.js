/*******************************************************************************
INFORMAÇÕES DE IDENTIFICAÇÃO DA VERSÃO
Versão: 1.0					Data: 19/11/2016 20:43
Objetivo/Manutenção: Adicionar funcionalidades ao mapa
Autor: Peron Rezende
*******************************************************************************/

/*******************************************************************************
' Nome........: changeState
' Objetivo....: 
' 
' Entrada.....: draw, demoState (False = original draw state or True = 
'               demo draw state)
' Observação..:
' Atualizações: [01]   Data: 27/06/2016 13:10   Autor: Paulo Mann
*******************************************************************************/

function changeState(draw, demoState, hideDraw)
{
	if(hideDraw)
	{
		if(demoState)
			map.removeLayer(draw);
		else
			map.addLayer(draw);
	}
}

/*******************************************************************************
' Nome........: hide
' Objetivo....: 
' 
' Entrada.....: managerDraw
' Observação..:
' Atualizações: [01]   Data: 27/06/2016 13:10   Autor: Paulo Mann
*******************************************************************************/

function hide(managerDraw)
{
	if(!managerDraw.hide)
	{
		managerDraw.hide = true;
		managerDraw.group.eachLayer(function (layer) 
		{
			changeState(layer, true, managerDraw.hide);
		});
	}
	else
	{
		managerDraw.group.eachLayer(function (layer)
		{
			changeState(layer, false, managerDraw.hide);
		});
		managerDraw.hide = false;
	}
	return managerDraw;
}

/*******************************************************************************
' Ajuste de variaveis globais
*******************************************************************************/

var srcIcon = L.icon({
    iconUrl: '../../leaflet/images/marker-icon.png',
    shadowUrl: '../../leaflet/images/marker-shadow.png',

    iconSize:     [25, 41], // size of the icon
    shadowSize:   [41, 41], // size of the shadow
    iconAnchor:   [12, 40], // point of the icon which will correspond to marker's location
    shadowAnchor: [12, 40],  // the same for the shadow
    popupAnchor:  [12, 12]  // point from which the popup should open relative to the iconAnchor
});

srcTaxi.button = L.easyButton({
	states: [{
		stateName: 'hide-src-taxis',   // name the state
		icon:      'glyphicon glyphicon-star-empty',          // and define its properties
		title:     'Hide src taxis demo', // like its title
		onClick: function(control) 
		{  
			srcTaxi = hide(srcTaxi);
			control.state('show-src-taxis');
		}
	}, {
		stateName: 'show-src-taxis',
		icon:      'glyphicon glyphicon-star-empty',
		title:     'Hide src taxis demo',
		onClick: function(control) 
		{
			srcTaxi = hide(srcTaxi);
			control.state('hide-src-taxis');
		}
	}]
});

dstTaxi.button = L.easyButton({
	states: [{
		stateName: 'hide-dst-taxis',   // name the state
		icon:      'glyphicon glyphicon-star',          // and define its properties
		title:     'Hide dst taxis demo', // like its title
		onClick: function(control) 
		{  
			dstTaxi = hide(dstTaxi);
			control.state('show-dst-taxis');
		}
	}, {
		stateName: 'show-dst-taxis',
		icon:      'glyphicon glyphicon-star',
		title:     'Hide dst taxis demo',
		onClick: function(control) 
		{
			dstTaxi = hide(dstTaxi);
			control.state('hide-dst-taxis');
		}
	}]
});

arrow.button = L.easyButton({
	states: [{
		stateName: 'hide-arrows',   // name the state
		icon:      'glyphicon glyphicon-arrow-up',          // and define its properties
		title:     'Hide arrows demo', // like its title
		onClick: function(control) 
		{  
			arrow = hide(arrow);
			control.state('show-arrows');
		}
	}, {
		stateName: 'show-arrows',
		icon:      'glyphicon glyphicon-arrow-up',
		title:     'Hide arrows demo',
		onClick: function(control) 
		{
			arrow = hide(arrow);
			control.state('hide-arrows');
		}
	}]
});

square.button = L.easyButton({
	states: [{
		stateName: 'hide-squares',   // name the state
		icon:      'glyphicon glyphicon-th-large',          // and define its properties
		title:     'Hide squares demo', // like its title
		onClick: function(control) 
		{  
			square = hide(square);
			control.state('show-squares');
		}
	}, {
		stateName: 'show-squares',
		icon:      'glyphicon glyphicon-th-large',
		title:     'Hide squares demo',
		onClick: function(control) 
		{
			square = hide(square);
			control.state('hide-squares');
		}
	}]
});

circleUMax.button = L.easyButton({
	states: [{
		stateName: 'hide-circle-u-max',   // name the state
		icon:      'glyphicon glyphicon-adjust',          // and define its properties
		title:     'Hide circle u max demo', // like its title
		onClick: function(control) 
		{  
			circleUMax = hide(circleUMax);
			control.state('show-circle-u-max');
		}
	}, {
		stateName: 'show-circle-u-max',
		icon:      'glyphicon glyphicon-adjust',
		title:     'Hide circle u max demo',
		onClick: function(control) 
		{
			circleUMax = hide(circleUMax);
			control.state('hide-circle-u-max');
		}
	}]
});

circleUMin.button = L.easyButton({
	states: [{
		stateName: 'hide-circle-u-min',   // name the state
		icon:      'glyphicon glyphicon-adjust',          // and define its properties
		title:     'Hide circle u min demo', // like its title
		onClick: function(control) 
		{  
			circleUMin = hide(circleUMin);
			control.state('show-circle-u-min');
		}
	}, {
		stateName: 'show-circle-u-min',
		icon:      'glyphicon glyphicon-adjust',
		title:     'Hide circle u min demo',
		onClick: function(control) 
		{
			circleUMin = hide(circleUMin);
			control.state('hide-circle-u-min');
		}
	}]
});

circleSMax.button = L.easyButton({
	states: [{
		stateName: 'hide-circle-s-max',   // name the state
		icon:      'glyphicon glyphicon-adjust',          // and define its properties
		title:     'Hide circle s max demo', // like its title
		onClick: function(control) 
		{  
			circleSMax = hide(circleSMax);
			control.state('show-circle-s-max');
		}
	}, {
		stateName: 'show-circle-s-max',
		icon:      'glyphicon glyphicon-adjust',
		title:     'Hide circle s max demo',
		onClick: function(control) 
		{
			circleSMax = hide(circleSMax);
			control.state('hide-circle-s-max');
		}
	}]
});

circleSMin.button = L.easyButton({
	states: [{
		stateName: 'hide-circle-s-min',   // name the state
		icon:      'glyphicon glyphicon-adjust',          // and define its properties
		title:     'Hide circle s min demo', // like its title
		onClick: function(control) 
		{  
			circleSMin = hide(circleSMin);
			control.state('show-circle-s-min');
		}
	}, {
		stateName: 'show-circle-s-min',
		icon:      'glyphicon glyphicon-adjust',
		title:     'Hide circle s min demo',
		onClick: function(control) 
		{
			circleSMin = hide(circleSMin);
			control.state('hide-circle-s-min');
		}
	}]
});

/*******************************************************************************
' Nome........: setupButtons
' Objetivo....: 
' 
' Entrada.....:
' Observação..:
' Atualizações: [01]   Data: 27/06/2016 13:10   Autor: Paulo Mann
*******************************************************************************/

function setupButtons()
{
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

/*******************************************************************************
' Nome........: actionInit
' Objetivo....: Atribui ações aos botões do mapa
' 
' Entrada.....:
' Observação..:
' Atualizações: [01]   Data: 19/11/2016 20:43   Autor: Peron Rezende 
*******************************************************************************/

function actionInit() {
	srcTaxi.group = L.layerGroup();
	dstTaxi.group = L.layerGroup();
	arrow.group = L.layerGroup();
	square.group = L.layerGroup();
	circleUMax.group = L.layerGroup();
	circleUMin.group = L.layerGroup();
	circleSMax.group = L.layerGroup();
	circleSMin.group = L.layerGroup();

	loadMap();
		
	loadSquare();
	//loadTaxi();
	loadArrow();
	loadCircle();
	
	//setupButtons();
}