package logic;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import org.joda.time.DateTime;


/**
 * @author john
 * version 1
 */

public class Model {
	
	public Model(){}
	
		
	//Table stuff
	/**
	 * Headings for the table
	 * @return The headings for the table
	 */
	public String[] getSaveTableHeadings()
	{
		String[] headings = {"Date", "Expected", "Have"};
		return headings;
	}
	
	/**
	 * Gets the data for the table
	 * @param buttonChoice
	 * @param expected
	 * @param have
	 * @param beginDate
	 * @return
	 */
	public Object[][] dataForTable(int buttonChoice, int expected, int have, DateTime beginDate, DateTime endDate)
	{
		int size = 0;
		switch(buttonChoice)
		{
			case 1:
				size = weeks(howManydaysToReachGoalAmount(beginDate, endDate));
				break;
			
			case 2:
				break;
			
			case 3:
				break;
				
			case 4:
				break;
		}
		
		Object[][] data = new Object[size][3];
		for(int row=0; row<size; row++)
		{
			data[row][0] = beginDate;
			data[row][1] = 200;
			data[row][2] = 0;
			
			beginDate.plusWeeks(1);
		}
		
		
		return data;
	}
	
	
	
	
	
	
	//Date stuff
	/**
	 * Works out how days between begin date and the end date
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public long howManydaysToReachGoalAmount(DateTime begin, DateTime endDate)
	{		
		long daysBetween = 0;  
		while (begin.isBefore(endDate)) 
		{  
			begin.plusDays(1);  
			daysBetween++;  
		}  
		return daysBetween;  
	}
	
	
	/**
	 * Takes in the days and give the weeks
	 * @param daysBetween
	 * @return
	 */
	public int weeks(long daysBetween)
	{
		int weeks = (int) (daysBetween/7);
		return weeks;
	}

}
