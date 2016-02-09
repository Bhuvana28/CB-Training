package classes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import models.UsersDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.AddressDao;

/**
 *
 * @author cb-bhuvana
 */
public class editDetails extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>API Request Invalid</h2>");
            out.println("</body>");
            out.println("</html>");
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
        PrintWriter out = response.getWriter();   
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
   
        //Setting the user attributes to update.
        Address address = new Address(request.getParameter("addressLine"),request.getParameter("city"),request.getParameter("state"),request.getParameter("zip"),request.getParameter("country"));
        User userUpdate = new User(request.getParameter("firstname"),request.getParameter("lastname"),user.getEmail(),address);
        UsersDao userDao = new UsersDao();
        AddressDao addressDao = new AddressDao();
        try{
            userDao.updateUser(userUpdate);
            if(user.getAddress()!=null)
                addressDao.updateAddress(address,user.getEmail());
            else
                addressDao.insertAddress(address,user.getEmail());
            
            session.setAttribute("user", userUpdate);
            response.sendRedirect("details.jsp");
        }catch (SQLException ex) {
            Logger.getLogger(editDetails.class.getName()).log(Level.SEVERE, null, ex);
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
