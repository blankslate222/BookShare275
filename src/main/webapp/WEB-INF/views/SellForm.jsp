<%@ page language="java" contentType="text/html; charset=UTF-8" import="edu.sjsu.cmpe275.bookshare.service.UserService,java.util.List"
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
<title>Sell Book</title>
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

  </div>
</nav>
<div class="background"></div>
<div class="content">
<div class="col-md-12 text-center">
	<h1>Sell Book</h1>
	<form:form action="/sellbook" method="post" modelAttribute="book" class="form-horizontal">
	<form:hidden path="id"/>
	<div class="form-group">
		
		<div class="col-md-8">
			<form:input path="isbn" class="form-control" placeholder="ISBN"/>
		</div>
	</div>
	<div class="form-group">
		<div class="col-md-8">
			<form:input path="title" class="form-control" placeholder="TITLE"/>
		</div>
	</div>
	<div class="form-group">
		<div class="col-md-8">
			<form:input path="description" class="form-control" placeholder="DESCRIPTION"/>
		</div>
	</div>
	<div class="form-group">
		<div class="col-md-8">
			<form:input path="condition" class="form-control" placeholder="CONDITION"/>
		</div>
	</div>
	<div class="form-group">
		<div class="col-md-8">
			<form:input path="price" class="form-control" placeholder="PRICE"/>
		</div>
	</div>
		<div class="form-group">
		<div class="col-md-8">
			<form:input path="author" class="form-control" placeholder="AUTHOR"/>
		</div>
	</div>
		<div class="form-group">
		<div class="col-md-8">
			<form:input path="status" class="form-control" placeholder="STATUS"/>
		</div>
	</div>
	
<%-- 		<%
		List<String> userNames = null;
		try{
			UserService userService = new UserService();
			userNames = userService.getUserNames();
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		%> --%>
		<div class="form-group">
		<div class="col-md-8">
		<form:select path="user" class="form-control">
<%-- 		 <%
		 if(userNames != null){
		 for(int i=0; i<userNames.size(); i++){
			
		 %>
		 <option value=<%=userNames.get(i) %>><%=userNames.get(i) %></option>
		 <%}} %>
		  --%>
		 </form:select>
		</div>
	</div>
		
	<input type="submit" value="Save" class="btn btn-info">
	</form:form>
</div>
</div>
</body>
</html>