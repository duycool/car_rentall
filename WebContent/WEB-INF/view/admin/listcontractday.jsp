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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<jsp:include page="/WEB-INF/view/templ/headeradmin.jsp"></jsp:include>
<section id="main-content">
	<section class="wrapper">
		<div class="table-agile-info">
 <div class="panel panel-default">
    <div class="panel-heading">
    	Hợp Đồng Thuê Theo Ngày
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
            <th data-breakpoints="xs">NGÀY TRẢ</th>
            <th>TỔNG NGÀY</th>
            <th>ẢNH XE</th>
            <th>TÊN XE</th>
            <th>TỔNG TIỀN</th> 
            <th>NHÂN VIÊN</th>         
            <th>CẬP NHẬP</th>             
          </tr>
        </thead>
        <c:forEach items="${listContractday}" var="contractday">
        <tbody>
          <tr>
           <td>${contractday.id_car}</td>          
            <td>${contractday.custumerid}</td>
            <td>${contractday.email}</td>  
            <td>${contractday.deposit}</td>
            <td>${contractday.dayhire}</td>          
            <td>${contractday.payday}</td>
            <td>${contractday.totalday}</td>
            <td><img src="images/${contractday.avatar}" width="170px" height="220px"/></td>
            <td>${contractday.nameCar}</td> 
            <td>${contractday.totalMoney}</td> 
			<td>
			<form action="updateContractday" method="get">
           	<c:forEach items="${lisStaff}" var="staff">          		
           			<select name="staff">
           				<option value="${staff.staffid}">${staff.fullname}</option>
           			</select>         		 
           	</c:forEach>  
           	<input type="hidden" value="${contractday.contractid}" name="idcontract">
           	<input type="submit" value="Cập nhật">
           	</form>
           	</td>             
             <td>            
             	<a href="contractdayPDF?contractid=${contractday.contractid}">IN HÓA ĐƠN</a>          	         
             </td>                  
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