<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags/pageparts" prefix="pp"%>
<%@ page session="false" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contact us <pp:title-postfix /></title>
<pp:global-meta />
<pp:global-css-js />
<link rel="stylesheet" href="resources/contact-us/css/contact-us.css" />
</head>
<body>
	<pp:hdr />
	<pp:nav />

	<section>
		<div id="section">
			<div id="sect-content">
				<h3>Contact us</h3>
				<p>
					For general enquiries, you may use the email:
					<a href="mailto:contact@humap.com.au">contact@humap.com.au</a>
				</p>
				<p>
					To place order, please email: <a href="mailto:sales@humap.com.au">sales@humap.com.au</a>
					or refer to <a href="http://www.humap.com.au/en/order-intent">http://www.humap.com.au/en/order-intent</a>
				</p>
			</div>
		</div>
	</section>

	<pp:ftr />
	<pp:analyticstracking />
</body>
</html>
