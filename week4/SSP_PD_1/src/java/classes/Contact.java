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
public class Contact {
    private Integer contactId;
    private String name;
    private Integer addressId = null;
    private Address address = null;
    private ArrayList<PhoneNumber> phoneNumbers = new ArrayList<>();
    
    
    public Contact(Integer contactId,String name,Integer addressId,Address address,ArrayList<PhoneNumber> phoneNumbers){
        this.contactId= contactId;
        this.name = name;
        this.addressId = addressId;
        this.address = address;
        this.phoneNumbers = phoneNumbers;
    }
    
    public void setContactId(Integer contactId){
        this.contactId = contactId;
    }
    
    public void setContactName(String name){
        this.name = name;
    }
    
    public void setContactAddressId(Integer addressId){
        this.addressId = addressId;
    }
    
    public void setContactAddress(Address address){
        this.address =address;
    }
    
    public void setContactPhoneNumbers(ArrayList<PhoneNumber> phoneNumbers){
        this.phoneNumbers = phoneNumbers;
    }
    
    public void addContactPhoneNumber(PhoneNumber phoneNumber){
        phoneNumbers.add(phoneNumber);
    }
    
    public Integer getContactId(){
        return contactId;
    }
    
    public String getContactName(){
        return name;
    }
    
    public Integer getContactAddressId(){
        return addressId;
    }
    
    public Address getContactAddress(){
        return address;
    }
    
    public ArrayList<PhoneNumber> getContactPhoneNumbers(){
        return phoneNumbers;
    } 
    
    public String getPhoneNumberofType(String type){
        for(PhoneNumber phoneNumber : phoneNumbers){
            if(phoneNumber.getPhoneType().equals(type)){
                return phoneNumber.getPhoneNumber();
            }
        }
        return "";
    }
    
    @Override
    public String toString(){
        return "Id: "+contactId+",Name:"+name+",Address:"+address+",PhoneNumbers:"+phoneNumbers;
    }
    
}
