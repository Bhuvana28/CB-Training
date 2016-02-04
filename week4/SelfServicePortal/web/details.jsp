<%-- 
    Document   : details
    Created on : Feb 3, 2016, 3:24:05 PM
    Author     : cb-bhuvana
--%>

<%@page import="classes.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>welcome</title>
    </head>
    <body>
        <div>
            
        </div>
        <h2>Welcome to Self Service Portal</h2> 
        <%User user = (User) session.getAttribute("user"); %>
        <strong>NAME</strong>: <%=user.getFirstname()%><br>
        <strong>EMAIL</strong>: <%=user.getEmail() %><br>
        <% if(user.getAddress() != null){ %>
            <strong>ADDRESS</strong>: <%=user.getAddress()%>
        <% }else { %>
            <strong>ADDRESS</strong>: --NA--
        <% } %>
        <br>
        <a href="editDetails.jsp">Edit Details</a> 
        <form action="Logout" method="get">
            <input type="submit" value="Logout"> 
        </form>
    </body>
</html>
