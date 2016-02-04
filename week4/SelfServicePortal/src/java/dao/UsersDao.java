/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

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
    
    public static User checkUser(String email,String password) throws SQLException{
        User user = null;
        Connection conn = null;
        try{
            DBConnectionManager DBConManager = new DBConnectionManager();
            conn = DBConManager.getConnection();
            PreparedStatement searchQuery = conn.prepareStatement("select firstname,lastname,address,email,password from users where email=? and password = ?");
            searchQuery.setString(1,email);
            searchQuery.setString(2,password);
            ResultSet rs = searchQuery.executeQuery();
            if(rs.next()){
                user  = new User(rs.getString("firstname"),rs.getString("lastname"),rs.getString("email"),rs.getString("address"));
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
    
    public void setAddress(String address,String email) throws SQLException{
        Connection conn = null;
        try{
            DBConnectionManager DBConManager = new DBConnectionManager();
            conn = DBConManager.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement setAddressQuery = conn.prepareStatement("update users set address = ? where email = ?");
            setAddressQuery.setString(1, address);
            setAddressQuery.setString(2, email);
            setAddressQuery.executeUpdate();
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
    
    public void setFirstname(String firstname,String email) throws SQLException{
        Connection conn = null;
        try{
            DBConnectionManager DBConManager = new DBConnectionManager();
            conn = DBConManager.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement setAddressQuery = conn.prepareStatement("update users set firstname = ? where email = ?");
            setAddressQuery.setString(1, firstname);
            setAddressQuery.setString(2, email);
            setAddressQuery.executeUpdate();
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
    
    public void setLastname(String lastname,String email) throws SQLException{
        Connection conn = null;
        try{
            DBConnectionManager DBConManager = new DBConnectionManager();
            conn = DBConManager.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement setAddressQuery = conn.prepareStatement("update users set lastname = ? where email = ?");
            setAddressQuery.setString(1, lastname);
            setAddressQuery.setString(2, email);
            setAddressQuery.executeUpdate();
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
