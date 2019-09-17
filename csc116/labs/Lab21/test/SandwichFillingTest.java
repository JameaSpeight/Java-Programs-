import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

/**
  * Test program for Sandwich class
  *
  * @author Grace Barnhill
  * @author Jamea Speight
  */
public class SandwichFillingTest extends TestCase {
    /** Create private SandwichFilling for turkey */
    private SandwichFilling turkey;
    /** Create private SandwichFilling for ham */
    private SandwichFilling ham;

    /**
      * Declaring the values of turkey and ham 
      */
    @Before
    public void setUp() {
        turkey = new SandwichFilling("Turkey", 54);
        ham = new SandwichFilling("Ham", 60);
    }
    
    @Test
    public void testGetters() {
        assertEquals("Turkey type", "Turkey", turkey.getType());
        assertEquals("Turkey calories", 54, turkey.getCalories());
    }

    @Test
    public void testGetters2() {
        assertEquals("Ham type", "Ham", ham.getType());
        assertEquals("Ham calories", 60, ham.getCalories());
    }

    @Test
    public void testEquals() {
        assertTrue(turkey.equals(turkey));
        assertTrue(turkey.equals(new SandwichFilling("Turkey", 54)));
        assertFalse(turkey.equals(new SandwichFilling("Turkey", 60)));
        assertFalse(turkey.equals(new SandwichFilling("turkey", 54)));
        assertFalse(turkey.equals(null));
        assertFalse(turkey.equals("Hello"));
    }

    @Test
    public void testEquals2() {
        assertTrue(ham.equals(ham));
        assertTrue(ham.equals(new SandwichFilling("Ham", 60)));
        assertFalse(ham.equals(new SandwichFilling("Ham", 59)));
        assertFalse(ham.equals(new SandwichFilling("ham", 60)));
        assertFalse(ham.equals(null));
        assertFalse(ham.equals("Not Ham"));
    }

    @Test
    public void testToString() {
        assertEquals("Turkey (54 calories per serving)", turkey.toString());
    }

    @Test
    public void testToString2() {
        assertEquals("Ham (60 calories per serving)", ham.toString());
    }

}

