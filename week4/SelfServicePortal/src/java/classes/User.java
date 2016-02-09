package classes;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cb-bhuvana
 */
public class User {
    private final String email;
    private String firstname;
    private String lastname;
    private Address address = null;
    
    public User(String firstname,String lastname,String email){
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
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
    
    public Address getAddress(){
        return address;
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
}
