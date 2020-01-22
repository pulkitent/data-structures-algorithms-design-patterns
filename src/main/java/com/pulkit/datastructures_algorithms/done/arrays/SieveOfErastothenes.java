package com.pulkit.datastructures_algorithms.done.arrays;

public class SieveOfErastothenes {
    public static void main(String[] args) {
        int a = 2;
        int b = 100;

        boolean[] primes = calculate(a, b);

        for (int index = 2; index < primes.length; index++) {
            if (primes[index]) {
                System.out.println(index);
            }
        }
    }

    private static boolean[] calculate(int low, int high) {
        boolean[] primes = new boolean[high];

        for (int i = 0; i < primes.length; i++) {
            primes[i] = true;
        }

        for (int index = low; index * index <= high; index++) {
            int k = 2;
            if (primes[index]) {
                for (int p = index * 2; p < high; p = index * k) {
                    primes[p] = false;
                    k++;
                }
            }
        }
        return primes;
    }
}