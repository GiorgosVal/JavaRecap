/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equalsvsequals;

/**
 *
 * @author giorgos
 */
public enum StringType {
    
    STRING("String"), STRINGBUILDER("StringBuilder"), STRINGBUFFER("StringBuffer");
    
    private String type;
    
    StringType(String type){
        this.type = type;
    }
    
    
    
}
