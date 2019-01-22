import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.ArrayList;

/**
 * GUI display, update whats provides by the game loop
 */
class Display {

    private Group root;

    Circle ballView ;
    ArrayList<Rectangle> tileViews;

    private Text scoreView = new Text("sup?");

    Button resetButton = new Button("Reset");
    Button playButton = new Button("Play");

    BorderPane layout = new BorderPane();
    GraphicsContext gc;

    Display(){

        root = new Group();
        layout.setCenter(root);

        //Input & Score View
        HBox hBox = new HBox();
        hBox.setSpacing(100);
        hBox.getChildren().add(resetButton);
        hBox.getChildren().add(scoreView);
        hBox.getChildren().add(playButton);

        layout.setBottom(hBox);


    }

    void setupBoard(Board board){
        Rectangle r;
        tileViews = new ArrayList<>();

        for (Tile t : board.tiles) {

            r = new Rectangle(t.pos.getX(), t.pos.getY());
            r.setFill(Color.BLUE);
            r.setStrokeWidth(10);
            r.setStroke(Color.DARKBLUE);
            tileViews.add(r);
            root.getChildren().add(r);
        }
    }

    void setupBall(Ball ball){


        ballView = new Circle(10);

        ballView.setCenterX(ball.getX());
        ballView.setCenterY(ball.getY());

        ballView.setFill(Color.RED);
        ballView.setStroke(Color.BLACK);
        root.getChildren().add(ballView);

    }

    void moveBall(Ball ball){

        ballView.setCenterX(ball.getX());
        ballView.setCenterY(ball.getY());

    }

    void setupCanvas(Group root){

        //Our tool for drawing the board:
        Canvas canvas = new Canvas(500,600);
        root.getChildren().add(canvas);
        gc = canvas.getGraphicsContext2D();

        gc.setFill(Color.FORESTGREEN);
        gc.setStroke(Color.DIMGREY);
        gc.setLineWidth(40);
        gc.fillOval(10, 10, 200, 200);
    }

}
