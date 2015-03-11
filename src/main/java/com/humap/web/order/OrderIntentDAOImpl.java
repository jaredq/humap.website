/**
 * Created by jaredqin@gmail.com
 */
package com.humap.web.order;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.PreparedStatementSetter;

import com.humap.web.commons.dao.BaseDAOImpl;

/**
 * The Class OrderIntentDAOImpl.
 * 
 * @author 1218
 */
public class OrderIntentDAOImpl extends BaseDAOImpl implements OrderIntentDAO {

	/** The Constant SQL_TBL_DATA_ORDER_INTENT. */
	private static final String SQL_TBL_DATA_ORDER_INTENT = "`tbl_data_order_intent`";

	/** The Constant SQL_COLLIST_TBL_DATA_ORDER_INTENT. */
	private static final String SQL_COLLIST_TBL_DATA_ORDER_INTENT = "`id`, `title`, `firstname`"
			+ ", `lastname`, `email`, `phone`, `organization`, `remark`, `createtime";

	/** The Constant SQL_COLLIST_TBL_DATA_ORDER_INTENT_INS. */
	private static final String SQL_COLLIST_TBL_DATA_ORDER_INTENT_INS = "`title`, `firstname`"
			+ ", `lastname`, `email`, `phone`, `organization`, `remark`";

	/**
	 * Find all.
	 * 
	 * @param beginRow
	 *            the begin row
	 * @param rowCount
	 *            the row count
	 * @return the list
	 */
	public List<OrderIntentItem> findAll(final int beginRow, final int rowCount) {
		// TODO
		return null;
	}

	/**
	 * Find total.
	 * 
	 * @return the int
	 */
	public int findTotal() {
		// TODO
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.humap.web.order.OrderIntentDAO#saveOrderIntent(com.humap.web.order
	 * .OrderIntentFO)
	 */
	@Override
	public int saveOrderIntent(final OrderIntentItem orderIntetnItem) {
		return getJdbcTemplate().update(
				"INSERT INTO " + SQL_TBL_DATA_ORDER_INTENT + "("
						+ SQL_COLLIST_TBL_DATA_ORDER_INTENT_INS + ") VALUES (?,?,?,?,?,?,?)",
				new PreparedStatementSetter() {

					@Override
					public void setValues(PreparedStatement ps) throws SQLException {
						int i = 0;
						ps.setString(++i, orderIntetnItem.getTitle());
						ps.setString(++i, orderIntetnItem.getFirstName());
						ps.setString(++i, orderIntetnItem.getLastName());
						ps.setString(++i, orderIntetnItem.getEmail());
						ps.setString(++i, orderIntetnItem.getPhone());
						ps.setString(++i, orderIntetnItem.getOrganization());
						ps.setString(++i, orderIntetnItem.getRemark());
					}
				});
	}
}
