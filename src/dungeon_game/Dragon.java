package dungeon_game;

public class Dragon extends ColoredMonster
{
	static int exp = 5;
	static Weapon dragonClaws = new DragonClaws();
	static int hitpoints = 15;
	static int dodge = 7;

	public Dragon()
	{
		super(hitpoints, dragonClaws, exp, dodge, "Dragon");
	}

	public String warCry()
	{
		return "ROOOAAAAARRR!";
	}
}