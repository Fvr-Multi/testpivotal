<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="java.util.List"%>
<%@page import="com.chainsys.carsaleapp.dao.impl.CarDetailImp"%>
<%@page import="com.chainsys.carsaleapp.model.CarDetail"%>
<jsp:include page="Header.jsp"></jsp:include>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ALL CARS</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">

</head>
<style>
.left {
	float: left;
	padding-left: 20px;
	padding-right: 20px;
	padding-top: 20px;
	padding-bottom: px;
}

.cent {
	float: padding-left: 20px;
	padding-right: 20px;
	padding-top: 20px;
	padding-bottom: 60px;
}

.right {
	float: right;
}
</style>
<body>

	<%--  <%List<CarDetail> li=(List<CarDetail>)request.getAttribute("viewAllCar"); %>--%>

	<form action="">
		<div>
			<%-- <%if(li!=null)
{%>

<%	for(CarDetail cd:li)
		{%>
 --%>
 <c:choose>
 <c:when test="${(viewAllCar!=null)&& !empty viewAllCar }">
			<c:forEach items="${viewAllCar}" var="b">
				<div class="left">
					<div class="card-desk" class="left">
						<div class="card" style="width: 25rem; height: 31rem">
							<img src="assets/images/${b.getImageSrc()}" class="card-img-top"
								alt="image">
							<div class="card-body">
								<h5 class="card-title">${b.getCarBrand()}${b.getCarName()}
								</h5>
								<h6 class="card-text">Registered Year:${b.getRegYear()}</h6>
								<h6 class="card-text">DrivenKm:${cd.getDrivenKm()}</h6>
								<h6 class="card-text">price:${b.getPrice()}</h6>
								<h6 class="card-text">Registered State:${b.getRegState()}</h6>
								<a href="SearchCarServlet?carId=${b.getCarId()}" class="right"
									class="madal-title"><span class="orange">View
										Detail></span></a>
							</div>
						</div>
					</div>
				</div>
				<%-- <%}%>
<%} %> --%>
			</c:forEach>
			</c:when>
			<c:otherwise>
			<h1>cars not found !!!</h1>
			</c:otherwise>
			</c:choose>
		</div>
	</form>
</body>
</html>