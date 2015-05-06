<%@ page language="java" contentType="text/html; charset=UTF-8" import="edu.sjsu.cmpe275.bookshare.service.UserService,java.util.List"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html><head>
<title>Big shope A Ecommerce Category Flat Bootstarp Resposive Website Template | Product :: w3layouts</title>
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


<ul class="login"><li><a href="${pageContext.request.contextPath}">LOGOUT</a></li> | <li><a href="${pageContext.request.contextPath}/allrequestedbooks">ADs</a></li><li><a href="${pageContext.request.contextPath}/search">ADVANCE SEARCH</a></li></ul>
						
					<div class="clearfix"> </div>
				</div>
				<div class="clearfix"> </div>	
			</div>
		</div>
	</div>
	<!---->
	<!-- start content -->
	<div class="container">
		
	
	
	
</div>
	<!---->
	
	<form:form action="${pageContext.request.contextPath}/book/request" method="post" modelAttribute="book" class="form-horizontal">
<form:hidden path="id"/>
<fieldset>

<!-- Form Name -->
<legend>Request A Book</legend>

<!-- Text input-->

<div class="form-group">
  <label class="col-md-4 control-label" for="title">Title</label>  
  <div class="col-md-5">
  <form:input path="title" id="title" name="title" type="text" placeholder="Book title" class="form-control input-md" required=""/>
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="authors">Authors</label>  
  <div class="col-md-5">
  <form:input path="author" id="authors" name="authors" type="text" placeholder="Authors" class="form-control input-md" required=""/>
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="isbn">ISBN</label>  
  <div class="col-md-5">
  <form:input path="isbn" id="isbn" name="isbn" type="text" placeholder="ISBN" class="form-control input-md" required=""/>
    
  </div>
</div>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="condition">Condition</label>
  <div class="col-md-4">
    <form:select path="condition" id="condition" name="condition" class="form-control">
      <option value="new">New</option>
      <option value="old">Old</option>
      <option value="good">Good</option>
      <option value="used">Used</option>
    	 </form:select>
  </div>
</div>

<!-- Textarea -->
<div class="form-group">
  <label class="col-md-4 control-label" for="description">Description</label>
  <div class="col-md-4">                     
    <form:textarea path="description" class="form-control" id="description" name="description"/></textarea>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="price">Price Range($)</label>  
  <div class="col-md-4">
  <form:input path="price" id="price" name="price" type="text" placeholder="Price" class="form-control input-md" required=""/>
    
  </div>
</div>

<!-- Button (Double) -->
<div class="form-group">
  <label class="col-md-4 control-label" for="submit"></label>
  <div class="col-md-8">
    <button type = "submit" id="submit" name="submit" class="btn btn-success">Submit</button>
    <button type = "reset" id="cancel" name="cancel" class="btn btn-danger">cancel</button>
  </div>
</div>

</fieldset>
</form:form>

	

</body></html>