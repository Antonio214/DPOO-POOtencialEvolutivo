package UIManager.BackgroungRender;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BackgroundRender {
    double screenHeigth;
    Group bgRoot;

    public BackgroundRender(double screenHeigth, Group bgRoot) {
        this.screenHeigth = screenHeigth;
        this.bgRoot = bgRoot;
    }

    private ImageView getBackGroundView() {
        Image imageBG = new Image("file:assets/img/Grass.png");
        ImageView bgView = new ImageView(imageBG);
        bgView.setPreserveRatio(true);
        bgView.setFitHeight(this.screenHeigth);
        return bgView;
    }

    public void clearScreen() {
        this.bgRoot.getChildren().clear();
        ImageView bgView = this.getBackGroundView();
        this.bgRoot.getChildren().add(bgView);
    }
}
