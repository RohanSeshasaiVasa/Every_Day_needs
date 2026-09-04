package com.example.programs;
import java.util.Scanner;

public class SpeedCalculator {
    public static void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the time taken(In hours)");
        double time = sc.nextDouble();
        System.out.println("Enter the distance travelled");
        double distance = sc.nextDouble();
        double speed = distance/time;
        System.out.println("Speed of the body is: " + speed);
        sc.close();
    }
}