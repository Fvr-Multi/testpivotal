<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="com.chainsys.carsaleapp.dao.impl.CarOwnerImp"%>
<%@page import="com.chainsys.carsaleapp.model.CarOwner"%>
<%@page import="java.util.List"%>
<jsp:include page="Header.jsp"></jsp:include>

<!DOCTYPE html>
<html lang="en">
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MyCars</title>
</head>
<script src="js/jquery-3.4.1.min.js"></script>
<style>
.left {
	float: left
}
</style>
<script>
function enableTxt(carId){
	$("#price_" + carId).removeAttr("disabled");
	$("#status_"+carId).removeAttr("disabled");
	}
function enableText() { 
    $('input').prop('readonly', true); 
    document.getElementById("price").innerHTML 
            = "Read-Only attribute enabled"; 
} 
function priceUpdate(carId,sellerId){
	
	var price = $("#price_" + carId).val();
	console.log(price);
	var status=$("#status_"+carId).val();
	console.log(status);
	var url = "UpdateCarPrice?price="+price +"&status="+status+"&carId="+carId+"&sellerId="+sellerId;
 alert(url);
	$
		.get(
				url,
				function(data) {
				var result=parseInt(data);
				if(result==1)
					{
					alert("updated");
				
					}
				});

}

</script>
<body>



	<%-- <%
		Integer sellerId = (Integer) session.getAttribute("login_seller_id");

		List<CarOwner> car = (List<CarOwner>) request.getAttribute("totalCar");
		String msg = "no records";
	%>
	<%
		if (car != null && !car.isEmpty()) {
	%> --%>
	<c:choose>
		<c:when test="${totalCar!=null && !totalCar.isEmpty()}">
			<div class="container left">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>status</th>
							<th>AvailableCity</th>
							<th>CarBrand</th>
							<th>CarName</th>
							<th>CarId</th>
							<th>DrivenKm</th>
							<th>Price(Rs)</th>
							<th>Reg Year</th>
							<th>Reg Number</th>
							<th>VID Number</th>
							<th>Edit</th>
							<th>UpdatePrice</th>
						</tr>
					</thead>
					<%-- <%
				for (CarOwner co : car) {
			%>
 --%>
					<c:forEach items="${totalCar}" var="co">
						<tr>
							<td><select id="status_${co.getCarDetail().getCarId()}"value="${co.getCarDetail().getStatus()}" disabled>
							<option value="ordered">ordered</option>
							<option value="order pending">order pending</option>
							<option value="cancelled">cancelled</option>
							<option value="shipped">shipped</option>
							</select>
							</td>
							<td>${co.getCarDetail().getCarAvailableCity()}</td>
							<td>${co.getCarDetail().getCarBrand()}</td>
							<td>${co.getCarDetail().getCarName()}</td>
							<td>${co.getCarDetail().getCarId()}</td>
							<td>${co.getCarDetail().getDrivenKm()}</td>
							<td><input type="number"
								value="${co.getCarDetail().getPrice()}" name="price"
								id="price_${co.getCarDetail().getCarId()}" disabled /></td>
							<td>${co.getCarDetail().getRegYear()}</td>
							<td>${co.getCarDetail().getRegistrationNo()}</td>
							<td>${co.getCarDetail().getVehicleIdNo()}</td>
							<td><button
									onclick="enableTxt(${co.getCarDetail().getCarId()})"
									class="btn btn-danger">edit</button></td>
							<td><button
									onclick="priceUpdate(${co.getCarDetail().getCarId()},${co.getOwnerId()})"
									class="btn btn-danger">update</button></td>

						</tr>
					</c:forEach>
				</table>
			</div>
		</c:when>
		<c:otherwise>
			<h1>NO RECORDS</h1>
		</c:otherwise>
	</c:choose>
</body>
</html>