import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

/**
 * Tests MatchGame class
 * @author Suzanne Balik
 * @author
 */
public class MatchGameTest extends TestCase {
    
    /** epsilon used for testing getGuessAverage() method */
    public static final double EPSILON = .001;

    /** Easy MatchGame instance used for testing */
    private MatchGame mgEasy;

    /** Hard MatchGame instance used for testing */
    private MatchGame mgHard;
    
    
    /**
     * Create new Match Game instances for testing
     */
    @Before
    public void setUp() {
        mgEasy = new MatchGame(true, true);
        mgHard = new MatchGame(true, false);
    }

    @Test
    public void testConstants() {
        // The following test tests that required constants are defined as specified
        assertEquals("ROWS", 4, MatchGame.ROWS);
        assertEquals("COLS", 13, MatchGame.COLS);
    }

    @Test
    public void testConstructor() {

        assertEquals("Initial number of guesses", 0, mgEasy.getNumberOfGuesses());
        assertEquals("Initial number of guesses", 0, mgEasy.getNumberOfCorrectGuesses());
        assertEquals("Initial guess average", 0, mgEasy.getGuessAverage(), EPSILON);
        assertEquals("Correct card at 0 0", "c2", mgEasy.getCardName(0, 0));
        assertEquals("Correct card at 3 12", "s14", mgEasy.getCardName(3, 12));
        assertFalse("Not found at 2 5", mgEasy.hasBeenFound(2, 5));
    }

    @Test
    public void testHasBeenFoundPreConditions() {
        
        try {
            mgEasy.hasBeenFound(-3, 2);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Correct IllegalArgumentException message", "Invalid row",
                    e.getMessage());
        }

        try {
            mgEasy.hasBeenFound(3, 15);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Correct IllegalArgumentException message", "Invalid col",
                    e.getMessage());
        }
    }

    @Test
    public void testIsMatchPreConditions() {
        
        try {
            mgEasy.isMatch(-3, 2, 1, 2);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Correct IllegalArgumentException message", "Invalid card1Row",
                    e.getMessage());
        }

        try {
            mgEasy.isMatch(3, 25, 1, 2);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Correct IllegalArgumentException message", "Invalid card1Col",
                    e.getMessage());
        }

        try {
            mgEasy.isMatch(3, 2, 10, 2);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Correct IllegalArgumentException message", "Invalid card2Row",
                    e.getMessage());
        }

        try {
            mgEasy.isMatch(3, 2, 1, -2);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Correct IllegalArgumentException message", "Invalid card2Col",
                    e.getMessage());
        }
    }

    @Test
    public void testGrid() {
        Grid grid = mgEasy.getGrid();
        String exp = "c2 c3 c4 c5 c6 c7 c8 c9 c10 c11 c12 c13 c14\n" +
                     "d2 d3 d4 d5 d6 d7 d8 d9 d10 d11 d12 d13 d14\n" +
                     "h2 h3 h4 h5 h6 h7 h8 h9 h10 h11 h12 h13 h14\n" +
                     "s2 s3 s4 s5 s6 s7 s8 s9 s10 s11 s12 s13 s14\n";
        assertEquals("Grid is correct", exp, grid.toString());
    }


    @Test
    public void testIsMatch() {
        assertTrue("Easy game match", mgEasy.isMatch(0, 0, 1, 0));
        assertFalse("Easy game not match", mgEasy.isMatch(0, 0, 0, 1));
        assertFalse("Easy game card already found not match", mgEasy.isMatch(0, 0, 2, 0));
        assertTrue("Hard game match", mgHard.isMatch(0, 0, 3, 0));
        assertFalse("Hard game same value not match", mgHard.isMatch(0, 0, 1, 0));
        assertFalse("Hard game different value/color not match", mgHard.isMatch(2, 1, 3, 8));
    }

    @Test
    public void testHasBeenFound() {
        assertFalse(mgEasy.hasBeenFound(0, 0));   
        mgEasy.isMatch(0, 0, 1, 0);
        assertTrue(mgEasy.hasBeenFound(0, 0));
    }

    @Test
    public void testPlayEasyGame1() {
        mgEasy.isMatch(2, 0, 2, 5);  //Not Match, different values
        mgEasy.isMatch(1, 1, 2, 1);  //Match
        mgEasy.isMatch(3, 8, 2, 8);  //Match
        mgEasy.isMatch(2, 7, 2, 10); //Not match, different values
        mgEasy.isMatch(1, 1, 3, 1);  //Not match, card already found    
        assertEquals("Easy game some correct guesses", .4, mgEasy.getGuessAverage());
    }

    @Test
    public void testPlayEasyGame2() {
        mgEasy.isMatch(1, 0, 3, 12); 
        mgEasy.isMatch(3, 0, 1, 12);  
        mgEasy.isMatch(1, 8, 1, 9);  
        mgEasy.isMatch(3, 0, 2, 10); 
        mgEasy.isMatch(1, 3, 3, 1);      
        assertEquals("Easy game no correct guesses", 0.0, mgEasy.getGuessAverage());
    }
    
    @Test
    public void testPlayEasyGame3() {
        mgEasy.isMatch(1, 0, 3, 0); 
        mgEasy.isMatch(0, 5, 1, 5);  
        mgEasy.isMatch(1, 8, 2, 8);  
        mgEasy.isMatch(3, 10, 2, 10); 
        mgEasy.isMatch(1, 6, 3, 6);      
        assertEquals("Easy game all correct guesses", 1.0, mgEasy.getGuessAverage());
    }
    
    @Test
    public void testPlayHardGame1() {
        mgHard.isMatch(0, 0, 3, 0); 
        mgHard.isMatch(2, 6, 1, 6);  
        mgHard.isMatch(1, 8, 2, 12);  
        mgHard.isMatch(3, 10, 2, 10); 
        mgHard.isMatch(1, 6, 2, 5);      
        assertEquals("Hard game some correct guesses", .4, mgHard.getGuessAverage());
    }
    
    @Test
    public void testPlayHardGame2() {
        mgHard.isMatch(1, 0, 3, 0); 
        mgHard.isMatch(2, 6, 1, 7);  
        mgHard.isMatch(1, 8, 2, 12);  
        mgHard.isMatch(3, 10, 2, 10); 
        mgHard.isMatch(1, 6, 2, 5);      
        assertEquals("Hard game some no correct guesses", 0.0, mgHard.getGuessAverage());
    }
    
    @Test
    public void testPlayHardGame3() {
        mgHard.isMatch(1, 0, 2, 0); 
        mgHard.isMatch(2, 6, 1, 6);  
        mgHard.isMatch(0, 8, 3, 8);  
        mgHard.isMatch(0, 0, 3, 0); 
        mgHard.isMatch(2, 9, 1, 9);      
        assertEquals("Hard game some all correct guesses", 1.0, mgHard.getGuessAverage());
    }

}
