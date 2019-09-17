import java.awt.*; 
/**
  * This class represents the logic of the game.
  *
  * @author Jamea Speight
  */
public class MatchGame {
    /**The lowest numeric value for the number of rows of cards in the game.”*/
    public static final int ROWS = 4;
    /**The lowest numeric value for the number of columns of cards in the game.”*/
    public static final int COLS = 13;
    /** Creating private deck object for the deck that will be used to play the game */
    private Deck d;
    /** Creating private grid object for the grid that will be arranged for the game */
    private Grid g;
    /** Creating private int for the correct guesses */
    private int correctGuesses;
    /** Creating private int for the total guesses */
    private int totalGuesses;
    /** Creating private boolean for if the game is easy or not*/
    private boolean easyGame;
    /** 
      * Custom constructor stores the value of if the game is easy
      *
      * @param isTesting - 
      * @param isEasy - 
      */
    public MatchGame(boolean isTesting, boolean isEasy){
        easyGame = isEasy;
        d = new Deck();
        this.g = g;
        this.d = d;
        if (!isTesting) {
            d.shuffle();
        }
        g = new Grid(ROWS,COLS);
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                g.setCard(i,j, d.nextCard());
            }
        }
    }
    /**
      * Gets the number of guesses
      *
      * @return the number of guesses
      */
    public int getNumberOfGuesses(){
        return totalGuesses;
    }
    /**
      * Gets the number of correct guesses
      *
      * @return the number of correct guesses
      */
    public int getNumberOfCorrectGuesses(){
        return correctGuesses;
    }
    /**
      * Gets the number of correct guesses
      *
      * @return the number of correct guesses
      */
    public double getGuessAverage(){
        if ( totalGuesses == 0 ) {
            return totalGuesses;
        } else {
            return ((double)correctGuesses / totalGuesses) ;
        }
    }
    /**
      * Gets the card name 
      * 
      * @param row - number of row of the card
      * @param col - number of column of the card
      * @return the card name
      */
    public String getCardName(int row, int col){
        if ( row < 0 || row >= ROWS) {
            throw new IllegalArgumentException ("Invalid row");
        } 
        if ( col >= COLS || col < 0) {
            throw new IllegalArgumentException ("Invalid col");
        } 
        Card card = g.getCard(row, col); 
        String cardName = card.toString();
        return cardName;
    }
    /**
      * Gets the truth value if the card has been found 
      *
      * @param row - number of row of the card
      * @param col - number of column of the card
      * @return the truth value
      */
    public boolean hasBeenFound(int row, int col){
        if ( row < 0 || row >= ROWS) {
            throw new IllegalArgumentException ("Invalid row");
        } 
        if ( col >= COLS || col < 0) {
            throw new IllegalArgumentException ("Invalid col");
        } 
        Card card = g.getCard(row, col); 
        return card.hasBeenFound();
    }
    /**
      * Gets the truth value if the card is a match
      *
      * @param card1Row - the row card one is in
      * @param card1Col - the column card one is in
      * @param card2Row - the row card two is in
      * @param card2Col - the column card two is in
      * @return the truth value if it is a match
      */
    public boolean isMatch(int card1Row, int card1Col, int card2Row, int card2Col){
        if ( card1Row < 0 || card1Row >= ROWS) {
            throw new IllegalArgumentException ("Invalid card1Row");
        } 
        if ( card1Col >= COLS || card1Col < 0) {
            throw new IllegalArgumentException ("Invalid card1Col");
        } 
        if ( card2Row < 0 || card2Row >= ROWS) {
            throw new IllegalArgumentException ("Invalid card2Row");
        } 
        if ( card2Col >= COLS || card2Col < 0) {
            throw new IllegalArgumentException ("Invalid card2Col");
        } 
        Card card1 = g.getCard(card1Row, card1Col); 
        Card card2 = g.getCard(card2Row, card2Col); 
        totalGuesses++;
        if (easyGame == true) {
            if (!card1.hasBeenFound() && !card2.hasBeenFound() && card1.hasSameValue(card2)){
                correctGuesses++;
                card1.setHasBeenFound(true);
                card2.setHasBeenFound(true);
                return true;
            } else {
                return false;
            }      
        } else {
            if (!card1.hasBeenFound() && !card2.hasBeenFound() && 
                                        card1.hasSameValueAndColor(card2)){
                correctGuesses++;
                card1.setHasBeenFound(true);
                card2.setHasBeenFound(true);
                return true;
            } else { 
                return false;
            }
        }
    }
    /**
      * Gets the deck object for testing
      *
      * @return the deck object for testing 
      */
    public Deck getDeck(){
        return d;
    }
    /**
      * Gets the grid object for testing
      *
      * @return the grid object for testing 
      */
    public Grid getGrid(){
        return g;
    }
}

