<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="menu-ativo">

<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- jquery -->
<script src="js/jquery.js"></script>

<!-- leaflet -->
<link rel="stylesheet" href="leaflet/leaflet.css">
<script src="leaflet/leaflet.js"></script>

<!-- easy-button -->
<script src="js/easy-button.js"></script>

<!-- leaflet route -->
<link rel="stylesheet" href="routing/leaflet-routing-machine.css" />
<script src="routing/leaflet-routing-machine.js"></script>

<!-- bootstrap -->
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css" />
<link rel="stylesheet" href="css/estilo.css" />
<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

<!-- actions -->
<script src="js/app.js"></script>

<title>Mapas & Taxis</title>
</head>

<body class="mapa-principal-ativo">

	<div class="message-loader" style="display: none;">
		<img src="img/loader_tela.gif" />
		<span>Aguarde a geração dos Mapas...</span>
	</div>
	
	<nav class="menu-nav">
		<div class="row topo">
			<div class="col-sm-2">
				<div class="barra-titulo">
					<button class="menu-abrir">Abre Menu</button>
					<span class="titulo">Mapas & Taxis</span>
				</div>
			</div>
			<div class="col-sm-8" style="text-align: center;">
				<ul class="pagination" style="display: none;">
					<li><a href="#" class="previus" style="display: none;"> <span aria-hidden="true">«</span></a></li>
					<li><a href="#" class="previus" style="display: none;">Anterior</a></li>
					<li><a href="#" class="next">Próximo</a></li>
					<li><a href="#" class="next"> <span aria-hidden="true">»</span>
					</a></li>
				</ul>
			</div>
			<div class="col-sm-2"></div>
		</div>	
	</nav>

	<nav class="barra-nav">

		<form class="form-horizontal" method="post" action="${urlContext}/coordenadas" id="filter-map">

			<input type="hidden" name="filtro.zoom" value="13" id="inputZoom" />

			<div class="radio">
				<label> <input class="control-label tipoMapa" id="tipo-densidade" type="radio" name="filtro.tipo" value="densidade" checked>Visão Conjunta</label>
			</div>
			<div class="radio">
				<label> <input class="control-label tipoMapa" id="tipo-deslocamento" type="radio" name="filtro.tipo" value="deslocamento">Deslocamento</label>
			</div>

			<div class="form-group">
				<label for="inputDDD" class="control-label">DDD</label> <input type="text" class="form-control" name="filtro.ddd" id="inputDDD" placeholder="DDD" value="21">
			</div>
			<div class="form-group">
				<label for="inputDataInicio" class="control-label">Data de Início</label> <input type="text" class="form-control" name="filtro.dataInicio" id="inputDataInicio" placeholder="Data de Início"
					value="22/06/2016 12:00">
			</div>
			<div class="form-group">
				<label for="inputDataFim" class="control-label">Data de Fim</label> <input type="text" class="form-control" name="filtro.dataFim" id="inputDataFim" placeholder="Data de Fim"
					value="22/06/2016 12:30">
			</div>
			<div class="form-group">
				<label for="inputTamanho" class="control-label">Tamanho Lateral</label> <input type="text" class="form-control" name="filtro.tamanho" id="inputTamanho" placeholder="Tamanho" value="1000">
			</div>
			<div class="form-group">
				<label for="inputQuantidadeMapas" class="control-label">Quantidade de Mapas</label> <input type="text" class="form-control" name="filtro.quantidadeMapas" id="inputQuantidadeMapas"
					placeholder="Tamanho" value="10">
			</div>
			<div class="form-group">
				<label for="inputVizinhos" class="control-label">Abrangência</label> <input type="text" class="form-control" name="filtro.vizinhos" id="inputVizinhos" placeholder="Vizinhos" value="2">
			</div>
			<div class="form-group">
				<label for="inputLatitude" class="control-label">Latitude</label> <input type="text" class="form-control" name="filtro.latitude" id="inputLatitude" placeholder="Latitude" value="-22.90">
			</div>
			<div class="form-group">
				<label for="inputLongitude" class="control-label">Longitude</label> <input type="text" class="form-control" name="filtro.longitude" id="inputLongitude" placeholder="Longitude" value="-43.25">
			</div>
			<div class="form-group">
				<div class="col-sm-4">
					<button type="submit" class="btn btn-primary btn-sm" id="btn-gerar">Gerar</button>
				</div>
				<div class="col-sm-4">
					<button type="button" class="btn btn-danger btn-sm" id="btn-limpa-filtro">Limpar Filtros</button>
				</div>
			</div>
		</form>

	</nav>

	<div class="container-fluid">


		<div class="row mapa-principal">
			<div class="col-sm-12 mapa-principal">
				<div id="mapa-principal" class="map" style="width: 100%; height: 100%; position: relative; outline: none;"></div>
			</div>
		</div>
		<div class="row mapa-secundario">
			<div class="col-sm-4 mapa-secundario">
				<span class="titulo"></span>
				<div id="mapa-1" class="map" ></div>
			</div>
			<div class="col-sm-4 mapa-secundario">
				<span class="titulo"></span>
				<div id="mapa-2" class="map" ></div>
			</div>
			<div class="col-sm-4 mapa-secundario">
				<span class="titulo">Mapa de Deslocamento</span>
				<div id="mapa-3" class="map" ></div>
			</div>
		</div>

	</div>
</body>
</html>

