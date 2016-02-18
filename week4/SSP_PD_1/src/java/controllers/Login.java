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
import javax.servlet.http.HttpSession;
import models.UsersDao;

/**
 *
 * @author cb-bhuvana
 */
public class Login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Login</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>NOT SUPPORTED API</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
        HttpSession httpSession = request.getSession();
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        String errorMsg = null;
        if(email == null || email.equals("")){
            httpSession.setAttribute("msg", "Feilds are left blank");
            httpSession.setAttribute("emailErrorMsg","User Email can't be null or empty");
        }
        if(password == null || password.equals("")){
            httpSession.setAttribute("msg", "Feilds are left blank");
            httpSession.setAttribute("passwordErrorMsg","Password can't be null or empty");
        }
        if(httpSession.getAttribute("msg") != null){   
            rd.include(request, response);
        }else{
            Integer userId;
            try {
                userId = UsersDao.checkUser(email, password);
                if(userId!=null){
                    System.out.println("login successful");
                    httpSession.setAttribute("userId",userId);
                    response.sendRedirect("Details");
                }else{
                    errorMsg = "Incorrect email or password.";
                    rd.include(request, response);
                }
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
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
