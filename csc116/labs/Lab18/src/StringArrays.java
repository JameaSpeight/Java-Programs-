/**
 * Program that performs String array methods
 * 
 * @author Jamea Speight
 * @author Jay Vandeveld
 */
public class StringArrays {
    /**
     * Test a string to see if it is a palindrome
     *
     * @param a String array to examine
     * @return whether a is a palindrome
     */
    public static boolean isPalindrome(String[] a) {
        for(int i = 0; i <= (a.length - 1); i++) {
            if (a [i] != a [(a.length - i - 1)]){ 
                return false;
            }
        }
        return true;
    }
}
