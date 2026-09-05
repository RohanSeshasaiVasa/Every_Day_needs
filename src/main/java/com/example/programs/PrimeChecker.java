package com.example.programs;
import java.util.Scanner;
public class PrimeChecker {
    public static void run() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a whole number to check whether it is a prime number or not: ");
        int number = sc.nextInt();
        System.out.println(number);
        sc.close();
        
        boolean isPrime = number >= 2;
        for (int i = 2; isPrime && i<= Math.sqrt(number); i++) {
            if (number % i == 0) {
                isPrime = false;
            }
        }
        System.out.println(number + (isPrime ? " is a prime number" : " is not a prime number"));
    }
}
