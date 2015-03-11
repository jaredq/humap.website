/**
 * Created by jaredqin@gmail.com
 */
package com.humap.web.product;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The Class ProductItem.
 * 
 * @author 1218
 */
public class ProductItem {

	/** The catalogue id. */
	private int catalogueID;

	/** The catalogue number. */
	private String catalogueNumber;

	/** The organ id. */
	private int organID;

	/** The organ. */
	private String organ;

	/** The description. */
	private String description;

	/** The species. */
	private String species;

	/** The fixative. */
	private String fixative;

	/** The total cases. */
	private String totalCases;

	/** The total cores. */
	private String totalCores;

	/** The core diameter. */
	private String coreDiameter;

	/** The section thickness. */
	private String sectionThickness;

	/** The validation. */
	private String validation;

	/** The tissue summary. */
	private String tissueSummary;

	/** The storage. */
	private String storage;

	/** The usage. */
	private String usage;

	/** The publication list. */
	private List<ResourceItem> publicationList = new ArrayList<ResourceItem>();

	/** The download list. */
	private List<ResourceItem> downloadList = new ArrayList<ResourceItem>();

	/** The cores case set. */
	private Set<String> coresCaseSet = new HashSet<String>();

	/** The path diag set. */
	private Set<String> pathDiagSet = new HashSet<String>();

	/** The infor set. */
	private Set<String> inforSet = new HashSet<String>();

	/** The unit price. */
	private String unitPrice;

	/** The pricing unit. */
	private String pricingUnit;

	/**
	 * Instantiates a new product item.
	 */
	public ProductItem() {
		super();
	}

	/**
	 * Instantiates a new product item.
	 * 
	 * @param catalogueNumber
	 *            the catalogue number
	 */
	public ProductItem(String catalogueNumber) {
		super();
		this.catalogueNumber = catalogueNumber;
	}

	/**
	 * Gets the catalogue number.
	 * 
	 * @return the catalogue number
	 */
	public String getCatalogueNumber() {
		return catalogueNumber;
	}

	/**
	 * Sets the catalogue number.
	 * 
	 * @param catalogueNumber
	 *            the new catalogue number
	 */
	public void setCatalogueNumber(String catalogueNumber) {
		this.catalogueNumber = catalogueNumber;
	}

	/**
	 * Gets the description.
	 * 
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 * 
	 * @param description
	 *            the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the species.
	 * 
	 * @return the species
	 */
	public String getSpecies() {
		return species;
	}

	/**
	 * Sets the species.
	 * 
	 * @param species
	 *            the new species
	 */
	public void setSpecies(String species) {
		this.species = species;
	}

	/**
	 * Gets the fixative.
	 * 
	 * @return the fixative
	 */
	public String getFixative() {
		return fixative;
	}

	/**
	 * Sets the fixative.
	 * 
	 * @param fixative
	 *            the new fixative
	 */
	public void setFixative(String fixative) {
		this.fixative = fixative;
	}

	/**
	 * Gets the total cases.
	 * 
	 * @return the total cases
	 */
	public String getTotalCases() {
		return totalCases;
	}

	/**
	 * Sets the total cases.
	 * 
	 * @param totalCases
	 *            the new total cases
	 */
	public void setTotalCases(String totalCases) {
		this.totalCases = totalCases;
	}

	/**
	 * Gets the total cores.
	 * 
	 * @return the total cores
	 */
	public String getTotalCores() {
		return totalCores;
	}

	/**
	 * Sets the total cores.
	 * 
	 * @param totalCores
	 *            the new total cores
	 */
	public void setTotalCores(String totalCores) {
		this.totalCores = totalCores;
	}

	/**
	 * Gets the core diameter.
	 * 
	 * @return the core diameter
	 */
	public String getCoreDiameter() {
		return coreDiameter;
	}

	/**
	 * Sets the core diameter.
	 * 
	 * @param coreDiameter
	 *            the new core diameter
	 */
	public void setCoreDiameter(String coreDiameter) {
		this.coreDiameter = coreDiameter;
	}

	/**
	 * Gets the section thickness.
	 * 
	 * @return the section thickness
	 */
	public String getSectionThickness() {
		return sectionThickness;
	}

