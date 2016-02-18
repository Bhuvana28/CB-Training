<%-- 
    Document   : details
    Created on : Feb 18, 2016, 8:59:30 AM
    Author     : cb-bhuvana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Details</title>
        <link href="css/detailsStyles.css" rel="stylesheet" type="text/css"> 
        <link href="css/contactsStyles.css" rel="stylesheet" type="text/css"> 
    </head>
    <body>
        <%@include file="headerBar.jspf"%>
        <h1>Welcome to Self Service Portal</h1> 
        <div class ="detailsDiv">
            <div class ="detailsForm">
            <h2> Details </h2>
            <div class="detailsList">
                <span class="title">NAME</span>
                <span class="value"><%=user.getFirstname()%> <%=user.getLastname()%></span>
            </div>
            <div class="detailsList">
                <span class="title">EMAIL</span>
                <span class="value"><%=user.getEmail() %></span>
            </div>
            <div class ="detailsList">
                <span class="title">ADDRESS</span>
                <span class="value">
                    <% if(address != null && !(address.toString().trim().isEmpty())){ %>
                    <%=address.getAddressLine()%><br>
                    <%=address.getCity()%> <%=address.getState()%><br>
                    <%=address.getZip()%> <%=address.getCountry()%>
                    <% }else { %>
                        --NA--
                        <% } %>
               </span>
            </div>
               <form action="EditDetails" method="get">
                   <input type="submit" value="Update Contact">
               </form>
            </div>
            <%-- This phone directory menu div --%>  
            <div id ="phoneDirectory" class ="detailsForm">
                <h2> Phone Directory Menu </h2>
                <form action="NameMatch" method="get">
                    <input type ="text" name="name" placeholder="Match by name">
                    <input type="submit" value="Submit">
                </form>
                <form action="PartialMatch" method="get">
                    <input type ="text" name="partial" placeholder = "Match by partial">
                    <input type="submit" value="Submit">
                </form>
                <form action="PhoneMatch" method="get">
                    <input type ="text" name="phone" placeholder="Match by phone">
                    <input type="submit" value="Submit">
                </form>
                <a href="AddContact"><button>Add Contact</button></a>
            </div>
        </div>
        <%@include file="contacts.jspf"%>
    </body>
</html>
