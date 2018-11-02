package dungeon_game;

public class Player extends Fighter
{
	static int defaultHp = 30;

	private int maxHitpoints;


	public Player(String name, Weapon weapon)
	{
		super(defaultHp, weapon, 0, 0, name);

		assert name.length() > 0 && exp >= 0;
	}

	@Override
	public String warCry() {
		return "";
	}

	public String toString()
	{
		return super.toString() + " EXP:" + this.exp + " W:" + this.weapon;
	}

	public void selfHeal()
	{
		super.hitpoints += 3;
		if (super.hitpoints > maxHitpoints) super.hitpoints = maxHitpoints;
	}
}