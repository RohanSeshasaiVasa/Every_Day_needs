package com.example.programs;
import java.util.Scanner;

public class DiscountCalculator {
    public static void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Total price");
        double TotalPrice = sc.nextDouble();
        System.out.println("Enter the discount percent");
        double DiscountPercent = sc.nextDouble();
        sc.close();
        double DiscountAmount = TotalPrice * DiscountPercent / 100.0;
        double FinalPrice = TotalPrice - DiscountAmount;
        System.out.println("Discount is: " + DiscountAmount);
        System.out.println("Final Price is: " + FinalPrice);
    }
}