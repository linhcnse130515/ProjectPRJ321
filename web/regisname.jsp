<%-- 
    Document   : regisname
    Created on : May 27, 2020, 10:26:11 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Name Page</title>
    </head>
    <body>
        <form action="MainController" method="POST">
            Full Name :<input type="text" name="txtFullName"></br>
            <input type="hidden" name="codeMail" value="${requestScope.codeMail}">
            <input type="hidden" name="gmail" value="${requestScope.gmail}">
            <input type="submit" name="btnAction" value="RegisName">
            <input type="reset" name="reset">
        </form>
    </body>
</html>
