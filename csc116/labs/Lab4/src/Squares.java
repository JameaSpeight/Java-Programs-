/**
 * This program prints the square values of 1-10
 *
 * @author Jamea Speight
 */
 public class Squares {
    /**
	 * The main method starts program execution
	 *
	 * @param args command line arguments
	 */
    public static void main(String[] args) {
        final int MAXIMUM_NUMBER=10;
        int odds = 0;
        int n = -1;
        for (int i = 1; i <= MAXIMUM_NUMBER; i++) {
			//write the addition steps to get to the squared value
				n = n + 2;
				odds = odds + n;
				System.out.print(odds + " ");	
		}	
        //go to a new line
        System.out.println ();
	}
}	  
