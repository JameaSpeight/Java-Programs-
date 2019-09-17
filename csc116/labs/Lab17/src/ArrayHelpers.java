/**
 * Accepts arrays and compares them and swaps adjacent indexes.
 * 
 * 
 * 
 * @author Jamea Speight
 * @author Jay Vandeveld
 */
public class ArrayHelpers {
    
    /**
     * accepts two arrays of integers and returns true if each element in the first
     * array is less than the element at the same index in the second array. Your
     * method should return false if the arrays are not the same length.
     * 
     * @param arr1 first array to compare
     * @param arr2 second array to compare
     * @return true if elements in first array are less than elements in second
     *         array at each index, else false
     */
    public static boolean allLess(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] >= arr2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Accepts an array of integers and swaps the elements at adjacent indexes. That
     * is, elements 0 and 1 are swapped, elements 2 and 3 are swapped, and so on. If
     * the array has an odd length, the final element should be left unmodified.
     * 
     * @param arr array of integers
     */
    public static void swapPairs(int[] arr) {
        for (int i = 0; i <= arr.length - 2; i += 2) {
            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp; 
        }
    }

}
