import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 * Start of the program
 */
public class Main extends Application {

    Stage window;
    GameLoop mainGameLoop;

    @Override
    public void start(Stage primaryStage) throws Exception {

        //Window setup
        window = primaryStage;

        window.setTitle("Bounce the Ball");
        window.setMinHeight(Board.height +150);
        window.setMinWidth(Board.width);

        //Main Game Process + Scene
        mainGameLoop = new GameLoop();
        Scene gameScene = new Scene(mainGameLoop.display.layout, Board.width, Board.height);

        //Intro Scene
        VBox introRoot = new VBox();
        Scene introScene = new Scene(introRoot, 500, 800);

        introRoot.getChildren().add(new Text("PinBall!"));
        introRoot.getChildren().add(new Text("click play to launch the ball into the orange tiles"));
        introRoot.getChildren().add(new Text("if you miss a tile after 3 bounces, click reset to try again!"));

        //Start Button + Switch Scenes button action
        Button startBtn = new Button("Play Ball!");
        startBtn.setOnAction(e -> window.setScene(gameScene));
        startBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("what");
                window.setScene(gameScene);
            }
        });
        introRoot.getChildren().add(startBtn);

        window.setScene(gameScene);

        window.show();


    }

    public static void main(String[] args) {
        launch(args);
    }
}
