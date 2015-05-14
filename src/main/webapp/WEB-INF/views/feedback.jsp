<%@ page language="java" contentType="text/html; charset=UTF-8" import="edu.sjsu.cmpe275.bookshare.service.UserService,java.util.List"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html><head>
<title>BOOKSHARE | FEEDBACK</title>
<link href="${pageContext.request.contextPath}/css/css/bootstrap.css" rel="stylesheet" type="text/css" media="all">
<!--theme-style-->
<link href="${pageContext.request.contextPath}/css/css/style.css" rel="stylesheet" type="text/css" media="all">	
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--fonts-->
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800" rel="stylesheet" type="text/css">
<!--//fonts-->
<script src="${pageContext.request.contextPath}/js/js/jquery.min.js"></script>


<!--script-->
</head>
<body> 
	<!--header-->
	<div class="header">
		
		<div class="bottom-header">
			<div class="container">
				<div class="header-bottom-left">
					<div class="logo">
						<a href="${pageContext.request.contextPath}/home"><img src="${pageContext.request.contextPath}/images/logo.png" alt=" "></a>
					</div>
					
					<div class="clearfix"> </div>
				</div>
				<div class="header-bottom-right">					
						<div class="account"><a href="${pageContext.request.contextPath}/useraccount"><span> </span>YOUR ACCOUNT</a></div>
							<ul class="login"><li><a href="${pageContext.request.contextPath}/sell/book">SELL</a></li> | <li><a href="${pageContext.request.contextPath}/book/request">REQUEST</a></li></ul>


<ul class="login"><li><a href="${pageContext.request.contextPath}">LOGOUT</a></li> | <li><a href="${pageContext.request.contextPath}/requests">ADs</a></li><li><a href="${pageContext.request.contextPath}/search">ADVANCE SEARCH</a></li>| <li><a href="${pageContext.request.contextPath}/book/all">BOOKS AVAILABLE</a></li></ul>
						
					<div class="clearfix"> </div>
				</div>
				<div class="clearfix"> </div>	
			</div>
		</div>
	</div>
	<!---->
	<!-- start content -->
	<div class="container">
		
<form:form action="${pageContext.request.contextPath}/update-feedback" method="post" modelAttribute="order" class="form-horizontal">
<form:hidden path="id"/>
<fieldset>

<!-- Form Name -->
<legend>Share Book</legend>

<!-- Text input-->
<h2>Thank you for using Bookshare</h2>
<h3>
Your Order Summary
</h3>
Book ISBN: ${order.isbn}
Sold By: ${order.seller}
Price: ${order.price}
<p>Your feedback is valuable to us</p>
<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="condition">Ratings</label>
  <div class="col-md-4">
    <form:select path="rating" id="rating" name="rating" class="form-control">
      <option value="1">1</option>
      <option value="2">2</option>
      <option value="3">3</option>
      <option value="4">4</option>
      <option value="5">5</option>
    	 </form:select>
  </div>
</div>

<!-- Textarea -->
<div class="form-group">
  <label class="col-md-4 control-label" for="description">Feedback</label>
  <div class="col-md-4">                     
    <form:textarea path="feedback" class="form-control" id="feedback" name="feedback"/></textarea>
  </div>
</div>



<!-- Button (Double) -->
<div class="form-group">
  <label class="col-md-4 control-label" for="submit"></label>
  <div class="col-md-8">
    <button type = "submit" id="submit" name="submit" class="btn btn-success">Submit</button>
    <button id="cancel" name="cancel" class="btn btn-danger">Cancel</button>
  </div>
</div>

</fieldset>
</form:form>
</div>
	<!---->
</body></html>