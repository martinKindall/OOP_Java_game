package dungeon_game;

public class Player extends Fighter
{
	static int defaultHp = 30;

	public Player(String name, Weapon weapon)
	{
		this(name, weapon, 0);
	}

	public Player(String name, Weapon weapon, int dodge){
		super(defaultHp, weapon, 0, dodge, name);
		assert name.length() > 0 && exp >= 0;
	}

	@Override
	public String warCry() {
		return "";
	}

	@Override
	public String toString()
	{
		return super.toString() + " EXP:" + this.exp + " W:" + this.weapon.name();
	}

	@Override
	public void selfHeal()
	{
		hitpoints += 3;
		if (hitpoints > maxHitpoints) hitpoints = maxHitpoints;
	}
}