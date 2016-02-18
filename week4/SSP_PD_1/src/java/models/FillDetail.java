/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import classes.Address;
import classes.Contact;
import classes.PhoneNumber;
import classes.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author cb-bhuvana
 */
public class FillDetail {
    
    public static User fillUserDetails(ResultSet rs) throws SQLException{
        User user = null;
        Integer addressId = null;
        Address address = null;
        if(rs.getObject("addressId")!=null){
            addressId = rs.getInt("addressId");
            address = new Address(rs.getString("address"),rs.getString("city"),rs.getString("state"),rs.getString("zip"),rs.getString("country"));
        }
        user = new User(rs.getString("firstname"),rs.getString("lastname"),rs.getString("email"),addressId,address);
        return user;
    }
    
    public static void fillUserContactDetails(ResultSet rs, ArrayList<Contact> contacts) throws SQLException{
        while(rs.next()){
            Integer addressId=null;
            Address address = null;
            Contact contact = FillDetail.getContactIndex(contacts,rs.getInt("id"));
            if(contact ==null){
                if(rs.getObject("addressId")!=null){
                    addressId = rs.getInt("addressId");
                    address = new Address(rs.getString("address"),rs.getString("city"),rs.getString("state"),rs.getString("zip"),rs.getString("country"));
                }
                ArrayList<PhoneNumber> phoneNumbers = new ArrayList<>();
                phoneNumbers.add(new PhoneNumber(rs.getString("type"),rs.getString("phone")));
                contacts.add(new Contact(rs.getInt("id"),rs.getString("name"),addressId,address,phoneNumbers));
            }else{
                contact.addContactPhoneNumber(new PhoneNumber(rs.getString("type"),rs.getString("phone")));
            }
        }
    }
    
    private static Contact getContactIndex(ArrayList<Contact> contacts,Integer contactId){
        
        for(Contact contact: contacts){
            if(contact.getContactId().equals(contactId)){
                return contact;
            }
        }
        return null;
    }
}
