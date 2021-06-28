package UIManager.EndGamePopUp;

import HeroManager.PrintableHeroStatus;
import Utils.FontConfigure;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class PopUpRenderer {
    Group bgRoot;
    PrintableHeroStatus heroStatus;
    private double screenWidth;
    private double screenHeigth;

    public PopUpRenderer(Group bgRoot, PrintableHeroStatus heroStatus, double screenWidth, double screenHeigth) {
        this.bgRoot = bgRoot;
        this.heroStatus = heroStatus;
        this.screenWidth = screenWidth;
        this.screenHeigth = screenHeigth;
    }

    public void renderPopUp() {
        if (heroStatus.isDead) {
            Image popUpImg = new Image("file:assets/img/popUp/Background.png");
            ImageView popUp = new ImageView(popUpImg);

            Text points = new Text();
            FontConfigure.setBaseTextStyle(points);

            String labelText = heroStatus.currentLevel == 1 ? " nível" : " níveis";
            points.setText(heroStatus.currentLevel + labelText);

            popUp.setX(screenWidth / 2 - popUpImg.getWidth() / 2);
            popUp.setY(screenHeigth / 2 - popUpImg.getHeight() / 2);
            points.setX((screenWidth / 2 - (popUpImg.getWidth() / 2)) + 205);
            points.setY((screenHeigth / 2 - (popUpImg.getHeight() / 2)) + 190);

            this.bgRoot.getChildren().add(popUp);
            this.bgRoot.getChildren().add(points);
        }
    }
}
