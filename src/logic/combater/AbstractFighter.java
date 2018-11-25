package logic.combater;

import com.sun.org.glassfish.gmbal.ManagedObject;
import logic.event.OutOfCombatCombater;
import logic.weapon.Weapon;
import utils.Utils;

import java.util.Observable;
import java.util.Observer;

public abstract class AbstractFighter extends Observable implements Combater
{
	protected int hitpoints;
	protected int maxHitpoints;
	protected Weapon weapon;
	protected int exp;
	protected String name;
	protected int dodge;
	protected boolean dodgeState;

	protected AbstractFighter(int hitpoints, Weapon weapon, int exp, int dodge, String name)
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
                this.hitpoints = 0;
                dieNow();
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
    public void subscribe(Observer observer){
	    addObserver(observer);
    }

    @Override
    public void increaseExp(int newExp){
    }

    protected void dieNow(){
	    setChanged();
	    notifyObservers(new OutOfCombatCombater());
    }
}