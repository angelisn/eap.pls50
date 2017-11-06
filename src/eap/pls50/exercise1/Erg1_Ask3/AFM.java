package eap.pls50.exercise1;

import java.util.Scanner;

public class AFM {

	/**
	 * 
	 * This program reads a string input given by the keyboard , checks the length
	 * and the format to comply the official the Greek tax number (A.F.M.) rules.
	 * Then based on the tax number algorithm calculation, check whether the input
	 * is a valid Greek tax number and then asks for users input to continue or not.
	 * 
	 * PLS50 Assignment 1 - Exercise 2
	 * 
	 * @version 0.2
	 * @author Aris Angelis
	 *
	 */

	/**
	 * Method to check the input value length
	 * 
	 * @param afmInput
	 * @return
	 */
	static boolean checkLength(String afmInput) {
		if (afmInput.length() == 9) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Validity check of each character of the given string, to be a digit
	 * 
	 * @param afmInput
	 * @return
	 */
	static boolean checkDigits(String afmInput) {
		for (int i = 0; i < afmInput.length() - 1; i++) {
			while (!Character.isDigit(afmInput.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Format check of each input string. Implementation of the AFM algorithm
	 * 
	 * @param afmInput
	 * @return
	 */
	static boolean checkFormat(String afmInput) {
		double s = 0;
		double y = 0;
		for (int i = 0; (i < afmInput.length() - 1); i++) {
			/**
			 * Calculate the sum of each one of the first 8 digits of the given string,
			 * according to the given algorithm
			 */
			int nextDigit = Character.getNumericValue(afmInput.charAt(i));
			double nextTermPow = Math.pow(2, (afmInput.length() - i - 1));
			s = s + (nextDigit * nextTermPow);

			/** Calculate the remainder of the division by 11 */
			y = s % 11;

		}
		/** Find the digit at the last position of the input string */
		int digitAtLastPosition = Character.getNumericValue(afmInput.charAt(8));
		/** Implement the checks for a valid AFM */
		if ((y == 10 && digitAtLastPosition == 0) || y == digitAtLastPosition) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		boolean noError;
		Scanner keyboard = new Scanner(System.in);
		do {

			System.out.println("Please provide the Tax Number: ");
			String givenAfm = keyboard.next();
			noError = checkLength(givenAfm);

			if (noError == false) {
				System.out.println("Invalid input length! 9 digits long values are accepted");
				noError = true;
			} else {
				noError = checkDigits(givenAfm);
				if (noError == false) {
					System.out.println("Invalid input type! Only digits are allowed");
					noError = true;
				} else {
					noError = checkFormat(givenAfm);
					if (noError == false) {
						System.out.println("Invalid AFM due to format!");
						noError = true;
					} else {
						System.out.println("Valid AFM!");
						System.out.println("Would you like to continue? (Y/N): ");
						char answer = keyboard.next().charAt(0);

						if (answer == 'N' || answer == 'n') {
							System.out.println("Program terminated. Thank you!");
							noError = false;
						} else if (answer == 'Y' || answer == 'y') {
							noError = true;
						} else {
							System.out.println("Unrecognized answer! Exiting program...");
							noError = false;
						}
					}
				}
			}
		} while (noError == true);
		keyboard.close();
	}

}
