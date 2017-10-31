package eap.pls50.exercise1;

public class IBAN {
	
	/**
	 * Char array instance variable with Greek IBAN format
	 * */
	char[] grIBAN = {'G', 'R', '1' , '6', 23};
	
	/**
	 * Constructor with string argument
	 * */
	public IBAN(String givenIban){
		grIBAN = givenIban.toCharArray();
	}
	
	/**
	 * Convert the grIBAN char array type to string
	 * */
	public String getIBAN(){
		return new String(grIBAN);
	}
	
	
	/**
	 * Verify the check digits (DD) and return true for Greek DD code (16) 
	 * */
	public boolean checkIBAN(){
	if(grIBAN[2] != '1' || grIBAN[3] != '6' )
		{
			System.out.println("[checkIBAN] Invalid Greek IBAN | Check Digits (DD)=" + getIBAN().substring(2, 4));
			return false;
		
		} else {
			System.out.println("[checkIBAN] Valid Greek IBAN | Check Digits (DD)=" + getIBAN().substring(2, 4));
			return true;

		}	
	}
	

	/**
	 * Replace the check digits with the correct ones in order to create the Greek DD code (16)
	 * */
	public void makeIBAN(){
	if(getIBAN().substring(2, 4) != "16")
	{
		System.out.println("[makeIBAN] Correcting the Check Digits (DD) to match 16... ");
		grIBAN[2] = '1';
		grIBAN[3] = '6';
	} 
}

}






