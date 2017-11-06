package eap.pls50.exercise1;

public class IBAN {

	/**
	 * Char array instance variable with Greek IBAN format
	 */
	char[] grIBAN = new char[27];
	String iban;

	/**
	 * Constructor with string argument
	 */
	public IBAN(String givenIban) {
		grIBAN = givenIban.toCharArray();
	}

	/**
	 * Convert the grIBAN char array type to string
	 */
	public String getIBAN() {
		return new String(grIBAN);
	}

	/**
	 * Verify the check digits (DD) and return true for Greek DD code
	 */
	public boolean checkIBAN() {

		iban = getIBAN().replace(getIBAN().substring(0, 2), "1627");
		iban = (iban.replace(iban.substring(0, 6), "") + iban.substring(0, 6)).trim();

		int d;

		String firstNineChars = iban.substring(0, 9);
		String restChars = iban.substring(9, 29);
		int intOFNineFirstChars = Integer.parseInt(firstNineChars);
		d = intOFNineFirstChars % 97;
		String shorterIban = d + restChars;
		firstNineChars = shorterIban.substring(0, 9);
		intOFNineFirstChars = Integer.parseInt(firstNineChars);

		d = intOFNineFirstChars % 97;

		restChars = iban.substring(16, 29);

		shorterIban = d + restChars;

		firstNineChars = shorterIban.substring(0, 9);
		intOFNineFirstChars = Integer.parseInt(firstNineChars);

		d = intOFNineFirstChars % 97;

		restChars = iban.substring(23, 29);

		shorterIban = d + restChars;

		firstNineChars = shorterIban;
		intOFNineFirstChars = Integer.parseInt(shorterIban);

		d = intOFNineFirstChars % 97;

		if (d == 1) {
			return true;
		} else {
			return false;

		}

	}

	public String getFixedIban() {
		return makeIBAN();
	}


	public String makeIBAN() {
		String input = getIBAN();
		iban = getIBAN().replace(getIBAN().substring(0, 4), "162700");
		iban = (iban.replace(iban.substring(0, 6), "") + iban.substring(0, 6)).trim();

		int d;

		String firstNineChars = iban.substring(0, 9);
		String restChars = iban.substring(9, 29);
		int intOFNineFirstChars = Integer.parseInt(firstNineChars);
		d = intOFNineFirstChars % 97;
		String shorterIban = d + restChars;
		firstNineChars = shorterIban.substring(0, 9);
		intOFNineFirstChars = Integer.parseInt(firstNineChars);

		d = intOFNineFirstChars % 97;

		restChars = iban.substring(16, 29);

		shorterIban = d + restChars;

		firstNineChars = shorterIban.substring(0, 9);
		intOFNineFirstChars = Integer.parseInt(firstNineChars);

		d = intOFNineFirstChars % 97;

		restChars = iban.substring(23, 29);

		shorterIban = d + restChars;

		firstNineChars = shorterIban;
		intOFNineFirstChars = Integer.parseInt(shorterIban);

		d = intOFNineFirstChars % 97;

		int finalDD = 98 - d;

		String finalDDstr = Integer.toString(finalDD);
		String countryCode = "GR";
		String firstFourChars = getIBAN().substring(0, 4);
		String fixedIban = countryCode + input.replace(firstFourChars, finalDDstr);

		return fixedIban;

	}

}
