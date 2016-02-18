/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import classes.Contact;
import classes.PhoneNumber;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author cb-bhuvana
 */
public class PhoneNumbersDao {
    
    public void insertContactPhoneNumber(Integer contactId, ArrayList<PhoneNumber> phoneNumbers) throws SQLException, ClassNotFoundException{
        Connection conn = null;
        try{
            DBConnManager dbConnManager = new DBConnManager();
            conn = dbConnManager.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement insertQuery = conn.prepareStatement("insert into phoneNumbers(contactId,type,phone) values(?,?,?)");
            for(PhoneNumber phoneNumber : phoneNumbers){
                insertQuery.setInt(1, contactId);
                insertQuery.setString(2,phoneNumber.getPhoneType());
                insertQuery.setString(3,phoneNumber.getPhoneNumber());
                insertQuery.executeUpdate();
            }
            conn.commit();
        }finally{
            if(conn!=null){
                conn.close();
            }
        }
    }
    
    
    public void updateContactPhoneNumber(Integer contactId,ArrayList<PhoneNumber> phoneNumbers) throws SQLException, ClassNotFoundException{
        Connection conn = null;
        try{
            DBConnManager dbConnManager = new DBConnManager();
            conn = dbConnManager.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement updateQuery = conn.prepareStatement("update phoneNumbers set phone = ? where type=? and contactId = ?");
            for(PhoneNumber phoneNumber : phoneNumbers){
                updateQuery.setString(1,phoneNumber.getPhoneNumber());
                updateQuery.setString(2,phoneNumber.getPhoneType());
                updateQuery.setInt(3, contactId);
                updateQuery.executeUpdate();
            }
            conn.commit();
        }finally{
            if(conn!=null){
                conn.close();
            }
        }
    }
    
    
    public void setPhoneMatchContacts(Integer userId,ArrayList<Contact> contacts,String phone) throws ClassNotFoundException, SQLException{
        Connection conn=null;
        try{
            DBConnManager dbConnManager = new DBConnManager();
            conn = dbConnManager.getConnection();
            PreparedStatement selectQuery=conn.prepareStatement("select p2.contactId as id ,p2.type as type,p2.phone as phone,c.name as name,c.addressId as addressId,a.address as address,a.city as city,a.state as state,a.zip as zip,a.country as country from phoneNumbers p1 inner join contacts c on p1.contactId = c.id left join addresses a on a.id=c.addressId inner join phoneNumbers p2 on p2.contactId = p1.contactId where p1.phone=? and c.userId=? group by p2.id");
            selectQuery.setString(1, phone);
            selectQuery.setInt(2, userId);
            ResultSet rs = selectQuery.executeQuery();
            FillDetail.fillUserContactDetails(rs, contacts);
        }finally{
            if(conn!=null){
                conn.close();
            }
        }
    }

    
    
    public void deleteContactPhoneNumbers(Integer contactId) throws SQLException, ClassNotFoundException{
        Connection conn = null;
        try{
            DBConnManager dbConnManager = new DBConnManager();
            conn = dbConnManager.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement updateQuery = conn.prepareStatement("delete from phoneNumbers where contactId = ?");
            updateQuery.setInt(1, contactId);
            updateQuery.executeUpdate();
            conn.commit();
        }finally{
            if(conn!=null){
                conn.close();
            }
        }   
    }
    
    public void deletePhoneNumber(Integer contactId,PhoneNumber phoneNumber) throws SQLException, ClassNotFoundException{
        Connection conn = null;
        try{
            DBConnManager dbConnManager = new DBConnManager();
            conn = dbConnManager.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement updateQuery = conn.prepareStatement("delete from phoneNumbers where contactId = ? and type = ?");
            updateQuery.setInt(1, contactId);
            updateQuery.setString(2,phoneNumber.getPhoneType());
            updateQuery.executeUpdate();
            conn.commit();
        }finally{
            if(conn!=null){
                conn.close();
            }
        }   
    }
}
