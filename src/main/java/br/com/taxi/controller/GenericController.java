package br.com.taxi.controller;

import static br.com.caelum.vraptor.view.Results.json;

import java.util.Collection;
import java.util.List;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Message;
import br.com.caelum.vraptor.validator.Validations;
import br.com.taxi.exception.ErroTaxi;

public abstract class GenericController  {

	protected final Result result;
	protected final Validator validator;

	protected GenericController(Result result, Validator validator) {
		this.result = result;
		this.validator = validator;
	}

	@SuppressWarnings("unchecked")
	protected <T> void retornaErrosEmJSON(List<T> erros) {
		if(!validator.hasErrors()){
			validator.addAll((Collection<? extends Message>) erros);
		}
		validator.onErrorUse(json()).withoutRoot().from(erros).serialize();
	}
	
	protected void retornaMensagemDeErroEmJSON(final ErroTaxi e) {
		List<Message> erros = new Validations() {
			{
				that(false, "error", e.getMensagemUsuario(), e.getParametrosMensagemUsuario());
			}
		}.getErrors();
		validator.addAll(erros);
		validator.onErrorUse(json()).withoutRoot().from(erros).serialize();
	}
	
	protected void retornaMensagemDeErroPadraoEmJSON() {
		List<Message> erros = new Validations() {
			{
				that(false, "error", "operacao.nao.realizada");
			}
		}.getErrors();
		validator.addAll(erros);
		validator.onErrorUse(json()).withoutRoot().from(erros).serialize();
	}

	protected void retornaMensagemDeErroEmJSON(final String mensagem) {
		List<Message> erros = new Validations() {
			{
				that(false, "error", mensagem);
			}
		}.getErrors();
		validator.addAll(erros);
		validator.onErrorUse(json()).withoutRoot().from(erros).serialize();
	}
	
	protected void direcionaMensagemErroParaTelaDeGru(ErroTaxi e) {
		validator.add(new I18nMessage(e.getTipoRetorno(), e.getMensagemUsuario(), e.getParametrosMensagemUsuario()));
		validator.onErrorRedirectTo(TaxiController.class).index();
	}
}
