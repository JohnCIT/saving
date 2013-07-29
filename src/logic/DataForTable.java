package logic;

import java.math.BigDecimal;
import java.text.Format;
import java.util.ArrayList;
import java.util.Formatter;

import gui.View;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import state.MainState;

/**
 * Gets the data for the table
 * @author john
 * @version 1
 *
 */

public class DataForTable {
	

	//Table stuff
	/**
	 * Headings for the table
	 * @return The headings for the table
	 */
	public static String[] getSaveTableHeadings()
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
	public static Object[][] dataForTable(DateTime beginDate, DateTime endDate, BigDecimal startingAmount, BigDecimal goal, int buttonChoice, ArrayList<BigDecimal> have)
	{
		int size = 0;
		Object[][] data = null;
		Model mod = new Model();
		
		
		switch(buttonChoice)
		{
			case 1:
				size 				= Model.weeks(Model.howManydaysToReachGoalAmount(beginDate, endDate));
				BigDecimal average 	= mod.averageAmountWeekly(size, startingAmount, goal);
				
				data = new Object[size][3];
				
				for(int row=0; row<size; row++)
				{
					DateTimeFormatter fmt = DateTimeFormat.forPattern("dd, MMMM, yyyy");
					String dateFormat = fmt.print(beginDate);
					
					data[row][0] = dateFormat; 
					data[row][1] = startingAmount.add(average);					
					if(have.size() == 0){
						data[row][2] = 0;
					}
					else{
						data[row][2] = have.get(row);
					}
									

					beginDate = beginDate.plusWeeks(1);
					startingAmount = startingAmount.add(average);
				}
				break;

			case 2:
				break;

			case 3:
				break;

			case 4:
				break;
		}

		


		return data;
	}

}
