import org.junit.Before;
import org.junit.Test;
import java.awt.*;

import junit.framework.TestCase;

/**
 * Tests Card class
 * @author Suzanne Balik
 * @author Jamea Speight
 */
public class CardTest extends TestCase {

    /** card two of hearts for testing */
    private Card twoOfHearts;

    /** card ace of spades for testing */
    private Card aceOfSpades;
   

    /**
     * Create cards for testing
     */
    @Before
    public void setUp() {
        twoOfHearts = new Card('h', 2);
        aceOfSpades = new Card('s',14);
    }

    @Test
    public void testConstants() {
        // The following tests test that constants are defined as specified
        assertEquals("CLUBS", 'c', Card.CLUBS);
        assertEquals("DIAMONDS", 'd', Card.DIAMONDS);
        assertEquals("SPADES", 's', Card.SPADES);
        assertEquals("HEARTS", 'h', Card.HEARTS);
        assertEquals("LOWEST_VALUE", 2, Card.LOWEST_VALUE);
        assertEquals("HIGHEST_VALUE]", 14, Card.HIGHEST_VALUE);
    }


    @Test
    public void testConstructorPreConditions() {
        try {
            new Card('h', 1);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Correct IllegalArgumentException message", "Invalid value",
                    e.getMessage());
        }

        try {
            new Card('s', 15);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Correct IllegalArgumentException message", "Invalid value",
                    e.getMessage());
        }

        try {
            new Card('x', 5);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Correct IllegalArgumentException message", "Invalid suit",
                    e.getMessage());
        }       

        try {
            new Card('D', 8);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Correct IllegalArgumentException message", "Invalid suit",
                    e.getMessage());
        }
    }

    @Test
    public void testGetValueTwoOfHearts() {
        assertEquals("twoOfHearts value", 2, twoOfHearts.getValue());
    }
    
    @Test
    public void testGetValueAceOfSpades() {
        assertEquals("aceOfSpades value", 14, aceOfSpades.getValue());
    }

    @Test
    public void testGetSuitTwoOfHearts() {
        assertEquals("twoOfHearts suit", 'h', twoOfHearts.getSuit());
    }
    
    @Test
    public void testGetSuitAceOfSpades() {
        assertEquals("aceOfSpades suit", 's', aceOfSpades.getSuit());
    }

    @Test
    public void testGetColorTwoOfHearts() {
        assertEquals("twoOfHearts color", Color.RED, twoOfHearts.getColor());
    }
    
    @Test
    public void testGetColorAceOfSpades() {
        assertEquals("aceOfSpades color", Color.BLACK, aceOfSpades.getColor());
    }

    @Test
    public void testToStringTwoOfHearts() {
        assertEquals("twoOfHearts toString", "h2", twoOfHearts.toString());
    }
    
    @Test
    public void testToStringAceOfSpades() {
        assertEquals("aceOfSpades toString", "s14", aceOfSpades.toString());
    }

    @Test
    public void testHasBeenFoundTwoOfHearts() {
        assertFalse("twoOfHearts hasBeenFound", twoOfHearts.hasBeenFound());
    }
    
    @Test
    public void testHasBeenFoundAceOfSpades() {
        assertFalse("aceOfSpades hasBeenFound", aceOfSpades.hasBeenFound());
    }

    @Test
    public void testSetHasBeenFoundTwoOfHearts() {
        twoOfHearts.setHasBeenFound(true);
        assertTrue("twoOfHearts setHasBeenFound true", twoOfHearts.hasBeenFound());
        twoOfHearts.setHasBeenFound(false);
        assertFalse("twoOfHearts setHasBeenFound false", twoOfHearts.hasBeenFound());
    }
   
    @Test
    public void testSetHasBeenFoundAceOfSpades() {
        aceOfSpades.setHasBeenFound(true);
        assertTrue("aceOfSpades setHasBeenFound true", aceOfSpades.hasBeenFound());
        aceOfSpades.setHasBeenFound(false);
        assertFalse("aceOfSpades setHasBeenFound false", aceOfSpades.hasBeenFound());
    }

    @Test
    public void testHasSameValue() {
        assertTrue("twoOfHearts has same value", twoOfHearts.hasSameValue(new Card('c', 2)));
        assertFalse("twoOfHearts has different value", twoOfHearts.hasSameValue(new Card('s', 3)));
    }
    
    @Test
    public void testHasSameValue2() {
        assertTrue("aceOfSpades has same value", aceOfSpades.hasSameValue(new Card('s', 14)));
        assertFalse("aceOfSpades has different value", 
                    aceOfSpades.hasSameValue(new Card('s', 2)));
    }
    
    @Test
    public void testHasSameValueAndColor() {
        assertTrue("twoOfHearts has same value and color", 
                   twoOfHearts.hasSameValueAndColor(new Card('d', 2)));
        assertFalse("twoOfHearts has different value and color", 
                    twoOfHearts.hasSameValueAndColor(new Card('s', 3)));
        assertFalse("twoOfHearts has different value and same color", 
                    twoOfHearts.hasSameValueAndColor(new Card('d', 8)));
        assertFalse("twoOfHearts has same value and different color", 
                    twoOfHearts.hasSameValueAndColor(new Card('s', 2)));
    }
    
    @Test
    public void testHasSameValueAndColor2() {
        assertTrue("aceOfSpades has same value and color", 
                   aceOfSpades.hasSameValueAndColor(new Card('s', 14)));
        assertFalse("aceOfSpades has different value and color", 
                    aceOfSpades.hasSameValueAndColor(new Card('h', 13)));
        assertFalse("aceOfSpades has different value and same color", 
                    aceOfSpades.hasSameValueAndColor(new Card('c', 8)));
        assertFalse("aceOfSpades has same value and different color", 
                    aceOfSpades.hasSameValueAndColor(new Card('h', 14)));
    }
    
    @Test
    public void testEqualsTwoOfHearts() {
        assertTrue("twoOfHearts equals with same instance", twoOfHearts.equals(twoOfHearts));
        assertTrue("twoOfHearts equals with different instances", 
                   twoOfHearts.equals(new Card('h', 2)));
        assertFalse("twoOfHearts with different value", twoOfHearts.equals(new Card('h', 4)));
        assertFalse("twoOfHearts with different suit", twoOfHearts.equals(new Card('s', 2)));
        assertFalse("twoOfHearts with different value and suit", 
                    twoOfHearts.equals(new Card('c', 5)));
        assertFalse("twoOfHearts compared to null object", twoOfHearts.equals(null));
        assertFalse("twoOfHearts compared to String", twoOfHearts.equals("twoOfHearts"));
    }
    
    @Test
    public void testEqualsAceOfSpades() {
        assertTrue("aceOfSpades equals with same instance", aceOfSpades.equals(aceOfSpades));
        assertTrue("aceOfSpades equals with different instances", 
                   aceOfSpades.equals(new Card('s', 14)));
        assertFalse("aceOfSpades with different value", aceOfSpades.equals(new Card('h', 4)));
        assertFalse("aceOfSpades with different suit", aceOfSpades.equals(new Card('s', 2)));
        assertFalse("aceOfSpades with different value and suit", 
                    aceOfSpades.equals(new Card('c', 5)));
        assertFalse("aceOfSpades compared to null object", aceOfSpades.equals(null));
        assertFalse("aceOfSpades compared to String", aceOfSpades.equals("twoOfHearts"));
    }


}
