package BoardManager.Cells;

import Utils.Position;

public abstract class BaseCell implements iCell {
    String imagePath;
    Position position;

    public BaseCell(String imagePath, Position position) {
        this.imagePath = imagePath;
        this.position = position;
    }

    @Override
    public String getCellImage() {
        return this.imagePath;
    }
}
