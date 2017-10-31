package eap.pls50.exercise1;
import java.util.Scanner;

/**
 * 
 * This program compares and returns to the user an output regarding the best choice and how many personal or family pizzas to order, 
 * based on the rate calculation totalCost/totalSurfaceOfPizzaEaten.
 * User has to provide different inputs from the keyboard regarding the number of the persons that will eat pizza, the diameter and price of personal and family pizza.
 * 
 * PLS50 Assignment 1 - Exercise 1
 * @version 0.1
 * @author Aris Angelis
 *
 */

public class Pizza {
	
	public static void main (String [] args) {
		
		/**
		 * Using Scanner class for input from Keyboard for number of persons, pizza sizes and pizza prices
		 */
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println(" Please provide the number of persons and press Enter key: ");
		int persons = keyboard.nextInt();
		
		System.out.println(" Please provide the diameter of the personal pizza and press Enter key: ");
		double atomicDiameter = keyboard.nextDouble();
		
		System.out.println(" Please provide the price of the personal pizza and press Enter key: ");
		double atomicPrice = keyboard.nextDouble();
		
		System.out.println(" Please provide the diameter of the family pizza and press Enter key: ");
		double familyDiameter = keyboard.nextDouble();
		
		System.out.println(" Please provide the price of the family pizza and press Enter key: ");
		double familyPrice = keyboard.nextDouble();
		
		keyboard.close();
		
		/**
		 * The surface of one personal pizza
		 */
		double atomicArea = Math.PI*Math.pow(0.5*atomicDiameter, 2);
		
		/**
		 * The surface of one family pizza
		 */
		double familyArea =  Math.PI*Math.pow(0.5*familyDiameter, 2);

		/**
		 * Calculation of total surface of personal pizza that will be eaten
		 */
		double totalAtomicPizzaEaten = persons*atomicArea;
		
		/**
		 * Calculation of the rate for the personal pizza
		 */
		double rateAtomic = (persons*atomicPrice)/totalAtomicPizzaEaten;
		
		/**
		 * Calculation of total surface of family pizza that will be eaten
		 */
		double totalFamilyPizzaEaten = persons*(0.5*familyArea);
		
		/**
		 * Calculation of the rate for the family pizza. We use Math.ceil method, which returns the right greater integer of its' argument, in order to calculate the number of family pizzas that will be ordered. 
		 */
		double rateFamily = (Math.ceil(0.5*persons)*familyPrice)/totalFamilyPizzaEaten;
		
		/**
		 * When the division remainder or the persons given by two is an even number, all the ordered pizza will be eaten, either personal or family ones
		 * When the division remainder or the persons given by two is an odd number, if the order is for Family pizza, then not all the family pizza will be eaten (half a family pizza will remain).
		 * When the rate for personal and family pizza are equal, a message will be printed, reading that user may order any kind of pizza since the rates are equal.
		 * An extra check was added at the end where the program checks the inputs and in case any of them are negative or zero an informative message is displayed.
		 */
		if(rateAtomic<rateFamily) {			
					System.out.println("Please order " + persons + " Personal pizzas. The Personal Pizza Price/Surface rate is " + rateAtomic + " against the Family rate which is " + rateFamily );
			}else if(rateAtomic>rateFamily){
					System.out.println("Please order " + Math.ceil(0.5*persons) + " family pizzas. The Family Pizza Price/Surface rate is " + rateFamily + " against the Personal rate which is " + rateAtomic );
				}
//		if(rateAtomic>rateFamily) {
//				System.out.println("Please order " + Math.ceil(0.5*persons) + " family pizzas. The Family Pizza Price/Surface rate is " + rateFamily + " against the Personal rate which is " + rateAtomic );
//					}else {
//						System.out.println("Please order " + persons + " personal pizzas. The Personal Pizza Price/Surface rate is " + rateAtomic + " against the Family rate which is " + rateFamily );
//					}
		if(rateAtomic==rateFamily) {
					System.out.println("Please order either " + persons + " personal pizzas or " + Math.ceil(0.5*persons) + " family pizzas. The Family and Personal Price/Surface rate is equal");
		}else if(persons<=0 || atomicDiameter<=0.0 || familyDiameter<=0.0 || atomicPrice<=0.0 || familyPrice<=0.0) {
					System.out.println("At least one of the provided values is invalid! Please run the program again and try valid values! ");
		}
	}
}



