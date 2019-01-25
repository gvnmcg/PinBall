import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * Controls the Game
 */
class GameLoop {

    Board board = new Board();
    Score score = new Score();

    //The only moving part, ball, uses a
    //timer calling move and its redisplay
    //method
    Ball ball = new Ball();
    AnimationTimer animationTimer;
    boolean running = false;

    //Layout and Graphical components
    Display display = new Display(board, score, ball);


    GameLoop(){

        setUserControls();

        //In-Game Time
        animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now){
               update();
            }
        };

        display.resetButton.setOnAction( e-> {
            reset();
        });

        display.playButton.setOnAction(e -> {
            play();
        });


    }

    void update(){
        ball.move();
        display.updateBall(ball);
        if(board.detectHit(ball)){
            score.hitTileCount();
        }
    }

    void reset(){
        ball.reset();
        score.reset();

        animationTimer.stop();
        running = false;
    }

    void play(){

        if (!running) {
            ball.launch();
            animationTimer.start();
            running = true;
        }
    }

    void setUserControls(){
        display.root.setFocusTraversable(true);

        display.root.addEventHandler(
                MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {

                        if (!running){
                            ball.x = event.getX();
                            display.updateBall(ball);
                        }

                    }
                });

        display.root.addEventHandler(
                MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        play();
                    }
                });
    }
}
