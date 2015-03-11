/**
 * Created by jaredqin@gmail.com
 */
package com.humap.web.resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * The Class PublicationManagerImpl.
 */
public class PublicationManagerImpl implements PublicationManager {

	/** The publication dao. */
	@Autowired
	private PublicationDAO publicationDAO;

	@Override
	public List<PublicationYearItem> findAllPublicationYears() {
		List<PublicationYearItem> pyList = new ArrayList<PublicationYearItem>();
		Map<String, List<PublicationItem>> pyMap = new HashMap<String, List<PublicationItem>>();
		List<PublicationItem> allPublications = publicationDAO.findAllPublications();
		for (PublicationItem publicationItem : allPublications) {
			if (pyMap.containsKey(publicationItem.getYear())) {
				pyMap.get(publicationItem.getYear()).add(publicationItem);
			} else {
				List<PublicationItem> piList = new ArrayList<PublicationItem>();
				piList.add(publicationItem);

				// put into map
				pyMap.put(publicationItem.getYear(), piList);
				
				// add into list
				PublicationYearItem pyItem = new PublicationYearItem();
				pyItem.setYear(publicationItem.getYear());
				pyItem.setPublicationList(piList);
				pyList.add(pyItem);
			}
		}

		return pyList;
	}

}
