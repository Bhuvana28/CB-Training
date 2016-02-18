<%-- 
    Document   : register
    Created on : Feb 18, 2016, 5:24:26 AM
    Author     : cb-bhuvana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <link href="css/registerStyles.css" rel="stylesheet" type="text/css"> 
    </head>
    <body>
        <div id="registerForm">
            <h6>Register to</h6>
            <h1>Self Service Portal</h1>
            <h3>All fields are mandatory</h3>
            <form action="Register" method="post">
                <div class="inputBlock">
                    <input type="text" name="firstname" placeholder="First Name" required>
                    <input type="text" name="lastname" placeholder = "Last Name" required>
                </div>
                <div class="inputBlock">
                    <input type="text" name="email" placeholder = "Email" required>
                    <input type="text" name="confirmemail" placeholder="Confirm email" required>
                </div>
                <div class="inputBlock">
                    <input type="password" name="password" placeholder = "Password" required>
                    <input type="password" name="confirmpassword" placeholder="Confirm Password" required>
                </div>
                <div id="registerSubmit">
                    <input type="submit" value="Create an account"><br>
                    <a href="login.jsp">Have an account already?</a>
                </div>
            </form>
        </div>
    </body>
</html>
