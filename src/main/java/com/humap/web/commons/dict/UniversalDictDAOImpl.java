/**
 * Created by jaredqin@gmail.com
 */
package com.humap.web.commons.dict;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;

import com.humap.web.commons.dao.BaseDAOImpl;

/**
 * The Class UniversalDictDAOImpl.
 * 
 * @author 1218
 */
public class UniversalDictDAOImpl extends BaseDAOImpl implements UniversalDictDAO {

	/** The Constant SQL_TABLENAME_DICT. */
	private static final String SQL_TABLENAME_DICT = "`tbl_dict_universal`";

	/** The Constant SQL_COLUMNLIST_DICT. */
	private static final String SQL_COLUMNLIST_DICT = "`id`, `name`, `value`, `desc`, `parentid`, `sort`, `type`";

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.humap.web.commons.dict.UniversalDictDAO#findAll()
	 */
	@Override
	public List<DictItem> findAll() {
		List<DictItem> list = getJdbcTemplate().query(
				"SELECT " + SQL_COLUMNLIST_DICT + " FROM " + SQL_TABLENAME_DICT
						+ " WHERE `type`<>0 ORDER BY `type`,`sort`, `name` asc",
				new PreparedStatementSetter() {

					@Override
					public void setValues(PreparedStatement ps) throws SQLException {
					}
				}, new RowMapper<DictItem>() {

					@Override
					public DictItem mapRow(ResultSet rs, int rowNum) throws SQLException {
						return extractDictItemRow(rs);
					}
				});
		return list;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.humap.web.commons.dict.UniversalDictDAO#findAllByType(int)
	 */
	@Override
	public List<DictItem> findAllByType(final int type) {
		List<DictItem> list = getJdbcTemplate().query(
				"SELECT " + SQL_COLUMNLIST_DICT + " FROM " + SQL_TABLENAME_DICT
						+ " WHERE `type`=? ORDER BY `sort`, `name` asc", new PreparedStatementSetter() {

					@Override
					public void setValues(PreparedStatement ps) throws SQLException {
						int i = 0;
						ps.setInt(++i, type);
					}
				}, new RowMapper<DictItem>() {

					@Override
					public DictItem mapRow(ResultSet rs, int rowNum) throws SQLException {
						return extractDictItemRow(rs);
					}
				});
		return list;
	}

	/**
	 * Extract dict item row.
	 * 
	 * @param rs
	 *            the rs
	 * @return the dict item
	 * @throws SQLException
	 *             the SQL exception
	 */
	private DictItem extractDictItemRow(ResultSet rs) throws SQLException {
		int i = 0;
		DictItem item = new DictItem();
		item.setDictID(rs.getInt(++i));
		item.setName(rs.getString(++i));
		item.setValue(rs.getString(++i));
		item.setDesc(rs.getString(++i));
		item.setParentID(rs.getInt(++i));
		item.setSort(rs.getInt(++i));
		item.setType(rs.getInt(++i));
		return item;
	}
}
