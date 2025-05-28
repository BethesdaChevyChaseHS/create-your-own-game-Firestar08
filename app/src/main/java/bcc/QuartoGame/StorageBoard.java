package bcc.QuartoGame;

import bcc.QuartoGame.Constants;

public class StorageBoard {
    private StoredPiece[] storage = new StoredPiece[8];

    // Initializes 8 pieces in storage with set values and a given color, one piece with every combination of attributes exists
    public StorageBoard(int color){
        // Temporary solution
        storage[0] = new StoredPiece(color, Constants.LOW, Constants.SOLID, Constants.SQUARE); // X000
        storage[0] = new StoredPiece(color, Constants.LOW, Constants.SOLID, Constants.ROUND); // X001
        storage[1] = new StoredPiece(color, Constants.LOW, Constants.HOLLOW, Constants.SQUARE); // X010
        storage[2] = new StoredPiece(color, Constants.LOW, Constants.HOLLOW, Constants.ROUND); // X011
        storage[3] = new StoredPiece(color, Constants.HIGH, Constants.SOLID, Constants.SQUARE); // X100
        storage[4] = new StoredPiece(color, Constants.HIGH, Constants.SOLID, Constants.ROUND); // X101
        storage[5] = new StoredPiece(color, Constants.HIGH, Constants.HOLLOW, Constants.SQUARE); // X110
        storage[6] = new StoredPiece(color, Constants.HIGH, Constants.HOLLOW, Constants.ROUND); // X111

    }

    public void removePiece(int index){
        storage[index].removePiece();
    }
}
