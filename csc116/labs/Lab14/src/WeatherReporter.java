import java.util.*;
import java.io.*;

/**
 * Program to get input from weather text file and process
 * 
 * @author Suzanne Balik
 * @author Jessica Young Schmidt
 * @author Jamea Speight
 * @author Jay Vandeveld
 */
public class WeatherReporter {

    /**
     * Starts program
     * 
     * @param args command arguments
     */
    public static void main(String[] args) {
        userInterface();
    }

    /**
     * Deals with all interactions with the user
     */
    public static void userInterface() {
        Scanner console = new Scanner(System.in);
        
        //confirm input is valid
        Scanner input = null;
        do{
            input = getInput(console);
        } while (input == null);   
        
        //create output to user for each line
        while (input.hasNextLine()) {
            String line = input.nextLine();
            System.out.print(processLine(line));
        }

       
    }

    /**
     * Processes a line of the text file (String) in order to print the correct
     * output to the console
     * 
     * @param line the line to be processed
     * @return processed line
     */
    public static String processLine(String line) {
        Scanner lineScan = new Scanner(line);
        
        //make sure parameter line is a line with weather info
        if(lineScan.hasNextInt()){
            
            //initialize variables
            String date  = lineScan.next();
            double average = lineScan.nextDouble();
            double high = lineScan.nextDouble();
            double low = lineScan.nextDouble();
            String sky = lineScan.next();
            
            //isolate dates 
            String year = date.substring(0, 4); 
            String month = date.substring(4, 6);
            String day = date.substring(6);
            
            //see if the day has either rain or snow
            boolean rain = (sky.charAt(1) == '1'); 
            boolean snow = (sky.charAt(2) == '1');
            String rain1 = "no";
            String snow1 = "no";
            if(rain == true) {
                rain1 = "yes";
            }
            if(snow == true) {
                snow1 = "yes";
            }      
            return String.format("%2s/%2s/%4s Low:%6.1f High:%6.1f Rain:%4s Snow:%4s",
                    month, day, year, low, high, rain1, snow1);
        } else {
            return "";
        }
    }
    /**
     * Prompt the user for a legal file name, create and return a Scanner tied to
     * the file
     * 
     * @param console console for user input
     * @return Scanner tied to the input file
     */
    public static Scanner getInput(Scanner console) {
        File file = null;
        Scanner fileScanner = null;
        try {
            System.out.print("Input file name? ");
            file = new File("../test-files/" + console.next());
            fileScanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Please try again.");
            return null;
        }

        return fileScanner;
    }

}

