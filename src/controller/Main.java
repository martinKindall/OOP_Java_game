package controller;
import logic.combater.Combater;
import logic.interaction.CombatInteraction;
import utils.Utils;
import view.CharacterFactory;
import view.Menu;

import java.io.IOException;
import java.util.List;

public class Main
{
	private static Combater character;

	public static void main(String[] args) throws IOException
	{
		game();
	}

	private static void game() throws IOException
	{
		Utils.clearScreen();
		Utils.println("Welcome to the dungeon game!");
		Utils.println("");

		character = CharacterFactory.create();
		List<Combater> monsters = MonsterFactory.create(1, 1);

		while(monsters.size() > 0)
		{
			currentTurn(monsters.remove(0));
		}

		Utils.println("There are no more monsters, you WIN!");
		System.exit(0);
	}

	private static void currentTurn(Combater currentMonster) throws IOException
	{
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

	private static void monsterTurn(Combater currentMonster) throws IOException
	{
		CombatInteraction.initAttack(currentMonster, character);
	}

	private static void playerTurn(Combater currentMonster) throws IOException
	{
		if (character.outOfCombat())
		{
			Utils.println("You can't fight anymore. GAME OVER...");
			System.exit(0);
		}

		String menuAction = Menu.getMenuAction();

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
}