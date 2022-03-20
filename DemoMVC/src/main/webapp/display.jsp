<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

Add two numbers--> <br> 
<!-- can use this -->
<%-- Result is: <%= request.getAttribute("result") %> --%>

<!-- but to save time we use el expressions -->
Result is: ${result}


</body>
</html>