import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * Start of the program
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Bounce the Ball");
        primaryStage.setMinHeight(800);
        primaryStage.setMinWidth(500);

        GameLoop mainGameLoop = new GameLoop();

        primaryStage.setScene(new Scene(mainGameLoop.display.layout, 500, 800));


    }
}
