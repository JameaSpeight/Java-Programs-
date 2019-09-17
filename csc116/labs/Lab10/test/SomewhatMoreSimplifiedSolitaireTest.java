import static org.junit.Assert.assertEquals;

import org.junit.*;
import junit.framework.TestCase;

/**
 * This program tests SomewhatMoreSimplifiedSolitaire
 * 
 * Somewhat Simplified Solitaire Encryption and Decryption algorithm.
 * 
 * See: https://www.schneier.com/academic/solitaire/
 * 
 * @author Dr. Jason King
 * @author Dr. Jessica Young Schmidt
 *
 */
public class SomewhatMoreSimplifiedSolitaireTest extends TestCase {

    @Test
    public void testEncrypt() {
		// Encrypting HELLO
        String deck = "1 4 7 10 13 3 6 9 12 15 14 2 5 8 11";
        String description = "Encrypt the message \"HELLO\"";
        String expected = "TPVPR";
        String actual = SomewhatMoreSimplifiedSolitaire.encrypt(deck, "HELLO");
        assertEquals(description, expected, actual);
		
		// Encrypting DOG
		deck = "3 6 7 10 4 2 1 11 8 12 14 9 5 13 15";
		description = "Encrypt the message \"DOG\"";
		expected = "LCS";
		actual = SomewhatMoreSimplifiedSolitaire.encrypt(deck, "DOG");
		assertEquals(description, expected, actual);
    }

    @Test
    public void testDecrypt() {
		// Decrypting TPVPR
        String deck = "1 4 7 10 13 3 6 9 12 15 14 2 5 8 11";
        String description = "Decrypt the message \"TPVPR\"";
        String expected = "HELLO";
        String actual = SomewhatMoreSimplifiedSolitaire.decrypt(deck, "TPVPR");
        assertEquals(description, expected, actual);
		
		// Decrypting DOG
		deck = "3 6 7 10 4 2 1 11 8 12 14 9 5 13 15";
		description = "Decrypt the message \"LCS\"";
		expected = "DOG";
		actual = SomewhatMoreSimplifiedSolitaire.decrypt(deck, "LCS");
		assertEquals(description, expected, actual);
    }

    @Test
    public void testMoveFirstJokerDownByOne() {
		// When Joker A is not the last card in the deck
        String deck = "1 4 7 10 13 3 6 9 12 15 14 2 5 8 11";
        String description = "Moving Joker A down by one when Joker A "
                + "is not the last card in the deck";
        String expected = "1 4 7 10 13 3 6 9 12 15 2 14 5 8 11";
        String actual = SomewhatMoreSimplifiedSolitaire.moveFirstJokerDownOne(deck);
        assertEquals(description, expected, actual);
		
		// When Joker A is the last card in the deck
		deck = "1 4 7 10 13 3 6 9 12 15 2 5 8 11 14";
		description = "Moving Joker A down by one when Joker A "
		        + "is not the last card in the deck";
		expected = "14 4 7 10 13 3 6 9 12 15 2 5 8 11 1";
		actual = SomewhatMoreSimplifiedSolitaire.moveFirstJokerDownOne(deck);
		
		deck = "7 5 10 3 6 11 13 15 2 4 8 1 9 12 14";
		description = "Moving Joker A down by one when Joker A "
		                               + "at the end of the deck";
		expected = "14 5 10 3 6 11 13 15 2 4 8 1 9 12 7";
		actual = SomewhatMoreSimplifiedSolitaire.moveFirstJokerDownOne(deck);
		assertEquals(description, expected, actual);
    }
    

    @Test
    public void testMoveSecondJokerDownByTwo() {
        // When Joker B is somewhere in the middle of the deck
        String deck = "1 4 7 10 13 3 6 9 12 15 2 14 5 8 11";
        String description = "Moving Joker B down by two when Joker B " 
                + "is not the last card in the deck";
        String expected = "1 4 7 10 13 3 6 9 12 2 14 15 5 8 11";
        String actual = SomewhatMoreSimplifiedSolitaire.moveSecondJokerDownTwo(deck);
        assertEquals(description, expected, actual);

        // When the second half of the deck has only one card
		deck = "4 7 10 13 3 6 8 12 14 5 8 15 11 1";
		String secondHalfOfDeckWithoutFirstCard = "1";
		description = "Adjusting the second half of the deck if it has only one card";
		expected = "4 7 10 13 3 6 8 12 14 5 8 11 1 15 ";
		actual = SomewhatMoreSimplifiedSolitaire.moveSecondJokerDownTwo(deck); 
		assertEquals(description, expected, actual);
		
        // When Joker B is second to last in the deck
        deck = "1 4 7 10 13 3 6 9 12 2 14 5 8 15 11";
        description = "Moving Joker B down by two when Joker B "
                + "is the next to last card in the deck";
        expected = "15 4 7 10 13 3 6 9 12 2 14 5 8 11 1";
        actual = SomewhatMoreSimplifiedSolitaire.moveSecondJokerDownTwo(deck);
        assertEquals(description, expected, actual);

        // When Joker B is at the end of the deck
        deck = "1 4 7 10 13 3 6 9 12 2 14 5 8 11 15";
        description = "Moving Joker B down by two when Joker B "
                + "is the last card in the deck";
        expected = "4 15 7 10 13 3 6 9 12 2 14 5 8 11 1";
        actual = SomewhatMoreSimplifiedSolitaire.moveSecondJokerDownTwo(deck);
        assertEquals(description, expected, actual);
    }
        
    

