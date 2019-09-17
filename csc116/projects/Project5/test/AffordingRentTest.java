import java.util.Arrays;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Program to test AffordingRent methods
 * @author Suzanne Balik
 * @author Jamea Speight
 */
public class AffordingRentTest extends TestCase {

    public static final StateData IDAHO = new StateData("Idaho", 7.25, 29580);
    
    public static final StateData NEW_YORK = new StateData("New York", 9, 55508);
    
    public static final StateData OHIO = new StateData("Ohio", 8.1, 30060);
    
    public static final StateData[] THREE_STATES = { IDAHO, NEW_YORK, OHIO };
    
    public static final StateData MARYLAND = new StateData("Maryland",8.25,55183);
    
    public static final StateData NORTH_CAROLINA = new StateData("North Carolina",7.25,31859);
    
    public static final StateData VIRGINA = new StateData("Virginia",7.25,46675);
    
    public static final StateData FLORIDA = new StateData("Florida",8.05,41527);
    
    public static final StateData GEORGIA = new StateData("Georgia",7.25,33905);
    
    public static final StateData[] MY_STATES = { FLORIDA, GEORGIA, MARYLAND, NEW_YORK,
                        NORTH_CAROLINA, OHIO, VIRGINA};
    
    @Test
    public void testGetStateList1() {
        String filename = "test-files/three_states.csv";
        StateData[] actual = AffordingRent.getStateList(filename);
        assertTrue(filename, Arrays.equals(THREE_STATES, actual));
    }
    
    @Test
    public void testGetStateList2() {
        String filename = "test-files/my_states.csv";
        StateData[] actual = AffordingRent.getStateList(filename);
        assertTrue(filename, Arrays.equals(MY_STATES, actual));
    }


    @Test
    public void testGetAllStates1() {
        String expected = "Idaho           7.25       739.50          29580           78.46\n" +
                          "New York        9.00      1387.70          55508          118.61\n" +
                          "Ohio            8.10       751.50          30060           71.37\n";
        String actual = AffordingRent.getAllStates(THREE_STATES);
        assertEquals("Three states", expected, actual);
    }
    
    @Test
    public void testGetAllStates2() {
        String expected = "Florida         8.05      1038.18          41527           99.20\n" +
                          "Georgia         7.25       847.63          33905           89.93\n" +
                          "Maryland        8.25      1379.57          55183          128.63\n" +
                          "New York        9.00      1387.70          55508          118.61\n" +
                          "North Carolina  7.25       796.47          31859           84.51\n" +
                          "Ohio            8.10       751.50          30060           71.37\n" +
                          "Virginia        7.25      1166.88          46675          123.81\n";
        String actual = AffordingRent.getAllStates(MY_STATES);
        assertEquals("My States", expected, actual);
    }
    


    @Test
    public void testSearchByState1() {
        String expected = "New York        9.00      1387.70          55508          118.61\n";
        String actual = AffordingRent.searchByState("new y", THREE_STATES);
        assertEquals("Three jobs", expected, actual);
    }

    @Test
    public void testSearchByState2() {
        String expected = "New York        9.00      1387.70          55508          118.61\n" +
                          "North Carolina  7.25       796.47          31859           84.51\n";
        String actual = AffordingRent.searchByState("n", MY_STATES);
        assertEquals("My states", expected, actual);
    }
    


    @Test
    public void testSearchByMinimumWageRange1() {
        String expected = "Ohio            8.10       751.50          30060           71.37\n";
        String actual = AffordingRent.searchByMinimumWageRange(7.50, 8.50, THREE_STATES);
        assertEquals("Three states", expected, actual);
    }

    @Test
    public void testSearchByMinimumWageRange2() {
        String expected = "Georgia         7.25       847.63          33905           89.93\n" +
                          "North Carolina  7.25       796.47          31859           84.51\n" +
                          "Virginia        7.25      1166.88          46675          123.81\n";
        String actual = AffordingRent.searchByMinimumWageRange(7.25, 7.25, MY_STATES);
        assertEquals("My states", expected, actual);
    }


    @Test
    public void testSearchByIncomeRange1() {
        String expected = "Idaho           7.25       739.50          29580           78.46\n" +
                          "Ohio            8.10       751.50          30060           71.37\n";
        String actual = AffordingRent.searchByIncomeRange(20000, 40000, THREE_STATES);
        assertEquals("Three states", expected, actual);
    }

    @Test
    public void testSearchByIncomeRange() {
        String expected = "Florida         8.05      1038.18          41527           99.20\n" +
                          "Maryland        8.25      1379.57          55183          128.63\n" +
                          "New York        9.00      1387.70          55508          118.61\n" +
                          "Virginia        7.25      1166.88          46675          123.81\n";
        String actual = AffordingRent.searchByIncomeRange(40000, 60000, MY_STATES);
        assertEquals("My states", expected, actual);
    }

    /**
     * Test the AffordingRent methods with invalid values
     */ 
    @Test
    public void testSearchInvalid() {
        // Invalid test cases are provided for you below - You do NOT
        // need to add additional invalid tests. Just make sure these
        // pass!
        try {
            AffordingRent.searchByMinimumWageRange(10.0, 7.0, THREE_STATES);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid min/max value", e.getMessage());
        }

        try {
            AffordingRent.searchByMinimumWageRange(-3, 10.0, THREE_STATES);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid min/max value", e.getMessage());
        }

        try {
            AffordingRent.searchByMinimumWageRange(4, -5, THREE_STATES);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid min/max value", e.getMessage());
        }
                try {
            AffordingRent.searchByIncomeRange(10000, 7000, THREE_STATES);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid min/max value", e.getMessage());
        }

        try {
            AffordingRent.searchByIncomeRange(-30000, 10000, THREE_STATES);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid min/max value", e.getMessage());
        }

        try {
            AffordingRent.searchByIncomeRange(40000, -50000, THREE_STATES);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid min/max value", e.getMessage());
        }
    }
}
