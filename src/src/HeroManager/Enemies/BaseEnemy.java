package HeroManager.Enemies;

public abstract class BaseEnemy implements iEnemy {
    protected int life;
    protected int atack;

    @Override
    public boolean isDefeated() {
        return this.getLife() <= 0;
    }

    public int getLife() {
        return this.life;
    }

    public void setLife(int life) {
        this.life = life;
        System.out.println("Vida do inimigo: " + life);
    }

    public int getAtack() {
        return atack;
    }

    public void setAtack(int atack) {
        this.atack = atack;
    }
}
