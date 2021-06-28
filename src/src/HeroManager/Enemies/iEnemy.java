package HeroManager.Enemies;

import HeroManager.Collectables.iCollectable;
import HeroManager.Status.iHeroStatus;

public interface iEnemy {
    public void dealDamageTo(iHeroStatus hero);

    public void receiveDamageFrom(iHeroStatus hero);

    public boolean isDefeated();

    public String getImage();

    public iCollectable dropItem();
}
