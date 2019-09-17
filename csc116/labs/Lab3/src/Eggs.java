/**
 * This program prints a full textual explanation for the amount owed for an egg purchase.
 *
 * @author Jamea Speight
 */
 public class Eggs {
	/**
	 * The main method starts program execution
	 *
	 * @param args command line arguments
	 */
 	public static void main (String [] args) {
 		// Calculate total egg order price with full explanation
 		double dozenPrice = 3.25;
 		double individualPrice = 0.45;
 		int N = 27;
 		int D = N / 12;
 		int S = N % 12;
 		double dozenCost = D * dozenPrice;
 		double singleCost = S * individualPrice;
 		double totalCost = dozenCost + singleCost;
 		System.out.println ("You ordered "+ N + " eggs. That's " + D + " dozen at $" + dozenPrice + " per dozen and " + S + " loose eggs at " + (int)(individualPrice * 100) + " cents each for a total of $" + totalCost + ".");
 		}
 }