package logic;

import gui.View;

import org.joda.time.DateTime;

/**
 * Gets the data for the table
 * @author john
 * @version 1
 *
 */

public class DataForTable {
	View view;
	
	public DataForTable(View view)
	{
		this.view = view;
	}

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
	public Object[][] dataForTable(int expected, int have, DateTime beginDate, DateTime endDate)
	{
		int size = 0;
		int buttonChoice = view.getpaymentTimeChoice();
		
		switch(buttonChoice)
		{
			case 1:
				size = Model.weeks(Model.howManydaysToReachGoalAmount(beginDate, endDate));
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

}
