<%-- 
    Document   : login.jsp
    Created on : Feb 17, 2016, 10:14:46 PM
    Author     : cb-bhuvana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login</title>
        <link href="css/loginStyles.css" rel="stylesheet" type="text/css"> 
    </head>
    <body>
        <div id="loginForm">
            <h1>Self Service Portal</h1>
            <h6>Login</h6>
            <form action="Login" method="post">
                <input type="text" name="email" placeholder="Email" required><br>
                <input type="password" name="password" placeholder = "Password" required><br>
                <div id='loginSubmit'>
                    <input type="submit" value="Login"> 
                    <a href="#">Don't remember your password?</a>
                </div>
            </form>
            <div id="gotoRegister">
                <a href="register.jsp">New around here?</a>
            </div>
        </div>
    </body>
</html>
