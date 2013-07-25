package utill;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * A general utill
 * @author john
 * version 1
 */

public class GeneralUtill {
	
	/**
	 * Checks if the passed in input is a big decimal
	 * @param check String to check
	 * @return Returns true if the the string is a big decimal
	 */
	public static boolean stringToBigDecimalCheck(String check)
	{
		Scanner input = new Scanner(check);
		
		if(input.hasNextBigDecimal())
		{
			return true;
		}
		
		return false;
	}
	
	
	public static BigDecimal convertStringToBigDecimal(String amount)
	{
		return new BigDecimal(amount);
	}

}
