package state;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;

import org.joda.time.DateTime;

/**
 * Stores the main state of the program
 * @author john
 * version 1
 *
 */

public class MainState implements Serializable{
	private DateTime 	beginDate 		= new DateTime();
	private DateTime 	endDate			= new DateTime();
	private BigDecimal 	startingAmount 	= new BigDecimal(0);
	private BigDecimal	goalAmount		= new BigDecimal(0);
	private int 		paymentPeriod = 0;
	private boolean		doesTheUserHaveMoney = false;
	
	ArrayList<BigDecimal> have = new ArrayList<BigDecimal>();
	
	
	private Object[][] tableContents;
	public ArrayList<BigDecimal> userHave = new ArrayList<BigDecimal>();
	
	
	public MainState(){}
	
	public MainState(DateTime beginDate, DateTime endDate, BigDecimal startingAmount, BigDecimal goalAmount, int paymentPeriod, Object[][] tableContents)
	{
		this.beginDate 		= beginDate;
		this.endDate		= endDate;
		this.startingAmount = startingAmount;
		this.goalAmount 	= goalAmount;
		this.paymentPeriod 	= paymentPeriod;
		this.tableContents 	= tableContents;
	}

	

	//Setters
	public void setBeginDate(DateTime beginDate) 
	{
		this.beginDate = beginDate;
	}
	
	public void setEndDate(DateTime endDate) 
	{
		this.endDate = endDate;
	}
	
	public void setStartingAmount(BigDecimal startingAmount) 
	{
		this.startingAmount = startingAmount;
	}
	
	public void setGoalAmount(BigDecimal goalAmount) 
	{
		this.goalAmount = goalAmount;
	}

	public void setTableContents(Object[][] tableContents)
	{
		int outer = 0;
		int inner = 0;
		//Get how big each section of the array is
		for(int i=0; i<tableContents.length; i++)
		{
			outer ++;
			for (int j=0; j<tableContents[i].length; j++)
			{
				inner ++;
			}
		}
		
		//Make a new array and copy the data to the new one
		this.tableContents = new Object[outer][inner];
		
		for(int i=0; i<tableContents.length; i++)
		{
			for (int j=0; j<tableContents[i].length; j++)
			{
				this.tableContents[i][j] = tableContents[i][j];
			}
		}
		
	}

	public void setPaymentPeriod(int paymentPeriod) 
	{
		this.paymentPeriod = paymentPeriod;
	}
	
	public void setDoesTheUserHaveMoney(boolean doesTheUserHaveMoney) {
		this.doesTheUserHaveMoney = doesTheUserHaveMoney;
	}

	
	//Getters
	public DateTime getBeginDate() 
	{
		return beginDate;
	}
	
	public DateTime getEndDate() 
	{
		return endDate;
	}
	
	public BigDecimal getStartingAmount() 
	{
		return startingAmount;
	}	
	
	public BigDecimal getGoalAmount() 
	{
		return goalAmount;
	}
	
	public Object[][] getTableContents() 
	{
		return tableContents;
	}
	
	public int getPaymentPeriod() 
	{
		return paymentPeriod;
	}

	public boolean getDoesTheUserHaveMoney() {
		return doesTheUserHaveMoney;
	}

	
	

}
