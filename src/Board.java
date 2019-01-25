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
    ArrayList<Tile> targets = new ArrayList<>();

    Random random = new Random();


    /**
     * create all tiles
     * choose few to become targets
     */
    Board(){


        for (int col = 0; col < columns; col++) {
            for (int row = 0; row < rows; row++) {
                tiles.add(new Tile(
                       new Point2D(col * scale, row * scale)));
            }
        }

        makeTargets();
    }

    private void makeTargets(){
        //targets
        Tile t;
        for (int i = 0; i < 7; i++) {
            t = tiles.get(random.nextInt((int)(rows * columns)));

            if (t.isTarget()){
                i--; //grab a different tile
            } else {
                targets.add(t);
                t.setTarget(true);
            }
        }

    }

    boolean detectHit(Ball ball) {

        //if there are no targets, make new targets
        if (targets.isEmpty()){

            makeTargets();

        } else {
            for (Tile t : targets) {
                if (t.view.intersects(
                        ball.getX(), ball.getY(), 1, 1)) {
                    t.setTarget(false);
                    targets.remove(t);
                    return true;
                }
            }
        }
        return false;
    }

}
