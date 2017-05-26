public class Main
{
	public static void main(String[] args)
	{
		Combat character = new Character("Martin", "sword", 3);
		Combat troll = new Monster(5, 1, "Troll");

		while(!character.outOfCombat() && !troll.outOfCombat())
		{
			// turno ficticio 1 fase 1: accion de criatura
			if (!troll.idle())
			{
				System.out.println(troll + " is attacking!");
				if (character.dodge())
				{
					System.out.println("You dodged the attack");
				}
				else
				{
					character.receiveDamage(troll.attack());
					System.out.println(character + " received damage");
				}
			}
			else
			{
				System.out.println(troll + " didn't attack");
			}

			// turno ficticio 1 fase 2: accion del personaje
			if (!character.idle())
			{
				System.out.println(character + " is attacking!");
				if (troll.dodge())
				{
					System.out.println(troll + " dodged the attack");
				}
				else
				{
					troll.receiveDamage(character.attack());
					System.out.println(troll + " received damage");
				}
			}
			else
			{
				System.out.println(character + " didn't attack");
			}
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
}