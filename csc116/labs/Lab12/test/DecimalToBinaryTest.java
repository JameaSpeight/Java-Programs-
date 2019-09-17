import static org.junit.Assert.assertEquals;

import org.junit.*;
import junit.framework.TestCase;
/**
 * A program that tests the program DecimalToBinary
 * 
 * @author Jamea Speight
 * @author Jay Vandeveld
 */
public class DecimalToBinaryTest extends TestCase{

    @Test
    public void testConvertToBinaryValid() {
        // Zero - special case
        String id = "Zero";
        String desc = "DecimalToBinary.convertToBinary(0)";
        String expected = "0";
        String actual = DecimalToBinary.convertToBinary(0);
        assertEquals(id, expected, actual);
        
        // 1 - boundary condition
        id = "705";
        desc = "DecimalToBinary.convertToBinary(705)";
        expected = "1011000001";
        actual = DecimalToBinary.convertToBinary(705);
        assertEquals(id, expected, actual);

        // 3 - odd decimal        
        id = "Three";
        desc = "DecimalToBinary.convertToBinary(3)";
        expected = "11";
        actual = DecimalToBinary.convertToBinary(3);
        assertEquals(id, expected, actual);

        // 1234 - even decimal
        id = "1234";
        desc = "DecimalToBinary.convertToBinary(1234)";
        expected = "10011010010";
        actual = DecimalToBinary.convertToBinary(1234);
        assertEquals(id, expected, actual);       
    }

    
    @Test
    public void testConvertToBinaryInvalid() {
        try {
            DecimalToBinary.convertToBinary(-1);
            fail("An exception should have been thrown for -1");
        } catch (IllegalArgumentException e) {
            assertEquals("-1", "Negative value: -1", e.getMessage());
        }

        try {
            DecimalToBinary.convertToBinary(-2468);
            fail("An exception should have been thrown for -2468");
        } catch (IllegalArgumentException e) {
            assertEquals("-2468", "Negative value: -2468", e.getMessage());
        }
    }

}
