<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<%@page import="com.chainsys.carsaleapp.dao.impl.CarOrderImp"%>
<%@page import="com.chainsys.carsaleapp.model.CarOrder"%>
<%@page import="java.util.List"%>
<jsp:include page="Header.jsp"></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">

<title>Buy</title>
</head>
<body>
	<c:choose>
		<c:when test="${ orderedlist!=null}">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>BuyerName</th>
						<th>OrderId</th>
						<th>CarId</th>
						<th>BuyerId</th>
						<th>address1</th>
						<th>address2</th>
						<th>city</th>
						<th>pincode</th>
						<th>State</th>
						<th>Test Drive</th>
						<th>status</th>
						<th>orderedDate</th>
						<th>DeliveryDate</th>
					</tr>
				</thead>
				<%-- <% for(CarOrder co:car){%> --%>
				<c:forEach items="${orderedlist}" var="ol">
					<tr>
						<td>${ol.getBuyerName()}</td>
						<td>${ol.getOrderId()}</td>
						<td>${ol.getCarId()}</td>
						<td>${ol.getUserId()}</td>
						<td>${ol.getAddress1()}</td>
						<td>${ol.getAddress2()}</td>
						<td>${ol.getCity()}</td>
						<td>${ol.getPincode()}</td>
						<td>${ol.getBuyerState()}</td>
						<td>${ol.getDeliveredDate()}</td>
						<td>${ol.getStatus()}</td>
						<td>${ol.getOrderedDate()}</td>
						<td>${ol.getDeliveredDate()}</td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<h1>NO RECORDS</h1>

		</c:otherwise>
		</c:choose>
</body>
</html>