package UIManager.BoardRender;

import BoardManager.BoardView.PrintableBoardState;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BoardRenderer {
    PrintableBoardState boardState;
    Group bgRoot;
    int cellsInColumn, cellsInLine;
    double cellHeigth, cellWidth;

    public BoardRenderer(PrintableBoardState boardState, Group bgRoot, int cellsInColumn, int cellsInLine,
            double cellHeigth, double cellWidth) {
        this.boardState = boardState;
        this.bgRoot = bgRoot;
        this.cellsInColumn = cellsInColumn;
        this.cellsInLine = cellsInLine;
        this.cellHeigth = cellHeigth;
        this.cellWidth = cellWidth;
    }

    public void renderBoard() {
        ImageView[] boardElements = getBoardElements();
        this.bgRoot.getChildren().addAll(boardElements);
    }

    private ImageView[] getBoardElements() {
        ImageView[] elements = new ImageView[this.cellsInColumn * this.cellsInLine];

        boardState.resetCounter();
        while (boardState.shouldPrintNext()) {
            Image img = new Image(boardState.getCurrentImage());
            ImageView newElement = new ImageView(img);

            newElement.setPreserveRatio(true);
            newElement.setFitHeight(this.cellHeigth);
            newElement.setX(boardState.currentColumn() * this.cellWidth);
            newElement.setY(boardState.currentLine() * this.cellHeigth);

            elements[(boardState.currentLine() * this.cellsInLine) + boardState.currentColumn()] = newElement;
            boardState.changeToNextImage();
        }

        return elements;
    }
}
