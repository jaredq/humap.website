/**
 * Created by jaredqin@gmail.com
 */
package com.humap.web.resource;

import java.util.List;

/**
 * The Interface PublicationDAO.
 */
public interface PublicationDAO {

	/**
	 * Find all publications.
	 * 
	 * @return the list
	 */
	List<PublicationItem> findAllPublications();

}
