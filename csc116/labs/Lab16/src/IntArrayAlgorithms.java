import java.util.Random;
import java.util.Scanner;

/**
 * Program that deals with arrays in different ways
 * 
 * 
 * 
 * @author Jamea Speight
 * @author Jay Vandeveld
 * @author Patricia Bradley
 */
public class IntArrayAlgorithms
{
    /**
     * Creates an array with given length and stores the values that are given from
     * the user.
     * 
     * @param length The length of the array that will be created and returned
     * @return Array with length elements that were given by the user
     */
    public static int[] getArrayFromUser(int length) 
    {
        int[] arr = new int[length];
        Scanner console = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) 
        {
            System.out.print("Element " + i + " (Integer): ");
            while (!console.hasNextInt()) 
            {
                console.next(); // discard token
                System.out.println("Not an integer.");
                System.out.print("Element " + i + " (Integer): ");
            }
            arr[i] = console.nextInt();
        }
        return arr;
    }

    /**
     * Creates an array with given length and stores the random values between 0 and
     * (bound-1)
     * 
     * @param length The length of the array that will be created and returned
     * @param bound The upperbound for the range of values within the array
     * @return Array with length elements that were assigned random integers
     */
    public static int[] getRandomArray(int length, int bound) 
    {
        Random r = new Random();
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) 
        {
            arr[i] = r.nextInt(bound);
        }
        return arr;
    }
    
    /**
     * Returns the contents of the array as a String in the format
     * {[val],[val],..[val]}
     * 
     * @param arr Array to return as a String
     * @return String format ({[val],[val],..[val]}) of arr
     */
    public static String arrayAsString(int[] arr) 
    {
        String ret = "{";
        for (int i = 0; i < arr.length; i++) 
        {
            ret += arr[i];
            if (i < arr.length - 1) 
            {
                ret += ", ";
            }
        }
        ret += "}";
        return ret;
    }
    /**
     * Outputs the greatest index of a given value.
     * If value isn't found, return -1.
     *
     * @param A - array of integers from user input
     * @param value - last value of the array
     * @return last index containing the value 
     */
    public static int lastIndexOf(int[] A, int value)
    {
        for (int i = A.length - 1; i >= 0; i--)
        {        
            if(value == A[i])
            {
                return i;
            }
        }
        return -1;
    }
    /**
     * Returns the range of the integers in the array
     *
     *
     * @param A - array of integers from user input
     * @return the range of the values
     */
    public static int range(int[] A)
    {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++)
        {
            max = Math.max(A[i], max);
            min = Math.min(A[i], min);
        }
        int range = (max - min + 1);  
        return range;
        
    }
    /**
     * outputs the number of integers in the array that
     * are in the range given
     *
     * @param A - array of integers from user input
     * @param min - lowest number in range of acceptable numbers
     * @param max - highest number in range of acceptable numbers
     * @return the count of numbers in the range
     */
    public static int countInRange(int[] A, int min,int max)
    {
        int count = 0;
        for(int i = 0; i < A.length; i++)
        {
            if(A[i] >= min && A[i] <= max)
            {
                count ++;
            }
        } 
        return count;
    }
}




























