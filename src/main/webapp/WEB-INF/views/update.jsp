<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${not empty requestScope.empObject}">
		<form action="/update" method = "post">
			Employee Number:<input type = "hidden" name = "empNo" value = "${requestScope.empObject.number}"  ><br><br>
			Employee Department Number:<input type = "number" name = "deptNo" value = "${requestScope.empObject.deptNumber}"><br><br>
			Employee DoJ: <input id="datej" type="date" name="DoJ" value=<fmt:formatDate pattern='yyyy-MM-dd' value='${requestScope.empObject.doJ}'/>><br><br>
			Employee DoB: <input id="dateb" type="date" name="DoB" value=<fmt:formatDate pattern='yyyy-MM-dd' value='${requestScope.empObject.doB}'/>><br><br>
			Employee Salary: <input type="text" name="salary" value = "${requestScope.empObject.salary}"> <br><br>
			Employee Salary Grade: <input type="text" name="salgrade" value = "${requestScope.empObject.salGrade}"><br><br>
			<input type="submit" value="submit">
			</form>
		</c:when>
		<c:otherwise>
   No employee Exists with that ID
  </c:otherwise>
	</c:choose>



</body>
</html>

