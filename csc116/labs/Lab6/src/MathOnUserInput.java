import java.util.Scanner;
 /**
  * Produce a summary of statistics of entered numbers.
  *
  *@author Ryan Hurlbut
  *@author Jamea Speight
  */

public class MathOnUserInput
{
    /**
     * Starts the program 
     *
     *@param args
     *           command line arguments
     */
//main method 
    public static void main(String[] args)
    {
		Scanner console = new Scanner(System.in);
		
	//asking for the number of integers they will input
		System.out.println("How many integers?");
		int intTotal = console.nextInt();
 
	//storing values to begin program with 
		System.out.println("Next Integer?");
		int startValue = console.nextInt();
		int min = startValue;
		int max = startValue;
		int sum = startValue;
	//main for loop to produce and store function values repeatedly
		for (int i = 0; i < intTotal - 1; i++)
		{
			System.out.println("Next Integer?");
			int value = console.nextInt();
			min = Math.min(min, value); 
			max = Math.max(max, value);
			sum = (value + sum);		
		}
	//print the values
        System.out.println("Sum = " + sum);
        System.out.println("Average = " + (((double)sum) / intTotal));
        System.out.println("Min = " + min);
        System.out.println("Max = " + max);
    }
}