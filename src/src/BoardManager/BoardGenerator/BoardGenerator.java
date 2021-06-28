package BoardManager.BoardGenerator;

import java.util.concurrent.ThreadLocalRandom;

import BoardManager.Cells.CollectableCell;
import BoardManager.Cells.EmptyCell;
import BoardManager.Cells.EndFaseCell;
import BoardManager.Cells.EnemyCell;
import BoardManager.Cells.ObstacleCell;
import BoardManager.Cells.iCell;
import HeroManager.Collectables.Banana;
import HeroManager.Enemies.EarthEnemy;
import HeroManager.Enemies.FireEnemy;
import HeroManager.Enemies.WaterEnemy;
import HeroManager.Enemies.iEnemy;
import Utils.Position;

public class BoardGenerator extends NewBoardObservable implements iBoardGenerator {
    iCell[][] cells;

    public BoardGenerator(iCell[][] cells) {
        this.cells = cells;
    }

    @Override
    public void generateNewBoard() {
        this.fillWithEmptyCells();
        this.fillWithObstaclesCell();
        this.fillWithCollectableCells();
        this.fillWithEnemies();
        this.fillWithEndFaseCell();
        notifyListeners(new NewBoardEvent());
    }

    @Override
    public void notifyListeners(NewBoardEvent event) {
        for (iNewBoardObserver observer : observers) {
            observer.update(event);
        }
    }

    private void fillWithEmptyCells() {
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                int randomNum = ThreadLocalRandom.current().nextInt(0, 101);
                int randomIndex = 0;
                if (randomNum > 50) {
                    randomIndex = ThreadLocalRandom.current().nextInt(1, 5);
                }
                String path = "file:assets/img/movableCell/movableCell" + randomIndex + ".png";
                this.cells[i][j] = new EmptyCell(path, new Position(i, j));
            }
        }
    }

    private void fillWithObstaclesCell() {
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                int randomNum = ThreadLocalRandom.current().nextInt(0, 101);
                int randomIndex = 0;
                if (randomNum > 58) {
                    randomIndex = ThreadLocalRandom.current().nextInt(1, 4);
                    String path = "file:assets/img/obstacleCell/Tree" + randomIndex + ".png";
                    this.cells[i][j] = new ObstacleCell(path, new Position(i, j));
                }
            }
        }
    }

    private void fillWithCollectableCells() {
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                int randomNum = ThreadLocalRandom.current().nextInt(0, 101);
                if (randomNum > 90) {
                    this.cells[i][j] = new CollectableCell(new Position(i, j), new Banana());
                }
            }
        }

    }

    private void fillWithEnemies() {
        int randomNum, randomLine, randomColumn;

        randomNum = ThreadLocalRandom.current().nextInt(0, 11);
        if (randomNum > 4) {
            randomLine = ThreadLocalRandom.current().nextInt(0, 16);
            randomColumn = ThreadLocalRandom.current().nextInt(0, 16);
            this.cells[randomLine][randomColumn] = new EnemyCell(new Position(randomLine, randomColumn),
                    new FireEnemy());
        }

        randomNum = ThreadLocalRandom.current().nextInt(0, 11);
        if (randomNum > 4) {
            randomLine = ThreadLocalRandom.current().nextInt(0, 16);
            randomColumn = ThreadLocalRandom.current().nextInt(0, 16);
            this.cells[randomLine][randomColumn] = new EnemyCell(new Position(randomLine, randomColumn),
                    new WaterEnemy());
        }

        randomNum = ThreadLocalRandom.current().nextInt(0, 11);
        if (randomNum > 4) {
            randomLine = ThreadLocalRandom.current().nextInt(0, 16);
            randomColumn = ThreadLocalRandom.current().nextInt(0, 16);
            this.cells[randomLine][randomColumn] = new EnemyCell(new Position(randomLine, randomColumn),
                    new EarthEnemy());
        }
    }

    private void fillWithEndFaseCell() {
        generateSafePath();
        this.cells[15][15] = new EndFaseCell(new Position(15, 15));
    }

    private void generateSafePath() {
        int[][] safeCoordinates = { { 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
                { 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 0 }, { 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0 },
                { 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0 },
                { 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0 }, { 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 0 },
                { 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0 }, { 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0 },
                { 0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0 }, { 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1 } };
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                if (safeCoordinates[i][j] == 1) {
                    int randomNum = ThreadLocalRandom.current().nextInt(0, 101);
                    int randomIndex = 0;
                    if (randomNum > 50) {
                        randomIndex = ThreadLocalRandom.current().nextInt(1, 5);
                    }
                    String path = "file:assets/img/movableCell/movableCell" + randomIndex + ".png";
                    this.cells[i][j] = new EmptyCell(path, new Position(i, j));

                }
            }
        }
    }
}
