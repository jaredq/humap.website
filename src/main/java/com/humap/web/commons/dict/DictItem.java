/**
 * Created by jaredqin@gmail.com
 */
package com.humap.web.commons.dict;

/**
 * The Class DictItem.
 * 
 * @author 1218
 */
public class DictItem {

	/** The dict id. */
	private int dictID;

	/** The name. */
	private String name;

	/** The value. */
	private String value;

	/** The desc. */
	private String desc;

	/** The parent id. */
	private int parentID;

	/** The sort. */
	private int sort;

	/** The type. */
	private int type;

	/** The addition. */
	private String addition;

	/**
	 * Gets the addition.
	 * 
	 * @return the addition
	 */
	public String getAddition() {
		return addition;
	}

	/**
	 * Sets the addition.
	 * 
	 * @param addition
	 *            the new addition
	 */
	public void setAddition(String addition) {
		this.addition = addition;
	}

	/**
	 * Gets the dict id.
	 * 
	 * @return the dict id
	 */
	public int getDictID() {
		return dictID;
	}

	/**
	 * Sets the dict id.
	 * 
	 * @param dictID
	 *            the new dict id
	 */
	public void setDictID(int dictID) {
		this.dictID = dictID;
	}

	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 * 
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the value.
	 * 
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Sets the value.
	 * 
	 * @param value
	 *            the new value
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * Gets the desc.
	 * 
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * Sets the desc.
	 * 
	 * @param desc
	 *            the new desc
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * Gets the parent id.
	 * 
	 * @return the parent id
	 */
	public int getParentID() {
		return parentID;
	}

	/**
	 * Sets the parent id.
	 * 
	 * @param parentID
	 *            the new parent id
	 */
	public void setParentID(int parentID) {
		this.parentID = parentID;
	}

	/**
	 * Gets the sort.
	 * 
	 * @return the sort
	 */
	public int getSort() {
		return sort;
	}

	/**
	 * Sets the sort.
	 * 
	 * @param sort
	 *            the new sort
	 */
	public void setSort(int sort) {
		this.sort = sort;
	}

	/**
	 * Gets the type.
	 * 
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	/**
	 * Sets the type.
	 * 
	 * @param type
	 *            the new type
	 */
	public void setType(int type) {
		this.type = type;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DictItem [dictID=").append(dictID).append(", name=").append(name)
				.append(", value=").append(value).append(", desc=").append(desc)
				.append(", parentID=").append(parentID).append(", sort=").append(sort)
				.append(", type=").append(type).append(", addition=").append(addition).append("]");
		return builder.toString();
	}
}
