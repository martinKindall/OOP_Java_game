package controller;
import logic.combater.Combater;
import logic.combater.Dragon;
import logic.combater.Goblin;

import java.util.*;

public class MonsterFactory
{
	/**
	 * [create: int int int -> List<Combat>]
	 *
	 * returns a List of type Combat with the desired
	 * amount of monsters of type Monster, Goblin or Dragon
	 * 
	 * @param  goblinsQty  [description]
	 * @param  dragonsQty  [description]
	 * @return             [description]
	 */
	public static List<Combater> create(int goblinsQty, int dragonsQty)
	{
		List<Combater> monsters = new LinkedList<>();
		fillWithGoblins(monsters, goblinsQty);
		fillWithDragons(monsters, dragonsQty);

		return monsters;
	}

	/**
	 * [fillWithMonsters LinkedList<Combat> int -> None]
	 *
	 * effect: fills the list with the desired qty of monsters
	 * 
	 * @param goblins [description]
	 * @param qty      [description]
	 */

	public static void fillWithGoblins(List<Combater> goblins, int qty)
	{
		for (int idx=0; idx<qty; ++idx) 
		{
			goblins.add(new Goblin());
		}
	}

	public static void fillWithDragons(List<Combater> dragons, int qty)
	{
		for (int idx=0; idx<qty; ++idx) 
		{
			dragons.add(new Dragon());
		}
	}
}