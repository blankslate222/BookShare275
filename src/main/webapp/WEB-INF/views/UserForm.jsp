<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../css/bootstrap.min.css"/>
<link rel="stylesheet" href="../css/style.css"/>
<script src="../js/jquery-2.1.3.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<title>New or Edit User</title>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">Bookshare</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
  </div><!-- /.container-fluid -->
</nav>
<div class="background"></div>
<div class="content">
<div class="col-md-12 text-center">
	<h1>New/Edit User</h1>
	<form:form action="save" method="post" modelAttribute="user" class="form-horizontal">
	<form:hidden path="id"/>
	<div class="form-group">
		
		<div class="col-md-8">
			<form:input path="firstname" class="form-control" placeholder="Firstname"/>
		</div>
	</div>
	<div class="form-group">
		<div class="col-md-8">
			<form:input path="lastname" class="form-control" placeholder="Lastname"/>
		</div>
	</div>
	<div class="form-group">
		<div class="col-md-8">
			<form:input path="email" class="form-control" placeholder="Email"/>
		</div>
	</div>
	<div class="form-group">
		<div class="col-md-8">
			<form:password path="password" class="form-control" placeholder="Password"/>
		</div>
	</div>
	<div class="form-group">
		<div class="col-md-8">
			<form:input path="address" class="form-control" placeholder="Address"/>
		</div>
	</div>
	<input type="submit" value="Save" class="btn btn-info">
	</form:form>
</div>
</div>
</body>
</html>