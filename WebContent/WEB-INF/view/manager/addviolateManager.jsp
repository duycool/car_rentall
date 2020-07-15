<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                           THÊM HỢP ĐỒNG VI PHẠM
                            <span class="tools pull-right">
                                <a class="fa fa-chevron-down" href="javascript:;"></a>
                                <a class="fa fa-cog" href="javascript:;"></a>
                                <a class="fa fa-times" href="javascript:;"></a>
                             </span>
                        </header>
                        <div class="panel-body">
                            <div class="form">
                   	 <form action="addViolateManager" method="post" style="margin-top: 100px" class="cmxform form-horizontal" id="signupForm">    
                   	 			<h2 align="center" style="color: red;"><%= request.getAttribute("mess") != null ? request.getAttribute("mess") : " " %></h2>				
         						<div class="form-group ">
                                        <label for="agree" class="control-label col-lg-3 col-sm-3">TÊN KHÁCH HÀNG VI PHẠM</label>
                                        <div class="col-lg-6 col-sm-9">
                                        	<input class="form-control " id="email"  type="text" readonly="readonly" value="${custumer.fullnName}">                                                                                         
                                        </div>
                                    </div>                                                  
                                 	<div class="form-group ">
                                        <label for="agree" class="control-label col-lg-3 col-sm-3">TIỀN VI PHẠM HỢP ĐỒNG</label>
                                        <div class="col-lg-6 col-sm-9">
                                        	<input class="form-control " id="email"  type="number" required="required" name="price">                                                                                         
                                        </div>
                                    </div> 
                                    <div class="form-group ">
                                        <label for="agree" class="control-label col-lg-3 col-sm-3">LÝ DO VI PHẠM</label>
                                        <div class="col-lg-6 col-sm-9">
                                        	<input class="form-control " id="email"  type="text" required="required" name="reason">                                                                                         
                                        </div>
                                    </div>                                                                     
                                    <div class="form-group">
                                        <div class="col-lg-offset-3 col-lg-6">
                                             <button class="btn btn-primary" type="submit">LƯU</button>
                                              <button class="btn btn-default" type="button" ><a href="${pageContext.request.contextPath}/homeStaffManage">CANCEL</a></button>
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