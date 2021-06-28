package UIManager.Animation;

import UIManager.iUIManager;
import javafx.animation.AnimationTimer;

//main class
public class GameTimer extends AnimationTimer {
    private iUIManager userInterface;
    int contador = 0;

    // define the handle method
    @Override
    public void handle(long now) {
        // call the method
        handlee();
    }

    public void connect(iUIManager userInterface) {
        this.userInterface = userInterface;
    }

    // method handlee
    private void handlee() {
        this.userInterface.render();
    }
}
