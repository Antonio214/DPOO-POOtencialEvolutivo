package BoardManager.Cells;

import BoardManager.BoardLogic.iBoardLogicController;
import HeroManager.Collectables.NullItem;
import HeroManager.Collectables.iCollectable;
import Utils.Position;

public class CollectableCell extends MovableCell {
    iCollectable item;

    public CollectableCell(Position position, iCollectable item) {
        super(item.getImage(), position);
        this.item = item;
    }

    @Override
    public void activateInteraction(iBoardLogicController controller) {
        controller.notifyItem(this.item);
        this.item = new NullItem();
        this.imagePath = item.getImage();
        super.activateInteraction(controller);
    }

}
