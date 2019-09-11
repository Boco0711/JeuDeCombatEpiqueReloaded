package com.ocr.sylvain;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Tools {
    Scanner sc = new Scanner(System.in);
    /**
     * this method is used by many methods
     * It display a question, get the answer check if it's a good one or not, display the error message if not and the question again.
     * returning the answer when it is good
     *
     * @param question the question to ask
     * @param error    the message to display in case of bad choice
     * @param min      minimum value accepted
     * @param max      maximum value accepted
     * @return an int.
     */
    public int askSomething(String question, String error, int min, int max) {
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
