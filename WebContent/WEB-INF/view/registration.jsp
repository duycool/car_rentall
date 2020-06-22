
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>Cho thue xe du lich</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<!-- Custom Theme files -->
<!--theme-style-->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Mattress Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<!--fonts-->
<link href='//fonts.googleapis.com/css?family=Lato:100,300,400,700,900'
	rel='stylesheet' type='text/css'>
<link
	href='//fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900'
	rel='stylesheet' type='text/css'>
<!--//fonts-->
<!-- start menu -->
<link href="css/memenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/memenu.js"></script>
<script>
	$(document).ready(function() {
		$(".memenu").memenu();
	});
</script>
<script src="js/simpleCart.min.js">
	
</script>
</head>
<body>
	<!--header-->
	<jsp:include page="templ/header1.jsp"></jsp:include>

	<div class="grow">
		<div class="container">
			<h2>ĐĂNG KÝ</h2>
		</div>
	</div>
	<!-- grow -->
	<!--content-->
	<div class="container">
		<div class="account">
			<div class="account-pass">
				<div class="col-md-8 account-top">
					<form action="${pageContext.request.contextPath}/registration"
						method="post">
						<h2 align="center" style="color: red;"><%= request.getAttribute("mess") != null ? request.getAttribute("mess") : " " %></h2>
						<div>
							<span>Họ tên</span> <input type="text" name="name">
						</div>
						<div>
							<span>Chứng minh nhân dân</span> <input type="text"
								name="idcard">
						</div>
						<div>
							<span>Ngày sinh</span> <input type="date" name="datebirth">
						</div>
						<div>
							<span>Địa chỉ</span> <input type="text" name="address">
						</div>
						<div>
							<span>Email</span> <input type="text" name="email">
						</div>
						<div>
							<span>Số điện thoại</span> <input type="text" name="phone">
						</div>				
						<div>
							<span>Mật khẩu</span> <input type="password" name="pass">
						</div>
						<div>
							<input type="hidden" name="roles" value="user">
						</div>
						<input type="submit" value="Đăng kí">
					</form>
				</div>
				<div class="col-md-4 left-account ">
					<a href="single.html"><img class="img-responsive "
						src="images/1.jpg" alt=""></a>
					<div class="five">
						<h2>25%</h2>
						<span>discount</span>
					</div>

					<div class="clearfix"></div>
				</div>
				<div class="clearfix"></div>

			</div>
			<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
