/**
 * Encapsulates the minimum wage rate and the gross income necessary to affordably rent 
 * a two-bedroom unit in a state, i.e., rent including utilities = 30% of gross income, as
 * well as the monthly rent and number of minimum wage working hours per week needed to 
 * to earn 30% of the gross income
 * @author Suzanne Balik
 */
public class StateData {

    /** Tolerance used to compare mininum wages **/
    public static final double TOLERANCE = .001;

    /** Percent of income that is used for rent */
    public static final double PERCENT_INCOME_FOR_RENT = .30;

    /** Number of working weeks per year */
    public static final int WEEKS_PER_YEAR = 52;

    /** Number of months per year */
    public static final int MONTHS_PER_YEAR = 12;
    
    /** Name of state*/
    private String name;
    
    /** Hourly minimum wage   */ 
    private double minimumWage;
  
    /** Yearly gross income necesary to affordably rent a two-bedroom unit */
    private int income;

    /** Monthly rent */   
    private double monthlyRent;

    /** Minimum wage working hours per week */
    private double workingHoursPerWeek;
      
    /**
     * Constructs and initializes a StateData object.
     * @param name name of state
     * @param minimumWage hourly minimum wage rate
     * @param income yearly gross income necessary to affordably rent a two-bedroom unit
     * @throws IllegalArgumentException if name is null
     * @throws IllegalArgumentException if minimumWage or income are nonpositive
     */
    public StateData (String name, double minimumWage, int income) {
        if (name == null) {
            throw new IllegalArgumentException("name is null");
        }
        if (minimumWage <= 0 || income <= 0) {
            throw new IllegalArgumentException("minimumWage or income is nonpositive");
        }
        this.name = name;
        this.minimumWage = minimumWage;
        this.income = income;
        monthlyRent = PERCENT_INCOME_FOR_RENT * income / MONTHS_PER_YEAR;
        workingHoursPerWeek = (double) income / WEEKS_PER_YEAR / minimumWage;
    }
    
    /**
     * Returns the name
     * @return the name
     */
    public String getName() {
        return name;
    } 
   
    /**
     * Returns the minimum wage
     * @return minimum wage
     */
    public double getMinimumWage() {
        return minimumWage;
    }
    
    /**
     * Returns the income
     * @return income
     */
    public int getIncome() {
        return income;
    }

        /**
     * Returns the monthly rent
     * @return monthlyRent
     */
    public double getMonthlyRent() {
        return monthlyRent;
    }

    /**
     * Returns the number of working hours per week
     * @return hoursPerWeek
     */
    public double getWorkingHoursPerWeek() {
        return workingHoursPerWeek;
    }
    

    /**
     * Determines if the given StateData object has the same 
     * state as this StateData object
     *
     * @param object StateData object to compare 
     * @return true   if given StateData object equals this StateData object
     *         false  otherwise
     */
    public boolean equals(Object object) {
        if (object instanceof StateData) {
            StateData other = (StateData) object;
            return (name.equals(other.name) && 
                    Math.abs(minimumWage - other.minimumWage) < TOLERANCE  &&
                    income == other.income &&
                    Math.abs(monthlyRent - other.monthlyRent) < TOLERANCE  &&
                    Math.abs(workingHoursPerWeek - other.workingHoursPerWeek) < TOLERANCE);
        } else {
            return false;
        }
    }


    /**
     * Returns a String representation of the StateData object
     * @return String containing state, minimum wage, monthly rent, income, 
     * and working hours per week
     */
    public String toString() {
        return String.format("%-15s%5.2f%13.2f%15d%16.2f", name, minimumWage, monthlyRent, income, 
                             workingHoursPerWeek);
    }
               
}
