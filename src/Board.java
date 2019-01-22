import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

/**
 * Board and its state reset, change, check tile, update
 */
class Board {

    ArrayList<Integer> targets = new ArrayList<>();

    ArrayList<Point2D> targethitboxes = new ArrayList<>();

    Random random = new Random();


    void reset(){

        targets.clear();

        reset(5);

    }

    void reset(int i){

        int target = random.nextInt(30);

        if (targets.contains(target)){
            reset(i);
        } else {
            targets.add(target);
        }

        if (i == 0) return;

        reset(--i);
    }
}
