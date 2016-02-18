/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.ArrayList;

/**
 *
 * @author cb-bhuvana
 */
public class User {
    private final String email;
    private String firstname;
    private String lastname;
    private Integer addressId=null;
    private Address address;
    private ArrayList<Contact> contacts = new ArrayList<>();
    
    public User(String firstname,String lastname,String email,Integer addressId,Address address){
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.addressId = addressId;
        this.address = address;
    }
    
    public User(String firstname,String lastname,String email,Address address){
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.address = address;
    }
    
    public String getFirstname(){
        return firstname;
    }
    
    public String getLastname(){
        return lastname;
    }

    public String getEmail(){
        return email;
    }
    
    public Integer getAddressId(){
        return addressId;
    }
    
    public Address getAddress(){
        return address;
    }
    
    public ArrayList<Contact> getUserContacts(){
        return contacts;
    }
    
    public void setFirstname(String firstname){
        this.firstname = firstname;
    }
    
    public void setLastname(String lastname){
        this.lastname = lastname;
    }
    
    public void setAddress(Address address){
        this.address = address;
    }
    
    public void setAddressId(Integer id){
        addressId = id;
    }
    
    public void setUserContacts(ArrayList<Contact> contacts){
        this.contacts = contacts;
    }
    
    public void addUserContact(Contact contact,Integer contactId){
        contacts.add(contact);
    }
    
    @Override
    public String toString(){
        return "User -" +  firstname + " " + lastname + " , "  + email  + " , "+ addressId + " \n " + address + "\n" +contacts;
    }

}
