
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
<jsp:include page="/WEB-INF/view/templ/headeruser1.jsp"></jsp:include>

	<div class="grow">
		<div class="container">
			<h2>Cập Nhật Thông Tin</h2>
		</div>
	</div>
	<!-- grow -->
<!--content-->
<div class="container">
		<div class="account">
		<div class="account-pass">
		<div class="col-md-8 account-top">
			<form action="${pageContext.request.contextPath}/updateInfoUser" method="post">	
			<div> 	
				<input type="hidden" name="custumerid" value="${custumer.custumerid}" required="required"> 
			</div>			
			<div> 	
				<span >Họ tên</span>
				<input type="text" name="name" value="${custumer.fullnName}" required="required"> 
			</div>
			<div> 
				<span >Chứng minh nhân dân</span>
				<input type="text" name="idcard" value="${custumer.idcard}" required="required"> 
			</div>	
			<div> 
				<span >Ngày sinh</span>
				<input type="text" name="datebirth" value="${custumer.dateBrith}" required="required">
			</div>
			<div> 
				<span >Địa chỉ</span>
				<input type="text" name="address" value="${custumer.address}" required="required">
			</div>
			<div> 
				<span >Số điện thoại</span>
				<input type="text" name="phone" value="${custumer.phoneNumber}" required="required">
			</div>
			<div> 
				<span >Email</span>
				<input type="text" name="email" value="${custumer.email}" required="required">
			</div>				
				<input type="submit" value="Xác Nhận"> 
			</form>
		</div>
	<div class="clearfix"> </div>
</div>
</div>
</div>
<div class="grow">
		<div class="container">
			<h2>Cập Nhật Tài Khoản</h2>
		</div>
	</div>
	<!-- grow -->
<!--content-->
<div class="container">
		<div class="account">
		<div class="account-pass">
		<h2 align="center" style="color: red;"><%= request.getAttribute("message") != null ? request.getAttribute("message") : " " %></h2>
		<div class="col-md-8 account-top">
			<form action="${pageContext.request.contextPath}/changePassUser" method="post">
			<div> 	
				<input  type="hidden"   name="iduser" value="${user.userid}" required="required"> 
			</div>						
			<div> 
				<span >Mật khẩu Cũ</span>
				<input type="password" name="passold"  required="required">
			</div>	
			<div> 
				<span >Mật Khẩu Mới</span>
				<input type="password" name="newpass"  required="required">
			</div>				
				<input type="submit" value="Xác Nhận"> 
			</form>
		</div>
	<div class="clearfix"> </div>
</div>
</div>
</div>
<jsp:include page="/WEB-INF/view/footer.jsp"></jsp:include>
</body>
</html>
			