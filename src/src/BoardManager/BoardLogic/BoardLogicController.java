package BoardManager.BoardLogic;

import BoardManager.BoardGenerator.iBoardGenerator;
import HeroManager.Collectables.iCollectable;
import HeroManager.Enemies.iEnemy;
import Utils.Position;

public class BoardLogicController extends PositionObservable implements iBoardLogicController {
    iBoardGenerator boardGenerator;
    iBoardItensLogic boardItems;
    iBoardCombatLogic boardCombat;

    public BoardLogicController(iBoardGenerator boardGenerator, iBoardItensLogic boardItems,
            iBoardCombatLogic boardCombat) {
        this.boardGenerator = boardGenerator;
        this.boardItems = boardItems;
        this.boardCombat = boardCombat;
    }

    @Override
    public void notifyListeners(Position position) {
        for (iMoveObserver observer : observers) {
            observer.update(position);
        }
    }

    @Override
    public void generateNewBoard() {
        this.boardGenerator.generateNewBoard();
    }

    @Override
    public void replaceHero() {
        // TODO Auto-generated method stub
    }

    @Override
    public void notifyItem(iCollectable info) {
        this.boardItems.notifyListeners(info);

    }

    @Override
    public void notifyCombat(iEnemy info) {
        this.boardCombat.notifyListeners(info);
    }

}
