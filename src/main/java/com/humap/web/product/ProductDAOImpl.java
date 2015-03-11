/**
 * Created by jaredqin@gmail.com
 */
package com.humap.web.product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.util.CollectionUtils;

import com.humap.web.commons.dao.BaseDAOImpl;

/**
 * The Class ProductDAOImpl.
 * 
 * @author 1218
 */
public class ProductDAOImpl extends BaseDAOImpl implements ProductDAO {

	/** The Constant SQL_TABLENAME_PRODUCT. */
	private static final String SQL_TBL_DATA_PRODUCT = "`tbl_data_product`";

	/** The Constant SQL_COLUMNLIST_PRODUCT. */
	private static final String SQL_COLUMNLIST_PRODUCT = " `id`, `cataloguenumber`"
			+ ", `organid`, `organ`, `description`, `species`, `fixative`, `totalcases`"
			+ ", `totalcores`, `corediameter`, `sectionthickness`, `validation`, `tissuesummary`"
			+ ", `storage`, `usage`, `corescaseset`, `pathdiagset`, `inforset`"
			+ ", `unitprice`, `pricingunit`";

	/** The Constant SQL_TBL_REF_PRODUCT_RESOURCE. */
	private static final String SQL_TBL_REF_PRODUCT_RESOURCE = "`tbl_ref_product_resource`";

	/** The Constant SQL_COLUMNLIST_PRODUCT_RESOURCE. */
	private static final String SQL_COLUMNLIST_PRODUCT_RESOURCE = "`productid`, `resourceid`"
			+ ", `sort`, `filename`, `filepath`, `filetype`, `name`, `desc`, `type`, `id`";

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.humap.web.product.dao.ProductDAO#findByID(int)
	 */
	@Override
	public ProductItem findByID(final int id) {
		ProductItem item = getJdbcTemplate().query(
				"SELECT " + SQL_COLUMNLIST_PRODUCT + " FROM " + SQL_TBL_DATA_PRODUCT
						+ " WHERE `id`=?", new PreparedStatementSetter() {

					@Override
					public void setValues(PreparedStatement ps) throws SQLException {
						int i = 0;
						ps.setInt(++i, id);
					}
				}, new ResultSetExtractor<ProductItem>() {

					@Override
					public ProductItem extractData(ResultSet rs) throws SQLException,
							DataAccessException {
						ProductItem item = null;
						if (rs.next()) {
							item = extractProductItem(rs);
						}
						return item;
					}
				});

		List<ResourceItem> resourceList = findResourceListByProductID(id);

		if (null != resourceList) {
			for (ResourceItem resourceItem : resourceList) {
				if (resourceItem.getType() == 1) {
					item.getPublicationList().add(resourceItem);
				} else if (resourceItem.getType() == 2) {
					item.getDownloadList().add(resourceItem);
				} else {
					// else
				}
			}
		}
		return item;
	}

