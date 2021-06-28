package HeroManager.Collectables;

import HeroManager.Status.GeneType;
import HeroManager.Status.iHeroStatus;

public class Gene implements iCollectable {
    GeneType type;
    String basePath = "file:assets/img/collectableCell/";

    public Gene(GeneType type) {
        this.type = type;
    }

    @Override
    public void activate(iHeroStatus hero) {
        hero.addGene(this.type);
    }

    @Override
    public String getImage() {
        switch (type) {
            case Fire:
                return this.basePath + "DNAVermelho.png";
            case Water:
                return this.basePath + "DNAAzul.png";
            case Earth:
                return this.basePath + "DNAVerde.png";
            default:
                return "";
        }
    }

}
