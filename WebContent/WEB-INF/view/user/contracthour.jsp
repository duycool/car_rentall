<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title>contract hour</title>
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
                <form action="${pageContext.request.contextPath}/contractHour" method="post" id="form-login">
                    <div class="row">
                        <div class="col-md-6">
                            <h3 class="text-center" style="margin-left: 110px;">HợpĐồngThuêTheoGiờ</h3>
                         </div>
                         <div class="col-md-6">
                             <span class="glyphicon glyphicon-pencil"></span>
                         </div>
                        <hr>                         
                        <img src="images/${car.avatar}" width="350px" hight="200px" alt="" name="uploadFile" style="margin-left: 50px;">                  
                          <div class="row">
                            <label class="label col-md-2 control-label">NgàyThuê:</label>
                            <div class="col-md-10">
                                <input type="date" class="form-control" name="date" >
                            </div>
                        </div>
                          <div class="row">
                            <label class="label col-md-2 control-label">Giá:</label>
                            <div class="col-md-10">
                                <input type="text" class="input form-control form-control-lg" name="pricehour" value="<%= request.getAttribute("priceSaleOff") != null ? request.getAttribute("priceSaleOff") : request.getAttribute("pricehour") != null ? request.getAttribute("pricehour") : " "%>" readonly="readonly"  style="color: black; font-size: 18px; margin-left:40px">
                            </div>
                        </div> 	               					                                  
                          <div class="row">
                            <label class="label col-md-2 control-label" for="from">GiờThuê:</label>
                            <div class="col-md-5">
                                <select class="input form-control form-control-c "  name="hourhire" >
                                    <option value="1">1 giờ</option>
                                    <option value="2">2 giờ</option>
                                    <option value="3">3 giờ</option>
                                    <option value="4">4 giờ</option>
                                    <option value="5">5 giờ</option>   
                                   	<option value="6">6 giờ</option> 
                                   	<option value="7">7 giờ</option> 
                                  	<option value="8">8 giờ</option> 
                                    <option value="9">9 giờ</option> 
                                    <option value="10">10 giờ</option> 
                                    <option value="11">11 giờ</option> 
                                    <option value="12">12 giờ</option> 
                                    <option value="13">13 giờ</option> 
                                    <option value="14">14 giờ</option> 
                                  	<option value="15">15 giờ</option> 
                                    <option value="16">16 giờ</option> 
                                    <option value="17">17 giờ</option> 
                                    <option value="18">18 giờ</option> 
                                    <option value="19">19 giờ</option> 
                                  	<option value="20">20 giờ</option> 
                                    <option value="21">21 giờ</option> 
                                    <option value="22">22 giờ</option> 
                                    <option value="23">23 giờ</option> 
                                    <option value="24">24 giờ</option>               
                                </select>
                            </div>
                        </div>
                        
                        
                        <div class="row">
                            <label class="label col-md-2 control-label" for="from">PhútThuê:</label>
                            <div class="col-md-5">
                                <select class="input form-control form-control-e "  name="minutehire" >
                                      <option value="0">0 phút</option>
                                    <option value="1">1 phút</option>
                                    <option value="2">2 phút</option>
                                    <option value="3">3 phút</option>
                                    <option value="4">4 phút</option>
                                    <option value="5">5 phút</option>   
                                   	<option value="6">6 phút</option> 
                                   	<option value="7">7 phút</option> 
                                  	<option value="8">8 phút</option> 
                                    <option value="9">9 phút</option> 
                                    <option value="10">10 phút</option> 
                                    <option value="11">11 phút</option> 
                                    <option value="12">12 phút</option> 
                                    <option value="13">13 phút</option> 
                                    <option value="14">14 phút</option> 
                                  	<option value="15">15 phút</option> 
                                    <option value="16">16 phút</option> 
                                    <option value="17">17 phút</option> 
                                    <option value="18">18 phút</option> 
                                    <option value="19">19 phút</option> 
                                  	<option value="20">20 phút</option> 
                                    <option value="21">21 phút</option> 
                                    <option value="22">22 phút</option> 
                                    <option value="23">23 phút</option> 
                                    <option value="24">24 phút</option> 
                                    <option value="25">25 phút</option> 
                                    <option value="26">26 phút</option> 
                                    <option value="27">27 phút</option> 
                                    <option value="28">28 phút</option> 
                                    <option value="29">29 phút</option> 
                                    <option value="30">30 phút</option> 
                                    <option value="31">31 phút</option> 
                                    <option value="32">32 phút</option> 
                                    <option value="33">33 phút</option> 
                                    <option value="34">34 phút</option> 
                                    <option value="35">35 phút</option> 
                                    <option value="36">36 phút</option> 
                                    <option value="37">37 phút</option> 
                                    <option value="38">38 phút</option> 
                                    <option value="39">39 phút</option> 
                                    <option value="40">40 phút</option> 
                                    <option value="41">41 phút</option> 
                                    <option value="42">42 phút</option> 
                                    <option value="43">43 phút</option> 
                                    <option value="44">44 phút</option> 
                                    <option value="45">45 phút</option> 
                                    <option value="46">46 phút</option> 
                                    <option value="47">47 phút</option> 
                                    <option value="48">48 phút</option> 
                                    <option value="49">49 phút</option> 
                                    <option value="50">50 phút</option> 
                                    <option value="51">51 phút</option> 
                                    <option value="52">52 phút</option> 
                                    <option value="53">53 phút</option> 
                                    <option value="54">54 phút</option> 
                                    <option value="55">55 phút</option> 
                                    <option value="56">56 phút</option> 
                                    <option value="57">57 phút</option> 
                                    <option value="58">58 phút</option> 
                                    <option value="59">59 phút</option> 
                                    <option value="60">60 phút</option>                   
                                </select>
                            </div>
                        </div>        
                        <div class="row">
                            <label class="label col-md-2 control-label" for="from">GiờTrả:</label>
                            <div class="col-md-5">
                                <select class="input form-control  form-control-v "  name="hourpay" >
                                    <option value="1">1 giờ</option>
                                    <option value="2">2 giờ</option>
                                    <option value="3">3 giờ</option>
                                    <option value="4">4 giờ</option>
                                    <option value="5">5 giờ</option>   
                                   	<option value="6">6 giờ</option> 
                                   	<option value="7">7 giờ</option> 
                                  	<option value="8">8 giờ</option> 
                                    <option value="9">9 giờ</option> 
                                    <option value="10">10 giờ</option> 
                                    <option value="11">11 giờ</option> 
                                    <option value="12">12 giờ</option> 
                                    <option value="13">13 giờ</option> 
                                    <option value="14">14 giờ</option> 
                                  	<option value="15">15 giờ</option> 
                                    <option value="16">16 giờ</option> 
                                    <option value="17">17 giờ</option> 
                                    <option value="18">18 giờ</option> 
                                    <option value="19">19 giờ</option> 
                                  	<option value="20">20 giờ</option> 
                                    <option value="21">21 giờ</option> 
                                    <option value="22">22 giờ</option> 
                                    <option value="23">23 giờ</option> 
                                    <option value="24">24 giờ</option>               
                                </select>
                            </div>
                        </div>
                        <div class="row">
                            <label class="label col-md-2 control-label" for="from">PhútTrả:</label>
                            <div class="col-md-5">
                                <select class="input form-control  form-control-k "  name="minutepay">
                                    <option value="0">0 phút</option>
                                    <option value="1">1 phút</option>
                                    <option value="2">2 phút</option>
                                    <option value="3">3 phút</option>
                                    <option value="4">4 phút</option>
                                    <option value="5">5 phút</option>   
                                   	<option value="6">6 phút</option> 
                                   	<option value="7">7 phút</option> 
                                  	<option value="8">8 phút</option> 
                                    <option value="9">9 phút</option> 
                                    <option value="10">10 phút</option> 
                                    <option value="11">11 phút</option> 
                                    <option value="12">12 phút</option> 
                                    <option value="13">13 phút</option> 
                                    <option value="14">14 phút</option> 
                                  	<option value="15">15 phút</option> 
                                    <option value="16">16 phút</option> 
                                    <option value="17">17 phút</option> 
                                    <option value="18">18 phút</option> 
                                    <option value="19">19 phút</option> 
                                  	<option value="20">20 phút</option> 
                                    <option value="21">21 phút</option> 
                                    <option value="22">22 phút</option> 
                                    <option value="23">23 phút</option> 
                                    <option value="24">24 phút</option> 
                                    <option value="25">25 phút</option> 
                                    <option value="26">26 phút</option> 
                                    <option value="27">27 phút</option> 
                                    <option value="28">28 phút</option> 
                                    <option value="29">29 phút</option> 
                                    <option value="30">30 phút</option> 
                                    <option value="31">31 phút</option> 
                                    <option value="32">32 phút</option> 
                                    <option value="33">33 phút</option> 
                                    <option value="34">34 phút</option> 
                                    <option value="35">35 phút</option> 
                                    <option value="36">36 phút</option> 
                                    <option value="37">37 phút</option> 
                                    <option value="38">38 phút</option> 
                                    <option value="39">39 phút</option> 
                                    <option value="40">40 phút</option> 
                                    <option value="41">41 phút</option> 
                                    <option value="42">42 phút</option> 
                                    <option value="43">43 phút</option> 
                                    <option value="44">44 phút</option> 
                                    <option value="45">45 phút</option> 
                                    <option value="46">46 phút</option> 
                                    <option value="47">47 phút</option> 
                                    <option value="48">48 phút</option> 
                                    <option value="49">49 phút</option> 
                                    <option value="50">50 phút</option> 
                                    <option value="51">51 phút</option> 
                                    <option value="52">52 phút</option> 
                                    <option value="53">53 phút</option> 
                                    <option value="54">54 phút</option> 
                                    <option value="55">55 phút</option> 
                                    <option value="56">56 phút</option> 
                                    <option value="57">57 phút</option> 
                                    <option value="58">58 phút</option> 
                                    <option value="59">59 phút</option> 
                                    <option value="60">60 phút</option>                                                   
                                </select>
                            </div>
                        </div>			             
                         <div class="row">
                                <label class="label col-md-2 control-label" for="from">TổngGiờThuê:</label>
                            <div class="col-md-5">
                                <input type="text" id="tonggio" class="input form-control form-control-i " name="totalhour"  style="font-size: 30px" name="toltalhour1" readonly="readonly" >
                                 
                            </div>
                        </div>
                        <div class="row">
                            <label class="label col-md-2 control-label" for="from">TổngPhútThuê:</label>
                            <div class="col-md-5">
                                <input type="text" id="tongphut" class="input form-control  form-control-y " name="totalMinute" style="font-size: 30px"  name="toltalminu1" readonly="readonly" >                       
                            </div> 
                            </div>
                        <div class="row">
                            <label class="label col-md-2 control-label"  >ĐịaChỉGiaoXe:</label>
                            <div class="col-md-10">
                                <select  class="form-control"  name="address" >
                                	<option value="ofyou">Địa Chỉ Của Bạn</option>
                                	<option value="other">Địa Chỉ Khác</option>
                                </select>
                            </div>
                        </div>                                              
                        <input type="submit" class="btn btn-info" value="Tiếp Tục" >
                        <a href="${pageContext.request.contextPath}/homeuser"><div class="btn btn-warning">Cancel</div></a>
                            <p style="color: red;"><%= request.getAttribute("mess") != null ? request.getAttribute("mess") : " " %></p>                                        
                     </div>
                      
                    </form>
                    <script>
                          $('.row .col-md-10').on('input','.form-control',function(){
                              var toltalsum1 = 1;  
                              var toltalsum = 1;
                              $('.row .col-md-10 .form-control-lg').each(function(){
                                  var inputval = $(this).val();
                                  if($.isNumeric(inputval));
                                  toltalsum1 *= parseInt(inputval) ;
                              });
                              $('.row .col-md-10 .form-control-g').each(function(){
                                   var inputval = $(this).val();
                                  if($.isNumeric(inputval));
                                  toltalsum *= parseInt(inputval) ;                               
                              });
                              $('#result').val(toltalsum1);
                              $('#result1').val(Math.round((toltalsum/60)+toltalsum1));                         
                          }); 
                          //time shit
                          $('.row .col-md-5').on('input','.form-control',function(){
                              var giothue= 1;  
                              var giotra= 1; 
                              var phutthue=1;
                              var phuttra =1;
                              
                              $('.row .col-md-5 .form-control-c').each(function(){
                                  var inputval = $(this).val();
                                  if($.isNumeric(inputval));
                                  giothue= parseInt(inputval) ;
                              });
                              $('.row .col-md-5 .form-control-v').each(function(){
                                   var inputval = $(this).val();
                                  if($.isNumeric(inputval));
                                  giotra= parseInt(inputval) ;                               
                              });
                              
                              
                              $('.row .col-md-5 .form-control-e').each(function(){
                                  var inputval = $(this).val();
                                  if($.isNumeric(inputval));
                                  phutthue = parseInt(inputval) ;
                              });
                              $('.row .col-md-5 .form-control-k').each(function(){
                                   var inputval = $(this).val();
                                  if($.isNumeric(inputval));
                                  phuttra = parseInt(inputval) ;                               
                              });
                              
                              
                              
                              $('#tongphut').val(phuttra - phutthue); 
                              $('#tonggio').val(giotra - giothue);                                          
                          });                                              
                        </script>
                        <script src="js/filecheck.js"></script>
                </div>  
            
            </div>
              
        </div>
        
    </body>
</html>
