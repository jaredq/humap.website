/**
9iu * Created by jaredqin@gmail.com
 */
package com.humap.web.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * The Class ProductManagerImpl.
 * 
 * @author 1218
 */
public class ProductManagerImpl implements ProductManager {

	/** The product dao. */
	@Autowired
	private ProductDAO productDAO;

	@Override
	public ProductItem findByID(int id) {
		ProductItem item = productDAO.findByID(id);
		return item;
	}

	@Override
	public SearchResult findByParam(SearchParam searchParam) {
		SearchResult sr = new SearchResult();
		int total = productDAO.findTotalBySearchParam(searchParam);
		List<ProductItem> list = productDAO.findBySearchParam(searchParam);
		sr.setResultList(list);
		sr.setBeginRow(searchParam.getBeginRow());
		sr.setRowCount(searchParam.getRowCount());
		sr.setTotalRowCount(total);
		return sr;
	}

}
