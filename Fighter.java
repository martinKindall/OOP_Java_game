public abstract class Fighter implements Combat
{
	int hitpoints;
	int baseAttack;
	int exp;
	String name;

	Fighter(int hitpoints, int baseAttack, int exp, String name)
	{
		this.hitpoints = hitpoints;
		this.baseAttack = baseAttack;
		this.exp = exp;
		this.name = name;
		
		assert hitpoints > 0 && name.length() > 0 && baseAttack > 0;
	}

	public int attack()
	{
		return this.baseAttack;
	}

	public void receiveDamage(int dmg)
	{
		this.hitpoints -= dmg;
		if (this.hitpoints < 0) this.hitpoints = 0;
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

	public void gainExp(int exp)
	{
		this.exp += exp;
	}

	public int getExp()
	{
		return this.exp;
	}

	public String toString()
	{
		return this.name + " HP:" + this.hitpoints;
	}
}