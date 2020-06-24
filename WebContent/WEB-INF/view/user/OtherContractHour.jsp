<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="css/style2.css">
        <link rel="stylesheet" href="css/jquery-ui.css">
<script src="js/jquery-1.12.4.js"></script>
<script src="js/jquery-ui.js"></script>
<script src="js/datepicker-vi.js"></script>
<script src="js/check.js"></script>
<script src="js/check.js"></script>
    </head>
    <body>
    	
					
        <div class="container">
            <div class="row">
                <div class="col-md-7">
                    <h1 class="text-left">Thuê xe , Thám Hiểm Mơ Mộng Khám Phá</h1>
                    <p class="text-left">Hai mươi năm về sau bạn sẽ hỗi hận nhiều hơn về Những gì bạn không làm .
							Vậy nên hãy tháo dây , nhổ neo ra khỏi bến đổ an toàn.
							Hãy Để Cánh buồm của bạn đón trọn lấy gió.</p>
                </div>
                <div class="col-md-5">
                <form action="${pageContext.request.contextPath}/contractOtherhour" method="post">
                    <div class="row">
                        <div class="col-md-6">
                            <h3 class="text-center" style="margin-left: 110px;">ThôngTin</h3>
                             <p class="text-center" style="margin-left: 110px;">TổngTiền:${contractHour.totalMoney}VNĐ</p>
                         </div> 
                            	<div class="row">
                        <label class="label col-md-2 control-label" for="from">Trả Trước:</label>
                            <div class="col-md-10">
                                <input type="number" class="form-control"   name="deposit" required="required">
                            </div>
                        </div>           
                      	 <div class="row">
                            <label class="label col-md-2 control-label" for="from">Tên:</label>
                            <div class="col-md-10">
                                <input type="text" class="form-control"   name="name" placeholder="Tên người Nhận" required="required">
                            </div>
                        </div>
                         <div class="row">
                            <label class="label col-md-2 control-label">ĐịaChỉ:</label>
                            <div class="col-md-10">
                                <input type="text" class="form-control" name="address" placeholder="Địa Chỉ" required="required" >
                            </div>
                        </div>
                           <div class="row">
                            <label class="label col-md-2 control-label">SĐT:</label>
                            <div class="col-md-10">
                                <input type="number" class="form-control" name="phone"  placeholder="Số Điện Thoại" required="required">
                            </div>
                        </div>                                                 						                                           
                        <p style="color: red;"><%= request.getAttribute("mess") != null ? request.getAttribute("mess") : " " %></p>
                        <input type="hidden" name="status" value="Waiting">
                        <input type="submit" class="btn btn-info checkday" value="Ðăng Ký">
                        <a href="${pageContext.request.contextPath}/homeuser"><div class="btn btn-warning">Cancel</div></a>
                        
                    </div>
                    </form>
                </div>  
            
            </div>
              
        </div>
        
    </body>
</html>
