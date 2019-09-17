import org.junit.Test;
import junit.framework.TestCase;

/**
 * Program to test DataConverter methods
 * @author Suzanne Balik
 * @author Jamea Speight 
 */
public class DataConverterTest extends TestCase {


    /** line in US format */
    public static final String US_LINE1 = 
                                "Brown, James        04/18/1991      68     167   99.30";
    
    /** line in other format */
    public static final String OTHER_LINE1 = 
                                "James Brown         18.04.1991  172.72   75.82   37.39";

    /** line in US format */
    public static final String US_LINE2 = 
                                "Dominguez, Raul     09/10/1945      67     150  100.25";
    
    /** line in other format */
    public static final String OTHER_LINE2 = 
                                "Raul Dominguez      10.09.1945  170.18   68.10   37.92";
                                          
    /** line in US format */
    public static final String US_LINE3 = 
                                "Zhang, Chen         03/15/2001      68     143   98.60";                                      
    
    /** line in other format */
    public static final String OTHER_LINE3 = 
                                "Chen Zhang          15.03.2001  172.72   64.92   37.00";
                                          
    @Test
    public void testConvertNameToOther1() {
        String description = "Convert Name to Other 1";
        String actual = DataConverter.convertLineToOtherFormat(US_LINE1);
        assertEquals(description, OTHER_LINE1.substring(0,20), actual.substring(0,20));
    }

    @Test
    public void testConvertDateToOther1() {
        String description = "Convert Date to Other 1";
        String actual = DataConverter.convertLineToOtherFormat(US_LINE1);
        assertEquals(description, OTHER_LINE1.substring(20,30), actual.substring(20,30));
    }

    @Test
    public void testConvertHeightToOther1() {
        String description = "Convert Height to Other 1";
        String actual = DataConverter.convertLineToOtherFormat(US_LINE1);
        assertEquals(description, OTHER_LINE1.substring(30,38), actual.substring(30,38));
    }

    @Test
    public void testConvertWeightToOther1() {
        String description = "Convert Weight to Other 1";
        String actual = DataConverter.convertLineToOtherFormat(US_LINE1);
        assertEquals(description, OTHER_LINE1.substring(38,46), actual.substring(38,46));
    }

    @Test
    public void testConvertTemperatureToOther1() {
        String description = "Convert Temperature to Other 1";
        String actual = DataConverter.convertLineToOtherFormat(US_LINE1);
        assertEquals(description, OTHER_LINE1.substring(46,54), actual.substring(46,54));
    }

    @Test
    public void testConvertLineToOther1() {
        String description = "Convert Line to Other 1";
        String actual = DataConverter.convertLineToOtherFormat(US_LINE1);
        assertEquals(description, OTHER_LINE1, actual);
    }

    @Test
    public void testConvertNameToUS1() {
        String description = "Convert Name to US 1";
        String actual = DataConverter.convertLineToUSFormat(OTHER_LINE1);
        assertEquals(description, US_LINE1.substring(0,20), actual.substring(0,20));
    }

    @Test
    public void testConvertDateToUS1() {
        String description = "Convert Date to US 1";
        String actual = DataConverter.convertLineToUSFormat(OTHER_LINE1);
        assertEquals(description, US_LINE1.substring(20,30), actual.substring(20,30));
    }

    @Test
    public void testConvertHeightToUS1() {
        String description = "Convert Height to US 1";
        String actual = DataConverter.convertLineToUSFormat(OTHER_LINE1);
        assertEquals(description, US_LINE1.substring(30,38), actual.substring(30,38));
    }

    @Test
    public void testConvertWeightToUS1() {
        String description = "Convert Weight to US 1";
        String actual = DataConverter.convertLineToUSFormat(OTHER_LINE1);
        assertEquals(description, US_LINE1.substring(38,46), actual.substring(38,46));
    }

    @Test
    public void testConvertTemperatureToUS1() {
        String description = "Convert Temperature to US 1";
        String actual = DataConverter.convertLineToUSFormat(OTHER_LINE1);
        assertEquals(description, US_LINE1.substring(46,54), actual.substring(46,54));
    }

    @Test
    public void testConvertLineToUS1() {
        String description = "Convert Line to US 1";
        String actual = DataConverter.convertLineToUSFormat(OTHER_LINE1);
        assertEquals(description, US_LINE1, actual);
    }
    
    @Test
    public void testConvertNameToOther2() {
        String description = "Convert Name to Other 2";
        String actual = DataConverter.convertLineToOtherFormat(US_LINE2);
        assertEquals(description, OTHER_LINE2.substring(0,21), actual.substring(0,21));
    }
    
    @Test
    public void testConvertDateToOther2() {
        String description = "Convert Date to Other 2";
        String actual = DataConverter.convertLineToOtherFormat(US_LINE2);
        assertEquals(description, OTHER_LINE2.substring(21,31), actual.substring(21,31));
    }
    
    @Test
    public void testConvertHeightToOther2() {
        String description = "Convert Height to Other 2";
        String actual = DataConverter.convertLineToOtherFormat(US_LINE2);
        assertEquals(description, OTHER_LINE2.substring(31,39), actual.substring(31,39));
    }

    @Test
    public void testConvertWeightToOther2() {
        String description = "Convert Weight to Other 2";
        String actual = DataConverter.convertLineToOtherFormat(US_LINE2);
        assertEquals(description, OTHER_LINE2.substring(39,47), actual.substring(39,47));
    }
    
    @Test
    public void testConvertTemperatureToOther2() {
        String description = "Convert Temperature to Other 2";
        String actual = DataConverter.convertLineToOtherFormat(US_LINE2);
        assertEquals(description, OTHER_LINE2.substring(47,54), actual.substring(47,54));
    }
    
    @Test
    public void testConvertLineToUS3() {
        String description = "Convert Line to US 3";
        String actual = DataConverter.convertLineToUSFormat(OTHER_LINE3);
        assertEquals(description, US_LINE3, actual);
    }
    
    @Test
    public void testConvertNameToUS2() {
        String description = "Convert Name to US 2";
        String actual = DataConverter.convertLineToUSFormat(OTHER_LINE2);
        assertEquals(description, US_LINE2.substring(0,21), actual.substring(0,21));
    }
    
    @Test
    public void testConvertDateToUS2() {
        String description = "Convert Date to US 2";
        String actual = DataConverter.convertLineToUSFormat(OTHER_LINE2);
        assertEquals(description, US_LINE2.substring(21,31), actual.substring(21,31));
    }

    @Test
    public void testConvertHeightToUS2() {
        String description = "Convert Height to US 2";
        String actual = DataConverter.convertLineToUSFormat(OTHER_LINE2);
        assertEquals(description, US_LINE2.substring(31,39), actual.substring(31,39));
    }

    @Test
    public void testConvertWeightToUS2() {
        String description = "Convert Weight to US 2";
        String actual = DataConverter.convertLineToUSFormat(OTHER_LINE2);
        assertEquals(description, US_LINE2.substring(39,47), actual.substring(39,47));
    }

    @Test
    public void testConvertTemperatureToUS3() {
        String description = "Convert Temperature to US 3";
        String actual = DataConverter.convertLineToUSFormat(OTHER_LINE3);
        assertEquals(description, US_LINE3.substring(47,54), actual.substring(47,54));
    }

    @Test
    public void testConvertLineToOther3() {
        String description = "Convert Line to Other 3";
        String actual = DataConverter.convertLineToOtherFormat(US_LINE3);
        assertEquals(description, OTHER_LINE3, actual);
    }
}
