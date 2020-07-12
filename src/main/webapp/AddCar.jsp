<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="Header.jsp"></jsp:include>
<!DOCTYPE html>
<html lang="en">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<style>
body {
  background-image: url('assets/images/bck.gif');
   background-repeat: no-repeat;
    background-attachment: fixed; 
background-size: 100% 100%;
}
.lable {
	color: black;
	padding: 8px;
}

.orange {
	color: #ed6c0d;
	cursor: pointer !important;
}

.right {
	float: right;
}
.center
{
float: center;
	padding-left: 275px;
	padding-right: 60px;
	padding-top: 20px;
	padding-bottom: 50px;     
}
.shade
{
 box-shadow: 0 19px 38px rgba(0,0,0,0.30), 0 15px 12px rgba(0,0,0,0.22);
}
.container {
  display: flex;
  justify-content: center;
  flex-direction: row;
}
input[type=text] {
  transition: width 0.4s ease-in-out;
}



</style>
<body>

	<%
		int sellerId = (Integer) session.getAttribute("login_seller_id");
	%>
	<script>
		function myFunction() {
			if (sellerId != null) {
				alert("added success");
			} else {
				alert("Failed");
			}
		}
	</script>
	<script src="js/jquery-3.4.1.min.js"></script>
	<script>
		$(document).ready(function() {
			console.log("Jquery working");
		});
		function validateCarNo(regNo) {
			//alert(phNo)

			var url = "CarRegNoValidateServlet?regNo=" + regNo;
			$.get(url, function(data) {
				console.log(data);
				var result = parseInt(data);

				//  alert("Data:" + data.length);
				if (result == 1) {
					
					var c = confirm("car is already registered");
					alert(c);
				}
				else
					{
					validateCarAvailable(regNo);
					}
			});
			
		}
		function validateCarAvailable(regNo)
		{
			if(regNo!=null && regNo.length==10)
				{
			var url="CarAvailableValidateServlet?regNo="+regNo;
			$.get(url,function(data){
				console.log("new",+data)
			var rs=parseInt(data);
				if(rs==1)
					{
					$("#b1").removeAttr("disabled");
					$("#vId").removeAttr("disabled");
					$("#trType").removeAttr("disabled");
					$("#trTyp").removeAttr("disabled");
					$("#fType").removeAttr("disabled");
					$("#fTyp").removeAttr("disabled");
					$("#regState").removeAttr("disabled");
					$("#carAvailableCity").removeAttr("disabled");
					$("#regYear").removeAttr("disabled");
					$("#img").removeAttr("disabled");
					$("#vOwner").removeAttr("disabled");
					$("#vOwn").removeAttr("disabled");
					$("#carAvailableCity").removeAttr("disabled");
					$("#price").removeAttr("disabled");
					$("#drKm").removeAttr("disabled");
					}					
				else
					{
					var con=(" Invalid Registeration number(not availablein rto dataBase)");
					alert(con)

					}
			});
				}
		}

		function setYear() {
			$("#regYear").attr("min", 1947);
			$("#regYear").attr("max", new Date().getFullYear());

		}
		function validateYear(year) {
			/* 
			console.log(year);
			var currentYear=new Date().getFullYear();
			if(year>1947 && year>currentYear==false)
				{
				
				}
			else
				{
				alert("enter the valid year");
				}
			 */
		}
	</script>

	<Form action="AddCarServlet" method="post" autocomplete="off">
			<div class="w3-container center">
				<div class="card-desk" class="container">
					<div class="card shade" style="width: 50rem; height: 32rem">
		<table>
			<tbody>
				
				<tr>
					<td align="left">Car Name</td>
					<td>: <input type="text" name="carName" id="carName"
						placeholder="Ex:figo" value="${param.carName}" required /></td>
				<td><font color="red"><small>${param.errorMessage}</small></font></td>
				</tr>
				<tr>
					<td align="left">Car Brand</td>
					<td>: <input type="text" name="carBrand" id="carBrand"
						placeholder="ford" value="${param.carBrand}" required /></td>
				</tr>
				<tr>
					<td align="left">Registration Number</td>
					<td>: <input type="text" name="regNo" value="${param.regNo}"
						id="regNo" required placeholder="Ex:TN00NH3433"
						pattern="[A-Z]{2}[0-9]{2}[A-Z]{2}[0-9]{4}"
						title="Enter correct Format" onblur="validateCarNo(this.value)" /></td>
					<td><Label for="regNo" class="lable"><span
							class="orange">Ex:TN00NH3433</span></Label></td>
				</tr>
				<tr>
					<td align="left">Transmission Type</td>
					<td>: <input type="radio" name="tr" value="manual" required id="trType" disabled>manual<input
						type="radio" name="tr" value="auto" id="trTyp" disabled>auto
					</td>
				</tr>
				<tr>
					<td align="left">Fuel Type</td>
					<td>: <input type="radio" name="fuel" value="petrol" required id="fType" disabled >Petrol<input
						type="radio" name="fuel" value="diesel" id="fTyp" disabled>Diesel
					</td>
				</tr>
				<tr>
					<td align="left">Registration State</td>
					<td>: <input type="text" name="regState" id="regState" 
						value="${param.regState}" placeholder="Ex:Tamilnadu" required disabled/></td>
				</tr>
				<tr>
					<td align="left">Car Available City</td>
					<td>: <input type="text" name="carAvailableCity"
						id="carAvailableCity" value="${param.carAvailableCity}" disabled
						placeholder="Ex:chennai" required /></td>
				</tr>
				<tr>
					<td align="left">Registered Year</td>
					<td>: <input type="number" name="regYear" id="regYear"
						value="${param.regYear}" placeholder="Ex:2000" required disabled
						onblur="validateYear(this.value)" /></td>
				</tr>
				<tr>
					<td align="left">Driven Kilometer</td>
					<td>: <input type="number" name="drKm" id="drKm"
						value="${param.drKm}" maxlength="10" pattern="^[0-9]"
						title="Enter Km correctly" min="1" placeholder="Ex:DrivenKm"
						required  disabled/></td>
				</tr>
				
				<tr>
					<td align="left">Vehicle Identification Number</td>
					<td>: <input type="text" name="vid" value="${param.vid}" id="vId"
						maxLength="17" pattern="[0-9]{1}[A-Z]{4}[0-9]{2}[A-Z]{4}[0-9]{6}"
						title="need 17 character" id="vid" required
						placeholder="Ex:1NNNN11NNNN111111" disabled/></td>
					<td><Label for="vid"><span class="orange">Ex:1NNNN11NNNN111111</span></Label></td>
				</tr>
				<tr>
					<td align="left">Price</td>
					<td>: <input type="number" name="price" id="price"
						value="${param.price}" placeholder="Ex:100000" min=300000 id="price" disabled
						pattern="^[0-9]" title="Give valid price" required /></td>
				</tr>
				<tr>
					<td align="left">Are You owner</td>
					<td><input type="radio" name="isowner" value=1 required id="vOwner" disabled/>Yes<input
						type="radio" name="isowner" id="vOwn" value=0 disabled/>No<br></td>
				</tr>
				<tr>
					<td align="left">Car Image Source</td>
					<td>: <input type="text" name="image" value="${param.image}" id="img" disabled
						placeholder="image.jpg" /></td>
				</tr>
				<tr>
					<th></th>
					<td class="right"></td>
				</tr>
			</tbody>
		</table>
		<button type="submit" onclick="myfunction()" id="b1"
							class="w3-button w3-green" disabled >add</button>
		</div>
		</div>
		</div>
	</Form>
	<script>
		setYear();
	</script>
</body>
</html>