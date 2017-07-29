package Model.Tile;

public class WallTile implements Tile {

    public char middle;
    public char top;
    public char bottom;
    public char left;
    public char right;

    public WallTile(){

        this.middle = '#';
        this.top = '#';
        this.bottom = '#';
        this.left = '#';
        this.right = '#';

    }

}
