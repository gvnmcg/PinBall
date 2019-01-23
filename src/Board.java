import javafx.geometry.Point2D;

import java.util.ArrayList;
import java.util.Random;

/**
 * Board and its state reset, change, check tile, update
 */
class Board {

    static double width = 500;
    static double height = 600;

    static double rows = 6;
    static double columns = 5;
    int scale = 100;

    ArrayList<Tile> tiles = new ArrayList<>();

    Random random = new Random();


    Board(){

        for (int i = 0; i < rows  * columns; i++) {
            tiles.add(
                    new Tile(
                            new Point2D(
                                    (i % columns) * scale, (int) ((i / rows)) * scale)));
        }
    }

}
