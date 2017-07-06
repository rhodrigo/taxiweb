package br.com.taxi.util;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

public class MessagePropertiesUtils {

	private MessagePropertiesUtils() {
	}

	private static final String MESSAGES_PROPERTIES = "messages";

	private static final ResourceBundle BUNDLE = ResourceBundle.getBundle(MESSAGES_PROPERTIES);

	private static final Logger LOG = Logger.getLogger(MessagePropertiesUtils.class);

	private static Map<String, String> propertiesList = new HashMap<String, String>();

	public static String getMessage(String key) {

		try {

			return BUNDLE.getString(key);

		} catch (Exception e) {
			LOG.error("Chave " + key + " não encontrada", e);
			return key;
		}
	}

	public static String getMessage(String key, String... parameters) throws ConfigurationException {

		String message = BUNDLE.getString(key);

		for (int i = 0; i < parameters.length; i++) {

			if (parameters[i] == null) {
				throw new IllegalArgumentException("Parâmetro não pode ser nulo para mensagem com chave: " + key);
			}

			message = message.replace("{" + i + "}", parameters[i]);
		}

		return message;

	}

	public static Map<String, String> getPropertiesList() {
		if (propertiesList.isEmpty()) {
			propertiesList = convertResourceBundleToMap(BUNDLE);
		}
		return propertiesList;
	}

	private static Map<String, String> convertResourceBundleToMap(ResourceBundle resource) {
		Map<String, String> map = new HashMap<String, String>();

		Enumeration<String> keys = resource.getKeys();
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			map.put(key, StringUtils.trim(resource.getString(key)));
		}

		return map;
	}

}
