package com.example.programs;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class AgeCalculator {
    public static void run() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your Birth year: ");
        int year = sc.nextInt();
        System.out.println(year);
        System.out.print("Enter your Birth month(In numbers): ");
        int month = sc.nextInt();
        System.out.println(month);
        System.out.print("Enter your birth day: ");
        int day = sc.nextInt();
        System.out.println(day);
        sc.close();

        LocalDate birthDate = LocalDate.of(year, month, day);
        LocalDate today = LocalDate.now();
        Period age = Period.between(birthDate, today);
        System.out.println("Your age is: " + age.getYears() + " years " + age.getMonths() + " months " + age.getDays() + " days");
    }
}