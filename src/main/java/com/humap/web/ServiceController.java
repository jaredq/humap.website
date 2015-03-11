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

import com.humap.web.commons.helpers.ModelHelper;

/**
 * Handles requests for the application service page.
 */
@Controller
public class ServiceController {

	private static final Logger logger = LoggerFactory
			.getLogger(ServiceController.class);

	/**
	 * Simply selects the customized-service view to render by returning its name.
	 */
	@RequestMapping(value = "/customized-service", method = RequestMethod.GET)
	public String customizedService(Locale locale, Model model) {
		logger.info(
				"String customizedService(Locale locale, Model model) - The client locale is {}.",
				locale);

		ModelHelper.addAttrServerTime(model, locale);

		return "customized-service";
	}

}
