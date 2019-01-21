import javafx.animation.AnimationTimer;

/**
 * Controls the Game
 */
class GameLoop {

    InputState inputState = new InputState();

    Display display = new Display();

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
                display.paintBall(ball);
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
