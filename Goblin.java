public class Goblin extends ColoredMonster
{
	static int exp = 3;
	static int baseAttack = 3;
	static int hitpoints = 10;

	public Goblin()
	{
		super(hitpoints, baseAttack, exp, "Goblin");
	}

	public String warCry()
	{
		return "I finish you!";
	}
}