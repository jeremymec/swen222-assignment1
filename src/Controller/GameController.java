package Controller;

import View.IOView;

public class GameController {

    IOView ioView;
    PlayerController playerController;

    public GameController(){

        this.ioView = new IOView(this);
        this.playerController = new PlayerController();

    }

    public void setupGame(){

        ioView.output("Welcome to the game!");
        gameLoop();

    }

    public void gameLoop(){

        while (ioView.hasNext()){

            ioView.output(ioView.getInput());

        }

    }

}
