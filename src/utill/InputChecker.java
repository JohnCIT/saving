package utill;

import gui.GuiUtill;

import org.joda.time.DateTime;

/**
 * User input and error messages are done here
 * @author john
 * @version 1
 */


public class InputChecker {
	
	public static boolean checkInputs(String startingAmount, String goalAmount, DateTime beginDate, DateTime endDate )
	{
		boolean valid = true;
		
		if(!GeneralUtill.stringToBigDecimalCheck(startingAmount)){
			GuiUtill.showError("Incorrect input", "please put in the correct in put in your starting amount");
			valid = false;
		}
		
		if(!GeneralUtill.stringToBigDecimalCheck(goalAmount)){
			GuiUtill.showError("Incorrect input", "please put in the correct in put in your goal amount");
			valid = false;
		}
		
		if(endDate.isBefore(beginDate)){
			GuiUtill.showError("Incorrect date input", "Your end date is before the start date. This is not allowed");
			valid = false;
		}
		return valid;
	}

}
