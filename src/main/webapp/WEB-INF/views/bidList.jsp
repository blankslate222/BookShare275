<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="edu.sjsu.cmpe275.bookshare.service.UserService,java.util.List"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>BOOKSHARE | MY OFFERS</title>
<link href="${pageContext.request.contextPath}/css/css/bootstrap.css" rel="stylesheet" type="text/css" media="all">

<link href="${pageContext.request.contextPath}/css/css/style.css" rel="stylesheet" type="text/css" media="all">	
<link rel="stylesheet" href="css/etalage.css" type="text/css" media="all">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/js/js/jquery.min.js"></script>
</head>
<body> 
	<!--header-->
	<div class="header">
		
		<div class="bottom-header">
			<div class="container">
				<div class="header-bottom-left">
					<div class="logo">
						<a href="${pageContext.request.contextPath}/useraccount"><img src="${pageContext.request.contextPath}/images/logo.png" alt=" "></a>
					</div>
					
					<div class="clearfix"> </div>
				</div>
				<div class="header-bottom-right">					
						<div class="account"><a href="${pageContext.request.contextPath}/home"><span> </span>HOME</a></div>
							


<ul class="login"><li><a href="${pageContext.request.contextPath}">LOGOUT</a></li> | <li></li><li><a href="${pageContext.request.contextPath}/search">ADVANCE SEARCH</a></li></ul>
						
					<div class="clearfix"> </div>
				</div>
				<div class="clearfix"> </div>	
			</div>
		</div>
	</div>

	
	 <div class="container"> 
	
		<c:forEach var="bid" items="${bids}">
	 <h4><strong>Book Id :</strong> <a href="${pageContext.request.contextPath}/details/book/id/${bid.bookId }">${bid.bookId }</a></h4><br>
	 <h4><strong>Bidder :</strong> ${bid.bidderEmail }</h4><br>
	 <h4><strong>Offered Price :</strong> ${bid.offerPrice}</h4><br>
	 <form action = "${pageContext.request.contextPath}/accept-offer" method = "post">
		<input type = "hidden" id = "bidId" name = "bidId" value = "${bid.id }"/>
		<input type="submit" value="Accept" class="btn btn-success"/>
		</form>
		</c:forEach>
	 	</div>
</body>
</html>