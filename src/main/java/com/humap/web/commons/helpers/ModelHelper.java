/**
 * Created by jaredqin@gmail.com
 */
package com.humap.web.commons.helpers;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.ui.Model;

/**
 * @author 1218
 * 
 */
public class ModelHelper {

	/**
	 * 
	 * @param model
	 * @param locale
	 */
	public static void addAttrServerTime(Model model, Locale locale) {
		String formattedDate = getServerTime(locale);

		model.addAttribute("serverTime", formattedDate);
	}

	/**
	 * Gets the server time.
	 * 
	 * @param locale
	 *            the locale
	 * @return the server time
	 */
	// TODO move into jqcommons-util
	public static String getServerTime(Locale locale) {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG,
				locale);

		String formattedDate = dateFormat.format(date);
		return formattedDate;
	}

	/**
	 * Filter param.
	 * 
	 * @param searchKey
	 *            the search key
	 * @return the string
	 */
	public static String filterParam(String searchKey) {
		if (searchKey == null) {
			return null;
		}
		searchKey = searchKey.replace("<", "");
		searchKey = searchKey.replace(">", "");
		// searchKey = searchKey.replace("%", "");
		// searchKey = searchKey.replace("_", "");
		searchKey = searchKey.replace("\"", "");
		searchKey = searchKey.replace("'", "");
		return searchKey;
	}
}
