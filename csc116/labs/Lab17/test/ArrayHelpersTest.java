import java.util.Arrays;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Program that deals with arrays in different ways
 * 
 * 
 * 
 * @author Jamea Speight
 * @author Jay Vandeveld 
 */
public class ArrayHelpersTest extends TestCase {

    @Test
    public void testAllLessA() {
        int[] arr1 = { 1, 2, 3 };
        int[] arr2 = { 4, 5, 6 };
        assertTrue(ArrayHelpers.allLess(arr1, arr2));
        assertFalse(ArrayHelpers.allLess(arr2, arr1));
        assertFalse(ArrayHelpers.allLess(arr1, arr1));
    }
    @Test
    public void testAllLessB() {
        int[] arr1 = { 0, 2, 3 };
        int[] arr2 = { 3, 2, 1 };
        assertFalse(ArrayHelpers.allLess(arr1, arr2));
        assertFalse(ArrayHelpers.allLess(arr2, arr1));
        assertFalse(ArrayHelpers.allLess(arr1, arr1));
    }
    @Test
    public void testAllLessC() {
        int[] arr1 = { 0, 2, 3 };
        int[] arr2 = { 3, 2 };
        assertFalse(ArrayHelpers.allLess(arr1, arr2));
        assertFalse(ArrayHelpers.allLess(arr2, arr1));
        assertFalse(ArrayHelpers.allLess(arr1, arr1));
    }
    @Test
    public void testAllLessD() {
        int[] arr1 = { 2 };
        int[] arr2 = { 1 };
        assertFalse(ArrayHelpers.allLess(arr1, arr2));
        assertTrue(ArrayHelpers.allLess(arr2, arr1));
        assertFalse(ArrayHelpers.allLess(arr1, arr1));
    }
    @Test
    public void testAllLessE() {
        int[] arr1 = { -1, 2 ,5};
        int[] arr2 = { 0, 4, 8 };
        assertTrue(ArrayHelpers.allLess(arr1, arr2));
        assertFalse(ArrayHelpers.allLess(arr2, arr1));
        assertFalse(ArrayHelpers.allLess(arr1, arr1));
    }
   

    @Test
    public void testSwapPairsA() {
        int[] arrSwapA = { 10, 20, 30, 40, 50 };
        int[] arrSwapAExp = { 20, 10, 40, 30, 50 };
        ArrayHelpers.swapPairs(arrSwapA);
        assertTrue(Arrays.equals(arrSwapAExp, arrSwapA));
    }

    @Test
    public void testSwapPairsB() {
        int[] arrSwapA = { 10, 20, 30, 40, 50, 60 };
        int[] arrSwapAExp = { 20, 10, 40, 30, 60, 50 };
        ArrayHelpers.swapPairs(arrSwapA);
        assertTrue(Arrays.equals(arrSwapAExp, arrSwapA));
    }
    
    @Test
    public void testSwapPairsC() {
        int[] arrSwapA = { 10, -10, -20, 20 };
        int[] arrSwapAExp = { -10, 10, 20, -20 };
        ArrayHelpers.swapPairs(arrSwapA);
        assertTrue(Arrays.equals(arrSwapAExp, arrSwapA));
    }
    
    @Test
    public void testSwapPairsD() {
        int[] arrSwapA = { 10, 20 };
        int[] arrSwapAExp = { 20, 10 };
        ArrayHelpers.swapPairs(arrSwapA);
        assertTrue(Arrays.equals(arrSwapAExp, arrSwapA));
    }    

}
