package logic.combater;

import logic.weapon.Club;

public class Goblin extends ColoredMonster
{
	private static int exp = 3;
	private static int defHitpoints = 10;
	private static int dodge = 0;

	public Goblin()
	{
		this(defHitpoints);
	}

	public Goblin(int hitpoints){
		super(hitpoints, new Club(), exp, dodge, "Goblin");
	}

	public String warCry()
	{
		return "I finish you!";
	}
}