    @Test
    public void testTripleCut() {
        // If joker A is before joker B
		String deck = "5 7 1 4 14 2 3 6 10 8 9 15 11 13 12";
		String description = "Doing a triple cut when Joker A "
		                           + "is in front of Joker B";
		String expected = "11 13 12 14 2 3 6 10 8 9 15 5 7 1 4";
		String actual = SomewhatMoreSimplifiedSolitaire.tripleCut(deck);
		assertEquals(description, expected, actual);
		
		// If joker B is before joker A
		deck = "6 8 15 9 10 3 4 2 5 14 1 7 12 11 13";
		description = "Doing a triple cut when Joker B "
		                      + "is in front of Joker A";

		expected = "1 7 12 11 13 15 9 10 3 4 2 5 14 6 8";
		actual = SomewhatMoreSimplifiedSolitaire.tripleCut(deck);
		assertEquals(description, expected, actual);
    }

    @Test
    public void testMoveToBack() {
        String deck = "1 4 7 10 13 3 6 9 12 11 2 14 5 8 15";
        String description = "Moving the cards to the back when the last card " 
                + "is Joker B";
        String expected = "1 4 7 10 13 3 6 9 12 11 2 14 5 8 15";
        String actual = SomewhatMoreSimplifiedSolitaire.moveToBack(deck);
        assertEquals(description, expected, actual);
        
        deck = "1 4 7 10 13 3 6 9 12 11 2 15 5 8 14";
        description = "Moving the cards to the back when the last card " 
                + "is Joker A";
        expected = "1 4 7 10 13 3 6 9 12 11 2 15 5 8 14";
        actual = SomewhatMoreSimplifiedSolitaire.moveToBack(deck);
        assertEquals(description, expected, actual);
        
        deck = "1 4 7 10 13 3 6 9 12 11 2 15 5 14 8";
        description = "Moving the cards to the back when the last card " 
                + "is not a Joker";
        expected = "12 11 2 15 5 14 1 4 7 10 13 3 6 9 8";
        actual = SomewhatMoreSimplifiedSolitaire.moveToBack(deck);
        assertEquals(description, expected, actual);
    }

    @Test
    public void testGetKey() {
        String deck = "1 4 7 10 13 3 6 9 12 11 2 14 5 8 15";
        String description = "Getting the key value when the first card  " 
                + "is 1";
        String expected = "4";
        String actual = SomewhatMoreSimplifiedSolitaire.getKey(deck);
        assertEquals(description, expected, actual);
        
        deck = "15 4 7 10 13 3 6 9 12 11 2 14 5 8 1";
        description = "Getting the key value when the first card  " 
                + "is Joker B";
        expected = "1";
        actual = SomewhatMoreSimplifiedSolitaire.getKey(deck);
        assertEquals(description, expected, actual);
        
        deck = "14 4 7 10 13 3 6 9 12 11 2 15 5 8 1";
        description = "Getting the key value when the first card  " 
                + "is Joker A";
        expected = "1";
        actual = SomewhatMoreSimplifiedSolitaire.getKey(deck);
        assertEquals(description, expected, actual);
    }

    @Test
    public void testShuffle() {
        // Shuffling deck when jokers are in the middle
		String deck = "2 7 5 10 11 13 14 15 1 4 9 8 3 6 12";
		String description = "Shuffling the deck when the jokers "
		                  + "are in the middle of the deck";
		String expected = "11 4 9 8 3 6 12 14 1 15 2 7 5 10 13";
		String actual = SomewhatMoreSimplifiedSolitaire.shuffle(deck);
		assertEquals(description, expected, actual);
		
		// Shuffling deck when there is a joker at the end
		deck = "7 5 10 3 6 11 13 15 2 4 8 1 9 12 14";
		description = "Shuffling the deck when there is a joker "
		                               + "at the end of the deck";
		expected = "8 1 9 12 7 14 5 10 3 6 11 13 2 4 15";
		actual = SomewhatMoreSimplifiedSolitaire.shuffle(deck);
		assertEquals(description, expected, actual);
    }

}
