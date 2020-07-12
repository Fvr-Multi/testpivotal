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

</head>
<style>
.slidecontainer {
	width: 100%; /* Width of the outside container */
}

/* The slider itself */
.slider {
	-webkit-appearance: none; /* Override default CSS styles */
	appearance: none;
	width: 100%; /* Full-width */
	height: 25px; /* Specified height */
	background: #d3d3d3; /* Grey background */
	outline: none; /* Remove outline */
	opacity: 0.7; /* Set transparency (for mouse-over effects on hover) */
	-webkit-transition: .2s; /* 0.2 seconds transition on hover */
	transition: opacity .2s;
}

/* Mouse-over effects */
.slider:hover {
	opacity: 1; /* Fully shown on mouse-over */
}

/* The slider handle (use -webkit- (Chrome, Opera, Safari, Edge) and -moz- (Firefox) to override default look) */
.slider::-webkit-slider-thumb {
	-webkit-appearance: none; /* Override default look */
	appearance: none;
	width: 25px; /* Set a specific slider handle width */
	height: 25px; /* Slider handle height */
	background: #4CAF50; /* Green background */
	cursor: pointer; /* Cursor on hover */
}

.slider::-moz-range-thumb {
	width: 25px; /* Set a specific slider handle width */
	height: 25px; /* Slider handle height */
	background: #4CAF50; /* Green background */
	cursor: pointer; /* Cursor on hover */
}

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

.rangeslider {
	width: 50%;
}

.myslider {
	-webkit-appearance: none;
	background: #FCF3CF;
	width: 50%;
	height: 20px;
	opacity: 2;
}

.myslider::-webkit-slider-thumb {
	-webkit-appearance: none;
	cursor: pointer;
	background: #34495E;
	width: 5%;
	height: 20px;
}

.myslider:hover {
	opacity: 1;
}
</style>

<body>



	<form action="SearchByCarPriceServlet" method="get">
		<div class="rangeslider" class="right">
			Above Price<input type="range" min="0" max="600000" value=""
				name="price" class="myslider" id="sliderRange">
			<p>
				Price:<span id="demo"></span>
			</p>

			<Button type="submit">submit</Button>
		</div>
	</form>
	<script>
		var rangeslider = document.getElementById("sliderRange");
		var output = document.getElementById("demo");
		output.innerHTML = rangeslider.value;

		rangeslider.oninput = function() {
			output.innerHTML = this.value;
		}
	</script>
	<%-- <%List<CarDetail> ar=(List<CarDetail>)request.getAttribute("carList") ;%>
<%if(ar!=null){%>
<%for(CarDetail cdl:ar)
	{%> --%>
	<c:choose>
	<c:when test="${(carList!=null)&& !empty carList}">
	<c:forEach items="${carList}" var="cl">
		<div class="left">
			<div class="card-desk" class="left">
				<div class="card" style="width: 18rem; height: 25rem">
					<img src="assets/images/${cl.getImageSrc()}" class="card-img-top"
						alt="image">
					<div class="card-body">
						<h5 class="card-title">${cdl.getCarBrand()}
							${cl.getCarName()}</h5>
						<h6 class="card-text">price: ${cl.getPrice()}
							DrivenKm:${cl.getDrivenKm()}</h6>
						<a href="SearchCarServlet?carId=${cl.getCarId()}" class="right"
							class="madal-title"><span class="orange">view Detail></a>

					</div>
				</div>
			</div>
		</div>
		<%-- <%}%>
<%} %> --%>

	</c:forEach>
	</c:when>
	<c:otherwise>
	<h1>car not available!!!</h1>
	</c:otherwise>
	</c:choose>
</body>
</html>