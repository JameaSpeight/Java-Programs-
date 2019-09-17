import java.util.Scanner;

/**
 * Determines if a user entered String is a palindrome, which means the String
 * is the same forward and reverse. The determination is case-insensitive.
 * Spaces and punctuation must match for palindromes.
 * 
 * @author Dr. Sarah Heckman
 * @author Dr. Jessica Young Schmidt
 * @author Jamea Speight
 * @author Taylor Earnhardt
 */
public class Palindrome {

    /**
     * Starts program
     * 
     * @param args array of command line arguments
     */
    public static void main(String[] args) {     
        userInterface();
    }

    /**
     * Reads user's console input and prints the results
     */
    public static void userInterface() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a word or phrase: ");
        String text = in.nextLine();
        
        System.out.print("isPalindrome: \t");
        if (isPalindrome(text)) {
            System.out.println("\"" + text + "\" is a palindrome");
        } else {
            System.out.println("\"" + text + "\" is NOT a palindrome");
        }
    }

    /**
     * Returns true if the text is a palindrome - the same word forward and
     * backwards
     * 
     * @param text String object to test if palindrome
     * @return whether text is a palindrome
     */
    public static boolean isPalindrome(String text) {
        for(int i = 0; i <= (text.length() - 1); i++) { 
            if (Character.toLowerCase(text.charAt(i)) != 
                Character.toLowerCase(text.charAt(text.length() - i - 1))){
                return false;
            }  
        }
        return true; 
    }

}
