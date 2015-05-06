<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html><head>
<title>BOOKSHARE| Login </title>
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
		
      	   <div class="account_grid">
			   <div class=" login-right">
			  	<h3>REGISTERED USERS</h3>
				<p>If you have an account with us, please log in.</p>
				<form:form action="signin" method="post" modelAttribute="user">
			
				  <div>
					<span>Email Address<label>*</label></span>
					<form:input path = "email" type="text"/> 
				  </div>
				  <div>
					<span>Password<label>*</label></span>
					<form:input path = "password" type="password"/> 
				  </div>
				 
				  <input type="submit" value="Login">
			    </form:form>
			    <p> <%if(request.getParameter("message")!=null){ %>
 <%=request.getParameter("message") %>

<%} %></p>
			   </div>	
			    <div class=" login-left">
			  	 <h3>NEW USERS</h3>
				 
				 <a class="acount-btn" href="register">Create an Account</a>
			   </div>
			   <div class="clearfix"> </div>
			 </div>
			 
			  <div class="clearfix"> </div>
      	 </div>
	<!---->
	<div class="footer">
		<div class="footer-top">
			
		</div>
		<div class="footer-bottom">
			
		</div>
	</div>

</body></html>