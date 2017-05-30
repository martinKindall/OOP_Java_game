public class CombatInteraction
{
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
}