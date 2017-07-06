/*******************************************************************************
INFORMAÇÕES DE IDENTIFICAÇÃO DA VERSÃO
Versão: 1.0					Data: 19/11/2016 23:05
Objetivo/Manutenção: Separar variáveis globais
Autor: Peron Rezende
*******************************************************************************/

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
