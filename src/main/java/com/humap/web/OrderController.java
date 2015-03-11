/**
 * Created by jaredqin@gmail.com
 */
package com.humap.web;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.math.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.humap.web.commons.helpers.ModelHelper;
import com.humap.web.order.OrderIntentFO;
import com.humap.web.order.OrderIntentManager;

/**
 * Handles requests for the application order pages.
 */
@Controller
public class OrderController {

	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

	/** The order intent manager. */
	@Autowired
	private OrderIntentManager orderIntentManager;

	/**
	 * Simply selects the order view to render by returning its name.
	 */
	@RequestMapping(value = "/order-intent", method = RequestMethod.GET)
	public String orderIntent(Locale locale, Model model, HttpSession session) {
		String serverTime = ModelHelper.getServerTime(locale);
		String orderIntentFormID = serverTime + RandomUtils.nextLong();

		logger.info("String orderIntent(Locale locale, Model model) - New client formId is {}.",
				orderIntentFormID);

		session.setAttribute("orderIntentFormID", orderIntentFormID);
		model.addAttribute("orderIntentFormID", orderIntentFormID);

		return "order-intent";
	}

	/**
	 * Simply selects the submit-order-intent view to render by returning its
	 * name.
	 * 
	 * @param locale
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/submit-order-intent", method = RequestMethod.POST)
	public String submitOrderIntent(Locale locale, Model model, HttpSession session,
			OrderIntentFO orderIntentFO) {
		logger.info("String submitOrderIntent(Locale locale, Model model, HttpSession session,"
				+ " OrderIntentFO orderIntent) - The client formId is {}.",
				orderIntentFO.getFormId());

		Object orderIntentFormIDObj = session.getAttribute("orderIntentFormID");
		try {
			if (orderIntentFormIDObj != null
					&& orderIntentFormIDObj.equals(orderIntentFO.getFormId())) {
				if (orderIntentManager.saveOrderIntent(orderIntentFO) > 0) {
					session.removeAttribute("orderIntentFormID");
					return "submit-order-intent";
				}
			}
		} catch (Exception e) {
			return "error-page";
		}
		return "error-page";
	}

	/**
	 * List order intent.
	 * 
	 * @param locale
	 *            the locale
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(value = "/list-order-intent", method = RequestMethod.GET)
	public String listOrderIntent(Locale locale, Model model) {
		logger.info(
				"String listOrderIntent(Locale locale, Model model) - The client locale is {}.",
				locale);
		return "list-order-intent";
	}
}
