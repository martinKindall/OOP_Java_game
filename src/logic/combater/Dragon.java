package logic.combater;

import logic.weapon.DragonClaws;

public class Dragon extends ColoredMonster
{
	private static int exp = 5;
	private static int hitpoints = 15;
	private static int dodge = 7;

	public Dragon()
	{
		super(hitpoints, new DragonClaws(), exp, dodge, "Dragon");
	}

	public String warCry()
	{
		return "ROOOAAAAARRR!";
	}
}