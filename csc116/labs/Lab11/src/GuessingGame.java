import java.util.Random;
import java.util.Scanner;

/**
 * @author Dr. Schmidt
 * @author Dr. King
 * @author Grace Barnhill
 * @author Jamea Speight
 */
public class GuessingGame {

    /** Maximum number for guessing game */
    public static final int MAX = 50;
    
    /**
     * Starts the GuessingGame program
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        userInterface();
    }
    
    /** 
      * Begins the game by getting the random number, 
      * printing the instructions, and calling the game
      */
    public static void userInterface() {
        int secretNumber = getRandomNumber(MAX);

        // Print game instructions
        printInstructions();
        
        // Play the game
        playGame(secretNumber);
    }
    
    /** Prints instructions of game */
    public static void printInstructions() {
        // Printing game instructions
        System.out.println("I picked a secret number between 1 and " + MAX + " (inclusive).");
        System.out.println("Guess my number!");
    }
    
    /**
      * Plays the game and continues to get guesses
      * from user until the user guesses the secret 
      * number
      *
      * @param secret - secret number
      */
    public static void playGame(int secret) {
        // Initializes scanner
        Scanner in = new Scanner(System.in);
        // Saves guess from player
        int guess = getGuessFromPlayer(in);
        // Initializes message to player
        String message = " ";
        
        // While the guess is not correct
        while (guess != secret) {
            // If the guess is larger than the secret number
            if (guess > secret) {
                message = (guess + " is larger than the secret number.");
            // If the guess is smaller than the secret number
            } else if (guess < secret) {
                message = (guess + " is smaller than the secret number.");
            // If the guess is out of range (larger than maximum or smaller than 1)
            } else if ((guess > MAX) || (guess < 1)) {
                message = "Out of range. Try again.";
            }
            // Printing message
            System.out.println(message);
            // Getting another guess
            guess = getGuessFromPlayer(in);
        }
        // Printing message when guess is correct
        System.out.println(guess + " is the secret number!!!");
    }
    
    /**
     * Returns a random number between 1 and maximum (inclusive)
     * 
     * @param maximum - the largest number that should be generated
     * @return random int between 1 and maximum
     */
    public static int getRandomNumber(int maximum) {
        // Generating a random number
        Random r = new Random();
        // Saving random number
        int randomNum = r.nextInt(maximum);
        // Returning random number
        return randomNum;
    }

    /**
     * Prompts player for a number until an integer is entered
     * 
     * @param console used for reading from player
     * @return the player's integer guess
     */
    public static int getGuessFromPlayer(Scanner console) {
        // Asking user for guess
        System.out.print("Your guess? ");
        // While the input is not an integer
        while (!console.hasNextInt()) {
            // Clearing input
            console.next();
            // Printing message to ask for another integer
            System.out.println("Not an integer. Try again.");
            System.out.print("Your guess? ");
        }
        // Saving the guess
        int guess = console.nextInt();
        // Returning the guess
        return guess;
        
    }

}
