package test;

import org.junit.*;
import dungeon_game.*;

import static org.junit.Assert.*;

public class CombaterTest {
    private Combater character;
    private Weapon sword;
    private Combater goblin;

    @Before
    public void setUp(){
        sword = new Sword();
        character = new Player("Martin", sword);
        goblin = new Goblin();
    }

    @Test
    public void damage(){
        int hitpoints = goblin.currentHp();
        character.attack(goblin);
        assertEquals(hitpoints - 4, goblin.currentHp());
    }
}
