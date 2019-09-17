import static org.junit.Assert.*;

import org.junit.Test;
/**
 * Program determines if two dimensional arrays are equal.
 * 
 * @author Jessica Young Schmidt
 * @author Jamea Speight
 * @author Jay Vandeveld
 */
public class TwoDArrayEqualityTest {

    @Test
    public void testEquals2DIntA() {
        int[][] ints8 = { { 1 }, { 2, 3 } };
        assertTrue(TwoDArrayEquality.equals2D(ints8, ints8));

    }

    @Test
    public void testEquals2DIntB() {
        int[][] ints8 = { { 1 }, { 2, 3 } };
        int[][] ints9 = { { 2, 3 }, { 1 } };
        assertFalse(TwoDArrayEquality.equals2D(ints8, ints9));
        assertFalse(TwoDArrayEquality.equals2D(ints9, ints8));

    }

    @Test
    public void testEquals2DIntC() {
        int[][] ints10 = { { 1, 2 }, { 2, 3 } };
        int[][] ints11 = { { 1, 2 }, { 3, 4} };
        assertFalse(TwoDArrayEquality.equals2D(ints10, ints11));
        assertFalse(TwoDArrayEquality.equals2D(ints11, ints10));

    }

    @Test
    public void testEquals2DIntD() {
        int[][] ints12 = { { 1, 2 }, { 3, 4 } };
        int[][] ints13 = { { 1, 2 }, { 3, 4} };
        assertTrue(TwoDArrayEquality.equals2D(ints12, ints13));
        assertTrue(TwoDArrayEquality.equals2D(ints13, ints12));

    }

    @Test
    public void testEquals2DIntE() {
        int[][] ints14 = { { 1 } };
        int[][] ints15 = { { 1 } };
        assertTrue(TwoDArrayEquality.equals2D(ints14, ints15));
        assertTrue(TwoDArrayEquality.equals2D(ints15, ints14));

    }
    

    @Test
    public void testEquals2DStringA() {
        String[][] strings1 = { { "Cat", "Dog", "Puppy" }, { "A", "B", "C" } };

        assertTrue(TwoDArrayEquality.equals2D(strings1, strings1));
    }

    @Test
    public void testEquals2DStringB() {
        String[][] strings1 = { { "Cat", "Dog", "Puppy" }, { "A", "B", "C" } };

        String[][] strings3 = { { "Cat", "dog", "Puppy" }, { "A", "B", "C" } };// One
                                                                               // different
                                                                               // value

        assertFalse(TwoDArrayEquality.equals2D(strings1, strings3));
        assertFalse(TwoDArrayEquality.equals2D(strings3, strings1));
    }

    @Test
    public void testEquals2DStringC() {
        String[][] strings1 = { { "Cat" }, { "A", "B", "C" } };

        String[][] strings3 = { { "Dog" }, { "A", "B", "C" } };

        assertFalse(TwoDArrayEquality.equals2D(strings1, strings3));
        assertFalse(TwoDArrayEquality.equals2D(strings3, strings1));
    }

    @Test
    public void testEquals2DStringD() {
        String[][] strings1 = { { "Cat", "Dog", "Puppy" }, { "A", "B", "C" } };

        String[][] strings3 = { { "Cat", "Dog", "Puppy" }, { "A", "B", "C" } };

        assertTrue(TwoDArrayEquality.equals2D(strings1, strings3));
        assertTrue(TwoDArrayEquality.equals2D(strings3, strings1));
    }

    @Test
    public void testEquals2DStringE() {
        String[][] strings1 = { { "Cat" } };

        String[][] strings3 = { { "Dog" } };

        assertFalse(TwoDArrayEquality.equals2D(strings1, strings3));
        assertFalse(TwoDArrayEquality.equals2D(strings3, strings1));
    }
    
}
