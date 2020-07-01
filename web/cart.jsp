<%-- 
    Document   : cart
    Created on : Mar 22, 2020, 4:54:51 PM
    Author     : nguye
--%>
<%@page import="linh_dto.BookDTO"%>
<%@page import="linh_dto.CartDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart Information</title>
    </head>
    <link rel="stylesheet" href="CSS/Header.css" />
    <link rel="stylesheet" href="CSS/Article.css" />
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
        <div class="cart">
            <h1>Your Shopping Cart:</h1>
            <p>${sessionScope.CART.borDay}  to  ${sessionScope.CART.payDay}</p>
            <%
                CartDTO cart = (CartDTO) session.getAttribute("CART");
                if (cart != null) {
            %>
            <center>
                ${requestScope.MESSAGEORDER}  
                <table border="1">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>Name</th>
                            <th>Author</th>
                            <th>Quantity</th>
                            <th>Remove</th>
                            <th>Save</th>
                        </tr>
                    </thead>
                    <%
                        int count = 0;
                        for (BookDTO dto : cart.getCart().values()) {
                    %>
                    <form action="MainController">
                        <tbody>  
                            <tr>
                                <td>
                                    <%= ++count%>
                                </td>
                                <td>
                                    <%= dto.getName()%>
                                    <input type="hidden" name="id" value="<%= dto.getCode()%>"/>
                                    <input type="hidden" name="name" value="<%= dto.getName()%>"/>
                                </td>
                                <td>
                                    <%= dto.getAuthor()%>
                                    <input type="hidden" name="author" value="<%= dto.getAuthor()%>"/>
                                </td>
                                <td>
                                    <input type="number" name="quantity" value="<%= dto.getQuantity()%>"/>                          
                                </td>
                                <td>
                                    <input type="submit" name="btnAction" value="Remove Book"/>
                                </td>
                                <td>
                                    <input type="submit" name="btnAction" value="Save"/>
                                </td>
                            </tr>
                        </tbody>  
                    </form>
                    <%
                        }
                    %>

                </table>   
                <c:url var="order" value="MainController">
                    <c:param name="btnAction" value="Order"></c:param>
                </c:url>
                <a href="${order}">Order</a>
                <c:url var="deleteCart" value="MainController">
                    <c:param name="btnAction" value="DeleteCart"></c:param>
                </c:url>
                <a href="${deleteCart}">Delete</a>
            </center>
            <%
                }
            %>   
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
