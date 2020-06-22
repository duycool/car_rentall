<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Cho thue xe du lich</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<!-- Custom Theme files -->
<!--theme-style-->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />	
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Mattress Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--fonts-->
<link href='//fonts.googleapis.com/css?family=Lato:100,300,400,700,900' rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900' rel='stylesheet' type='text/css'><!--//fonts-->
<!-- start menu -->
<link href="css/memenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/memenu.js"></script>
<script>$(document).ready(function(){$(".memenu").memenu();});</script>
<script src="js/simpleCart.min.js"> </script>
</head>
<body>
<jsp:include page="templ/header.jsp"></jsp:include>
<!--content-->

<div class="container-fluid">
	<div class="cont">
		<div class="content">
			<div class="content-top-bottom">
				<div class="col-md-6 men">
					<a href="single.html" class="b-link-stripe b-animate-go  thickbox"><img class="img-responsive" src="images/xe3.jpg" alt="" height="30px;">
						<div class="b-wrapper">
											<h3 class="b-animate b-from-top top-in   b-delay03 ">
												<span>Audi</span>	
											</h3>
										</div>
					</a>				
				</div>
				<div class="col-md-6">
					<div class="col-md1 ">
						<a href="single.html" class="b-link-stripe b-animate-go  thickbox"><img class="img-responsive" src="images/xe5.jpg" alt="">
							<div class="b-wrapper">
											<h3 class="b-animate b-from-top top-in1   b-delay03 ">
												<span>Ford</span>	
											</h3>
										</div>
						</a>
						
					</div>
			
				</div>
				<div class="clearfix"> </div>
			</div>	
			<div class="content-top">
				<div><h2 style="color: activecaption;">Car Rental</h2>
				<i style="">THUÊ SAO CŨNG ĐƯỢC !!!</i>
				
				</div>
				<div class="grid-in">
				<c:forEach items="${listcar}" var="car">					
					<div class="col-md-4 grid-top simpleCart_shelfItem">
						<a href="listCarIdhome?id_car=${car.id_car}" class="b-link-stripe b-animate-go  thickbox"><img class="img-responsive" src="images/${car.avatar}" alt="" width="650px" height="433px">
							<div class="b-wrapper">
								<h3 class="b-animate b-from-left    b-delay03 ">
									<span>${car.nameCar}</span>									
									<span>${promotion.titile}</span>	
												
								</h3>
							</div>
						</a>
					<p>				
					<a href="listCarIdhome?id_car=${car.id_car}">${car.nameCar}</a>
					</p>					
					</div>
					</c:forEach>						
							<div class="clearfix"> </div>
				</div>
			</div>
				<div class="container p-3 my-3 bg-success text-white">
  			<i style="font-size: 30px;">Cảm nhận của bạn thế nào  <br>
  			 khi đã được trãi nghiệm dịch vụ cho thuê xe bên chúng tôi</i><br>
  			<i>cảm ơn bạn đã tin tưởng và thuê sản phẩm bên chúng tôi  <br> 
  			mong sao được làm khách hàng tiềm năng của bạn mãi mãi !!! .</i>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>		
		</div>
	<!----->
	</div>
</div>
	
</body>
</html>

		
		
			