package HeroManager.Collectables;

import HeroManager.Status.iHeroStatus;

public interface iCollectable {
    public void activate(iHeroStatus hero);

    public String getImage();
}
