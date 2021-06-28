package BoardManager.BoardState;

import BoardManager.BoardLogic.iBoardLogicController;
import BoardManager.Cells.ObstacleCell;
import BoardManager.Cells.iCell;
import Utils.Position;

public class BoardStateController implements iBoardStateController {
    iCell cells[][];
    iBoardLogicController boardLogic;

    public BoardStateController(iCell[][] cells, iBoardLogicController boardLogic) {
        this.cells = cells;
        this.boardLogic = boardLogic;
    }

    @Override
    public void interactWithCellAt(Position position) {
        try {
            this.cells[position.line][position.column].activateInteraction(this.boardLogic);
        } catch (ArrayIndexOutOfBoundsException e) {
            ObstacleCell tempo = new ObstacleCell("", new Position(0, 0));
            tempo.activateInteraction(this.boardLogic);
        } catch (Exception e) {
            throw e;
        }
    }
}
