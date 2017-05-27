public class Monster extends Fighter
{
	static int exp = 1;
	static int baseAttack = 1;
	static int hitpoints = 1;

	public Monster()
	{
		super(hitpoints, baseAttack, exp, "Monster");
	}

	protected Monster(int hitpoints, int baseAttack, int exp, String name)
	{
		super(hitpoints, baseAttack, exp, name);
	}

	public String warCry()
	{
		return "GROAAAR!";
	}
}