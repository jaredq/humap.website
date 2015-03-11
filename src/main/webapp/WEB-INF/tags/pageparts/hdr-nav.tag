<%@ tag language="java" pageEncoding="UTF-8"%>
<header>
	<div id="header"
		style="height: 100px; background-image: url('resources/global/images/logo2.png'); background-repeat: no-repeat; background-position: top;">
		<div id="header-content" style="width: 700px; padding-top: 30px;">
			<div id="nav-content" style="width: 713px; -webkit-border-radius: 5px; border-radius: 5px;">
				<div class="menu" style="padding-right: 25px; padding-left: 10px;">
					<a href="home">Home</a>
				</div>
				<div class="menu" style="padding-right: 25px; padding-left: 10px;">
					<a href="about-us">About us</a>
				</div>
				<div class="menu" style="padding-right: 25px; padding-left: 10px;">
					<a href="search-product">Tissue Microarray</a>
				</div>
				<div class="menu" style="padding-right: 25px; padding-left: 10px;">
					<a href="customized-service">Services</a>
				</div>
				<div class="menu" style="padding-right: 25px; padding-left: 10px;">
					<a href="order-intent">Order</a>
				</div>
				<div class="menu" style="padding-right: 15px; padding-left: 10px;">
					<a href="contact-us">Contact us</a>
				</div>
			</div>
			<form action="search-product" method="get" name="searchFormHeader"
				id="search-form-header">
				<input type="text" name="searchKey"
					style="border: 1px solid #A5C7FE;" id="search-key-header" value=""
					maxlength="32" /><input type="hidden" name="pageNum"
					id="page-num-header" value="1" /><input type="image"
					id="search-go-header" value="" alt="Search"
					onclick="javascript:searchFormHeader.submit();"
					src="resources/global/images/s.png" />
			</form>
		</div>
	</div>
</header>