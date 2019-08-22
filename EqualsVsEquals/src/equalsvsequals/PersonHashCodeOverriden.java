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
public class PersonHashCodeOverriden extends Person {

    public PersonHashCodeOverriden(String name) {
        super(name);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.name);
        return hash;
    }
    
}
