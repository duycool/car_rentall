<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<title>Admin</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"  />
<meta name="keywords" content="Visitors Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- bootstrap-css -->
<link rel="stylesheet" href="csss/bootstrap.min.css" >
<!-- //bootstrap-css -->
<!-- Custom CSS -->
<link href="csss/stylee.css" rel='stylesheet' type='text/css' />
<link href="csss/style-responsive.css" rel="stylesheet"/>
<!-- font CSS -->
<link href='//fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
<!-- font-awesome icons -->
<link rel="stylesheet" href="csss/font.css" type="text/css"/>
<link href="csss/font-awesome.css" rel="stylesheet"> 
<link rel="stylesheet" href="csss/morris.css" type="text/css"/>
<!-- calendar -->
<link rel="stylesheet" href="csss/monthly.css">

<!-- //calendar -->
<!-- //font-awesome icons -->


<script src="jsss/jquery2.0.3.min.js"></script>
<script src="jsss/raphael-min.js"></script>
<script src="jsss/morris.js"></script>


</head>
<body>
<section id="container">
<!--header start-->
<header class="header fixed-top clearfix">
<!--logo start-->
<div class="brand">
    <a href="${pageContext.request.contextPath}/homeStaffDelivery" class="logo">
      	Delivery 
    </a>
    <div class="sidebar-toggle-box">
        <div class="fa fa-bars"></div>
    </div>
</div>
<div class="top-nav clearfix">
    <!--search & user info start-->
    <ul class="nav pull-right top-menu">
        <li>
            <input type="text" class="form-control search" placeholder=" Search">
        </li>
        <!-- user login dropdown start-->
        <li class="dropdown">
           	 <a data-toggle="dropdown" class="dropdown-toggle" href="${pageContext.request.contextPath}/logout">
                <img alt="" src="imagess/ok.jpg">
               <a href="${pageContext.request.contextPath}/logout"><span class="username">Đăng Xuất</span></a>    
            </a>      
        </li>     
       <!-- user login dropdown end -->
       
    </ul>
    <!--search & user info end-->
</div>
</header>

<aside>


<div id="sidebar" class="nav-collapse">
        <!-- sidebar menu start-->
        <div class="leftside-navigation">
            <ul class="sidebar-menu" id="nav-accordion">
                <li>
                    <a class="active" href="${pageContext.request.contextPath}/homeStaffDelivery">
                        <i class="fa fa-dashboard"></i>
                        <span>Trang chủ</span>
                    </a>
                </li>                                        
                 <li class="sub-menu">
                    <a href="javascript:;">
                        <i class="fa fa-book"></i>
                        <span>HỢP ĐỒNG CẦN GIAO</span>
                    </a>
                    <ul class="sub">
                         <li><a href="${pageContext.request.contextPath}/listcontractdayDelivery?status=Approved">Hợp Đồng Thuê Theo Ngày Đã Duyệt</a></li>                          
                         <li><a href="${pageContext.request.contextPath}/listcontracthourDelivery?status=Approved">Hợp Đồng Thuê Theo Giờ Đã Duyệt</a></li>                                       
                    </ul>
                </li> 
                   <li class="sub-menu">
                    <a href="javascript:;">
                        <i class="fa fa-book"></i>
                        <span>HỢP ĐỒNG ĐANG GIAO</span>
                    </a>
                    <ul class="sub">
                               <li><a href="${pageContext.request.contextPath}/listcontractdayDelivery?status=delivery">Hợp Đồng Thuê Theo Ngày Đang Giao</a></li>
                                <li><a href="${pageContext.request.contextPath}/listcontracthourDelivery?status=delivery">Hợp Đồng Thuê Theo Giờ Đang Giao</a></li>
                    </ul>
                </li> 
               <li class="sub-menu">
                    <a href="javascript:;">
                        <i class="fa fa-book"></i>
                        <span>HỢP ĐỒNG ĐÃ GIAO</span>
                    </a>
                    <ul class="sub">
                                         <li><a href="${pageContext.request.contextPath}/listcontractdayDelivery?status=delivered">Hợp Đồng Thuê Theo Ngày Đã Giao</a></li>
                                          <li><a href="${pageContext.request.contextPath}/listcontracthourDelivery?status=delivered">Hợp Đồng Thuê Theo Giờ Đã Giao</a></li>
                    </ul>
                </li>   
                    <li class="sub-menu">
                    <a href="javascript:;">
                        <i class="fa fa-book"></i>
                        <span>HỢP ĐỒNG ĐÃ TRẢ</span>
                    </a>
                    <ul class="sub">
                                          <li><a href="${pageContext.request.contextPath}/listcontractdayDelivery?status=AlreadyPaid">Hợp Đồng Thuê Theo Ngày Đã Trả</a></li>
                                          <li><a href="${pageContext.request.contextPath}/listcontracthourDelivery?status=AlreadyPaid">Hợp Đồng Thuê Theo Giờ Đã Trả</a></li>
                    </ul>
                </li> 
                <li class="sub-menu">
                    <a href="javascript:;">
                        <i class="fa fa-book"></i>
                        <span>HỢP ĐỒNG ĐẾN HẠN</span>
                    </a>
                    <ul class="sub">
                                         <li><a href="${pageContext.request.contextPath}/listcontractdayTorankDelivery">Hợp Đồng Thuê Theo Ngày Đến Hạng</a></li>
                                          <li><a href="${pageContext.request.contextPath}/listcontractdayDelivery?status=delivery">Hợp Đồng Thuê Theo Giờ Đã Giao</a></li>
                    </ul>
                </li>                             
                  <li>                   
                    <a href="${pageContext.request.contextPath}/contractexpires">
                        <i class="fa fa-bullhorn"></i>
                        <span>Hợp đồng quá hạn</span>                     
                    </a>
                     <ul class="sub">
                           <li><a href="${pageContext.request.contextPath}/listcontractdayOutDayDelivery">Hợp Đồng Thuê Theo Ngày Quá Hạn</a></li>
                    </ul>
                </li>    
                       <li>                   
                    <a href="${pageContext.request.contextPath}/contractexpires">
                        <i class="fa fa-bullhorn"></i>
                        <span>DANH SÁCH HỢP ĐỒNG BỊ VI PHẠM</span>                     
                    </a>
                     <ul class="sub">
                           <li><a href="${pageContext.request.contextPath}/listcontractdayOutDayDelivery">Hợp Đồng Thuê Theo Ngày Quá Hạn</a></li>
                    </ul>
                </li>                
            </ul>      
           </div>
    </div>
</aside>
</section>
<script src="jss/bootstrap.js"></script>
<script src="jss/jquery.dcjqaccordion.2.7.js"></script>
<script src="jss/scripts.js"></script>
<script src="jss/jquery.slimscroll.js"></script>
<script src="jss/jquery.nicescroll.js"></script>
<!--[if lte IE 8]><script language="javascript" type="text/javascript" src="js/flot-chart/excanvas.min.js"></script><![endif]-->
<script src="jss/jquery.scrollTo.js"></script>
</body>
</html>
