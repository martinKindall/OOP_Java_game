public class Monster extends Fighter
{
	public Monster()
	{
		super(10, 1, "Monster");
	}

	protected Monster(int hitpoints, int baseAttack, String name)
	{
		super(hitpoints, baseAttack, name);
	}

	public String warCry()
	{
		return "GROAAAR!";
	}
}