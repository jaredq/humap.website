<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags/pageparts" prefix="pp"%>
<%@ page session="false" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en" ng-app="pubApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Publications <pp:title-postfix /></title>
<pp:global-meta />
<pp:global-css-js />
<link rel="stylesheet" href="resources/publication/css/publication.css" />
</head>
<body ng-controller="pubCtrl">
	<pp:hdr />
	<pp:nav />

	<section>
		<div id="section">
			<div id="sect-content">
				<h3>Publications</h3>
				<div style="clear: both; overflow: hidden;">
					<c:forEach items="${gpYearList}" var="item">
						<div style="margin-right: 4px; float: left;">
							<input type="checkbox" ng-model="pubyear_${item.year}" />
						</div>
						<div style="margin-top: 3px; margin-right: 20px; float: left;">${item.year}</div>
					</c:forEach>
				</div>
				<c:forEach items="${gpYearList}" var="item">
					<div id="general-publications-${item.year}" class="gpList"
						ng-show="pubyear_${item.year}">
						<h3>-- ${item.year}</h3>
						<ul class="numlist">
							<c:forEach items="${item.publicationList}" var="gpItem">
								<li>${gpItem.name}</li>
							</c:forEach>
						</ul>
					</div>
				</c:forEach>
			</div>
		</div>
	</section>

	<pp:ftr />
	<pp:global-ftr-js />
	<script type="text/javascript">
		var orderIntentApp = angular.module('pubApp', []);

		orderIntentApp.controller('pubCtrl', function($scope) {
			<c:forEach items="${gpYearList}" var="item">
				$scope.pubyear_${item.year}=true;
			</c:forEach>
		});
	</script>
	<pp:analyticstracking />
</body>
</html>
