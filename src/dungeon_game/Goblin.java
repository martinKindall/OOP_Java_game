package dungeon_game;

public class Goblin extends ColoredMonster
{
	static int exp = 3;
	static Weapon club = new Club();
	static int hitpoints = 10;
	static int dodge = 0;

	public Goblin()
	{
		super(hitpoints, club, exp, dodge, "Goblin");
	}

	public String warCry()
	{
		return "I finish you!";
	}
}