package HeroManager.Collectables;

import HeroManager.Status.iHeroStatus;

public class Banana implements iCollectable {
    String imgPath = "file:assets/img/collectableCell/Banana.png";

    @Override
    public void activate(iHeroStatus hero) {
        hero.restoreEnergy();
        hero.addFood();
    }

    @Override
    public String getImage() {
        return this.imgPath;
    }

}
