<%-- 
    Document   : login
    Created on : May 25, 2020, 3:38:24 PM
    Author     : nguye
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <link rel="stylesheet" href="CSS/Header.css" />
    <link rel="stylesheet" href="CSS/Footer.css" />
    <body>
        <header>
            <img src="https://300b5338.vws.vegacdn.vn/image/img.news/0/0/0/275.jpg?v=1&w=628&h=365&nocache=1" />
        </header>
        <nav>
            <div class="navi">
                <a href="index.jsp" a>HOME</a>
                <a href="books.jsp">BOOKS</a>
                <a href="contact.jsp" a>CONTACT US</a>
                <c:if test="${empty sessionScope.USER}">
                    <a href="login.jsp" a>LOGIN</a>
                </c:if>
                <c:if test="${not empty sessionScope.USER}">
                    <c:url var="user" value="MainController">
                        <c:if test="${sessionScope.ROLE == 'Admin'}">
                            <c:param name="btnAction" value="Admin"></c:param>
                        </c:if>
                        <c:if test="${sessionScope.ROLE == 'User'}">
                            <c:param name="btnAction" value="User"></c:param>
                        </c:if>
                    </c:url>
                    <a href="${user}">${sessionScope.USER.fullName}</a>  
                    <c:if test="${sessionScope.ROLE == 'User'}">
                        <a href="cart.jsp">Cart</a>
                    </c:if>
                    <c:url var="logout" value="MainController">
                        <c:param name="btnAction" value="Logout"></c:param>
                    </c:url>
                    <a href="${logout}">Logout</a>
                </c:if> 
            </div>    
        </nav>
        <div class="login"> 
            <form action="MainController" method="POST">
                User ID :<input type="text" name="txtUserID"></br>
                Password :<input type="password" name="txtPassword"></br>
                <input type="submit" name="btnAction" value="Login">
                <input type="reset" name="reset">
            </form>
            <a href="register.jsp">Register</a>
            <a href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8084/Project/LoginGmailController&response_type=code
               &client_id=976519729204-b8sdfs891eeu4c18beajv7912qffd99p.apps.googleusercontent.com&approval_prompt=force">Login With Google</a></br>
            ${requestScope.MESSAGE}
        </div>  
        <footer>
            <div class="footerLeft">
                <ul>
                    <li> Address 1: 183 B 3/2 Street,11 Ward,10 District,HCM City </li>
                    <li> Phone :0908.882.588 </li>
                    <li> Guide to buy online </li>
                    <li> Guide to buy installment </li>
                </ul>
            </div>
            <div class="footerRight">
                <ul>
                    <li> Address 2: 300 Quang Trung ward,Go Vap District,HCM City </li>
                    <li> Phone :028665.004.500</li>
                    <li> Warranty Policy </li>
                    <li> Setup software for free </li>
                </ul>
            </div>

        </footer>
    </body>
</html>
