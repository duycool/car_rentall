<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create DeliveryTime</title>
</head>
<body>
<jsp:include page="/WEB-INF/view/templ/headeradmin.jsp"></jsp:include><br>
<form action="updateContractday" method="post" style="margin-top: 100px">
        <table border="0" width="35%" align="center">
            <caption><h2 style="text-align: center;">Ngày Giao Xe</h2></caption>
            <tr>
                <td width="50%">NgàyThuêCủaKháchHàng: </td>
                  <td><p>${contractday.dayhire}<br></p></td>
               
            </tr> 
            <tr>
              <td width="50%">ChọnNgàyGiao:<br> </td>
                <td><input type="date" name="date" size="50"/></td>   
			</tr>            
            <tr>
                <td colspan="2" align="center"><input type="submit" value="submit"/></td>
            </tr>
        </table>
         
    </form>
</body>
</html>