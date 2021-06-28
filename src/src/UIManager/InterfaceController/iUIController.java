package UIManager.InterfaceController;

import HeroManager.Status.iDeathObserver;

public interface iUIController extends iDirectionObservable, iDeathObserver {
    public void configKeyBoard();
}
