public class Dragon extends ColoredMonster
{
	static int exp = 5;
	static int baseAttack = 4;
	static int hitpoints = 15;
	static int dodge = 7;

	public Dragon()
	{
		super(hitpoints, baseAttack, exp, dodge, "Dragon");
	}

	public String warCry()
	{
		return "ROOOAAAAARRR!";
	}
}