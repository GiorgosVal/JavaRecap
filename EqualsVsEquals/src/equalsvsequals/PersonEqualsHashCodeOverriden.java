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
public class PersonEqualsHashCodeOverriden extends Person {

    public PersonEqualsHashCodeOverriden(String name) {
        super(name);
    }
    
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PersonEqualsHashCodeOverriden other = (PersonEqualsHashCodeOverriden) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
    
    
    
}
