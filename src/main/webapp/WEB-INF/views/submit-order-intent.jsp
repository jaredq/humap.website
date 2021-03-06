<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags/pageparts" prefix="pp"%>
<%@ page session="false" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Order <pp:title-postfix /></title>
<pp:global-meta />
<pp:global-css-js />
<link rel="stylesheet" href="resources/order/css/order.css" />
</head>
<body>
	<pp:hdr />
	<pp:nav />

	<section>
		<div id="section">
			<div id="sect-content">
				<h3>Thank you for providing your information! </h3>
				<p>We will contact you later.</p>
			</div>
		</div>
	</section>

	<pp:ftr />
</body>
</html>