	/**
	 * Sets the section thickness.
	 * 
	 * @param sectionThickness
	 *            the new section thickness
	 */
	public void setSectionThickness(String sectionThickness) {
		this.sectionThickness = sectionThickness;
	}

	/**
	 * Gets the validation.
	 * 
	 * @return the validation
	 */
	public String getValidation() {
		return validation;
	}

	/**
	 * Sets the validation.
	 * 
	 * @param validation
	 *            the new validation
	 */
	public void setValidation(String validation) {
		this.validation = validation;
	}

	/**
	 * Gets the tissue summary.
	 * 
	 * @return the tissue summary
	 */
	public String getTissueSummary() {
		return tissueSummary;
	}

	/**
	 * Sets the tissue summary.
	 * 
	 * @param tissueSummary
	 *            the new tissue summary
	 */
	public void setTissueSummary(String tissueSummary) {
		this.tissueSummary = tissueSummary;
	}

	/**
	 * Gets the storage.
	 * 
	 * @return the storage
	 */
	public String getStorage() {
		return storage;
	}

	/**
	 * Sets the storage.
	 * 
	 * @param storage
	 *            the new storage
	 */
	public void setStorage(String storage) {
		this.storage = storage;
	}

	/**
	 * Gets the usage.
	 * 
	 * @return the usage
	 */
	public String getUsage() {
		return usage;
	}

	/**
	 * Sets the usage.
	 * 
	 * @param usage
	 *            the new usage
	 */
	public void setUsage(String usage) {
		this.usage = usage;
	}

	/**
	 * Gets the organ.
	 * 
	 * @return the organ
	 */
	public String getOrgan() {
		return organ;
	}

	/**
	 * Sets the organ.
	 * 
	 * @param organ
	 *            the new organ
	 */
	public void setOrgan(String organ) {
		this.organ = organ;
	}

	/**
	 * Gets the catalogue id.
	 * 
	 * @return the catalogue id
	 */
	public int getCatalogueID() {
		return catalogueID;
	}

	/**
	 * Sets the catalogue id.
	 * 
	 * @param catalogueID
	 *            the new catalogue id
	 */
	public void setCatalogueID(int catalogueID) {
		this.catalogueID = catalogueID;
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

	/**
	 * Gets the organ id.
	 * 
	 * @return the organ id
	 */
	public int getOrganID() {
		return organID;
	}

	/**
	 * Sets the organ id.
	 * 
	 * @param organID
	 *            the new organ id
	 */
	public void setOrganID(int organID) {
		this.organID = organID;
	}

	/**
	 * Gets the unit price.
	 * 
	 * @return the unit price
	 */
	public String getUnitPrice() {
		return unitPrice;
	}

	/**
	 * Sets the unit price.
	 * 
	 * @param unitPrice
	 *            the new unit price
	 */
	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}

	/**
	 * Gets the pricing unit.
	 * 
	 * @return the pricing unit
	 */
	public String getPricingUnit() {
		return pricingUnit;
	}

	/**
	 * Sets the pricing unit.
	 * 
	 * @param pricingUnit
	 *            the new pricing unit
	 */
	public void setPricingUnit(String pricingUnit) {
		this.pricingUnit = pricingUnit;
	}

	public List<ResourceItem> getPublicationList() {
		return publicationList;
	}

	public List<ResourceItem> getDownloadList() {
		return downloadList;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProductItem [catalogueID=").append(catalogueID)
				.append(", catalogueNumber=").append(catalogueNumber).append(", organID=")
				.append(organID).append(", organ=").append(organ).append(", description=")
				.append(description).append(", species=").append(species).append(", fixative=")
				.append(fixative).append(", totalCases=").append(totalCases)
				.append(", totalCores=").append(totalCores).append(", coreDiameter=")
				.append(coreDiameter).append(", sectionThickness=").append(sectionThickness)
				.append(", validation=").append(validation).append(", tissueSummary=")
				.append(tissueSummary).append(", storage=").append(storage).append(", usage=")
				.append(usage).append(", publicationList=").append(publicationList)
				.append(", downloadList=").append(downloadList).append(", coresCaseSet=")
				.append(coresCaseSet).append(", pathDiagSet=").append(pathDiagSet)
				.append(", inforSet=").append(inforSet).append(", unitPrice=").append(unitPrice)
				.append(", pricingUnit=").append(pricingUnit).append("]");
		return builder.toString();
	}
}
