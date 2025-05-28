package bcc.QuartoGame;

import bcc.QuartoGame.Constants;

public class BoardPiece {
    // A value less than 0 indicates an unset value
    private int color; // 0 = white, 1 = black
    private int height; // 0 = low, 1 = high
    private int hollow; // 0 = solid, 1 = hollow
    private int round; // 0 = square, 1 = round

    // Initializes a blank board space
    public BoardPiece(){
        this.color = Constants.UNSET;
        this.height = Constants.UNSET;
        this.hollow = Constants.UNSET;
        this.round = Constants.UNSET;
    }

    // Sets the board space to contain the given attributes
    public void setPiece(int color, int height, int hollow, int round){
        this.color = color;
        this.height = height;
        this.hollow = hollow;
        this.round = round;
    }

    public boolean isEmpty(){
        if (this.color == -1){
            return true;
        }
        return false;
    }

    // Getter Methods
    public int getColor(){
        return color;
    }

    public int getHeight(){
        return height;
    }

    public int getHollow(){
        return hollow;
    }

    public int getRound(){
        return round;
    }
}