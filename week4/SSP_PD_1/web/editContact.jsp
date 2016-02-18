<%-- 
    Document   : editContact
    Created on : Feb 18, 2016, 3:14:26 PM
    Author     : cb-bhuvana
--%>

<%@page import="classes.Country"%>
<%@page import="classes.PhoneType"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Contact</title>
        <link href="css/addContactStyles.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <%@include file="headerBar.jspf"%>
        <%
            Contact contact = (Contact) httpSession.getAttribute("contact");
            Address contactAddress = contact.getContactAddress();
        %>
         <div class="addContactForm" style="margin: 2% auto 0;width: 30%;text-align: center;">
            <h1>Edit Contact</h1>
            <form action="EditContact" method="post">
                <div class="lineBlock">
                    <span class="title">Name</span>
                    <span><input type="text" name="name" value="<%=contact.getContactName()%>" required ></span> 
                </div>
                <div class="lineBlock">
                    <span class="title">Address</span>
                    <span><input type="text" name="addressLine" placeholder="Address" <% if(contactAddress!=null){%> value="<%= contactAddress.getAddressLine()%>" <%}%> ></span>
                </div>        
                <div class="addressDetails">
                    <span class="title"></span>
                    <span><input type="text" name= "city" <% if(contactAddress!=null) {%>value="<%=contactAddress.getCity()%>" <%}%> placeholder="City" >
                          <input type="text" name= "state"  <% if(contactAddress!=null) {%> value = "<%=contactAddress.getState()%>" <%}%> placeholder="State" >
                    </span>
                </div>
                <div class="addressDetails">
                    <span class="title"></span>
                    <span><input type="text" name= "zip"  <% if(contactAddress!=null) {%> value = "<%= contactAddress.getZip()%>" <%}%> placeholder="Zip" pattern="[0-9]{6}">
                        <select name="country">
                            <option value="">Country</option>
                            <%for(Country country : Country.values()){ %>
                                <option value ="<%=country.getName()%>" <% if(contactAddress!=null) {%> <%= country.getName().equals(contactAddress.getCountry())?"selected":"" %> <%}%> ><%=country.getName()%></option>                                
                            <%}%>
                        </select>
                    </span>
                </div>
                <%for(PhoneType type : PhoneType.values()){ %>       
                <div class="lineBlock">
                    <span class="title">Phone(<%=type.getPhoneEnumType()%>)</span>
                    <span><input type="text" name="<%=type.getPhoneEnumType()%>" value="<%=contact.getPhoneNumberofType(type.getPhoneEnumType())%>"></span>
                </div>        
                <%}%>
                <input type="hidden" name="addressId" value="<%=contact.getContactAddressId()==null?0:contact.getContactAddressId()%>" >
                <input type="hidden" name="contactId" value="<%=contact.getContactId()%>" >
                <input type="submit" value="Update"> <a href="Details">Discard</a>
            </form>
        </div>
    </body>
</html>
