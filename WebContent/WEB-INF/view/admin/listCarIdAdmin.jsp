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
                            Car Admin
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
                                        <label for="firstname" class="control-label col-lg-3">HÃNG</label>
                                        <div class="col-lg-6 col-sm-9">
                                        	<p class="form-control " id="firstname">${maCar.nameManufac}</p>                                                                   
                                        </div>
                                    </div> 
         							<div class="form-group ">
                                        <label for="firstname" class="control-label col-lg-3">LOẠI</label>
                                        <div class="col-lg-6 col-sm-9">
                                        	<p class="form-control " id="firstname">${speciesCar.nameSpecies}</p>                                                                                 
                                        </div>
                                    </div>                                                  				  
                                    <div class="form-group ">
                                        <label for="lastname" class="control-label col-lg-3">TÊN XE</label>
                                      	 <div class="col-lg-6 col-sm-9">
                                        	<p class="form-control " id="email">${car.nameCar}</p>                                                                   
                                       	</div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="lastname" class="control-label col-lg-3">SỐ LƯỢNG</label>
                                      	 <div class="col-lg-6 col-sm-9">
                                        	<p class="form-control " id="email">${car.quantity}</p>                                                                   
                                       	</div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="lastname" class="control-label col-lg-3">SỐ HIỆN CÒN</label>
                                      	 <div class="col-lg-6 col-sm-9">
                                        	<p class="form-control " id="email">${car.still_exist}</p>                                                                   
                                       	</div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="lastname" class="control-label col-lg-3">Ảnh</label>
                                      	 <div class="col-lg-6 col-sm-9">
                                        	<img src="images/${car.avatar}" width="170px" height="220px"/>                                                                  
                                       	</div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="lastname" class="control-label col-lg-3">GIÁ THEO NGÀY</label>
                                      	 <div class="col-lg-6 col-sm-9">
                                        	<p class="form-control " id="email">${car.price}VNĐ</p>                                                                   
                                       	</div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="lastname" class="control-label col-lg-3">GIÁ THEO GIỜ</label>
                                      	 <div class="col-lg-6 col-sm-9">
                                        	<p class="form-control " id="email">${car.pricehour}VNĐ</p>                                                                   
                                       	</div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="lastname" class="control-label col-lg-3">MÀU</label>
                                      	 <div class="col-lg-6 col-sm-9">
                                        	<p class="form-control " id="email">${car.color}</p>                                                                   
                                       	</div>
                                    </div>
                                      <div class="form-group ">
                                        <label for="lastname" class="control-label col-lg-3">PHÂN KHỐI</label>
                                      	 <div class="col-lg-6 col-sm-9">
                                        	<p class="form-control " id="email">${car.ounce}</p>                                                                   
                                       	</div>
                                    </div>
                                     <div class="form-group ">
                                        <label for="lastname" class="control-label col-lg-3">SỐ KHUNG</label>
                                      	 <div class="col-lg-6 col-sm-9">
                                        	<p class="form-control " id="email">${car.chassisnumber}</p>                                                                   
                                       	</div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="lastname" class="control-label col-lg-3">SỐ CHỖ NGỒI</label>
                                      	 <div class="col-lg-6 col-sm-9">
                                        	<p class="form-control " id="email">${car.seatnumber}</p>                                                                   
                                       	</div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="lastname" class="control-label col-lg-3">MIÊU TẢ XE</label>
                                        <div class="col-lg-6 col-sm-9">
                                      	 <p>${car.status}</p>
                                      	 	</div>
                                    </div>
                                      <div class="form-group">
                                        <div class="col-lg-offset-3 col-lg-6">
                                           	<a class="btn btn-primary" href="updateCar?id_car=${car.id_car}">CẬP NHẬT</a>
                                             <a class="btn btn-primary" href="deleteCar?id_car=${car.id_car}">XÓA</a> 
                                             <a class="btn btn-default" href="${pageContext.request.contextPath}/listCaradmin">CANCEL</a>
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