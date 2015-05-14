<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="edu.sjsu.cmpe275.bookshare.service.UserService,java.util.List"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html><head>
<title>BOOKSHARE | SALES HISTORY</title>
<link href="${pageContext.request.contextPath}/css/css/bootstrap.css" rel="stylesheet" type="text/css" media="all">
<!--theme-style-->
<link href="${pageContext.request.contextPath}/css/css/style.css" rel="stylesheet" type="text/css" media="all">	
<link rel="stylesheet" href="css/etalage.css" type="text/css" media="all">
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--fonts-->
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800" rel="stylesheet" type="text/css">
<!--//fonts-->
<script src="${pageContext.request.contextPath}/js/js/jquery.min.js"></script>

<script src="js/jquery.etalage.min.js"></script>
<script>
			jQuery(document).ready(function($){

				$('#etalage').etalage({
					thumb_image_width: 300,
					thumb_image_height: 400,
					source_image_width: 900,
					source_image_height: 1200,
					show_hint: true,
					click_callback: function(image_anchor, instance_id){
						alert('Callback example:\nYou clicked on an image with the anchor: "'+image_anchor+'"\n(in Etalage instance: "'+instance_id+'")');
					}
				});

			});
		</script>

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
						<div class="account"><a href="${pageContext.request.contextPath}/useraccount"><span> </span>YOUR ACCOUNT</a></div>
							


<ul class="login"><li><a href="${pageContext.request.contextPath}/">LOGOUT</a></li> | <li><a href="${pageContext.request.contextPath}/search">ADVANCE SEARCH</a></li></ul>
						
					<div class="clearfix"> </div>
				</div>
				<div class="clearfix"> </div>	
			</div>
		</div>
	</div>
	<!---->
	
	 <div class="container"> 
	 	 	<h3>Your sales history</h3>
	 	<c:choose>
		<c:when test="${ not empty history }">
			<table>
	 	<tr><th>Date</th><th>Purchased By</th><th>ISBN</th><th>Price</th></tr>
	 		<c:forEach var = "purchase" items = "${history}" >
	 		<tr>
	 		<td>${ purchase.orderDate.getTime().toString()}</td>
	 		<td>${ purchase.buyer }</td>
	 		<td>${ purchase.isbn }</td>
	 		<td>${purchase.price}</td>
	 		</c:forEach>
	 		</table>
		</c:when>
		<c:otherwise>
			<p>No history found</p>
		</c:otherwise>
	</c:choose> 
	 </div>
	

</body></html>