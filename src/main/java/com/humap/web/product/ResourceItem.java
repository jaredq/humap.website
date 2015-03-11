/**
 * Created by jaredqin@gmail.com
 */
package com.humap.web.product;

/**
 * The Class ImageItem.
 * 
 * @author 1218
 */
public class ResourceItem {

	/** The product id. */
	private int productID;

	/** The resourceid. */
	private int resourceID;

	/** The sort. */
	private int sort;

	/** The file name. */
	private String fileName;

	/** The file path. */
	private String filePath;

	/** The file type. */
	private String fileType;

	/** The name. */
	private String name;

	/** The desc. */
	private String desc;

	/** The type. */
	private int type;

	/** The id. */
	private int id;

	/**
	 * Instantiates a new image item.
	 */
	public ResourceItem() {
		super();
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public int getResourceID() {
		return resourceID;
	}

	public void setResourceID(int resourceID) {
		this.resourceID = resourceID;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ResourceItem [productID=").append(productID).append(", resourceID=")
				.append(resourceID).append(", sort=").append(sort).append(", fileName=")
				.append(fileName).append(", filePath=").append(filePath).append(", fileType=")
				.append(fileType).append(", name=").append(name).append(", desc=").append(desc)
				.append(", type=").append(type).append(", id=").append(id).append("]");
		return builder.toString();
	}

}
