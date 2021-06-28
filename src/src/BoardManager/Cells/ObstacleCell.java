package BoardManager.Cells;

import BoardManager.BoardLogic.iBoardLogicController;
import Utils.Position;

public class ObstacleCell extends BaseCell {
    public ObstacleCell(String imgPath, Position position) {
        super(imgPath, position);
    }

    @Override
    public void activateInteraction(iBoardLogicController controller) {
    }

}