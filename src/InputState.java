import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * Encapsulates the input form the mouse and buttons
 */
public class InputState {


    public EventHandler<MouseEvent> handleReset() {

        return new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("reset");
            }
        };
    }

    public EventHandler<MouseEvent> handlePlay() {
        return new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("play");
            }
        };
    }
}
