package dungeon_game;
import java.io.IOException;
import java.util.List;

public class Main
{
	static Combater character;
	static List<Combater> monsters;

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
		monsters = MonsterFactory.create(1, 1, 1);

		while(monsters.size() > 0)
		{
			currentTurn(monsters.remove(0));
		}

		Utils.println("There are no more monsters, you WIN!");
		System.exit(0);
	}

	public static void currentTurn(Combater monster) throws IOException
	{
		Combater currentMonster = monster;
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

	public static void monsterTurn(Combater currentMonster) throws IOException
	{
		CombatInteraction.initAttack(currentMonster, character);
	}

	public static void playerTurn(Combater currentMonster) throws IOException
	{
		if (character.outOfCombat())
		{
			Utils.println("You can't fight anymore. GAME OVER...");
			System.exit(0);
		}

		menuAction = Menu.getMenuAction();

		switch (menuAction)
		{
			case Menu.attack:	CombatInteraction.initAttack(character, currentMonster);
								break;
			case Menu.heal: 	Utils.println("You heal yourself");
								character.selfHeal();
					 			break;
			case Menu.quit: 	Utils.println("You quit the game. See you next time..");
								System.exit(0);
			default:        	Utils.println("Something weird happened");
								break;
		}
	}


	// Aca empiezan los tests
	public static void tests()
	{
		combatTest();
		characterTest();
	}

	public static void combatTest()
	{
		Combater prueba = new Goblin();
		while(!prueba.outOfCombat())
		{
			prueba.attack(prueba);
		}
	}

	public static void characterTest()
	{
		Weapon sword = new Sword();
		Combater character = new Player("Martin", sword);
		while(!character.outOfCombat())
		{
			character.attack(character);
		}
	}
}