<%-- 
    Document   : editDetails
    Created on : Feb 18, 2016, 10:14:39 AM
    Author     : cb-bhuvana
--%>

<%@page import="classes.Country"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Details</title>
        <link href="css/editDetailsStyles.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <%@include file="headerBar.jspf"%>
        <div class="editDetailsform">
            <h1>Edit Details</h1>
            <form action="EditDetails" method="post">
                <div class="nameBlock">
                    <span class="title">Name</span>
                    <span><input type="text" name="firstname" value="<%=user.getFirstname()%>" placeholder="First name">
                    <input type="text" name="lastname" value = "<%=user.getLastname()%>"  placeholder="Last name"></span>
                </div>
                <div class="emailBlock">
                    <span class="title">Email</span>
                    <span><input type="text" name="email" value = "<%=user.getEmail()%>" readonly></span> 
                </div>
                <div class="addressBlock">
                    <span class="title">Address</span>
                    <span><input type="text" name="addressLine"  <% if(address!=null) {%> value="<%=address.getAddressLine()%>" <%}%> placeholder="Address" ></span>
                </div>        
                <div class="addressDetails">
                    <span class="title"></span>
                    <span><input type="text" name= "city" <% if(address!=null) {%>value="<%=address.getCity()%>" <%}%>placeholder="City">
                          <input type="text" name= "state"  <% if(address!=null) {%> value = "<%=address.getState()%>" <%}%> placeholder="State">
                    </span>
                </div>
                <div class="addressDetails">
                    <span class="title"></span>
                    <span><input type="text" name= "zip" <% if(address!=null) {%> value = "<%= address.getZip()%>" <%}%> placeholder="Zip" pattern="[0-9]{6}">
                        <select name="country">
                            <option value="">Country</option>
                            <%for(Country country : Country.values()){ %>
                                <option value ="<%=country.getName()%>" <% if(address!=null) {%> <%= country.getName().equals(address.getCountry())?"selected":"" %> <%}%>><%=country.getName()%></option>                                
                            <%}%>
                        </select>
                    </span>
                </div>
                <input type="hidden" name="addressId" value="<%=user.getAddressId()==null?0:user.getAddressId()%>">
                <input type="submit" value="Save details"> <a href="Details">Discard</a>
            </form>
        </div>
    </body>
</html>
