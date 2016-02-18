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
public class PhoneNumber {
    private String type;
    private String phone;
    
    public PhoneNumber(String type, String phone){
        this.type = type;
        this.phone = phone;
    }
    
    public void setPhoneType(String type){
        this.type = type;
    }
    
    public void setPhoneNumber(String phone){
        this.phone = phone;
    }
        
    public String getPhoneType(){
        return type;
    }
    
    public String getPhoneNumber(){
        return phone;
    }
    
    @Override
    public String toString(){
        return phone+"("+type+") ";
    }
}
