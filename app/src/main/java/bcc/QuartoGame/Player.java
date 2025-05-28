package bcc.QuartoGame;

public class Player {
    StorageBoard playerStorage;
    private int selectedPiece;
    private int selectedSpace;
    private int turnPhase; // Stages: Piece Selection == 0, Placement Selection == 1, Opponent Piece Selection == 2, Turn end == 3
    private int[][] selectionBoard = new int[4][4];
    private int selectedRow;
    private int selectedCol;

    // Initializes the pieces for the two players and the playing board
    public Player(int color, int turnPhase){
        playerStorage = new StorageBoard(color);
        selectedPiece = -1;
        this.turnPhase = turnPhase;
        int i = 0;
        for (int row = 0; row < 4; row ++){
            for (int col = 0; col < 4; col ++){
                selectionBoard[row][col] = i;
                i ++;
            }
        }
        selectedRow = 0;
        selectedCol = 0;
        selectedSpace = selectionBoard[selectedRow][selectedCol];
    }

    // Selects a piece from the available storage pieces
    public boolean pickUp(int piece){
        if (turnPhase == 0){
            selectedPiece = piece;
            return true;
        }
        return false;
    }

    // Locks in the piece selection, resets variables if the turn has ended
    public void finalizeChoice(){
        checkSelection();
        turnPhase ++;
        if (turnPhase == 3){
            resetTurn();
        }
    }

    // Checks if a piece selection is valid
    public boolean checkSelection(){
        if (turnPhase == 0){
            if (selectedPiece >= 0){
                return true;
            }
        }
        else if (turnPhase == 1){
            if (selectedSpace >= 0){
                return true;
            }
        }
        else if (turnPhase == 2){
            if (selectedPiece >= 0){
                return true;
            }
        }
        return false;
    }

    // Resets the player for the next turn
    public void resetTurn(){
        selectedPiece = 0;
        selectedRow = 0;
        selectedCol = 0;
        selectedSpace = 0;
    }

    // Returns the current phase of the turn
    public int getTurnPhase(){
        return turnPhase;
    }

    // returns the currently selected piece
    public int getSelectedPiece(){
        return selectedPiece;
    }

    // decreases the board placement selection row
    public void decreaseRow(){
        if (selectedRow > 0){
            selectedRow --;
        }
    }

    //increases the board placement selection row
    public void increaseRow(){
        if (selectedRow < 3){
            selectedRow ++;
        }
    }
    // increases the board placement selection column
    public void decreaseCol(){
        if (selectedCol > 0){
            selectedCol --;
        }
    }

    // increases the board placement selection column
    public void increaseCol(){
        if (selectedRow < 3){
            selectedCol ++;
        }
    }
}
