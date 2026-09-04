package com.example.programs;
import java.util.Scanner;

public class InterestCalculator {
    public static void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Principal(Don't use commas)");
        double principal = sc.nextDouble();
        System.out.println("Enter the Time(in years)");
        double time = sc.nextDouble();
        System.out.println("Enter the Rate of Intererst(only the number, no percentage symbol)");
        double rate = sc.nextDouble();
        double SI = (principal*time*rate)/ 100.0;
        double amount = SI + principal;
        System.out.println("Simple Interest is: " + SI);
        System.out.println("Total amount to be paid: " + amount);
        sc.close();
    }
}