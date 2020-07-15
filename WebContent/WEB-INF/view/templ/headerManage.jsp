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
    <a href="${pageContext.request.contextPath}/homeStaffManage" class="logo">
      	Manager 
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
                    <a class="active" href="${pageContext.request.contextPath}/homeStaffManage">
                        <i class="fa fa-dashboard"></i>
                        <span>TRANG CHỦ</span>
                    </a>
                </li>
                    <li class="sub-menu">
                    <a >
                        <i class="fa fa-book"></i>
                        <span>QUẢN LÝ KHÁCH HÀNG</span>
                    </a>
                    <ul class="sub">                    
                          <li><a href="${pageContext.request.contextPath}/listCustumerManager">KHÁCH HÀNG</a></li>                                             
                    </ul>
                </li>         
                     <li class="sub-menu">
                    <a  href="javascript:;">
                        <i class="fa fa-book"></i>
                        <span>QUẢN LÝ XE</span>
                    </a>
                    <ul class="sub">                      
                       		<li><a href="${pageContext.request.contextPath}/createcarManager">THÊM XE</a></li>
                    		<li><a href="${pageContext.request.contextPath}/listCarManager">QUẢN LÝ XE</a></li>   
                    		<li><a href="${pageContext.request.contextPath}/promotionManager">XE VỪA ĐƯỢC THÊM VÀO GIẢM GIÁ</a></li>           	
                    </ul>
                </li>   
                 <li class="sub-menu">
                    <a  href="javascript:;">
                        <i class="fa fa-book"></i>
                        <span>QUẢN LÝ LOẠI</span>
                    </a>
                    <ul class="sub">
                      		<li><a href="${pageContext.request.contextPath}/createspeciesManager">Thêm Loại</a></li>                       
                    		<li><a href="${pageContext.request.contextPath}/listspeciesManager">Tất Cả Lọai</a></li>      		
                    </ul>
                </li> 
                      <li class="sub-menu">
                    <a  href="javascript:;">
                        <i class="fa fa-book"></i>
                        <span>QUẢN LÝ HÃNG</span>
                    </a>
                    <ul class="sub">           
                       	<li><a href="${pageContext.request.contextPath}/createManufactManager">Thêm Hãng</a></li>
                    		<li><a href="${pageContext.request.contextPath}/listmanufactManager">Tất Cả Hãng</a></li>         		
                    </ul>
                </li> 
                 <li class="sub-menu">
                    <a href="javascript:;">
                        <i class="fa fa-book"></i>
                        <span>HỢP ĐỒNG THUÊ THEO NGÀY</span>
                    </a>
                    <ul class="sub">
                       <li><a href="${pageContext.request.contextPath}/listcontractdayManager?status=newRent">MỚI THUÊ</a></li>
                         <li><a href="${pageContext.request.contextPath}/listcontractdayManagerApproved?status=Approved">ĐÃ DUYỆT</a></li>
                         <li><a href="${pageContext.request.contextPath}/listcontractdayManagerApproved?status=delivery">ĐANG GIAO</a></li>
                         <li><a href="${pageContext.request.contextPath}/listcontractdayManagerApproved?status=delivered">ĐÃ GIAO</a></li>  
                         <li><a href="${pageContext.request.contextPath}/listcontractdayManagerApproved?status=AlreadyPaid">ĐÃ TRÃ</a></li>
                         <li><a href="${pageContext.request.contextPath}/listcontractdaytorankAdmin">ĐẾN HẠN</a></li>   
                         <li><a href="${pageContext.request.contextPath}/listcontractdayOutAdmin">QUÁ HẠN</a></li>                        
                    </ul>
                </li>
                  <li class="sub-menu">
                    <a href="javascript:;">
                        <i class="fa fa-book"></i>
                        <span>HỢP ĐỒNG THUÊ THEO GIỜ</span>
                    </a>
                    <ul class="sub">
                         <li><a href="${pageContext.request.contextPath}/listcontracthour?status=newRent">Mới Thuê</a></li>
                         <li><a href="${pageContext.request.contextPath}/listcontracthourApproved?status=Approved">ĐÃ DUYỆT</a></li>
                         <li><a href="${pageContext.request.contextPath}/listcontracthourApproved?status=delivery">ĐANG GIAO</a></li>    
                         <li><a href="${pageContext.request.contextPath}/listcontracthourApproved?status=delivered">ĐÃ GIAO</a></li>   
                         <li><a href="${pageContext.request.contextPath}/listcontracthourApproved?status=AlreadyPaid">ĐÃ TRÃ</a></li>    
                         <li><a href="${pageContext.request.contextPath}/listcontracthourtorankAdmin">ĐẾN HẠN</a></li>   
                         <li><a href="${pageContext.request.contextPath}/listcontracthourOutAdmin">QUÁ HẠN</a></li>                                   
                    </ul>
                </li>                    
                 <li class="sub-menu">
                    <a href="javascript:;">
                        <i class="fa fa-book"></i>
                        <span>DOANH THU CỬA HÀNG</span>
                    </a>
                    <ul class="sub">
                         <li><a href="${pageContext.request.contextPath}/sumtotal?status=CurrentlyHiring">Thu nhập ước tính</a></li>
                        <li><a href="${pageContext.request.contextPath}/sumtotal?status=AlreadyPaid">Thu nhập đạt được</a></li>            
                    </ul>
                </li> 
                      <li class="sub-menu">
                    <a href="javascript:;">
                        <i class="fa fa-bullhorn"></i>
                        <span>GIẢM GIÁ</span>
                    </a>
                    <ul class="sub">                       
                          <li><a href="${pageContext.request.contextPath}/viewpromotionManager">Danh sách xe giảm giá</a></li>              
                    </ul>
                </li>  
                        <li class="sub-menu">
                    <a href="javascript:;">
                        <i class="fa fa-bullhorn"></i>
                        <span>DANH SÁCH KHÁCH HÀNG VI PHẠM HỢP ĐỒNG</span>
                    </a>
                    <ul class="sub">                       
                         <li><a href="${pageContext.request.contextPath}/listcontractViolateManager">DANH SÁCH VI PHẠM HỢP ĐỒNG</a></li>            
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
