<%@ page language="java" contentType="text/html; charset=UTF-8" import="edu.sjsu.cmpe275.bookshare.service.UserService,java.util.List"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html><head>
<title>BOOKSHARE | SEARCH</title>
<link href="${pageContext.request.contextPath}/css/css/bootstrap.css" rel="stylesheet" type="text/css" media="all">
<link href="${pageContext.request.contextPath}/css/css/style.css" rel="stylesheet" type="text/css" media="all">	
<link rel="stylesheet" href="css/etalage.css" type="text/css" media="all">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/js/js/jquery.min.js"></script>
</head>
<body> 
	
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
	
	 <div class="container"> 
	 	

<legend>Advance Search</legend> 	

<form action="${pageContext.request.contextPath}/search/title" method="get" class="form-horizontal">

<fieldset>
<div class="form-group">
  <label class="col-md-4 control-label" for="title">Search By Title</label>  
  <div class="col-md-5">
  <input id="title" name="title" type="text" placeholder="Book title" class="form-control input-md" required=""/>
    
  </div>
</div>
<div class="form-group">
  <label class="col-md-4 control-label" for="submit"></label>
  <div class="col-md-8">
    <button type = "submit" id="submit" name="submit" class="btn btn-success">Search</button>
   
  </div>
</div>

</fieldset>
</form>

<form action="${pageContext.request.contextPath}/search/author" method="get" class="form-horizontal">

<fieldset>
<div class="form-group">
  <label class="col-md-4 control-label" for="title">Search By Author</label>  
  <div class="col-md-5">
  <input id="author" name="author" type="text" placeholder="Book Author" class="form-control input-md" required=""/>
    
  </div>
</div>
<div class="form-group">
  <label class="col-md-4 control-label" for="submit"></label>
  <div class="col-md-8">
    <button type = "submit" id="submit" name="submit" class="btn btn-success">Search</button>
   
  </div>
</div>

</fieldset>
</form>

<form action="${pageContext.request.contextPath}/search/isbn" method="get" class="form-horizontal">

<fieldset>
<div class="form-group">
  <label class="col-md-4 control-label" for="title">Search By ISBN</label>  
  <div class="col-md-5">
  <input id="isbn" name="isbn" type="text" placeholder="Book Isbn" class="form-control input-md" required=""/>
    
  </div>
</div>
<div class="form-group">
  <label class="col-md-4 control-label" for="submit"></label>
  <div class="col-md-8">
    <button type = "submit" id="submit" name="submit" class="btn btn-success">Search</button>
  </div>
</div>

</fieldset>
</form>
</div>
</body>
</html>