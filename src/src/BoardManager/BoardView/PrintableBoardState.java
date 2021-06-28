package BoardManager.BoardView;

/**
 * PrintableBoardState
 */
public class PrintableBoardState {
    private int columnMax = 16;
    private int lineMax = 16;
    private String[][] images;
    private int lineCounter;
    private int columnCounter;
    private boolean hasFinished;

    public PrintableBoardState() {
        this.images = new String[lineMax][columnMax];
    }

    public void appendImage(int i, int j, String path) {
        this.images[i][j] = path;
    }

    public void resetCounter() {
        this.lineCounter = 0;
        this.columnCounter = 0;
        hasFinished = false;
    }

    public int currentLine() {
        return lineCounter;
    }

    public int currentColumn() {
        return columnCounter;
    }

    public String getCurrentImage() {
        return images[lineCounter][columnCounter];
    }

    public void changeToNextImage() {
        columnCounter++;
        if (columnCounter == columnMax) {
            columnCounter = 0;
            lineCounter++;
            if (lineCounter == lineMax) {
                hasFinished = true;
            }
        }
    }

    public boolean shouldPrintNext() {
        return !hasFinished;
    }
}