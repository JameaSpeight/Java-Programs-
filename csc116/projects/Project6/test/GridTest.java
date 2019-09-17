import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

/**
 * Tests Grid class
 * @author Suzanne Balik
 */
public class GridTest extends TestCase {
    
    /** Grid for testing */
    private Grid grid;

    /**
     * Creates Grid for testing
     */
    @Before
    public void setUp() {
        grid = new Grid(2, 3);
    }


    @Test
    public void testConstructorPreConditions() {
 
        try {
            new Grid(0, 2);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Correct IllegalArgumentException message", "Invalid rows/cols",
                    e.getMessage());
        }

        try {
            new Grid(3, -4);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Correct IllegalArgumentException message", "Invalid rows/cols",
                    e.getMessage());
        }      
    }

    @Test
    public void testSetCardPreConditions() {
        try {
            grid.setCard(1, 1, null);
            fail();
        } catch (NullPointerException e) {
            assertEquals("Correct NullPointerException message", "Null card",
                    e.getMessage());
        }

        try {
            grid.setCard(5, 1, new Card('c', 2));
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Correct IllegalArgumentException message", "Invalid row",
                    e.getMessage());
        }

        try {
            grid.setCard(0, -1, new Card('c', 2));
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Correct IllegalArgumentException message", "Invalid col",
                    e.getMessage());
        }
    }



    @Test
    public void testGetCardPreConditions() {
        
        try {
            grid.getCard(5, 1);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Correct IllegalArgumentException message", "Invalid row",
                    e.getMessage());
        }

        try {
            grid.getCard(0, -1);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Correct IllegalArgumentException message", "Invalid col",
                    e.getMessage());
        }
    }

    @Test
    public void testSetAndGetCard() {
        grid.setCard(0, 2, new Card('h', 8));
        assertEquals("Card ", new Card('h', 8), grid.getCard(0, 2));
    }


    @Test
    public void testToString() {
        for (int j = 0; j < 3; j++) {
            grid.setCard(0, j, new Card('c', j + 2));
        }
        for (int j = 0; j < 3; j++) {
            grid.setCard(1, j, new Card('d', j + 2));
        }
        String expected = "c2 c3 c4\nd2 d3 d4\n";
        assertEquals("toString  after constructed",
                     expected, grid.toString());
    }
}
