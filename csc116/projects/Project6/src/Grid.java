import java.awt.*; 
/**
  * This class represents the grid of the game.
  * @author Jamea Speight
  */
public class Grid {
    /** Creating private int for the number of rows in the grid*/
    private int rows;
    /** Creating private int for the number of columns in the grid*/
    private int cols;
    /** Creating private array for the card objects */
    private Card[][] cards;
    /** 
      * Custom constructor for the rows and columns of the grid.
      *
      * @param rows - number of rows
      * @param cols - number of columns 
      */
    public Grid(int rows, int cols) {
        if ( rows < 1 || cols < 1) {
            throw new IllegalArgumentException ("Invalid rows/cols");
        } 
        this.rows = rows;
        this.cols = cols;
        cards = new Card[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cards[i][j] = null;
            }
        }
    
    }
    /** 
      * Stores the card in the 2D array
      *
      * @param row - number of rows
      * @param col - number of columns 
      * @param card - the card to store in the 2D array
      */
    public void setCard(int row, int col, Card card) {
        if ( row < 0 || row >= rows) {
            throw new IllegalArgumentException ("Invalid row");
        } 
        if ( col >= cols || col < 0) {
            throw new IllegalArgumentException ("Invalid col");
        } 
        if (card == null) {
            throw new NullPointerException("Null card");
        }
        cards[row][col] = card;
    }
    /** 
      * Returns the card in the 2D array at the given row and column
      *
      * @param row - number of rows
      * @param col - number of columns 
      * @return the card
      */
    public Card getCard(int row, int col) {
        if ( row < 0 || row >= rows) {
            throw new IllegalArgumentException ("Invalid row");
        } 
        if ( col < 0 || col >= cols ) {
            throw new IllegalArgumentException ("Invalid col");
        } 
        return cards[row][col];
    }
    /**
      * Creates and returns a string representation of the grid
      *
      * @return a string representation of the grid 
      */
    public String toString() {
        String s = "";
        for( int i = 0; i < rows; i++) {
            for (int j = 0; j < cols ; j++){
                if (j < cols - 1 ){
                    s += cards[i][j].toString() + " ";
                } else {
                    s += cards[i][j].toString();
                }
            }
            s += "\n";
        }
        return s;
    }
}