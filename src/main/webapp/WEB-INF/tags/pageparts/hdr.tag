<%@ tag language="java" pageEncoding="UTF-8"%>
<header>
	<div id="header">
		<div id="header-logo">
			<a href="home"><img src="resources/global/images/logo.png" /></a>
		</div>
		<div id="header-content">
			<br>
			<form action="search-product" method="get" name="searchFormHeader"
				id="search-form-header">
				<input type="text" name="searchKey"
					style="border: 1px solid #A5C7FE; border-right-width: 0; border-radius: 5px 0 0 5px;"
					id="search-key-header" value="" maxlength="32" /><input
					type="hidden" name="pageNum" id="page-num-header" value="1" /><input
					type="image" id="search-go-header" value="" alt="Search"
					onclick="javascript:searchFormHeader.submit();"
					src="resources/global/images/s.png"
					style="border: 1px solid #A5C7FE; border-left-width: 0; border-radius: 0 5px 5px 0;" />
			</form>
		</div>
	</div>
</header>