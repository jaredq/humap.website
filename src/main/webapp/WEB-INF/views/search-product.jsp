<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib tagdir="/WEB-INF/tags/pageparts" prefix="pp"%>
<%@ page session="false" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tissue Microarray <pp:title-postfix /></title>
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
			<div id="main-list">
				<div id="search-bar">
					<form action="" method="get" name="searchForm" id="search-form">
						<span>Search: </span><input type="text" name="searchKey"
							id="search-key" value="${searchParam.searchKey}" maxlength="32" /><input
							type="hidden" name="pageNum" id="page-num-1" value="1" /> <input
							type="submit" id="search-go" value="Go" />
					</form>
				</div>
				<div id="spec-bar">
					<dl id="path-diag-list">
						<dt class="ttl">Pathology diagnosis:</dt>
						<dd class="cnt">
							<c:forEach items="${pathdiagList}" var="item">
								<c:set var="value2" value="|${item.value}|" />
								<c:choose>
									<c:when test="${fn:contains(pathdiagSetStr, value2)}">
										<div class="ac">
											<a href="javascript:minusOpt('p','${item.value}')"><span>${item.name}</span></a>
										</div>
									</c:when>
									<c:otherwise>
										<div class="na">
											<a href="javascript:plusOpt('p','${item.value}')"><span>${item.name}</span></a>
										</div>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</dd>
					</dl>
					<dl id="infor-list">
						<dt class="ttl">Information:</dt>
						<dd class="cnt">
							<c:forEach items="${inforList}" var="item">
								<c:set var="value2" value="|${item.value}|" />
								<c:choose>
									<c:when test="${fn:contains(inforSetStr, value2)}">
										<div class="ac">
											<a href="javascript:minusOpt('i','${item.value}')"><span>${item.name}</span></a>
										</div>
									</c:when>
									<c:otherwise>
										<div class="na">
											<a href="javascript:plusOpt('i','${item.value}')"><span>${item.name}</span></a>
										</div>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</dd>
					</dl>
				</div>
				<div id="result-list">
					<table id="result-table">
						<tbody>
							<tr bgcolor="0558AA">
								<td align="center" width="160" class="tl">Catalog</td>
								<td align="center" width="50" class="tl">Organ</td>
								<td align="center" width="70" class="tl">Diameter</td>
								<td align="center" width="40" class="tl">Dots</td>
								<td align="center" width="50" class="tl">Cases</td>
								<td align="center" class="tl">Description</td>
								<td align="center" width="100" class="tl">Unit Price<br />(AUD/1
									slide)
								</td>
							</tr>
							<c:forEach items="${searchResult.resultList}" var="item"
								varStatus="loopStatus">
								<tr bgcolor="${loopStatus.index % 2 == 1 ? 'EEEEEE' : 'CCCCCC'}">
									<td align="center"><a target="_blank"
										href="show-product-${item.catalogueID}">${item.catalogueNumber}</a>
									</td>
									<td align="center">${item.organ}</td>
									<td align="center">${item.coreDiameter}</td>
									<td align="center">${item.totalCores}</td>
									<td align="center">${item.totalCases}</td>
									<td>${item.description}</td>
									<td align="center">${item.unitPrice}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div id="result-nav">
					<form action="" method="get" name="searchForm2" id="search-form-2">
						<input type="hidden" name="searchKey" id="search-key-2"
							value="${searchParam.searchKey}" /> <input type="hidden"
							name="pageNum" id="page-num-2" value="${pageNum}" />
						<div style="padding-top: 10px;">
							<pp:paging totalPage="${totalPage}" pageNum="${pageNum}"
								func="page" />
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>
	<script type="text/javascript">
		function page(pn) {
			searchForm2.pageNum.value = pn;
			searchForm2.submit();
		}
		
		function minusOpt(f, opt) {
			window.location.assign(location.href.replace("-" + f + opt, ""));
		}

		function plusOpt(f, opt) {
			var i = location.href.indexOf("?");
			if (i > 0)
			{
				window.location.assign(location.href.substring(0, i)
					.concat("-").concat(f).concat(opt).concat(location.href.substring(i)));
			} else
			{

				window.location.assign(location.href.concat("-").concat(f).concat(opt));
			}
		}
	</script>
	<pp:ftr />
	<pp:analyticstracking />
</body>
</html>
