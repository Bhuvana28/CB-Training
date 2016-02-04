package classes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.DBConnectionManager;
import dao.UsersDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author cb-bhuvana
 */
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       System.out.println("in post login");
       response.setContentType("text/html;charset=UTF-8");
       RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
       PrintWriter out = response.getWriter();
       
       String email = request.getParameter("email");
       String password = request.getParameter("password");
       String errorMsg = null;
        if(email == null || email.equals("")){
            errorMsg ="User Email can't be null or empty";
        }
        if(password == null || password.equals("")){
            errorMsg = "Password can't be null or empty";
        }
         
        if(errorMsg != null){
           // out.println(errorMsg);
            rd.include(request, response);
        }else{
            try{
                User user = UsersDao.checkUser(email, password);
                if(user!=null){
                    HttpSession session = request.getSession();
                    session.setAttribute("user",user); 
                    response.sendRedirect("details.jsp");
                }else{
                    errorMsg = "Incorrect email or password.";
                    //out.println(errorMsg);
                    rd.include(request, response);
                }
            }catch(SQLException ex){
                System.out.println("Connection close problem");
            }      
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
