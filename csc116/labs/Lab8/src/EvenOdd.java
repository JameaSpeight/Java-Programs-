import java.util.Scanner;

/**
 * Write an application that asks a user to enter an integer. Display a
 * statement that indicates whether the integer is even or odd.
 * 
 * @author Jamea Speight
 * @author Matt Spivey
 */
public class EvenOdd {

    /**
     * The method that is executed when the program is run
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter a number: " );
        int num = in.nextInt();
        System.out.println("The value " + num + " is" +  evenOdd (num) + ".");
    }
    /**
     * This method decides whether the entered number is even or odd 
     * 
     */
    public static String evenOdd(int num) {
        int x = num % 2; 
        String ret = "";
        if (x == 1) {
            ret = " an odd number";
        } 
        if (x == 0) {
            ret = " an even number";
        }
        return ret;
    }
}
