package BoardManager.BoardView;

import BoardManager.Cells.iCell;

public class BoardView implements iBoardView {
    iCell[][] cells;

    public BoardView(iCell[][] cells) {
        this.cells = cells;
    }

    @Override
    public PrintableBoardState exportPrintableBoardState() {
        PrintableBoardState printableState = new PrintableBoardState();
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                printableState.appendImage(i, j, this.cells[i][j].getCellImage());
            }
        }
        return printableState;
    }
}
