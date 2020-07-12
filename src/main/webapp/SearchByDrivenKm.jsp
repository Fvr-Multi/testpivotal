<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="Header.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<%@page import="java.util.List"%>
<%@page import="com.chainsys.carsaleapp.model.CarDetail"%>
<script src="js/jquery-3.4.1.min.js"></script>
<!-- <link rel="stylesheet" type="text/css" href="style.css">
<script src="//cdnjs.cloudflare.com/ajax/libs/less.js/3.9.0/less.min.js" ></script>
 -->
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	</head>
	<style>
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
.shade
{
 box-shadow: 0 12px 10px rgba(0,0,0,0.30), 0 5px 5px rgba(0,0,0,0.22);
}
.w
{
 height:300px;
}
.cent
{
float:center;
}
</style>
<body>
	<script src="js/jquery-3.4.1.min.js"></script>
<div class="left shade w">
	<form action="SearchCarByDrivenKmServlet" method="get">
		<div class="rangeslider" class="right">
			Fromkm<input type="range" min="0" max="2000" value="" name="fromKm"
				class="myslider" id="sliderRange">
			<p>
				Price:<span id="fromValue"></span>
			</p>
			TO KM<input type="range" min="2500" max="600000" value="" name="toKm"
				class="myslider" id="secondSliderRange">
			<p>
				Price:<span id="toValue"></span>
			</p>
		</div>
		<br>
		<br>
		&nbsp;&nbsp;<Button type="submit" class="cent">submit</Button>

	</form>
	</div>
	<script>
		var rangeslider = document.getElementById("sliderRange");
		var rangeslid = document.getElementById("secondSliderRange");
		var fromOut = document.getElementById("fromValue");
		fromOut.innerHTML = rangeslider.value;
		var toOutput = document.getElementById("toValue");
		toOutput.innerHTML = rangeslid.value;
		rangeslider.oninput = function() {
			fromOut.innerHTML = this.value;
		}
		rangeslid.oninput = function() {
			toOutput.innerHTML = this.value;
		}
	</script>
	<c:choose>
	<c:when test="${(carDetail!=null)&&!empty carDetail}">
	<c:forEach items="${carDetail}" var="cl">
		<div class="left">
			<div class="card-desk" class="left">
			<div class="card" style="width: 25rem; height: 30rem">
				<div class="in">
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>
    <!-- Wrapper for slides -->
    <div class="carousel-inner">
      <div class="item active">
        <img src="assets/images/${cl.getImageSrc()}" alt="Los Angeles" style="width:150%;">
      </div>

      <div class="item">
        <img src="assets/images/${cl.getImageSrc()}" alt="Chicago" style="width:150%;">
        
          
        </div>
      </div>
      </div>
      </div>
   				
					<div class="card-body">
						<h5 class="card-title">${cl.getCarBrand()}</h5>
							<h5 class="card-text">${cl.getCarName()}</h5>
						<h6 class="card-text">price: ${cl.getPrice()}
							DrivenKm:${cl.getDrivenKm()}</h6>
						<a href="SearchCarServlet?carId=${cl.getCarId()}" class="right"
							class="madal-title"><span class="orange">view Detail></a>

					</div>
				</div>
		</div>
</div>
	</c:forEach>
	</c:when>
	<c:otherwise>
	<h1>car not available</h1>
	</c:otherwise>
	</c:choose>
</body>
</html>