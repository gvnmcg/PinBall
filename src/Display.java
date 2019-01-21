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

//        ballView.setFill(Color.RED);
//        ballView.setStroke(Color.BLACK);

        setupCanvas(root);

        //Input & Score View
        HBox hBox = new HBox();
        hBox.setSpacing(100);
        hBox.getChildren().add(resetButton);
        hBox.getChildren().add(scoreView);
        hBox.getChildren().add(playButton);

        layout.setBottom(hBox);


    }

    void setupCanvas(Group root){
        layout.setCenter(root);

        //Our tool for drawing the board:
        Canvas canvas = new Canvas(500,600);
        root.getChildren().add(canvas);
        gc = canvas.getGraphicsContext2D();

        gc.setFill(Color.FORESTGREEN);
        gc.setStroke(Color.DIMGREY);
        gc.setLineWidth(40);
        gc.fillOval(10, 10, 200, 200);
    }

    void paintComponents(Board board, Ball ball){

        paintTiles(board);
        paintBall(ball);

    }

    private void paintBall(Ball ball){
        gc.setFill(Color.RED);
        gc.setStroke(Color.BLACK);
        gc.fillOval(ball.getX(), ball.getY(), 50,50);
    }

    private void paintTiles(Board board){

        //paint all 30 blue
        gc.setFill(Color.DARKBLUE);
        gc.setStroke(Color.LIGHTBLUE);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                gc.fillRect(i * 100, j * 100, 100, 100);
            }
        }

        //plaint the choosen ones orange

        gc.setFill(Color.ORANGE);
        gc.setStroke(Color.FORESTGREEN);
        for (Integer i : board.targets){
            gc.fillRect(500/i, 600 % i, 100, 100);
        }

    }
}
