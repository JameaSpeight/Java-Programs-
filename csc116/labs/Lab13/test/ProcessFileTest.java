import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Test;

public class ProcessFileTest {

    @Test
    public void testProcessFileSingleInteger() throws FileNotFoundException {
        Scanner fileScan = new Scanner(new File("test-files/test1.txt"));
        String expected = "Maximum = 4\n" + "Minimum = 4\n" + "Sum = 4\n" + "Count = 1\n"
                + "Average = 4.0";
        String actual = ProcessFile.processFile(fileScan);
        assertEquals("Test file with single integer", expected, actual);
    
        // multiple different type of tokens
        fileScan = new Scanner(new File("test-files/test2.txt"));
        expected = "Maximum = 8\n" + "Minimum = 3\n" + "Sum = 23\n" + "Count = 4\n"
                + "Average = 5.75";
        actual = ProcessFile.processFile(fileScan);
        assertEquals("Test file with different type of tokens", expected, actual);

        //negative integers
        fileScan = new Scanner(new File("test-files/test3.txt"));
        expected = "Maximum = -5\n" + "Minimum = -30\n" + "Sum = -85\n" + "Count = 5\n"
                + "Average = -17.0";
        actual = ProcessFile.processFile(fileScan);
        assertEquals("Test file with negative integers", expected, actual);
    }

    @Test
    public void testGetInputScannerSingleInteger() throws FileNotFoundException {
        // Next lecture we will discuss Scanner for strings
        Scanner fileScan = ProcessFile.getInputScanner(new Scanner("test-files/test1.txt"));
        assertNotNull(fileScan);
        assertTrue("Has integer element", fileScan.hasNextInt());
        assertEquals("Get single element", 4, fileScan.nextInt());
        assertFalse("No other integer element", fileScan.hasNextInt());
        assertFalse("No other element", fileScan.hasNext());
    }

    @Test
    public void testGetInputScannerFileDoesNotExistThenSingleInteger()
            throws FileNotFoundException {
        // Next lecture we will discuss Scanner for strings
        Scanner fileScan = ProcessFile
                .getInputScanner(new Scanner("test-file/non-existent.txt test-files/test1.txt"));
        assertNotNull(fileScan);
        assertTrue("Has integer element", fileScan.hasNextInt());
        assertEquals("Get single element", 4, fileScan.nextInt());
        assertFalse("No other integer element", fileScan.hasNextInt());
        assertFalse("No other element", fileScan.hasNext());
    }
}
