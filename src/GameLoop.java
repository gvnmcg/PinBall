/**
 * Controls the Game
 */
class GameLoop {

    InputState inputState = new InputState();

    Display display = new Display();

    Ball ball = new Ball();
    Board board = new Board();
    Score score = new Score();

    GameLoop(){

        display.ball = ball;
        display.board = board;
        display.score = score;

        display.resetButton.setOnMouseClicked(inputState.handleReset());
        display.playButton.setOnMouseClicked(inputState.handlePlay());



    }
}
