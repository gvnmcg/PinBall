/**
 * keeps track of the state of the ball, rests and moves
 */
public class Ball {

    private double x = 250;
    private double y = 400;

    private double dx = 0;
    private double dy = -1;


    public void reset(){

    }

    public void launch(){

    }

    public void move() {

        x += dx;
        y += dy;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
