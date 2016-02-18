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

    public static Integer checkUser(String email, String password) throws SQLException, ClassNotFoundException {
        Integer userId = null;
        Connection conn = null;
        try{
            DBConnManager dbConManager = new DBConnManager();
            conn = dbConManager.getConnection();
            PreparedStatement searchQuery = conn.prepareStatement("select id from users where email = ? and password = ?");
            searchQuery.setString(1, email);
            searchQuery.setString(2,password);
            ResultSet rs = searchQuery.executeQuery();
            if(rs.next()){
                userId = rs.getInt("id");
            }
        }finally{
            if(conn!=null)
                conn.close();
        }
        return userId;
    }
    
    public User userDetails(Integer userId) throws ClassNotFoundException, SQLException{
        User user = null;
        Connection conn = null;
        try{
            DBConnManager dbConManager = new DBConnManager();
            conn = dbConManager.getConnection();
            PreparedStatement searchQuery = conn.prepareStatement("select u.firstname as firstname,"
                    + "u.lastname as lastname,u.email as email,u.addressId as addressId,a.address as address,"
                    + "a.city as city,a.state as state,a.zip as zip,a.country as country from users u "
                    + "left join addresses a on u.addressId = a.id where u.id =?");
            searchQuery.setInt(1, userId);
            ResultSet rs = searchQuery.executeQuery();
            if(rs.next()){
                user = FillDetail.fillUserDetails(rs);
            }
        }finally{
            if(conn!=null)
                conn.close();
        }
        return user;
    }

    public boolean insertUser(String firstname,String lastname,String email,String password) throws ClassNotFoundException, SQLException {
        boolean status = false;
        Connection conn = null;
        try{
            DBConnManager DBConManager = new DBConnManager();
            conn = DBConManager.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement insertQuery = conn.prepareStatement("insert into users(email,firstname,lastname,password) values(?,?,?,?)");
            insertQuery.setString(1,email);
            insertQuery.setString(2,firstname);
            insertQuery.setString(3,lastname);
            insertQuery.setString(4,password);
            int rs = insertQuery.executeUpdate();
            if(rs>0){
               status = true;
            }
            conn.commit();
        }finally{
            if(conn!=null){
                conn.close();
            }
        }
        return status;
    }
    
    public void updateUser(Integer userId,User user) throws SQLException, ClassNotFoundException{
        Connection conn = null;
        try{
            DBConnManager dbConManager = new DBConnManager();
            conn = dbConManager.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement updateQuery = conn.prepareStatement("update users set firstname=?,lastname=?,addressId=? where id = ?");
            updateQuery.setString(1,user.getFirstname());
            updateQuery.setString(2,user.getLastname());
            updateQuery.setObject(3,user.getAddressId());
            updateQuery.setInt(4, userId);
            updateQuery.executeUpdate();
            conn.commit();
        }finally{
            if(conn!=null)
                conn.close();
        }
    }
    
    public void deleteUser(Integer userId) throws SQLException{
        Connection conn = null;
        try{
            DBConnManager dbConManager = new DBConnManager();
            conn = dbConManager.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement deleteQuery = conn.prepareStatement("delete from users where id = ?");
            deleteQuery.setInt(1, userId);
            deleteQuery.executeUpdate();
            conn.commit();
        }catch (SQLException | ClassNotFoundException ex) {
            if(conn!=null){
                Logger.getLogger(UsersDao.class.getName()).log(Level.SEVERE, null, ex);
                conn.rollback();
            }
        }finally{
            if(conn!=null)
                conn.close();
        }
    }
}
