<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html><head>
<title>Big shope A Ecommerce Category Flat Bootstarp Resposive Website Template | Register :: w3layouts</title>
<link href="css/css/bootstrap.css" rel="stylesheet" type="text/css" media="all">
<!--theme-style-->
<link href="css/css/style.css" rel="stylesheet" type="text/css" media="all">	
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--fonts-->
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800" rel="stylesheet" type="text/css">
<!--//fonts-->
<script src="js/js/jquery.min.js"></script>


</head>
<body> 
	<!--header-->
	<div class="header">
		
		<div class="bottom-header">
			<div class="container">
				<div class="header-bottom-left">
					<div class="logo">
						<a href="${pageContext.request.contextPath}/"><img src="images/logo.png" alt=" "></a>
					</div>
				</div>
				<div class="header-bottom-right">					
				</div>
				<div class="clearfix"> </div>	
			</div>
		</div>
	</div>
	<!---->
	<div class="container"> 

		<div class="register">
		  	  <form:form action="update" method="post" modelAttribute="user">
		  	   <form:hidden path="id"/>
				 <div class="  register-top-grid">
					<h3>UPDATE PERSONAL INFORMATION</h3>
					<div class="mation">
						<span>First Name<label>*</label></span>
						<form:input path = "firstname" type="text"/> 
						<span>Last Name<label>*</label></span>
						<form:input path = "lastname" type="text"/> 
					 <span>Address<label>*</label></span>
						<form:input path = "address" type="text"/> 
					<%-- 	 <span>Email Address<label>*</label></span>
						 <form:input path = "email" type="text" disabled/> 
						 <span>Password<label>*</label></span>
						 <form:input path = "password" type="password" disabled/>  --%>
					</div>
					 <div class="clearfix"> </div>
					   <a class="news-letter" href="#">
						 
					   </a>
					 </div>
				     
			
				<div class="clearfix"> </div>
				<div class="register-but">
				  
					   <input type="submit" value="update">
					   <div class="clearfix"> </div>
				
				</div>
					</form:form>
		   </div>
		         
	</div>
	<!---->
	

</body></html>