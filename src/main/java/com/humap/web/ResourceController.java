/**
 * Created by jaredqin@gmail.com
 */
package com.humap.web;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.humap.web.resource.PublicationManager;

/**
 * Handles requests for the "Resources" page.
 * 
 * @author 1218
 * 
 */
@Controller
public class ResourceController {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(ResourceController.class);

	/** The publication manager. */
	@Autowired
	private PublicationManager publicationManager;

	/**
	 * List general publications.
	 * 
	 * @param locale
	 *            the locale
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(value = "/general-publications", method = RequestMethod.GET)
	public String listGeneralPublications(Locale locale, Model model) {
		logger.info(
				"String listGeneralPublications(Locale locale, Model model) - The client locale is {}.",
				locale);
		model.addAttribute("gpYearList", publicationManager.findAllPublicationYears());
		return "list-general-publications";
	}

	/**
	 * News list page
	 * 
	 * @param locale
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/news", method = RequestMethod.GET)
	public String listNews(Locale locale, Model model) {
		logger.info("String listNews(Locale locale, Model model) - The client locale is {}.",
				locale);

		return "list-news";
	}

	/**
	 * News detail page.
	 * 
	 * @param locale
	 *            the locale
	 * @param model
	 *            the model
	 * @param title
	 *            the title
	 * @return the string
	 */
	@RequestMapping(value = "/news-{title}", method = RequestMethod.GET)
	public String showNews(Locale locale, Model model, @PathVariable("title") String title) {
		logger.info("String showNews(Locale locale, Model model) - The client locale is {}.",
				locale);

		// TODO improve
		if (title != null && (title.contains(".") || title.contains("/") || title.contains("\\"))) {
			title = title.replace(".", "").replace("/", "").replace("\\", "");
		}
		return "news-" + title;
	}

}
