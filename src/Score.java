/**
 * Game Score, reset, increment
 */
public class Score {

    final int tilePts = 100;

    int value;

    public void reset(){
        value = 0;
    }

    public void hitTileCount(){
        value += tilePts;
    }

}
