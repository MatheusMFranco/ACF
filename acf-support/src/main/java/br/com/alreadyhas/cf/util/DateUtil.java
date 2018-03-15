package br.com.alreadyhas.cf.util;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * <h2>DateUtil</h2>
 * <hr />
 * <p>Useful class for a manipulation of date and objects that involve time.</p>
 * <hr />
 * 
 * @author Matheus Franco
 * @category Util
 * @version 0.1
 *
 */
public abstract class DateUtil {

	private static final String DEFAULT_LOCALE  = "pt";
	private static final String DEFAULT_COUNTRY = "Brazil";

	private DateUtil() {
		Locale.setDefault(new Locale(DEFAULT_LOCALE, DEFAULT_COUNTRY));
	}

	/**
	 * Returns the Brazilian date format.
	 * @param date for the format 
	 * @return dd/MM/yyyy
	 */
	public static String getDefaultFormat(Date date){
		return DateFormat.getDateInstance().format(date == null ? new Date() : date);
	}

	/**
	 * Returns the Brazilian date format.
	 * @return new Date in dd/MM/yyyy
	 */
	public static String getDefaultFormat(){
		return getDefaultFormat(null);
	}
}
