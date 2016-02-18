/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import classes.Address;
import classes.Contact;
import classes.PhoneNumber;
import classes.PhoneType;
import classes.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.AddressesDao;
import models.ContactsDao;
import models.PhoneNumbersDao;
import models.UsersDao;

/**
 *
 * @author cb-bhuvana
 */
public class AddContact extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession httpSession = request.getSession();
        Integer userId = (Integer) httpSession.getAttribute("userId");
        UsersDao usersDao = new UsersDao();
        try {    
            User user=usersDao.userDetails(userId);
            if(user!=null){
               httpSession.setAttribute("user", user);
               response.sendRedirect("addContact.jsp");
            }else{
                response.sendRedirect("Logout");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Details.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/addContact.jsp");
        HttpSession httpSession = request.getSession();
        Integer userId = (Integer) httpSession.getAttribute("userId");
        
        AddressesDao addressesDao = new AddressesDao();
        ContactsDao contactsDao = new ContactsDao();
        PhoneNumbersDao phoneNumbersDao = new PhoneNumbersDao();
        
        Address address = new Address(request.getParameter("addressLine"),request.getParameter("city"),request.getParameter("state"),request.getParameter("zip"),request.getParameter("country"));
        
        if(request.getParameter("Work").isEmpty() && request.getParameter("Mobile").isEmpty() && request.getParameter("Home").isEmpty()){
            out.println("<h1 style='color:red;text-align:center;font-weight: 200;font-size: 20px;'>Enter atleast one phone number.</h1>");
            rd.include(request, response);
        }else{
            try{
                Integer addressId = address.toString().trim().isEmpty()? null : addressesDao.insertAddress(address);
                ArrayList<PhoneNumber> phoneNumbers = new ArrayList<>();
                for(PhoneType type : PhoneType.values()){
                   if(!request.getParameter(type.getPhoneEnumType()).isEmpty()){
                       phoneNumbers.add(new PhoneNumber(type.getPhoneEnumType(),request.getParameter(type.getPhoneEnumType())));
                   }
                }
                if(addressId== null){
                    address = null;
                }
                
                Contact contact = new Contact(null,request.getParameter("name"),addressId,address,phoneNumbers);
                
                Integer contactId = contactsDao.insertContact(contact, userId);
                if(contactId != null){
                    phoneNumbersDao.insertContactPhoneNumber(contactId, phoneNumbers);
                    response.sendRedirect("Details");
                }else{
                    out.println("<h1 style='color:red;text-align:center;font-weight: 200;font-size: 20px;margin-bottom:0px;'>Couldn't add a contact. Please try after some time.</h1>");
                    rd = getServletContext().getRequestDispatcher("/Details");
                    rd.include(request, response);
                }
            } catch (SQLException|ClassNotFoundException ex) {
                System.out.println(ex);
            } 
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