	/**
	 * Find resource list by product id.
	 * 
	 * @param id
	 *            the id
	 * @return the list
	 */
	private List<ResourceItem> findResourceListByProductID(final int productID) {
		String sql = "SELECT" + SQL_COLUMNLIST_PRODUCT_RESOURCE + " FROM "
				+ SQL_TBL_REF_PRODUCT_RESOURCE + " where `productid`=? order by `type`, `sort`";
		List<ResourceItem> list = getJdbcTemplate().query(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				int i = 0;
				ps.setInt(++i, productID);
			}
		}, new RowMapper<ResourceItem>() {

			@Override
			public ResourceItem mapRow(ResultSet rs, int rowNum) throws SQLException {
				return extractResourceItem(rs);
			}
		});

		return list;
	}

	@Override
	public List<ProductItem> findBySearchParam(final SearchParam searchParam) {

		String sql = "SELECT" + SQL_COLUMNLIST_PRODUCT + " FROM " + SQL_TBL_DATA_PRODUCT;
		final List<String> paramList = new ArrayList<String>();
		sql = createWhereStatementBySearchParam(searchParam, sql, paramList);
		sql += " LIMIT ?,?";
		List<ProductItem> list = getJdbcTemplate().query(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				int i = 0;
				for (String param : paramList) {
					ps.setString(++i, param);
				}
				ps.setInt(++i, searchParam.getBeginRow());
				ps.setInt(++i, searchParam.getRowCount());
			}
		}, new RowMapper<ProductItem>() {

			@Override
			public ProductItem mapRow(ResultSet rs, int rowNum) throws SQLException {
				return extractProductItem(rs);
			}
		});

		return list;
	}

	@Override
	public int findTotalBySearchParam(SearchParam searchParam) {

		String sql = "SELECT COUNT(1) AS `total` FROM " + SQL_TBL_DATA_PRODUCT;
		final List<String> paramList = new ArrayList<String>();
		sql = createWhereStatementBySearchParam(searchParam, sql, paramList);
		int total = getJdbcTemplate().query(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				int i = 0;
				for (String param : paramList) {
					ps.setString(++i, param);
				}
			}
		}, new ResultSetExtractor<Integer>() {

			@Override
			public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					return rs.getInt(1);
				}
				return 0;
			}
		});

		return total;
	}

	/**
	 * Creates the where statement by search param.
	 * 
	 * @param searchParam
	 *            the search param
	 * @param sql
	 *            the sql
	 * @param paramList
	 *            the param list
	 * @return the string
	 */
	private String createWhereStatementBySearchParam(SearchParam searchParam, String sql,
			final List<String> paramList) {
		StringBuffer sbSql = new StringBuffer(sql);
		sbSql.append(" WHERE 1");

		if (!StringUtils.isBlank(searchParam.getOrganID())) {
			sbSql.append(" AND `organid`=?");
			paramList.add(searchParam.getOrganID());
		}

		if (!CollectionUtils.isEmpty(searchParam.getCoresCaseSet())) {
			for (String cc : searchParam.getCoresCaseSet()) {
				sbSql.append(" AND `corescaseset` LIKE concat('%|',?,'|%')");
				paramList.add(cc);
			}
		}

		if (!CollectionUtils.isEmpty(searchParam.getPathDiagSet())) {
			for (String cc : searchParam.getPathDiagSet()) {
				sbSql.append(" AND `pathdiagset` LIKE concat('%|',?,'|%')");
				paramList.add(cc);
			}
		}

		if (!CollectionUtils.isEmpty(searchParam.getInforSet())) {
			for (String cc : searchParam.getInforSet()) {
				sbSql.append(" AND `inforset` LIKE concat('%|',?,'|%')");
				paramList.add(cc);
			}
		}

		if (!StringUtils.isBlank(searchParam.getSearchKey())) {
			sbSql.append(" AND concat(`cataloguenumber`,'+',`organ`,'+',`description`)"
					+ " LIKE concat('%',?,'%')");
			paramList.add(searchParam.getSearchKey());

		}
		return sbSql.toString();
	}

	/**
	 * Extract product item.
	 * 
	 * @param rs
	 *            the rs
	 * @return the product item
	 * @throws SQLException
	 *             the SQL exception
	 */
	private ProductItem extractProductItem(ResultSet rs) throws SQLException {
		int i = 0;
		ProductItem item = new ProductItem();
		item.setCatalogueID(rs.getInt(++i));
		item.setCatalogueNumber(rs.getString(++i));
		item.setOrganID(rs.getInt(++i));
		item.setOrgan(rs.getString(++i));
		item.setDescription(rs.getString(++i));
		item.setSpecies(rs.getString(++i));
		item.setFixative(rs.getString(++i));
		item.setTotalCases(rs.getString(++i));
		item.setTotalCores(rs.getString(++i));
		item.setCoreDiameter(rs.getString(++i));
		item.setSectionThickness(rs.getString(++i));
		item.setValidation(rs.getString(++i));
		item.setTissueSummary(rs.getString(++i));
		item.setStorage(rs.getString(++i));
		item.setUsage(rs.getString(++i));
		// TODO item.set(rs.getString(++i));
		++i;
		// TODO item.set(rs.getString(++i));
		++i;
		// TODO item.set(rs.getString(++i));
		++i;
		item.setUnitPrice(rs.getString(++i));
		item.setPricingUnit(rs.getString(++i));
		return item;
	}

	/**
	 * Extract resource item.
	 * 
	 * @param rs
	 *            the rs
	 * @return the resource item
	 */
	protected ResourceItem extractResourceItem(ResultSet rs) throws SQLException {
		int i = 0;
		ResourceItem item = new ResourceItem();
		item.setProductID(rs.getInt(++i));
		item.setResourceID(rs.getInt(++i));
		item.setSort(rs.getInt(++i));
		item.setFileName(rs.getString(++i));
		item.setFilePath(rs.getString(++i));
		item.setFileType(rs.getString(++i));
		item.setName(rs.getString(++i));
		item.setDesc(rs.getString(++i));
		item.setType(rs.getInt(++i));
		item.setId(rs.getInt(++i));
		return item;
	}
}
