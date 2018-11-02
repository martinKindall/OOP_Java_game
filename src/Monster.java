public class Monster extends Fighter
{
	static int exp = 1;
	static int baseAttack = 1;
	static int hitpoints = 10;
	static int dodge = 8;

	public Monster()
	{
		super(hitpoints, baseAttack, exp, dodge, "Monster");
	}

	protected Monster(int hitpoints, int baseAttack, int exp, int dodge, String name)
	{
		super(hitpoints, baseAttack, exp, dodge, name);
	}

	public boolean idle()
	{
		return Utils.random(0, 9) > 7;
	}

	public String warCry()
	{
		return "GROAAAR!";
	}
}