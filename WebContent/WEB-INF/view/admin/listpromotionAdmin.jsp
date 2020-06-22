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
    	List Promotion
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
            <th data-breakpoints="xs">TÊN XE</th>                  
            <th>ẢNH</th> 
            <th>TÊN HÃNG</th> 
            <th>NGÀY BẮT ĐẦU</th> 
            <th>NGÀY KẾT THÚC</th>   
            <th>TIÊU ĐỀ</th>            
            <th>CẬP NHẬT</th>            
          </tr>
        </thead>      
        <tbody>
         <c:forEach items="${listpromotion}" var="promotion">  
         	<tr>       	        	            
              <td>${promotion.nameCar}</td>
               <td><img src="images/${promotion.avatar}" width="170px" height="220px"/></td>
              <td>${promotion.nameManufac}</td>
              <td>${promotion.starday}</td>
              <td>${promotion.endDay}</td>
              <td>${promotion.titile}</td>          
             <td><a href="updatePromotionAdmin?idpromotion=${promotion.idpromotion}">Update</a>
             	 <a href="deletePromotionAdmin?idpromotion=${promotion.idpromotion}">Delete</a>
             	<p style="color: red;"> <%= request.getAttribute("message") != null ? request.getAttribute("message") : " " %>  </p>          	 
             </td>       
             </tr>                   
         </c:forEach>                          
        </tbody>                    
      </table>
      <c:forEach items="${listprodetails}" var="prodetails">
      <a href="${pageContext.request.contextPath}/homeadmin">Cancel</a>
      </c:forEach>
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