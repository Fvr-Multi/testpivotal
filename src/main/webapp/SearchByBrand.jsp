<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="java.util.List"%>
<%@page import="com.chainsys.carsaleapp.model.CarDetail"%>
<jsp:include page="Header.jsp"></jsp:include>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BuySell</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<style>
.orange {
	color: #ed6c0d;
	cursor: pointer !important;
}

modal-title {
	font-size: 20px;
	color: #463364;
	margin-bottom: 48px;
	font-weight: 500;
	line-height: 1.3;
	max-width: 194px;
}

.left {
	float: left;
	padding-left: 20px;
	padding-right: 20px;
	padding-top: 20px;
	padding-bottom: px;
}

.right {
	float: right;
}
</style>
</head>
<%-- <%List<CarDetail> cd=(List<CarDetail>)request.getAttribute("availableCar"); %>
 --%>
<body>
	<form action="SearchByBrandServlet" method="get">
		<div>
			<input list="carBrand" name="carBrand" placeholder="CarBrand">
			<datalist id="carBrand">
				<option value="audi">
				<option value="honda">
				<option value="ford">
				<option value="tata">
				<option value="hundai">
				<option value="maruti">
				<option value="suzuki">
			</datalist>
			<button name="submit">Search</button>
		</div>
		<%-- <%if((cd!=null)&&!cd.isEmpty()){%>
<%for(CarDetail cdl:cd)
	{%>
 --%>
 <c:choose>
 <c:when test="${(availableCar!=null) && !empty availableCar}">
		<c:forEach items="${availableCar}" var="ac">
			<div class="left">
				<div class="card-desk" class="left">
					<div class="card" style="width: 18rem; height: 25rem">
						<img src="assets/images/${ac.getImageSrc()}" class="card-img-top"
							alt="image">
						<div class="card-body">
							<h5 class="card-title">${ac.getCarBrand()}
								${ac.getCarName()}</h5>
							<h6 class="card-text">Registration year:${ac.getRegYear()}</h6>
							<h6>DrivenKm:${ac.getDrivenKm()}</h6>
							<h6>price:${ac.getPrice()}</h6>
							<a href="SearchCarServlet?carId=${ac.getCarId()}" class="right"
								class="madal-title"><span class="orange">view Detail></span></a>
						</div>
					</div>
				</div>
			</div>
			<%-- <%}%>
<%}%> --%>
		</c:forEach>
		</c:when>
		<c:otherwise>
		<h1>car not available1!!!</h1>
		</c:otherwise>
		</c:choose>
	</form>
</body>
</html>