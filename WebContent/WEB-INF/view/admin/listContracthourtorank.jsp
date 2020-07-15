<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<head>
<title>Visitors an Admin Panel Category Bootstrap Responsive Website Template | Responsive_table :: w3layouts</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Visitors Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- bootstrap-css -->
<link rel="stylesheet" href="css/bootstrap.min.css" >
<!-- //bootstrap-css -->
<!-- Custom CSS -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<link href="css/style-responsive.css" rel="stylesheet"/>
<!-- font CSS -->
<link href='//fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
<!-- font-awesome icons -->
<link rel="stylesheet" href="css/font.css" type="text/css"/>
<link href="css/font-awesome.css" rel="stylesheet"> 
<!-- //font-awesome icons -->
<script src="js/jquery2.0.3.min.js"></script>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<jsp:include page="/WEB-INF/view/templ/headeradmin.jsp"></jsp:include>
	
<section id="main-content">
	<section class="wrapper">
		<div class="table-agile-info">
	 <div class="panel panel-default">
    <div class="panel-heading">
    	<%= request.getAttribute("title") != null ? request.getAttribute("title") : " " %>
    </div>
                         	<p align="center" style="color: red;"><%= request.getAttribute("message") != null ? request.getAttribute("message") : " " %></p> 
    <div>
      <table class="table" ui-jq="footable" ui-options='{
        "paging": {
          "enabled": true
        },
        "filtering": {
          "enabled": true
        },
        "sorting": {
          "enabled": true
        }}'>
        
        <thead>
          <tr>
            <th data-breakpoints="xs">ID XE</th>
            <th>ID Custumer</th>
            <th>Email</th>  
            <th data-breakpoints="xs">TIỀN TRẢ TRƯỚC</th>  
            <th data-breakpoints="xs">NGÀY THUÊ</th>       
            <th data-breakpoints="xs">GIỜ THUÊ</th>
             <th data-breakpoints="xs">GIỜ TRẢ</th>
            <th>TỔNG GIỜ THUÊ</th>
            <th>ẢNH XE</th>
            <th>TÊN XE</th>
            <th>TỔNG TIỀN</th>          
            <th>TÁC VỤ</th>             
          </tr>
        </thead>
        <c:forEach items="${listcontracthour}" var="contracthour">
        <tbody>
          <tr>
           <td>${contracthour.id_car}</td>          
            <td>${contracthour.custumerid}</td>
            <td>${contracthour.email}</td>  
            <td>${contracthour.deposit}</td>
            <td>${contracthour.dayhire}</td>          
            <td>${contracthour.timehire}</td>
            <td>${contracthour.paytime}</td>
            <td>${contracthour.totaltime}</td>
            <td><img src="images/${contracthour.avatar}" width="170px" height="220px"/></td>
            <td>${contracthour.nameCar}</td> 
            <td>${contracthour.totalMoney}</td>   
            <td>${contracthour.totalMoney}</td>   
            <td><a class="btn-primary primary" href="addViolateAdmin?carid=${contracthour.id_car}&custumerid=${contracthour.custumerid}">AddViPhạm</a></td>      </td>                                        
          </tr>
        </tbody>
        </c:forEach>

      </table>
      <a href="${pageContext.request.contextPath}/homeadmin">Cancel</a>
    </div>
  </div>
</div>
</section>
 <!-- footer -->
		  <div class="footer">
			<div class="wthree-copyright">
			  <p>© DANANG <a href="https://www.facebook.com/chamhoilon">DUYNGUYEN</a></p>
			</div>
		  </div>
  <!-- / footer -->
</section>

<!--main content end-->
</section>

</body>
</html>