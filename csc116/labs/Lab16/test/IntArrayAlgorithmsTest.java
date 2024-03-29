import org.junit.Test;

import junit.framework.TestCase;

/**
 * Program to test IntArrayAlgorithms
 * 
 * @author Jessica Young Schmidt
 */
public class IntArrayAlgorithmsTest extends TestCase {

    /**
     * Tests the countInRange method
     */
    @Test
    public void testCountInRange() {
        int[] arr = { 74, 85, 102, 99, 101, 85, 56 };
        String desc = "IntArrayAlgorithms.countInRange(arr, 0, 1000)";
        int expected = 7;
        int actual = IntArrayAlgorithms.countInRange(arr, 0, 1000);
        assertEquals(desc, expected, actual);

        desc = "IntArrayAlgorithms.countInRange(arr, 101, 102)";
        expected = 2;
        actual = IntArrayAlgorithms.countInRange(arr, 101, 102);
        assertEquals(desc, expected, actual);

        desc = "IntArrayAlgorithms.countInRange(arr, 102, 102)";
        expected = 1;
        actual = IntArrayAlgorithms.countInRange(arr, 102, 102);
        assertEquals(desc, expected, actual);

        int[] arrG = { 14, 1, 22, 17, 36, 7, -43, 5 };
        desc = "IntArrayAlgorithms.countInRange(arrG, 4, 17)";
        expected = 4;
        actual = IntArrayAlgorithms.countInRange(arrG, 4, 17);
        assertEquals(desc, expected, actual);
        
        desc = "IntArrayAlgorithms.countInRange(arrG, -50, 3)";
        expected = 2;
        actual = IntArrayAlgorithms.countInRange(arrG, -50, 3);
        assertEquals(desc, expected, actual);
    }

    /**
     * Tests the range method
     */
    @Test
    public void testRange() {
        int[] arr = { 74, 85, 102, 99, 101, 85, 56 };
        String desc = "Duplicate elements";
        int expected = 47;
        int actual = IntArrayAlgorithms.range(arr);
        assertEquals(desc, expected, actual);

        int[] arr1 = { 74 };
        desc = "Single element";
        expected = 1;
        actual = IntArrayAlgorithms.range(arr1);
        assertEquals(desc, expected, actual);

        int[] arr2 = { 36, 12, 25, 19, 46, 31, 22 };
        desc = "Given array";
        expected = 35;
        actual = IntArrayAlgorithms.range(arr2);
        assertEquals(desc, expected, actual);
        
        int[] arr3 = { 0, 3, 5, 6 };
        desc = "A zero element";
        expected = 7;
        actual = IntArrayAlgorithms.range(arr3);
        assertEquals(desc, expected, actual);
    }

    /**
     * tests the lastIndexOf method
     */
    @Test
    public void testLastIndexOf() {
        int[] arr = { 74, 85, 102, 99, 101, 85, 56 };
        String desc = "Duplicate elements";
        int expected = 5;
        int actual = IntArrayAlgorithms.lastIndexOf(arr, 85);
        assertEquals(desc, expected, actual);

        desc = "Doesn't exist";
        expected = -1;
        actual = IntArrayAlgorithms.lastIndexOf(arr, 83);
        assertEquals(desc, expected, actual);

        desc = "First element";
        expected = 0;
        actual = IntArrayAlgorithms.lastIndexOf(arr, 74);
        assertEquals(desc, expected, actual);

        int[] arrE = {};
        desc = "Empty array";
        expected = -1;
        actual = IntArrayAlgorithms.lastIndexOf(arrE, 74);
        assertEquals(desc, expected, actual);
        
        int[] arr2 = { 1, 1, 3, 1, 5, 1, 4 };
        desc = "Multiple Duplicate elements";
        expected = 5;
        actual = IntArrayAlgorithms.lastIndexOf(arr2, 1);
        assertEquals(desc, expected, actual);
       
    }

}

