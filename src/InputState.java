import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/**
 * Encapsulates the input form the mouse and buttons
 */
public class InputState {


    public EventHandler<MouseEvent> handleReset(GameLoop gameLoop) {

        return new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("reset");
                gameLoop.reset();
            }
        };
    }

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
