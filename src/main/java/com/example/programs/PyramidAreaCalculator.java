package com.example.programs;
import java.util.Scanner;

public class PyramidAreaCalculator {
    public static void run() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length: ");
        double length = sc.nextDouble();
        System.out.println(length);
        System.out.print("Enter the width: ");
        double width = sc.nextDouble();
        System.out.println(width);
        System.out.print("Enter the height: ");
        double height = sc.nextDouble();
        System.out.println(height);
        double baseArea = length*width;
        double volume = (1.0/3) * baseArea * height;
        System.out.println("Length is: " + length + "\n" + "Width is: " + width + "\n" + "Height is: " + height);
        System.out.println("Base Area of the pyramid is: " + baseArea);
        System.out.println("Volume of the pyramid is: " + volume);
        sc.close();
    }
}
