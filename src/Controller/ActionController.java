package Controller;

import Model.Action;
import Model.passAction;

import java.util.ArrayList;

public class ActionController {

    GameController gameController;
    BoardController boardController;
    IOController ioController;
    PlayerController playerController;

    ArrayList<Action> actions;

    public  ActionController(GameController gameController){
        this.gameController = gameController;
        this.boardController = gameController.boardController;
        this.ioController = gameController.ioController;
        this.playerController = gameController.playerController;

        this.actions = new ArrayList<>();

        setupActions();
    }

    public void setupActions(){
        actions.add(new passAction(this));
    }

    public boolean processInput(String input){

        for (Action action : actions){
            if (action.processInput(input)){
                return true;
            }
        }

        return false;
    }

    // Methods required for actions to execute

    public void output(String text){
        this.ioController.output(text);
    }
}
