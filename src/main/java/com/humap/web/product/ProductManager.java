/**
 * Created by jaredqin@gmail.com
 */
package com.humap.web.product;

/**
 * @author 1218
 * 
 */
public interface ProductManager {

	/**
	 * Find by id.
	 * 
	 * @param id
	 *            the id
	 * @return the product item
	 */
	ProductItem findByID(int id);

	/**
	 * Find all.
	 * 
	 * @param searchParam
	 *            the search param
	 * @return the search result
	 */
	SearchResult findByParam(SearchParam searchParam);
}
