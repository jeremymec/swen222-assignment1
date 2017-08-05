package Model;

import Controller.ActionController;

public class passAction extends Action {

    ActionController actionController;

    public passAction(ActionController actionController){
        this.actionController = actionController;
    }

    @Override
    public boolean processInput(String input) {
        if(input.equals("pass")){
            executeAction();
            return true;
        }
        return false;
    }

    @Override
    public void executeAction() {
        actionController.output("Turn passed!");
    }
}
