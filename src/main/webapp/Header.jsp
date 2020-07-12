
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
	margin: 0;
	font-family: Arial, Helvetica, sans-serif;
}

.topnav {
	overflow: hidden;
	background-color: #555;
}

.topnav a {
	float: left;
	color: #f2f2a2;
	text-align: center;
	padding: 16px 16px;
	text-decoration: none;
	font-size: 17px;
	display: inline-block;
	vertical-align: middle;
	content: "";
	background:;
	background-size: 100% 100%;
	align-items: center;
}

.topnav a:hover {
	background-color: #blue;
	color: red;
}

.topnav a.active {
	background: url('assets/images/login.png');
	color: white;
	padding: 5px 15px, 5px;
	border-radius: 20px;
}

.topnav a.right {
	float: right;
}

.orange {
	color: #ed6c0d;
	cursor: pointer !important;
}

.white {
	color: #ffffff;
	cursor: pointer !important;
}

.rgiht {
	float: left;
}
</style>
</head>
<%-- <%
  Integer sellerId=(Integer)session.getAttribute("login_seller_id");
  %>
< --%>
<body>
	<div class="topnav">
		<a class="active" href="ViewAllCar">BuYSeLL</a>
		<c:if test="${sessionScope.login_seller_id==null}">
			<a href="Login.jsp" class="right">Login</a>
			<a href="Register.jsp" class="right">Register</a>
		</c:if>
		<%-- <%} %>
  --%>
		<%--   <%if(sellerId!=null){ %>
 --%>
		<c:if test="${sessionScope.login_seller_id!=null}">
			<a href="LogoutServlet" class="right">Logout</a>
			<a class="right"><span class="white">User Id:</span><Span
				class="orange">${sessionScope.login_seller_id}</Span></a>
			<a href="AddCar.jsp" class="right">AddCars</a>
			<a href="ViewCar" class="right">ViewMyCars</a>
			<a href="WhoOrderedMyCarSevlet" class="right">PlacedCars</a>
			<a href="ViewOrderedCarServlet" class="right">MyorderedCars</a>
			<a href="SearchByPrice.jsp" class="left">SearchBy price</a>
			<a href="SearchByBrand.jsp" class="left">Search By Brand</a>
			<a href="SearchByDrivenKm.jsp" class="left">search By DrivenKm</a>
			<%-- <%} %>
 --%>
		</c:if>
	</div>

	<div style="padding-left: 16px"></div>

</body>
</html>
