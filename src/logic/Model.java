package logic;
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

}
