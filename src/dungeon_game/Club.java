package dungeon_game;

public class Club implements Weapon {

    @Override
    public int attckPts() {
        return 3;
    }

    @Override
    public String name() {
        return "wooden club";
    }
}
