import java.io.*;
import java.util.*;
import java.lang.Runtime;

public class Main
{
	static String name;
	static String weapon;
	static int baseAttack;

	static Combat character;
	static LinkedList<Combat> monsters;

	static String menuAction;

	public static void main(String[] args) throws IOException
	{
		tests();
		game();
	}

	public static void game() throws IOException
	{
		Utils.clearScreen();
		Utils.println("Welcome to the dungeon game!");
		Utils.println("");

		getDataCharacter();
		character = new Character(baseAttack, name, weapon);

		monsters = new LinkedList<Combat>();
		fillWithMonsters(monsters, 1);
		fillWithGoblins(monsters, 1);
		fillWithDragons(monsters, 1);

		while(monsters.size() > 0)
		{
			currentTurn(monsters.poll());
		}

		Utils.println("There are no more monsters, you WIN!");
		System.exit(0);
	}

	public static void currentTurn(Combat monster) throws IOException
	{
		Combat currentMonster = monster;
		Utils.println(currentMonster.warCry() + " A " + currentMonster + " has appeared.");
		while(!currentMonster.outOfCombat())
		{
			// fase 1: accion de criatura
			monsterTurn(currentMonster);

			Utils.println("------------------------------------------");

			// fase 2: accion del jugador
			playerTurn(currentMonster);

			Utils.readLine("Press enter to continue: ");
			Utils.clearScreen();
		}

		Utils.println("You defeated " + currentMonster);
	}

	public static void monsterTurn(Combat currentMonster) throws IOException
	{
		initAttack(currentMonster, character);
	}

	public static void playerTurn(Combat currentMonster) throws IOException
	{
		if (character.outOfCombat())
		{
			Utils.println("You can't fight anymore. GAME OVER...");
			System.exit(0);
		}

		menuAction = getMenuAction();

		switch (menuAction)
		{
			case attack:	initAttack(character, currentMonster);
							break;
			case heal: 		Utils.println("You heal yourself");
							character.selfHeal();
					 		break;
			case quit: 		Utils.println("You quit the game. See you next time..");
							System.exit(0);
			default:        Utils.println("Something weird happened");
							break;
		}
	}

	/**
	 * [initAttack: Combat Combat -> None]
	 *
	 * The first combat object attacks the second
	 * if it doesnt fail
	 *
	 * effect: the second combat object may lose hitpoints
	 * 
	 */
	public static void initAttack(Combat combat1, Combat combat2)
	{
		if (!combat1.idle())
		{
			Utils.println(combat1 + " is attacking!");
			if (combat2.dodge())
			{
				Utils.println(combat2 + " dodged the attack");
			}
			else
			{
				combat2.receiveDamage(combat1.attack());
				Utils.println(combat2 + " received damage");
			}
		}
		else
		{
			Utils.println(combat1 + " didn't attack");
		}
	}


	public static final String sword = "s";
	public static final String axe = "a";
	public static final String bow = "b";

	/**
	 * [getDataCharacter: None -> None]
	 *
	 * effect: the global variables name and weapon 
	 * are assigned with the user input
	 * 
	 * @throws IOException [description]
	 */
	public static void getDataCharacter() throws IOException
	{
        final String[] validWeapons = {sword, axe, bow};
        boolean isvalid = false;

		name = Utils.readLine("Name? ");

        while(!isvalid)
        {
	        weapon = Utils.readLine("Weapon [s:sword, b:bow, a:axe]? ");

        	for (int idx=0; idx<validWeapons.length; ++idx) 
        	{
        		if (validWeapons[idx].equals(weapon))
        		{
        			isvalid = true;
	    			break;
        		} 
        	}
        	if (!isvalid) Utils.println("Not a valid weapon!");
        }

        switch (weapon)
        {
        	case axe:	baseAttack = 2;
        							break;
        	case sword:	baseAttack = 1;
					    			break;
        	case bow: 	baseAttack = 3;
        						  	break;

        	default: 				break;
        }
	}

	/**
	 * [fillWithMonsters LinkedList<Combat> int -> None]
	 *
	 * effect: fills the list with the desired qty of monsters
	 * 
	 * @param monsters [description]
	 * @param qty      [description]
	 */
	public static void fillWithMonsters(LinkedList<Combat> monsters, int qty)
	{
		for (int idx=0; idx<qty; ++idx) 
		{
			monsters.add(new Monster());
		}
	}

	public static void fillWithGoblins(LinkedList<Combat> monsters, int qty)
	{
		for (int idx=0; idx<qty; ++idx) 
		{
			monsters.add(new Goblin());
		}
	}

	public static void fillWithDragons(LinkedList<Combat> monsters, int qty)
	{
		for (int idx=0; idx<qty; ++idx) 
		{
			monsters.add(new Dragon());
		}
	}

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

	// Aca empiezan los tests
	public static void tests()
	{
		combatTest();
		characterTest();
	}

	public static void combatTest()
	{
		Combat prueba = new Monster();
		while(!prueba.outOfCombat())
		{
			prueba.receiveDamage(prueba.attack());
		}
	}

	public static void characterTest()
	{
		Combat character = new Character(3, "Martin", "sword");
		while(!character.outOfCombat())
		{
			character.receiveDamage(character.attack());
		}
	}
}