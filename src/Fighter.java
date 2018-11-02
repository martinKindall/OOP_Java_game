public abstract class Fighter implements Combat
{
	int hitpoints;
	int baseAttack;
	int exp;
	String name;
	int dodge;

	Fighter(int hitpoints, int baseAttack, int exp, int dodge, String name)
	{
		this.hitpoints = hitpoints;
		this.baseAttack = baseAttack;
		this.exp = exp;
		this.dodge = dodge;
		this.name = name;
		
		assert hitpoints > 0 && name.length() > 0 && baseAttack > 0;
	}

	public int attack()
	{
		return this.baseAttack;
	}

	public void receiveDamage(Combater combater)
	{
		if (!dodge()){
			this.hitpoints -= combater.getAttack();
			if (this.hitpoints < 0) this.hitpoints = 0;
		}
	}

	public boolean dodge()
	{
		return Utils.random(0, 9) > this.dodge;
	}

	public boolean outOfCombat()
	{
		return this.hitpoints <= 0;
	}

	public boolean idle()
	{
		return false;
	}

	public String warCry();

	public int getExp()
	{
		return this.exp;
	}

	public String toString()
	{
		return this.name + " HP:" + this.hitpoints;
	}

	public void selfHeal();
}