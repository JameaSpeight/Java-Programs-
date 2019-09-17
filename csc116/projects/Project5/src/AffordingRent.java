import java.io.*;
import java.util.*;
/**
 * A program that allows users to examine the number of working hours per week necessary 
 * for minimum wage worker to earn enough income to "affordably" rent two-bedroom unit in
 * various states
 *
 * @author Jamea Speight
 *
 */
public class AffordingRent {
    public static final String TOP_HEADER = String.format(" %21s %13s %15s %15s %n", "Minimum",
                "Monthly Rent", "Yearly Income", "Hours per Week");

    public static final String BOTTOM_HEADER = String.format(" %6s %12s %15s %15s %15s %n", 
                "State",  "Wage", "for 2 BR Apt",  "to Afford Rent", " to Afford Rent");
    public static final String DIVIDER = "  -----       --------  ------------"
                                    + "  --------------  --------------";
    
    /**
     * Starts program
     * 
     * @param states command arguments
     */
    public static void main(String[] args) {
        if (args.length == 0 || args.length > 1) {
            System.out.println("Usage: java -cp bin AffordingRent filename");
            System.exit(1);
        }

        StateData[] states = null;
        if (states == null ) {
            try {
                states = getStateList(args[0]);
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.exit(1);
            }
        }
        Scanner console = new Scanner(System.in);
        String option;
        do{
            System.out.println("Affording Rent for Minimum Wage Workers - " +
                                            "Please enter an option below.\n");
            System.out.println("D - Display all states");
            System.out.println("S - Search by state");
            System.out.println("M - Search by minimum wage range");
            System.out.println("I - Search by income range");
            System.out.println("Q - Quit the program\n");
            System.out.print("Option: ");
            option = console.next();
            if (option.equalsIgnoreCase("D")) {
                System.out.println(TOP_HEADER + BOTTOM_HEADER + DIVIDER);
                System.out.println(getAllStates(states));
            } else if (option.equalsIgnoreCase("S")) {
                System.out.print("State name (starts with/is): ");
                console.nextLine();
                String name = console.nextLine();
                System.out.println();
                System.out.println(TOP_HEADER + BOTTOM_HEADER + DIVIDER);
                System.out.println(searchByState(name,states));
            } else if (option.equalsIgnoreCase("M")) {
                double min = 0;
                double max = 0;
                System.out.print("Minimum value: ");
                if (console.hasNextDouble()) { 
                    min = console.nextDouble();
                    System.out.print("Maximum value: ");
                        if (console.hasNextDouble()) { 
                            max = console.nextDouble();
                            if (max >= min) {
                                System.out.println();
                                System.out.println(TOP_HEADER + BOTTOM_HEADER + DIVIDER);
                                System.out.println(searchByMinimumWageRange(min, max, states));
                            } else {
                                System.out.println("Invalid value\n");
                            }
                        } else {
                            console.next();
                            System.out.println("Invalid value\n");
                        }
                } else {
                    console.next();
                    System.out.println("Invalid value\n");
                }
            } else if (option.equalsIgnoreCase("I")) {
                int minIncome = 0;
                int maxIncome = 0;
                System.out.print("Minimum value: "); 
                if (console.hasNextInt()) { 
                    minIncome = console.nextInt();
                    System.out.print("Maximum value: "); 
                    if (console.hasNextInt()) { 
                        maxIncome = console.nextInt();
                        if (maxIncome >= minIncome) {
                            System.out.println();
                            System.out.println(TOP_HEADER + BOTTOM_HEADER + DIVIDER);
                            System.out.println(searchByIncomeRange(minIncome, maxIncome, states));
                        } else {
                            System.out.println("Invalid value\n");
                        }
                    } else {
                        console.next();
                        System.out.println("Invalid value\n");
                    }
                } else {
                    console.next();
                    System.out.println("Invalid value\n");
                }           
            } else if (!option.equalsIgnoreCase("Q")) {
                System.out.println("Invalid Option\n");
            }
        } while (!option.equalsIgnoreCase("Q")); 
        
        System.out.println("\nGoodbye!");
        console.close();
    }
    /**
     *
     * Create a scanner for read the file and create an array or the StateData 
     *
     * @param filename the filename of the state data file
     * 
     *
     * @return stateData of all states
     */
    public static StateData[] getStateList(String filename) {
        Scanner in = null;
        File file = new File (filename);
        if (in == null ) { 
            try {
                in = new Scanner(file);
            } catch (FileNotFoundException e) {
                throw new IllegalArgumentException("Unable to access input file: " + filename);
            }
        }
        int lineCount = 0;
        while (in.hasNextLine()) {
            String statesCount = in.nextLine();
            lineCount ++;  
        } 
        StateData[] states = new StateData[lineCount];
        
        Scanner console = null;
        if (console == null ) { 
            try {
                console = new Scanner(file);
            } catch (FileNotFoundException e) {
                throw new IllegalArgumentException("Unable to access input file: " + filename);
            }
        }
        int i = 0;
        while (console.hasNextLine()) {
            String line = console.nextLine();
            Scanner scan = new Scanner(line);
            scan.useDelimiter(","); 
            
            
                while(scan.hasNext()) {
                    String state =  scan.next();
                    double minWage = scan.nextDouble();
                    int yearIncome = scan.nextInt();

                    StateData s = new StateData(state, minWage, yearIncome);
                    s.getName(); 
                    s.getMinimumWage(); 
                    s.getMonthlyRent();
                    s.getIncome();
                    s.getWorkingHoursPerWeek(); 
                    
                    states[i] = s;
                    i++;
                
            }
            
        }
        return states;
    }
    /**
     *
     * Display all the State data to the user.
     *
     * @param states the array of states data 
     * 
     *
     * @return string on the state data
     */
    public static String getAllStates(StateData[] states) {
        String allStates = "";
        for (int i = 0; i < states.length; i++) {
            allStates += states[i].toString() + "\n";
            
        }
        return allStates;
    }
    /**
     *
     * Search and select the states the user wants to see by name
     *
     * @param states the array of states data 
     * @param name of the state
     *
     * @return string on the state data
     */
    public static String searchByState(String name, StateData[] states) {
        String statesByName = "";
        name = name.toLowerCase();
        for (int i = 0; i < states.length; i++) {
             if(states[i].getName().toLowerCase().startsWith(name)) {
                    statesByName += states[i].toString() + "\n";
            }
            
        }
        return statesByName;
    }
    /**
     *
     * Search and select the states the user wants to see byr minimum wage range given 
     *
     * @param states the array of states data 
     * @param min the minimum of the wage range
     * @param max the maximum of the wage range
     * @return string on the state data
     */
    public static String searchByMinimumWageRange(double min, double max, StateData[] states) {
        String statesByMinWage = "";
        if (max < 0 || min < 0 || max < min) {
            throw new IllegalArgumentException ("Invalid min/max value");
        }
        for(int i = 0; i < states.length; i++) {
            if(states[i].getMinimumWage()  >= min && states[i].getMinimumWage() <= max) {
                statesByMinWage += states[i].toString() + "\n";
            }
        }
        return statesByMinWage;
    }
    /**
     *
     * Search and select the states the user wants to see by income range  
     *
     * @param states the array of states data 
     * @param min the minimum of the income range 
     * @param max the maximum of the income range 
     * @return string on the state data
     */
    public static String searchByIncomeRange(int min, int max, StateData[] states) {
        String statesByIncome = ""; 
        if (max < 0 || min < 0 || max < min) {
            throw new IllegalArgumentException ("Invalid min/max value");
        }
        for(int i = 0; i < states.length; i++) {
            if(states[i].getIncome() >= min && states[i].getIncome() <= max) {
                statesByIncome += states[i].toString() + "\n";
            }
        }
        return statesByIncome;
    }
}