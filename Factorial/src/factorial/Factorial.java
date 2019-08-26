/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factorial;

import java.math.BigInteger;
import java.util.stream.LongStream;

/**
 *
 * @author giorgos
 */
public class Factorial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(factorial(20));
        System.out.println(factorialStream(20));
        System.out.println(factorialRecursive(20));
        System.out.println(factorialBigInteger(120));
    }

    static long factorial(int number) {
        long factorial = 1;
        for (int i = 2; i <= number; i++) {
            factorial *= i;
        }
        return factorial;
    }

    static long factorialStream(int number) {
        return LongStream.rangeClosed(1, number).reduce(1, (x, y) -> x * y);
    }

    static long factorialRecursive(int number) {
        if (number == 1) {
            return 1;
        }
        return number * factorialRecursive(number - 1);
    }

    static BigInteger factorialBigInteger(int number) {
        BigInteger factorial = BigInteger.ONE;
        for (int i = 2; i <= number; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        return factorial;
    }


}
