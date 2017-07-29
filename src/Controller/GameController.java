package Controller;

import View.IOView;
import org.omg.CORBA.DynAnyPackage.Invalid;

public class GameController {

    IOController ioController;
    PlayerController playerController;
    BoardController boardController;
    TileController tileController;

    public GameController(){

        this.ioController = new IOController(this);
        this.playerController = new PlayerController();
        this.boardController = new BoardController(this.ioController);
        this.tileController = new TileController(boardController);

    }

    public void setupGame(){

        ioController.startText();

        boardController.setupBoard();

        int[] boardDims = boardController.getDims();
        ioController.initBoard(boardDims[0], boardDims[1]);


        gameLoop();

    }

    public void gameLoop(){

        while (ioController.inputExists()){

            ioController.outputBoard();
            ioController.output(ioController.getInput());

            try {

                tileController.createWallTile(0, 0);

            } catch (InvalidTilePosException e){

                ioController.output("Opps, can't place a tile out of board bounds");

            }


        }

    }

}
