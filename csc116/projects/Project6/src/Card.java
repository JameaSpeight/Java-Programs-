import java.awt.*; 
/**
  * This class describes represents a single playing card used in the Match Game.
  *
  * @author Jamea Speight
  */
public class Card {
    /**A char value that represents the suit “Clubs.”*/
    public static final char CLUBS = 'c';
    /**A char value that represents the suit “Diamond.”*/
    public static final char DIAMONDS = 'd';
    /**A char value that represents the suit “Hearts.”*/
    public static final char HEARTS = 'h';
    /**A char value that represents the suit “Spades.”*/
    public static final char SPADES = 's';
    /**The lowest numeric value for a card.”*/
    public static final int LOWEST_VALUE = 2;
    /**The highest numeric value for a card.”*/
    public static final int HIGHEST_VALUE  = 14;
    /** Creating private char for the suit */
    private char suit;
    /** Creating private int for the value */
    private int value;
    /** Creating private color for the card color*/
    private Color color;
    /** Creating private boolean for the correct card*/
    private boolean match;
    /** 
      * Custom constructor (It accepts a suit and a value to assign to the instance fields.)
      *
      * @param suit - card suit
      * @param value - numerica value of the card
      */
    public Card(char suit, int value) {
        if (suit != CLUBS && suit != DIAMONDS && suit != HEARTS && suit != SPADES) {
            throw new IllegalArgumentException ("Invalid suit");
        }
        if ( value < LOWEST_VALUE || value >  HIGHEST_VALUE) {
            throw new IllegalArgumentException ("Invalid value");
        }
        if (suit == DIAMONDS || suit == HEARTS) { 
            color = Color.RED;
        } else if ( suit == CLUBS || suit == SPADES ) { 
            color = Color.BLACK;
        }
        setSuit(suit);
        setValue(value);
        setColor(color);
    }
    /**
      * Sets the suit
      *
      * @param s - suit
      */
    private void setSuit(char s) {
        suit = s;
    }
    /**
      * Gets the suit
      *
      * @return the suit
      */
    public char getSuit() {
        return suit;
    }
    /**
      * Sets the value
      *
      * @param v - value
      */
    private void setValue(int v) {
        value = v;
    }
    /**
      * Gets the value
      *
      * @return the value
      */
    public int getValue() {
        return value;
    }
    /**
      * Sets the color
      *
      * @param c - color
      */
    private void setColor(Color c) {
        color = c;
    }
    /**
      * Gets the color
      *
      * @return the color
      */
    public Color getColor() {
        return color;
    }
    /**
      * Gets the truth value if the card has been found 
      *
      * @return the truth value
      */
    public boolean hasBeenFound() {
        return match;
    }
    /**
      * Sets the value of the instance field 
      *
      * @param hasBeenFound - boolean
      */
    public void setHasBeenFound(boolean hasBeenFound) {
        match = hasBeenFound;
    }
    /**
      * Gets the truth value if the other card has the same value 
      *
      * @param other - second card picked
      * @return the truth value
      */
    public boolean hasSameValue(Card other) {
        if ( this.getValue() == other.getValue()) {
            return true; 
        }
        return false;
    }
     /**
      * Gets the truth value if the other card has same value and color
      *
      * @param other - second card picked
      * @return the truth value
      */
    public boolean hasSameValueAndColor(Card other) {
        if ( this.getValue() == other.getValue() && this.getColor() == other.getColor()) {
            return true; 
        } 
        return false;
    }
    /** 
      * Tests if the cards are the sam 
      *
      * @param o - object
      * @return boolean (true if the suit, color, and value are the same)
      */
    public boolean equals(Object o) { 
        if (o instanceof Card) {
            Card c = (Card) o;
            return this.getSuit() == c.getSuit() && this.getColor() == c.getColor()
                                && this.getValue() == c.getValue();
        } else {
            return false;
        }
    }
    /**
      * Creates and returns a string describing the cards matched 
      *
      * @return a string describing the cards matched 
      */
    public String toString() {
        String cardName = "";
        char cardSuit = this.getSuit();
        int cardValue =  this.getValue();
        cardName += cardSuit + "" + cardValue;
        return cardName;
    } 
}