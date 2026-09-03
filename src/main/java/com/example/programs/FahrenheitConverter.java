package com.example.programs;
import java.util.Scanner;
public class FahrenheitConverter {
    public static void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the temparature in fahrenheit");
        double fahrenheit = sc.nextDouble();
        double celsius = (fahrenheit - 32) * 5 / 9; 
        System.out.println("Fahrenheit temparature: " +  fahrenheit + "°F" + "\n" + "Celcius temparature: " + celsius);
        sc.close();
    }
}
