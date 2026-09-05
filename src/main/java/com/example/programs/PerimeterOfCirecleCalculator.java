package com.example.programs;
import java.util.Scanner;

public class PerimeterOfCirecleCalculator {
    public static void run() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the radius: ");
        double radius = sc.nextDouble();
        System.out.println(radius);
        sc.close();
        final double PI = 3.14;
        double perimeter = 2 * PI * radius;
        double area = PI * radius * radius;
        System.out.println("Radius of the circle is: " + radius);
        System.out.println("Perimeter of the circle is: " + perimeter);
        System.out.println("Area of the circle is: " + area);
    }
}
