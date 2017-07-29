package Model.Tile;

public class WallTile extends Tile {

    public char middle;
    public char top;
    public char bottom;
    public char left;
    public char right;

    public WallTile(){
        super('#', '#', '#', '#', '#');
    }

}
