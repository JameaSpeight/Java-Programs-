import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
/**
 * This is a test case for the program Bread.
 * 
 * @author Grace Barnhill
 * @author Jamea Speight
 */
public class BreadTest extends TestCase {

    private Bread rye;
    private Bread wheat;

    @Before
    public void setUp() {
        rye = new Bread("Rye", 65);
        wheat = new Bread("Wheat", 69);
    }

    @Test
    public void testGetters() {
        assertEquals("Rye type", "Rye", rye.getType());
        assertEquals("Rye calories", 65, rye.getCalories());
    }

    @Test
    public void testGetters2() {
        assertEquals("Wheat type", "Wheat", wheat.getType());
        assertEquals("Wheat calories", 69, wheat.getCalories());
    }

    @Test
    public void testEquals() {
        assertTrue(rye.equals(rye));
        assertTrue(rye.equals(new Bread("Rye", 65)));
        assertFalse(rye.equals(new Bread("Rye", 60)));
        assertFalse(rye.equals(new Bread("rye", 65)));
        assertFalse(rye.equals(null));
        assertFalse(rye.equals("Hello"));
    }

    @Test
    public void testEquals2() {
        assertTrue(wheat.equals(wheat));
        assertTrue(wheat.equals(new Bread("Wheat", 69)));
        assertFalse(wheat.equals(new Bread("Wheat", 60)));
        assertFalse(wheat.equals(new Bread("Wheat", 65)));
        assertFalse(wheat.equals(null));
        assertFalse(wheat.equals("Rye"));
    }

    @Test
    public void testToString() {
        assertEquals("Rye (65 calories per slice)", rye.toString());
    }

    @Test
    public void testToString2() {
        assertEquals("Wheat (69 calories per slice)", wheat.toString());
    }
}
