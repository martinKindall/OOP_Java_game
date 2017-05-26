public class Monster implements Combat
{
	int hitpoints;
	int baseAttack;

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