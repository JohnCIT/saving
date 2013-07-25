package logic;

import java.util.Calendar;
import java.util.Date;


/**
 * @author john
 * version 1
 */

public class Model {
	
	public Model(){}
	
		
	
	/**
	 * Headings for the table
	 * @return The headings for the table
	 */
	public String[] getSaveTableHeadings()
	{
		String[] headings = {"Expected", "Have"};
		return headings;
	}
	
	/**
	 * Works out how many weeks between begin date and the end date
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public long howManyWeeksToReachGoalAmount(Date beginDate, Date endDate)
	{		
		Calendar begin = Calendar.getInstance();begin.setTime(beginDate); 
		long daysBetween = 0;  
		while (begin.before(endDate)) 
		{  
			begin.add(Calendar.DAY_OF_MONTH, 1);  
			daysBetween++;  
		}  
		return daysBetween/7;  
	}

}
