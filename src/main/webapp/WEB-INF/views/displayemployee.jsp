<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${not empty requestScope.empObject}">
			<p>Employee Department Number:
				${requestScope.empObject.deptNumber}</p>
			<p>Employee DoJ: ${requestScope.empObject.doJ}</p>
			<p>Employee DoB: ${requestScope.empObject.doB}</p>
			<p>Employee Salary: ${requestScope.empObject.salary}</p>
			<p>Employee Salary Grade: ${requestScope.empObject.salGrade}</p>
		</c:when>
		<c:otherwise>
   No employee Exists with that ID
  </c:otherwise>
	</c:choose>



</body>
</html>