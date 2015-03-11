/**
 * Created by jaredqin@gmail.com
 */
package com.humap.web.commons.dao;

import javax.sql.DataSource;

/**
 * The Class BaseDAO.
 * 
 * @author 1218
 */
public interface BaseDAO {

	/**
	 * Gets the data source.
	 * 
	 * @return the data source
	 */
	DataSource getDataSource();

}
