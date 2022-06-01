<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Specialist Registration Form</title>
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
	<h2>Specialist Registration Form</h2>

	<hr>
	<br>

	<form:form action="processSpecialistForm" method="post"
		modelAttribute="specialist">

<div class="form-group md-5">
		<label for="specialist_id">Specialist ID</label>
		<form:input type="text" path="specialist_id" />
		</div>
		
		<div class="form-group md-5">
		<label for="specialist_username">User Name(*)</label>
		<form:input type="text" path="specialist_username" />
		<form:errors path="specialist_username" cssClass="error" />
		</div>

<div class="form-group md-5">
		<label for="specialist_password">Password(*)</label>
		<form:input type="password" path="specialist_password" />
		<form:errors path="specialist_password" cssClass="error" />
		</div>

<div class="form-group md-5">
		<label for="specialist_name">Name(*)</label>
		<form:input type="text" path="specialist_name" />
		<form:errors path="specialist_name" cssClass="error" />
		</div>

<div class="form-group md-5">
		<label for="specialist_experience">Experience</label>
		<form:input type="text" path="specialist_experience" />
		<form:errors path="specialist_experience" cssClass="error" />
		</div>

<div class="form-group md-5">
		<label>Contact(*)</label>
		<form:input type="text" path="specialist_contact" />
		<form:errors path="specialist_contact" cssClass="error" />
		</div>

<div class="form-group md-5">
		<label>Email(*)</label>
		<form:input type="text" path="specialist_email" />
		<form:errors path="specialist_email" cssClass="error" />
		</div>

<div class="form-group md-5">
		<label>Description(*)</label>
		<br>
		<form:textarea path="specialist_description" rows="5" cols="30" />
		<form:errors path="specialist_description" cssClass="error" />
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