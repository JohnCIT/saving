package gui;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 * 
 * @author john
 * @version 1
 */

public class IconLoader
{
	private static ArrayList<Image> icons;
		
	/**
	 *Loads the icons
	 */
	public static ArrayList<Image> getIcons()
	{
		if (icons == null) 
		{
			icons = new ArrayList<Image>();
			icons.add( new ImageIcon( "images/iconSmall.png" ).getImage() );
			icons.add( new ImageIcon( "images/iconMed.png" ).getImage() );
		}
		
		return icons;
	}
	
}