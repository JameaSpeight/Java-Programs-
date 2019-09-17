import java.util.Scanner;

/**
 * Read in full name from user then reverses name
 * 
 * @author Jessica Young Schmidt
 * @author Jason King
 * @author Ryan Hurlbut
 * @author Jamea Speight
 */
import java.util.Scanner;

public class AlterStrings {
	/**
	 * The main method starts program execution
	 *
	 * @param args command line arguments
	 */
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in); 
        System.out.print("Please enter your full name (first last): ");
        String name = console.nextLine();
        int space = name.indexOf(" ");
        String firstname = name.substring(0, space);
        String lastname = name.substring(space + 1,name.length()); 
        System.out.println("Your name in reverse order is " + lastname + "," + firstname);
    }
}

