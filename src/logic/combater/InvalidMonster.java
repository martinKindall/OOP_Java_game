package logic.combater;

import logic.weapon.Club;
import logic.weapon.Weapon;

public class InvalidMonster extends AbstractFighter{

    protected InvalidMonster(int hitpoints, Weapon weapon, int exp, int dodge, String name) {
        super(hitpoints, weapon, exp, dodge, name);
    }

    public InvalidMonster(){
        this(1, new Club(), 0, 0, "invalid");
    }

    @Override
    public String warCry() {
        return "";
    }
}
