import javafx.animation.AnimationTimer;
import javafx.event.EventType;
import javafx.scene.input.KeyEvent;

/**
 * Controls the Game
 */
class GameLoop {

    //The only moving part, ball, uses a
    //timer calling move and its redisplay
    //method
    Ball ball = new Ball();
    AnimationTimer animationTimer;
    boolean running = false;

    Board board = new Board();
    Score score = new Score();

    //Layout and Graphical components
    Display display = new Display(board, ball);


    GameLoop(){

        InputState inputState = new InputState(ball, display);

        display.root.setFocusTraversable(true);
        display.root.addEventHandler(
                KeyEvent.KEY_PRESSED,inputState.handleKeyMovement());

        //In-Game Time
        animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now){
                ball.move();
                display.updateBall(ball);
                board.detectHit(ball);
            }
        };

        display.resetButton.setOnAction( e-> {
            reset();
        });

        display.playButton.setOnAction(e -> {
            play();
        });


    }

    void reset(){
        ball.reset();
        score.reset();

        animationTimer.stop();
        running = false;
    }

    void play(){

        animationTimer.start();
        running = true;
    }
}
