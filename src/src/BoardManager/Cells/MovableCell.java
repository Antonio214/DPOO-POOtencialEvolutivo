package BoardManager.Cells;

import BoardManager.BoardLogic.iBoardLogicController;
import Utils.Position;

/**
 * MovableCell
 */
public abstract class MovableCell extends BaseCell {
    public MovableCell(String imagePath, Position position) {
        super(imagePath, position);
    }

    @Override
    public void activateInteraction(iBoardLogicController controller) {
        controller.notifyListeners(this.position);
    }

}