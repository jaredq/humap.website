<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags/pageparts" prefix="pp"%>
<%@ page session="false" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en" ng-app="orderIntentApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Order <pp:title-postfix /></title>
<pp:global-meta />
<pp:global-css-js />
<link rel="stylesheet" href="resources/order/css/order.css" />
</head>
<body ng-controller="OrderIntentFormCtrl">
	<pp:hdr />
	<pp:nav />

	<section>
		<div id="section">
			<div id="sect-content">
				<h3>Place order</h3>
				<h3>Order by Email :</h3>
				<p>
					sales@humap.com.au<br /> 7 days a week, 24 hours a day
				</p>

				<h3>Please provide the following information when placing an
					order:</h3>
				<p>
					• Purchaser’s name, email and telephone number<br /> •
					Organization<br /> • Shipping address<br /> • Billing address (if
					different)<br /> • Purchase order number<br /> • Quotation number
					(if applicable)<br /> • Catalog number and product description<br />
					• Quantity of products
				</p>

				<h3>Or you can leave the purchaser’s information below, we will
					contact you later:</h3>
				<form action="submit-order-intent" method="post"
					name="orderIntentForm">
					<input type="hidden" name="formId" value="${orderIntentFormID}">
					<dl>
						<dt>Title, first name and last name:</dt>
						<dd>
							<input name="title" ng-maxlength="10" class="inputtitle">
							<input name="firstName" ng-minlength="1" ng-maxlength="85"
								class="inputname" ng-model="oiFirstName" ng-trim="true" required>
							<input name="lastName" ng-minlength="1" ng-maxlength="85"
								class="inputname" ng-model="oiLastName" ng-trim="true" required>
						</dd>
						<dt>Email:</dt>
						<dd>
							<input name="email" ng-minlength="3" ng-maxlength="85"
								ng-model="oiEmail" ng-trim="true" required>
						</dd>
						<dt>Phone:</dt>
						<dd>
							<input name="phone" ng-minlength="5" ng-maxlength="85"
								ng-model="oiPhone" ng-trim="true" required>
						</dd>
						<dt>Organization:</dt>
						<dd>
							<input name="organization" ng-minlength="2" ng-maxlength="170"
								ng-model="oiOrg" ng-trim="true" required>
						</dd>
						<dt>Remark (optional):</dt>
						<dd>
							<textarea name="remark" ng-maxlength="1360"></textarea>
							<br> <input type="submit" value="Ok"
								style="margin-top: 5px; margin-left: 300px; width: 100px;">
						</dd>
					</dl>
				</form>

				<h3>Shipping</h3>
				<p>Array sections will normally be cut and/or shipped within 24
					to 48 hours after receiving the order during the working days of
					the week. Shipping and handling fees are added to your invoice.</p>

				<h3>Terms and Conditions/Purchasing Policies</h3>

				<h4>Pricing:</h4>
				<p>All prices listed are in AUD dollars. Prices and product
					specifications are subject to change without prior notice.</p>

				<h4>Payment Terms:</h4>
				<p>Payment for orders placed with a purchase order are net 30
					days from date of shipment. An invoice will be mailed out within 48
					hours of shipment.</p>

				<h4>Discount Policy (This policy does not apply to products
					with special offer):</h4>
				<p>10 or more slides or items per order: 5%</p>
				<p>20 or more slides or items per order: 10%</p>
				<p>50 or more slides or items per order: 15%</p>
				<p>75 or more slides or items per order: 20%</p>
				<p>100 or more slides or items per order: 25%</p>
				<p>For whole sale orders and distributorship applications please
					contact us.</p>

				<h4>Order Cancellations:</h4>
				<p>Orders can be cancelled at no charge if the notification is
					given before the shipment. Cancellations after the shipment may be
					subject to a 20% return and re-stocking fee.</p>

				<h4>Returns and Refund:</h4>
				<p>To return mistaken, unsatisfactory or damaged products please
					email or call our customer service within 72 hours after receiving
					the shipment to obtain a return authorization. Items damaged during
					transportation should be brought to the attention of the carrier.
					We will assist you in filing a claim with the carrier. All other
					returns may be charged for a 20% re-stocking fee. All items must be
					returned in the original package within 30 days from the date of
					delivery. The above return policies are not suitable for
					customized, or bulk products.</p>
				<p>At our discretion, we may issue a product credit or refund
					for the product value and shipping charges. No product credit shall
					be available for use if a past due balance is outstanding on your
					account.</p>

				<h4>Terms and Conditions:</h4>
				<p>Our products are intended for research use only and are not
					to be used for diagnostic or therapeutic purposes. HUMAP products
					shall not be resold, modified for resale, or used to manufacture
					commercial products without the prior written consent from HUMAP
					PTY LTD. For further information, please contact sales@humap.com.au</p>
			</div>
		</div>
	</section>

	<pp:ftr />
	<pp:global-ftr-js />
	<script type="text/javascript">
		var orderIntentApp = angular.module('orderIntentApp', []);

		orderIntentApp.controller('OrderIntentFormCtrl', function($scope) {
		});
	</script>
	<pp:analyticstracking />
</body>
</html>
