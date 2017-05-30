import java.io.*;
import java.util.*;
import java.lang.Runtime;

public class Main
{
	static Combat character;
	static List<Combat> monsters;

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

		character = CharacterFactory.create();

		monsters = new LinkedList<Combat>();
		fillWithMonsters(monsters, 1);
		fillWithGoblins(monsters, 1);
		fillWithDragons(monsters, 1);

		while(monsters.size() > 0)
		{
			currentTurn(monsters.remove(0));
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
		CombatInteraction.initAttack(currentMonster, character);
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
			case attack:	CombatInteraction.initAttack(character, currentMonster);
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
	 * [fillWithMonsters LinkedList<Combat> int -> None]
	 *
	 * effect: fills the list with the desired qty of monsters
	 * 
	 * @param monsters [description]
	 * @param qty      [description]
	 */
	public static void fillWithMonsters(List<Combat> monsters, int qty)
	{
		for (int idx=0; idx<qty; ++idx) 
		{
			monsters.add(new Monster());
		}
	}

	public static void fillWithGoblins(List<Combat> monsters, int qty)
	{
		for (int idx=0; idx<qty; ++idx) 
		{
			monsters.add(new Goblin());
		}
	}

	public static void fillWithDragons(List<Combat> monsters, int qty)
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