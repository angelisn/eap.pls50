package eap.pls50.exercise1;

import java.util.Scanner;

public class AFM {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/**
		 * 
		 * This program reads a string input given by the keyboard , checks the length and the format to comply the official the Greek tax number (A.F.M.) rules.
		 * Then based on the tax number algorithm calculation, check whether the input is a valid Greek tax number and then asks for users input to continue or not.  
		 * 
		 * PLS50 Assignment 1 - Exercise 2
		 * @version 0.1
		 * @author Aris Angelis
		 *
		 */
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please provide the Tax Number: ");
		String givenAfm = keyboard.next();
		double s = 0;
		double y = 0;

		/** 
		 * Input value length check 
		 */
		while(givenAfm.length() !=9){
			System.out.println("Invalid input! Please try again by providing a 9-digit long value: ");
			givenAfm = keyboard.next();
		}
		/** 
		 * Validity check of each character of the given string, to be a digit
		 */
		for(int i = 0; i < givenAfm.length()-1; i++) {		
					while(!Character.isDigit(givenAfm.charAt(i))) {
						System.out.println("Character at position " + i + " is not a digit");
						givenAfm = keyboard.next();
					}
		/**
		 * Calculate the sum of each one of the first 8 digits of the given string, according to the given algorithm 
		 */
		int nextDigit = Character.getNumericValue(givenAfm.charAt(i));
		double nextTermPow = Math.pow(2 , (givenAfm.length() - i-1));
		s = s + nextDigit * nextTermPow;			
			}
		
		/** 
		 * Calculate the remainder of the division by 11
		 */
		y = s%11;
		
		/**
		 * Get the numeric value of the character at position 9 of the input string
		 */
		int digitAtLastPosition = Character.getNumericValue(givenAfm.charAt(8));
		System.out.println("The sum is " + s + " and the remained Y= " + y + " and the last digit A9= " + digitAtLastPosition);
		
		/**
		 * Implementation of the rules regarding the remainder and the 9th digit of the string
		 */
		if((y==10 && digitAtLastPosition == 0) || y==digitAtLastPosition ) {
				System.out.println("The Tax Number that you entered is valid!");
		}else {
				System.out.println("The Tax Number you entered is NOT valid!");
		}
		
		/** 
		 * Prompt user to continue or exit via specific keyboard input
		 */
		System.out.println("Would you like to repeat the process or exit the program? Press 'r' for repeat or 'e' for exiting...");

		char answer = keyboard.next().charAt(0);
		
		if(answer=='e') {
				System.out.println("You selected to exit the program. Thank you!");					
		}else if (answer == 'r') {
		/**
		 * Call the main() in order to run the program again
		 */
			System.out.println("You selected to repeat the process.");
			AFM.main(args);
		}else if (answer != 'e' || answer != 'r') {
				System.out.println("Invalid anwser! Exiting...");
		}
		
		/** 
		 * Scanner's instance closure. No more input from the keyboard is needed.
		 */
		keyboard.close();
	}
}