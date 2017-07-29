package Controller;

import Model.Board;
import Model.Tile.Tile;

public class BoardController {

    IOController ioController;

    Board board;

    public BoardController(IOController ioController){

        this.ioController = ioController;

    }

    public void setupBoard(){

        this.board = new Board();

    }

    public int[] getDims(){
        int dim[] = new int[2];

        dim[0] = Board.width;
        dim[1] = Board.height;

        return dim;
    }

    public void insertTile(Tile tile, int x, int y){

        board.insertTile(tile, x, y);

        // Order is Middle, Top, Bottom, Left, Right
        char[] values = new char[5];

        values[0] = tile.middle;
        values[1] = tile.top;
        values[2] = tile.bottom;
        values[3] = tile.left;
        values[4] = tile.right;

        ioController.updateTile(values, x, y);

    }

    public boolean checkRange(int x, int y){

        return ((x >= 0 && x < Board.width) && (y >= 0 && y < Board.height));

    }


}
