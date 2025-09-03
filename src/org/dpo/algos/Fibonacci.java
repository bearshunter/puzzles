package org.dpo.algos;

public class Fibonacci {


    public static void main(String[] args) {
        int n = 100;
        long result = fibonacci(n);
        System.out.println("Fibonacci of " + n + " is: " + result);
        long resultRecursion = fibonacciRecursion(n);
        System.out.println("Fibonacci of " + n + " is: " + resultRecursion);


    }

    public static long fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        int first = 0;
        int second = 1;
        for (int i = 2; i <= n; i++) {
            int next = first + second;
            first = second;
            second = next;
        }
        return second;
    }
    //0,1,1,2,3,5,8,13,21

    private static long fibonacciRecursion(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
