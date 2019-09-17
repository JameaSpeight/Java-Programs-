import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
/**
 * Tests StringArray program
 * 
 * @author Jamea Speight
 * @author Jay Vandeveld
 */
public class StringArraysTest {
    @Test
    public void testIsPalindrome() {
        String[] arr = {};
        boolean test = StringArrays.isPalindrome(arr);

        assertEquals(Arrays.deepToString(arr), true, test);

        String[] arr2 = { "I <3 Marty Stepp!" };
        test = StringArrays.isPalindrome(arr2);
        assertEquals(Arrays.deepToString(arr2), true, test);

        String[] arr3 = { "one", "two", "one" };
        test = StringArrays.isPalindrome(arr3);
        assertEquals(Arrays.deepToString(arr3), true, test);

        String[] arr3case = { "one", "two", "ONE" };
        test = StringArrays.isPalindrome(arr3case);
        assertEquals(Arrays.deepToString(arr3case), false, test);

        String[] arr4 = { "one", "two", "three" };
        test = StringArrays.isPalindrome(arr4);
        assertEquals(Arrays.deepToString(arr4), false, test);

        String[] arr5 = { "aay", "bee", "cee", "cee", "bee", "aay" };
        test = StringArrays.isPalindrome(arr5);
        assertEquals(Arrays.deepToString(arr5), true, test);

        String[] arr6 = { "aay", "bee", "cee", "dee", "cee", "bee", "aay" };
        test = StringArrays.isPalindrome(arr6);
        assertEquals(Arrays.deepToString(arr6), true, test);
        
        String[] arr7 = { "dog" };
        test = StringArrays.isPalindrome(arr7);
        assertEquals(Arrays.deepToString(arr7), true, test);

        String[] arr8 = { "dog", "dog" };
        test = StringArrays.isPalindrome(arr8);
        assertEquals(Arrays.deepToString(arr8), true, test);
    }

}
