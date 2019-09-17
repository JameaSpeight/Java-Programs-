import org.junit.Test;

import junit.framework.TestCase;
/**
 * Test Program for Client code for Employee class
 * 
 * @author Jamea Speight
 * @author Grace Barnhill
 */
public class EmployeeTest extends TestCase {

    @Test 
    public void testGetFirstName() {
        Employee emp = new Employee();
        emp.setFirstName("Alice");
        assertEquals("getFirstName", "Alice", emp.getFirstName());
        
    }
    
    @Test 
    public void testGetMiddleInitial() {
        Employee emp = new Employee();
        emp.setMiddle('N');
        assertEquals("getMiddleInitial", 'N', emp.getMiddleInitial());
        
    }
    
    @Test 
    public void testGetLastName() {
        Employee emp = new Employee();
        emp.setLastName("Wonderland");
        assertEquals("getLastName", "Wonderland", emp.getLastName());
        
    }
    
    @Test 
    public void testGetNormalOrder() {
        Employee emp = new Employee();
        emp.setFirstName("Bryce");
        emp.setLastName("Hopper");
        emp.setMiddle('C');
        assertEquals("getNormalOrder", "Bryce C. Hopper", emp.getNormalOrder());
        
    }

    @Test 
    public void testGetReverseOrder() {
        Employee emp = new Employee();
        emp.setFirstName("Deon");
        emp.setLastName("Johnson");
        emp.setMiddle('W');
        assertEquals("getReverseOrder", "Johnson, Deon W.", emp.getReverseOrder());
    }

    @Test
    public void testGetUnityID() {
        Employee emp = new Employee();
        emp.setFirstName("Edward");
        emp.setLastName("Cullen");
        emp.setMiddle('P');
        assertEquals("getUnityID", "epcullen", emp.getUnityID());
    }
    
    @Test 
    public void testGetInitials() {
        Employee emp = new Employee();
        emp.setFirstName("Chris");
        emp.setLastName("Bacon");
        emp.setMiddle('P');
        assertEquals("getInitials", "CPB", emp.getInitials());
    }

    @Test 
    public void testLength() {
        Employee emp = new Employee();
        emp.setFirstName("Jordan");
        emp.setLastName("Bailey");
        emp.setMiddle('A');
        assertEquals("length", 13, emp.length());
    }

    @Test 
    public void testToString() {
        Employee emp = new Employee();
        emp.setFirstName("Amanda");
        emp.setLastName("Clore");
        emp.setMiddle('V');
        assertEquals("toString", "Amanda V. Clore", emp.toString());
    }

    @Test 
    public void testEquals() {
        Employee emp = new Employee();
        emp.setFirstName("Dylan");
        emp.setLastName("O'Brien");
        emp.setMiddle('M');
        assertTrue("equals", emp.equals(emp));
    }

    @Test
    public void testExample() {
        Employee emp = new Employee();
        emp.setFirstName("John");
        emp.setLastName("Public");
        emp.setMiddle('Q');
        assertEquals("getNormalOrder", "John Q. Public", emp.getNormalOrder());
        assertEquals("getReverseOrder", "Public, John Q.", emp.getReverseOrder());
        assertEquals("getUnityID", "jqpublic", emp.getUnityID());
        assertEquals("getInitials", "JQP", emp.getInitials());
        assertEquals("length", 11, emp.length());

        Employee emp2 = new Employee();
        emp2.setFirstName("Jason");
        emp2.setLastName("King");
        emp2.setMiddle('T');
        assertFalse("not equals", emp.equals(emp2));
        assertFalse("not equals", emp2.equals(emp));
        assertEquals("toString", "Jason T. King", emp2.toString());
    }

}
