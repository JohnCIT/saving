package logic;
import java.math.BigDecimal;

import org.joda.time.DateTime;




/**
 * @author john
 * @version 1
 */

public class Model {
	
	public Model(){}
	
	//Date stuff
	/**
	 * Works out how days between begin date and the end date
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public static long howManydaysToReachGoalAmount(DateTime begin, DateTime endDate)
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
	public static int weeks(long daysBetween)
	{
		int weeks = (int) (daysBetween/7);
		return weeks;
	}
	
	
	/**
	 * Gets the average needed to meet the goal
	 * @param weeks
	 * @param startingAmount
	 * @param goal
	 * @return
	 */
	public static BigDecimal averageAmountWeekly(int weeks, BigDecimal startingAmount, BigDecimal goal)
	{
		BigDecimal average = goal.subtract(startingAmount);
		average = average.divide(new BigDecimal(weeks));
		return average;
	}

}
