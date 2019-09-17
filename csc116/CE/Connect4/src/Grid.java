import java.awt.*; 
/**
  * This class represents the grid used in the ConnectFour game.
  *
  * @author Jay Vandeveld
  * @author Jamea Speight 
  * @author Johnathan Rhyne
  * @author Tess Colavecchio
  */
public class Grid {
    /**The number of rows.*/
    public static final int NUM_OF_ROWS = 8;
    /**The number of columns*/
    public static final int NUM_OF_COLS = 8;
    /** Creating array for the grid and player pieces */
    public Player[][] grid;
    /** Creating Player instance for player 1 */
    public Player player1;
    /** Creating Player instance for player 2 */
    public Player player2;
    /** Creating Player instance that signifies an empty spot */
    public Player none;
    /** creates a variable for number of rows */
    public int rows;
    /** creates a variable for number of columns */
    public int columns;
    
    /** 
      * Default constructor of the grid
      *
      */
    public Grid() {
        this(NUM_OF_ROWS, NUM_OF_COLS);
    }
    
    /**
      * Custom constructor
      * @param rows the number of rows to be made
      * @param columns the number of colums to be made
      */
    public Grid(int rows, int columns) {
        none = new Player("none", "          -");
        grid = new Player[rows][columns];
        this.rows = rows;
        this.columns = columns;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                grid[i][j] = none;
            }
        }
        player1 = new Player("test", ConnectFour.PLAYER_ONE);
        player2 = new Player("test", ConnectFour.PLAYER_TWO);
        
    }

    /**
      * Sets an element on the grid
      * @param row the row number of the element
      * @param col the column number of the element
      * @param pieceName the name of the piece the player is using
      */     
    public void setGridElement(int row, int col, String pieceName) {
        if (row >= rows || col >= columns) {
            throw new IllegalArgumentException("Invalid row or column input");
        } else if (row < 0 || col < 0) {
            throw new IllegalArgumentException("Invalid row or column input");
        }
        
        grid[row][col] = new Player("test", pieceName);
        
    }
    
    /**
      * Gets an element from a grid spot
      * @param row the row number of the element
      * @param col the column number of the element
      *
      * @return string of element gotten
      */     
    public String getGridElement(int row, int col) {
    
    
        try {
            String temp = grid[row][col].getPiece();
            return temp;
        } catch (ArrayIndexOutOfBoundsException a) {
            return "a";
        }
    }
}