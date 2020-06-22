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
                            Thêm Xe
                            <span class="tools pull-right">
                                <a class="fa fa-chevron-down" href="javascript:;"></a>
                                <a class="fa fa-cog" href="javascript:;"></a>
                                <a class="fa fa-times" href="javascript:;"></a>
                             </span>
                        </header>
                        <div class="panel-body">
                            <div class="form">
                                <form class="cmxform form-horizontal " id="signupForm" method="post" action="${pageContext.request.contextPath}/createcar" novalidate="novalidate" enctype="multipart/form-data">
                                    <p align="center" style="color: red;"><%= request.getAttribute("absurd") != null ? request.getAttribute("absurd") : " " %></p>
                                    <div class="form-group ">
                                        <label for="firstname" class="control-label col-lg-3">TÊN SẢN PHẨM</label>
                                        <div class="col-lg-6">
                                            <input class=" form-control" id="firstname" name="nameproduct" type="text">
                                        </div>
                                    </div>
                                     <div class="form-group ">
                                        <label for="firstname" class="control-label col-lg-3">REVIEW SẢN PHẨM</label>
                                        <div class="col-lg-6">
                                            <input class=" form-control" id="firstname" name="status" type="text">
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="firstname" class="control-label col-lg-3">MÀU SẢN PHẨM</label>
                                        <div class="col-lg-6">
                                            <input class=" form-control" id="firstname" name="color" type="text">
                                        </div>
                                    </div>
                                     <div class="form-group ">
                                        <label for="firstname" class="control-label col-lg-3">PHÂN KHỐI</label>
                                        <div class="col-lg-6">
                                            <input class=" form-control" id="firstname" name="ounce" type="text">
                                        </div>
                                    </div>
                                     <div class="form-group ">
                                        <label for="firstname" class="control-label col-lg-3">SỐ KHUNG</label>
                                        <div class="col-lg-6">
                                            <input class=" form-control" id="firstname" name="chassis" type="text">
                                        </div>
                                    </div>                                 
                                    <div class="form-group ">
                                        <label for="lastname" class="control-label col-lg-3">LOẠI</label>
                                        <select class="col-lg-6" name="species" style="width: 150px; margin-left: 15px; color: blue;">
                                          <c:forEach items="${listspecies}" var="species">
                                            <option class=" form-control" id="lastname" value="${species.speciesId}">${species.nameSpecies}</option>  
                                            </c:forEach>                                       
                                        </select>
                                    </div>
                                    
                                     
                                    <div class="form-group ">
                                        <label for="lastname" class="control-label col-lg-3">Hãng</label>
                                        <select class="col-lg-6" name="manufact" style="width: 150px; margin-left: 15px; color: blue;">
                                        <c:forEach items="${listsmanu}" var="manufact">
                                            <option class=" form-control" id="lastname" value="${manufact.manuFacID}">${manufact.nameManufac}</option>   
                                            </c:forEach>                                      
                                        </select>
                                    </div>
                                    
                                    <div class="form-group ">
                                        <label for="username" class="control-label col-lg-3">SỐ LƯỢNG</label>
                                        <div class="col-lg-6">
                                            <input class="form-control " id="username" name="quantity" type="text">
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="agree" class="control-label col-lg-3 col-sm-3">ẢNH</label>
                                        <div class="col-lg-6 col-sm-9">
                                            <input class="form-control " id="email" name="uploadFile" type="file" required="required">
                                        </div>
                                    </div>
                                       <div class="form-group ">
                                        <label for="email" class="control-label col-lg-3">SỐ CHỖ XE</label>
                                        <div class="col-lg-6">
                                         <select class="col-lg-6" name="seatnumber" style="width: 150px; margin-left: 15px; color: blue;">           
                                            <option class=" form-control" id="lastname" value="xe 2 chỗ">Xe 2 chỗ</option>      
                                            <option class=" form-control" id="lastname" value="xe 4 chỗ">Xe 4 chỗ</option>   
                                            <option class=" form-control" id="lastname" value="xe 7 chỗ">Xe 7 chỗ</option>   
                                            <option class=" form-control" id="lastname" value="xe 9 chỗ">Xe 9 chỗ</option>   
                                            <option class=" form-control" id="lastname" value="xe 12 chỗ">Xe 12 chỗ</option>   
                                            <option class=" form-control" id="lastname" value="xe 16 chỗ">Xe 16 chỗ</option> 
                                            <option class=" form-control" id="lastname" value="xe 45 chỗ">Xe 45 chỗ</option>                                                                              
                                        </select>
                                        </div>
                                    </div>
                                      <div class="form-group ">
                                        <label for="email" class="control-label col-lg-3">Gía theo ngày</label>
                                        <div class="col-lg-6">
                                            <input class="form-control " id="email" name="price" type="text">
                                        </div>
                                    </div>
                                      <div class="form-group ">
                                        <label for="email" class="control-label col-lg-3">Gía theo giờ</label>
                                        <div class="col-lg-6">
                                            <input class="form-control " id="email" name="pricehour" type="text">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-lg-offset-3 col-lg-6">
                                            <button class="btn btn-primary" type="submit">THÊM</button>
                                            <button class="btn btn-default" type="button">Cancel</button>
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