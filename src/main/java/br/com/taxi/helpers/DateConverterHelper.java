package br.com.taxi.helpers;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import br.com.caelum.vraptor.Convert;
import br.com.caelum.vraptor.Converter;
import br.com.caelum.vraptor.converter.ConversionError;
import br.com.caelum.vraptor.ioc.ApplicationScoped;

@Convert(Date.class)
@ApplicationScoped
public class DateConverterHelper implements Converter<Date> {

	public Date convert(String value, Class<? extends Date> type, ResourceBundle bundle) {
		if (value == null || value.equals("")) {
			return null;
		}
		try {
				
			DateFormat format;
			
			if(value.length() == 10){
				format = new SimpleDateFormat("dd/MM/yyyy");
			}else if(value.length() == 16){
				format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			}else{
				format = new SimpleDateFormat("dd/MM/yyyy");
			}
			
			format.setLenient(false);
			return (Date) format.parse(value);

		} catch (ParseException e) {
			throw new ConversionError(MessageFormat.format(bundle.getString("is_not_a_valid_date"), value));
		}
	}

}
