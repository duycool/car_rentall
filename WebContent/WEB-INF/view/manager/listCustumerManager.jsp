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
	<jsp:include page="/WEB-INF/view/templ/headerManage.jsp"></jsp:include>
<section id="main-content">
	<section class="wrapper">
		<div class="table-agile-info">
 <div class="panel panel-default">
    <div class="panel-heading">
    	KHÁCH HÀNG
    </div>
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
            <th data-breakpoints="xs">CUSTUMER ID</th>       
            <th>USER ID</th>
            <th>TÊN KHÁCH HÀNG</th>
           	<th>CMND</th>
            <th>NGÀY SINH</th>
            <th>EMAIL</th>
            <th>ĐỊA CHỈ</th>
            <th>SỐ ĐIỆN THOẠI</th>
            <th>VAI TRÒ</th>
            <th>TÁC VỤ</th>
          </tr>
        </thead>
        <c:forEach items="${listcustumer}" var="custumer">
        <tbody>
          <tr>
            <td>${custumer.custumerid}</td>
            <td>${custumer.userid}</td>  
            <td>${custumer.fullnName}</td>
            <td>${custumer.idcard}</td>  
            <td>${custumer.dateBrith}</td>
            <td>${custumer.email}</td>   
            <td>${custumer.address}</td> 
            <td>${custumer.phoneNumber}</td>    
             <td>${custumer.roles}</td>   
             <td>      
             	<a class="btn btn-primary" href="deleteCustumerManager?userid=${custumer.userid}">DELETE</a>              	
             </td>  
          
          </tr>
        </tbody>
        </c:forEach>
      </table>
      <a href="${pageContext.request.contextPath}/homeStaffManage">Cancel</a>
    </div>
  </div>
</div>
</section>
 <!-- footer -->
		  <div class="footer">
			<div class="wthree-copyright">
			  <p>©ĐÀ NẴNG VIỆT NAM </p>
			</div>
		  </div>
  <!-- / footer -->
</section>

<!--main content end-->
</section>
</body>
</html>