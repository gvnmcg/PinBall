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

    Circle ballView ;

    private Text scoreView = new Text("sup?");

    Button resetButton = new Button("Reset");
    Button playButton = new Button("Play");

    BorderPane layout = new BorderPane();
    GraphicsContext gc;

    Display(){

        //Board View
        Group root = new Group();
        ballView = new Circle(50);


        layout.setCenter(root);

        //Our tool for drawing the board:
        Canvas canvas = new Canvas(500,600);
        root.getChildren().add(canvas);
        gc = canvas.getGraphicsContext2D();

        gc.setFill(Color.FORESTGREEN);
        gc.fillOval(10, 10, 200, 200);



        //Input & Score View
        HBox hBox = new HBox();
        hBox.setSpacing(100);
        hBox.getChildren().add(resetButton);
        hBox.getChildren().add(scoreView);
        hBox.getChildren().add(playButton);

        layout.setBottom(hBox);


    }

    void paintBall(Ball ball){
        gc.fillOval(ball.getX(), ball.getY(), 50,50);
    }

    void paintTiles(Board board){

        //paint all 30 blue
        gc.setFill(Color.DARKBLUE);

        //plaint the choosen ones orange

    }
}
