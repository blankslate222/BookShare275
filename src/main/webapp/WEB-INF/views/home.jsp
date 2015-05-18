<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head>
<title>BOOKSHARE| Home </title>
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

<meta name="google-translate-customization" content="832e45d6fb214c99-b714140db595e3d8-g484b20115371f2a3-24"></meta>

<!--script-->
</head>
<body> 
<%if(session.getAttribute("user")== null || session.getAttribute("user").equals("Guest") ){%>
<jsp:forward page="${pageContext.request.contextPath}"></jsp:forward>
<%	
} %>
	<!--header-->
	<div class="header">
		
		<div class="bottom-header">
			<div class="container">
				<div class="header-bottom-left">
					<div class="logo">
						<a href="${pageContext.request.contextPath}/home"><img src="images/logo.png" alt=" "></a>
					</div>
					
					<div class="clearfix"> </div>
				</div>
				<div class="header-bottom-right">					
						<div class="account"><a href="${pageContext.request.contextPath}/useraccount"><span> </span>YOUR ACCOUNT</a></div>
							<ul class="login"><li><a href="${pageContext.request.contextPath}/sell/book">SELL</a></li> | <li><a href="${pageContext.request.contextPath}/book/request">REQUEST</a></li></ul>


<ul class="login"><li><a href="${pageContext.request.contextPath}">LOGOUT</a></li> | <li><a href="${pageContext.request.contextPath}/requests">ADs</a></li><li><a href="${pageContext.request.contextPath}/search">ADVANCE SEARCH</a></li>| <li><a href="${pageContext.request.contextPath}/book/all">BOOKS AVAILABLE</a></li></ul>
						<ul><li><div id="google_translate_element"></div><script type="text/javascript">
function googleTranslateElementInit() {
 new google.translate.TranslateElement({pageLanguage: 'en', layout: google.translate.TranslateElement.InlineLayout.SIMPLE}, 'google_translate_element');
}
</script><script type="text/javascript" src="//translate.google.com/translate_a/element.js?cb=googleTranslateElementInit"></script></li></ul>
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
			<div class="content_box"><a href="">
			   	</a><div class="left-grid-view grid-view-left"><a href="">
			   	   	 <img src="images/ba.jpg" class="img-responsive watch-right" alt="">
				   	   	<div class="mask">
	                        <div class="info">Quick View</div>
			            </div>
				   	  </a>
				</div>
				    <h4><a href="#">The Lewis Man</a></h4>
				     <p>It is a long established fact that a reader is always curious</p>
				   $20
			   	</div>
              </div>
			 <div class="  product-grid">
			<div class="content_box"><a href="">
			   	</a><div class="left-grid-view grid-view-left"><a href="">
			   	   	 <img src="images/bag.jpg" class="img-responsive watch-right" alt="">
				   	   	<div class="mask">
	                        <div class="info">Quick View</div>
			            </div>
				   	  </a>
				   </div>
				    <h4><a href="#">Spring Recipes</a></h4>
				     <p>Must book for Software Developer</p>
				     $35
			   	</div>
                 </div>
			 <div class="  product-grid">
			<div class="content_box"><a href="">
			   	</a><div class="left-grid-view grid-view-left"><a href="">
			   	   	 <img src="images/bag1.jpg" class="img-responsive watch-right" alt="">
				   	   	<div class="mask">
	                        <div class="info">Quick View</div>
			            </div>
				   	  </a>
				   </div>
				    <h4><a href="#">JAVA EE Spring Patterns</a></h4>
				     <p>Must know Spring Patterns</p>
				   $30
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
	   		     		<a href=""><img class="img-responsive chain" src="images/wat.gif" alt=" "></a>	   		     		
	   		     		<div class="grid-chain-bottom chain-watch">
		   		     		<span class="actual dolor-left-grid">30$</span>
		   		     		<span class="reducedfrom">50$</span>  
		   		     		<h6>Operating Systems</h6>  		     			   		     										
	   		     		</div>
	   		     	</div>
	   		     		
			</div>
	<div class="clearfix"> </div>
</div>
	<!---->
	

</body></html>