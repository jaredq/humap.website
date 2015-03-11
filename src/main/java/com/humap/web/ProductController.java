/**
 * Created by jaredqin@gmail.com
 */
package com.humap.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.humap.web.commons.dict.DictConstants;
import com.humap.web.commons.dict.DictItem;
import com.humap.web.commons.dict.UniversalDictDAO;
import com.humap.web.commons.helpers.ModelHelper;
import com.humap.web.product.ProductItem;
import com.humap.web.product.ProductManager;
import com.humap.web.product.SearchParam;
import com.humap.web.product.SearchResult;

/**
 * Handles requests for the "Product" page.
 * 
 * @author 1218
 * 
 */
@Controller
public final class ProductController {

	/** The Constant ROW_COUNT_PER_PAGE. */
	private static final int ROW_COUNT_PER_PAGE = 5;

	/** The Constant BEGIN_ROW_NUM. */
	private static final int BEGIN_ROW_NUM = 0;

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	/** The product manager. */
	@Autowired
	private ProductManager productManager;

	/** The universal dict dao. */
	@Autowired
	private UniversalDictDAO universalDictDAO;

	/**
	 * default Search Product page.
	 * 
	 * @param locale
	 *            the locale
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(value = "/search-product", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchProduct(Locale locale, Model model,
			@RequestParam(value = "pageNum", required = false) String pageNumStr,
			@RequestParam(value = "searchKey", required = false) String searchKey) {
		logger.info("String searchProduct(Locale locale, Model model) - The client locale is {}.",
				locale);

		return searchProduct(locale, model, null, pageNumStr, searchKey);
	}

	/**
	 * Search product.
	 * 
	 * @param locale
	 *            the locale
	 * @param model
	 *            the model
	 * @param searchOptionsStr
	 *            the search options str
	 * @param pageNumStr
	 *            the page num str
	 * @param searchKey
	 *            the search key
	 * @return the string
	 */
	@RequestMapping(value = "/search-product-{searchOptions}", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String searchProduct(Locale locale, Model model,
			@PathVariable("searchOptions") String searchOptionsStr,
			@RequestParam(value = "pageNum", required = false) String pageNumStr,
			@RequestParam(value = "searchKey", required = false) String searchKey) {

		logger.info("String searchProductByParameters(Locale, Model, String, String, String, String)");

		SearchParam searchParam = new SearchParam();
		if (!StringUtils.isBlank(searchOptionsStr)) {
			String[] searchOptions = searchOptionsStr.split("-");
			for (String so : searchOptions) {
				if (so.startsWith("c")) {
					searchParam.getCoresCaseSet().add(so.substring(1));
				} else if (so.startsWith("p")) {
					searchParam.getPathDiagSet().add(so.substring(1));
				} else if (so.startsWith("i")) {
					searchParam.getInforSet().add(so.substring(1));
				} else {
					searchParam.setOrganID(so);
				}
			}
		}

		if (searchKey != null) {
			searchKey = ModelHelper.filterParam(searchKey);
			searchKey = searchKey.trim();
		}
		searchParam.setSearchKey(searchKey);

		searchParam.setRowCount(ROW_COUNT_PER_PAGE);
		int beginRow = BEGIN_ROW_NUM;
		if (!StringUtils.isBlank(pageNumStr)) {
			try {
				int pageNum = Integer.parseInt(pageNumStr);
				if (pageNum < 1 || pageNum > 200) {
					pageNum = 1;
				}
				beginRow = ROW_COUNT_PER_PAGE * (pageNum - 1);
			} catch (NumberFormatException e) {
				beginRow = BEGIN_ROW_NUM;
			}
		}
		searchParam.setBeginRow(beginRow);

		SearchResult searchResult = productManager.findByParam(searchParam);
		model.addAttribute("searchResult", searchResult);

		model.addAttribute("searchParam", searchParam);
		model.addAttribute("corescaseSetStr", createOptionSetStr(searchParam.getCoresCaseSet()));
		model.addAttribute("pathdiagSetStr", createOptionSetStr(searchParam.getPathDiagSet()));
		model.addAttribute("inforSetStr", createOptionSetStr(searchParam.getInforSet()));

		int pageNum = beginRow / ROW_COUNT_PER_PAGE + 1;
		model.addAttribute("pageNum", pageNum);

		int totalPage = (searchResult.getTotalRowCount() - 1) / ROW_COUNT_PER_PAGE + 1;
		model.addAttribute("totalPage", totalPage);

		List<DictItem> dictItemList = universalDictDAO.findAll();

		List<DictItem> organList = new ArrayList<DictItem>();
		List<DictItem> corescaseList = new ArrayList<DictItem>();
		List<DictItem> pathdiagList = new ArrayList<DictItem>();
		List<DictItem> inforList = new ArrayList<DictItem>();
		for (DictItem dictItem : dictItemList) {
			switch (dictItem.getType()) {
			case DictConstants.DICTTYPE_ORGAN:
				organList.add(dictItem);
				break;
			case DictConstants.DICTTYPE_CORESCASE:
				corescaseList.add(dictItem);
				break;
			case DictConstants.DICTTYPE_PATHDIAG:
				pathdiagList.add(dictItem);
				break;
			case DictConstants.DICTTYPE_INFOR:
				inforList.add(dictItem);
				break;
			default:
				;
			}
		}

		model.addAttribute("organList", organList);
		model.addAttribute("corescaseList", corescaseList);
		model.addAttribute("pathdiagList", pathdiagList);
		model.addAttribute("inforList", inforList);

		return "search-product";
	}

	/**
	 * Creates the option set str.
	 * 
	 * @param optionSet
	 *            the option set
	 * @return the string
	 */
	private String createOptionSetStr(Set<String> optionSet) {
		String optionSetStr = null;
		if (!CollectionUtils.isEmpty(optionSet)) {
			optionSetStr = "|";
			for (String opt : optionSet) {
				optionSetStr += opt + "|";
			}
		}
		return optionSetStr;
	}

	/**
	 * Show Product page with the productID.
	 * 
	 * @param locale
	 *            the locale
	 * @param model
	 *            the model
	 * @param productID
	 *            the product id
	 * @return the string
	 */
	@RequestMapping(value = "/show-product-{productID}", method = RequestMethod.GET)
	public String showProductByID(Locale locale, Model model,
			@PathVariable("productID") String productIDStr) {
		logger.info("String searchProduct(Locale locale, String productID=[{}], Model model)");

		List<DictItem> organList = universalDictDAO.findAllByType(DictConstants.DICTTYPE_ORGAN);
		model.addAttribute("organList", organList);

		try {
			int productID = Integer.parseInt(productIDStr);
			ProductItem item = productManager.findByID(productID);
			model.addAttribute("productItem", item);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		return "show-product";
	}
}
