package dungeon_game;

public class Bow implements Weapon {
    @Override
    public int attckPts() {
        return 3;
    }

    @Override
    public String name() {
        return "bow";
    }
}
