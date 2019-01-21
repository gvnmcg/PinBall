import javafx.animation.AnimationTimer;

/**
 * Controls the Game
 */
class GameLoop {

    //Event handlers for human input
    InputState inputState = new InputState();

    //Layout and Graphical components
    Display display = new Display();

    //The only moving part, ball, uses a
    //timer calling move and its redisplay
    //method
    Ball ball = new Ball();
    AnimationTimer animationTimer;


    Board board = new Board();
    Score score = new Score();

    GameLoop(){

        animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now){
                System.out.println(" wow");
                ball.move();
                display.moveBall(ball);
                display.paintComponents(board, ball);
            }
        };

        //add inputState EventHandlers to Displays buttons
        display.resetButton.setOnMouseClicked(inputState.handleReset(this));
        display.playButton.setOnMouseClicked(inputState.handlePlay(this));


    }

    void reset(){
        ball.reset();
        board.reset();
        score.reset();

        animationTimer.stop();
    }

    void play(){
        animationTimer.start();
    }
}
