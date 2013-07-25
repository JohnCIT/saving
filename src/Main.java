
import gui.GuiUtill;
import gui.View;
import logic.Controller;
import logic.Model;


public class Main {
	
	public static void main (String[] args)
	{
		//Set native style must be called first
		GuiUtill.setNativeGui();
		
		//Load core program
		Model mod 		= new Model();
		View view 		= new View();
		Controller cont = new Controller(mod, view);		
	}

}
