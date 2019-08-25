/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadandrunnable;

import java.util.logging.Level;
import java.util.logging.Logger;
import static threadandrunnable.ThreadAndRunnable.T0;

/**
 *
 * @author giorgos
 */
public class ThreadOne extends Thread {
    @Override
    public void run(){
        for (int i = 0; i < 5; i++) {
            try {
                System.out.printf("%-10s%s\n", "Thread 1", 
                        (System.currentTimeMillis() - T0) + "ms");
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadOne.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
