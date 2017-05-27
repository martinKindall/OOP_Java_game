public abstract class ColoredMonster extends Monster
{
	ColoredMonster(int hitpoints, int baseAttack, String name)
	{
		super(hitpoints, baseAttack, name);
	}

	public static String getColor()
	{
		String[] colors = {"yellow", "red", "blue", "green"};

		return colors[Utils.random(0, colors.length-1)];
	}
}