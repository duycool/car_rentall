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
<script>
	$(function() {
		var dateFormat = "dd/mm/yy", from = $("#from").datepicker({
			defaultDate : "+1w",
			changeMonth : true,
			numberOfMonths : 2
		}).on("change", function() {
			to.datepicker("option", "minDate", getDate(this));
			calTT();
		}), to = $("#to").datepicker({
			defaultDate : "+1w",
			changeMonth : true,
			numberOfMonths : 2
		}).on("change", function() {
			from.datepicker("option", "maxDate", getDate(this));
			calTT();
		});

		function getDate(element) {
			var date;
			try {
				date = $.datepicker.parseDate(dateFormat, element.value);
			} catch (error) {
				date = null;
			}

			return date;
		}

		function calTT() {
			if ($('#from').val() && $('#to').val()) {
				var a = $("#from").datepicker('getDate').getTime(), b = $("#to")
						.datepicker('getDate').getTime(), c = 24 * 60 * 60 * 1000, diffDays = Math
						.round(Math.abs((a - b) / (c)));
				//console.log(diffDays);
				$('#days').val(diffDays);
			}
			;
			if ($('#from').val() && $('#to').val() && $('#price').val()
					&& $('#days').val()) {
				totalC = $('#days').val() * $('#price').val();
				$('#total').val(totalC);
			}

		}
		
		
	});
</script>
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
                <form action="${pageContext.request.contextPath}/contractDay" method="post">
                    <div class="row">
                        <div class="col-md-6">
                            <h3 class="text-center" style="margin-left: 110px;">ContractRental</h3>
                         </div>
                         <div class="col-md-6">
                             <span class="glyphicon glyphicon-pencil"></span>
                         </div>
                        <hr>                       
                        <input type="hidden" name="acmount" value="1">
                        <img src="images/${car.avatar}" width="350px" hight="200px" alt="" name="uploadFile" style="margin-left: 50px;">
                          <div class="row">
                            <label class="label col-md-2 control-label">Address:</label>
                            <div class="col-md-10">
                                <input type="text" class="form-control" name="address" placeholder="địa chỉ giao xe">
                            </div>
                        </div>								             
                         <div class="row">
                            <label class="label col-md-2 control-label" for="from">To:</label>
                            <div class="col-md-10">
                                <input type="text" class="form-control"  id="from" name="from" placeholder="Từ Ngày">
                            </div>
                        </div>
                         <div class="row">
                            <label class="label col-md-2 control-label">From:</label>
                            <div class="col-md-10">
                                <input type="text" class="form-control" id="to" name="to" placeholder="Đến Ngày">
                            </div>
                        </div>
                           <div class="row">
                            <label class="label col-md-2 control-label">Price:</label>
                            <div class="col-md-10">
                                <input type="text" class="form-control" id="price" name="price" value="<%= request.getAttribute("priceSaleOff") != null ? request.getAttribute("priceSaleOff") : " " %> <%= request.getAttribute("pricept") != null ? request.getAttribute("pricept") : " " %>" readonly="readonly"  style="color: black; font-size: 18px; margin-left:40px">
                            </div>
                        </div>
                         <div class="row">
                            <label class="label col-md-2 control-label">Daytotal:</label>
                            <div class="col-md-10">
                                <input type="number" class="form-control" id="days" name="days" readonly="readonly"  style="color: black; font-size: 15px; margin-left: 40px;">
                            </div>
                        </div>
                         <div class="row">
                            <label class="label col-md-2 control-label" for="total" >TotalMoneys:</label>
                            <div class="col-md-10">
                                <input type="number" class="form-control" id="total" name="total" readonly="readonly" style="color: black; font-size: 10px; margin-left: 55px;" >
                            </div>
                        </div>
                        <div class="row">
                            <label class="label col-md-2 control-label"  >Prepay:</label>
                            <div class="col-md-10">
                                <input type="number" class="form-control"  name="prepay" placeholder="Trả trước VNĐ">
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
