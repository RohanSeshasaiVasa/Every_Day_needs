package com.example.programs;
import java.util.Scanner;

public class BillSplitter {
    public static void run() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the total bill amount: ");
        double bill = sc.nextDouble();
        System.out.println(bill);
        System.out.print("Enter the amount of people splitting the bill: ");
        int people = sc.nextInt();
        System.out.println(people);
        System.out.print("Enter the tip percentage(Enter 0 if none): ");
        double tipPercent = sc.nextDouble();
        System.out.println(tipPercent + "%");
        sc.close();
        double tipAmount = bill * tipPercent / 100.0;
        double totalWithTip = bill + tipAmount;
        double perPerson = totalWithTip / people;
        System.out.println("Tip amount is: " + tipAmount);
        System.out.println("Total Amount(with tip): " + totalWithTip);
        System.out.println("Per person should pay: " + perPerson);
    }
}