import java.util.Scanner;

/**
 * Triangle program outputs the type of a triangle based on the lengths of its
 * sides.
 * 
 * @author Matt Spivey
 * @author <Student 2's Name>
 */
public class Triangle {

    /**
     * The method that is executed when the program is run
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        userInterface();
    }

    /**
     * Provides the user interface for
     * interacting with the user.
     */
    public static void userInterface() {
        System.out.println( );//starts with a space to make it easier to read
        System.out.println("Triangle program provides the type of any triangle."
                + "\nPlease enter the lengths of sides a, b, and c.");
        Scanner console = new Scanner(System.in);
        System.out.print("Enter a: ");
        int a = console.nextInt();
        System.out.print("Enter b: ");
        int b = console.nextInt();
        System.out.print("Enter c: ");
        int c = console.nextInt();  
        if (!isValidTriangle(a, b, c)) {
            System.out.println("Invalid Triangle"); 
        } else if (isValidTriangle(a, b, c)) {
            String type = getTriangleType(a,b,c);
            System.out.println("Triangle: " + type);            
        }      
        System.out.println( );//another readability feature   
    }

    /**
     * Checks to see if a triangle is valid based on the lengths of its sides. The
     * length of each side must be positive and less than the sum of the other two
     * sides.
     * 
     * @param a length of side a
     * @param b length of side b
     * @param c length of side c
     * @return true if the lengths create a valid triangle, false otherwise.
     * (Invalid if: one side’s length is longer than the sum of the other two, which
     * is impossible in a triangle, or a side length is non-positive.)
     * 
     */
    public static boolean isValidTriangle(int a, int b, int c) {
                
        if ((a + b < c) || (a + c < b) || (c + b < a)) {
            return false;//invalid triangle            
        } else if ((a < 0) || (b < 0) || (c < 0)) {
            return false;//invalid triangle
        } else {
            return true;//valid, so move on to triangle type   
        }       
    }

    /**
     * Returns the type of a triangle based on the lengths of its sides. PRE:
     * Assumes the lengths form a valid triangle.
     * 
     * @param a length of side a
     * @param b length of side b
     * @param c length of side c
     * @return "Equilateral", "Isosceles", or "Scalene", or "Not Valid Triangle"
     */
    public static String getTriangleType(int a, int b, int c) {

        if ((a == b) && (b == c)) {
            return "Equilateral";
        } else if ((a != b) && (b != c) && (a != c)) {
            return "Isosceles";
        } else { 
            return "Scalene";

        }
    }
}
