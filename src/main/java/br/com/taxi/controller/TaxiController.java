package br.com.taxi.controller;

import org.apache.log4j.Logger;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.view.Results;
import br.com.taxi.exception.ErroTaxi;
import br.com.taxi.model.Filtro;
import br.com.taxi.model.Mapas;
import br.uff.ic.taxi.App;
import br.uff.ic.taxi.Config;

@Resource
public class TaxiController extends GenericController {

	private static final Logger LOG = Logger.getLogger(TaxiController.class);

	protected TaxiController(Result result, Validator validator) {
		super(result, validator);
	}

	@Get("/")
	public void index() {
	}

	@Post("/coordenadas")
	public void coordenadas(Filtro filtro) {
		try {

			validator.onErrorUse(Results.json()).withoutRoot().from(validator.getErrors()).serialize();

			Config config = new Config(filtro);
			Mapas mapas = new App().geraMapaWeb(config);

			result.use(Results.json()).withoutRoot().from(mapas).recursive().serialize();

		} catch (ErroTaxi e) {
			LOG.error("Erro ao listar pontos", e);
			retornaMensagemDeErroPadraoEmJSON();
		}
	}

}
