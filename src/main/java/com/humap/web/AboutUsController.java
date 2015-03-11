/**
 * Created by jaredqin@gmail.com
 */
package com.humap.web;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the "About us" page.
 * 
 * @author 1218
 * 
 */
@Controller
public class AboutUsController {

	private static final Logger logger = LoggerFactory
			.getLogger(AboutUsController.class);

	/**
	 * About us page
	 * 
	 * @param locale
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/about-us", method = RequestMethod.GET)
	public String aboutUs(Locale locale, Model model) {
		logger.info(
				"String aboutUs(Locale locale, Model model) - The client locale is {}.",
				locale);

		return "about-us";
	}

}
