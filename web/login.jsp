<%-- 
    Document   : login
    Created on : May 25, 2020, 3:38:24 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Welcome to </h1>
        <form action="MainController" method="POST">
            User ID :<input type="text" name="txtUserID"></br>
            Password :<input type="password" name="txtPassword"></br>
            <input type="submit" name="btnAction" value="Login">
            <input type="reset" name="reset">
        </form>
        <a href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8084/Project/LoginGmailController&response_type=code
    &client_id=976519729204-b8sdfs891eeu4c18beajv7912qffd99p.apps.googleusercontent.com&approval_prompt=force">Login With Google</a>
    </body>
</html>
