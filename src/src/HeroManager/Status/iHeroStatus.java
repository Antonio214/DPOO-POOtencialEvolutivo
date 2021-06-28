package HeroManager.Status;

import HeroManager.PrintableHeroStatus;
import Utils.Direction;
import Utils.Position;

public interface iHeroStatus extends iDeathObservable {
    public boolean isAlive();

    public void placeHero();

    public void decreaseHP(int damage);

    public void decreaseEnergy(int damage);

    public void restoreEnergy();

    public void addFood();

    public void moveHero(Position position);

    public void setFacingDirection(Direction direction);

    public int getAtackValue();

    public Position getPosition();

    public PrintableHeroStatus expPrintableHeroStatus();

    public boolean hasGene(GeneType gene);

    public void addGene(GeneType gene);

    public void increaseXP(int value);
}
