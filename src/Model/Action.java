package Model;

public abstract class Action {

    public abstract boolean processInput(String input) throws InvalidSyntaxException;

    public abstract void executeAction();

}
