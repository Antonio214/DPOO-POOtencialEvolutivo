package UIManager;

import HeroManager.iHeroManConsumer;
import HeroManager.Enemies.iCombatObserver;
import UIManager.InterfaceController.iUIController;
import BoardManager.iBoardManConsumer;
import BoardManager.BoardGenerator.iNewBoardObserver;
import BoardManager.BoardLogic.iMoveObserver;
import javafx.stage.Stage;

public interface iUIManager
        extends iHeroManConsumer, iBoardManConsumer, iMoveObserver, iNewBoardObserver, iCombatObserver {

    public void updateState();

    public void setStage(Stage stage);

    public void render();

    public iUIController getController();
}
