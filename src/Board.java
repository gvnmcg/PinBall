import javafx.geometry.Point2D;

import java.util.ArrayList;
import java.util.Random;

/**
 * Board and its state reset, change, check tile, update
 */
class Board {

    ArrayList<Tile> tiles = new ArrayList<>();

    Random random = new Random();


    Board(){

        for (int i = 0; i < 30; i++) {

            tiles.add(new Tile(new Point2D((i % 5) * 100, (int) ((i / 6) * 100))));

        }
    }

}
