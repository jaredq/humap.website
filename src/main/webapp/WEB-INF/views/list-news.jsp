<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags/pageparts" prefix="pp"%>
<%@ page session="false" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>News <pp:title-postfix /></title>
<pp:global-meta />
<pp:global-css-js />
<link rel="stylesheet" href="resources/news/css/news.css" />
</head>
<body>
	<pp:hdr />
	<pp:nav />

	<section>
		<div id="section">
			<div id="sect-content">
				<h3>News</h3>
				<div
					style="clear: both; overflow: auto; width: 100%; height: 150px;">
					<div style="width: 620px; float: left; margin-top: 10px;">
						<h3>
							<a href="news-2014-acabs-function">HUMAP's attendance at The
								2014 ACABS Academic function</a>
						</h3>
						<p>HUMAP Biosciences was invited as one of the main sponsors
							to this meeting and gave a brief introduction of the company and
							its tissue array products, interpreting the application in
							translational medicine.</p>
					</div>
					<div
						style="width: 200px; height: 142px; float: left; margin-left: 5px;">
						<a href="news-2014-acabs-function"><img width="200px"
							height="142px" src="resources/home/images/2014-acabs-fuction.jpg"></a>
					</div>
				</div>
				<div style="text-align: center; width: 100%; padding-top: 10px;">
					<div
						style="border-top: 1px solid grey; width: 95%; margin-left: 10px;"></div>
				</div>
			</div>
		</div>
	</section>

	<pp:ftr />
	<pp:analyticstracking />
</body>
</html>
