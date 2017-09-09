<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Getting Employee Info By ID</title>
</head>
<body>
	<c:choose>
		<c:when test="${not empty requestScope.empObject}">
			<form id="update" method="get">
				<input type="hidden" id="empNo" name="empNo" /> <input
					id="operations" name="operations" />
				<table cellspacing="10" border="1">
					<tr>
						<td>Employee No.</td>
						<td>Department No.</td>
						<td>DoJ</td>
						<td>DoB</td>
						<td>salary</td>
						<td>Salary Grade</td>
					</tr>

					<c:forEach items="${requestScope.empObject}" var="emp">
						<tr>
							<td>${emp.number}</td>
							<td>${emp.deptNumber}</td>
							<td>${emp.doJ}</td>
							<td>${emp.doB}</td>
							<td>${emp.salary}</td>
							<td>${emp.salGrade}</td>

							<td><input type="button" value="Update"
								onclick="updateFunction(${emp.number})"></td>
							<td><input type="button" value="Delete"
								onclick="deleteFunction(${emp.number})"></td>
						</tr>

					</c:forEach>
				</table>
			</form>
		</c:when>
		<c:otherwise>

		</c:otherwise>
	</c:choose>




</body>
<script>
function updateFunction(id){
	$("#empNo").val(id);
	$("#operations").val("updateOperFrmDept");
	$("#update").attr("action","/update");
	$("#update").submit();
	
}
function delteFunction(id){
	$("#empNo").val(id);
	$("#operations").val("deleteOper");
	$("#update").attr("action","/delete");
	$("#update").submit();
	
}
</script>
</html>