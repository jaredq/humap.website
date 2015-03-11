/**
 * Created by jaredqin@gmail.com
 */
package com.humap.web.product;

import java.util.HashSet;
import java.util.Set;

/**
 * The Class SearchParam.
 * 
 * @author 1218
 */
public class SearchParam {

	/** The organ id. */
	private String organID = null;

	/** The cores case set. */
	private Set<String> coresCaseSet = new HashSet<String>();

	/** The path diag set. */
	private Set<String> pathDiagSet = new HashSet<String>();

	/** The infor set. */
	private Set<String> inforSet = new HashSet<String>();

	/** The search key. */
	private String searchKey = null;

	/** The begin row. */
	private int beginRow;

	/** The row count. */
	private int rowCount;

	/**
	 * Instantiates a new search param.
	 */
	public SearchParam() {
		super();
	}

	/**
	 * Gets the search key.
	 * 
	 * @return the search key
	 */
	public String getSearchKey() {
		return searchKey;
	}

	/**
	 * Sets the search key.
	 * 
	 * @param searchKey
	 *            the new search key
	 */
	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	/**
	 * Gets the organ id.
	 * 
	 * @return the organ id
	 */
	public String getOrganID() {
		return organID;
	}

	/**
	 * Sets the organ id.
	 * 
	 * @param organID
	 *            the new organ id
	 */
	public void setOrganID(String organID) {
		this.organID = organID;
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

	/**
	 * Gets the cores case set.
	 * 
	 * @return the cores case set
	 */
	public Set<String> getCoresCaseSet() {
		return coresCaseSet;
	}

	/**
	 * Gets the path diag set.
	 * 
	 * @return the path diag set
	 */
	public Set<String> getPathDiagSet() {
		return pathDiagSet;
	}

	/**
	 * Gets the infor set.
	 * 
	 * @return the infor set
	 */
	public Set<String> getInforSet() {
		return inforSet;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SearchParam [organID=").append(organID).append(", coresCaseSet=")
				.append(coresCaseSet).append(", pathDiagSet=").append(pathDiagSet)
				.append(", inforSet=").append(inforSet).append(", searchKey=").append(searchKey)
				.append(", beginRow=").append(beginRow).append(", rowCount=").append(rowCount)
				.append("]");
		return builder.toString();
	}
}
