package BoardManager.BoardLogic;

import HeroManager.Collectables.iCollectable;
import HeroManager.Enemies.iEnemy;

public interface iBoardLogicController extends iMoveObservable {
    public void generateNewBoard();

    public void replaceHero();

    public void notifyItem(iCollectable info);

    public void notifyCombat(iEnemy info);
}
