<%-- 
    Document   : index
    Created on : May 25, 2020, 11:55:00 AM
    Author     : nguye
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <header>
            
        </header>
        <nav>
            <c:if test="${empty sessionScope.USER}">
                <a href="login.jsp" a>LOGIN</a>
            </c:if>
            <c:if test="${not empty sessionScope.USER}">               
                <a href="${user}">${sessionScope.USER.fullName}</a>                
                <c:url var="logout" value="MainController">
                    <c:param name="btnAction" value="Logout"></c:param>
                </c:url>
                <a href="${logout}">Logout</a>
            </c:if>
        </nav>
    </body>
</html>
