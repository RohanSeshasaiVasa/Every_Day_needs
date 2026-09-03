package com.example.programs;
import java.util.Scanner;
public class KmphToMs {
    public static void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter speed in Kilomter per hour");
        double kilo = sc.nextDouble();
        double meter = 0.28* kilo;
        System.out.println("Speed in meter per second is: " + meter);
        sc.close();
    }
}