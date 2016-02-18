/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import classes.Address;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author cb-bhuvana
 */
public class AddressesDao {
    public Integer insertAddress(Address address) throws SQLException, ClassNotFoundException{
        Integer addressId = null;
        Connection conn = null;
        try{
            DBConnManager DBConManager = new DBConnManager();
            conn = DBConManager.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement insertQuery = conn.prepareStatement("insert into addresses(address,city,state,zip,country) values(?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
            insertQuery.setString(1,address.getAddressLine().isEmpty()?null:address.getAddressLine());
            insertQuery.setString(2,address.getCity().isEmpty()?null:address.getCity());
            insertQuery.setString(3,address.getState().isEmpty()?null:address.getState());
            insertQuery.setString(4,address.getZip().isEmpty()?null:address.getZip());
            insertQuery.setString(5,address.getCountry().isEmpty()?null:address.getCountry());
            int result = insertQuery.executeUpdate();
            if(result>0){   
               ResultSet rs= insertQuery.getGeneratedKeys();
               if(rs.next()){
                   addressId=rs.getInt(1);
               }
            }
            conn.commit();
        }finally{
            if(conn != null){
                conn.close();
            }
        }
        return addressId;
    }
    
    public void updateAddress(Integer addressId,Address address) throws SQLException, ClassNotFoundException{
        Connection conn = null;
        try{
            DBConnManager dbConManager = new DBConnManager();
            conn = dbConManager.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement updateQuery = conn.prepareStatement("update addresses set address=?,city = ?,state=?,zip=?,country=? where id=?");
            updateQuery.setString(1,address.getAddressLine().isEmpty()?null:address.getAddressLine());
            updateQuery.setString(2,address.getCity().isEmpty()?null:address.getCity());
            updateQuery.setString(3,address.getState().isEmpty()?null:address.getState());
            updateQuery.setString(4,address.getZip().isEmpty()?null:address.getZip());
            updateQuery.setString(5,address.getCountry().isEmpty()?null:address.getCountry());
            updateQuery.setObject(6, addressId);
            updateQuery.executeUpdate();
            conn.commit();
        }finally{
            if(conn!=null){
                conn.close();
            }
        }
    }
        
    public void deleteAddress(Integer addressId) throws SQLException, ClassNotFoundException{
        Connection conn = null;
        try{
            DBConnManager dbConManager = new DBConnManager();
            conn = dbConManager.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement deleteQuery = conn.prepareStatement("delete from addresses where id=?");
            deleteQuery.setInt(1, addressId);
            deleteQuery.executeUpdate();
            conn.commit();
        }finally{
            if(conn!=null){
                conn.close();
            }
        }
    }
}

