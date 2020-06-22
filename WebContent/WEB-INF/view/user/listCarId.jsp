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
<jsp:include page="/WEB-INF/view/templ/headeruser1.jsp"></jsp:include>
<!--content-->
	<!-- grow -->
		<div class="product">
			<div class="container">
				
				<div class="product-price1">
				<div class="top-sing">
				<div class="col-md-7 single-top">	
		<div class="flexslider">
			  <ul class="slides">
			    <li data-thumb="images/si.jpg">
			        <div class="thumb-image"> <img src="images/${car.avatar}" data-imagezoom="true" class="img-responsive"> </div>			     
			    </li>			  			  					    
			  </ul>			    
		</div>										
		   <div class="clearfix"> </div>				
				<div>
					<form action="${pageContext.request.contextPath}/comment"
							method="POST">
							<h4 class="text-success">Bình luận:</h4>
							<input type="text" name="textcomment" size="70">
							 <input type="submit" value="Gửi" class="btn btn-success">
						</form>
					</div>
				<div class="clearfix"> </div>
			<div>
							<c:forEach items="${listComment}" var="comment">
								<p>
									<i style="color: green;">${comment.nameuser}:</i>
									${comment.comment}
								</p>
							</c:forEach>
			</div>			
	<div class="clearfix"> </div>
<!-- slide -->
						<!-- FlexSlider -->
  <script defer src="js/jquery.flexslider.js"></script>
<link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" />

<script>
// Can also be used with $(document).ready()
$(window).load(function() {
  $('.flexslider').flexslider({
    animation: "slide",
    controlNav: "thumbnails"
  });
});
</script>
					</div>	
					<div class="col-md-5 single-top-in simpleCart_shelfItem">
						<div class="single-para ">						
						<h5>Tên Xe : ${car.nameCar}</h5>
									<div class="star-on">								
									<div class="review">	
									<a>Hãng Xe: ${car.nameManufac}</a><br>	
									<a>Loại Xe : ${car.nameSpecies}</a><br>
									<a>Số Lượng Hiện Còn : ${car.still_exist} Chiếc </a><br>
									<a>Số Chỗ Ngồi : ${car.seatnumber}</a><br>									
									<a><%= request.getAttribute("name") != null ? request.getAttribute("name") : " " %> ${promotion.titile}</a>
									</div>	
							<div class="clearfix"> </div>
							</div>																																
							<h5>Đánh giá Xe : </h5>
							<div class="star-on">								
								<div class="review">														
									<a > ${car.status}</a>	<br>																			
								</div>
									<a href="contractDay?id_car=${car.id_car}" class="add-cart item_add">Thuê Theo Ngày</a>		
									<a href="contractHour?id_car=${car.id_car}" class="add-cart item_add">Thuê Theo Giờ</a>
									<p align="center" style="color: red;"><%= request.getAttribute("message") != null ? request.getAttribute("message") : " " %></p>																														
							<div class="clearfix"> </div>
							</div>						
							<h5 class="item_price">	
									<%= request.getAttribute("giatheongay") != null ? request.getAttribute("giatheongay") : " " %><%= request.getAttribute("pricebt") != null ? request.getAttribute("pricebt") : " " %> <%= request.getAttribute("vnd") != null ? request.getAttribute("vnd") : " " %>	 <br>																																					  
									<%= request.getAttribute("giatheogio") != null ? request.getAttribute("giatheogio") : " " %><%= request.getAttribute("pricehourbt") != null ? request.getAttribute("pricehourbt") : " " %> <%= request.getAttribute("vnd") != null ? request.getAttribute("vnd") : " " %>																																																																																																												
									<%= request.getAttribute("giatheongaysale") != null ? request.getAttribute("giatheongaysale") : " " %>  	<br>
																	<%= request.getAttribute("giabandau") != null ? request.getAttribute("giabandau") : " " %> 
																	<strike><%= request.getAttribute("price") != null ? request.getAttribute("price") : " " %> <%= request.getAttribute("vndsale") != null ? request.getAttribute("vndsale") : " " %>	</strike><br>
																	<%= request.getAttribute("giagiam") != null ? request.getAttribute("giagiam") : " " %> 
																	<%= request.getAttribute("priceSaleOff") != null ? request.getAttribute("priceSaleOff") : " " %> <%= request.getAttribute("vndsale") != null ? request.getAttribute("vndsale") : " " %><br>																					  
									<%= request.getAttribute("giatheogiosale") != null ? request.getAttribute("giatheogiosale") : " " %>    	<br>
												   					<%= request.getAttribute("giabandau") != null ? request.getAttribute("giabandau") : " " %> 
																	<strike><%= request.getAttribute("pricehour") != null ? request.getAttribute("pricehour") : " " %> <%= request.getAttribute("vndsale") != null ? request.getAttribute("vndsale") : " " %>	</strike><br>
																	<%= request.getAttribute("giagiam") != null ? request.getAttribute("giagiam") : " " %> 									
																	<%= request.getAttribute("pricehourSaleOff") != null ? request.getAttribute("pricehourSaleOff") : " " %> <%= request.getAttribute("vndsale") != null ? request.getAttribute("vndsale") : " " %><br>								
							</h5>																																																																															
							<div class="clearfix"> </div>								
						</div>
					</div>						
			
				</div>
				</div>
			<!---->		
</div>
			<jsp:include page="/WEB-INF/view/footer.jsp"></jsp:include>
</body>
</html>