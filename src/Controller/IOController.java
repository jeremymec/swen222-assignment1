package Controller;

import View.IOView;

public class IOController {

    GameController gameController;

    IOView ioView;

    char[][] boardText;
    int textWidth;
    int textHeight;

    public IOController(GameController gameController){

        this.ioView = new IOView(this);
        this.gameController = gameController;

    }

    public void initBoard(int width, int height){

        textWidth = width * 3;
        textHeight = height * 3;

        boardText = new char[textWidth][textHeight];

        for (int y = 0; y < textHeight; y++) {

            for (int x = 0; x < textWidth; x++){

                boardText[x][y] = '@';

            }

        }

    }

    public void outputBoard(){
        for (int y = 0; y < textHeight; y ++){

            StringBuilder sb = new StringBuilder();

            for (int x = 0; x < textWidth; x++){

                sb.append(boardText[x][y]);

            }

            String line = sb.toString();

            ioView.output(line);

        }
    }

    public void updateTile(char[] values, int x, int y){

        // Order is Middle, Top, Bottom, Left, Right

        int middlePosX = x * 3 + 1;
        int middlePosY = y * 3 + 1;

        boardText[middlePosX][middlePosY] = values[0];
        boardText[middlePosX][middlePosY + 1] = values[1];
        boardText[middlePosX][middlePosY - 1] = values[2];
        boardText[middlePosX -1][middlePosY] = values[3];
        boardText[middlePosX + 1][middlePosY] = values[4];

        // Set blank values
        boardText[middlePosX + 1][middlePosY + 1] = ' ';
        boardText[middlePosX - 1][middlePosY - 1] = ' ';
        boardText[middlePosX + 1][middlePosY - 1] = ' ';
        boardText[middlePosX - 1][middlePosY + 1] = ' ';

    }

    public void startText(){
        ioView.output("Welcome to the game!");
    }


    public boolean inputExists(){
        return this.ioView.hasNext();
    }

    public String getInput(){
        return this.ioView.getInput();
    }

    public void output(String text){
        ioView.output(text);
    }

}
