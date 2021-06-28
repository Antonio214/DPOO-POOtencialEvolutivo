package UIManager;

import BoardManager.iBoardManager;
import BoardManager.BoardGenerator.NewBoardEvent;
import BoardManager.BoardView.PrintableBoardState;
import HeroManager.PrintableHeroStatus;
import HeroManager.iHeroManager;
import HeroManager.Enemies.iEnemy;
import UIManager.Animation.GameTimer;
import UIManager.BackgroungRender.BackgroundRender;
import UIManager.BoardRender.BoardRenderer;
import UIManager.EndGamePopUp.PopUpRenderer;
import UIManager.HeroRender.HeroRenderer;
import UIManager.InterfaceController.UIController;
import UIManager.InterfaceController.iUIController;
import UIManager.SidebarRender.SidebarRenderer;
import Utils.Position;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class UIManager implements iUIManager {
    // screen constants
    private double screenWidth = 1024;
    private double screenHeigth = 728;
    private int cellsInColumn = 16;
    private int cellsInLine = 16;
    private double cellHeigth = this.screenHeigth / this.cellsInColumn;
    private double cellWidth = this.cellHeigth;
    private String screenTitle = "POOtencial Evolutivo - by DPOO";

    // GameLogic Stuffs
    private iBoardManager board;
    private iHeroManager hero;

    // JavaFX Stuffs
    private GameTimer timer;
    private Stage primaryStage;
    private Scene currentScene;
    private Group bgRoot;

    // SubClasses
    private iUIController controller;
    private BackgroundRender backgroundRenderer;

    @Override
    public void updateState() {
        this.backgroundRenderer.clearScreen();
        PrintableHeroStatus heroStatus = this.hero.expPrintableHeroStatus();
        PrintableBoardState boardState = this.board.exportPrintableBoardState();

        SidebarRenderer sidebarRenderer = new SidebarRenderer(bgRoot, heroStatus);
        sidebarRenderer.renderSidebar();

        BoardRenderer boardRenderer = new BoardRenderer(boardState, bgRoot, cellsInColumn, cellsInLine, cellHeigth,
                cellWidth);
        boardRenderer.renderBoard();

        HeroRenderer heroRenderer = new HeroRenderer(bgRoot, heroStatus, cellHeigth, cellWidth);
        heroRenderer.renderHero();

        PopUpRenderer popUpRenderer = new PopUpRenderer(bgRoot, heroStatus, screenWidth, screenHeigth);
        popUpRenderer.renderPopUp();

    }

    @Override
    public void setStage(Stage stage) {
        this.primaryStage = stage;
        this.initialConfigure();
    }

    @Override
    public void render() {
        primaryStage.setScene(this.currentScene);
        primaryStage.show();
    }

    private void initialConfigure() {
        // generate the first scene
        primaryStage.setTitle(this.screenTitle);
        primaryStage.setResizable(false);
        this.bgRoot = new Group();
        this.backgroundRenderer = new BackgroundRender(this.screenHeigth, this.bgRoot);
        this.backgroundRenderer.clearScreen();
        this.currentScene = new Scene(this.bgRoot, this.screenWidth, this.screenHeigth);

        // conect the ui with the controller to receive input from user
        this.controller = new UIController(this.currentScene);
        this.controller.configKeyBoard();

        // conect the ui with timer so it render on every new frame
        this.timer = new GameTimer();
        this.timer.connect(this);
        this.timer.start();
    }

    @Override
    public void connectHero(iHeroManager hero) {
        this.hero = hero;
        this.controller.addObserver(hero);
    }

    @Override
    public void connectBoard(iBoardManager board) {
        this.board = board;
    }

    @Override
    public void update(Position positionToMove) {
        this.updateState();
    }

    @Override
    public void update(NewBoardEvent event) {
        this.updateState();
    }

    @Override
    public void update(iEnemy info) {
        this.updateState();
    }

    @Override
    public iUIController getController() {
        return this.controller;
    }
}
