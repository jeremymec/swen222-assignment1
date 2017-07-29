package View;

import Controller.GameController;
import Controller.IOController;

import java.util.Scanner;

public class IOView {

    IOController ioController;

    TileView tileView;

    Scanner textScanner;

    public IOView(IOController ioController){

        this.ioController = ioController;
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
