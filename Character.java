public class Character extends Fighter
{
	int exp;
	String weapon;

	public Character(String name, String weapon, int baseAttack)
	{
		super(10, baseAttack, name);
		this.weapon = weapon;
		this.exp = 0;
	}
}