package logic.event;

import controller.Game;

public class OutOfCombatPlayer implements Event {

    @Override
    public void visitGame(Game game) {
        game.finish();
    }
}
