import java.util.*;

public class MonsterFactory
{
	/**
	 * [create: int int int -> List<Combat>]
	 *
	 * returns a List of type Combat with the desired
	 * amount of monsters of type Monster, Goblin or Dragon
	 * 
	 * @param  monstersQty [description]
	 * @param  goblinsQty  [description]
	 * @param  dragonsQty  [description]
	 * @return             [description]
	 */
	public static List<Combat> create(int monstersQty, int goblinsQty, int dragonsQty)
	{
		List<Combat> monsters = new LinkedList<Combat>();
		fillWithMonsters(monsters, monstersQty);
		fillWithGoblins(monsters, goblinsQty);
		fillWithDragons(monsters, dragonsQty);

		return monsters;
	}

	/**
	 * [fillWithMonsters LinkedList<Combat> int -> None]
	 *
	 * effect: fills the list with the desired qty of monsters
	 * 
	 * @param monsters [description]
	 * @param qty      [description]
	 */
	public static void fillWithMonsters(List<Combat> monsters, int qty)
	{
		for (int idx=0; idx<qty; ++idx) 
		{
			monsters.add(new Monster());
		}
	}

	public static void fillWithGoblins(List<Combat> goblins, int qty)
	{
		for (int idx=0; idx<qty; ++idx) 
		{
			goblins.add(new Goblin());
		}
	}

	public static void fillWithDragons(List<Combat> dragons, int qty)
	{
		for (int idx=0; idx<qty; ++idx) 
		{
			dragons.add(new Dragon());
		}
	}
}