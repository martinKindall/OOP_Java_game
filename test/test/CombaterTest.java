package test;

import controller.Game;
import logic.combater.Combater;
import logic.combater.Goblin;
import logic.combater.Player;
import logic.weapon.Sword;
import logic.weapon.Weapon;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CombaterTest {
    private Combater character;
    private Weapon sword;
    private Combater goblin;
    private Combater damagedGoblin;
    private List<Combater> list1;
    private List<Combater> list2;
    private Game game1;
    private Game game2;

    @Before
    public void setUp(){
        goblin = new Goblin();
        damagedGoblin = new Goblin(3);

        list1 = new ArrayList<>();
        list1.add(goblin);
        list2 = new ArrayList<>();
        list2.add(damagedGoblin);

        game1 = new Game(list1);
        game2 = new Game(list2);

        sword = new Sword();
        character = new Player("Martin", sword);
    }

    @Test
    public void damage(){
        game1.setPlayer(character);
        int hitpoints = goblin.currentHp();
        character.attack(goblin);
        assertEquals(hitpoints - 4, goblin.currentHp());
    }

    @Test
    public void outOfCombatTest(){
        game2.setPlayer(character);
        assertFalse(damagedGoblin.outOfCombat());
        character.attack(damagedGoblin);
        assertTrue(damagedGoblin.outOfCombat());
    }

    @Test
    public void gainExpTest(){
        game2.setPlayer(character);
        int currExp = character.getExp();
        character.attack(damagedGoblin);
        assertEquals(currExp + damagedGoblin.getExp(), character.getExp());
    }
}
