<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="Header.jsp"></jsp:include>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<title>L0G1N</title>
</head>
<style>
.login {
	background: url("assets/images/login.png") no-repeat top center;
	background-size: cover;
	height: 100vh;
	position: relative;
}

.form-label-group {
	position: relative;
	margin-bottom: 35px;
}

.form-label-group input, .form-label-group label {
	padding: 0 20px;
	border: 1px solid #dde5eb;
	height: 48px; @ include radius(5px);
	font-size: 16px;
	line-height: 1.31;
	color: #465166;
}

.form-label-group input:focus {
	border: 2px solid #ed6c0d;
	box-shadow: none;
}

.form-label-group label {
	position: absolute;
	top: 0;
	left: 0;
	display: block;
	width: 100%;
	margin-bottom: 0;
	line-height: 46px;
	color: rgba(0, 0, 0, 0.2);
	font-size: 14px;
	transition: all .1s ease-in-out;
	border: 1px solid transparent;
}

.form-label-group input:not (:focus ):valid {
	border: 1px solid #dde5eb;
}

.form-label-group input:not (:focus ):valid+label {
	color: rgba(70, 81, 102, 0.7);
}

.form-label-group input::-webkit-input-placeholder {
	color: transparent;
}

.form-label-group input:-ms-input-placeholder {
	color: transparent;
}

.form-label-group input::-ms-input-placeholder {
	color: transparent;
}

.form-label-group input::-moz-placeholder {
	color: transparent;
}

.form-label-group input::placeholder {
	color: transparent;
}

.form-label-group

 

input


:not

 

(
:placeholder-shown

 

)
{
border


:

 

2
px

 

solid

 

#ed6c0d


;
}
.form-label-group input:focus ~label {
	padding: 0 20px;
	font-size: 10px;
	color: #ed6c0d;
	top: -7px;
	line-height: 13px;
	height: 14px;
	width: auto; @ include radius(0);
	z-index: 1;
	border: 1px solid transparent;
}

.form-label-group input:focus ~label::after {
	height: 4px;
	content: '';
	width: 70%;
	position: absolute;
	left: 15%;
	background: #ffffff;
	top: 5px;
	z-index: -1;
}

.form-label-group input:not (:placeholder-shown ) ~ label {
	padding: 0 20px;
	font-size: 10px;
	color: #ed6c0d;
	top: -7px;
	line-height: 13px;
	height: 14px;
	width: auto; @ include radius(0);
	z-index: 1;
}

.form-label-group input:not (:placeholder-shown ) ~ label:after {
	height: 4px;
	content: '';
	width: 70%;
	position: absolute;
	left: 15%;
	border: 1px solid #ffffff;
	background: #fff;
	top: 5px;
	z-index: -1;
}
/* CSS for +91*/
.form-label-group .user-mobile {
	padding-left: 49px;
}

.error-text {
	position: absolute;
	bottom: -16px;
	line-height: 10px;
	font-size: 12px;
	color: #c80039;
}

.code {
	position: absolute;
	top: 1px;
	height: 48px;
	line-height: 48px;
	vertical-align: baseline;
	display: inline-block;
	left: 20px;
	font-size: 16px;
	opacity: 0.5;
	color: #465166;
}

.verify {
	position: absolute;
	right: 20px;
	height: 48px;
	line-height: 48px;
	font-size: 14px;
	font-weight: bold;
	text-align: center;
	color: rgba(70, 81, 102, 0.3);
	top: 0;
	cursor: default;
}

.orange {
	color: #ed6c0d;
	cursor: pointer !important;
}

.error-border {
	border: 2px solid #c80039 !important;
}

.error-border+label {
	color: #c80039 !important;
}

.otp-field.form-label-group input {
	padding-left: 49px;
}

.otp-field.form-label-group input:focus::placeholder {
	color: rgba(70, 81, 102, 0.7);
	font-weight: normal;
}

.timer {
	position: absolute;
	bottom: -20px;
	right: 3px;
	z-index: 9;
	font-size: 12px;
	color: #465166;
}

@media screen and (max-width:767px) {
	.form-label-group input:not (:placeholder-shown ) ~ label:after {
		border: 2px solid #ffffff;
		top: 5px;
	}
	.form-label-group input:focus ~ label::after {
		height: 4px;
		top: 5px;
	}
}

.modal-dialog {
	width: 40%;
	background: #ffffff;
}

