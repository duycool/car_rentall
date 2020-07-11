<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CẬP NHẬT TRẠNG THÁI GIAO HÀNG</title>
</head>
<body>
<jsp:include page="/WEB-INF/view/templ/headerDelivery.jsp"></jsp:include><br>
<form action="deliveryContractday" method="post" style="margin-top: 100px">
        <table border="0" width="35%" align="center">
            <caption><h2>CẬP NHẬT TRẠNG THÁI GIAO HÀNG</h2></caption>
            	<tr>
            		<td><input type="hidden" name="idSpecies" value="${speContractid}"></td>
            	</tr>
               <tr>
             <td width="50%">ĐANG GIAO: </td>
                <td><input  type="radio" name="status" value="delivery"></td>
           	 </tr>    
           	 <tr>
                <td width="50%">ĐÃ GIAO  : </td>
                <td><input  type="radio" name="status" value="delivered"></td>
           	 </tr>   
           	 	 <tr>
             <td width="50%">ĐÃ TRẢ  : </td>
                <td><input  type="radio" name="status" value="AlreadyPaid"></td>
           	 </tr>             
            <tr>
                <td colspan="2" align="center"><input type="submit" value="submit"/></td>
            </tr>
        </table>
         
    </form>
</body>
</html>