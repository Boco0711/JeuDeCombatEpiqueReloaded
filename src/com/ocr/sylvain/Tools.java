package com.ocr.sylvain;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Tools {


    public static int askSomething(String question, String error, int min, int max) {
        Scanner sc = new Scanner(System.in);
        System.out.println(question);
        boolean responseIsGood = false;
        int choix = 0;
        while (!responseIsGood || choix < min || choix > max) {
            try {
                choix = sc.nextInt();
                responseIsGood = true;
                if (choix < min || choix > max) {
                    System.out.println(error);
                    System.out.println(question);
                }
            } catch (InputMismatchException e) {
                sc.next();
                System.out.println(error);
                System.out.println(question);
                responseIsGood = false;
            }
        }
        return choix;
    }

}
