package dungeon_game;

public abstract class Fighter implements Combater
{
	protected int hitpoints;
	protected int maxHitpoints;
	protected Weapon weapon;
	protected int exp;
	protected String name;
	protected int dodge;
	protected boolean dodgeState;

	Fighter(int hitpoints, Weapon weapon, int exp, int dodge, String name)
	{
		this.maxHitpoints = hitpoints;
		this.hitpoints = hitpoints;
		this.weapon = weapon;
		this.exp = exp;
		this.dodge = dodge;
		this.name = name;
		dodgeState = false;
		
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
	    dodgeState = false;

        dodgeNow();

		if (!dodgeState){
			this.hitpoints -= combater.getAttack();
			if (this.hitpoints <= 0){
                combater.increaseExp(this);
                this.hitpoints = 0;
			}
		}
	}

	private void dodgeNow(){
        dodgeState = Utils.random(0, 9) < this.dodge;
    }

	public boolean dodge()
	{
		return dodgeState;
	}

	public boolean outOfCombat()
	{
		return hitpoints <= 0;
	}

	public boolean idle()
	{
		return false;
	}

	public abstract String warCry();

	public int getExp()
	{
		return exp;
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

	@Override
	public void increaseExp(Combater combater) {
		exp += combater.getExp();
	}
}