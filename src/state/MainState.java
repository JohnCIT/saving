package state;

import java.io.Serializable;
import java.math.BigDecimal;

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
	
	
	private Object[][] tableContents;
	
	
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
		this.tableContents = tableContents;
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
