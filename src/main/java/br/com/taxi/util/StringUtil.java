package br.com.taxi.util;

import java.text.Normalizer;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.text.MaskFormatter;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

public class StringUtil {

	private static final Logger LOG = Logger.getLogger(StringUtil.class);

	private StringUtil() {
	}

	public static String extrairTermoComRegex(String linha, String regex) {

		final Pattern pattern = Pattern.compile(regex);
		final Matcher matcher = pattern.matcher(linha);

		final StringBuilder builder = new StringBuilder();

		while (matcher.find()) {
			builder.append(StringUtils.trim(matcher.group(matcher.groupCount())));
		}

		return builder.toString();
	}

	public static String extraiNumeros(String valor) {
		if (valor == null) {
			return null;
		}
		return extrairTermoComRegex(valor, "[0-9]");
	}

	public static Long converteParaLong(String valor) {

		if (valor == null) {
			return null;
		}

		valor = extrairTermoComRegex(valor, "[0-9]*");

		if (StringUtils.isNumeric(valor) && !StringUtils.isBlank(valor)) {
			return Long.parseLong(valor);
		}

		return null;

	}

	public static String format(String pattern, String value) {
		if (value == null) {
			return "";
		}

		try {
			MaskFormatter mask = new MaskFormatter(pattern);
			mask.setValueContainsLiteralCharacters(false);
			return mask.valueToString(value);
		} catch (Exception e) {
			LOG.error("Erro ao converter: " + value, e);
			return value;
		}
	}

	public static String removeCaracteresNaoNumericos(String valor) {
		if (valor == null) {
			return null;
		}
		return valor.replaceAll("[^0-9]", "");
	}

	public static String extraiPrimeiroValorNumericoDe(String... textosComNumeros) {

		if (textosComNumeros == null) {
			return null;
		}

		for (String telefone : textosComNumeros) {

			String numero = StringUtil.removeCaracteresNaoNumericos(telefone);

			if (!StringUtils.isBlank(numero)) {
				return numero;
			}
		}

		return null;
	}

	public static String substituiEspacoBranco(String texto) {
		texto = Normalizer.normalize(texto, Normalizer.Form.NFD);
		texto = texto.replaceAll("[^\\p{ASCII}]", "");
		return texto;
	}

	/**
	 * 
	 * Converte uma lista em um texto descritivo
	 * 
	 * @param List
	 *            <String> lista
	 * @return String
	 * 
	 *         O retorno ficará com o seguinte layout: [ ELEMENTO1 , ELEMENTO2 ]
	 * 
	 */
	public static String obterDescricaoDeLista(List<String> lista) {

		StringBuilder builder = new StringBuilder();
		builder.append("[");

		for (String extensao : lista) {
			builder.append(" " + extensao.toUpperCase() + " ");
		}

		builder.append("]");
		return builder.toString();
	}

	public static String extrairData(String data) {

		String[] splitData = data.split("/");
		return splitData[2];
	}

}
