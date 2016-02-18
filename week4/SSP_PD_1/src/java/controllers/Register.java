/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

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
import models.UsersDao;

/**
 *
 * @author cb-bhuvana
 */
public class Register extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Register</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Invalid API CALL</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
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
            out.println("<h1 style='color:red;text-align:center;font-weight: 200;font-size: 20px;'>" + errorMsg + "</h1>");
            rd.include(request, response);
        }
        else{
            try {
                UsersDao usersDao = new UsersDao();
                boolean status = usersDao.insertUser(request.getParameter("firstname"),request.getParameter("lastname"),request.getParameter("email"),request.getParameter("password"));
                if(status){
                    out.println("<h1 style='color:green;text-align:center;font-weight: 200;font-size: 20px;margin-bottom:0px;'>Registration Succesful.Please continue to login.</h1>");
                    rd = getServletContext().getRequestDispatcher("/login.jsp");
                    rd.include(request,response);
                }else{
                    out.println("<h1 style='color:red;text-align:center;font-weight: 200;font-size: 20px;margin-bottom:0px;'>Couldn't register. Please try after some time.</h1>");
                    rd.include(request, response);
                }
            } catch (ClassNotFoundException | SQLException ex) {
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
