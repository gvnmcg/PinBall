import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

/**
 * GUI display, update whats provides by the game loop
 */
class Display {

    Board board;

    Ball ball;
    private Circle ballView = new Circle(30);

    Score score;
    private Text scoreView = new Text("sup?");

    Button resetButton = new Button("Reset");
    Button playButton = new Button("Play");

    BorderPane layout = new BorderPane();

    Display(){

        //Board View
        Group root = new Group();
        layout.setCenter(root);

        Canvas canvas = new Canvas(500,600);
        root.getChildren().add(canvas);

        //Our tool for drawing the board:
        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setFill(Color.FORESTGREEN);
        gc.fillOval(10, 10, 200, 200);

        //Input & Score View
        HBox hBox = new HBox();
        hBox.setSpacing(100);
        layout.setBottom(hBox);
        hBox.getChildren().add(resetButton);
        hBox.getChildren().add(scoreView);
        hBox.getChildren().add(playButton);

    }
}
