public class Main
{
	public static void main(String[] args)
	{
		tests();
		// game();
	}

	public static void game()
	{
		Combat character = new Character(3, "Martin", "sword");
		Combat troll = new Monster();

		System.out.println(troll.warCry() + " A " + troll + " has appeared.");

		while(!character.outOfCombat() && !troll.outOfCombat())
		{
			// turno ficticio 1 fase 1: accion de criatura
			initAttack(troll, character);

			// turno ficticio 1 fase 2: accion del personaje
			initAttack(character, troll);
		}

		if (character.outOfCombat())
		{
			System.out.println("You can't fight anymore. GAME OVER...");
		}
		else
		{
			System.out.println("You defeated the monster. You win!!!");
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
			System.out.println(combat1 + " is attacking!");
			if (combat2.dodge())
			{
				System.out.println(combat2 + " dodged the attack");
			}
			else
			{
				combat2.receiveDamage(combat1.attack());
				System.out.println(combat2 + " received damage");
			}
		}
		else
		{
			System.out.println(combat1 + " didn't attack");
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