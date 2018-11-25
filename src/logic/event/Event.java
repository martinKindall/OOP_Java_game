package logic.event;

import controller.Game;

public interface Event {
    void visitGame(Game game);
}
