import javafx.geometry.Point2D;

public class Tile {

    boolean target;

    Point2D pos;
    double size = 100;

    Tile(Point2D pos){

        this.pos = pos;

    }

    public boolean isTarget() {
        return target;
    }

    public void setTarget(boolean target) {
        this.target = target;
    }
}
