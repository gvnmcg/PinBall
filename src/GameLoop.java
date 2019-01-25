import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * Controls the Game
 */
class GameLoop {

    //Game Components
    private Board board = new Board();
    private Score score = new Score();

    //The only moving part, ball, uses a
    //timer calling move and its redisplay
    //method
    private Ball ball = new Ball();
    private AnimationTimer animationTimer;
    private boolean running = false;

    //Layout and Graphical components
    Display display = new Display(board, score, ball);


    /**
     * sets user controls/Event handlers
     * initializes animation timer
     * button action
     */
    GameLoop(){

        setUserControls();

        //In-Game Time
        animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now){
               update();
            }
        };

        display.getResetButton().setOnAction( e-> {
            reset();
        });

        display.getPlayButton().setOnAction(e -> {
            play();
        });


    }

    /**
     * animation timer calls this constantly when runnning
     */
    private void update(){

        //movement
        ball.move();
        display.updateBall(ball);

        //target hit
        if(board.detectHit(ball)){
            score.hitTileCount();
            ball.setMisses(0);
        }

        if (ball.getMisses() >= 3){
            reset();
        }
    }

    /**
     * called when game is lost or reset button is clicked
     * resets all components of the game
     */
    void reset(){

        display.getResetButton().setDisable(true);
        display.getPlayButton().setDisable(false);

        ball.reset();
        score.reset();
        board.reset();

        animationTimer.stop();
        running = false;
    }

    /**
     * called when board display/play button is clicked
     * launches the ball, starting the animation timer
     */
    void play(){


        display.getResetButton().setDisable(false);
        display.getPlayButton().setDisable(true);
        if (!running) {
            ball.launch();
            animationTimer.start();
            running = true;
        }
    }

    /**
     * adds event handlers to display
     */
    private void setUserControls(){
        display.getRoot().setFocusTraversable(true);

        display.getRoot().addEventHandler(
                MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {

                        if (!running){
                            ball.setX(event.getX());
                            display.updateBall(ball);
                        }

                    }
                });

        display.getRoot().addEventHandler(
                MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        play();
                    }
                });
    }
}
