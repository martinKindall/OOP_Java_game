package logic.interaction;

import logic.combater.Combater;
import utils.Utils;

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
	public static void initAttack(Combater combat1, Combater combat2)
	{
		if (!combat1.idle())
		{
			combat1.attack(combat2);

			Utils.println(combat1 + " is attacking!");
			if (combat2.dodge())
			{
				Utils.println(combat2 + " dodged the attack");
			}
			else
			{
				Utils.println(combat2 + " received damage");
			}
		}
		else
		{
			Utils.println(combat1 + " didn't attack");
		}
	}
}