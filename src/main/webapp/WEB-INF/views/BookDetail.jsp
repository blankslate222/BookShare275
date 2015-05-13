<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="edu.sjsu.cmpe275.bookshare.service.UserService,java.util.List"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Big shope A Ecommerce Category Flat Bootstarp Resposive
	Website Template | Product :: w3layouts</title>
<link href="${pageContext.request.contextPath}/css/css/bootstrap.css"
	rel="stylesheet" type="text/css" media="all">
<!--theme-style-->
<link href="${pageContext.request.contextPath}/css/css/style.css"
	rel="stylesheet" type="text/css" media="all">
<!--//theme-style-->
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<!--fonts-->
<link
	href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800"
	rel="stylesheet" type="text/css">
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
						<a href="${pageContext.request.contextPath}"><img
							src="${pageContext.request.contextPath}/images/logo.png" alt=" "></a>
					</div>

					<div class="clearfix"></div>
				</div>
				<div class="header-bottom-right">
					<div class="account">
						<a href="${pageContext.request.contextPath}/useraccount"><span>
						</span>YOUR ACCOUNT</a>
					</div>
					<ul class="login">
						<li><a href="${pageContext.request.contextPath}/sell/book">SELL</a></li>
						|
						<li><a href="${pageContext.request.contextPath}/book/request">REQUEST</a></li>
					</ul>


					<ul class="login">
						<li><a href="${pageContext.request.contextPath}">LOGOUT</a></li> |
						<li><a
							href="${pageContext.request.contextPath}/allrequestedbooks">ADs</a></li>
						<li><a href="${pageContext.request.contextPath}/search">ADVANCE
								SEARCH</a></li>
					</ul>

					<div class="clearfix"></div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!---->
	<!-- start content -->
	<div class="container"></div>
	<!---->

	<form:form action="${pageContext.request.contextPath}/"
		method="post" modelAttribute="book" class="form-horizontal" id="myform">
		<form:hidden path="id" />
		<fieldset>

			<!-- Form Name -->
			<legend>Share Book</legend>


			<div class="form-group">
				<label class="col-md-4 control-label" for="isbn"></label>
				<div class="col-md-5">
				<img
							src="${pageContext.request.contextPath}/images/bag.jpg" alt=" "><br>
					<form:input path="isbn" id="isbn" name="isbn" type="hidden"
						placeholder="" class="form-control input-md" required="" />
					Title:${book.title}<br> 
					Description:${book.description}<br>
					Condition: ${book.condition} <br>
					Price :${book.price}<br>
					Author: ${book.author}<br>
						<form:input path="title" id="title" name="title" type="hidden"
						placeholder="" class="form-control input-md" required="" />
							<form:input path="description" id="description" name="description" type="hidden"
						placeholder="" class="form-control input-md" required="" />
							<form:input path="condition" id="condition" name="condition" type="hidden"
						placeholder="" class="form-control input-md" required="" />
							<form:input path="price" id="price" name="price" type="hidden"
						placeholder="" class="form-control input-md" required="" />
							<form:input path="author" id="author" name="author" type="hidden"
						placeholder="" class="form-control input-md" required="" />
					<form:input path="isNegotiable" id="isNegotiable" name="isNegotiable" type="hidden"
						placeholder="" class="form-control input-md" required="" />
						<form:input path="user" id="user" name="user" type="hidden"
						placeholder="" class="form-control input-md" required="" />
				</div>
			</div>
			<!-- Button (Double) -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="submit"></label>
				<div class="col-md-8">
					<c:choose>
						<c:when test="${ book.isNegotiable == 'yes'}">
    Offer a lower price<input type="text" id="offerPrice" name="offerPrice" min="1" max="${ book.price }"/>
<button type="submit" id="offer" name="submit"
						onclick="return submitform(this.id)" class="btn btn-success">Make Offer</button>
						</c:when>
					</c:choose>
					<button type="submit" id="buy" name="submit"
						onclick="return submitform(this.id)" class="btn btn-success">Buy</button>
						
					<button id="cancel" name="cancel" class="btn btn-danger">cancel</button>
				</div>
			</div>

		</fieldset>
	</form:form>

${msg}

</body>
<script type="text/javascript">
	function submitform(operation) {

		if (operation == 'buy') {

			var action = "";
			action += "${pageContext.request.contextPath}/book/purchase";
			//alert(action);
			document.getElementById('myform').action = action;
			/*document.getElementById('updDel').method = "delete";*/

		}

		if (operation == 'offer') {
			var action = "";
			var offer = document.getElementById('offerPrice').value;
			
			action += "${pageContext.request.contextPath}/offer-bid/"+offer;
			//alert(action);
			document.getElementById('myform').action = action;

		}
	}
</script>
</html>