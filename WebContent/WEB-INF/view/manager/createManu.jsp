<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Manufacturer</title>
</head>
<body>
<jsp:include page="/WEB-INF/view/templ/headerManage.jsp"></jsp:include><br>
<form action="createManufactManager" method="post" style="margin-top: 100px">
        <table border="0" width="35%" align="center">
            <caption><h2>THÊM HÃNG</h2></caption>
                        <tr>
                <td width="50%">TÊN HÃNG: </td>
                <td><input type="text" name="name" size="50"/></td>
            </tr>                 
            <tr>
                <td colspan="2" align="center"><input type="submit" value="submit"/></td>
            </tr>
        </table>
         
    </form>
</body>
</html>