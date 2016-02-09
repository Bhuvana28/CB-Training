<%-- 
    Document   : editDetails
    Created on : Feb 3, 2016, 4:22:21 PM
    Author     : cb-bhuvana
--%>
<%@page import="classes.Country"%>
<%@page session="false" %>
<%@page import="classes.User"%>
<%@page import="classes.Address"%>
<%@page import= "javax.servlet.http.HttpSession"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>editDetails</title>
        <link href="css/stylesEditDetails.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <%@include file="header.jspf"%>
        <div class="editDetailsform">
            <h1>Edit Details</h1>
            <form action="editDetails" method="post">
                <div class="nameBlock">
                    <span class="title">Name</span>
                    <span><input type="text" name="firstname" value="<%=user.getFirstname()%>">
                    <input type="text" name="lastname" value = "<%=user.getLastname()%>"></span>
                </div>
                <div class="emailBlock">
                    <span class="title">Email</span>
                    <span><input type="text" name="email" value = "<%=user.getEmail()%>" readonly></span> 
                </div>
                <div class="addressBlock">
                    <span class="title">Address</span>
                    <% if(address!=null){%>
                        <span><input type="text" name="addressLine"  value="<%=address.getAddressLine()%>" placeholder="Address" ></span>
                    <% }else{ %>    
                        <span><input type="text" name="addressLine"  placeholder="Address" ></span>
                    <%}%>
                </div>        
                <div class="addressDetails">
                    <span class="title"></span>
                    <span>
                        <% if(address!=null) {%>
                            <input type="text" name= "city" value="<%=address.getCity()%>" placeholder="City">
                            <input type="text" name= "state" value = "<%=address.getState()%>" placeholder="State">
                        <% }else{ %>
                            <input type="text" name= "city" placeholder="City">
                            <input type="text" name= "state" placeholder="State">
                        <%}%>
                    </span>
                </div>
                <div class="addressDetails">
                    <span class="title"></span>
                    <span>
                        <% if(address!=null) {%>
                        <input type="text" name= "zip" value = "<%= address.getZip()%>" placeholder="Zip" pattern="[0-9]{6}">
                          <select name="country">
                            <option value="">Country</option>
                            <% if(address.getCountry().equals(Country.AFGHANISTAN)){ %>
                                <option value="<%=Country.AFGHANISTAN%>" selected>Afghanistan</option>
                            <% }else{ %>    
                                <option value="<%=Country.AFGHANISTAN%>">Afghanistan</option>
                            <%}%>
                            
                            <% if(address.getCountry().equals(Country.ANTARCTICA)){ %>
                                <option value="<%=Country.ANTARCTICA%>" selected>Antarctica</option>
                            <% }else{ %>        
                                <option value="<%=Country.ANTARCTICA%>">Antarctica</option>
                            <%}%>    
                            
                            <% if(address.getCountry().equals(Country.AUSTRALIA)){ %>
                                <option value="<%=Country.AUSTRALIA%>" selected>Australia</option>
                            <% }else{ %>        
                                <option value="<%=Country.AUSTRALIA%>">Australia</option>
                            <%}%>
                            
                            <% if(address.getCountry().equals(Country.BANGLADESH)){ %>
                                <option value="<%=Country.BANGLADESH%>" selected>Bangladesh</option>
                            <% }else{ %>        
                                <option value="<%=Country.BANGLADESH%>">Bangladesh</option>
                            <%}%>
                            
                            <% if(address.getCountry().equals(Country.BARBADOS)){ %>
                                <option value="<%=Country.BARBADOS%>" selected>Barbados</option>
                            <% }else{ %>        
                                <option value="<%=Country.BARBADOS%>">Barbados</option>
                            <%}%>
                            
                            <% if(address.getCountry().equals(Country.BRAZIL)){ %>
                                <option value="<%=Country.BRAZIL%>" selected>Brazil</option>
                            <% }else{ %>        
                                <option value="<%=Country.BRAZIL%>">Brazil</option>
                            <%}%>
                            
                            <% if(address.getCountry().equals(Country.CANADA)){ %>
                                <option value="<%=Country.CANADA%>" selected>Canada</option>
                            <% }else{ %>        
                                <option value="<%=Country.CANADA%>">Canada</option>
                            <%}%>
                            
                            <% if(address.getCountry().equals(Country.CHINA)){ %>
                                <option value="<%=Country.CHINA%>" selected>China</option>
                            <% }else{ %>        
                                <option value="<%=Country.CHINA%>">China</option>
                            <%}%>
                            
                            <% if(address.getCountry().equals(Country.DENMARK)){ %>
                                <option value="<%=Country.DENMARK%>" selected>Denmark</option>
                            <% }else{ %>        
                                <option value="<%=Country.DENMARK%>">Denmark</option>
                            <%}%>
                            <% if(address.getCountry().equals(Country.ICELAND)){ %>
                                <option value="<%=Country.ICELAND%>" selected>Iceland</option>
                            <% }else{ %>        
                                <option value="<%=Country.ICELAND%>">Iceland</option>
                            <%}%>
                            
                            <% if(address.getCountry().equals(Country.INDIA)){ %>
                                <option value="<%=Country.INDIA%>" selected>India</option>
                            <% }else{ %>        
                                <option value="<%=Country.INDIA%>">India</option>
                            <%}%>
                            
                            <% if(address.getCountry().equals(Country.MEXICO)){ %>
                            <option value="<%=Country.MEXICO%>" selected>Mexico</option
                            <% }else{ %>        
                                <option value="<%=Country.MEXICO%>">Mexico</option>
                            <%}%>
                            <% if(address.getCountry().equals(Country.ZIMBABWE)){ %>
                                <option value="<%=Country.ZIMBABWE%>" selected>Zimbabwe</option>
                            <% }else{ %>        
                                <option value="<%=Country.ZIMBABWE%>">Zimbabwe</option>
                            <%}%>
                        </select>
                        
                        <%}else{%>
                        <input type="text" name= "zip" placeholder="Zip" pattern="[0-9]{6}">
                          <select name="country">
                            <option value="">Country</option>
                                <option value="<%=Country.AFGHANISTAN%>">Afghanistan</option>
                                <option value="<%=Country.ANTARCTICA%>">Antarctica</option>
                                <option value="<%=Country.AUSTRALIA%>">Australia</option>
                                <option value="<%=Country.BANGLADESH%>">Bangladesh</option>
                                <option value="<%=Country.BARBADOS%>">Barbados</option>
                                <option value="<%=Country.BRAZIL%>">Brazil</option>
                                <option value="<%=Country.CANADA%>">Canada</option>
                                <option value="<%=Country.CHINA%>">China</option>
                                <option value="<%=Country.DENMARK%>">Denmark</option>
                                <option value="<%=Country.ICELAND%>">Iceland</option>
                                <option value="<%=Country.INDIA%>">India</option>
                                <option value="<%=Country.MEXICO%>">Mexico</option>
                                <option value="<%=Country.ZIMBABWE%>">Zimbabwe</option>
                            </select>
                        <%}%>
                        </span>
                </div>
                <input type="submit" value="Save details"> <a href="details.jsp">Discard</a>
            </form>
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
