package br.com.taxi.exception;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;

public class ErroTaxi extends Exception {

	private static final long serialVersionUID = -3068927175373415823L;

	private static final Logger LOG = Logger.getLogger(ErroTaxi.class);

	private final String message;
	private String mensagemUsuario;
	private Object[] parametrosMensagemUsuario;
	private String info;
	private Throwable exception;

	public ErroTaxi(String mensagemInterna, Throwable exception) {
		super(mensagemInterna, exception);
		this.exception = exception;
		this.message = obterOrigemDoStackTrace(exception, mensagemInterna);
		salvaLog();
	}

	public ErroTaxi(String mensagemInterna, Throwable exception, String mensagemUsuario, String... parametrosMensagemUsuario) {
		super(mensagemInterna, exception);
		this.message = obterOrigemDoStackTrace(exception, mensagemInterna);
		this.mensagemUsuario = mensagemUsuario;
		this.parametrosMensagemUsuario = parametrosMensagemUsuario;
		this.exception = exception;
		salvaLog();
	}

	public ErroTaxi(String mensagemInterna, String mensagemUsuario, String... parametrosMensagemUsuario) {
		super(mensagemInterna);
		this.message = mensagemInterna;
		this.mensagemUsuario = mensagemUsuario;
		this.parametrosMensagemUsuario = parametrosMensagemUsuario;
		salvaLog();
	}

	public String getMensagemUsuario() {
		if (mensagemUsuario == null) {
			return "operacao.nao.realizada";
		}
		return mensagemUsuario;
	}

	public Object[] getParametrosMensagemUsuario() {
		if (parametrosMensagemUsuario == null) {
			parametrosMensagemUsuario = new Object[0];
		}
		return parametrosMensagemUsuario;
	}

	public String getTipoRetorno() {
		return "error";
	}

	public ErroTaxi info(String info) {
		this.info = info;
		return this;
	}

	@Override
	public String getMessage() {
		if (info != null) {
			return message + " - " + info;
		}
		return message;
	}

	private String obterOrigemDoStackTrace(Throwable e, String mensagemInterna) {
		String stacktrace = ExceptionUtils.getRootCauseMessage(e);
		return mensagemInterna + " | " + stacktrace;
	}

	private void salvaLog() {
		LOG.error(message, exception);
	}

}
