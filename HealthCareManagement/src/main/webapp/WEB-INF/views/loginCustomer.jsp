<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Customer Login</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
</head>
<body>
	<h2 style="text-align: center;">Welcome to the NCU</h2>
	<br>



	<div class="container">
		<br> Please login to continue ahead or if you are a new user
		kindly Sign Up by pressing the button below
		<hr>
		<a href="showCustomerForm"> <input type="submit" value="Sign Up" />
		</a> <br> <br> <br>
		<h3>Login</h3>
		<div class="login-form">

			<form action="validateCustomer" method="post">

				<div class="form-group ">
					<label for="username">Username: </label> <input type="text"
						class="form-control" placeholder="Username" required="required" name="username">
				</div>
				<br>
				<div class="form-group md-5">
					<label for="pass">Password: </label> <input type="text"
						class="form-control" name="pass" placeholder="Password" required="required">
				</div>
				<br>
				<div class="form-group md-5">
					<button type="submit" class="btn btn-primary btn-block">Login</button>
				</div>

			</form>

		</div>
	</div>


	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>
</body>
</html>