
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CONTACT Page</title>
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
            <div class="contact">
                <h1>
                    Welcome to Fibo Library</br> 
                </h1>
                <a>
                    Fibo Holiday Hotel is located in the west of Hanoi. Fibo Holiday Hotel is a great</br> 
                    destination and brings you the most enjoyable experience when you come to us. Come</br> 
                    to Fibo Holiday Hotel, you will be immersed in fresh nature, to participate in </br>
                    leisure activities, relax to take away the sorrows and chaos of life. Fibo Holiday </br>
                    Hotel with all kinds of amenities and modern bungalows combined traditional style, </br>
                    restaurant system, conference room,  ... </br>
                </a>
                <a>
                    </br>Fibo Holiday Hotel with fully furnished rooms and villas, interior space is </br>
                    decorated in luxurious style mixed with traditional Vietnamese and modern Western. </br>
                    We have well trained, professional and professional staff, dedicated service. </br>
                </a>
                <a>
                    </br>Fibo Holiday Hotel offers a full range of amenities, fast check-in procedures, </br>
                    free public wi-fi coverage throughout the resort. The highlight of Fibo Holiday Hotel </br>
                    is the restaurant that offers both Western and Oriental cuisine built and served on </br>
                    the top floor. You can enjoy a delicious dinner while watching the starry sky and sea </br>
                    at night. In addition, guests can enjoy other services such as spa, gym in the resort </br>
                    area. It's great that your well-being, self-care habits are maintained on a regular basis.</br>
                </a>
                <a>
                   </br>Fibo Holiday Hotel is confident to bring you the emotional excitement, the best </br>
                   experience, the best in your stay. Come to us, we guarantee that you will not regret. </br>
                </a>
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
