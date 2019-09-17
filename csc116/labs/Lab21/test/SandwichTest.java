import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
/**
 * This is a test case for the program Sandwich.
 * 
 * @author Grace Barnhill
 * @author Jamea Speight
 */
public class SandwichTest extends TestCase {
    private Sandwich sandwich;
    private Sandwich sandwichH;
    private Bread rye;
    private Bread wheat;
    private SandwichFilling turkey;
    private SandwichFilling ham;

    @Before
    public void setUp() {
        rye = new Bread("Rye", 65);
        turkey = new SandwichFilling("Turkey", 54);
        sandwich = new Sandwich("Turkey Sandwich", rye, turkey);
        wheat = new Bread("Wheat", 69);
        ham = new SandwichFilling("Ham", 60);
        sandwichH = new Sandwich("Ham Sandwich", wheat, ham);
    }

    @Test
    public void testTotalCalories() {
        assertEquals("Total Calories", 184, sandwich.getCalories());
    }

    @Test
    public void testTotalCalories2() {
        assertEquals("Total Calories", 198, sandwichH.getCalories());
    }

    @Test
    public void testEquals() {
        assertTrue(sandwich.equals(sandwich));
        assertTrue(sandwich.equals(new Sandwich("Turkey Sandwich",rye,turkey)));
        assertTrue(sandwich
                .equals(new Sandwich("Turkey Sandwich", new Bread("Rye", 65), new SandwichFilling("Turkey", 54))));
        assertFalse(sandwich
                .equals(new Sandwich("Turkey Sandwich", new Bread("Rye", 65), new SandwichFilling("turkey", 54))));
        assertFalse(sandwich
                .equals(new Sandwich("Turkey Sandwich", new Bread("Rye", 61), new SandwichFilling("Turkey", 54))));
        assertFalse(sandwich.equals(null));
        assertFalse(sandwich.equals("Hello"));
    }

   @Test
    public void testEquals2() {
        assertTrue(sandwichH.equals(sandwichH));
        assertTrue(sandwichH.equals(new Sandwich("Ham Sandwich",wheat,ham)));
        assertTrue(sandwichH
                .equals(new Sandwich("Ham Sandwich", new Bread("Wheat", 69), new SandwichFilling("Ham", 60))));
        assertFalse(sandwichH
                .equals(new Sandwich("Ham Sandwich", new Bread("Wheat", 69), new SandwichFilling("ham", 60))));
        assertFalse(sandwichH
                .equals(new Sandwich("Ham Sandwich", new Bread("Wheat", 65), new SandwichFilling("Ham", 60))));
        assertFalse(sandwichH.equals(null));
        assertFalse(sandwichH.equals("chicken"));
    }


    @Test
    public void testToString() {
        assertEquals("Total Calories (184): Turkey (54 calories per serving) on"
                + " Rye (65 calories per slice)", sandwich.toString());
    }

    @Test
    public void testToString2() {
        assertEquals("Total Calories (198): Ham (60 calories per serving) on"
                + " Wheat (69 calories per slice)", sandwichH.toString());
    }

}