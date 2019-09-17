import org.junit.Before;
import org.junit.Test;
import java.awt.*;
import junit.framework.TestCase;

/**
 * Test for ConnectFour object
 * NOTE: playerOnePlaying alternates with every method that tests numConneccted, as it checks
 *      for num connected for whoever's turn it is when the method is called, so it emulates that
 *
 * @author Jay Vandeveld
 * @author Jamea Speight 
 * @author Johnathan Rhyne
 * @author Tess Colavecchio
 */
public class ConnectFourTest extends TestCase {
    /** creates a ConnectFour object */
    private ConnectFour board;
    
    /** Setting up the ConnectFour grid */
    @Before 
    public void setUp() {
        board = new ConnectFour (8,8);
    }
    
    @Test
    public void testNumConnectedHorizontally() {
        board.playerOnePlaying = true;
        board.setPiece(0, true);
        board.setPiece(1, true);
        board.setPiece(2, true);
        assertEquals("Same Row" ,3, board.checkNumConnected());
    }
    
    @Test
    public void testNumConnectedVertically() {
        board.playerOnePlaying = false;
        board.setPiece(0, false);
        board.setPiece(0, false);
        board.setPiece(0, false);
        assertEquals("Same Col" ,3, board.checkNumConnected());
    }
    
    @Test
    public void testNumConnectedDiagUp() {
        board.playerOnePlaying = false;
        board.setPiece(0, false);
        board.setPiece(1, true);
        board.setPiece(1, false);
        board.setPiece(2, true);
        board.setPiece(2, true);
        board.setPiece(2, false);
        assertEquals("diagonal SW to NE", 3, board.checkNumConnected());
    }
    
    @Test
    public void testNumConnectedDiagDown() {
        board.playerOnePlaying = true;
        board.setPiece(0, false);
        board.setPiece(0, false);
        board.setPiece(0, true);
        board.setPiece(1, false);
        board.setPiece(1, true);
        board.setPiece(2, true);
        assertEquals("diagonal SE to NW", 3, board.checkNumConnected());
    }
    
    @Test
    public void testNumConnectedMoreThanOneGroup() {
        board.playerOnePlaying = false;
        board.setPiece(0, false);
        board.setPiece(0, false);
        board.setPiece(0, false);
        board.setPiece(7, false);
        board.setPiece(7, false);
        assertEquals("2 vertical columns", 3, board.checkNumConnected());
    }
    
    @Test
    public void testNumConnectedOneXTwoO() {
        board.playerOnePlaying = false;
        board.setPiece(0, false);
        board.setPiece(6, true);
        board.setPiece(6, true);
        assertFalse("not counting wrong stack", board.checkNumConnected() != 1);
        assertEquals("counting the correct stack", 1, board.checkNumConnected());
    }

    @Test
    public void testSetandGetPiecePlayerOne() {
        board.setPiece(4, true);
        assertEquals("Player1 playing", "          X", board.getPiece(7, 4));
    }
    
    @Test
    public void testSetandGetPiecePlayerTwo() {
        board.setPiece(3, false);
        assertEquals("Player2 playing", "          O", board.getPiece(7, 3));
    }
}