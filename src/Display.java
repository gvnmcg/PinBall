import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;

/**
 * GUI display, update whats provides by the game loop
 */
class Display {

    //game view
    private Group root;

    private Circle ballView;
    private ArrayList<Rectangle> tileViews;

    private Button resetButton = new Button("Reset");
    private Button playButton = new Button("Play");

    private BorderPane layout = new BorderPane();

    /**
     * displays game components
     * @param board - each tile displayed as a rectangle
     * @param score - text at the bottom
     * @param ball - a red ball
     */
    Display(Board board, Score score, Ball ball) {

        //root of game view & adding game components
        root = new Group();
        layout.setCenter(root);

        showBoard(board);
        showBall(ball);

        //Input & Score View
        HBox hBox = new HBox();
        layout.setBottom(hBox);

        hBox.setSpacing(210);
        hBox.getChildren().add(resetButton);
        hBox.getChildren().add(score.text);
        hBox.getChildren().add(playButton);

    }

    /**
     * initialize board display
     * each tile displayed as a blue rectangle
     * targets are displayed as orange
     * @param board
     */
    private void showBoard(Board board){
        Rectangle r;
        tileViews = new ArrayList<>();

        //botton grey rectangle
        r = new Rectangle( -5, Board.height, Board.width + 10, 50);
        r.setFill(Color.GRAY);
        root.getChildren().add(r);

        for (Tile t : board.tiles) {

            r = new Rectangle(t.getPosition().getX(),
                    t.getPosition().getY(), t.getSize(),t.getSize());

            if (t.isTarget()){
                r.setFill(Color.ORANGE);
            } else {
                r.setFill(Color.BLUE);
            }

            t.setView(r);

            r.setStrokeWidth(10);
            r.setStroke(Color.DARKBLUE);
            tileViews.add(r);
            root.getChildren().add(r);
        }
    }

    /**
     * initialize ball display
     * @param ball
     */
    private void showBall(Ball ball){

        ballView = new Circle(10);

        updateBall(ball);

        ballView.setFill(Color.RED);
        ballView.setStroke(Color.BLACK);
        root.getChildren().add(ballView);

    }

    /**
     * update circle display position
     * @param ball
     */
    void updateBall(Ball ball){
        ballView.setCenterX(ball.getX() + 5);
        ballView.setCenterY(ball.getY() + 5);
    }

    public Group getRoot() {
        return root;
    }

    public Button getResetButton() {
        return resetButton;
    }

    public Button getPlayButton() {
        return playButton;
    }

    public BorderPane getLayout() {
        return layout;
    }
}
