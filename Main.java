public class Main
{
	public static void main(String[] args)
	{
		tests();

		Combat character = new Character("Martin", "sword", 3);
		Combat troll = new Monster(5, 1, "Troll");

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
	}

	public static void combatTest()
	{
		Combat prueba = new Monster(1, 1, "prueba");
		prueba.receiveDamage(prueba.attack());
		assert prueba.outOfCombat();

		// tiene 2 hp y solo hace 1 de dmg, no debe morir
		Combat prueba2 = new Monster(2, 1, "prueba2");
		prueba2.receiveDamage(prueba2.attack());
		assert !prueba2.outOfCombat();
	}
}