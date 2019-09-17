import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
/**
  * ConnectFourGUI game GUI class
  *
  * @author Jay Vandeveld
  * @author Jamea Speight 
  * @author Johnathan Rhyne
  * @author Tess Colavecchio
  */
public class ConnectFourGUI extends JFrame implements ActionListener {
    
    /** Width of window */
    public static final int WIDTH = 884;
    /** Height of window */
    public static final int HEIGHT = 530;
    /** Max count possible in the game */
    public static final int MAX_COUNT = 65;
    /** Column 3 */
    public static final int COLUMN_THREE = 3;
    /** Column 4 */
    public static final int COLUMN_FOUR = 4;
    /** Column 5 */
    public static final int COLUMN_FIVE = 5;
    /** Column 6 */
    public static final int COLUMN_SIX = 6;
    /** Column 7 */
    public static final int COLUMN_SEVEN = 7;
    /** Number to look for to win game*/
    public static final int FOUR_IN_ROW = 4;
    
    /** Column 1 button */
    private JButton column1;
    /** Column 2 button */
    private JButton column2;
    /** Column 3 button */
    private JButton column3;
    /** Column 4 button */
    private JButton column4;
    /** Column 5 button */
    private JButton column5;
    /** Column 6 button */
    private JButton column6;
    /** Column 7 button */
    private JButton column7;
    /** Column 8 button */
    private JButton column8;
    /** Quit button */
    private JButton quitButton;
    /** Player 1 information panel */
    private JLabel playerOneInfo;
    /** Player 2 information panel */
    private JLabel playerTwoInfo;
    /** Array for game display */
    private JLabel[][] gameDisplay;
    /** Panel for game display */
    private JPanel panelGame;
    /** Panel for instructions */
    private JPanel information;
    /** Panel Columns  */
    private JPanel panelColumns;
    /** Box for panel */
    private Box panel;
    /** Player 1 win count */
    private int playerOneWins;
    /** Player 2 win count */
    private int playerTwoWins;
    /** count for number of turns */
    private int count;
    /** Number of player 1 pieces connected*/
    private int player1Connected;
    /** Number of player 2 pieces connected*/
    private int player2Connected;
    /** Player 1 name */
    private String playerOneName;
    /** Player 2 name */
    private String playerTwoName;
    /** ConnectFour object of grid */
    private ConnectFour grid;
    
    /**
      * GUI custom constructor
      * @param name1 name of player 1
      * @param name2 name of player 2
      * @param wins1 number of wins for player 1   
      * @param wins2 number of wins for player 2      
      */    
    public ConnectFourGUI(String name1, String name2, int wins1, int wins2) {
        super("Connect 4");
        //Stores values to be used later
        playerOneName = name1;
        playerTwoName = name2;
        playerOneWins = wins1;
        playerTwoWins = wins2;
        //Creates display objects
        grid = new ConnectFour();
        playerOneInfo = new JLabel(playerOneName + " has " + playerOneWins + " Win(s), and has "
                + "0 piece(s) in a row." + " It is " + playerOneName + "'s turn");
        playerTwoInfo = new JLabel(playerTwoName + " has " + playerTwoWins + " Win(s), and has "
                + "0 piece(s) in a row.");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panelColumns = new JPanel(new FlowLayout());
        panel = Box.createVerticalBox();
        information = new JPanel(new FlowLayout());
        //Adds objects to the frame
        add(panel);
        panel.add(information);
        panel.add(panelColumns);
        //Creates JButtons
        column1 = new JButton("Column 1");
        column2 = new JButton("Column 2");
        column3 = new JButton("Column 3");
        column4 = new JButton("Column 4");
        column5 = new JButton("Column 5");
        column6 = new JButton("Column 6");
        column7 = new JButton("Column 7");
        column8 = new JButton("Column 8");
        quitButton = new JButton("Quit");
        //Allows them to be responsive
        column1.addActionListener(this);
        column2.addActionListener(this);
        column3.addActionListener(this);
        column4.addActionListener(this);
        column5.addActionListener(this);
        column6.addActionListener(this);
        column7.addActionListener(this);
        column8.addActionListener(this);
        quitButton.addActionListener(this);
        //Adds to the GUI screen
        information.add(playerOneInfo);
        information.add(quitButton);
        information.add(playerTwoInfo);
        panelColumns.add(column1);
        panelColumns.add(column2);
        panelColumns.add(column3);
        panelColumns.add(column4);
        panelColumns.add(column5);
        panelColumns.add(column6);
        panelColumns.add(column7);
        panelColumns.add(column8);
        
        //Adds the pieces to the display
        panelGame = new JPanel(new GridLayout(Grid.NUM_OF_ROWS, Grid.NUM_OF_COLS));
        gameDisplay = new JLabel[Grid.NUM_OF_ROWS][Grid.NUM_OF_COLS];
        for (int i = 0; i < gameDisplay.length; i++) {
            for (int j = 0; j < gameDisplay[i].length; j++) {
                JLabel display = new JLabel(grid.getPiece(i,j));
                gameDisplay[i][j] = display;
                panelGame.add(display);
            }
        }
        panel.add(panelGame);
        setVisible(true);
    }   
    
