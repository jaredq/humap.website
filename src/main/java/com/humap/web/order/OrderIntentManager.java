/**
 * Created by jaredqin@gmail.com
 */
package com.humap.web.order;

/**
 * @author 1218
 * 
 */
public interface OrderIntentManager {

	/**
	 * Save order intent.
	 * 
	 * @param orderIntetnFO
	 *            the order intetn fo
	 * @return the int
	 */
	int saveOrderIntent(OrderIntentFO orderIntetnFO);
}
