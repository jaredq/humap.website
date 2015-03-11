/**
 * Created by jaredqin@gmail.com
 */
package com.humap.web.commons.dict;

import java.util.List;

/**
 * The Interface UniversalDictDAO.
 * 
 * @author 1218
 */
public interface UniversalDictDAO {

	/**
	 * Find all.
	 * 
	 * @return the list
	 */
	List<DictItem> findAll();

	/**
	 * Find all by type.
	 * 
	 * @param type
	 *            the type
	 * @return the list
	 */
	List<DictItem> findAllByType(int type);
}
