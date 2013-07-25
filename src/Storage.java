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
		MainState state = new MainState();;
		
		return state;
	}
	
	
	public static void saveState()
	{
		
	}

}
