<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<head>
<title>Admin</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Visitors Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- bootstrap-css -->
<link rel="stylesheet" href="css/bootstrap.min.css" >
<!-- //bootstrap-css -->
<!-- Custom CSS -->
<link href="css/stylee.css" rel='stylesheet' type='text/css' />
<link href="css/stylee-responsive.css" rel="stylesheet"/>
<!-- font CSS -->
<link href='//fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
<!-- font-awesome icons -->
<link rel="stylesheet" href="css/font.css" type="text/css"/>
<link href="css/font-awesome.css" rel="stylesheet"> 
<link rel="stylesheet" href="css/morris.css" type="text/css"/>
<!-- calendar -->
<link rel="stylesheet" href="css/monthly.css">
<!-- //calendar -->
<!-- //font-awesome icons -->
<script src="jsss/jquery2.0.3.min.js"></script>
<script src="jsss/raphael-min.js"></script>
<script src="jsss/morris.js"></script>
</head>
<body>
<jsp:include page="/WEB-INF/view/templ/headeradmin.jsp"></jsp:include>
</aside>
<!--sidebar end-->
<!--main content start-->
<section id="main-content">
	<section class="wrapper">
		<div class="form-w3layouts">
            <!-- page start-->
            <div class="row">
                <div class="col-lg-12">
                    <section class="panel">
                     
              <div class="panel-body">
         		<div class="row">
                <div class="col-lg-12">
                    <section class="panel">
                        <header class="panel-heading">
                            CUSTUMER
                            <span class="tools pull-right">
                                <a class="fa fa-chevron-down" href="javascript:;"></a>
                                <a class="fa fa-cog" href="javascript:;"></a>
                                <a class="fa fa-times" href="javascript:;"></a>
                             </span>
                        </header>
                        <div class="panel-body">
                            <div class="form">
                   	 <form action="" method="" style="margin-top: 100px" class="cmxform form-horizontal" id="signupForm">     			
         							<div class="form-group ">
                                        <label for="firstname" class="control-label col-lg-3">TÊN KHÁCH HÀNG</label>
                                        <div class="col-lg-6 col-sm-9">
                                        	<p class="form-control " id="firstname">${custumer.fullnName}</p>                                                                   
                                        </div>
                                    </div> 
         							<div class="form-group ">
                                        <label for="firstname" class="control-label col-lg-3">CHỨNG MINH THƯ</label>
                                        <div class="col-lg-6 col-sm-9">
                                        	<p class="form-control " id="firstname">${custumer.idcard}</p>                                                                                 
                                        </div>
                                    </div>                                                  				  
                                    <div class="form-group ">
                                        <label for="lastname" class="control-label col-lg-3">NGÀY SINH</label>
                                      	 <div class="col-lg-6 col-sm-9">
                                        	<p class="form-control " id="email">${custumer.dateBrith}</p>                                                                   
                                       	</div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="lastname" class="control-label col-lg-3">EMAIL</label>
                                      	 <div class="col-lg-6 col-sm-9">
                                        	<p class="form-control " id="email">${custumer.email}</p>                                                                   
                                       	</div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="lastname" class="control-label col-lg-3">ĐỊA CHỈ</label>
                                      	 <div class="col-lg-6 col-sm-9">
                                        	<p class="form-control " id="email">${custumer.address}</p>                                                                   
                                       	</div>
                                    </div>
                                     <div class="form-group ">
                                        <label for="lastname" class="control-label col-lg-3">SỐ ĐIỆN THOẠI</label>
                                      	 <div class="col-lg-6 col-sm-9">
                                        	<p class="form-control " id="email">${custumer.phoneNumber}</p>                                                                   
                                       	</div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="lastname" class="control-label col-lg-3">TÀI KHOẢN</label>
                                      	 <div class="col-lg-6 col-sm-9">
                                        	<p class="form-control " id="email">${user.username}</p>                                                                   
                                       	</div>
                                    </div>   
                                    <div class="form-group ">
                                        <label for="lastname" class="control-label col-lg-3">MẬT KHẨU</label>
                                      	 <div class="col-lg-6 col-sm-9">
                                        	<p class="form-control " id="email">${user.passwords}</p>                                                                   
                                       	</div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="lastname" class="control-label col-lg-3">VAI TRÒ TRONG HỆ THỐNG</label>
                                      	 <div class="col-lg-6 col-sm-9">
                                        	<p class="form-control " id="email">${user.roles}</p>                                                                   
                                       	</div>
                                    </div>                               
                                      <div class="form-group">
                                        <div class="col-lg-offset-3 col-lg-6">
                                           	<a class="btn btn-primary" href="deleteCustumerAdmin?userid=${user.userid}">DELETE</a>                                             
                                             <a class="btn btn-default" href="${pageContext.request.contextPath}/listCustumerAdmin">CANCEL</a>
                                        </div>
                                    </div>
   						 </form>                  
                            </div>
                        </div>
                    </section>
                </div>
            </div> 
             <!-- page end-->         
           </div>	
                           
 </div>
</section>
 <!-- footer -->
		  <div class="footer">
			<div class="wthree-copyright">
			  <p>© DA NANG VIET NAM</p>
			</div>
		  </div>
  <!-- / footer -->
</section>

<!--main content end-->
</section>
<script src="js/bootstrap.js"></script>
<script src="js/jquery.dcjqaccordion.2.7.js"></script>
<script src="js/scripts.js"></script>
<script src="js/jquery.slimscroll.js"></script>
<script src="js/jquery.nicescroll.js"></script>
<!--[if lte IE 8]><script language="javascript" type="text/javascript" src="js/flot-chart/excanvas.min.js"></script><![endif]-->
<script src="js/jquery.scrollTo.js"></script>
</body>
</html>