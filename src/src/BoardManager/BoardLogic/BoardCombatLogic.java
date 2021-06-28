package BoardManager.BoardLogic;

import HeroManager.Enemies.CombatObservable;
import HeroManager.Enemies.iCombatObservable;
import HeroManager.Enemies.iCombatObserver;
import HeroManager.Enemies.iEnemy;

public class BoardCombatLogic extends CombatObservable implements iBoardCombatLogic {

    @Override
    public void notifyListeners(iEnemy info) {
        for (iCombatObserver combatObserver : observers) {
            combatObserver.update(info);
        }
    }

}
