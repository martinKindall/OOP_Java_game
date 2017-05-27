public class Character extends Fighter
{
	String weapon;

	static int exp = 0;
	static int hitpoints = 30;
	static int dodge = 8;

	public Character(int baseAttack, String name, String weapon)
	{
		super(hitpoints, baseAttack, exp, dodge, name);
		this.weapon = weapon;

		assert weapon.length() > 0 && this.exp >= 0;
	}

	public String toString()
	{
		return super.toString() + " EXP:" + this.exp + " W:" + this.weapon;
	}

	public void selfHeal()
	{
		super.hitpoints += 3;
	}
}