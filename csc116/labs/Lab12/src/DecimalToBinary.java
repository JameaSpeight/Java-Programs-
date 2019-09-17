import java.util.Scanner;

/**
 * A program that converts decimal numbers to their binary equivalent until the
 * user types -1 to quit
 * 
 * @author Dr. Sarah Heckman (sarah_heckman@ncsu.edu)
 * @author Dr. Jessica Young Schmidt
 * @author Dr. Jason King
 * @author Jamea Speight
 * @author Jay Vandeveld
 */
public class DecimalToBinary {

    /**
     * Starts the program
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        userInterface();
    }

    /**
     * Interface with the user that reads in numbers and prints out their binary
     * equivalent
     */
    public static void userInterface() {
        System.out.println("This program converts nonnegative decimal (base-10) numbers "
                + "(integers) \nto their binary (base-2) equivalent until the user types" 
                + " -1 to quit\n");
        Scanner console = new Scanner(System.in);
        int number = 0; // initialize number variable
        do { 
            System.out.print("\nEnter a number (-1 to quit):");
            if (console.hasNextInt()){  //check to see if inputed value is an integer
                number = console.nextInt(); //set number variable to input
                if (number < -1){
                    System.out.print("Need a nonnegative number or -1 to quit");
                } else {
                    if(number >= 0){
                        System.out.print("Decimal (base-10): " + number + 
                                        ", Binary (base-2): " + convertToBinary(number));
                    }
                }
            } else {
                System.out.print("Not an integer. Try again.");   
                console.next();
            }            
        } while (number != -1);
        System.out.println("Exiting DecimalToBinary. Thank you!!");
    
    }

    /**
     * Converts a decimal number to binary
     * 
     * PRECONDITION: the decimal (base-10) value must be nonnegative     
     *
     * @param decimal number to convert
     * @return binary string of number
     * @throws IllegalArgumentException if decimal < 0
     */
    public static String convertToBinary(int decimal) {
        if (decimal < 0) {
            throw new IllegalArgumentException("Negative value: " + decimal);
        } else {
            String binaryNumber = "";
            do{
                int binary = decimal % 2;
                decimal = decimal / 2;
                binaryNumber = binary + binaryNumber;
            } while (decimal != 0);
            return binaryNumber;
        }    
    }
}
