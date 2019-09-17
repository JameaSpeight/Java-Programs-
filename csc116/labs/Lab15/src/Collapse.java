import java.io.*;
import java.util.Scanner;

/**
 * Collapses spaces in file
 * 
 * @author Jessica Young Schmidt
 * @author Jason King
 * @author Jamea Speight
 * @author Jay Vandeveld
 */
public class Collapse {
    /**
     * Starts program
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        userInterface();
    }
    
    /**
     * User interface
     */
    public static void userInterface() {
        Scanner console = new Scanner(System.in);
        Scanner in = getInputScanner(console);
        PrintStream out = getOutputPrintStream(console);
        
        collapseSpaces(in, out);
        
        in.close(); // Close the Scanner
        out.close(); // Close the PrintStream
        console.close(); // Close the console scanner
    }

    public static void collapseSpaces(Scanner in, PrintStream out) {
        while (in.hasNextLine()) {
            String line = in.nextLine();
            Scanner lineScan = new Scanner(line);
            if (lineScan.hasNext()) {
                String newLine = lineScan.next();
                while (lineScan.hasNext()) {
                    newLine += " " + lineScan.next(); 
                
                }
                out.println(newLine);
            } else {
                out.println("");
            }
        }
    }

    /**
     * Returns a Scanner for input from a file.
     * 
     * @param console Scanner for console
     * @return Scanner for input from a file
     */
    public static Scanner getInputScanner(Scanner console) {
        Scanner input = null;
        while (input == null) {
            System.out.print("input file name? ");
            String name = console.nextLine();
            try {
                input = new Scanner(new File(name));
            } catch (FileNotFoundException e) {
                System.out.println("File not found. Please try again.");
            }
        }
        return input;
    }
    
    /**
     * Returns a PrintStream for output to a file. NOTE: If file exists, this
     * code will overwrite the existing file. It is likely that you want to add
     * additional tests.
     * 
     * @param console Scanner for console.
     * @return PrintStream for output to a file
     */
    public static PrintStream getOutputPrintStream(Scanner console) {
        // The boilerplate code is provided here.
        // You will need to edit this boilerplate code to fit the
        //    requirements for the lab.
        PrintStream outputFile = null;
        while (outputFile == null) {
            System.out.print("output file name? ");
            String name = console.nextLine();
            File f = new File(name);
            if (f.exists()) {
                System.out.println("File " + name + " exists!");
            }
            try {
                outputFile = new PrintStream(new File(name));
            } catch (FileNotFoundException e) {
                System.out.println("File unable to be written. Please try again.");
            }
        }
        return outputFile;
    }    
}

