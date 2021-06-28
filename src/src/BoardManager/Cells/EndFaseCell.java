package BoardManager.Cells;

import BoardManager.BoardLogic.iBoardLogicController;
import Utils.Position;

/**
 * EndFaseCell
 */
public class EndFaseCell extends MovableCell {
    public EndFaseCell(Position position) {
        super("file:assets/img/portalCell/portal.png", position);
    }

    @Override
    public void activateInteraction(iBoardLogicController controller) {
        // super.activateInteraction(controller);
        controller.generateNewBoard();
        controller.replaceHero();
    }

}