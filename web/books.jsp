<%-- 
    Document   : books
    Created on : Jun 6, 2020, 1:44:27 PM
    Author     : nguye
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.time.LocalDate"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Books Page</title>
    </head>
    <link rel="stylesheet" href="CSS/Header.css" />
    <link rel="stylesheet" href="CSS/ArticleRooms.css" />
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
        <div class="rooms">
            <h1>Welcome :</h1> ${sessionScope.USER.fullName}
            <form action="MainController">
                Borrow Day<input type="date" min="<%= LocalDate.now()%>" name="BORDAY" value="${requestScope.BORDAY}"/>
                Pay Day<input type="date" min="<%= LocalDate.now()%>" name="PAYDAY" value="${requestScope.PAYDAY}"/>
                <input type="hidden" name="txtUserID" value="${sessionScope.USER.userID}"/>
                <input type="submit" name="btnAction" value="GetAll"/>
            </form>
            ${requestScope.MESSAGE} 
            ${requestScope.MESSAGEBOOK}
            <c:forEach var="list" items="${requestScope.SHOWALL}">
                <div class="productImg">
                    <form action="MainController">
                        <img src="${list.image}" />                     
                        <div class="product">                        
                            <h2> ${list.name} </h2>
                            ${list.author} </br>
                            Remain: ${list.quantity} </br> 
                            <c:if test="${sessionScope.ROLE == 'User'}">
                                Amount<input type="number" name="txtAmount"/>
                                <input type="hidden" name="BORDAY" value="${requestScope.BORDAY}"/>
                                <input type="hidden" name="PAYDAY" value="${requestScope.PAYDAY}"/>
                                <input type="hidden" name="BookString" value="${list.code}-${list.name}-${list.author}-${list.quantity}-${list.image}"/>
                                <input type="submit" name="btnAction" value="AddCart"/>
                            </c:if>
                        </div>
                    </form>
                </div>
            </c:forEach>                              
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
