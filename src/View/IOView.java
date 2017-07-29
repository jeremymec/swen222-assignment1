package View;

import Controller.GameController;

import java.util.Scanner;

public class IOView {

    GameController gameController;

    TileView tileView;

    Scanner textScanner;

    public IOView(GameController gameController){

        this.gameController = gameController;
        this.textScanner = new Scanner(System.in);
        this.tileView = new TileView(this);

    }

    public boolean hasNext(){

        return this.textScanner.hasNext();

    }

    public void output(String text){

        System.out.println(text);

    }

    public String getInput(){

        return textScanner.nextLine();

    }

}
