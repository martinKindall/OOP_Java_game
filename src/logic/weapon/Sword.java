package logic.weapon;

public class Sword implements Weapon{

    @Override
    public int attckPts() {
        return 4;
    }

    @Override
    public String name() {
        return "sword";
    }
}
