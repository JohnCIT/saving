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
		loadTable();
	}
	
	/**
	 * Loads the table headings
	 */
	private void loadTable()
	{
		view.setSaveTableData(mod.getSaveTableHeadings(), state.getTableContents());
	}

}
