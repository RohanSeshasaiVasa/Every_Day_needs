package com.example.programs;
import java.util.Scanner;
public class BMRCalculator {
    public static void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your weight in kilograms");
        double weight = sc.nextDouble();
        System.out.println("Enter your height(In centimeters)");
        double height = sc.nextDouble();
        System.out.println("Enter your age in Years");
        int age = sc.nextInt();
        System.out.println("Enter your gender(M for Men, F for Female)");
        String gender = sc.next().toUpperCase();
        sc.close();

        double bmr = gender.equals("M") ? 10 * weight + 6.25 * height - 5 * age + 5 : 10 * weight + 6.25 * height - 5 * age - 161; 
        System.out.println("Your estimated BMR: " + bmr);
    }
}
