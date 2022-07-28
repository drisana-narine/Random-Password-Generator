package com.PersonalProjects;

import java.util.ArrayList;
import java.util.Scanner;

public class RandomPasswordGenerator {
    public static void main(String[] args) {
        String answer;
        do {
            //gather information from user
            Scanner keyboard = new Scanner(System.in);
            System.out.println("How many letters do you want in your password?");
            int letterAmount = keyboard.nextInt();
            System.out.println("How many numbers do you want in your password?");
            int numAmount = keyboard.nextInt();
            System.out.println("How many special Characters do you want in your password?");
            int sCAmount = keyboard.nextInt();
            System.out.println("Do you want capital letters?");
            boolean needsCaps = keyboard.next().equalsIgnoreCase("yes");
            if (needsCaps) {
                System.out.println("Your password is: " + randomCapitalization(letterPortion(letterAmount)) +
                        numberPortion(numAmount) + specialCharactersPortion(sCAmount));
            } else {
                System.out.println("Your password is: " + letterPortion(letterAmount) +
                        numberPortion(numAmount) + specialCharactersPortion(sCAmount));
            }
            System.out.println("Do you want another password?");
            answer= keyboard.next();
            System.out.println("-------------------------------------------------------------------");
        }while (answer.equalsIgnoreCase("yes"));
    }

    //put together letter portion of password
    private static String letterPortion(int n){
        String letterOptions ="abcdefghijklmnopqrstuvwxyz";
        String letters = "";
        for(int i=0;i<n;i++){
            //randomly pick special letter from options
            letters += letterOptions.charAt((int) (Math.random() * (letterOptions.length())));
        }
        return letters;
    }

    //put together number portion of password
    private static String numberPortion(int n){
        String numberOptions ="0123456789";
        String nums = "";
        for(int i=0;i<n;i++){
            //randomly pick number from options
            nums += numberOptions.charAt((int) (Math.random() * (numberOptions.length())));
        }
        return nums;
    }

    //put together special character portion of character
    private static String specialCharactersPortion(int n){
        String sCOptions = "~`!@#$%^&*()-_=+{[]}\\|:;\"'<,>.?/";
        String sC = "";
        for(int i=0;i<n;i++){
            //randomly pick special character from options
            sC += sCOptions.charAt((int) (Math.random() * (sCOptions.length())));
        }
        return sC;
    }

    //capitalizes random letters in password if necessary
    private static String randomCapitalization(String s){
        String capitalizedPassword="";
        //minimum 1 capital letter, maximum all but one
        int max = s.length();
        int min = 1;
        int times = (int) ((Math.random() * (max - min)) + min);
        ArrayList<Integer> makeCapital = new ArrayList<>();
        for(int i=0;i<times;i++){
            makeCapital.add((int) ((Math.random() * (max - min)) + min));
        }
        //capitalize letters
        for(int i=0;i<s.length();i++){
            if(makeCapital.contains(i)){
                char d = s.charAt(i);
                d = Character.toUpperCase(d);
                capitalizedPassword += d;
            }
            else
                capitalizedPassword += s.charAt(i);
        }
        return capitalizedPassword;
    }
}
