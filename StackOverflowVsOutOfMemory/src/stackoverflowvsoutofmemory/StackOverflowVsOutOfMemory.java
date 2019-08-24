/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackoverflowvsoutofmemory;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author giorgos
 */
public class StackOverflowVsOutOfMemory {

    static void method() {
        method();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /*
        STACK OVERFLOW ERROR
            The most common cause for the JVM to encounter this situation is
        unterminated/infinite recursion of a code snippet.
            It can also happen in a situation where an application keeps calling
        methods from within methods until the stack is exhausted.
            Lastly, it can also happen if an app has classes with cyclic relationships
        between them, or if a class is being instatiated within the same class
        as an instance variable of that class.
                
        Uncomment one of two lines below to get
        Exception in thread "main" java.lang.StackOverflowError            
         */
        
        //method();
        //RecursiveClass recursive = new RecursiveClass();
        
        
        
        
        /*
        OUT OF MEMORY ERROR : HEAP
            Usually, this error is thrown when the JVM cannot allocate memory in
        the Heap to store an object because the Heap is out of memory, and no more
        memory could be made available by the Garbage Collector.
            When this error occurs then this usually means that there are too many
        not orphaned objects stored, or we are trying to process too much data at
        a time.
        
        Uncomment Line 1, compile and run the programm with 512mb Heap memory.
        The programm will run flawlessly. Try again running the program with
        426mb Heap memory or less. JVM will throw
        Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
        
        
        Uncomment Line 2, compile an run the program with the default Heap memory.
        Through the loop there're so many objects created and stored in the
        array that the Heap runs out of space. Have in mind that this process
        will need some time.
        
        */

        //Integer[][] array = new Integer[10000][10000];  // Line 1
        
        
        List<Person> persons = new ArrayList();
        for (int i = 0; i < 10000000; i++) {
            //persons.add(new Person("Name" + i, "Surname" + i, i));    // Line 2
        }
        
        /*
        CONFIGURATION OF HEAP AND STACK MEMORY SIZE
        We can configure the Heap and Stack size either by the project configuration
        (right click on project -> Properties -> Run -> VM Options
        either by the Command Line when we choose to run the project.
        
        In both cases we need to use the following flags:
        
        -Xss: configures the Stack memory size
        -Xmx: configures the max Heap memory size
            Example:
            $java -Xmx512m stackoverflowvsoutofmemory.StackOverflowVsOutOfMemory
        
        -Xms: configures the min Heap memory size
        
        
        
        
        
        */
        
        
        
    }

}
