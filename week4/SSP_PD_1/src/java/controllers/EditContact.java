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
public class EditContact extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession httpSession = request.getSession();
        Integer userId = (Integer) httpSession.getAttribute("userId");
        UsersDao usersDao = new UsersDao();
        ContactsDao contactsDao = new ContactsDao();
        try {    
            User user=usersDao.userDetails(userId);
            if(user!=null){
               Contact contact = contactsDao.getContact(Integer.parseInt(request.getParameter("contactId")));
               if(contact!=null){
                   httpSession.setAttribute("contact", contact);
                   response.sendRedirect("editContact.jsp");
               }else{
                   response.sendRedirect("Details");
               }
            }else{
                response.sendRedirect("Logout");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Details.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession httpSession = request.getSession();
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/editContact.jsp");
        Integer userId = (Integer) httpSession.getAttribute("userId");
        Integer contactId = Integer.parseInt(request.getParameter("contactId"));
        
        AddressesDao addressesDao = new AddressesDao();
        ContactsDao contactsDao = new ContactsDao();
        PhoneNumbersDao phoneNumbersDao = new PhoneNumbersDao();
        
        Address addressUpdate = new Address(request.getParameter("addressLine"),request.getParameter("city"),request.getParameter("state"),request.getParameter("zip"),request.getParameter("country"));
        ArrayList<PhoneNumber> phoneNumbers = new ArrayList<>();
        
        
        Contact contactUpdate = new Contact(contactId,request.getParameter("name"),Integer.parseInt(request.getParameter("addressId")),addressUpdate,phoneNumbers);
        if(request.getParameter("Work").isEmpty() && request.getParameter("Mobile").isEmpty() && request.getParameter("Home").isEmpty()){
            out.println("<h1 style='color:red;text-align:center;font-weight: 200;font-size: 20px;'>Enter atleast one phone number.</h1>");
            rd.include(request, response);
        }else{
        try{
            Contact contact = contactsDao.getContact(contactId);
            if(addressUpdate.toString().trim().isEmpty()){
                if(contactUpdate.getContactAddressId()!=null && contactUpdate.getContactAddressId()!=0){
                       addressesDao.deleteAddress(contactUpdate.getContactAddressId());
                }
            contactUpdate.setContactAddressId(null);
            }else if(contactUpdate.getContactAddressId()==null || contactUpdate.getContactAddressId()==0 ){
                Integer addressId = addressesDao.insertAddress(addressUpdate);
                contactUpdate.setContactAddressId(addressId);
                contactUpdate.setContactAddress(addressUpdate);
            }else{
                addressesDao.updateAddress(contactUpdate.getContactAddressId(), addressUpdate);
                contactUpdate.setContactAddress(addressUpdate);
            }
            
            //PhoneNumbers
            ArrayList<PhoneNumber> phoneNumbersInsert = new ArrayList<>();
            for(PhoneType type : PhoneType.values()){
                if(!request.getParameter(type.getPhoneEnumType()).isEmpty()){
                    if(contact.getPhoneNumberofType(type.getPhoneEnumType()).isEmpty()){
                        phoneNumbersInsert.add(new PhoneNumber(type.getPhoneEnumType(),request.getParameter(type.getPhoneEnumType())));
                    }else{
                        phoneNumbers.add(new PhoneNumber(type.getPhoneEnumType(),request.getParameter(type.getPhoneEnumType())));
                    }
                }else{
                    if(!contact.getPhoneNumberofType(type.getPhoneEnumType()).isEmpty()){
                        phoneNumbersDao.deletePhoneNumber(contactId, new PhoneNumber(type.getPhoneEnumType(),request.getParameter(type.getPhoneEnumType())));
                    }
                }
            }
            
            phoneNumbersDao.insertContactPhoneNumber(contactId, phoneNumbersInsert);
            phoneNumbersDao.updateContactPhoneNumber(contactId, phoneNumbers);
                
            contactsDao.updateContact(contactId,contactUpdate);
            
            response.sendRedirect("Details");
            
        } catch (SQLException |ClassNotFoundException ex) {
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
