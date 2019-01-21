/**
 * keeps track of the state of the ball, rests and moves
 */
public class Ball {

    private double x = 250;
    private double y = 400;

    private double speed = 5;

    private double dx = 1 * speed;
    private double dy = -1 * speed;


    public void reset(){

    }

    public void launch(){

    }

    public void move() {

        if (x > 500 && dx > 0){
            dx = -dx;
        }

        if (x < 0 && dx < 0){
            dx = -dx;
        }

        if (y > 600 && dy > 0){
            dy = -dy;
        }

        if (y < 0 && dy < 0){
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
