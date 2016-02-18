<%-- 
    Document   : addContact
    Created on : Feb 18, 2016, 1:26:50 PM
    Author     : cb-bhuvana
--%>

<%@page import="classes.Country"%>
<%@page import="classes.PhoneType"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/addContactStyles.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <%@include file="headerBar.jspf"%>
        <div class="addContactForm" style="margin: 2% auto 0;width:30%;text-align: center;" >
            <h1>Add Contact</h1>
            <form action="AddContact" method="post">
                <div class="lineBlock">
                    <span class="title">Name</span>
                    <span><input type="text" name="name" required ></span> 
                </div>
                <div class="lineBlock">
                    <span class="title">Address</span>
                    <span><input type="text" name="addressLine" placeholder="Address"  ></span>
                </div>        
                <div class="addressDetails">
                    <span class="title"></span>
                    <span><input type="text" name= "city" placeholder="City"  >
                          <input type="text" name= "state" placeholder="State" >
                    </span>
                </div>
                <div class="addressDetails">
                    <span class="title"></span>
                    <span><input type="text" name= "zip" placeholder="Zip" pattern="[0-9]{6}" >
                        <select name="country">
                            <option value="">Country</option>
                            <%for(Country country : Country.values()){ %>
                                <option value ="<%=country.getName()%>"><%=country.getName()%></option>                                
                            <%}%>
                        </select>
                    </span>
                </div>
                <%for(PhoneType type : PhoneType.values()){ %>       
                <div class="lineBlock">
                    <span class="title">Phone(<%=type.getPhoneEnumType()%>)</span>
                    <span><input type="text" name="<%=type.getPhoneEnumType()%>"></span>
                </div>        
                <%}%>
                <input type="submit" value="Add"> <a href="Details">Discard</a>
            </form>
        </div>
    </body>
</html>
