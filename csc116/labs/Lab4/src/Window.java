/**
 * This program displays window based on window size.
 *
 * @author Jamea Speight
 */
 public class Window {
public static final int WINDOW_SIZE = 5;
    /**
	 * The main method starts program execution
	 *
	 * @param args command line arguments
	 */
    public static void main(String[] args) {
      
    	lengthLine ();
		windowRow ();
		lengthLine (); 
		windowRow ();
		lengthLine ();
	}
	/**
	 * This method prints lengthLine by window size 
	 */
	 public static void lengthLine () {
	 	// print +=====+=====+
	 	System.out.print ("+");
	 	for (int n = 1; n <= WINDOW_SIZE; n++) {
			System.out.print ("=") ;
		}
		System.out.print ("+");
	 	for (int n = 1; n <= WINDOW_SIZE; n++) {
			System.out.print ("=") ;
		}
		System.out.println ("+") ;
	}
	/**
	* This method prints windowRows by window size 
	*/
	public static void windowRow () {
		// print |     |     |
			for(int i = 0; i < WINDOW_SIZE; i++){
				System.out.print ("|");
				for (int j = 1; j <= WINDOW_SIZE; j++) {
					System.out.print (" ") ;
				}
				System.out.print ("|");
	 			for (int j = 1; j <= WINDOW_SIZE; j++) {
					System.out.print (" ") ;
				}
				System.out.println ("|") ;
			}
	 }
}