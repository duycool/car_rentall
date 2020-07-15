<%@page import="com.ute.rental.dao.MethodDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"  />
<meta name="keywords" content="Visitors Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- bootstrap-css -->
<link rel="stylesheet" href="csss/bootstrap.min.css" >
<!-- //bootstrap-css -->
<!-- Custom CSS -->
<link href="csss/stylee.css" rel='stylesheet' type='text/css' />
<link href="csss/style-responsive.css" rel="stylesheet"/>
<!-- font CSS -->
<link href='//fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
<!-- font-awesome icons -->
<link rel="stylesheet" href="csss/font.css" type="text/css"/>
<link href="csss/font-awesome.css" rel="stylesheet"> 
<link rel="stylesheet" href="csss/morris.css" type="text/css"/>
<!-- calendar -->
<link rel="stylesheet" href="csss/monthly.css">

<!-- //calendar -->
<!-- //font-awesome icons -->


<script src="jsss/jquery2.0.3.min.js"></script>
<script src="jsss/raphael-min.js"></script>
<script src="jsss/morris.js"></script>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hóa Đơn Thuê Theo Giờ</title>
</head>
<body>
	<div class="tile">
            <section class="invoice">
              <div class="row mb-4">
                <div class="col-6">
                  <h2 class="page-header" style="color:  green;"><i class="fa fa-globe"></i> HÓA ĐƠN THUÊ THEO GIỜ</h2>
                </div>
                <div class="col-6">
                <%String ngayht = MethodDAO.Ngayhientai(); %>
                  <h5 class="text-right">Ngày: <%=ngayht %> </h5>
                </div>
              </div>
              <div class="row invoice-info">
                <div class="col-4"><span style="color: green;"><b>Thông tin khách hàng</b></span>
                  <address><strong>Họ tên: ${contractHour.fullnName}</strong><br>Địa chỉ Giao Xe: ${contractHour.adressDelivery}<br>Email: ${contractHour.email}</address>
                </div>
                <div class="col-4"><span style="color: green;"><b>Thông tin WebSite</b></span>
                  <address><strong>CHOTHUEXE</strong><br>Đà Nẵng<br>Số điện thoại: 0764103425<br>Email:duy19899@gmail.com</address>
                </div>
                <div class="col-4"><span style="color: green;"><b>Thông tin đơn hàng</b></span>
                <address><b>TÊN LOẠI HỢP ĐỒNG</b> ${contractHour.nameSpecies}<br><b>ID Hợp Đồng: ${contractHour.contractid}</b></address>
                </div>
              </div>
              <div class="row">
                <div class="col-12 table-responsive">
                  <table class="table table-striped">
                    <thead>
                      <tr>             
                        <th>TÊN XE</th>
                        <th>NGÀY THUÊ</th>
                        <th>GIỜ THUÊ</th>
                        <th>GIỜ TRẢ</th>
                        <th>TỔNG THỜI GIAN</th>
                        <th>TỔNG TIỀN</th>
                        <th>ĐÃ THANH TOÁN TRƯỚC</th>
                        <th>CÒN LẠI</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr>               
                        <td>${contractHour.nameCar}</td>
                        <td>${contractHour.dayhire}</td>
                        <td>${contractHour.timehire}</td>
                        <td>${contractHour.paytime}</td>
                        <td>${contractHour.totaltime}</td>
                         <td>${contractHour.totalMoney}VNĐ</td>
                        <td>${contractHour.deposit}VNĐ</td>
                        <td>${rest}VNĐ</td>
                      </tr>
                     
                      </tbody>
                  </table>
                </div>
              </div>
              <div class="row d-print-none mt-2">
                <div class="col-12 text-right"><a class="btn btn-primary" onclick="window.print()"><i class="fa fa-print"></i> In</a></div>
              </div>
            </section>
          </div>
				
</body>
</html>