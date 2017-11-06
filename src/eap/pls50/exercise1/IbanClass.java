package eap.pls50.exercise1;

import java.util.Arrays;

public class IbanClass {

//	char[] grIBAN = new char[27];
//	char [] temp = new char[29];
//	
	char[] grIBAN = new char[27];
//	char[] grIBAN = {'G', 'R', '9', '2', '5', '8', '2', '7', '9', '7', '6', '7', '8', '3', '1', '2', '5', '8', '2', '7', '9', '7', '6', '7', '8', '3', '1' };
	char[] temp = new char[grIBAN.length + 2];

	public IbanClass(String ibanGR) {
		grIBAN = ibanGR.toCharArray();
//		char[] temp = new char[grIBAN.length + 2];
		System.out.println("WWWWW!");
		for (int i = 0; i < grIBAN.length; i++) {
			char a = grIBAN[i];
			//int j = i; 
			if (a == 'G') {
				temp[0] = '1';
				temp[1] = '6';
				System.out.println("AAAA1");
			} else if (a == 'R')  {
				temp[2] = '2';
				temp[3] = '7';
				System.out.println("BBBB1");
			}
			else {
				temp[i+2] = a;
				System.out.println("CCCC1!");
			}
			
		}
		
//	String value = String.copyValueOf(temp);
//	String ffinal = value.substring(6, value.length()) + value.substring(0, 6);
//	System.out.println("The IBAN after replacing the GR is: " + value);
//	System.out.println("The IBAN after  move to the end is: " + ffinal);
		
	}

	public String getIBAN() {
		String correctedDigits = makeIBAN().toString();
		String value = String.copyValueOf(temp);
		String ffinal = value.substring(6, value.length()) + value.substring(0, 6);
		System.out.println("[getIBAN] The IBAN after replacing the GR is: " + value);
		System.out.println("[getIBAN] The IBAN after  move to the end is: " + ffinal);
		
		String countryCode = "GR";
		String firstFourChars = getIBAN().substring(0, 4);
		String fixedIban = countryCode + ffinal.replace(firstFourChars, correctedDigits);
		System.out.println("The NEW CORRECTED IBAN is: " + fixedIban);
//		return temp.toString();
//		return new String(grIBAN);
		return;
	}
	
	public boolean checkIBAN() {
		String value = String.copyValueOf(temp);
		String ffinal = value.substring(6, value.length()) + value.substring(0, 6);
		System.out.println("[checkIban] The IBAN after replacing the GR is: " + value);
		System.out.println("[checkIban] The IBAN after  move to the end is: " + ffinal);

		int d;

		String firstNineChars = ffinal.substring(0, 9);
		String restChars = ffinal.substring(9, 29);
		int intOFNineFirstChars = Integer.parseInt(firstNineChars);
		d = intOFNineFirstChars % 97;
		String shorterIban = d + restChars;
		firstNineChars = shorterIban.substring(0, 9);
		intOFNineFirstChars = Integer.parseInt(firstNineChars);

		d = intOFNineFirstChars % 97;

		restChars = ffinal.substring(16, 29);

		shorterIban = d + restChars;

		firstNineChars = shorterIban.substring(0, 9);
		intOFNineFirstChars = Integer.parseInt(firstNineChars);

		d = intOFNineFirstChars % 97;

		restChars = ffinal.substring(23, 29);

		shorterIban = d + restChars;

		firstNineChars = shorterIban;
		intOFNineFirstChars = Integer.parseInt(shorterIban);

		d = intOFNineFirstChars % 97;

		if (d == 1) {
			System.out.println("CHECK IBAN RETURNED TRUE!");
			return true;
		} else {
			System.out.println("CHECK IBAN RETURNED FALSE!");
			return false;

		}

	}

	public String makeIBAN() {
		String value = String.copyValueOf(temp);
		String ffinal = value.substring(6, value.length()) + value.substring(0, 6);
		System.out.println("[makeIban] The IBAN after replacing the GR is: " + value);
		System.out.println("[makeIban] The IBAN after  move to the end is: " + ffinal);


		int d;

		String firstNineChars = ffinal.substring(0, 9);
		String restChars = ffinal.substring(9, 29);
		int intOFNineFirstChars = Integer.parseInt(firstNineChars);
		d = intOFNineFirstChars % 97;
		String shorterIban = d + restChars;
		firstNineChars = shorterIban.substring(0, 9);
		intOFNineFirstChars = Integer.parseInt(firstNineChars);

		d = intOFNineFirstChars % 97;

		restChars = ffinal.substring(16, 29);

		shorterIban = d + restChars;

		firstNineChars = shorterIban.substring(0, 9);
		intOFNineFirstChars = Integer.parseInt(firstNineChars);

		d = intOFNineFirstChars % 97;

		restChars = ffinal.substring(23, 29);

		shorterIban = d + restChars;

		firstNineChars = shorterIban;
		intOFNineFirstChars = Integer.parseInt(shorterIban);

		d = intOFNineFirstChars % 97;
		System.out.println("LAST D IS: " + d);

		int finalDD = 98 - d;
		System.out.println("after last afairesh IS: " + finalDD);
		String finalDDstr = Integer.toString(finalDD);


		return finalDDstr;

	}

}
