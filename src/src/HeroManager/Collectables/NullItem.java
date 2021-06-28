package HeroManager.Collectables;

import HeroManager.Status.iHeroStatus;

public class NullItem implements iCollectable {
    String imgPath = "file:assets/img/movableCell/movableCell0.png";

    @Override
    public void activate(iHeroStatus hero) {
        return;
    }

    @Override
    public String getImage() {
        return this.imgPath;
    }

}
