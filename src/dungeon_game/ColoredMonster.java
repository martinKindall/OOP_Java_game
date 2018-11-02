package dungeon_game;

public abstract class ColoredMonster extends Fighter
{
	ColoredMonster(int hitpoints, Weapon weapon, int exp, int dodge, String name)
	{
		super(hitpoints, weapon, exp, dodge, getColor() + " " + name);
	}

	public static String getColor()
	{
		String[] colors = {"yellow", "red", "blue", "green"};

		return colors[Utils.random(0, colors.length-1)];
	}

	@Override
	public boolean idle()
	{
		return Utils.random(0, 9) < 2;
	}
}