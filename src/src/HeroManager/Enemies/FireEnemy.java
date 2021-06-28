package HeroManager.Enemies;

import java.util.concurrent.ThreadLocalRandom;

import HeroManager.Collectables.Banana;
import HeroManager.Collectables.Gene;
import HeroManager.Collectables.iCollectable;
import HeroManager.Status.GeneType;
import HeroManager.Status.iHeroStatus;

public class FireEnemy extends BaseEnemy {
    private String imgPath = "file:assets/img/enemies/FireElemental.png";

    public FireEnemy() {
        this.setLife(5);
        this.setAtack(2);
    }

    @Override
    public void dealDamageTo(iHeroStatus hero) {
        hero.decreaseHP(this.getAtack());
    }

    @Override
    public void receiveDamageFrom(iHeroStatus hero) {
        int mult = hero.hasGene(GeneType.Water) ? 2 : 1;
        this.setLife(this.getLife() - (hero.getAtackValue() * mult));
    }

    public String getImage() {
        return this.imgPath;
    }

    @Override
    public iCollectable dropItem() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 11);
        if (randomNum > 7) {
            return new Gene(GeneType.Fire);
        } else {
            return new Banana();
        }
    }
}
