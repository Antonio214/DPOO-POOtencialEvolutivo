import BoardManager.iBoardManager;
import BoardManager.BoardManager;
import HeroManager.HeroManager;
import HeroManager.iHeroManager;
import UIManager.UIManager;
import UIManager.iUIManager;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 ** App
 */
public class App extends Application {
    iBoardManager board;
    iUIManager userInterface;
    iHeroManager hero;

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    private void setUp(Stage primaryStage) {
        board = new BoardManager();
        userInterface = new UIManager();
        hero = new HeroManager();

        // GameLogic SetUp
        this.hero.placeHero();
        this.userInterface.setStage(primaryStage);
        this.userInterface.connectBoard(this.board);
        this.userInterface.connectHero(this.hero);
        this.hero.connectBoard(this.board);
        this.hero.connectUI(this.userInterface);
        this.board.connectHero(this.hero);
        this.board.connectUI(this.userInterface);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.setUp(primaryStage);
        userInterface.updateState();
    }

}
