<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags/pageparts" prefix="pp"%>
<%@ page session="false" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${productItem.catalogueNumber}<pp:title-postfix /></title>
<pp:global-meta />
<pp:global-css-js />
<link rel="stylesheet" href="resources/product/css/product.css" />
</head>
<body>
	<pp:hdr />
	<pp:nav />

	<section>
		<div id="section">
			<div id="sect-title">
				<h3>Tissue Microarray</h3>
			</div>
			<div id="organ-list">
				<ul>
					<li><a href="search-product">-- All --</a></li>
					<c:forEach items="${organList}" var="item">
						<li><a href="search-product-${item.value}">${item.name}</a></li>
					</c:forEach>
				</ul>
			</div>
			<div id="detail-list">
				<table id="detail-table">
					<colgroup>
						<col width="180"></col>
						<col></col>
					</colgroup>

					<tbody>
						<tr class="r1">
							<td class="ttl">Catalogue Number:</td>
							<td class="cnt">${productItem.catalogueNumber}</td>
						</tr>
						<tr class="r2">
							<td class="ttl">Description:</td>
							<td class="cnt">${productItem.description}</td>
						</tr>
						<tr class="r1">
							<td class="ttl">Species:</td>
							<td class="cnt">${productItem.species}</td>
						</tr>
						<tr class="r2">
							<td class="ttl">Fixative:</td>
							<td class="cnt">${productItem.fixative}</td>
						</tr>
						<tr class="r1">
							<td class="ttl">Total Cases:</td>
							<td class="cnt">${productItem.totalCases}</td>
						</tr>
						<tr class="r2">
							<td class="ttl">Total Cores:</td>
							<td class="cnt">${productItem.totalCores}</td>
						</tr>
						<tr class="r1">
							<td class="ttl">Core Diameter:</td>
							<td class="cnt">${productItem.coreDiameter}</td>
						</tr>
						<tr>
							<td class="ttl">Section Thickness:</td>
							<td class="cnt">${productItem.sectionThickness}</td>
						</tr>
						<tr class="r1">
							<td class="ttl">Validation:</td>
							<td class="cnt">${productItem.validation}</td>
						</tr>
						<tr class="r2">
							<td class="ttl">Tissue Summary:</td>
							<td class="cnt">${productItem.tissueSummary}</td>
						</tr>
						<tr class="r1">
							<td class="ttl">Storage:</td>
							<td class="cnt">${productItem.storage}</td>
						</tr>
						<tr class="r2">
							<td class="ttl">Usage:</td>
							<td class="cnt">${productItem.usage}</td>
						</tr>
						<tr class="r1">
							<td class="ttl">Unit Price (AUD/1 slide):</td>
							<td class="cnt">${productItem.unitPrice}</td>
						</tr>
						<tr class="r2">
							<td class="ttl">Publications:</td>
							<td class="cnt">
								<ul class="numlist">
									<c:forEach items="${productItem.publicationList}" var="item">
										<li><a target="_blank" href="${item.filePath}">${item.name}</a></li>
									</c:forEach>
								</ul>
							</td>
						</tr>
						<tr class="r1">
							<td class="ttl">Download:</td>
							<td class="cnt">
								<ul class="numlist">
									<c:forEach items="${productItem.downloadList}" var="item">
										<li><a target="_blank"
											href="${item.filePath}${item.fileName}">${item.name}</a></li>
									</c:forEach>
								</ul>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</section>
	<pp:ftr />
	<pp:analyticstrackinguid userID="${productItem.catalogueID}" />
</body>
</html>
