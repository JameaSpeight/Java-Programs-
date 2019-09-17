import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
/**
  * Testing PackBakery class and its methods
  *
  * @author Grace Barnhill
  * @author Jamea Speight
  */
public class PackBakeryTest extends TestCase {
    /** Creating private PackBakery for bakery */
    private PackBakery bakery;
    /** Creating private PackBakery for bakery2 */
    private PackBakery bakery2;
    /** Creating private Sandwich for turkeySandwich */
    private Sandwich turkeySandwich;
    /** Creating private Sandwich for pbjSandwich */
    private Sandwich pbjSandwich;
    /** Creating private Sandwich for bltSandwich */
    private Sandwich bltSandwich;
    /** Creating private Sandwich for bananaSandwich */
    private Sandwich bananaSandwich;
    /** Creating private Sandwich for hamSandwich */
    private Sandwich hamSandwich;
    /** Creating private Sandwich for clubSandwich */
    private Sandwich clubSandwich;

    /**
      * Setting variables for test cases
      *
      */
    @Before
    public void setUp() {
        Bread rye = new Bread("Rye", 65);
        SandwichFilling turkey = new SandwichFilling("Turkey", 54);
        turkeySandwich = new Sandwich("Turkey Sandwich", rye, turkey);
        
        Bread white = new Bread("White", 50);
        SandwichFilling pbj = new SandwichFilling("Peanut Butter and Jelly", 120);
        pbjSandwich = new Sandwich("PBJ Sandwich", white, pbj);
        
        Bread french = new Bread("French", 75);
        SandwichFilling blt = new SandwichFilling("Bacon, Lettuce, and Tomato", 200);
        bltSandwich = new Sandwich("BLT Sandwich", french, blt);
        
        Bread wheat = new Bread("Wheat", 70);
        SandwichFilling banana = new SandwichFilling("Banana", 50);
        bananaSandwich = new Sandwich("Banana", wheat, banana);
        
        SandwichFilling club = new SandwichFilling("Turkey, Bacon, Lettuce, Tomato, and Mayonnaise", 254);
        clubSandwich = new Sandwich("Club Sandwich", white, club);
        
        SandwichFilling ham = new SandwichFilling("Ham and Cheese", 100);
        hamSandwich = new Sandwich("Ham Sandwich", white, ham);
        
        
        bakery = new PackBakery(3);
        
        bakery2 = new PackBakery(2);
    }

    @Test
    public void testAddSandwich() {
        assertTrue(bakery.addSandwich(turkeySandwich));
        assertEquals(turkeySandwich, bakery.getMenu()[0]);
        assertTrue(bakery.addSandwich(bltSandwich));
        assertEquals(turkeySandwich, bakery.getMenu()[0]);
        assertEquals(bltSandwich, bakery.getMenu()[1]);
        assertTrue(bakery.addSandwich(pbjSandwich));
        assertEquals(turkeySandwich, bakery.getMenu()[0]);
        assertEquals(bltSandwich, bakery.getMenu()[1]);        
        assertEquals(pbjSandwich, bakery.getMenu()[2]);
        assertFalse(bakery.addSandwich(bananaSandwich));
    }
    
    @Test
    public void testAddSandwich2() {
        assertTrue(bakery2.addSandwich(clubSandwich));
        assertEquals(clubSandwich, bakery2.getMenu()[0]);
        assertTrue(bakery2.addSandwich(hamSandwich));
        assertEquals(clubSandwich, bakery2.getMenu()[0]);
        assertEquals(hamSandwich, bakery2.getMenu()[1]);
        assertFalse(bakery2.addSandwich(turkeySandwich));
    }

    @Test
    public void testRemoveSandwich() {
        assertTrue(bakery.addSandwich(turkeySandwich));
        assertEquals(turkeySandwich, bakery.getMenu()[0]);
        assertTrue(bakery.removeSandwich(turkeySandwich));
        assertNull(bakery.getMenu()[0]);
        
        assertTrue(bakery.addSandwich(turkeySandwich));
        assertTrue(bakery.addSandwich(bltSandwich));
        assertTrue(bakery.addSandwich(pbjSandwich));
        assertFalse(bakery.addSandwich(bananaSandwich));
        
        assertTrue(bakery.removeSandwich(turkeySandwich));
        assertNull(bakery.getMenu()[0]);
        assertTrue(bakery.removeSandwich(pbjSandwich));
        assertNull(bakery.getMenu()[0]);
        assertNull(bakery.getMenu()[2]);
        assertTrue(bakery.removeSandwich(bltSandwich));
        assertNull(bakery.getMenu()[0]);
        assertNull(bakery.getMenu()[1]);
        assertNull(bakery.getMenu()[2]);  
        assertFalse(bakery.removeSandwich(bananaSandwich));
    }
    
    @Test
    public void testRemoveSandwich2() {
        assertTrue(bakery2.addSandwich(clubSandwich));
        assertEquals(clubSandwich, bakery2.getMenu()[0]);
        assertTrue(bakery2.removeSandwich(clubSandwich));
        assertNull(bakery2.getMenu()[0]);
        
        assertTrue(bakery2.addSandwich(clubSandwich));
        assertTrue(bakery2.addSandwich(hamSandwich));
        assertFalse(bakery2.addSandwich(turkeySandwich));
        
        assertTrue(bakery2.removeSandwich(clubSandwich));
        assertNull(bakery2.getMenu()[0]);
        assertTrue(bakery2.removeSandwich(hamSandwich));
        assertNull(bakery2.getMenu()[0]);
        assertNull(bakery2.getMenu()[1]);
        assertFalse(bakery2.removeSandwich(turkeySandwich));
    }

    @Test
    public void testGetSandwich() {
        assertTrue(bakery.addSandwich(turkeySandwich));
        assertTrue(bakery.addSandwich(bltSandwich));
        assertTrue(bakery.addSandwich(pbjSandwich));
        
        assertEquals(turkeySandwich, bakery.getSandwich("Turkey Sandwich"));
        assertEquals(pbjSandwich, bakery.getSandwich("PBJ Sandwich"));
        assertEquals(bltSandwich, bakery.getSandwich("BLT Sandwich"));
       
        assertNull(bakery.getSandwich("Banana Sandwich"));
    }
    
    @Test
    public void testGetSandwich2() {
        assertTrue(bakery2.addSandwich(clubSandwich));
        assertTrue(bakery2.addSandwich(hamSandwich));
        
        assertEquals(clubSandwich, bakery2.getSandwich("Club Sandwich"));
        assertEquals(hamSandwich, bakery2.getSandwich("Ham Sandwich"));
        
        assertNull(bakery2.getSandwich("Turkey Sandwich"));
    }

}
