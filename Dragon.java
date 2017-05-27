public class Dragon extends ColoredMonster
{
	static int exp = 5;
	static int baseAttack = 4;
	static int hitpoints = 15;

	public Dragon()
	{
		super(hitpoints, baseAttack, exp, "Dragon");
	}

	public String warCry()
	{
		return "ROOOAAAAARRR!";
	}
}