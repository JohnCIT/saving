package utill;
/**
 * Converts Date to date time and back
 * @author john
 * @version 1
 */

import java.util.Date;

import org.joda.time.DateTime;

public class DateConversions {
	
	public static DateTime convertDateToDateTime(Date date)
	{
		DateTime dateTime = new DateTime(date);		
		return dateTime;
	}
	
	public static Date convertDateTimeToDate(DateTime date)
	{
		Date newDate = date.toDate();		
		return newDate;
	}
	
	

}
