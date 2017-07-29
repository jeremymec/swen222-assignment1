package Model.Tile;

public abstract class Tile {

    public char middle;
    public char top;
    public char bottom;
    public char left;
    public char right;

    public Tile(char middle, char top, char bottom, char left, char right){
        this.middle = middle;
        this.top = top;
        this.bottom = bottom;
        this.left = left;
        this.right = right;

    }

}
