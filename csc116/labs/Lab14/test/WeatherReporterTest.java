import java.util.Scanner;
import org.junit.Test;
import junit.framework.TestCase;
/**
 * Program to test the WeatherReporter 
 * 
 * @author Suzanne Balik
 * @author Jessica Young Schmidt
 * @author Jamea Speight
 * @author Jay Vandeveld
 */
public class WeatherReporterTest extends TestCase {

    @Test
    public void testProcessLine() {
        String input = "20100627    85.4    100.9   73  000000";
        String description = "Temperature over 100";
        String expected = "06/27/2010 Low:  73.0 High: 100.9 Rain:  no Snow:  no";
        String actual = WeatherReporter.processLine(input);
        assertEquals(description, expected, actual);
    }

    @Test
    public void testProcessLine2() {
        String input = "20101030    76.9    32.4   12.0  011000";
        String description = "Low Temperature is decimal";
        String expected = "10/30/2010 Low:  12.0 High:  32.4 Rain: yes Snow: yes" ;
        String actual = WeatherReporter.processLine(input);
        assertEquals(description, expected, actual);
    }
    
    @Test
    public void testProcessLine3() {
        String input = "20100820    99.9    75   54.6  001000";
        String description = "High Temperature is whole number";
        String expected = "08/20/2010 Low:  54.6 High:  75.0 Rain:  no Snow: yes" ;
        String actual = WeatherReporter.processLine(input);
        assertEquals(description, expected, actual);
    }
}
