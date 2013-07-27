package logic;
import java.math.BigDecimal;
import java.math.RoundingMode;

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
			begin = begin.plusDays(1);
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
	public BigDecimal averageAmountWeekly(int weeks, BigDecimal startingAmount, BigDecimal goal)
	{
		BigDecimal average = goal.subtract(startingAmount);
		average.setScale(2);
		average = average.divide(new BigDecimal(weeks), RoundingMode.HALF_UP);
		return average;
	}
	
	/**
	 *get the weeks between begin date and end date 
	 */
	public int getWeeksStarting(DateTime begin, DateTime end)
	{
		long days = howManydaysToReachGoalAmount(begin, end);
		return weeks(days);
		
	}

}
