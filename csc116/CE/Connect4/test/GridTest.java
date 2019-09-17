import org.junit.Before;
import org.junit.Test;
import java.awt.*;
import junit.framework.TestCase;

/**
 * Test for Grid object
 *
 * @author Jay Vandeveld
 * @author Jamea Speight 
 * @author Johnathan Rhyne
 * @author Tess Colavecchio
 */
public class GridTest extends TestCase {
    
     /** Grid for testing */
    private Grid grid;

    /** Player one */
    private Player player1;

    /**
     * Creates Grid for testing
     */
    @Before
    public void setUp() {
        grid = new Grid();
    }

    @Test
    public void testSetGridElementPreCondition(){
        try {
            grid.setGridElement(10, 10, "X");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Correct IllegalArgumentException message", "Invalid row or column input",
                    e.getMessage());
        }

        try {
            grid.setGridElement(-5, 10, "O");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Correct IllegalArgumentException message", "Invalid row or column input",
                    e.getMessage());
        }
    }
    
    @Test
    public void testGetGridElementPreCondition(){
        assertEquals("correct return", "a" ,grid.getGridElement(8, 8));
            
    }

    
    @Test
    public void testSetandGetGridElement(){
        grid.setGridElement(4,4, "X");
        assertEquals("Player1 Piece", "X", grid.getGridElement(4,4));
    }

    @Test
    public void testSetandGetGridElement2(){
        grid.setGridElement(5,6, "O");
        assertEquals("Player2 Piece", "O", grid.getGridElement(5,6));
    }


}