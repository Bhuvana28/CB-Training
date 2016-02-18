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
public enum PhoneType {
    Work("Work"),
    Home("Home"),
    Mobile("Mobile");
    
    private final String type;
    PhoneType(String type){
        this.type = type;
    }
    
    public String getPhoneEnumType(){
        return type;
    }
}
