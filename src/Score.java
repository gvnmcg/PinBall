import javafx.scene.text.Text;

/**
 * Game Score, reset, increment
 */
public class Score {

    Text text = new Text();

    final int tilePts = 100;

    int value;

    public void updateText(){
        text.setText(String.valueOf(value));
    }

    public void reset(){
        value = 0;
    }

    public void hitTileCount(){
        value += tilePts;
        updateText();
    }

}
