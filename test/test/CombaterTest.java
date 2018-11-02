package test;

import org.junit.*;
import dungeon_game.*;

import static org.junit.Assert.*;

public class CombaterTest {
    private Combater character;
    private Weapon sword;
    private Combater goblin;
    private Combater damagedGoblin;

    @Before
    public void setUp(){
        sword = new Sword();
        character = new Player("Martin", sword);
        goblin = new Goblin();
        damagedGoblin = new Goblin(3);
    }

    @Test
    public void damage(){
        int hitpoints = goblin.currentHp();
        character.attack(goblin);
        assertEquals(hitpoints - 4, goblin.currentHp());
    }

    @Test
    public void outOfCombatTest(){
        assertFalse(damagedGoblin.outOfCombat());
        goblin.attack(damagedGoblin);
        assertTrue(damagedGoblin.outOfCombat());
    }

    @Test
    public void gainExpTest(){
        int currExp = character.getExp();
        character.attack(damagedGoblin);
        assertEquals(currExp + damagedGoblin.getExp(), character.getExp());
    }
}
