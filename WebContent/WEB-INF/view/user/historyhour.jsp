<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/view/templ/headeruser1.jsp"></jsp:include>
	<div class="container">
	<h2 align="center" class="text-secondary">Lịch Sử Thuê Xe Theo Giờ</h2>
	<h2 align="center" style="color: red;"><%= request.getAttribute("notification") != null ? request.getAttribute("notification") : " " %></h2>
	<table class="table table-info">
	<thead>
		<tr class="text-secondary"  >
			<th scope="col" >Ảnh Xe</th>
			<th scope="col" >Tên Xe</th>
			<th scope="col" >Ngày Thuê</th>
			<th scope="col">Giờ Thuê</th>
			<th scope="col">Giờ Trả</th>
			<th scope="col">Tổng Giờ Thuê</th>
			<th scope="col">Tổng Tiền</th>
			<th scope="col">Trạng Thái</th>
			<th scope="col">Hủy</th>
		</tr>
	</thead>
	<c:forEach items="${lisContractHour}" var ="history">
	<tbody>		
		<tr>						
			<td scope="row"><img src="images/${history.avatar}" width="170px" height="220px"/></td>	
			<td>${history.nameCar}</td>	
			<td>${history.dayhire}</td>		
			<td>${history.timehire}</td>
			<td>${history.paytime}</td>
			<td>${history.totaltime}</td>
			<td>${history.totalMoney}</td>
			<td>${history.status}</td>
			<td><a href="deleteContracthour?id_contract=${history.contractid}" ><i class="fa fa-times text-danger text">Hủy</i></a></td>									
		</tr>		
	</tbody>
	</c:forEach>
	</table>
	<jsp:include page="/WEB-INF/view/footer.jsp"></jsp:include>
	</div>
</body>
</html>