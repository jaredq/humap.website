/**
 * Created by jaredqin@gmail.com
 */
package com.humap.web.resource;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;

import com.humap.web.commons.dao.BaseDAOImpl;
import com.humap.web.product.ProductItem;
import com.humap.web.product.ResourceItem;

/**
 * The Class PublicationDAOImpl.
 */
public class PublicationDAOImpl extends BaseDAOImpl implements PublicationDAO {

	/** The Constant SQL_TBL_REF_PRODUCT_RESOURCE. */
	private static final String SQL_TBL_REF_PRODUCT_RESOURCE = "`tbl_ref_product_resource`";

	/** The Constant SQL_COLUMNLIST_PRODUCT_RESOURCE. */
	private static final String SQL_COLUMNLIST_PRODUCT_RESOURCE = "`productid`, `resourceid`"
			+ ", `filepath`, `name`";

	/** The Constant RESOURCE_TYPE_GENERAL_PUBLICATION. */
	private static final int RESOURCE_TYPE_GENERAL_PUBLICATION = 3;

	@Override
	public List<PublicationItem> findAllPublications() {
		String sql = "select " + SQL_COLUMNLIST_PRODUCT_RESOURCE + " from "
				+ SQL_TBL_REF_PRODUCT_RESOURCE + " where type=" + RESOURCE_TYPE_GENERAL_PUBLICATION
				+ " order by productid desc, sort asc ";
		List<PublicationItem> list = getJdbcTemplate().query(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
			}
		}, new RowMapper<PublicationItem>() {

			@Override
			public PublicationItem mapRow(ResultSet rs, int rowNum) throws SQLException {
				return extractPublicationItem(rs);
			}
		});

		return list;
	}

	/**
	 * Extract publication item.
	 * 
	 * @param rs
	 *            the rs
	 * @return the publication item
	 * @throws SQLException
	 */
	protected PublicationItem extractPublicationItem(ResultSet rs) throws SQLException {
		int i = 0;
		PublicationItem item = new PublicationItem();
		item.setYear(rs.getString(++i));
		item.setId(rs.getString(++i));
		item.setUrl(rs.getString(++i));
		item.setName(rs.getString(++i));
		return item;
	}

}
