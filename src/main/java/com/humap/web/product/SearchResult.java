/**
 * Created by jaredqin@gmail.com
 */
package com.humap.web.product;

import java.util.List;

/**
 * The Class SearchResult.
 * 
 * @author 1218
 */
public class SearchResult {

	/** The total row count. */
	private int totalRowCount;

	/** The begin row. */
	private int beginRow;

	/** The row count. */
	private int rowCount;

	/** The result list. */
	private List<ProductItem> resultList = null;

	/**
	 * Gets the result list.
	 * 
	 * @return the result list
	 */
	public List<ProductItem> getResultList() {
		return resultList;
	}

	/**
	 * Sets the result list.
	 * 
	 * @param resultList
	 *            the new result list
	 */
	public void setResultList(List<ProductItem> resultList) {
		this.resultList = resultList;
	}

	/**
	 * Gets the total row count.
	 * 
	 * @return the total row count
	 */
	public int getTotalRowCount() {
		return totalRowCount;
	}

	/**
	 * Sets the total row count.
	 * 
	 * @param totalRowCount
	 *            the new total row count
	 */
	public void setTotalRowCount(int totalRowCount) {
		this.totalRowCount = totalRowCount;
	}

	/**
	 * Gets the begin row.
	 * 
	 * @return the begin row
	 */
	public int getBeginRow() {
		return beginRow;
	}

	/**
	 * Sets the begin row.
	 * 
	 * @param beginRow
	 *            the new begin row
	 */
	public void setBeginRow(int beginRow) {
		this.beginRow = beginRow;
	}

	/**
	 * Gets the row count.
	 * 
	 * @return the row count
	 */
	public int getRowCount() {
		return rowCount;
	}

	/**
	 * Sets the row count.
	 * 
	 * @param rowCount
	 *            the new row count
	 */
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SearchResult [totalRowCount=").append(totalRowCount)
				.append(", beginRow=").append(beginRow).append(", rowCount=")
				.append(rowCount).append(", resultList=").append(resultList)
				.append("]");
		return builder.toString();
	}

}
