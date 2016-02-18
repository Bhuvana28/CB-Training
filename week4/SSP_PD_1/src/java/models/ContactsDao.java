/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import classes.Contact;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author cb-bhuvana
 */
public class ContactsDao {
    
    public void setUserContactsDetails(Integer userId, ArrayList<Contact> contacts) throws ClassNotFoundException, SQLException {
        Connection conn=null;
        try{
            DBConnManager dbConnManager = new DBConnManager();
            conn = dbConnManager.getConnection();
            PreparedStatement selectQuery=conn.prepareStatement("select c.id as id,c.name as name,c.addressId as addressId,a.address as address,a.city as city,a.state as state,a.zip as zip,a.country as country,p.type as type,p.phone as phone from contacts c left join addresses a on a.id=c.addressId inner join phoneNumbers p on p.contactId = c.id where c.userId=?");
            selectQuery.setInt(1, userId);
            ResultSet rs = selectQuery.executeQuery();
            FillDetail.fillUserContactDetails(rs, contacts);
        }finally{
            if(conn!=null){
                conn.close();
            }
        }
    }
    
    public Integer insertContact(Contact contact,Integer userId) throws SQLException, ClassNotFoundException{
        Integer contactId =null;
        Connection conn = null;
        try{
            DBConnManager dbConnManager = new DBConnManager();
            conn = dbConnManager.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement insertQuery = conn.prepareStatement("insert into contacts(userId,name,addressId) values(?,?,?)",Statement.RETURN_GENERATED_KEYS);
            insertQuery.setInt(1,userId);
            insertQuery.setString(2, contact.getContactName());
            insertQuery.setObject(3,contact.getContactAddressId());
            int result = insertQuery.executeUpdate();
            if(result>0){   
               ResultSet rs= insertQuery.getGeneratedKeys();
               if(rs.next()){
                   contactId=rs.getInt(1);
               }
               conn.commit();
            }
        }finally{
            if(conn!=null){
                conn.close();
            }
        }
        return contactId;
    }

    public Contact getContact(Integer contactId) throws ClassNotFoundException, SQLException {
        ArrayList<Contact> contacts = new ArrayList<>();
        Connection conn=null;
        try{
            DBConnManager dbConnManager = new DBConnManager();
            conn = dbConnManager.getConnection();
            PreparedStatement selectQuery=conn.prepareStatement("select c.id as id,c.name as name,c.addressId as addressId,a.address as address,a.city as city,a.state as state,a.zip as zip,a.country as country,p.type as type,p.phone as phone from contacts c left join addresses a on a.id=c.addressId inner join phoneNumbers p on p.contactId = c.id where c.id=?");
            selectQuery.setInt(1, contactId);
            ResultSet rs = selectQuery.executeQuery();
            FillDetail.fillUserContactDetails(rs, contacts);
        }finally{
            if(conn!=null){
                conn.close();
            }
        }
        return contacts.get(0);
    }
    
    public void updateContact(Integer contactId,Contact contact) throws SQLException, ClassNotFoundException{
        Connection conn = null;
        try{
            DBConnManager dbConManager = new DBConnManager();
            conn = dbConManager.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement updateQuery = conn.prepareStatement("update contacts set name= ?, addressId= ? where id=?");
            updateQuery.setString(1, contact.getContactName());
            updateQuery.setObject(2,contact.getContactAddressId());
            updateQuery.setInt(3,contactId);
            updateQuery.executeUpdate();
            conn.commit();
        }finally{
            if(conn!=null){
                conn.close();
            }
        }
    }

    public void setNameMatchContacts(Integer userId, ArrayList<Contact> contacts, String name) throws ClassNotFoundException, SQLException {
        Connection conn=null;
        try{
            DBConnManager dbConnManager = new DBConnManager();
            conn = dbConnManager.getConnection();
            PreparedStatement selectQuery=conn.prepareStatement("select c.id as id,c.name as name,c.addressId as addressId,a.address as address,a.city as city,a.state as state,a.zip as zip,a.country as country,p.type as type,p.phone as phone from contacts c left join addresses a on a.id=c.addressId inner join phoneNumbers p on p.contactId = c.id where c.userId=? and c.name = ?");
            selectQuery.setInt(1, userId);
            selectQuery.setString(2, name);
            ResultSet rs = selectQuery.executeQuery();
            FillDetail.fillUserContactDetails(rs, contacts);
        }finally{
            if(conn!=null){
                conn.close();
            }
        }
    }
    
    public void setPartialMatchContacts(Integer userId, ArrayList<Contact> contacts, String partial) throws ClassNotFoundException, SQLException {
        Connection conn=null;
        try{
            DBConnManager dbConnManager = new DBConnManager();
            conn = dbConnManager.getConnection();
            PreparedStatement selectQuery=conn.prepareStatement("select p2.contactId as id ,p2.type as type,p2.phone as phone,c.name as name,c.addressId as addressId,a.address as address,a.city as city,a.state as state,a.zip as zip,a.country as country from contacts c inner join phoneNumbers p1 on p1.contactId = c.id left join addresses a on a.id=c.addressId inner join phoneNumbers p2 on p2.contactId = p1.contactId where c.userId=? and (p1.phone like '%"+partial+"%' or c.name like '%" + partial + "%') group by p2.id");
            selectQuery.setInt(1, userId);
            ResultSet rs = selectQuery.executeQuery();
            FillDetail.fillUserContactDetails(rs, contacts);
        }finally{
            if(conn!=null){
                conn.close();
            }
        }
    }
    
    public void deleteContactInfo(Integer contactId) throws SQLException, ClassNotFoundException{
        Connection conn = null;
        try{
            DBConnManager dbConManager = new DBConnManager();
            conn = dbConManager.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement deleteQuery = conn.prepareStatement("delete from contacts where id=?");
            deleteQuery.setInt(1,contactId);
            deleteQuery.executeUpdate();
            conn.commit();
        }finally{
            if(conn!=null){
                conn.close();
            }
        }
    }
}
