import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;
/**
 * 
 * Test program for the Rational Numbers program.
 * 
 * @author Jamea Speight
 * @author Grace Barnhill
 * @author Johnathan Rhyne
 */
public class RationalNumberTest extends TestCase {

    /** Initialize private RationalNumber quarter */
    private RationalNumber quarter;
    /** Initialize private RationalNumber quarterNeg */
    private RationalNumber quarterNeg;
    /** Initialize private RationalNumber twoOverEight */
    private RationalNumber twoOverEight;
    /** Initialize private RationalNumber third */
    private RationalNumber third;
    /** Initialize private RationalNumber half */
    private RationalNumber half;
    /** Initialize private RationalNumber three */
    private RationalNumber three;

    /** Setting all private RationalNumbers previously initialized */
    @Before
    public void setUp() {
        quarter = new RationalNumber(1, 4);
        quarterNeg = new RationalNumber(1, -4);
        twoOverEight = new RationalNumber(2, 8);
        third = new RationalNumber(1, 3);
        half = new RationalNumber(1, 2);
        three = new RationalNumber(6, 2);
    }

    @Test
    public void testNotANumber() {
        try {
            RationalNumber temp = new RationalNumber(3, 0);
            fail("Didn't throw exception when denominator 0");
        } catch (IllegalArgumentException e) {
            assertEquals("Message for IllegalArgumentException for denominator 0", e.getMessage(),
                    "Denominator is 0");
        }
    }

    @Test
    public void testToString() {
        assertEquals("quarter toString", "1/4", quarter.toString());
        assertEquals("quarterNeg toString", "-1/4", quarterNeg.toString());
        assertEquals("twoOverEight toString", "1/4", twoOverEight.toString());
        assertEquals("third toString", "1/3", third.toString());
        assertEquals("half toString", "1/2", half.toString());
        assertEquals("three toString", "3", three.toString());
    }

    @Test
    public void testAdd() {
        String desc = "quarter.add(twoOverEight)";
        RationalNumber exp = half;
        RationalNumber act = quarter.add(twoOverEight);
        assertEquals(desc, exp, act);

        String desc2 = "three.add(twoOverEight)";
        RationalNumber expZ = new RationalNumber(26, 8);
        RationalNumber actB = three.add(twoOverEight);
        assertEquals(desc2, expZ, actB);

        String desc3 = "quarterNeg.add(quarter)";
        RationalNumber expY = new RationalNumber();
        RationalNumber actC = quarterNeg.add(quarter);
        assertEquals(desc3, expY, actC);

    }

    @Test
    public void testSubtract() {

        String desc = "quarter.subtract(twoOverEight)";
        RationalNumber exp = new RationalNumber();
        RationalNumber act = quarter.subtract(twoOverEight);
        assertEquals(desc, exp, act);

        String desc2 = "half.subtract(third)";
        RationalNumber expZ = new RationalNumber(1,6);
        RationalNumber actB = half.subtract(third);
        assertEquals(desc2, expZ, actB);
        
        String desc3 = "twoOverEight.subtract(half)";
        RationalNumber expY = new RationalNumber(-1,4);
        RationalNumber actC = twoOverEight.subtract(half);
        assertEquals(desc3, expY, actC);

        
    }

    @Test
    public void testMultiply() {

        String desc = "quarter.multiply(twoOverEight)";
        RationalNumber exp = new RationalNumber(1, 16);
        RationalNumber act = quarter.multiply(twoOverEight);
        assertEquals(desc, exp, act);

        String desc2 = "half.multiply(quarterNeg)";
        RationalNumber expZ = new RationalNumber(1, -8);
        RationalNumber actB = half.multiply(quarterNeg);
        assertEquals(desc2, expZ, actB);

        String desc3 = "third.multiply(three)";
        RationalNumber expY = new RationalNumber(1, 1);
        RationalNumber actC = third.multiply(three);
        assertEquals(desc3, expY, actC);
    }

    @Test
    public void testDivide() {

        String desc = "quarter.divide(twoOverEight)";
        RationalNumber exp = new RationalNumber(1, 1);
        RationalNumber act = quarter.divide(twoOverEight);
        assertEquals(desc, exp, act);

        String desc2 = "three.divide(third)";
        RationalNumber expZ = new RationalNumber(9, 1);
        RationalNumber actB = three.divide(third);
        assertEquals(desc2, expZ, actB);

        String desc3 = "half.divide(third)";
        RationalNumber expY = new RationalNumber(3, 2);
        RationalNumber actC = half.divide(third);
        assertEquals(desc3, expY, actC);
    }

    @Test
    public void testEquals() {
        String desc = "quarter.equals(twoOverEight)";
        boolean actB = quarter.equals(twoOverEight);
        assertTrue(desc, actB);

        String desc2 = "quarter.equals(third)";
        boolean actC = quarter.equals(third);
        assertFalse(desc2, actC);

        String desc3 = "quarterNeg.equals(twoOverEight)";
        boolean actD = quarterNeg.equals(twoOverEight);
        assertFalse(desc3, actD);
    }

}
