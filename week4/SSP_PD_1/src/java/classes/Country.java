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
public enum Country {
    AFGHANISTAN("Afghanistan"),
    AUSTRALIA("Australia"),
    BRAZIL("Brazil"),
    ICELAND("Iceland"),
    INDIA("India"),
    MEXICO("Mexico"),
    ZIMBABWE("Zimbabwe");
    private final String countryName;
    Country(String name){
        countryName = name;
    }
    public String getName(){
        return countryName;
    }
}
