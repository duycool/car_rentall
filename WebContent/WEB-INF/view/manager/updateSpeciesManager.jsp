<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Species</title>
</head>
<body>
<jsp:include page="/WEB-INF/view/templ/headerManage.jsp"></jsp:include><br>
<form action="updateSpeciesManager" method="post" style="margin-top: 100px">
        <table border="0" width="35%" align="center">
            <caption><h2>CẬP NHẬT LOẠI</h2></caption>
             <tr>
                <td><input type="hidden" name="idSpecies" value="${speciesCar.speciesId}"/></td>
            </tr>  
                 <tr>
                <td width="50%">Name Manufacturer: </td>
                <td><input type="text" name="nameSpecies" value="${speciesCar.nameSpecies}"/></td>
            </tr>                
            <tr>
                <td colspan="2" align="center"><input type="submit" value="submit"/></td>
            </tr>
        </table>
         
    </form>
</body>
</html>