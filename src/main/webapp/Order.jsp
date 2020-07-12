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
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">

<title>Order Car</title>
</head>
<style>
.modal-title {
	font-size: 20px;
	color: #463364;
	margin-bottom: 48px;
	font-weight: 500;
	line-height: 1.3;
	max-width: 194px;
	span
	{
	&.orange{
	color
	:
	#ed6c0d;
}

}
}
.right {
	float: right;
}

.cent {
	float: center;
	padding-left: 20px;
	padding-right: 20px;
	padding-top: 20px;
	padding-bottom: 60px;
}
</style>
<script src="js/jquery-3.4.1.min.js"></script>
<script>
	function validateContactNo(phNo) {
		//alert(phNo)
		if (phNo.length != 10 || phNo.length > 10) {
			alert("check phone No")
		}
	}
	function validatesSeller(userId) {

	}
</script>
<body>
	<%-- <% Integer userId=(Integer)session.getAttribute("login_seller_id"); %>
<%List<CarDetail> cd=(List<CarDetail>)request.getAttribute("cars"); %>
 --%>
	<form action="FinalOrderServlet" method="get">
		<%-- <%if(cd!=null){%>
<%for (CarDetail cdorder:cd) 
{ %>
 --%>

		<%-- <c:out value="${ sessionScope.login_seller_id}"></c:out>
 --%>
 <center>
		<c:forEach items="${cars}" var="co">
			<div class="card-desk">
				<div class="card" style="width: 25rem; height: 33rem">
					<h6 class="modal-title">
						Good Choice<Span class="orange"> Happy Face!!!</Span>
					</h6>
					<div class="card-body">
						<table>
							<tr>
								<td>BuyerName</td>
								<td>: <input type="text" name="BuyerName"
									placeholder="BuyerName" required /></td>
							</tr>

							<tr>
								<td>Buyer Contact Number</td>
								<td>: <input type="number" pattern="[0-10]{10}"
									title=" required 10 Digit No" name="BuyerContactNo"
									placeHolder="BuyerContactNo" required
									onblur="validateContactNo(this.value)" /></td>
							</tr>

							<tr>
								<td>CarId</td>
								<td>: <input type="number" name="carId"
									value="${co.getCarId()}" readonly required /></td>
							</tr>

							<tr>
								<td>sellerId</td>
								<td>: <input type="number" name="sellerId"
									value="${co.getCarOwner().getOwnerId()}" readonly required /></td>
							</tr>
							<tr>
								<td>UserId</td>
								<td>: <input type="number" name="userId"
									value="${sessionScope.login_seller_id}" readonly required /></td>
							</tr>
							<tr>
								<td>Are you Apply TestDrive</td>
								<td>: <input type="radio" name="testDr" value="yes"
									required>Yes<input type="radio" name="testDr"
									value="no">No
								</td>
							</tr>


							<tr>
								<td>StreetName</td>
								<td>: <input type="text" name="address1"
									placeholder="streetName" required /></td>
							</tr>

							<tr>
								<td>StreetNO</td>
								<td>: <input type="text" name="address2"
									placeholder="streetNo" /></td>
							</tr>

							<tr>
								<td>City</td>
								<td>: <input type="text" name="city" placeholder="City"
									required /></td>
							</tr>

							<tr>
								<td>State</td>
								<td>: <input type="text" name="state" placeholder="State"
									required /></td>
							</tr>
							<tr>
								<td>pincode</td>
								<td>: <input type="number" pattern="[0-9]{6}" maxlength="6"
									tilte="Ex:600000" name="pincode" placeholder="Pincode" required /></td>
							</tr>
							<tr>
								<td></td>
								<td><button type="submit" class="right">Order</button></td>
							</tr>
						</table>
					</div>
				</div>
			</div>
			<%-- <% }%>
<% }% --%>>
</c:forEach>
</center>
	</form>

</body>
</html>