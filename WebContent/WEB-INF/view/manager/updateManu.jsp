<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Manufacturer</title>
</head>
<body>
<jsp:include page="/WEB-INF/view/templ/headerManage.jsp"></jsp:include><br>
<form action="updateManufactManager" method="post" style="margin-top: 100px">
        <table border="0" width="35%" align="center">
            <caption><h2>Update Manufacturer</h2></caption>
             <tr>
                <td><input type="hidden" name="idManufact" value="${manufact.manuFacID}"/></td>
            </tr>  
                 <tr>
                <td width="50%">Name Manufacturer: </td>
                <td><input type="text" name="nameManufact" value="${manufact.nameManufac}"/></td>
            </tr>                
            <tr>
                <td colspan="2" align="center"><input type="submit" value="submit"/></td>
            </tr>
        </table>
         
    </form>
</body>
</html>