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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cb-bhuvana
 */
public class Register extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/register.jsp");
        PrintWriter out = response.getWriter();
        String errorMsg = null;
        if(request.getParameter("firstname") == null || request.getParameter("firstname").isEmpty()){
            errorMsg = "Enter valid firstname.";
        }
        if(request.getParameter("lastname") == null || request.getParameter("lastname").isEmpty()){
            errorMsg = "Enter valid lastname.";
        }
        if(!request.getParameter("email").equals(request.getParameter("confirmemail")) || (request.getParameter("email") == null || request.getParameter("email").isEmpty())){
            errorMsg  = "Enter valid email and cofirm email.";
        }
        if(!request.getParameter("password").equals(request.getParameter("confirmpassword")) || (request.getParameter("password") == null || request.getParameter("password").isEmpty())){
            errorMsg  = "Enter valid Password and confirm Password.";
        }
        if(errorMsg!=null){
            out.println(errorMsg);
            rd.include(request, response);
        }
        else{
            try{
                boolean state;
                UsersDao userDao = new UsersDao();
                state = userDao.insertUser(request.getParameter("firstname"),request.getParameter("lastname"),request.getParameter("email"),request.getParameter("password"));
                if(state){
                    out.println("Registration Succesful.Please continue to login.");
                    rd = getServletContext().getRequestDispatcher("/login.html");
                    rd.include(request,response);
                }else{
                    out.println("Couldn't register. Please try after some time.");
                    rd.include(request, response);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
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
