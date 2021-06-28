package BoardManager.BoardLogic;

import HeroManager.Collectables.CollectableObservable;
import HeroManager.Collectables.iCollectable;
import HeroManager.Collectables.iCollectableObserver;

public class BoardItensLogic extends CollectableObservable implements iBoardItensLogic {

    @Override
    public void notifyListeners(iCollectable info) {
        for (iCollectableObserver collectableObserver : observers) {
            collectableObserver.update(info);
        }
    }

}
