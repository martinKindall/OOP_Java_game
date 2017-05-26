public class Monster extends Fighter
{
	public Monster(int hitpoints, int baseAttack, String name)
	{
		super(hitpoints, baseAttack, name);
	}

	public String warCry()
	{
		return "GROAAAR";
	}
}