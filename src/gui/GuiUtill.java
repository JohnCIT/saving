package gui;

import javax.swing.JOptionPane;
import javax.swing.UIManager;


/**
 * 
 * @author john
 * version 1
 */
public class GuiUtill {
	
	public static void setNativeGui()
	{
		try 
		{
	        // Set System L&F
			UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName() );
	    } 
		catch (Exception e) {
				e.printStackTrace();		
		}
	}
	
	
	
	/**
	 * Show a modal error dialogue.
	 * @param title
	 * @param message
	 */
	public static void showError(String title, String message) 
	{
		JOptionPane.showMessageDialog(View.currentInstance, message, title, JOptionPane.ERROR_MESSAGE);
	}

	
}