package com.Lectures;/*This is a program that takes input of a number between 1 and 999,999,999. It then checks to see if the input is a number palindrome or not*/

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        String pattern = "^[0-9]{1,9}$";
        String alphaPattern = "^.*[a-zA-Z].*$";
        String numberPattern = "^[0-9]+$";
        String userInput;
        int maxRange = 999999999;

        do {
            userInput = JOptionPane.showInputDialog(null, "Input a number between 1 and 9 digits long");
            //1.Error if no input
            if (userInput.equals("")) {
                JOptionPane.showConfirmDialog(null, "No input given.");
            }
            //2.incorrect format
            else if (userInput.matches(alphaPattern)) {
                JOptionPane.showConfirmDialog(null, "No alphabetical characters allowed");
            }
            //3.out of range
            else if (userInput.matches(numberPattern) && Long.parseLong(userInput) > maxRange) {
                JOptionPane.showConfirmDialog(null, "Input number is too large. Max number is 999,999,999.");
            }
            //if the user input matches the Regex pattern, the conditions of the if statement are met;
            else if (userInput.matches(pattern)) {
                //the isPalindrome method is passed an int and returns a boolean
                int number = Integer.parseInt(userInput);
                if (isPalindrome(userInput)) {
                    JOptionPane.showConfirmDialog(null, "It's a palendrome.");
                } else {
                    JOptionPane.showConfirmDialog(null, "It's NOT a palendrome!");
                }
            } else {
                JOptionPane.showConfirmDialog(null, "Incorrect format");
            }

            userInput = JOptionPane.showInputDialog(null, "Check another number? Y/N");
        }while(userInput.equalsIgnoreCase("Y"));


    }

    //isPalindrome method compares characters at the beginning and end of a string to check it's a palindrome
    public static boolean isPalindrome(String palindrome){
        char beginning, end;
        for(int i = 0, n = palindrome.length()-1; i < palindrome.length(); i++, n--){

            //beginning holds the ith character of the string, while end holds the nth character
            beginning = palindrome.charAt(i);
            end = palindrome.charAt(n);

            //if i is ever greater than n, it must be a palindrome, because if they were not equal
            //that means it's not a palindrome and the method would have returned false
            if(i > n){
                return true;
            }

            if(end != beginning){
                return false;
            }

        }
        return true;
    }
}
