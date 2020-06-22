
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<!--header-->
<div class="header">
	<div class="header-top">
		<div class="container">
			<div class="social">
				<ul>
					<li><a href="#"><i class="facebok"> </i></a></li>
					<li><a href="#"><i class="twiter"> </i></a></li>
					<li><a href="#"><i class="inst"> </i></a></li>
					<li><a href="#"><i class="goog"> </i></a></li>
						<div class="clearfix"></div>	
				</ul>
			</div>
			<div class="header-left">
			
				<div class="search-box">
					<div id="sb-search" class="sb-search">
						<form action="${pageContext.request.contextPath}/searchCar" method="GET">
							<input class="sb-search-input" name="search" placeholder="vui lòng điền thông tin..." type="search"  id="search">
							<input class="sb-search-submit" type="submit" value="">
							<span class="sb-icon-search"> </span>
						</form>
					</div>
				</div>
			
<!-- search-scripts -->
					<script src="js/classie.js"></script>
					<script src="js/uisearch.js"></script>
						<script>
							new UISearch( document.getElementById( 'sb-search' ) );
						</script>
					<!-- //search-scripts -->

				<div class="ca-r">
					<div class="cart box_1">
						
						

					</div>
				</div>
					<div class="clearfix"> </div>
			</div>
				
		</div>
		</div>
		<div class="container-fluid">
			<div class="head-top">
				<div class="logo">
					<h1><a href="${pageContext.request.contextPath}/homeuser">Cho Thuê Xe</a></h1>
				</div>
		<form action="${pageContext.request.contextPath}/searchBySpecies" method="get">
		  <div class="h_menu4">
				<ul class="memenu skyblue">
				
					  	   <li><a class="color1" href="#">TÌM KIẾM</a>
				      	<div class="mepanel">
						<div class="row">
							<div class="col1">
								<div class="h_nav">
									<ul>
										<li>Mã Giảm Giá</li>																		
									</ul>
									<ul>
										<li><a href="searchCarByPromotion?title=5"> Giảm  5%</a></li>
										<li><a href="searchCarByPromotion?title=10">Giảm 10%</a></li>
										<li><a href="searchCarByPromotion?title=20">Giảm 20%</a></li>
										<li><a href="searchCarByPromotion?title=30">Giảm 30%</a></li>
										<li><a href="searchCarByPromotion?title=40">Giảm 40%</a></li>
										<li><a href="searchCarByPromotion?title=50">Giảm 50%</a></li>				
									</ul>	
								</div>							
							</div>
							<div class="col1">
								<div class="h_nav">
									<ul>
										<li>HÃNG XE</li>																		
									</ul>
									<ul>
										<li><a href="searchCarByManu?manu=Audi">Audi</a></li>	
										<li><a href="searchCarByManu?manu=mercedes">Mercedes</a></li>	
										<li><a href="searchCarByManu?manu=Ford">Ford</a></li>	
										<li><a href="searchCarByManu?manu=Honda">Honda</a></li>	
										<li><a href="searchCarByManu?manu=Mazda">Mazda</a></li>	
										<li><a href="searchCarByManu?manu=Toyota">Toyota</a></li>	
										<li><a href="searchCarByManu?manu=BMW">BMW</a></li>	
										<li><a href="searchCarByManu?manu=Yamaha">Yamaha</a></li>	
										<li><a href="searchCarByManu?manu=Vinbus">Vinbus</a></li>							
									</ul>	
								</div>							
							</div>
									<div class="col1">
								<div class="h_nav">
									<ul>
										<li>Loại Xe</li>																		
									</ul>	
									<ul>
										<li><a href="searchCarBySpecies?species=CarNumberFloor">Xe Số Sàn</a></li>
										<li><a href="searchCarBySpecies?species=AutomaticGear">Xe Số Tự Động</a></li>
										<li><a href="searchCarBySpecies?species=Motorcycle">Xe Mô Tô</a></li>									
									</ul>	
								</div>							
							</div>						
						  </div>
						</div>
					</li>
			    <li><a class="color4" href="${pageContext.request.contextPath}/updateInfoUser">CẬP NHẬP THÔNG TIN</a></li>
			    <li><a class="color4" href="${pageContext.request.contextPath}/historyContract">LỊCH SỬ THUÊ</a></li>	
				<li><a class="color4" href="${pageContext.request.contextPath}/logout">ĐĂNG XUẤT</a></li>				
			  </ul> 
			</div>
			</form>
				
				<div class="clearfix"> </div>
		</div>
		</div>		
	</div>
	<div class="banner">
		<div class="container">
			  <script src="js/responsiveslides.min.js"></script>
  <script>
    $(function () {
      $("#slider").responsiveSlides({
      	auto: true,
      	nav: true,
      	speed: 500,
        namespace: "callbacks",
        pager: true,
      });
    });
  </script>
			<div  id="top" class="callbacks_container">
			<ul class="rslides" id="slider">
			    <li>
					
						<div class="banner-text">
							<h3>Thuê xe , Thám Hiểm Mơ Mộng Khám Phá </h3>
						<p>Hai mươi năm về sau bạn sẽ hỗi hận nhiều hơn về Những gì bạn không làm .
							Vậy nên hãy tháo dây , nhổ neo ra khỏi bến đổ an toàn.
							Hãy Để Cánh buồm của bạn đón trọn lấy gió.
						</p>
						
						</div>
				
				</li>
				<li>
					
						<div class="banner-text">
							<h3>Vì sao thuê xe bên chúng tôi ? </h3>
						<p>Chúng tôi luôn mạng lại những trãi nghiệm tiệc vời giữa bạn với những
							Chiếc xe đẹp và đầy quyến rủ.Không chỉ dừng lại ở việc xe đẹp mà xe còn
							chất lượng và bao rẻ cho những chuyển du lịch của bạn .
						</p>
												

						</div>
					
				</li>
				<li>
						<div class="banner-text">
							<h3>Lý do phải trãi nghiệm</h3>
						<p>Vì cuộc đời nãy chỉ có một lần
							Ngại gì mà bạn không trãi nghiệm.
						</p>
								

						</div>
					
				</li>
			</ul>
		</div>

	</div>
	</div>
		<div class="container">
			<div  id="top" class="callbacks_container">
			<ul class="rslides" id="slider">
			    <li>												
				</li>
				<li>				
						<div class="banner-text">															
						</div>					
				</li>
				<li>
						<div class="banner-text">						
						</div>				
				</li>
			</ul>
		</div>
	</div>
</body>
</html>
			