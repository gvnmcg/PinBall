import javafx.animation.AnimationTimer;

/**
 * Controls the Game
 */
class GameLoop {

    //The only moving part, ball, uses a
    //timer calling move and its redisplay
    //method
    Ball ball = new Ball();
    AnimationTimer animationTimer;


    Board board = new Board();
    Score score = new Score();

    //Layout and Graphical components
    Display display = new Display(board, ball);


    GameLoop(){

        //In-Game Time
        animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now){
                ball.move();
                display.moveBall(ball);
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
    }

    void play(){

        animationTimer.start();
    }
}
