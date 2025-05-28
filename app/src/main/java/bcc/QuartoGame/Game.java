package bcc.QuartoGame;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Game {
    Player player0;
    Player player1;
    Board board;

    private int x;
    private int y;

    private int playerTurn;

    // Initializes a game instance with two players and a shared board (also a gui)
    public Game(int xSize, int ySize){
        player0 = new Player(Constants.WHITE, 2);
        player1 = new Player(Constants.BLACK, 0);
        board = new Board();

        x = xSize;
        y = ySize;

        JFrame frame = new JFrame("Quarto!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel text1 = new JLabel("Quarto");
        JLabel text2 = new JLabel("Key ID: ");
        text1.setFont(new Font("Serif", Font.BOLD, Constants.fontTitle));
        text1.setHorizontalAlignment(JLabel.CENTER);
        text1.setVerticalAlignment(JLabel.TOP);
        text2.setFont(new Font("Serif", Font.BOLD, Constants.fontTitle));
        text2.setVerticalAlignment(JLabel.CENTER);
        text2.setVerticalAlignment(JLabel.CENTER);
        
        frame.addKeyListener(new KeyListener(){
            int k = 0;
            public void keyPressed(KeyEvent ke){
                k = ke.getKeyCode();
                text2.setText("Key ID: " + k);
                if ((k > Constants.KEY1 - 1) && k < (Constants.KEY8 - 1)){
                    
                    text1.setText("Piece Selected: " + (k - (Constants.KEY1)));
                }
                else if (k == Constants.ENTER){
                    player0.finalizeChoice();
                }
                else if (k == Constants.ARROW_LEFT){
                    selectionLeft();
                }
                else if (k == Constants.ARROW_UP){
                    selectionUp();
                }
                else if (k == Constants.ARROW_RIGHT){
                    selectionRight();
                }
                else if (k == Constants.ARROW_DOWN){
                    selectionDown();
                }
            }
            public void keyReleased(KeyEvent ke){

            }
            public void keyTyped(KeyEvent ke){
            }
        });

        frame.add(text1);
        frame.add(text2);

        frame.setSize(x, y);
        frame.setVisible(true);

        playerTurn = 0;
    }
    // alternates turns between players
    public boolean turn(){
        if (player0.getTurnPhase() == 3 || player1.getTurnPhase() == 3){
            if (playerTurn == 0){
                playerTurn = 1;
                return true;
            }
            else {
                playerTurn = 0;
                return true;
            }
        }
        return false;
    }

    // Moves the current player's selected spot to the left
    public void selectionLeft(){
        if (playerTurn == 0){
            player0.decreaseRow();
        }
        else {
            player1.decreaseRow();
        }
    }

    // Moves the current player's selected spot to the right
    public void selectionRight(){
        if (playerTurn == 0){
            player0.increaseRow();
        }
        else {
            player1.increaseRow();
        }
    }

    // Moves the current player's selected spot down
    public void selectionDown(){
        if (playerTurn == 0){
            player0.decreaseCol();
        }
        else {
            player1.decreaseCol();
        }
    }

    // Moves the current player's selected spot up
    public void selectionUp(){
        if (playerTurn == 0){
            player0.increaseCol();
        }
        else {
            player1.increaseCol();
        }
    }
}
