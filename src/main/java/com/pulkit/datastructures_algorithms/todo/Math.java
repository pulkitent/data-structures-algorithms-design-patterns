package com.pulkit.datastructures_algorithms.todo;

public class Math {
    public static void main(String[] args) {
        Math m = new Math();
        m.divideUtil(9, 0);
    }

    private void divideUtil(int a, int b) {
        try {
            divide(a, b);
        } catch (ArithmeticException ex) {
            System.out.println("Inside divideUtil");
            throw new ArithmeticException();
        }
    }

    private void divide(int a, int b) {
        try {
            int c = a / b;
        } catch (ArithmeticException ex) {
            System.out.println("Inside divide");
            throw new ArithmeticException();
        }
    }
}