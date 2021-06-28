package UIManager.HeroRender;

import HeroManager.PrintableHeroStatus;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HeroRenderer {
    Group bgRoot;
    PrintableHeroStatus status;
    double cellHeigth, cellWidth;

    public HeroRenderer(Group bgRoot, PrintableHeroStatus status, double cellHeigth, double cellWidth) {
        this.bgRoot = bgRoot;
        this.status = status;
        this.cellHeigth = cellHeigth;
        this.cellWidth = cellWidth;
    }

    public void renderHero() {
        ImageView heroView = this.getHeroView();
        this.bgRoot.getChildren().add(heroView);
    }

    private ImageView getHeroView() {
        Image imageHero = new Image("file:assets/img/Character.png");
        ImageView heroView = new ImageView(imageHero);

        heroView.setPreserveRatio(true);
        heroView.setFitHeight(this.cellHeigth);

        heroView.setX(status.position.column * this.cellWidth);
        heroView.setY(status.position.line * this.cellHeigth);

        switch (this.status.facingDirection) {
            case Down:
                break;
            case Left:
                heroView.setRotate(90);
                break;
            case Up:
                heroView.setScaleY(-1);
                break;
            case Rigth:
                heroView.setRotate(90);
                heroView.setScaleY(-1);
                break;
            default:
                break;
        }

        return heroView;
    }
}
