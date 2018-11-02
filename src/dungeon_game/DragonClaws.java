package dungeon_game;

public class DragonClaws implements Weapon {
    @Override
    public int attckPts() {
        return 7;
    }

    @Override
    public String name() {
        return "Sharp dragon claws with fire";
    }
}
