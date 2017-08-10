package Model;

import Controller.ActionController;
import org.apache.commons.lang3.*;

public class createPieceAction extends Action {

    ActionController actionController;

    public createPieceAction(ActionController actionController){
        this.actionController = actionController;
    }

    @Override
    public boolean processInput(String input) throws InvalidSyntaxException {
        String[] splitInput = input.split(" ");

        if (splitInput[0].equals("create")){
            checkSyntax(splitInput);
        } else {
            return false;
        }

        return false;
    }

    public boolean checkSyntax (String[] input) throws InvalidSyntaxException{

        char name;
        int orientation;

        // Check input is three strings split by spaces
        if (input.length > 3){
            throw new InvalidSyntaxException("Too many parameters; syntax is “create <letter> <0/90/180/270>");
        } else if (input.length < 3){
            throw new InvalidSyntaxException("Not enough parameters; syntax is “create <letter> <0/90/180/270>");
        }

        // Check piece name parameter is both one character long and alphabetical
        if (input[1].length() == 1){

            name = Character.toUpperCase(input[1].charAt(0));

            if (!Character.isAlphabetic(name)){
                throw new InvalidSyntaxException("Piece name must be alphabetical!");
            }

        } else {
            throw new InvalidSyntaxException("Piece name must be one character long!");
        }

        // Check the orientation parameter is a number, and one of the four valid options
        if (StringUtils.isNumeric(input[2])){

            orientation = Integer.parseInt(input[2]);

            if (!(orientation == 0 | orientation == 90 | orientation == 180 | orientation == 270)){
                throw new InvalidSyntaxException("Piece orientation must be one of 0/90/180/270!");
            }

        } else {

            throw new InvalidSyntaxException("Piece orientation must be an integer!");

        }

        System.out.println("create command valid");
        return true;

    }


    @Override
    public void executeAction() {

    }
}
