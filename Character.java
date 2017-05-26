public class Character implements Combat
{
	int hitpoints;
	int baseAttack;
	int exp;
	String name;
	String weapon;

	public Character(String name, String weapon, int baseAttack)
	{
		this.name = name;
		this.weapon = weapon;
		this.baseAttack = baseAttack;
		this.hitpoints = 10;
		this.exp = 0;
	}

	public int attack()
	{
		return this.baseAttack;
	}

	public void receiveDamage(int dmg)
	{
		this.hitpoints -= dmg;
	}

	public boolean dodge()
	{
		return true;
	}

	public boolean outOfCombat()
	{
		return this.hitpoints <= 0;
	}

	public void idle(){
		this.baseAttack = 0;
	}   // not used yet
}