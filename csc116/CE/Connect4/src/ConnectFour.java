import java.awt.*;
 
/**
  * ConnectFour Game Class
  *
  * @author Jay Vandeveld
  * @author Jamea Speight 
  * @author Johnathan Rhyne
  * @author Tess Colavecchio
  */
  
public class ConnectFour {

    /** Symbol for Player One */
    public static final String PLAYER_ONE = "          X";
    
    /** Symbol for Player Two */
    public static final String PLAYER_TWO = "          O";
    
    /** constant for number in a row */
    public static final int WIN_NUM = 4;
    
    /** Says whether or not it is Player One's turn */
    public boolean playerOnePlaying;
    
    /** References Grid Class 2D array*/
    public Grid board;
    
    /**
    *default constructor class for ConnectFour
    *
    */
    public ConnectFour() {
        this(Grid.NUM_OF_ROWS, Grid.NUM_OF_COLS);
    }
    
    /**
    * Creates the ConnectFour object
    *@param rows the number of rows to be used with the grid
    *@param columns the number of columns within the grid
    */
    public ConnectFour(int rows, int columns) {
        board = new Grid(rows, columns);
    }
    
    /**
     * Count how many like pieces are connected on the grid
     * @return how many pieces are in a row
     */
    public int checkNumConnected() {
        int numConnected = 0;
        int numConnectedPerRow = 0;
        String temp = "";
        String lastPiece = "";
        if (playerOnePlaying) {
            temp = PLAYER_ONE;
        } else {
            temp = PLAYER_TWO;
        }
        //checks horizontally
        //Goes through each horizontal row starting at the bottom
        for (int i = board.rows; i >= 0; i--) {
            //checks each vertical column
            for (int j = 0; j < board.columns; j++) {
                //compares the temp val to each subsequent horizontal piece
                for (int k = 0; k < (board.columns - j); k++) {
                    //breaks out of this loop if the next piece is not the same as temp
                    try {
                        if (!temp.equals(board.getGridElement(i,k)) ) {
                            numConnectedPerRow = 0;
                        } else {
                            numConnectedPerRow++;
                            numConnected = Math.max(numConnected, numConnectedPerRow);
                        }
                    } catch (IllegalArgumentException f) {
                        k = k; //used to prevent checkstyle. No real function necessary here
                    }
                }
                numConnectedPerRow = 0;
            }
        }
        //checks vertically (make sure to test properly)
        for (int i = board.rows; i >= 0; i--) {
            //checks each vertical column
            for (int j = 0; j < board.columns; j++) {
                //compares the temp val to each subsequent vertical piece
                for (int k = 0; k < (board.rows - i); k++) {
                    //breaks out of this loop if the next piece is not the same as temp
                    if (!temp.equals(board.getGridElement(k,j))) {
                        numConnectedPerRow = 0;
                    } else {
                        numConnectedPerRow++;
                        numConnected = Math.max(numConnected, numConnectedPerRow);
                    }
                }
                numConnectedPerRow = 0;
            }
        }
        //checks diagonally SW-NE
        for (int i = board.rows; i >= 0; i--) {
            for (int j = 0; j < board.columns; j++) {
                for (int k = 0; k < WIN_NUM; k++) {
                    if (i - k < 0 || j + k >= board.columns) {
                        break;
                    }
                    try {
                        if (!temp.equals(board.getGridElement(i - k,j + k))) {
                            break;
                        } else {
                            numConnectedPerRow++;
                        }
                    } catch (IllegalArgumentException e) {
                        k = k; //used to prevent checkstyle. No real function necessary here
                    }
                }
                numConnected = Math.max(numConnected, numConnectedPerRow);
                numConnectedPerRow = 0;
            }
        }
        //checks diagonally NW-SE
        for (int i = board.rows - 1; i >= 0; i--) {
            for (int j = 0; j < board.columns; j++) {
                for (int k = 0; k < WIN_NUM; k++) {
                    if (i - k >= board.rows || j - k < 0) {
                        break;
                    }
                    if (!temp.equals(board.getGridElement(i - k,j - k))) {
                        break;
                    } else {
                        numConnectedPerRow++;
                    }
                }
                numConnected = Math.max(numConnected, numConnectedPerRow);
                numConnectedPerRow = 0;
            }
            numConnectedPerRow = 0;
        }
        
        return numConnected;
    }
    
    /**
     * Set a piece in a place on the grid based on the column number
     *      and which player's turn it is
     *
     * @param column int on the grid
     * @param playerOnePlaying boolean whether player one is playing or not
     *
     * @return row that piece is placed on
     */
    public int setPiece(int column, boolean playerOnePlaying) {
        String pieceToPlace = "";
        if (playerOnePlaying) {
            pieceToPlace = PLAYER_ONE;
        } else {
            pieceToPlace = PLAYER_TWO;
        }
        int row = 0;
        try {
            while (board.getGridElement(row, column).equals(board.none.getPiece())) {
                row++;
            }
        } catch (IllegalArgumentException e) {
            row = row;
        }
        try {
            board.setGridElement(row - 1, column, pieceToPlace);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return row - 1;
    }
    
    /**
     * Get a piece from a spot on the grid
     *
     * @param row row of object on the grid
     * @param col column of object on the grid
     *
     * @return Piece on spot on grid
     */    
    public String getPiece(int row, int col) {
        return board.getGridElement(row, col);
    }
        
}