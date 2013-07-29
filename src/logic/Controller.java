package logic;

/**
 * @author john
 * version 1
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigDecimal;

import org.joda.time.DateTime;

import Main.Storage;

import state.MainState;
import utill.DateConversions;
import utill.GeneralUtill;
import utill.InputChecker;
import utill.TableDataConversion;
import gui.GuiUtill;
import gui.View;

public class Controller {
	
	Model mod;
	View view;
	MainState state;
	
	public Controller(Model mod, View view, MainState state)
	{
		this.mod 	= mod;
		this.view 	= view;
		this.state	= state;
		
		//Load all the details from the state
		loadFromState();
		
		
		//Connect action listeners
		view.applyActionListener(new applyAction() );
		view.saveActionListener(new saveAction() );
		view.loadActionListener(new LoadAction() );
		view.saveTableActionListener(new SaveTableListener());
	}
	
	/**
	 * Loads the table headings
	 */
	private void loadFromState()
	{
		view.setSaveTableData(DataForTable.getSaveTableHeadings(), state.getTableContents());
		view.setData(DateConversions.convertDateTimeToDate(state.getBeginDate()), DateConversions.convertDateTimeToDate(state.getEndDate()), state.getStartingAmount(), state.getGoalAmount());
		view.setSaveTableData(DataForTable.getSaveTableHeadings(), state.getTableContents());
	}
	
	/**
	 * saves changes to the state of the program
	 */
	private void saveToState(DateTime beginDate, DateTime endDate, BigDecimal beginAmount, BigDecimal goal)
	{
		state.setBeginDate(beginDate);
		state.setEndDate(endDate);
		state.setStartingAmount(beginAmount);
		state.setGoalAmount(goal);
		state.setPaymentPeriod(view.getpaymentTimeChoice());
		state.setTableContents(TableDataConversion.getTableDataAsArray(view.getTableModel()));
	}
	
	
	
	
	
	////Action listeners//////
	/////////////////////////
	
	/**
	 * Action event for the apply button. Get all the data entered
	 * @author john
	 *
	 */
	class applyAction implements ActionListener{

		public void actionPerformed(ActionEvent e) 
		{
			BigDecimal beginAmount;
			BigDecimal goal;
			
			//Gets the dates from the GUI
			DateTime beginDate 	= DateConversions.convertDateToDateTime(view.getBeginDate());
			DateTime endDate	= DateConversions.convertDateToDateTime(view.getEndDate());	
			
			//Check the inputs are big decimal
			if(InputChecker.checkInputs(view.getStartingAmount(), view.getGoalAmount(), beginDate, endDate))
			{			
				//Get the data to store			
				beginAmount = GeneralUtill.convertStringToBigDecimal(view.getStartingAmount()); 
				goal 		= GeneralUtill.convertStringToBigDecimal(view.getGoalAmount());
				
				//Get the weeks between the two dates
				int weeks = mod.getWeeksStarting(beginDate, endDate);
				
				//Display the average amount
				view.setAverageAmount(mod.averageAmountWeekly(weeks, beginAmount, goal));
				
				//Save the table to state
				state.setTableContents(TableDataConversion.getTableDataAsArrayandSaveToHave(view.getTableModel(), state) );
				
				//Update table
				if(!state.getDoesTheUserHaveMoney()){
					view.setSaveTableData(DataForTable.getSaveTableHeadings(), DataForTable.dataForTable(beginDate, endDate, beginAmount, goal, view.getpaymentTimeChoice(), state.userHave) );
				}
				else{
					view.setSaveTableData(DataForTable.getSaveTableHeadings(), state.getTableContents());
				}
				
				
				//Save the state
				saveToState(beginDate, endDate, beginAmount, goal);			
			}			
		}
		
	}
	
	/**
	 * @author john
	 * Saves the state of the program
	 */
	class saveAction implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			Storage.saveState(state);
		}
		
	}
	
	/**
	 * Loads the state
	 * @author john
	 *
	 */
	class LoadAction implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			state = Storage.loadState();
			loadFromState();//Updates the GUI from the newly loaded state
		}
		
	}
	
	
	/**
	 * @author john
	 * Focus listener for the JTable
	 */
	class SaveTableListener implements FocusListener{

		public void focusGained(FocusEvent e) {}


		public void focusLost(FocusEvent e) {
			state.setTableContents(TableDataConversion.getTableDataAsArrayandSaveToHave(view.getTableModel(), state) );
			state.setDoesTheUserHaveMoney(true);
			System.out.println("here");
		}
		
	}
	

}
