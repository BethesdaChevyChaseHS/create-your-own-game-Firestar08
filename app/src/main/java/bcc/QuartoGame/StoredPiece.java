package bcc.QuartoGame;

import bcc.QuartoGame.Constants;

public class StoredPiece {
    private int color; // 0 = white, 1 = black, -1 = unset
    private int height; // 0 = low, 1 = high, -1 = unset
    private int hollow; // 0 = solid, 1 = hollow, -1 = unset
    private int round; // 0 = square, 1 = round, -1 = unset

    // Initializes an empty space in the storage grid
    public StoredPiece(int color, int height, int hollow, int round){
        this.color = Constants.UNSET;
        this.height = Constants.UNSET;
        this.hollow = Constants.UNSET;
        this.round = Constants.UNSET;
    }

    // Clears a space in the storage grid
    public void removePiece(){
        this.color = Constants.UNSET;
        this.height = Constants.UNSET;
        this.hollow = Constants.UNSET;
        this.round = Constants.UNSET;
    }

    // Getter methods
    public int getColor(){
        return this.color;
    }

    public int getHeight(){
        return this.height;
    }

    public int getHollow(){
        return this.hollow;
    }

    public int getRound(){
        return this.round;
    }

    public String toString(){
        return "" + this.color + this.height + this.hollow + this.round;
    }
}
