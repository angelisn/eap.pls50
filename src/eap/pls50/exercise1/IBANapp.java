package eap.pls50.exercise1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 
 * This program reads string inputs line by line from a txt file and checks whether each string complies the Greek IBAN format and algorithm rules.
 * When the input passes both format and algorithm checks, user is prompted to save the new IBAN in a new line of another output txt file 
 * 
 * PLS50 Assignment 1 - Exercise 3
 * @version 0.1
 * @author Aris Angelis
 *
 */
public class IBANapp {
	
	/**
	 * Verify the format of the IBAN line - Length to be 27, country code to be GR and BBAN part to consist of digits only
	 * */
	public static boolean checkFormat(String iban) {
		if(iban.length() == 27 && iban.startsWith("GR")) {
			 for(int i=2; i>=2 && i<=iban.length()-1; i++) {
				 while(!Character.isDigit(iban.charAt(i))) {
						System.out.println("[checkFormat] Character at position " + i + " is not a digit");
						return false;}
			 }
				 }else if ( iban.length() != 27 || !iban.startsWith("GR") ){
			return false;
			 }
			System.out.println("[checkFormat] Format of the IBAN: " + iban + " and length: " + iban.length() + " are OK");
			return true;	
	}

		

	public static void main(String[] args) throws FileNotFoundException {

				FileInputStream inFile = new FileInputStream("inIBAN.txt");
				DataInputStream in = new DataInputStream(inFile);
				BufferedReader br = new BufferedReader(new InputStreamReader(in));
				String strLine;
				/**
				 * Read from txt file line by line as long as line is not null
				 * */
				try {
					while ((strLine = br.readLine()) !=null ) {
						/**
						 * Calls checkFormat method
						 * */
						boolean format = checkFormat(strLine);
						/**
						 * Verify the format of the IBAN line - Length to be 27, country code to be GR and BBAN part to consist of digits only
						 */
						if(format == false) {
							System.out.println("Wrong format! Either length and/or country code and/or BBAN part are invalid");
						}else {
						/**
						 * Create an object of IBAN class and use the methods that this has 
						 * */
							IBAN ibanObj = new IBAN(strLine);
							boolean checkIbanResult = ibanObj.checkIBAN();
							if(checkIbanResult == false) {
								ibanObj.makeIBAN();
								String iban = ibanObj.getIBAN();
								System.out.println("The corrected IBAN is: " + iban + ". Would you like to store it? Type y or n and press enter key:");
								
								/**
								 * Use Scanner class for user's answer to store the IBAN or not
								 * */	
								
								Scanner keyboard = new Scanner(System.in);
								char answer = keyboard.next().charAt(0);
								/**
								 * In case of user's negative answer, the IBAN is discarded
								 * */
								if(answer=='n') {
										System.out.println("IBAN " +iban+ " was discarded!");
								}else if (answer == 'y') {
								/**
								 * In case of user's positive answer, the IBAN is stored in a new line of outIBAN.txt file
								 * */
									System.out.println("IBAN " +iban+ " saved!");						
										FileWriter outFile = new FileWriter("outIBAN.txt", true);
										BufferedWriter bw = new BufferedWriter(outFile);
										PrintWriter printedInFile = new PrintWriter(bw);
										printedInFile.println(iban);
										printedInFile.close();
								}else if (answer != 'y' || answer != 'n') {
										System.out.println("Invalid anwser!");
								}
								
							}							 
						}
					}
						in.close();
				}
			 catch (IOException e) {
					System.err.println("Error: " + e.getMessage());
			 }
	}			
}
