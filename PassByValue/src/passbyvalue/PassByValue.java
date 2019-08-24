/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passbyvalue;

/**
 *
 * @author giorgos
 */
public class PassByValue {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Person john = new Person("John", "Adams", 31);
        Person mary = new Person("Mary", "Williams", 29);

        swap(john, mary);

        System.out.println("John's properties: "
                + john.getName() + " " + john.getSurname() + " " + john.getAge());
        System.out.println("Mary's properties: "
                + mary.getName() + " " + mary.getSurname() + " " + mary.getAge());

        dothings(john, mary);

        System.out.println("John's properties: "
                + john.getName() + " " + john.getSurname() + " " + john.getAge());
        System.out.println("Mary's properties: "
                + mary.getName() + " " + mary.getSurname() + " " + mary.getAge());
    }

    private static void swap(Person p1, Person p2) {
        Person t = p1;
        p1 = p2;
        p2 = t;
    }

    private static void dothings(Person p1, Person p2) {
        p1.setName("Brian");
        p1 = new Person("Bill", "O'Neal", 25);
        p1.setName("Shaquille");
        p2.setSurname(p1.getSurname());
        Person p3 = p2;
        p3.setAge(25);
    }
    
    
    /*
    This example showcases the meaning of 'Pass by value' in Java.
    Pass by value: The method parameters are copies of the method arguments that
        are passed at the invocation of the method. These parameters are local
        variables that are set to point to the same values as the variables
        of the arguments.
    Pass by reference: The method parameters are aliases or references to the
        actual references passed through arguments.
    
    
    Output:
    John's properties: John Adams 31
    Mary's properties: Mary Williams 29
    John's properties: Brian Adams 31
    Mary's properties: Mary O'Neal 25
    
    Explanation of output:
    Line 17: The main method is invoked, and space for the method is allocated
        in the Stack memory.
    Lines 18,19: The 2 object references 'john' and 'mary' are created inside
        the main method (Stack), alongside with the creation of the actual objects
        that are created in the Heap memory.
    
    Line 21: The invocation of swap() method allocates new space in the Stack
        memory, with 2 new object references 'p1' and 'p2'. 'p1' is set to point
        to object 'john' and 'p2' is set to point to object 'mary'.
    Line 37: The 't' object reference is created inside the swap() method which
        points to where 'p1' points at, that is 'john' object.
    Line 38: The 'p1' object reference is set to point to where 'p2' points at,
        that is 'mary' object.
    Line 39: The 'p2' object reference is set to point to where 't' points at,
        that is 'john' object.
    Line 40: The swap() method's execution ends, the 't', 'p1', 'p2' object 
        references are deleted and the corresponding space at the Stack memory
        is freed. The execution goes back to the main() method.
    
    Lines 23-26: Through the object references 'john' and 'mary' we print out
        the properties of the objects that the references are pointing at.
    
    Line 28: The invocation of dothings() method allocates new space in the Stack
        memory, with 2 new object references 'p1' and 'p2'. 'p1' is set to point
        to object 'john' and 'p2' is set to point to object 'mary'.
    Line 43: Through 'p1' object reference, the name property of the actual
        'john' object is changed.
    Line 44: A new object is created in the Heap memory and 'p1' is set to point
        at it. At this point we loose the ability to set again the 'p1' reference
        to point at 'john' object.
    Line 45: Through 'p1' object reference, the name property of the newly
        created object is changed.
    Line 46: Through 'p2' object reference (which at the moment points at the same
        object as the 'mary' object reference point to) the surname property
        of the object is set to be equal to the value of the newly created object.
    Line 47: The new object reference 'p3' is created and set to point to where
        'p2' object reference points to, that is 'mary'.
    Line 48: Through 'p3' object reference, the age property of 'mary' is changed.
    Line 49: The dothings() method's execution ends, the 'p1', 'p2', 'p3' object
        references are deleted. The newly created object that was referenced by 'p1'
        is now orphaned and eligible for GC. The corresponding space of dothings()
        method in the Stack memory is freed, and the execution returns to main().
    
    Lines 30-33: Through the object references 'john' and 'mary' we print out
        the properties of the objects that the references are pointing at.
    
    */

}
