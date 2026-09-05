package com.example.programs;
import java.util.Scanner;
public class MarksProgram {
    public static void run(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter you name: ");
        String name = sc.nextLine();
        System.out.println(name);
        System.out.print("Enter your roll number(only numbers please): ");
        int rno = sc.nextInt();
        System.out.println(rno);
        System.out.print("Enter your Maths marks: ");
        int maths = sc.nextInt();
        System.out.println(maths);
        System.out.print("Enter your Physics marks: ");
        int phy = sc.nextInt();
        System.out.println(phy);
        System.out.print("Enter your Chemistry marks: ");
        int chem = sc.nextInt();
        System.out.println(chem);
        System.out.print("Enter your Biology marks: ");
        int bio = sc.nextInt();
        System.out.println(bio);
        System.out.print("Enter your History marks: ");
        int history = sc.nextInt();
        System.out.println(history);
        System.out.print("Enter your Geography marks: ");
        int geo = sc.nextInt();
        System.out.println(geo);
        System.out.print("Enter your Language marks: ");
        int lang = sc.nextInt();
        System.out.println(lang);
        System.out.print("Enter your Grammar marks: ");
        int grammar = sc.nextInt();
        System.out.println(grammar);
        System.out.print("Enter your Literature(English 2) marks: ");
        int literature = sc.nextInt();
        System.out.println(literature);
        System.out.print("Enter your Moral Science marks: ");
        int msci = sc.nextInt();
        System.out.println(msci);
        int total = maths + phy + chem + bio + history + geo + lang + grammar + literature + msci;
        double average = total/10.0;
        
        System.out.println("Total marks you got for 10 subjects is: " + total);
        System.out.println("Percentage marks you got  for 10 subjects is: " + average);
        sc.close();
    }
}
