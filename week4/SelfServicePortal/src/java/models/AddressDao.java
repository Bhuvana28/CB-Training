/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import classes.Address;
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
public class AddressDao {
    public Address getAddressDetails(String email) throws SQLException{
        Address address= null;
        Connection conn = null;
        try{
            DBConnectionManager DBConManager = new DBConnectionManager();
            conn = DBConManager.getConnection();
            PreparedStatement searchQuery = conn.prepareStatement("select address,city,state,zip,country from addresses where email=?");
            searchQuery.setString(1,email);
            ResultSet rs = searchQuery.executeQuery();
            if(rs.next()){
                address = new Address(rs.getString("address"),rs.getString("city"),rs.getString("state"),rs.getString("zip"),rs.getString("country")); 
            }
        } catch (ClassNotFoundException | SQLException ex) {
                   Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(conn != null){
                conn.close();
            }
        }
        return address;
    }
    
    public boolean insertAddress(Address address,String email) throws SQLException{
        boolean status = false;
        Connection conn = null;
        try{
            DBConnectionManager DBConManager = new DBConnectionManager();
            conn = DBConManager.getConnection();
             conn.setAutoCommit(false);
            PreparedStatement insertQuery = conn.prepareStatement("insert into addresses(email,address,city,state,zip,country) values(?,?,?,?,?,?)");
            insertQuery.setString(1,email);
            insertQuery.setString(2,address.getAddressLine());
            insertQuery.setString(3,address.getCity());
            insertQuery.setString(4,address.getState());
            insertQuery.setString(5,address.getZip());
            insertQuery.setString(6,address.getCountry());
            int rs = insertQuery.executeUpdate();
            if(rs>0){
               status = true;
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
        return status;
    }
    
    public void updateAddress(Address address,String email) throws SQLException{
        Connection conn = null;
        try{
            DBConnectionManager DBConManager = new DBConnectionManager();
            conn = DBConManager.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement updateAddressQuery = conn.prepareStatement("update addresses set address=?,city = ?,state=?,zip=?,country=? where email = ?");
            updateAddressQuery.setString(1, address.getAddressLine());
            updateAddressQuery.setString(2, address.getCity());
            updateAddressQuery.setString(3, address.getState());
            updateAddressQuery.setString(4, address.getZip());
            updateAddressQuery.setString(5, address.getCountry());
            updateAddressQuery.setString(6, email);
            updateAddressQuery.executeUpdate();
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
    
    public void deleteAddress(String email) throws SQLException{
        Connection conn = null;
        try{
            DBConnectionManager DBConManager = new DBConnectionManager();
            conn = DBConManager.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement deleteAddressQuery = conn.prepareStatement("delete from addresses where email = ?");
            deleteAddressQuery.setString(1, email);
            deleteAddressQuery.executeUpdate();
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
