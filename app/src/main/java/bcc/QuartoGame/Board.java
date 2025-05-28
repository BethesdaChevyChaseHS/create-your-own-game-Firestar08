package bcc.QuartoGame;

import bcc.QuartoGame.BoardPiece;

public class Board {
    BoardPiece[][] board = new BoardPiece[4][4];

    // Initializes a 4x4 grid of empty spaces
    public Board(){
        for (int row = 0; row < 4; row ++){
            for (int col = 0; col < 4; col ++){
                board[row][col] = new BoardPiece();
                
            }
        }
    }
// Checks if a space is empty and populates it with the given attributes if so
    public boolean markSpace(int row, int col, int color, int height, int hollow, int round){
        if (isEmpty(row, col) == true){
            board[row][col].setPiece(color, height, hollow, round);
            return true;
        }
        return false;
    }
    // Returns true if a space is empty
    public boolean isEmpty(int row, int col){
        if (board[row][col].isEmpty() == true){
            return true;
        }
        return false;
    }

    // Returns true if a given two spaces share an attribute
    public boolean CheckMatch(int rowA, int colA, int rowB, int colB){
        // Checks if the colors match
        if (board[rowA][colA].getColor() == board[rowB][colB].getColor()){
            return true;
        }
        // Checks if the heights match
        else if (board[rowA][colA].getHeight() == board[rowB][colB].getHeight()){
            return true;
        }
        // Checks if the "hollow" attributes match
        else if (board[rowA][colA].getHollow() == board[rowB][colB].getHollow()){
            return true;
        }
        // Checks if the "round" attributes match
        else if (board[rowA][colA].getRound() == board[rowB][colB].getRound()){
            return true;
        }
        return false;
    }

    // Returns true if any 4 spaces in a row share an attribute (including diagonals)
    public boolean checkWin(){
        for (int row = 0; row < 4; row ++){ // Loops every row
            int lineLength = 0;
            for (int i = 1; i < 4; i ++){
                // Checks if the first space in the row is empty
                if (isEmpty(row, 0) == true){
                    lineLength += 0;
                }
                // Checks if each other space in the row matches the first space
                else if (CheckMatch(row, 0, row, i)){
                    lineLength ++;
                }
            }
            // Returns true if the row has 4 matching spaces
            if (lineLength == 3){
                return true;
            }
        }
        for (int col = 0; col < 4; col ++){  // Loops every column
            int lineLength = 0;
            for (int i = 1; i < 4; i ++){
                // Checks if the first space in the column is empty
                if (isEmpty(0, col) == true){
                    lineLength += 0;
                }
                // Checks if each other space in the column matches the first space
                else if (CheckMatch(0, col, i, col)){
                    lineLength ++;
                }
            }
            // Returns true if the column has 4 matching spaces
            if (lineLength == 3){
                return true;
            }
        }
        return false; // returns if no winning lines are found
    }

    // Returns a space's color using the boardpiece.getColor() method
    public int getColor(int row, int col){
        return board[row][col].getColor();
    }
    // Returns a space's height using the boardpiece.getHeight() method
    public int getHeight(int row, int col){
        return board[row][col].getHeight();
    }
    // Returns if a space is hollow using the boardpiece.getHollow() method
    public int getHollow(int row, int col){
        return board[row][col].getHollow();
    }
    // Returns if a space is round using the boardpiece.getRound() method
    public int getRound(int row, int col){
        return board[row][col].getRound();
    }
}
