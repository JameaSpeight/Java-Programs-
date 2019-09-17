import org.junit.Before;
import org.junit.Test;
import java.awt.*;
import junit.framework.TestCase;

/**
 * Test for Player object
 *
 * @author Jay Vandeveld
 * @author Jamea Speight 
 * @author Johnathan Rhyne
 * @author Tess Colavecchio
 */
public class PlayerTest extends TestCase {
    
    /** player one */
    private Player player1;

    /** player two */
    private Player player2;

    /** 
      * Create the player for testing.
      */
    @Before 
    public void setUp() {
        player1 = new Player("test", "X");
        player2 = new Player("test", "O");
    }

    @Test 
    public void testGetPiecePlayer1() {
        assertEquals("Player1 piece" , "X", player1.getPiece());
    }
    
    @Test 
    public void testGetPiecePlayer2() {
        assertEquals("Player2 piece" , "O", player2.getPiece());
    }
    
     
}

