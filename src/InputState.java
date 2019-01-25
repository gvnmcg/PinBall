import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

/**
 * Encapsulates the input form the mouse and buttons
 */
public class InputState {

    Ball ball;
    Display display;

    InputState(Ball ball, Display display){
        this.ball = ball;
        this.display = display;
    }

    public EventHandler<KeyEvent> handleKeyMovement(){
        return new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

                if (event.getCode() == KeyCode.RIGHT){
                    ball.x -= 5;
                    display.showBall(ball);
                }
            }
        };
    }

    /**
     * Handler method for reset button
     * @param gameLoop containing reset GameLoop control
     * @return reset Handler
     */
    public EventHandler<MouseEvent> handleReset(GameLoop gameLoop) {

        return new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("reset");
                gameLoop.reset();
            }
        };
    }

    /**
     * Handler Method to play, or teh ball in motion
     * @param gameLoop containing the play Gameloop Control
     * @return play Handler
     */
    public EventHandler<MouseEvent> handlePlay(GameLoop gameLoop) {
        return new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("play");
                gameLoop.play();
            }
        };
    }
}
