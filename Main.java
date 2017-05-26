public class Main
{
	public static void main(String[] args)
	{
		Combat character = new Character("Martin", "sword", 3);
		Combat troll = new Monster(5, 1, "Troll");

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
	}
}