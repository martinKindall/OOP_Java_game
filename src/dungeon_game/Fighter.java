package dungeon_game;

public abstract class Fighter implements Combater
{
	protected int hitpoints;
	protected int maxHitpoints;
	protected Weapon weapon;
	protected int exp;
	protected String name;
	protected int dodge;

	Fighter(int hitpoints, Weapon weapon, int exp, int dodge, String name)
	{
		this.maxHitpoints = hitpoints;
		this.hitpoints = hitpoints;
		this.weapon = weapon;
		this.exp = exp;
		this.dodge = dodge;
		this.name = name;
		
		assert hitpoints > 0 && name.length() > 0 && weapon.attckPts() > 0;
	}

	public void attack(Combater combater){
		combater.receiveDamage(this);
	}

	public int getAttack(){
		return weapon.attckPts();
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
		return Utils.random(0, 9) < this.dodge;
	}

	public boolean outOfCombat()
	{
		return this.hitpoints <= 0;
	}

	public boolean idle()
	{
		return false;
	}

	public abstract String warCry();

	public int getExp()
	{
		return this.exp;
	}

	public String toString()
	{
		return this.name + " HP:" + this.hitpoints;
	}

	public void selfHeal(){}

	@Override
	public int currentHp() {
		return hitpoints;
	}
}