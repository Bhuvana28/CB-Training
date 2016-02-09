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
public class Error {
    private final String attribute;
    private String message;
    
    Error(String attribute,String message){
        this.attribute = attribute;
        this.message = message;
    }
    
    public String getErrorMessage(){
        return message;
    }
    
    public String getErrorAttribute(){
        return attribute;
    }
    
    public void setErrorMessage(String message){
        this.message = message;
    }
}
