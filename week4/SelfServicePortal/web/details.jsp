<%-- 
    Document   : details
    Created on : Feb 3, 2016, 3:24:05 PM
    Author     : cb-bhuvana
--%>

<%@page session="false" %>
<%@page import= "javax.servlet.http.HttpSession"%>
<%@page import="classes.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>welcome</title>
        <link href="css/stylesDetails.css" rel="stylesheet" type="text/css"> 
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
            Self Service Portal<span>Hi <%=user.getFirstname()%><a href="Logout">Logout</a></span>
        </div>
        <div id ="detailsForm">
            <h1>Welcome to Self Service Portal</h1> 
            <div class="detailsList">
                <span class="title">NAME</span>
                <span class="value"><%=user.getFirstname()%></span>
            </div>
            <div class="detailsList">
                <span class="title">EMAIL</span>
                <span class="value"><%=user.getEmail() %></span>
            </div>
            <div class ="detailsList">
                <span class="title">ADDRESS</span>
                <span class="value">
                    <% if(user.getAddress() != null){ %>
                        <%=user.getAddress()%>
                    <% }else { %>
                        --NA--
                        <% } %>
               </span>
            </div>
            <a href="editDetails.jsp">Edit Details</a> 
        </div>
        
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
