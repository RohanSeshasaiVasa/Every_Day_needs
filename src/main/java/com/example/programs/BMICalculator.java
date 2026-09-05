package com.example.programs;
import java.util.Scanner;

public class BMICalculator {
    public static void run() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your weight in kilograms: ");
        double weight = sc.nextDouble();
        System.out.println(weight);
        System.out.print("Enter your height in meters: ");
        double height  = sc.nextDouble();
        System.out.println(height);
        sc.close();
        double bmi = weight / (height * height);
        
        String category;
        if(bmi < 18.5) {
            category = "Underweight";
        } else if(bmi < 25){
            category = "Normal weight";
        } else if(bmi < 30) {
            category = "Overweight";
        } else{
            category = "Obese";
        }

        System.out.println("Your BMI is: " + bmi);
        System.out.println("Category: " + category);
    }
}