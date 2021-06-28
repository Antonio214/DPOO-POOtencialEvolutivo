package BoardManager.Cells;

import BoardManager.BoardLogic.iBoardLogicController;
import HeroManager.Collectables.Banana;
import HeroManager.Collectables.NullItem;
import HeroManager.Enemies.iEnemy;
import Utils.Position;

public class EnemyCell extends CollectableCell {
    iEnemy enemy;

    public EnemyCell(Position position, iEnemy enemy) {
        super(position, new NullItem());
        this.enemy = enemy;
        this.imagePath = enemy.getImage();
    }

    @Override
    public void activateInteraction(iBoardLogicController controller) {
        if (!enemy.isDefeated()) {
            controller.notifyCombat(this.enemy);
            if (enemy.isDefeated()) {
                this.item = enemy.dropItem();
                this.imagePath = item.getImage();
                controller.notifyCombat(this.enemy);
            }
        } else {
            super.activateInteraction(controller);
        }

    }

}