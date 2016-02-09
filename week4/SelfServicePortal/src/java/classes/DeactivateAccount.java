/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.AddressDao;
import models.UsersDao;

/**
 *
 * @author cb-bhuvana
 */
public class DeactivateAccount extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UsersDao userDao = new UsersDao();
        AddressDao addressDao = new AddressDao();
        HttpSession session = request.getSession();
        String email = (String)session.getAttribute("email");
        try{
            addressDao.deleteAddress(email);
            userDao.deleteUser(email);
            if(session != null){
                System.out.println("session not null");
                session.invalidate();
            }
            response.sendRedirect("register.jsp");
        }catch(SQLException ex){
            System.out.println("Connection close problem");
        }
    
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
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
