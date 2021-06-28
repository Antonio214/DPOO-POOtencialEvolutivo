package BoardManager.BoardLogic;

import Utils.Position;

public interface iMoveObserver {
    void update(Position positionToMove);
}
