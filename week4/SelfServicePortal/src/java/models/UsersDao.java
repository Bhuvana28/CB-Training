/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import classes.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cb-bhuvana
 */
public class UsersDao {
    
    public static String checkUser(String email,String password) throws SQLException{
        String emailValue = null;
        Connection conn = null;
        try{
            DBConnectionManager DBConManager = new DBConnectionManager();
            conn = DBConManager.getConnection();
            PreparedStatement searchQuery = conn.prepareStatement("select email from users where email=? and password = ?");
            searchQuery.setString(1,email);
            searchQuery.setString(2,password);
            ResultSet rs = searchQuery.executeQuery();
            if(rs.next()){
                emailValue = rs.getString("email");
            }
        } catch (ClassNotFoundException | SQLException ex) {
                   Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(conn != null){
                conn.close();
            }
        }
        return emailValue;
    }
    
    public User getUserDetails(String email) throws SQLException{
        User user = null;
        Connection conn = null;
        try{
            DBConnectionManager DBConManager = new DBConnectionManager();
            conn = DBConManager.getConnection();
            PreparedStatement searchQuery = conn.prepareStatement("select firstname,lastname from users where email=?");
            searchQuery.setString(1,email);
            ResultSet rs = searchQuery.executeQuery();
            if(rs.next()){
                user = new User(rs.getString("firstname"),rs.getString("lastname"),email);
            }
        } catch (ClassNotFoundException | SQLException ex) {
                   Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(conn != null){
                conn.close();
            }
        }
        return user;
    }
    
    public boolean insertUser(String firstname,String lastname,String email,String password) throws SQLException{
        boolean state = false;
        Connection conn = null;
        try{
            DBConnectionManager DBConManager = new DBConnectionManager();
            conn = DBConManager.getConnection();
             conn.setAutoCommit(false);
            PreparedStatement insertQuery = conn.prepareStatement("insert into users(email,firstname,lastname,password) values(?,?,?,?)");
            insertQuery.setString(1,email);
            insertQuery.setString(2,firstname);
            insertQuery.setString(3,lastname);
            insertQuery.setString(4,password);
            int rs = insertQuery.executeUpdate();
            if(rs>0){
               state = true;
            }
            conn.commit();
        } catch (ClassNotFoundException | SQLException ex) {
            if(conn!=null){
                   Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
                   conn.rollback();
            }
        }finally{
            if(conn != null){
                conn.close();
            }
        }
        return state;
    }
    
    public void updateUser(User user) throws SQLException{
        Connection conn = null;
        try{
            DBConnectionManager DBConManager = new DBConnectionManager();
            conn = DBConManager.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement updateUserQuery = conn.prepareStatement("update users set firstname=?,lastname = ? where email = ?");
            updateUserQuery.setString(1, user.getFirstname());
            updateUserQuery.setString(2, user.getLastname());
            updateUserQuery.setString(3, user.getEmail());
            updateUserQuery.executeUpdate();
            conn.commit();
        } catch (ClassNotFoundException | SQLException ex) {
            if(conn!=null){
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
                conn.rollback();
            }   
        }finally{
            if(conn!=null){
               conn.close();
            }
        }
    }
    
    public void deleteUser(String email) throws SQLException{
        Connection conn = null;
        try{
            DBConnectionManager DBConManager = new DBConnectionManager();
            conn = DBConManager.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement deleteUserQuery = conn.prepareStatement("delete from users where email = ?");
            deleteUserQuery.setString(1, email);
            deleteUserQuery.executeUpdate();
            conn.commit();
        } catch (ClassNotFoundException | SQLException ex) {
            if(conn!=null){
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
                conn.rollback();
            }   
        }finally{
            if(conn!=null){
               conn.close();
            }
        }
    }
}
