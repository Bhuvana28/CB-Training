/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import classes.Address;
import classes.User;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.AddressesDao;
import models.UsersDao;

/**
 *
 * @author cb-bhuvana
 */
public class EditDetails extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession httpSession = request.getSession();
        Integer userId = (Integer) httpSession.getAttribute("userId");
        try {    
            UsersDao usersDao = new UsersDao();
            User user  = usersDao.userDetails(userId);
            if(user!=null){
               httpSession.setAttribute("user", user);
               response.sendRedirect("editDetails.jsp");
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
        HttpSession httpSession = request.getSession();
        Integer userId = (Integer) httpSession.getAttribute("userId");
        
        UsersDao usersDao = new UsersDao();
        AddressesDao addressesDao = new AddressesDao();
       
        //Update details from edit details form
        Address addressUpdate = new Address(request.getParameter("addressLine"),request.getParameter("city"),request.getParameter("state"),request.getParameter("zip"),request.getParameter("country"));
        User userUpdate = new User(request.getParameter("firstname"),request.getParameter("lastname"),request.getParameter("email"),Integer.parseInt(request.getParameter("addressId")),addressUpdate);
        
        try {
            if(addressUpdate.toString().trim().isEmpty()){
                if(userUpdate.getAddressId()!=null && userUpdate.getAddressId()!=0){
                    addressesDao.deleteAddress(userUpdate.getAddressId());
                }
                userUpdate.setAddressId(null);
            }else if(userUpdate.getAddressId()==null || userUpdate.getAddressId()==0){
                Integer addressId = addressesDao.insertAddress(addressUpdate);
                userUpdate.setAddressId(addressId);
                userUpdate.setAddress(addressUpdate);
            }else{
                addressesDao.updateAddress(userUpdate.getAddressId(), addressUpdate);
                userUpdate.setAddress(addressUpdate);
            }
            
            usersDao.updateUser(userId, userUpdate);
            httpSession.setAttribute("user", userUpdate);
            response.sendRedirect("Details");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(EditDetails.class.getName()).log(Level.SEVERE, null, ex);
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
