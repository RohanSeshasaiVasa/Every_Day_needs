package com.example.programs;
import java.util.Scanner;
public class MarksProgram {
    public static void run(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter you name");
        String name = sc.nextLine();
        System.out.println("Enter your roll number(only numbers please)");
        int rno = sc.nextInt();
        System.out.println("Enter your Maths marks");
        int maths = sc.nextInt();
        System.out.println("Enter your Physics marks");
        int phy = sc.nextInt();
        System.out.println("Enter your Chemistry marks");
        int chem = sc.nextInt();
        System.out.println("Enter your Biology marks");
        int bio = sc.nextInt();
        System.out.println("Enter your History marks");
        int history = sc.nextInt();
        System.out.println("Enter your Geography marks");
        int geo = sc.nextInt();
        System.out.println("Enter your Language marks");
        int lang = sc.nextInt();
        System.out.println("Enter your Grammar marks");
        int grammar = sc.nextInt();
        System.out.println("Enter your Literature(English 2) marks");
        int literature = sc.nextInt();
        System.out.println("Enter your Moral Science marks");
        int msci = sc.nextInt();
        int total = maths + phy + chem + bio + history + geo + lang + grammar + literature + msci;
        double average = total/10.0;
        System.out.println("Your name is: " + name);
        System.out.println("Your Roll number is:" + rno);
        System.out.println("Maths: " + maths);
        System.out.println("Physics: " + phy);
        System.out.println("Chemistry: " + chem);
        System.out.println("Biology: " + bio);
        System.out.println("History: " + history);
        System.out.println("Geography: " + geo);
        System.out.println("Language: " + lang);
        System.out.println("Grammar: " + grammar);
        System.out.println("Literature: " + literature);
        System.out.println("Moral values: " + msci);
        System.out.println("Total marks you got for 10 subjects is: " + total);
        System.out.println("Percentage marks you got  for 10 subjects is: " + average);
    }
}
