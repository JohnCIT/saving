package logic;

/**
 * @author john
 * version 1
 */

import state.MainState;
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
		
		//Load the table
		loadFromState();
	}
	
	/**
	 * Loads the table headings
	 */
	private void loadFromState()
	{
		view.setSaveTableData(DataForTable.getSaveTableHeadings(), state.getTableContents());
	}
	
	/**
	 * saves changes to the state of the program
	 */
	private void saveToState()
	{
		
	}

}
