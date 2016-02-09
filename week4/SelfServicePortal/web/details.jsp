<%-- 
    Document   : details
    Created on : Feb 3, 2016, 3:24:05 PM
    Author     : cb-bhuvana
--%>

<%@page import="classes.Address"%>
<%@page session="false" %>
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
        
        <%@include file="header.jspf"%>
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
                    <% if(address != null){ %>
                    <%=address.getAddressLine()%><br>
                    <%=address.getCity()%>,<%=address.getState()%><br>
                    <%=address.getZip()%>,<%=address.getCountry()%>
                    <% }else { %>
                        --NA--
                        <% } %>
               </span>
            </div>
            <a href="editDetails.jsp"><button>Edit Details</button></a> 
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
