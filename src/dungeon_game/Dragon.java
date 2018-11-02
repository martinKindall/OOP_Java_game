package dungeon_game;

public class Dragon extends ColoredMonster
{
	static int exp = 5;
	static int hitpoints = 15;
	static int dodge = 7;

	public Dragon()
	{
		super(hitpoints, new DragonClaws(), exp, dodge, "Dragon");
	}

	public String warCry()
	{
		return "ROOOAAAAARRR!";
	}
}