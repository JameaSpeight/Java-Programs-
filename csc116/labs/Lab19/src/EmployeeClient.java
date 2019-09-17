import java.util.Scanner;

/**
 * Client code for Employee class
 * 
 * @author Jessica Young Schmidt
 * @author Jamea Speight
 */
public class EmployeeClient {

    /** Number of employee names to read in from the console */
    private static final int NUM_EMPLOYEES = 5;

    /**
     * Starts program
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Employee[] employees = getEmployees(console);
        for (Employee e : employees) {
            System.out.println(e);
        }
    }

    /**
     * Sets up Array of Employees
     * 
     * @param console Scanner for console
     * @return Array of Employees input from console
     */
    public static Employee[] getEmployees(Scanner console) {
        Employee[] employees = new Employee[NUM_EMPLOYEES];
        for (int i = 0; i < employees.length; i++) {
            String firstName = console.next();
            String middleName = console.next();
            char middleIntial = char(0);
            String lastName = console.next(); 
            
            Employee e = new Employee();
            e.setFirstName(firstName);
            e.setMiddleInitial(middleInitial);
            e.setLastName(lastName);

            employees[i] = e;

        }
        return employees;
    }

}
