import org.junit.Test;
import junit.framework.TestCase;

/**
 * Program to test SwagStore methods
 * @author Suzanne Balik
 * @author Jamea Speight 
 */
public class SwagStoreTest extends TestCase {
 
    
    @Test
    public void testIsValidDate1() {
        
        assertTrue("SwagStore.isValidDate(3, 20)", 
                   SwagStore.isValidDate(3, 20));
        
    }

    @Test
    public void testIsValidDate2() {
        
        assertFalse("SwagStore.isValidDate(12, 24)", 
                    SwagStore.isValidDate(12, 24));
    }

    @Test
    public void testIsValidDate3() {
        
        assertFalse("SwagStore.isValidDate(3, 12)", 
                    SwagStore.isValidDate(3, 12));
    }
    
    @Test
    public void testIsValidDate4() {
        
        assertTrue("SwagStore.isValidDate(4, 10)", 
                    SwagStore.isValidDate(4, 10));
    }
    
    @Test
    public void testIsValidDate5() {
        
        assertTrue("SwagStore.isValidDate(4, 30)", 
                    SwagStore.isValidDate(4, 30));
    }
    
    @Test
    public void testIsValidDate6() {
        
        assertFalse("SwagStore.isValidDate(5, 1)", 
                    SwagStore.isValidDate(5, 1));
    }
    
    @Test
    public void testIsValidDate7() {
        
        assertFalse("SwagStore.isValidDate(4, 31)", 
                    SwagStore.isValidDate(4, 31));
    }

    @Test
    public void testGetCostOfItems1() {
        
        assertEquals("SwagStore.getCostOfItems(2, 1, 2)", 36,
                     SwagStore.getCostOfItems(2, 1, 2));
        
    }

    @Test
    public void testGetCostOfItems2() {
        
        assertEquals("SwagStore.getCostOfItems(0, 0, 0)", 0,
                     SwagStore.getCostOfItems(0, 0, 0));
        
    }

    @Test
    public void testGetCostOfItems3() {
        
        assertEquals("SwagStore.getCostOfItems(1, 1, 1)", 23,
                     SwagStore.getCostOfItems(1, 1, 1));
        
    }
    
    @Test
    public void testGetCostOfItems4() {
        
        assertEquals("SwagStore.getCostOfItems(2, 1, 0)", 12,
                     SwagStore.getCostOfItems(2, 1, 0));
        
    }
    
    @Test
    public void testGetCostOfItems5() {
        
        assertEquals("SwagStore.getCostOfItems(5, 0, 0)", 5,
                     SwagStore.getCostOfItems(5, 0, 0));
        
    }

    @Test
    public void testGetShippingCost1() {
        
        assertEquals("SwagStore.getShippingCost(25, false, false)", 0,
                     SwagStore.getShippingCost(25, false, false));
        
    }

    @Test
    public void testGetShippingCost2() {
        
        assertEquals("SwagStore.getShippingCost(15, false, true)", 0,
                     SwagStore.getShippingCost(15, false, true));
        
    }

    @Test
    public void testGetShippingCost3() {
        
        assertEquals("SwagStore.getShippingCost(0, false, true)", 0,
                     SwagStore.getShippingCost(0, false, true));
        
    }

    @Test
    public void testGetShippingCost4() {
        
        assertEquals("SwagStore.getShippingCost(20, true, false)", 5,
                     SwagStore.getShippingCost(20, true, false));
        
    }
    
    @Test
    public void testGetShippingCost5() {
        
        assertEquals("SwagStore.getShippingCost(10, false, true)", 0,
                     SwagStore.getShippingCost(10, false, true));
        
    }

    @Test
    public void testGetArrivalDate1() {
        
        assertEquals("SwagStore.getArrivalDate(3, 16, 3)", "Tue, 3 19 2019",
                   SwagStore.getArrivalDate(3, 16, 3));
        
    }

    @Test
    public void testGetArrivalDate2() {
        
        assertEquals("SwagStore.getArrivalDate(4, 30, 1)", "Wed, 5 1 2019",
                   SwagStore.getArrivalDate(4, 30, 1));
        
    }

    @Test
    public void testGetArrivalDate3() {
        
        assertEquals("SwagStore.getArrivalDate(3, 31, 3)", "Wed, 4 3 2019",
                   SwagStore.getArrivalDate(3, 31, 3));
         
    }
    
    @Test
    public void testGetArrivalDate4() {
        
        assertEquals("SwagStore.getArrivalDate(3, 15, 1)", "Sat, 3 16 2019",
                   SwagStore.getArrivalDate(3, 15, 1));
         
    }
    
    @Test
    public void testGetArrivalDate5() {
        
        assertEquals("SwagStore.getArrivalDate(3, 19, 3)", "Fri, 3 22 2019",
                   SwagStore.getArrivalDate(3, 19, 3));
         
    }
    
    @Test
    public void testGetArrivalDate6() {
        
        assertEquals("SwagStore.getArrivalDate(3, 31, 1)", "Mon, 4 1 2019",
                   SwagStore.getArrivalDate(3, 31, 1));
         
    }
    
    @Test
    public void testGetArrivalDate7() {
        
        assertEquals("SwagStore.getArrivalDate(4, 30, 3)", "Fri, 5 3 2019",
                   SwagStore.getArrivalDate(4, 30, 3));
         
    }
    
    @Test
    public void testGetArrivalDate8() {
        
        assertEquals("SwagStore.getArrivalDate(3, 20, 3)", "Sat, 3 23 2019",
                   SwagStore.getArrivalDate(3, 20, 3));
         
    }

    
    /**
     * Test the SwagStore methods with invalid values
     */ 
    @Test
    public void testInvalidMethods() {
        // Invalid test cases are provided for you below - You do NOT
        // need to add additional invalid tests. Just make sure these
        // pass!
        try {
            SwagStore.getCostOfItems(-1, 0, 5);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid number of items", e.getMessage());
        }
        try {
            SwagStore.getShippingCost(-5, true, false);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid cost of items", e.getMessage());
        }
        
        try {
            SwagStore.getArrivalDate(12, 4, 1);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid date", e.getMessage());
        }

        try {
            SwagStore.getArrivalDate(4, 12, 5);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid number of shipping days", e.getMessage());
        }   
       
    }
}