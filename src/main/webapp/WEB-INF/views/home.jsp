<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head>
<title>Big shope A Ecommerce Category Flat Bootstarp Resposive Website Template | Product :: w3layouts</title>
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


<!--script-->
</head>
<body> 
<%if(session.getAttribute("email")== null){%>
<jsp:forward page="${pageContext.request.contextPath}"></jsp:forward>
<%	
} %>
	<!--header-->
	<div class="header">
		
		<div class="bottom-header">
			<div class="container">
				<div class="header-bottom-left">
					<div class="logo">
						<a href="${pageContext.request.contextPath}"><img src="images/logo.png" alt=" "></a>
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
		
	<div class="women-product">
		
		<!-- grids_of_4 -->
		<div class="grid-product">
		  <div class="  product-grid">
			<div class="content_box"><a href="single.html">
			   	</a><div class="left-grid-view grid-view-left"><a href="single.html">
			   	   	 <img src="images/pic13.jpg" class="img-responsive watch-right" alt="">
				   	   	<div class="mask">
	                        <div class="info">Quick View</div>
			            </div>
				   	  </a>
				</div>
				    <h4><a href="#"> Duis autem</a></h4>
				     <p>It is a long established fact that a reader</p>
				     Rs. 499
			   	</div>
              </div>
			 <div class="  product-grid">
			<div class="content_box"><a href="single.html">
			   	</a><div class="left-grid-view grid-view-left"><a href="single.html">
			   	   	 <img src="images/pic2.jpg" class="img-responsive watch-right" alt="">
				   	   	<div class="mask">
	                        <div class="info">Quick View</div>
			            </div>
				   	  </a>
				   </div>
				    <h4><a href="#"> Duis autem</a></h4>
				     <p>It is a long established fact that a reader</p>
				     Rs. 499
			   	</div>
                 </div>
			 <div class="  product-grid">
			<div class="content_box"><a href="single.html">
			   	</a><div class="left-grid-view grid-view-left"><a href="single.html">
			   	   	 <img src="images/pic3.jpg" class="img-responsive watch-right" alt="">
				   	   	<div class="mask">
	                        <div class="info">Quick View</div>
			            </div>
				   	  </a>
				   </div>
				    <h4><a href="#"> Duis autem</a></h4>
				     <p>It is a long established fact that a reader</p>
				     Rs. 499
			   	</div>
                 </div>
				
		  
			
			
			<div class="clearfix"> </div>
		</div>
	</div>
	<div class="sub-cate">
				
				<!--initiate accordion-->
		<script type="text/javascript">
			$(function() {
			    var menu_ul = $('.menu > li > ul'),
			           menu_a  = $('.menu > li > a');
			    menu_ul.hide();
			    menu_a.click(function(e) {
			        e.preventDefault();
			        if(!$(this).hasClass('active')) {
			            menu_a.removeClass('active');
			            menu_ul.filter(':visible').slideUp('normal');
			            $(this).addClass('active').next().stop(true,true).slideDown('normal');
			        } else {
			            $(this).removeClass('active');
			            $(this).next().stop(true,true).slideUp('normal');
			        }
			    });
			
			});
		</script>
					<div class=" chain-grid menu-chain">
	   		     		<a href=""><img class="img-responsive chain" src="images/wat.jpg" alt=" "></a>	   		     		
	   		     		<div class="grid-chain-bottom chain-watch">
		   		     		<span class="actual dolor-left-grid">300$</span>
		   		     		<span class="reducedfrom">500$</span>  
		   		     		<h6>Lorem ipsum dolor</h6>  		     			   		     										
	   		     		</div>
	   		     	</div>
	   		     		
			</div>
	<div class="clearfix"> </div>
</div>
	<!---->
	

</body></html>