<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
/* Set height of the grid so .sidenav can be 100% (adjust as needed) */
.row.content {
	height: 550px
}
/* Set gray background color and 100% height */
.sidenav {
	background-color: #f1f1f1;
	height: 100%;
}
/* On small screens, set height to 'auto' for the grid */
@media screen and (max-width: 767px) {
	.row.content {
		height: auto;
	}
}
</style>
</head>
<body>

	<nav class="navbar navbar-inverse visible-xs">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Logo</a>
			</div>
		</div>
	</nav>

	<div class="container-fluid">
		<div class="row content">
			<div class="col-sm-3 sidenav hidden-xs">
				<h2>Logo</h2>
				<ul class="nav nav-pills nav-stacked">
					<li><a id="add" href="#add">Add</a></li>
					<li><a id="delete" href="#delete">Delete</a></li>
					<li><a id="update" href="#update">Update</a></li>
					<li><a id="search" href="#search">Search</a></li>
				</ul>
				<br>
			</div>
			<br>
			<div id="msg">
				<br> <br>
				<c:if test="${not empty requestScope.msg}">${requestScope.msg}</c:if>
			</div>

			<div class="col-sm-4">
				<form id="addAction" action="/addEmployee"
					style="display: none" method = "post">
					<input type = "hidden" name = "hidden" value = "add">
					<h2 style="color: blue;">Add an Employee here!</h2>
					Department Number: <input type="number" name="deptNumber"><br>
					<br> DoB: <input id="dateb" type="date" name="DoB"><br>
					<br> DoJ: <input id="datej" type="date" name="DoJ"><br>
					<br> Salary: <input type="text" name="salary"><br>
					<br> Salary Grade: <input type="text" name="salGrade"><br>
					<br> <input type="submit" value="submit">
				</form>
			</div>
			<div class="col-sm-8">
				<form id="updateAction" action="/update" method = "get" style="display: none">
					Employee Number: <input type="number" name="id"> <input
						type="submit" value="submit">
				</form>
			</div>

			<div class="col-sm-8">
				<form id="deleteAction" action="/delete" method = "get" style="display: none">
				<input type = "hidden" name = "hidden" value = "delete">
					Employee Number: <input type="number" name="id"> <input
						type="submit" value="submit">
				</form>
			</div>

			<div class="col-sm-8">
				<form id="searchAction" action="/getEmployee" style="display: none" method = "get">
				<input type = "hidden" name = "hidden" value = "search">
					Employee Number: <input type="number" name="id"> <input
						type="submit" value="submit">
				</form>
			</div>

		</div>
	</div>

	<script>
		$(document).ready(function() {
			$("#add").click(function() {
				$("#addAction").show();
				$("#updateAction").hide();
				$("#searchAction").hide();
				$("#deleteAction").hide();
				$("#msg").hide();
			});
		});
		$(document).ready(function() {
			$("#update").click(function() {
				$("#updateAction").show();
				$("#addAction").hide();
				$("#deleteAction").hide();
				$("#searchAction").hide();
				$("#msg").hide();
			});
		});
		$(document).ready(function() {
			$("#delete").click(function() {
				$("#deleteAction").show();
				$("#addAction").hide();
				$("#updateAction").hide();
				$("#searchAction").hide();
			});
		});
		$(document).ready(function() {
			$("#search").click(function() {
				$("#searchAction").show();
				$("#deleteAction").hide();
				$("#addAction").hide();
				$("#updateAction").hide();
				$("#msg").hide();
			});
		});
	</script>


</body>
</html>	