.login-pop {
	align-content: center;
	max-width: 869px !important;
	margin: 0 auto;
	display: flex;
	border-radius: 10px; . modal-content { border : none;
	box-shadow: 0 7px 10px 0 rgba(0, 0, 0, 0.1);
	display: flex;
	max-height: 533px;
	flex-direction: row; . modal-left { width : 100%;
	max-width: 545px; h4 { &.modal-title{ font-size : 20px;
	color: #463364;
	margin-bottom: 48px;
	font-weight: 500;
	line-height: 1.3;
	max-width: 194px;
}

}
.modal-login {
	max-width: 290px;
	margin: 100px auto 0;
	h3
	{
	display
	:
	none;
}

.login-left {
	padding: 10; . login-buton { width : 100%;
	height: 48px; @ include radius(5px);
	color: #fff;
	font-size: 1rem;
	font-weight: 500;
	text-transform: uppercase;
	opacity: 1;
}

}
.error {
	color: #c80039;
	font-size: 12px;
	display: block;
	position: absolute;
	margin-top: 8px;
	line-height: 14px;
}

}
}
p {
	font-size: .75rem;
	color: rgba(70, 81, 102, 0.5);
	text-align: center;
	margin-top: 70px; a { color : rgba( 70, 81, 102, 0.5);
	text-decoration: underline;
}

}
}
.modal-right {
	width: calc(100% - 545px);
	max-width: 324px;
	background-image: linear-gradient(147deg, #0059a3, #003057);
	height: 100%;
	padding: 88px 65px 0 65px; @ include radius(0 10px 10px 0); p { color :
	#fff;
	font-size: 0.875rem;
	margin-bottom: 0;
	line-height: 1.36;
}

h4 { &.modal-title { font-size:2.25rem;
	font-weight: 500;
	line-height: 1.33;
	margin-bottom: 25px;
	color: #fff;
	span
	{
	&.orange{
	color
	:
	#ed6c0d;
}

}
}
}
}
}
.cross-icon {
	position: absolute;
	right: 28px;
	top: 28px;
}

@media screen and (max-width:767px) {
	.login-pop {
		padding: 0 15px;
	}
	.modal-left {
		padding: 40px 25px;
	}
	.login-pop .modal-content .modal-left .modal-login .login-left .login-buton
		{
		width: 100%;
	}
	.login-pop .modal-content .modal-left .modal-login {
		margin: 0;
		max-width: 100%;
	}
	.login-pop .modal-content .modal-left p {
		margin: 19px 0 0;
		a
		{
		color
		:
		#465166;
	}
}

.login-pop .modal-content .modal-left h4.modal-title {
	margin: 0;
}

.login-pop .modal-content .modal-left .modal-login h3 {
	font-size: 14px;
	line-height: 1.36;
	color: #465166;
	margin: 16px 0 30px;
	display: block;
	font-weight: normal;
}

.cross-icon {
	right: 21px;
	top: 21px;
}

}
.login-pop {
	padding: 20px 20px;
	align-content: self; . modal-content .modal-left{ width : 0%;
	max-width: 10%;
}

.modal-content .modal-right {
	width: 45%;
	max-width: 100%;
}

}
#text {
	display: none;
	color: red
}

.center {
	float: center
}
</style>
<script src="js/jquery-3.4.1.min.js"></script>
<script>
	function validateUser(phoneNo) {
		var check = "CarOwnerValidateServlet?phoneNo=" + phoneNo;
		$.getJSON(check, function(data) {
			console.log('ajax' + data);
			var result = parseInt(data);
			if (result == 1) {
				$("#valid").removeClass("glyphicon-remove");
				$("#valid").addClass("glyphicon-ok");
				$("#valid").css("color", "#00A41E");
			} else {
				$("#valid").removeClass("glyphicon-ok");
				$("#valid").addClass("glyphicon-remove");
				$("#valid").css("color", "#FF0004");
			}

		});

	}

	function capsOn() {
		var input = document.getElementById("pass");
		var text = document.getElementById("text");
		input.addEventListener("keyup", function(event) {
			if (event.getModifierState("CapsLock")) {
				text.style.display = "block";

			} else {
				text.style.display = "none";
			}
		});

	}
	//capsOn();
</script>
<body>
	<div class="login center">
		<div class="modal-dialog login-pop">
			<div class="modal-content">
				<div class="modal-login">
					<h4 class="modal-title">Log In</h4>
					<h3>Join us to track your appointments and find all your
						recently viewed cars in one place!</h3>
					<div class="col-md-12 login-left">

						<form action="LoginServlet" method="post">

							<div class="form-label-group">


								<input type="text" id="phone" name="mobileno"
									placeholder="MobileNumber/userId" pattern="[0-9]{10}||[0-9]{4}"
									title="10 digit mobile No OR Your User Id"
									value="${param.mobileno}" class="form-control user-mobile"
									required onblur="validateUser(this.value)"> <label
									for="phone">Mobile Number/userId*</label> <span id="valid"
									class="glyphicon glyphicon-remove" style="color: #FF0004;"></span>
							</div>
							<div class="form-label-group otp-field">
								<input type="password" id="pass" name="pass"
									class="form-control user-mobile" placeholder="Password"
									autocomplete="off" required onkeypress="capsOn()"> <label
									for="pass">Password</label>
								<p id="text">WARNING! Caps lock is ON.</p>
							</div>
							<%-- <%
								String errorMessage = request.getParameter("errorMessage");
							%>

							<%
								if (errorMessage != null) {
							%> --%>
							<font color="red"><h>${param.errorMessage}</h></font>
							<%-- <%
								}
							%> --%>

							<button type="submit"
								class="btn btn-default login-buton btn-disabled">Login</button>
							<br>
						</form>
					</div>
				</div>
				<h4 class="modal-title">
					Welcome to<span class="orange"> BuYSeLLS</span>
				</h4>
			</div>
		</div>
	</div>
</body>
</html>