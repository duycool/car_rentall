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
<jsp:include page="/WEB-INF/view/templ/headerManage.jsp"></jsp:include>
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
                            CẬP NHẬT XE
                            <span class="tools pull-right">
                                <a class="fa fa-chevron-down" href="javascript:;"></a>
                                <a class="fa fa-cog" href="javascript:;"></a>
                                <a class="fa fa-times" href="javascript:;"></a>
                             </span>
                        </header>
                        <div class="panel-body">
                            <div class="form">
                                <form class="cmxform form-horizontal " id="signupForm" method="post" action="${pageContext.request.contextPath}/updateCarManager" novalidate="novalidate" enctype="multipart/form-data">
                                    <div class="form-group ">
                                        <label for="firstname" class="control-label col-lg-3"></label>
                                        <div class="col-lg-6">
                                            <input class=" form-control"  type="hidden"   id="firstname" name="idproduct"  value="${car.id_car}">
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="firstname" class="control-label col-lg-3">Tên Sản Phẩm</label>
                                        <div class="col-lg-6">
                                            <input class=" form-control" id="firstname" name="nameproduct" value="${car.nameCar}">
                                        </div>
                                    </div>
                                        <div class="form-group ">
                                        <label for="firstname" class="control-label col-lg-3">Review Sản Phẩm</label>
                                        <div class="col-lg-6">
                                            <input class=" form-control" id="firstname" name="status" value="${car.status}">
                                        </div>
                                    </div>
                                        <div class="form-group ">
                                        <label for="firstname" class="control-label col-lg-3">MÀU SẢN PHẨM</label>
                                        <div class="col-lg-6">
                                            <input class=" form-control" id="firstname" name="color" type="text" value="${car.color}">
                                        </div>
                                    </div>
                                     <div class="form-group ">
                                        <label for="firstname" class="control-label col-lg-3">PHÂN KHỐI</label>
                                        <div class="col-lg-6">
                                            <input class=" form-control" id="firstname" name="ounce" type="text" value="${car.ounce}"> 
                                        </div>
                                    </div>
                                     <div class="form-group ">
                                        <label for="firstname" class="control-label col-lg-3">SỐ KHUNG</label>
                                        <div class="col-lg-6">
                                            <input class=" form-control" id="firstname" name="chassis" type="text" value="${car.chassisnumber}">
                                        </div>
                                    </div>                                 
                                    <div class="form-group ">
                                        <label for="username" class="control-label col-lg-3">Quantity</label>
                                        <div class="col-lg-6">
                                            <input class="form-control " id="username" name="acmount" value="${car.quantity}">
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="username" class="control-label col-lg-3">Số hiện còn</label>
                                        <div class="col-lg-6">
                                            <input class="form-control " id="username" name="stillExist" value="${car.still_exist}">
                                        </div>
                                    </div>    
                                    <div class="form-group ">
                                        <label for="email" class="control-label col-lg-3">CHỖ NGỒI HIỆN TẠI</label>
                                        <div class="col-lg-6">
                                            <input class="form-control " id="email" name="seat" value="${car.seatnumber}" readonly="readonly">
                                        </div>
                                    </div>                                       
                                      <div class="form-group ">
                                        <label for="email" class="control-label col-lg-3">Giá Theo Ngày</label>
                                        <div class="col-lg-6">
                                            <input class="form-control " id="email" name="price" value="${car.price}">
                                        </div>
                                    </div>
                                    <div class="form-group ">
                                        <label for="email" class="control-label col-lg-3">Giá Theo Giờ</label>
                                        <div class="col-lg-6">
                                            <input class="form-control " id="email" name="pricehour" value="${car.pricehour}">
                                        </div>
                                    </div>                                  
                                    <div class="form-group">
                                        <div class="col-lg-offset-3 col-lg-6">
                                            <button class="btn btn-primary" type="submit">CẬP NHẬT</button>
                                            <button class="btn btn-default" type="button" ><a href="${pageContext.request.contextPath}/listCaradmin">CANCEL</a></button>
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
       
         <div class="panel-body">
         <div class="row">
                <div class="col-lg-12">
                    <section class="panel">
                        <header class="panel-heading">
                            CẬP NHẬT ẢNH 
                            <span class="tools pull-right">
                                <a class="fa fa-chevron-down" href="javascript:;"></a>
                                <a class="fa fa-cog" href="javascript:;"></a>
                                <a class="fa fa-times" href="javascript:;"></a>
                             </span>
                        </header>
                        <div class="panel-body">
                            <div class="form">
                                   <form class="cmxform form-horizontal " id="signupForm" method="post" action="${pageContext.request.contextPath}/updateImagesManager" novalidate="novalidate" enctype="multipart/form-data">
                                    <div class="form-group ">
                                        <label for="firstname" class="control-label col-lg-3"></label>
                                        <div class="col-lg-6">
                                            <input class=" form-control"  type="hidden"   id="firstname" name="idproduct"  value="${car.id_car}">
                                        </div>
                                    </div>   
                                       <div class="form-group ">
                                        <label for="agree" class="control-label col-lg-3 col-sm-3">ẢNH HIỆN TẠI</label>
                                        <div class="col-lg-6 col-sm-9">
                                        	<img   name="file" src="images/${car.avatar}" width="170px" height="220px">                                                                                      
                                        </div>
                                    </div>                                 
                                    <div class="form-group ">
                                        <label for="agree" class="control-label col-lg-3 col-sm-3">Ảnh Mới</label>
                                        <div class="col-lg-6 col-sm-9">                           
                                            <input class="form-control " id="email" name="uploadFile" type="file" required="required" value="images/${car.avatar}">                                           
                                        </div>
                                    </div>                             
                                    <div class="form-group">
                                        <div class="col-lg-offset-3 col-lg-6">
                                            <button class="btn btn-primary" type="submit">CẬP NHẬT</button>
                                              <button class="btn btn-default" type="button" ><a href="${pageContext.request.contextPath}/listCaradmin">CANCEL</a></button>
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
           
       <div class="panel-body">
         <div class="row">
                <div class="col-lg-12">
                    <section class="panel">
                        <header class="panel-heading">
                            CẬP NHẬT LOẠI
                            <span class="tools pull-right">
                                <a class="fa fa-chevron-down" href="javascript:;"></a>
                                <a class="fa fa-cog" href="javascript:;"></a>
                                <a class="fa fa-times" href="javascript:;"></a>
                             </span>
                        </header>
                        <div class="panel-body">
                            <div class="form">
                   	 <form action="updateCarSpeciesManager" method="post" style="margin-top: 100px" class="cmxform form-horizontal" id="signupForm">
        					<table border="0" width="35%" align="center">
      					           	
                        <tr>
                        	<td><input  type="hidden"   name="idproduct"  value="${car.id_car}"></td>              			
            			</tr>                          				
        				</table>
         						<div class="form-group ">
                                        <label for="agree" class="control-label col-lg-3 col-sm-3">LOẠI HIỆN TẠI</label>
                                        <div class="col-lg-6 col-sm-9">
                                        	<input class="form-control " id="email"  type="text" required="required" value="${speciesCar.nameSpecies}" readonly="readonly">                                                                                         
                                        </div>
                                    </div>                                 
                               		 
                                    <div class="form-group ">
                                        <label for="lastname" class="control-label col-lg-3">LOẠI</label><br>
                                        <select class="col-lg-6" name="species" style="width: 150px; margin-left: 15px; color: blue;">
                                        	<c:forEach items="${listSpecies}" var="species">
                                            <option class=" form-control" id="lastname" value="${species.speciesId}">${species.nameSpecies}</option>  
                                            </c:forEach>                                        
                                        </select>
                                    </div>
                                      <div class="form-group">
                                        <div class="col-lg-offset-3 col-lg-6">
                                            <button class="btn btn-primary" type="submit">CẬP NHẬT</button>
                                              <button class="btn btn-default" type="button" ><a href="${pageContext.request.contextPath}/listCaradmin">CANCEL</a></button>
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
           
           
              <div class="panel-body">
         <div class="row">
                <div class="col-lg-12">
                    <section class="panel">
                        <header class="panel-heading">
                            CẬP NHẬT HÃNG
                            <span class="tools pull-right">
                                <a class="fa fa-chevron-down" href="javascript:;"></a>
                                <a class="fa fa-cog" href="javascript:;"></a>
                                <a class="fa fa-times" href="javascript:;"></a>
                             </span>
                        </header>
                        <div class="panel-body">
                            <div class="form">
                   	 <form action="updateCarManuManager" method="post" style="margin-top: 100px" class="cmxform form-horizontal" id="signupForm">
        					<table border="0" width="35%" align="center">
      					           	
                        <tr>
                        	<td><input  type="hidden"   name="idproduct"  value="${car.id_car}"></td>              			
            			</tr>                          				
        				</table>
         						<div class="form-group ">
                                        <label for="agree" class="control-label col-lg-3 col-sm-3">HÃNG HIỆN TẠI</label>
                                        <div class="col-lg-6 col-sm-9">
                                        	<input class="form-control " id="email"  type="text" required="required" value="${maCar.nameManufac}" readonly="readonly">                                                                                         
                                        </div>
                                    </div>                                 
                  
                                    <div class="form-group ">
                                        <label for="lastname" class="control-label col-lg-3">Hãng</label>
                                        <select class="col-lg-6" name="manufact" style="width: 150px; margin-left: 15px; color: blue;">
                                        	<c:forEach items="${listmanu}" var="manufact">
                                            <option class=" form-control" id="lastname" value="${manufact.manuFacID}">${manufact.nameManufac}</option>  
                                            </c:forEach>                                         
                                        </select>
                                    </div>
                                      <div class="form-group">
                                        <div class="col-lg-offset-3 col-lg-6">
                                            <button class="btn btn-primary" type="submit">CẬP NHẬT</button>
                                              <button class="btn btn-default" type="button" ><a href="${pageContext.request.contextPath}/listCaradmin">CANCEL</a></button>
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
              <div class="panel-body">
         <div class="row">
                <div class="col-lg-12">
                    <section class="panel">
                        <header class="panel-heading">
                            CẬP NHẬT CHỖ XE
                            <span class="tools pull-right">
                                <a class="fa fa-chevron-down" href="javascript:;"></a>
                                <a class="fa fa-cog" href="javascript:;"></a>
                                <a class="fa fa-times" href="javascript:;"></a>
                             </span>
                        </header>
                        <div class="panel-body">
                            <div class="form">
                                   <form action="updateSeatNumberManager" method="post" style="margin-top: 100px" class="cmxform form-horizontal" id="signupForm">
                                	<table border="0" width="35%" align="center">
      					           	
    		                    <tr>
                        		<td><input  type="hidden"   name="idproduct"  value="${car.id_car}"></td>              			
            					</tr>                          				
        						</table>
                                   <div class="form-group ">
                                        <label for="email" class="control-label col-lg-3">CHỖ NGỒI HIỆN TẠI</label>
                                        <div class="col-lg-6">
                                            <input class="form-control " id="email" name="seat" value="${car.seatnumber}" readonly="readonly">
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
                                    <div class="form-group">
                                        <div class="col-lg-offset-3 col-lg-6">
                                            <button class="btn btn-primary" type="submit">CẬP NHẬT</button>
                                              <button class="btn btn-default" type="button" ><a href="${pageContext.request.contextPath}/listCaradmin">CANCEL</a></button>
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