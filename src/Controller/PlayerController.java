package Controller;

import Model.Player;

public class PlayerController {

    GameController gameController;
    IOController ioController;

    Player player1;
    Player player2;

    Player currentTurn;

    public PlayerController(GameController gameController, IOController ioController){

        this.gameController = gameController;
        this.ioController = ioController;

    }

    public void setupPlayers(){

        setupFirstPlayer();
        setupSecondPlayer();

    }

    void setupFirstPlayer(){

        ioController.output("First player, please enter your username");
        String name = ioController.getInput();

        if (!checkName(name)){
            setupFirstPlayer();
            return;
        }

        player1 = new Player(name);

    }

    void setupSecondPlayer(){

        ioController.output("Second player, please enter your username");
        String name = ioController.getInput();

        if (!checkName(name)){
            setupSecondPlayer();
            return;
        }

        player2 = new Player(name);

    }

    boolean checkName(String name) {

        if (name.length() < 2) {
            ioController.output("Ops, your name needs to be at least three characters long");
            return false;
        } else if (name.length() > 8) {
            ioController.output("Ops, your name can't be longer than eight characters");
            return false;
        } else if (!name.matches("[a-zA-Z]+")) {
            ioController.output("Ops, your name can only have letters");
            return false;
        } else if (player1 != null) {
            if (name.equals(player1.getName())) {
                ioController.output("Ops, can't both have the same name");
                return false;
            }
        } else if (player2 != null) {
            if (name.equals(player2.getName())) {
                ioController.output("Ops, can't both have the same name");
                return false;
            }
        }
        return true;
    }
}
