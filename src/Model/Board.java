package Model;

import Model.Tile.Tile;
import Model.Tile.WallTile;

public class Board {

    public static int width = 5;
    public static int height = 5;

    Tile[][] tiles = new Tile[width][height];

    public Board(){

        init();

    }

    void init(){

        for (int y = 0; y < height; y++){

            for (int x = 0; x < width; x++){

                tiles[x][y] = new WallTile();

            }

        }

    }

    public Tile getTileByPos(int x, int y){

        return tiles[x][y];

    }

    public void insertTile(Tile t, int x, int y){

        tiles[x][y] = t;

    }

}
