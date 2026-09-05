package com.example.programs;
import java.util.Scanner;
public class KmphToMs {
    public static void run() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter speed in Kilomter per hour: ");
        double kmph = sc.nextDouble();
        System.out.println(kmph + "kmph");
        double meter = 0.28* kmph;
        System.out.println("Speed in meter per second is: " + meter);
        sc.close();
    }
}