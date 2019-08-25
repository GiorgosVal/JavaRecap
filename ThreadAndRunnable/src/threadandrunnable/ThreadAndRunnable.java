/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadandrunnable;

/**
 *
 * @author giorgos
 */
public class ThreadAndRunnable {
    
    public static final long T0 = System.currentTimeMillis();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ThreadOne one = new ThreadOne();
        ThreadTwo two = new ThreadTwo();
        ThreadThree three = new ThreadThree();
        ThreadFour four = new ThreadFour();
        
        /*
        'one' and 'two' can start right away with the start() method they inherited
        by the Thread class. The start() method searches and executes the run()
        method of the objects.
        */
        one.start();
        two.start();
        
        /*
        'three' and 'four' implement Runnable which has not a start() method.
        To execute their run() methods we must firstly create two Thread objects
        and relating these objects with 'three' and 'four' objects.
        After this, we can use the start() method on the Thread objects.
        */
        Thread t1 = new Thread(three);
        Thread t2 = new Thread(four);
        t1.start();
        t2.start();
        
    }
    
}
