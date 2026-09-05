package com.example.programs;
import java.util.Scanner;
public class AreaOfTrapezoid {
    public static void run() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first base: ");
        double base1 = sc.nextDouble();
        System.out.println(base1);
        System.out.print("Enter the second base: ");
        double base2 = sc.nextDouble();
        System.out.println(base2);
        System.out.print("Enter the height: ");
        double height = sc.nextDouble();
        System.out.println(height);
        double Area = 0.5 * (base1 + base2) * height;
        System.out.println("Area of the trapezoid is: " + Area);
        sc.close();
    }
}