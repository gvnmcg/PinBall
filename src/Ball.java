import javafx.scene.shape.Circle;

import java.util.Random;

/**
 * keeps track of the state of the ball, rests and moves
 */
public class Ball {

    Circle hitbox;

    double x = 250;
    double y = 600;
    private double r = 5;

    private double speed = 5;

    private double dx = 1 * speed;
    private double dy = -1 * speed;

    Random random = new Random();

    Ball(){

    }

    /**
     * resets ball to launching position
     */
    public void reset(){

        x = 250;
        y = 600;
    }

    /**
     * chooses a random angle from 0 to pi
     */
    public void launch(){

        double randAngle = random.nextDouble();

        dx = speed * Math.cos(randAngle * Math.PI);
        dy = speed * Math.sin(randAngle * Math.PI);

    }

    /**
     * wall collision & ball movement
     */
    public void move() {


        //wall collision
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

        //movement
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
