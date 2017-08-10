package Model;

public class InvalidSyntaxException extends Exception {

    public InvalidSyntaxException(String message){
        super("SYNTAX ERROR: " + message);
    }

}
