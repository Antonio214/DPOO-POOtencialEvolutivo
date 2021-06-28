package UIManager.InterfaceController;

import HeroManager.Status.DeathEvent;
import Utils.Direction;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class UIController extends DirectionObservable implements iUIController {
    Scene scene;

    public UIController(Scene scene) {
        this.scene = scene;
    }

    @Override
    public void notifyListeners(Direction info) {
        for (iDirectionObserver observer : observers) {
            observer.update(info);
        }
    }

    private void handleKeyBoard(KeyEvent event) {
        switch (event.getCode()) {
            case W:
            case UP:
                notifyListeners(Direction.Up);
                break;
            case S:
            case DOWN:
                notifyListeners(Direction.Down);
                break;
            case LEFT:
            case A:
                notifyListeners(Direction.Left);
                break;
            case RIGHT:
            case D:
                notifyListeners(Direction.Rigth);
                break;
            default:
                break;
        }
    }

    public void configKeyBoard() {
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                handleKeyBoard(event);
            }
        });
    }

    @Override
    public void update(DeathEvent info) {
        scene.setOnKeyReleased(null);
    }
}
