<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Meeting Registration Form</title>
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
		<h2>Meeting Registration Form</h2>

		<hr>
		<br>

		<form:form action="processCustomerMeetingForm" method="post"
			modelAttribute="meeting">

			<div class="form-group ">
				<label for="meeting_id">Meeting Id(*)</label>
				<form:input type="text" path="meeting_id" />
				<form:errors path="meeting_id" cssClass="error" />

			</div>

			<div class="form-group md-5">
				<label for="customer_id">Customer Id(*)</label>
				<form:input type="text" path="customer_id" />
				<form:errors path="customer_id" cssClass="error" />

			</div>

			<div class="form-group md-5">
				<label for="specialist_id">Specialist_Id(*)</label>
				<form:input type="text" path="specialist_id" readonly="true" />
				<form:errors path="specialist_id" cssClass="error" />

			</div>

			<div class="form-group md-5">
				<label for="date">Date(*)</label>
				<form:input type="date" path="date" />
				<form:errors path="date" cssClass="error" />
				
			</div>

			<div class="form-group md-5">
				<label for="time">Time(*)</label>
				<form:input type="time" path="time" />
				<form:errors path="time" cssClass="error" />

			</div>

			<div class="form-group md-5">
				<label for="location">Location(*)</label>
				<form:input type="text" path="location" />
				<form:errors path="location" cssClass="error" />

			</div>

			<div class="form-group md-5">
				<input type="submit" value="submit" />
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