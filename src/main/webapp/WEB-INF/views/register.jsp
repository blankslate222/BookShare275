<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html><head>
<title>BOOKSHARE| Register </title>
<link href="css/css/bootstrap.css" rel="stylesheet" type="text/css" media="all">
<link href="css/css/style.css" rel="stylesheet" type="text/css" media="all">	
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800" rel="stylesheet" type="text/css">
<script src="js/js/jquery.min.js"></script>
</head>
<body> 

	<div class="header">
		
		<div class="bottom-header">
			<div class="container">
				<div class="header-bottom-left">
					<div class="logo">
						<a href="${pageContext.request.contextPath}/"><img src="images/logo.png" alt=" "></a>
					</div>
				
					<div class="clearfix"> </div>
				</div>
				<div class="header-bottom-right">					
						
							<ul class="login">
								<li><a href="login"><span> </span>LOGIN</a></li> |
								<li><a href="register">SIGNUP</a></li>
							</ul>
						
					<div class="clearfix"> </div>
				</div>
				<div class="clearfix"> </div>	
			</div>
		</div>
	</div>
	<!---->
	<div class="container"> 
			         
		<div class="register">
		  	  <form:form action="save" method="post" modelAttribute="user">
		  	   <form:hidden path="id"/>
				 <div class="  register-top-grid">
					<h3>PERSONAL INFORMATION</h3>
					<div class="mation">
						<span>First Name<label>*</label></span>
						<form:input path = "firstname" type="text"/> 
					
						<span>Last Name<label>*</label></span>
						<form:input path = "lastname" type="text"/> 
					 <span>Address<label>*</label></span>
						<form:input path = "address" type="text"/> 
						 <span>Email Address<label>*</label></span>
						 <form:input path = "email" type="text"/> 
						 <span>Password<label>*</label></span>
						 <form:input path = "password" type="password"/> 
					</div>
					 <div class="clearfix"> </div>
					   <a class="news-letter" href="#">
						 
					   </a>
					 </div>
				     
			
				<div class="clearfix"> </div>
				<div class="register-but">
				  
					   <input type="submit" value="submit">
					   <div class="clearfix"> </div>
				
				</div>
				 <p> <%if(request.getParameter("message")!=null){ %>
 <%=request.getParameter("message") %>

<%} %></p>
					</form:form>
		   </div>
		         
	</div>

	</body>
	</html>