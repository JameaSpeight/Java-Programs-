import java.awt.*;
import java.util.*; 
/**
  * This class describes represents the deck used in the Match Game.
  *
  * @author Jamea Speight
  */
public class Deck {
    /**The lowest numeric value for a card.”*/
    public static final int CARDS_IN_DECK = 52;
    /**The number of suits.”*/
    public static final int NUM_OF_SUITS = 4;
    /** Creating private array for the deck of cards */
    private Card[] cards;
    /** Creating private int for the next card */
    private int nextCard;
    /** 
      * Custom constructor for the Deck
      *
      */
    public Deck() {
        cards = new Card[CARDS_IN_DECK];
        int k = 0;
       
        
        for (int i = 0 ; i <= 3; i++) {
            for (int j = Card.LOWEST_VALUE;  j <= Card.HIGHEST_VALUE; j++) {
                if ( i == 0) {
                    cards[k] = new Card(Card.CLUBS , j );
                } else if ( i == 1) {
                    cards[k] = new Card(Card.DIAMONDS , j );
                } else if ( i == 2) {
                    cards[k] = new Card(Card.HEARTS , j );
                } else if ( i == 3) {
                    cards[k] = new Card(Card.SPADES , j );
                }
                k++;
            }
        }
    }
    /** 
      * Shuffles the cards in the deck
      *
      */
    public void shuffle() {
        Random rand = new Random();
        int r;
        Card tempCard;
        for (int i = CARDS_IN_DECK - 1; i > 0; i--) {
            r = rand.nextInt(CARDS_IN_DECK);
            tempCard = cards[i];
            cards[i] = cards[r];
            cards[r] = tempCard;
        }
    }
     /** 
      * Shuffles the cards in the deck
      *
      * @return the Card next in the deck
      */
    public Card nextCard() { 
        if ( nextCard  < cards.length) {
            return cards[nextCard++];
        } else {
            return null;
        }
    }
    /** 
      * Tests if the cards are the same
      *
      * @param o - object
      * @return boolean (true if the suit, color, and value are the same)
      */
    public boolean equals(Object o) {
        if (o instanceof Deck) {
            Deck d = (Deck) o;
            return Arrays.equals(d.cards, cards) && nextCard == d.nextCard;
        } else {
            return false;
        }
        
    }
    /**
      * Creates and returns a string describing the deck
      *
      * @return a string describing the deck
      */
    public String toString() {
        String s = "";
        int k = 0;
        

        for (int i = 0; i <= 3 ; i++) {
            for (int j = 1; j <= CARDS_IN_DECK / NUM_OF_SUITS; j++) {
                s += "card " + k + ": " + cards[k++] + "\n";
            }
        }
        return s;
    }
    
}