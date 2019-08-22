/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equalsvsequals;

import java.util.Objects;

/**
 *
 * @author giorgos
 */
public class Person {
    
    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    
}
