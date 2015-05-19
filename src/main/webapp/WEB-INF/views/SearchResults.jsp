<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="edu.sjsu.cmpe275.bookshare.service.UserService,java.util.List"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>BOOKSHARE | Search Results</title>
<link href="${pageContext.request.contextPath}/css/css/bootstrap.css" rel="stylesheet" type="text/css" media="all">
<link href="${pageContext.request.contextPath}/css/css/style.css" rel="stylesheet" type="text/css" media="all">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/css/etalage.css" type="text/css" media="all">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
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

					<div class="clearfix"></div>
				</div>
				<div class="header-bottom-right">
					<div class="account">
						<a href="${pageContext.request.contextPath}/useraccount"><span> </span>YOUR ACCOUNT</a>
					</div>
					<ul class="login">
						<li><a href="${pageContext.request.contextPath}/sell/book">SELL</a></li> |
						<li><a href="${pageContext.request.contextPath}/book/request">REQUEST</a></li>
					</ul>


					<ul class="login">
						<li><a href="${pageContext.request.contextPath}">LOGOUT</a></li> |
						<li><a href="${pageContext.request.contextPath}/allrequestedbooks">ADs</a></li>
						<li><a href="${pageContext.request.contextPath}/search">ADVANCE SEARCH</a></li>
					</ul>

					<div class="clearfix"></div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>


	<div class="container">
	<h3>Search Results</h3>
	<p>Search parameter : ${searchTerm}</p>
	<c:choose>
		<c:when test="${ not empty books }">
			<ul>
				<c:forEach var="buk" items="${books}">
					<img src="${pageContext.request.contextPath}/images/wat.gif"/>
					<li><a href="${pageContext.request.contextPath}/details/book/id/${buk.id}">${buk.title}</a></li>
				</c:forEach>
			</ul>
		</c:when>
		<c:when test="${not empty book }">
		<img src=""/>
		<a href="${pageContext.request.contextPath}/details/book/id/${book.id}">${book.title}</a>
		</c:when>
		<c:otherwise>
			<p>No matches found</p>
		</c:otherwise>
	</c:choose>
	</div>


</body>
</html>