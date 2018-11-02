public abstract class ColoredMonster extends Monster
{
	ColoredMonster(int hitpoints, int baseAttack, int exp, int dodge, String name)
	{
		super(hitpoints, baseAttack, exp, dodge, getColor() + " " + name);
	}

	public static String getColor()
	{
		String[] colors = {"yellow", "red", "blue", "green"};

		return colors[Utils.random(0, colors.length-1)];
	}
}