package view;
import utils.Utils;

import java.io.*;

public class Menu
{
	public static final String attack = "a";
	public static final String heal = "h";
	public static final String quit = "q";

	/**
	 * [getMenuAction: None -> String]
	 *
	 * return a valid menu action string
	 * 
	 */
	public static String getMenuAction() throws IOException
	{
		final String[] validActions = {attack, heal, quit};
		String action = Utils.readLine("Choose [a:attack, h:heal, q:quit]? ");

		for (int idx=0; idx<validActions.length; ++idx) 
    	{
    		if (validActions[idx].equals(action))
    		{
    			return action;
    		} 
    	}

    	Utils.println("Not a valid action!");
    	return getMenuAction();
	}
}