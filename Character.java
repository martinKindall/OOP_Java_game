public class Character extends Fighter
{
	int exp;
	String weapon;

	public Character(int baseAttack, String name, String weapon)
	{
		super(30, baseAttack, name);
		this.weapon = weapon;
		this.exp = 0;

		assert weapon.length() > 0 && this.exp >= 0;
	}

	public String toString()
	{
		return super.toString() + " EXP:" + this.exp + " W:" + this.weapon;
	}
}