/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author cb-bhuvana
 */

public class Address {
    private String line;
    private String city;
    private String state;
    private String zip;
    private String country;
    
   public Address(String line,String city,String state,String zip,String country){
       this.line = line;
       this.city = city;
       this.state = state;
       this.zip = zip;
       this.country = country;
   }
   
   public void setAddressLine(String line){
       this.line = line;
   }
   
   public void setCity(String city){
       this.city = city;
   }
   
   public void setState(String state){
       this.state = state;
   }
   
   public void setZip(String zip){
       this.zip = zip;
   }
   
   public void setCountry(String country){
       this.country = country;
   }
   
   public String getAddressLine(){
       return line;
   }
   
   public String getState(){
       return state;
   }
   
   public String getCity(){
       return city;
   }
   
   public String getCountry(){
       return country;
   }
   
   public String getZip(){
       return zip;
   }
}


