package BoardManager.Cells;

import BoardManager.BoardLogic.iBoardLogicController;

public interface iCell {
    public void activateInteraction(iBoardLogicController controller);

    public String getCellImage();
}
