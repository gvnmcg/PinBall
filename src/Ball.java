import javafx.scene.shape.Circle;

import java.util.Random;

/**
 * keeps track of the state of the ball, rests and moves
 */
public class Ball {

    Circle hitbox;

    double x = 250;
    double y = 625;
    private double r = 5;

    private double speed = 5;

    private double dx = 1 * speed;
    private double dy = -1 * speed;

    private Random random = new Random();

    private int misses = 0;

    Ball(){

    }

    /**
     * resets ball to launching position
     */
    public void reset(){

        x = 250;
        y = 625;

        misses = 0;
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
        //left wall
        if (x+r > Board.width && dx > 0){
            dx = -dx;
            misses++;
        }

        //right wall
        if (x-r < 0 && dx < 0){
            dx = -dx;
            misses++;
        }

        //bottom wall
        if (y+r > Board.height && dy > 0){
            dy = -dy;
            misses++;
        }

        //top wall
        if (y-r < 0 && dy < 0){
            dy = -dy;
            misses++;
        }

        //movement
        x += dx;
        y += dy;

    }

    public void setMisses(int misses) {
        this.misses = misses;
    }

    public int getMisses() {
        return misses;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }
}