    /**
      * Individual action processor
      * @param e object of action that occured   
      */     
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == quitButton) {
            System.exit(1);
        } else {
            if (count == 0) {
                count = 1;
            }
            //Odds are player 1 because starts at 1
            if (count % 2 == 1) {
                grid.playerOnePlaying = true;
            } else {
                grid.playerOnePlaying = false;
            }
            count++;
        }
        //determines where to place the pieces
        int row = 0;
        int column = 0;
        if (e.getSource() == column1) {
            column = 0;
            row = grid.setPiece(column, grid.playerOnePlaying);
            gameDisplay[row][column].setText(grid.getPiece(row,column));
        } else if (e.getSource() == column2) {
            column = 1;
            row = grid.setPiece(column, grid.playerOnePlaying);
            gameDisplay[row][column].setText(grid.getPiece(row,column));
        } else if (e.getSource() == column3) {
            column = 2;
            row = grid.setPiece(column, grid.playerOnePlaying);
            gameDisplay[row][column].setText(grid.getPiece(row,column));
        } else if (e.getSource() == column4) {
            column = COLUMN_THREE;
            row = grid.setPiece(column, grid.playerOnePlaying);
            gameDisplay[row][column].setText(grid.getPiece(row,column));
        } else if (e.getSource() == column5) {
            column = COLUMN_FOUR;
            row = grid.setPiece(column, grid.playerOnePlaying);
            gameDisplay[row][column].setText(grid.getPiece(row,column));
        } else if (e.getSource() == column6) {
            column = COLUMN_FIVE;
            row = grid.setPiece(column, grid.playerOnePlaying);
            gameDisplay[row][column].setText(grid.getPiece(row,column));
        } else if (e.getSource() == column7) {
            column = COLUMN_SIX;
            row = grid.setPiece(column, grid.playerOnePlaying);
            gameDisplay[row][column].setText(grid.getPiece(row,column));
        } else if (e.getSource() == column8) {
            column = COLUMN_SEVEN;
            row = grid.setPiece(column, grid.playerOnePlaying);
            gameDisplay[row][column].setText(grid.getPiece(row,column));
        }
        //determines who's stats to update
        if (grid.playerOnePlaying) {
            player1Connected = grid.checkNumConnected();
        } else {
            player2Connected = grid.checkNumConnected();
        }
        //adds the new information
        String playerOneText = playerOneName + " has " + playerOneWins + " Win(s), and has " + 
                player1Connected + " piece(s) in a row.";
        String playerTwoText = playerTwoName + " has " + playerTwoWins + " Win(s), and has " + 
                player2Connected + " piece(s) in a row.";
        //adds indicator of who is playing
        if (!grid.playerOnePlaying) {
            playerOneText += " It is " + playerOneName + "'s turn";
        } else {
            playerTwoText += " It is " + playerTwoName + "'s turn";
        }
        //updates GUI
        playerOneInfo.setText(playerOneText);
        playerTwoInfo.setText(playerTwoText);
        //checks for win condition (>= is used in the event 4 in a row is skipped)
        if (player1Connected >= FOUR_IN_ROW) {
            setVisible(false);
            Scanner console = new Scanner(System.in);
            System.out.println("Player 1 wins.");
            playerOneWins++;
            System.out.print("play again? (y/n): ");
            String input = console.nextLine();
            String inputReduced = input.substring(0,1).toLowerCase();
            //prompts for new game with updated wins
            if (inputReduced.equals("y")) {
                new ConnectFourGUI(playerOneName, playerTwoName, playerOneWins, playerTwoWins);
            } else {
                System.exit(1);
            }
        } else if (player2Connected >= FOUR_IN_ROW) { //checks the same but for player 2
            setVisible(false);
            Scanner console = new Scanner(System.in);
            System.out.println("Player 2 wins.");
            playerTwoWins++;
            System.out.print("play again? (y/n): ");
            String input = console.nextLine();
            String inputReduced = input.substring(0,1).toLowerCase();
            //prompts for new game with updated wins
            if (inputReduced.equals("y")) {
                new ConnectFourGUI(playerOneName, playerTwoName, playerOneWins, playerTwoWins);
            } else {
                System.exit(1);
            }
        }
        //checks to see if any columns are full and disables them
        for (int i = 0; i < gameDisplay[0].length; i++) {
            if (!grid.getPiece(0,i).equals(grid.board.none.getPiece())) {
                if (i == 0) {
                    column1.setEnabled(false);
                } else if (i == 1) {
                    column2.setEnabled(false);
                } else if (i == 2) {
                    column3.setEnabled(false);
                } else if (i == COLUMN_THREE) {
                    column4.setEnabled(false);
                } else if (i == COLUMN_FOUR) {
                    column5.setEnabled(false);
                } else if (i == COLUMN_FIVE) {
                    column6.setEnabled(false);
                } else if (i == COLUMN_SIX) {
                    column7.setEnabled(false);
                } else if (i == COLUMN_SEVEN) {
                    column8.setEnabled(false);
                }
            }
        }
        //checks for a full board and displays it as a draw
        if (count == MAX_COUNT) {
            setVisible(false);
            Scanner console = new Scanner(System.in);
            System.out.println("Draw");
            System.out.print("play again? (y/n): ");
            String input = console.nextLine();
            String inputReduced = input.substring(0,1).toLowerCase();
            if (inputReduced.equals("y")) {
                new ConnectFourGUI(playerOneName, playerTwoName, playerOneWins, playerTwoWins);
            } else {
                System.exit(1);
            }
        }
    }
    
    
    /**
     * Starts program
     * 
     * @param args command arguments
     */    
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Player 1 name: ");
        String player1Name = console.nextLine();
        System.out.print("Player 2 name: ");
        String player2Name = console.nextLine();
        new ConnectFourGUI(player1Name, player2Name, 0, 0);
    }
    
}