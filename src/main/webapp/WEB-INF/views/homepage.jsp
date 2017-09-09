<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<link rel="stylesheet" href="bootstrap-overridden.css" />
</head>
<body>
	<div class="container container-small">
		<div class="alert alert-warning">
			<h1 style="color: blue;">Select here!</h1>
			<strong>*</strong> Select the required option
		</div>

		<div class="form-group">
			<!-- <label class="control-label col-sm-4">Employee ID:<span  style="color:red">*</span> </label> -->
			<form action="/employee">
				<button type="submit" class="btn btn-primary">Click here
					to enter employee ID</button>
			</form>
		</div>
		<div class="form-group">
			<!-- <label class="control-label col-sm-4">Department ID:<span  style="color:red">*</span></label> -->
			<form action="/department">
				<button type="submit" class="btn btn-primary" onclick="validate()">Click
					here to enter department ID</button>
			</form>
		</div>
	</div>
</body>
</html>