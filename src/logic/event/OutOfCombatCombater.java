package logic.event;

import controller.Game;

public class OutOfCombatCombater implements Event{

    @Override
    public void visitGame(Game game) {
        game.increasePlayerExp();
        game.goNextMonster();
    }
}
