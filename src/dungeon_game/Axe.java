package dungeon_game;

public class Axe implements Weapon {
    @Override
    public int attckPts() {
        return 5;
    }

    @Override
    public String name() {
        return "axe";
    }
}
