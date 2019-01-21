import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/**
 * Encapsulates the input form the mouse and buttons
 */
public class InputState {

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
