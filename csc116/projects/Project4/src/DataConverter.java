import java.io.*;
import java.util.Scanner;
/**
 * A program that allows customers to place their orders at the SwagStore and outputs 
 * the price. 
 *
 * @author Jamea Speight
 *
 */
public class DataConverter {
    /**
     * Changing file ending 
     */
    public static final int CHANGE_ENDING = 3;
    /**
     * Weight conversion values
     */
    public static final double WEIGHT_CONVERSION = .454;
    /**
     * Height conversion values
     */
    public static final double HEIGHT_CONVERSION = 2.54;
    /**
     * Temperature conversion decimal
     */
    public static final double TEMP_CONVERSION = 1.8;
    /**
     * Temperature conversion INT
     */
    public static final int TEMP_CONVERSION_INT = 32;
    /**
     * end of month substring
     */
    public static final int MONTH_ENDING = 5;
    /**
     * Beginning of year substring
     */
    public static final int YEAR_BEGINNING = 6;
     /**
     * ENDING of year substring
     */
    public static final int YEAR_ENDING = 10;
    /**
     * Beginning of DAY substring
     */
    public static final int DAY_BEGINNING = 3;
    /**
     * Starts program
     * 
     * @param args command arguments
     */
    public static void main(String[] args) {
        System.out.println("           This is the Data Converter Program.");
        System.out.println(" When prompted please, provide an input file. The input file"
            + " must have an extension of .us indicating US format or .ot indicating the" 
            + " other country’s format. If the output file already exists, you will be "
            + " asked if it is OK to overwrite the file.");
        Scanner console = new Scanner(System.in);
        String filename;
        do{
            System.out.print("Enter filename or Q to quit: ");
            filename = console.next();
            Scanner fileScanner = getInputScanner(filename);
            if (fileScanner != null) {
                PrintStream outputFile = getOutputPrintStream(console, filename);
                if (outputFile != null) {
                    boolean convertToOtherFormat = false;
                    if (filename.endsWith(".ot")) {
                        convertToOtherFormat = false;
                        processFile(convertToOtherFormat, fileScanner, outputFile); 
                    } else {
                        convertToOtherFormat = true;
                        processFile(convertToOtherFormat, fileScanner, outputFile); 
                    } 
                }
                fileScanner.close();
            } 
        } while (!filename.equalsIgnoreCase("q")); 
        
        console.close();
    }
    /**
     * Gets the input scanner
     * 
     * @param filename for input file 
     * @return the scanner for input file
     *
     */
    public static Scanner getInputScanner(String filename){
        Scanner fileScanner = null; 
        if (fileScanner == null) {
            try {
                fileScanner = new Scanner(new File(filename ));
                return fileScanner;
            } catch (FileNotFoundException e) {
                if (filename.equalsIgnoreCase("q")) {
                    return null; 
                } else if (filename.endsWith(".us") || filename.endsWith(".ot")) {
                    System.out.println(e.getMessage());
                    return null;
                } else {
                    System.out.println("Invalid filename");
                    return null;
                }
            }
        }
        return null;
        
        
    }
    /**
     * Checks to see if the file exist and if it is okay to overwrite the file
     * 
     * @param console scanner for file 
     * @param filename for the input file
     * @return PrintStream for an output file
     * 
     *
     */
    public static PrintStream getOutputPrintStream(Scanner console, String filename){
        PrintStream outputFile = null;
        String outputFileName = "";
        if (outputFile == null) {
            if (filename.endsWith(".ot")) {
                outputFileName = filename.substring(0, filename.length() - CHANGE_ENDING) + ".us";
            } else if (filename.endsWith(".us")) {
                outputFileName = filename.substring(0, filename.length() - CHANGE_ENDING) + ".ot";
            } 
            File file = new File(outputFileName);
            String answer = "";
            try {
                if (file.exists()) {
                    System.out.print(outputFileName + " exists - OK to overwrite (y,n)?: ");
                    answer = console.next();
                    answer = answer.toLowerCase(); 
                    if (!answer.startsWith("y")) {
                        return null;
                    }
                }       
                outputFile = new PrintStream(new File(outputFileName ));
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
        return outputFile;
    }
    /**
     * Converts the data in the input file based off if convertToOtherFormat is true.
     * 
     * @param convertToOtherFormat if the file is other or us
     * @param input scanner for the input file
     * @param output PrintStream to make the output file 
     * 
     *
     */
    public static void processFile (boolean convertToOtherFormat, Scanner input,
                                     PrintStream output){
        String convertedLine = "";
        if (convertToOtherFormat == true ) {
            while (input.hasNextLine()) {
                String line = input.nextLine();
                convertedLine += convertLineToOtherFormat(line) + "\n";
            }
            output.print(convertedLine);
        } else {
            while (input.hasNextLine()) {
                String line = input.nextLine();
                convertedLine += convertLineToUSFormat(line) + "\n";
            }
            output.print(convertedLine);
        }
        
    }
    /**
     * Converts the line to the correct format
     * 
     * @param line from the input file
     * @return string containing line of data in other country's format
     *
     */
    public static String convertLineToOtherFormat(String line){
        Scanner lineScan = new Scanner(line);
        while (lineScan.hasNext()) {
            String lastName = lineScan.next();
            String firstName = lineScan.next();
            String dateFormat = lineScan.next();
            double heightInches = lineScan.nextDouble();
            double weightPounds = lineScan.nextDouble();
            double temperatureF = lineScan.nextDouble();
            
            String name = firstName + " " +  lastName.substring(0, lastName.length() - 1);
            String month = dateFormat.substring(0,2);
            String day = dateFormat.substring(DAY_BEGINNING,MONTH_ENDING);
            String year = dateFormat.substring(YEAR_BEGINNING,YEAR_ENDING);
            String date = day + "." + month + "." + year; 
            double height = heightInches * HEIGHT_CONVERSION;
            double weight = weightPounds * WEIGHT_CONVERSION;
            double temp = (temperatureF - TEMP_CONVERSION_INT) / TEMP_CONVERSION;
            String s = String.format("%-20s%s%8.2f%8.2f%8.2f", name, date, height, weight, temp);
            lineScan.close();
            return s;
        }
        lineScan.close();
        return "";
    }
    /**
     * Converts string containing line of data in US format
     * 
     * @param line from the input file 
     * @return string containing line of data in US format
     *
     */ 
    public static String convertLineToUSFormat(String line){
        Scanner lineScan = new Scanner(line);
        while (lineScan.hasNext()) {
            String firstName = lineScan.next();
            String lastName = lineScan.next();
            String dateFormat = lineScan.next();
            double heightCent = lineScan.nextDouble();
            double weightKg = lineScan.nextDouble();
            double temperatureC = lineScan.nextDouble();
            
            String name = lastName + ", " + firstName;
            String day = dateFormat.substring(0,2);
            String month = dateFormat.substring(DAY_BEGINNING,MONTH_ENDING);
            String year = dateFormat.substring(YEAR_BEGINNING,YEAR_ENDING);
            String date = month + "/" + day + "/" + year; 
            double height = heightCent / HEIGHT_CONVERSION;
            double weight = weightKg / WEIGHT_CONVERSION ;
            double temp = temperatureC * TEMP_CONVERSION + TEMP_CONVERSION_INT;
            String s = String.format("%-20s%s%8.0f%8.0f%8.2f", name, date, height, weight, temp);
            return s;
        } 
        lineScan.close();
        return "";
    }
}
