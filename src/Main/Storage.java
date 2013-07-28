package Main;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import state.MainState;

/**
 * Saves and loads all data here
 * @author john
 *
 */
public class Storage {
	
	/**
	 * Loads the state of the program
	 * @return The state
	 */
	public static MainState loadState()
	{
		MainState state = new MainState();
		try
	      {
	         FileInputStream fileIn = new FileInputStream("Budget.txt");
	         ObjectInputStream in   = new ObjectInputStream(fileIn);
	         state                	=  (MainState) in.readObject();
	         in.close();
	         fileIn.close();
	      }catch(IOException i)
	      {
	         i.printStackTrace();
	         return state;
	       
	      }catch(ClassNotFoundException c)
	      {
	         c.printStackTrace();
	       
	      }
	
		return state;
	}
	
	
	public static void saveState(MainState state)
	{
		try
	      {
	         FileOutputStream fileOut = new FileOutputStream("Budget.txt");
	         ObjectOutputStream out   = new ObjectOutputStream(fileOut);
	         out.writeObject(state);
	         out.close();
	         fileOut.close();
	      }catch(IOException i)
	      {
	          i.printStackTrace();
	      }
	}

}
