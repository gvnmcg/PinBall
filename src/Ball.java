import javafx.scene.shape.Circle;

/**
 * keeps track of the state of the ball, rests and moves
 */
public class Ball {

    Circle hitbox;

    private double x = 250;
    private double y = 400;
    private double r = 5;

    private double speed = 5;

    private double dx = 1 * speed;
    private double dy = -1 * speed;

    Ball(){

    }

    public void reset(){

    }

    public void launch(){

    }

    public void move() {



        if (x+r > Board.width && dx > 0){
            dx = -dx;
        }

        if (x-r < 0 && dx < 0){
            dx = -dx;
        }

        if (y+r > Board.height && dy > 0){
            dy = -dy;
        }

        if (y-r < 0 && dy < 0){
            dy = -dy;
        }

        x += dx;
        y += dy;

//        System.out.printf("x : %f, y: %f", x, y);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
