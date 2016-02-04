<%-- 
    Document   : editDetails
    Created on : Feb 3, 2016, 4:22:21 PM
    Author     : cb-bhuvana
--%>
<%@page import="classes.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>editDetails</title>
    </head>
    <body>
        <h2>Edit Details</h2>
        <%User user = (User) session.getAttribute("user"); %>
        <form action="editDetails" method="post">
            <input type="text" name="firstname" value="<%=user.getFirstname()%>">
            <input type="text" name="lastname" value = "<%=user.getLastname()%>"><br>
            <input type="text" name="email" value = "<%=user.getEmail()%>" readonly>
            <% if(user.getAddress() != null){ %>
            <input type="text" name="address"  value="<%=user.getAddress()%>" placeholder="Address" ><br>
            <% }else { %>
            <input type="text" name="address" placeholder="Address" ><br>
            <%}%>
            <input type="submit" value="Save Details"> <a href="details.jsp">discard</a>
        </form>
        
        <form action="Logout" method="get">
            <input type="submit" value="Logout"> 
        </form>
        
    </body>
</html>
