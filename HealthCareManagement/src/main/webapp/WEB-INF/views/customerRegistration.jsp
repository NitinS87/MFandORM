<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Registration Form</title>

<style>
.error {
	color: red
}
</style>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
</head>
<body>

	<div class="container">

		<h2>Customer Registration Form</h2>

		<hr>
		<br>

		<form:form action="processCustomerForm" method="post"
			modelAttribute="customer">

			<div class="form-group ">
				<label for="customer_id">Customer ID</label>
				<form:input type="text" path="customer_id" />
			</div>

			<div class="form-group md-5">
				<label for="customer_username">User Name(*)</label>
				<form:input type="text" path="customer_username" />
				<form:errors path="customer_username" cssClass="error" />
			</div>

			<div class="form-group md-5">
				<label for="customer_password">Password(*)</label>
				<form:input type="password" path="customer_password" />
				<form:errors path="customer_password" cssClass="error" />
			</div>

			<div class="form-group md-5">
				<label for="customer_name">Name(*)</label>
				<form:input type="text" path="customer_name" />
				<form:errors path="customer_name" cssClass="error" />
			</div>
			

			<div class="form-group md-5">
				<label for="customer_age">Age</label>
				<form:input type="text" path="customer_age" />
				<form:errors path="customer_age" cssClass="error" />
			</div>

			<div class="form-group md-5">
				<label for="customer_gender">Gender: </label>
				<form:radiobuttons path="customer_gender"
					items="${customer.genderOptions}" />
			</div>

			<div class="form-group md-5">
				<label>Contact(*)</label>
				<form:input type="text" path="customer_contact" />
				<form:errors path="customer_contact" cssClass="error" />
			</div>

			<div class="form-group md-5">
				<label>Email(*)</label>
				<form:input type="text" path="customer_email" />
				<form:errors path="customer_email" cssClass="error" />
			</div>
			
			<div class="form-group md-5">
				<label>Address Details(*)</label> <br>
				<form:textarea path="customer_address" rows="5" cols="30" />
				<form:errors path="customer_address" cssClass="error" />
			</div>
			<div class="form-group md-5">
				<button type="submit" class="btn btn-primary btn-block">Register</button>
			</div>
		</form:form>
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