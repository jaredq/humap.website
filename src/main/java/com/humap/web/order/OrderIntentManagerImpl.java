/**
 * Created by jaredqin@gmail.com
 */
package com.humap.web.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 1218
 * 
 */
public class OrderIntentManagerImpl implements OrderIntentManager {

	/** The order intent dao. */
	@Autowired
	private OrderIntentDAO orderIntentDAO;

	@Override
	@Transactional
	public int saveOrderIntent(OrderIntentFO orderIntetnFO) {
		return orderIntentDAO.saveOrderIntent(orderIntetnFO);
	}

}
