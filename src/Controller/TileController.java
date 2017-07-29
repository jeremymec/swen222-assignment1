package Controller;

import Model.Tile.Tile;
import Model.Tile.WallTile;

public class TileController {

    BoardController boardController;

    public TileController(BoardController boardController){

        this.boardController = boardController;

    }

    public void createWallTile(int x, int y) throws InvalidTilePosException{

        if (!boardController.checkRange(x, y)){
            throw new InvalidTilePosException();
        }

        Tile wallTile = new WallTile();

        boardController.insertTile(wallTile, x, y);

    }

}
