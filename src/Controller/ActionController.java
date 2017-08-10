package Controller;

import Model.Action;
import Model.InvalidSyntaxException;
import Model.createPieceAction;
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

    /***
     * Add new actions to the game inside this function
     */
    public void setupActions(){
        actions.add(new passAction(this));
        actions.add(new createPieceAction(this));
        // TODO - Add actions to this
    }

    /***
     * Takes a string and attempts to execute the corresponding action if one exists by looping through all Actions
     * @param input The string to process
     * @return returns true if action to process exists, false if not
     */
    public boolean processInput(String input) throws InvalidSyntaxException{

        for (Action action : actions){
            if (action.processInput(input)){
                return true;
            }
        }

        return false;
    }


    /***
     * Method used by different actions; passes the string to the ioController for output
     * @param text the string to output
     */
    public void output(String text){
        this.ioController.output(text);
    }
}
