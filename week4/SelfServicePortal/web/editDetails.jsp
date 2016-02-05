<%-- 
    Document   : editDetails
    Created on : Feb 3, 2016, 4:22:21 PM
    Author     : cb-bhuvana
--%>
<%@page session="false" %>
<%@page import="classes.User"%>
<%@page import= "javax.servlet.http.HttpSession"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>editDetails</title>
    </head>
    <body>
        <%  
            response.setHeader("Cache-Control","no-cache,no-store");
            response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
            response.setHeader("Expires", "0"); 
            HttpSession SSPSession = request.getSession(false);
            if(SSPSession!=null){
            User user = (User) SSPSession.getAttribute("user");
        %>
        <div id="headerDiv" style="display: block;">
            <span>Self Service Portal</span><span>Hi <%=user.getFirstname()%></span><a href="Logout">Logout"</a>
        </div>
        <h2>Edit Details</h2>
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
        <%}else{
                try{
                    request.setAttribute("sessionError", "Session has ended.  Please login.");
                    response.sendRedirect("register.jsp");
                }catch(Exception e){
                    System.out.println("details page redirection problem");
            }
        }%>
    </body>
</html>
