<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Home Page</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
</head>
<body>
	<%
	System.out.print("iscustomerlogin");
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);

	if (session.getAttribute("iscustomerlogin") == null) {
		response.sendRedirect("/HealthCareManagement/");
	}
	%>
	<div class="container">
		<h1 align="center">Customer Dashboard</h1>


		<br>
		<div align="center">
			<i>Meeting data coming soon...</i>
			<table border=1>
				<thead>
					<tr>
						<td>Meeting Id</td>
						<td>Customer Id</td>
						<td>Specialist Id</td>
						<td>Date</td>
						<td>Time</td>
						<td>Location</td>
						<td>Logistics</td>
						<td>Operation</td>
					</tr>
				</thead>


				<c:forEach var="meeting" items="${meeting}">
					<tr>

						<td>${meeting.meeting_id }</td>
						<td>${meeting.customer_id }</td>
						<td>${meeting.specialist_id}</td>
						<td>${meeting.date }</td>
						<td>${meeting.time }</td>
						<td>${meeting.location }</td>
						<td>${meeting.logistics }</td>
						<td><a
							href="updateCustomerMeetingForm?id=${meeting.meeting_id}">Edit</a>
							<a href="deleteMeeting?id=${meeting.meeting_id}"
							onclick="if (!(confirm('Do you really want to delete this meeting record?'))) return false">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</table>

		</div>
		<br> <br>
		<hr>
		<div align="center">
			<i>Specialists data coming soon...</i> <br>

			<table border=1>
				<thead>
					<tr>
						<td>Specialist Id</td>
						<td>Specialist Name</td>
						<td>Specialist Experience</td>
						<td>Specialist Description</td>
						<td>Specialist Contact</td>
						<td>Specialist Email</td>
						<td>Choose</td>
					</tr>
				</thead>


				<c:forEach var="specialist" items="${specialist}">
					<tr>
						<td>${specialist.specialist_id }</td>
						<td>${specialist.specialist_name }</td>
						<td>${specialist.specialist_experience }</td>
						<td>${specialist.specialist_description }</td>
						<td>${specialist.specialist_contact }</td>
						<td>${specialist.specialist_email }</td>
						<td><a
							href="showCustomerMeetingForm?specialist_id=${specialist.specialist_id}&customer_id=${customer.customer_id}">Choose
								(+)</a></td>
					</tr>
				</c:forEach>




			</table>
		</div>
		<br> <br> <a href="logoutCustomer"> <input type="submit"
			value="Logout">
		</a>
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