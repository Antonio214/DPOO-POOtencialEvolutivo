package Utils;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class FontConfigure {
    static public void setBaseTextStyle(Text value) {
        value.setFont(Font.font("Press Start 2P", FontWeight.BOLD, FontPosture.REGULAR, 18));
        value.setFill(Color.WHITE);
    }
}
