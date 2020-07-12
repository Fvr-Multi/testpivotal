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
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Buysell</title>
</head>
<body>
	<h2>Buyer Details</h2>
	<c:choose>
		<c:when test="${(orderedlist!=null) && !empty orderedlist}">
			<c:forEach items="${orderedlist}" var="co">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>BuyerName</th>
							<th>OrderId</th>
							<th>CarId</th>
							<th>sellerId</th>
							<th>DeliveryDate</th>
							<th>Status</th>
						</tr>
					</thead>
					<tr>
						<td>${co.getBuyerName()}</td>
						<td>${co.getOrderId()}</td>
						<td>${co.getCarId()}</td>
						<td>${co.getSellerId()}</td>
						<td>${co.getDeliveredDate()}</td>
						<td>${co.getStatus()}</td>
					</tr>
				</table>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<h1>NO RECORDS</h1>
		</c:otherwise>
	</c:choose>
</body>
</html>