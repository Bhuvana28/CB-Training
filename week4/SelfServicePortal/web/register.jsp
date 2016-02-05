<%-- 
    Document   : register.jsp
    Created on : Feb 5, 2016, 12:35:30 PM
    Author     : cb-bhuvana
--%>

<%@page session="false" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>register</title>
        <link href="css/stylesRegister.css" rel="stylesheet" type="text/css"> 
    </head>
    <body>
        <div id="registerForm">
            <h6>Register to</h6>
            <h1>Self Service Portal</h1>
            <form action="Register" method="post">
                <div class ="inputBlock">
                    <input type="text" name="firstname" placeholder="First Name">
                    <input type="text" name="lastname" placeholder = "Last Name">
                </div>
                <div class = "inputBlock">
                    <input type="text" name="email" placeholder = "Email">
                    <input type="text" name="confirmemail" placeholder="Confirm email">
                </div>
                <div class="inputBlock">
                    <input type="password" name="password" placeholder = "Password">
                    <input type="password" name="confirmpassword" placeholder="Confirm Password">
                </div>
               <div id="registerSubmit">
                <input type="submit" value="Create an account"><br>
                <a href="login.html">Have an account already?</a>
               </div>
            </form>
        </div>
    </body>
</html>
