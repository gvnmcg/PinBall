import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * GUI display, update whats provides by the game loop
 */
class Display {

    private Group root;

    Circle ballView;
    ArrayList<Rectangle> tileViews;

    HashMap<Tile, Rectangle> tileToViewMap = new HashMap<>();

    private Text scoreView = new Text("sup?");

    Button resetButton = new Button("Reset");
    Button playButton = new Button("Play");

    BorderPane layout = new BorderPane();
    GraphicsContext gc;

    Display(Board board, Ball ball) {

        //root of game view & adding game components
        root = new Group();
        layout.setCenter(root);

        showBoard(board);
        showBall(ball);

        //Input & Score View
        HBox hBox = new HBox();
        hBox.setSpacing(100);
        hBox.getChildren().add(resetButton);
        hBox.getChildren().add(scoreView);
        hBox.getChildren().add(playButton);

        layout.setBottom(hBox);
    }

    void showBoard(Board board){
        Rectangle r;
        tileViews = new ArrayList<>();

        for (Tile t : board.tiles) {

            r = new Rectangle(t.pos.getX(), t.pos.getY(), t.size,t.size);

            if (t.isTarget()){
                r.setFill(Color.ORANGE);
            } else {
                r.setFill(Color.BLUE);
            }

            t.view = r;
            //or
            tileToViewMap.put(t, r);

            r.setStrokeWidth(10);
            r.setStroke(Color.DARKBLUE);
            tileViews.add(r);
            root.getChildren().add(r);
        }
    }

    void showBall(Ball ball){

        ballView = new Circle(10);

        ballView.setCenterX(ball.getX() + 5);
        ballView.setCenterY(ball.getY() + 5);

        ballView.setFill(Color.RED);
        ballView.setStroke(Color.BLACK);
        root.getChildren().add(ballView);

    }

    void moveBall(Ball ball){

        ballView.setCenterX(ball.getX());
        ballView.setCenterY(ball.getY());

    }

    Rectangle getTileView(Tile tile){

        return tileToViewMap.containsKey(tile) ?
                tileToViewMap.get(tile) : null;
    }
}
