package Controller;

public class GameController {

    IOController ioController;
    PlayerController playerController;
    BoardController boardController;
    TileController tileController;
    ActionController actionController;

    public GameController(){

        this.ioController = new IOController(this);
        this.playerController = new PlayerController(this, ioController);
        this.boardController = new BoardController(this.ioController);
        this.tileController = new TileController(boardController);
        this.actionController = new ActionController(this);

    }

    public void setupGame(){

        ioController.startText();

        boardController.setupBoard();

        int[] boardDims = boardController.getDims();
        ioController.initBoard(boardDims[0], boardDims[1]);

        playerController.setupPlayers();

        gameLoop();

    }

    public void gameLoop(){

        while (ioController.inputExists()){

            try {
                actionController.processInput(ioController.getInput());
            }

        }

    }

}
