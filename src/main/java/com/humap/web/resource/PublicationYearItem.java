/**
 * Created by jaredqin@gmail.com
 */
package com.humap.web.resource;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class PublicationYearItem.
 */
public class PublicationYearItem {

	/** The year. */
	private String year;

	/** The publication list. */
	private List<PublicationItem> publicationList = new ArrayList<PublicationItem>();

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public List<PublicationItem> getPublicationList() {
		return publicationList;
	}

	public void setPublicationList(List<PublicationItem> publicationList) {
		this.publicationList = publicationList;
	}
}
