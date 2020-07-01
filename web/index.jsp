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
        <article>  
            <div class="articleUp">
                <h1>
                    WELCOME TO FIBO LIBRARY</br> 
                    ★★★★
                </h1>
                <a>
                    was established in 1956 (right after the school was founded). </br> 
                    Over the course of construction and development, the Library has made </br> 
                    many important contributions to the training of a large number of scientific </br> 
                    and technical staff, making a positive contribution to the cause of economic, </br> 
                    scientific and technical development. Art of the country.</br> </br> </br>  
                </a>
                <a>
                    Looking back on the past, in the early years of its establishment, with an initial amount of 5000 books, </br> 
                    poor facilities and 2 staff who have no librarian skills, the Library is a a division of the Office of Education.</br> 
                </a>
            </div>
            <div class="articleDown">
                <h2>OUR BEST</h2>
                <img src="https://salt.tikicdn.com/cache/w1200/ts/product/56/3f/4f/f4e6621e69775643d22604bccef281bf.jpg">
                <div class="articleDownRight">
                    <h4>LƯỢC SỬ LOÀI NGƯỜI</h4>
                    <a>Sapiens, take us on an amazing journey through the whole of human history, 
                        from its evolutionary roots to the era of capitalism and genetic engineering, 
                        to discover why we are in current living conditions.<br><br>

                        Sapiens focused on the important processes that shaped humanity and the world around it, 
                        such as the birth of agricultural production, the creation of money, the spread of religions, 
                        and the rise of national states. Unlike other books of the same type, Sapiens took an 
                        interdisciplinary approach, bridging gaps between history, biology, philosophy and economics 
                        in a way never before seen. Moreover, taking both a macro and a micro perspective, Sapiens not 
                        only addresses what happened and why, but also delves into how individuals in history have perceived it.<br><br>

                        Harari's big and profound question is: what do we really want? Is there any way to achieve 
                        happiness for us, or even if we know what it is? At its core, Sapiens argues that we do not 
                        know ourselves, let alone the needs of other living things. We have been deceived so often 
                        by our fictional fantasies. History is also a fiction, but a fiction that has been controlled 
                        by reality and argument: a form of myth - a useful fiction - that enables it to bring about 
                        the enlightenment of self-knowing. yourself.<br>
                    </a>
                </div>

            </div>            
        </article>      
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
