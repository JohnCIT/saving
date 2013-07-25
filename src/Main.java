
import state.MainState;
import gui.GuiUtill;
import gui.View;
import logic.Controller;
import logic.DataForTable;
import logic.Model;


public class Main {
	
	public static void main (String[] args)
	{
		//Set native style must be called first
		GuiUtill.setNativeGui();
		
		//Get the main state
		MainState state = Storage.loadState();
		
		//Load core program
		Model mod 		= new Model();
		View view 		= new View();
		Controller cont = new Controller(mod, view, state);	
		DataForTable tab = new DataForTable(view);
	}

}
