/**
 * Created by jaredqin@gmail.com
 */
package com.humap.web.product;

import java.util.List;

/**
 * The Interface ProductDAO.
 * 
 * @author 1218
 */
public interface ProductDAO {

	/**
	 * Find by id.
	 * 
	 * @param id
	 *            the id
	 * @return the product item
	 */
	ProductItem findByID(int id);

	/**
	 * Find by search param.
	 * 
	 * @param searchParam
	 *            the search param
	 * @return the list
	 */
	List<ProductItem> findBySearchParam(SearchParam searchParam);

	/**
	 * Find total by search param.
	 * 
	 * @param searchParam
	 *            the search param
	 * @return the int
	 */
	int findTotalBySearchParam(SearchParam searchParam);
}
