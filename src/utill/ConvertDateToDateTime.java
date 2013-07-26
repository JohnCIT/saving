package utill;
/**
 * Converts Date to date time
 * @author john
 * @version 1
 */

import java.util.Date;

import org.joda.time.DateTime;

public class ConvertDateToDateTime {
	
	public static DateTime convertDateToDateTime(Date date)
	{
		DateTime dateTime = new DateTime(date);		
		return dateTime;
	}

}
