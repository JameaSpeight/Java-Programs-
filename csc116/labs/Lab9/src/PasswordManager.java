import java.util.Scanner;

/**
 * Examines whether the user entered password is validate (contains at least two
 * uppercase letters, at least two lowercase letters, and at least two digits)
 * 
 * @author Jessica Young Schmidt
 * @author Jason King
 * @author Jamea Speight
 * @author Taylor Earnhardt
 */
public class PasswordManager {
    /**
     * The method that is executed when the program is run
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        printIntroduction();
        System.out.print("Enter your password: ");
        String password = in.nextLine(); // Just in case there is whitespace
        System.out.println(validatePassword(password));                           
    }
    
    /**
     * Prints a description of the minimum password requirements.
     */
    public static void printIntroduction() {
        System.out.println("Passwords must contain");
        System.out.println("  no spaces,");
        System.out.println("  at least two uppercase letters,");
        System.out.println("  at least two lowercase letters, and");
        System.out.println("  at least two digits. ");
    }
    
    /**
     * Counts the number of uppercase, lowercase, and digits
     * contained in the password.
     *
     * @param password - the password to check
     * @return a message indicating whether the password is valid or not
     */
    public static String validatePassword(String password) {
        //method constant 6 for the max length of the password
        final int MAX = 6;
        int countUpper = 0;
        int countLower = 0;
        int countDigits = 0;
        int countSpaces = 0;
        if (password.length() < MAX) {
            throw new IllegalArgumentException("Password must be at least 6 characters long");
        }
        for(int i = 0; i <= (password.length() - 1); i++) {
            if (Character.isLetter(password.charAt(i))) {
                if(Character.isUpperCase(password.charAt(i))) {
                    countUpper++; 
                }
                else {countLower++; }
            }
            else if (Character.isDigit(password.charAt(i))) {
                countDigits++;
            }
            else if (password.charAt(i) == ' ') { 
                countSpaces++;
            }
                
        }            
        return createMessage(countUpper, countLower, countDigits, countSpaces);
    }
    
    /**
     * Constructs a message (based on the number of uppercase,
     * lowercase, and digits in the password) to inform the 
     * user which password requirements were invalid.
     *
     * @param countUpper - the number of uppercase letters in the password
     * @param countLower - the number of lowercase letters in the password
     * @param countDigits - the number of digits in the password
     * @param countSpaces - the number of space in the password
     * @return a message indicating whether the password is valid or not
     */
    public static String createMessage(int countUpper, int countLower, int countDigits, 
                                       int countSpaces) {
        // Checks to see whether requirement were met
        String message = "";
        if (countUpper >= 2 && countLower >= 2 && countDigits >= 2 && countSpaces == 0){
            message += "Your password is vaild.";
        }
        else {
            message += "Your password is invaild because:";
            if (countSpaces > 0){
                message += "\n - your password contains spaces";
            }
            if(countUpper < 2){
                message += "\n - fewer than two uppercase letters";
            }
            if (countLower < 2) { 
                message += "\n - fewer than two lowercase letters";
            }
            if (countDigits < 2) {
                message += "\n - fewer than two digits";
            }
        }
        return message;
    }
}
