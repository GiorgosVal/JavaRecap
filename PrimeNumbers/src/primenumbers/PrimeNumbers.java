/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primenumbers;

import java.util.ArrayList;
import java.util.List;
import methodtimer.MethodTimer;

/**
 *
 * @author giorgos
 */
public class PrimeNumbers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        printClosestPrimes(-151);

        printPrimesList(getPrimesInRange(-151, 80));

        for (int i = -500; i < 500; i++) {
            printPrimeWithAllMethods(i);
        }
    }

    static boolean isPrime1(int x) {
        int abs = Math.abs(x);
        if (abs <= 1) {
            return false;
        }
        if (abs == 2) {
            return true;
        }
        int limit = abs - 1;
        for (int i = 2; i < limit; i++) {
            if (abs % i == 0) {
                return false;
            }
        }
        return true;
    }

    static boolean isPrime2(int x) {
        int abs = Math.abs(x);
        if (abs <= 1) {
            return false;
        }
        if (abs == 2) {
            return true;
        }

        int limit;
        if (abs % 2 == 0) {
            return false;
        } else {
            limit = abs / 2;
            for (int i = 2; i < limit; i++) {
                if (abs % i == 0) {
                    return false;
                }
            }
        }

        return true;
    }

    static boolean isPrime3(int x) {
        int abs = Math.abs(x);
        if (abs <= 1) {
            return false;
        }
        if (abs == 2) {
            return true;
        }

        double root = Math.sqrt(abs);
        double floor = Math.floor(root);

        if (root != floor) {
            for (int i = 2; i <= floor; i++) {
                if (abs % i == 0) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    static int[] closestPrimes(int x) {
        boolean isNegative = x < 0;
        boolean lowPrimeNeeded = true;
        boolean highPrimeNeeded = true;
        int low = Math.abs(x);
        int high = low;

        while (lowPrimeNeeded || highPrimeNeeded) {
            if (highPrimeNeeded) {
                highPrimeNeeded = !isPrime3(++high);
            }
            if (lowPrimeNeeded) {
                lowPrimeNeeded = !isPrime3(--low);
            }
        }

        low = (isNegative) ? -low : low;
        high = (isNegative) ? -high : high;

        return new int[]{low, high};
    }

    static List<Integer> getPrimesInRange(int x, int y) {
        List<Integer> primes = new ArrayList();
        int min = (x < y) ? x : y;
        int max = (x > y) ? x : y;

        for (int i = min; i <= max; i++) {
            if (isPrime3(i)) {
                primes.add(i);
            }
        }
        return primes;
    }

    static void printPrimeWithAllMethods(int x) {
        MethodTimer t = () -> isPrime1(x);
        System.out.printf("%-30s%10s%20s\n", "isPrime1(" + x + "): ",
                isPrime1(x), t.stopwatchNano() + "ms");
        t = () -> isPrime2(x);
        System.out.printf("%-30s%10s%20s\n", "isPrime2(" + x + "): ",
                isPrime2(x), t.stopwatchNano() + "ms");
        t = () -> isPrime3(x);
        System.out.printf("%-30s%10s%20s\n\n", "isPrime3(" + x + "): ",
                isPrime3(x), t.stopwatchNano() + "ms");

    }

    static void printClosestPrimes(int x) {
        int[] primes = closestPrimes(x);

        System.out.println(x + " number is " + (isPrime3(x) ? "" : "not ")
                + "a prime number.");
        System.out.println("It's closest prime numbers are " + primes[0]
                + " and " + primes[1] + ".\n");
    }

    static void printPrimesList(List<Integer> list) {
        list.stream().forEach((t) -> System.out.print(t + ", "));
        System.out.println("\n");
    }
    
}
