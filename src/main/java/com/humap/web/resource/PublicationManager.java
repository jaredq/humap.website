/**
 * Created by jaredqin@gmail.com
 */
package com.humap.web.resource;

import java.util.List;

/**
 * The Interface PublicationManager.
 */
public interface PublicationManager {

	/**
	 * Find all publications.
	 * 
	 * @return the list
	 */
	List<PublicationYearItem> findAllPublicationYears();
}
