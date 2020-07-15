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
    	Tất Cả Sản Phẩm Vừa Mới Thêm Vào
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
            <th data-breakpoints="xs">ID XE</th>
            <th>TÊN LOẠI</th>
            <th>IÊN HÃNG</th>
            <th>TÊN XE</th>     
            <th data-breakpoints="xs">SỐ LƯỢNG</th>  
            <th data-breakpoints="xs">SỐ HIỆN CÒN</th>       
            <th data-breakpoints="xs">ẢNH</th>
            <th>GIÁ THEO NGÀY</th>
            <th>GIÁ THEO GIỜ</th>       
            <th>CẬP NHẬP</th>
            <th>SỐ CHỖ</th>    
            <th>CẬP NHẬT</th>      
          </tr>
        </thead>
       <form  action="addPromotionDBManager" method="post">
        <c:forEach items="${promotion.promotionDetails}" var="promotionDetail">
        <tbody>
          <tr>
           <td>${promotionDetail.car.id_car}</td>          
            <td>${promotionDetail.speciesCar.nameSpecies}</td>
            <td>${promotionDetail.manufacturerCar.nameManufac}</td>
            <td>${promotionDetail.car.nameCar}</td>          
            <td>${promotionDetail.quantity}</td>
            <td>${promotionDetail.car.still_exist}</td>
            <td><img src="images/${promotionDetail.car.avatar}" width="170px" height="220px"/></td>
            <td>${promotionDetail.car.price}</td> 
            <td>${promotionDetail.car.pricehour}</td>      
            <td>${promotionDetail.car.seatnumber}</td>  
             <td><a href="deletePromotionManagerItems?id_car=${promotionDetail.car.id_car}">DELETE</a></td>                    	 
          </tr>
        </tbody>  
        <input type="hidden"   name="idcar"   value="${promotionDetail.car.id_car}"/>      
        </c:forEach> 
        <div style="margin-top: 30px;">   
         <label>Ngày giảm : </label>
        <input type="date" name="starday"> 
         <label>Ngày kết thúc giảm: </label>
        <input type="date" name="endday"> 
        <label>Tiêu đề giảm giá : </label>               
        <select type="text" name="title"> 
        	<option value="5%"> Giảm  Giá 5%</option>
        	<option value="10%">Giảm Giá 10%</option>
        	<option value="20%">Giảm Giá 20%</option>
        	<option value="30%">Giảm Giá 30%</option>
        	<option value="40%">Giảm Giá 40%</option>
        	<option value="50%">Giảm Giá 50%</option>
        </select><br>
         <input type="submit"     value="Thêm" class="btn-primary" style="margin-left: 500px;"/>   
        </form>
        </div> 
      </table>      
      <a href="${pageContext.request.contextPath}/homeStaffManage">Cancel</a>
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