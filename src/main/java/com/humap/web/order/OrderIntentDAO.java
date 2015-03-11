/**
 * Created by jaredqin@gmail.com
 */
package com.humap.web.order;

import java.util.List;

/**
 * The Interface OrderIntentDAO.
 * 
 * @author 1218
 */
public interface OrderIntentDAO {

	/**
	 * Find all.
	 * 
	 * @param beginRow
	 *            the begin row
	 * @param rowCount
	 *            the row count
	 * @return the list
	 */
	List<OrderIntentItem> findAll(final int beginRow, final int rowCount);

	/**
	 * Find total.
	 * 
	 * @return the int
	 */
	int findTotal();

	/**
	 * Save order intent.
	 * 
	 * @param orderIntetnItem
	 *            the order intetn item
	 * @return the int
	 */
	int saveOrderIntent(OrderIntentItem orderIntetnItem);
}
