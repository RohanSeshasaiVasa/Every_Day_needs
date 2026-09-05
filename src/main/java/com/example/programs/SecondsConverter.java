package com.example.programs;
import java.util.Scanner;

public class SecondsConverter {
    public static void run() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your seconds: ");
        int seconds = sc.nextInt();
        System.out.println(seconds + "s");
        int hours = seconds/3600;
        int rseconds = seconds%3600;
        int minutes = rseconds/60;
        int secs = seconds%60;
        System.out.println(hours + " Hours " + minutes + " Minutes " + secs + " Seconds ");
        sc.close();
    }    
}
