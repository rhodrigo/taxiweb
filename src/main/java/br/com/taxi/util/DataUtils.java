package br.com.taxi.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;

public class DataUtils {

	private DataUtils() {
	}

	public static final String DD_MM_YYYY = "dd/MM/yyyy";

	public static final String DD_MM_YYYY_HH_MM = "dd/MM/yyyy HH:mm";

	public static final String HH_MM = "HH:mm";

	public static final String DD_MM_YYYY_TRACOS = "dd-MM-yyyy";

	/**
	 * Converte uma String para um objeto Date. Caso a String seja vazia ou nula, retorna null - para facilitar em casos
	 * onde formulários podem ter campos de datas vazios.
	 * 
	 * @param data
	 *            String no formato dd/MM/yyyy a ser formatada
	 * @return Date Objeto Date ou null caso receba uma String vazia ou nula
	 * @throws ParseException
	 * @throws Exception
	 *             Caso a String esteja no formato errado
	 */
	public static Date formataData(String data, String formato) throws ParseException {

		if (StringUtils.isBlank(data)) {
			return null;
		}

		Date date = null;

		SimpleDateFormat format = new SimpleDateFormat(formato);
		format.setLenient(false);
		format.setTimeZone(TimeZone.getTimeZone("GMT-3"));
		date = format.parse(data);

		return date;
	}

	public static boolean primeiraDataMenorQueSegunda(Date dataAVerificar, Date dataParametro) {

		Calendar calendarDataParaVerificar = Calendar.getInstance();
		calendarDataParaVerificar.setTime(dataAVerificar);

		Calendar calendarDataParametro = Calendar.getInstance();
		calendarDataParametro.setTime(dataParametro);

		int comparacao = calendarDataParaVerificar.compareTo(calendarDataParametro);

		if (comparacao >= 0 || isMesmoDia(calendarDataParaVerificar, calendarDataParametro)) {
			return false;
		}
		return true;
	}

	public static boolean primeiraDataMenorOuIgualSegunda(Date dataAVerificar, Date dataParametro) {

		Calendar calendarDataParaVerificar = Calendar.getInstance();
		calendarDataParaVerificar.setTime(dataAVerificar);

		Calendar calendarDataParametro = Calendar.getInstance();
		calendarDataParametro.setTime(dataParametro);

		int comparacao = calendarDataParaVerificar.compareTo(calendarDataParametro);

		if (isMesmoDia(dataAVerificar, dataParametro)) {
			return true;
		}

		if (comparacao > 0) {
			return false;
		}
		return true;
	}

	public static boolean isMesmoDia(Calendar data1, Calendar data2) {
		return data1.get(Calendar.DAY_OF_MONTH) == data2.get(Calendar.DAY_OF_MONTH) && data1.get(Calendar.MONTH) == data2.get(Calendar.MONTH) && data1.get(Calendar.YEAR) == data2.get(Calendar.YEAR);
	}

	public static boolean isMesmoDia(Date primeiraData, Date segundaData) {
		Calendar data1 = Calendar.getInstance();
		data1.setTime(primeiraData);
		Calendar data2 = Calendar.getInstance();
		data2.setTime(segundaData);
		return isMesmoDia(data1, data2);
	}

	public static boolean dateEhMaiorDataAtual(Date data) {
		Calendar dataAtual = Calendar.getInstance();
		return data.after(dataAtual.getTime());
	}

	public static Date converteStringParaDate(String data) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		format.setLenient(false);
		return format.parse(data);
	}

	public static Date obterDataAtualMenosMeses(int mesesParaSubtrair) {
		Calendar dataAtual = Calendar.getInstance();
		dataAtual.add(Calendar.MONTH, -(mesesParaSubtrair));

		dataAtual.set(Calendar.HOUR, 0);
		dataAtual.set(Calendar.MINUTE, 0);
		dataAtual.set(Calendar.SECOND, 0);

		final Calendar dataAtualSubtraida = dataAtual;
		return dataAtualSubtraida.getTime();
	}

	public static Date obterDataAVerificarMenosMeses(int mesesParaSubtrair, Date dataParametro) {
		Calendar data = Calendar.getInstance();
		data.setTime(dataParametro);
		data.add(Calendar.MONTH, -(mesesParaSubtrair));

		final Calendar dataAtualSubtraida = data;
		return dataAtualSubtraida.getTime();
	}

	public static String format(java.util.Date data, String format) {
		SimpleDateFormat formato = obterFormato(format);

		if (data != null) {
			return formato.format(data);
		}
		return "";
	}

	private static SimpleDateFormat obterFormato(String formato) {
		return new SimpleDateFormat(formato);
	}

	public static boolean possuiFormatoDeDataValido(String data, String formato) {
		try {
			formataData(data, formato);
			return true;
		} catch (ParseException e) {
			return false;
		}

	}

	public static boolean dateEhMenorOuIgualDataAtual(Date dataAcesso) {
		Calendar dataAtual = Calendar.getInstance();
		return dataAcesso.before(dataAtual.getTime()) || isMesmoDia(dataAcesso, dataAtual.getTime());
	}

	public static boolean isMesmoDia(DateTime data1, DateTime data2) {
		return data1.withTimeAtStartOfDay().isEqual(data2.withTimeAtStartOfDay());
	}


}
