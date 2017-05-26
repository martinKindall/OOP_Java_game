public abstract class Fighter implements Combat
{
	int hitpoints;
	int baseAttack;
	String name;

	Fighter(int hitpoints, int baseAttack, String name)
	{
		this.hitpoints = hitpoints;
		this.baseAttack = baseAttack;
		this.name = name;
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
		return false;
	}

	public boolean outOfCombat()
	{
		return this.hitpoints <= 0;
	}

	public boolean idle()
	{
		return false;
	}

	public String warCry()
	{
		return "";
	}

	public String toString()
	{
		return this.name + " HP:" + this.hitpoints;
	}
}