import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile {

    boolean target;

    Point2D pos;
    double size = 100;

    Rectangle view;

    Tile(Point2D pos) {

        this.pos = pos;

    }

    public boolean isTarget() {
        return target;
    }

    public void setTarget(boolean target) {
        this.target = target;

        if (view != null) {
            if (!target) {
                view.setFill(Color.BLUE);
            } else {
                view.setFill(Color.ORANGE);
            }
        }
    }

    public void setView(Rectangle view) {
        this.view = view;
    }

    public Rectangle getView() {
        return view;
    }
}
