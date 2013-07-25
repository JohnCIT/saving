package logic;

/**
 * @author john
 * version 1
 */

import gui.View;

public class Controller {
	
	Model mod;
	View view;
	
	public Controller(Model mod, View view)
	{
		this.mod 	= mod;
		this.view 	= view;
		
		//Load the table
		loadTable();
	}
	
	/**
	 * Loads the table headings
	 */
	private void loadTable()
	{
		view.setSaveTableData(mod.getSaveTableHeadings(), null);
	}

}
