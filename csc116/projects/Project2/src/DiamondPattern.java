import java.util.*;
import java.awt.*;
/**
 * This program prints the image of diamond tiles based of the users inputs. 
 *
 * @author Jamea Speight
 */
public class DiamondPattern {
    /**
    * The minimum number of rows.
    */
    public static final int MIN_ROWS = 1;
    /**
    * The maximum number of rows.
    */
    public static final int MAX_ROWS = 8;
    /**
    * The minimum number of diamonds.
    */
    public static final int MIN_DIAMONDS = 1;
    /**
    * The maximum number of diamonds.
    */
    public static final int MAX_DIAMONDS = 12;
    /**
    * The minimum color value.
    */
    public static final int MIN_COLOR = 0;
    /**
    * The maximum color value.
    */
    public static final int MAX_COLOR = 255; 
    /**
    * Width of the diamond.
    */
    public static final int WIDTH = 100;  
    /**
     * Declares the variables, computes the position, and prints the results.
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in); 
        System.out.print("Number of rows (1-8):");
        int rows = console.nextInt();
        System.out.print("Number of diamonds per row (1-12):");
        int diamonds = console.nextInt();
        System.out.print("Red value (0-255):");
        int red = console.nextInt();
        System.out.print("Green value (0-255):");
        int green = console.nextInt();
        System.out.print("Blue value (0-255):");
        int blue = console.nextInt();
        
        if (rows < MIN_ROWS){
            rows = MIN_ROWS;
        }
        else if (rows > MAX_ROWS ){
            rows = MAX_ROWS ;
        }
        if ( diamonds < MIN_DIAMONDS ){
            diamonds = MIN_DIAMONDS ;  
        }
        else if (diamonds > MAX_DIAMONDS) { 
            diamonds = MAX_DIAMONDS;
        }
        if (red < MIN_COLOR ) {
            red = MIN_COLOR;
        } 
        else if( red > MAX_COLOR){
            red = MAX_COLOR; 
        }
        if (green < MIN_COLOR ) {
            green = MIN_COLOR;
        } 
        else if( green > MAX_COLOR){
            green = MAX_COLOR; 
        }
        if (blue < MIN_COLOR ) {
            blue = MIN_COLOR ;
        } 
        else if( blue > MAX_COLOR){
            blue = MAX_COLOR; 
        } 
        int x = WIDTH * diamonds;
        int y = WIDTH * rows;
        DrawingPanel panel = new DrawingPanel( x , y );
        Graphics g = panel.getGraphics(); 
        Color userColor = new Color (red, green, blue);
        panel.setBackground(userColor);
        int ty = 0;
        for (int i = 0; i <= rows; i++) {
            int tx = WIDTH / 2;
            for(int j = 0; j <= diamonds; j++) {
                drawDiamond(g,tx, ty, WIDTH);
                tx += WIDTH;
            }
            ty += WIDTH; 
        }
        System.out.println("*CLOSE the Drawing Panel to exit the program*");
    }
    /**
    * Draws the diamond picture based of the user input.
    *
    * @param g - Graphics variable to call the Drawing Panel
    * @param topX - x coordinate variable
    * @param topY - y coordinate variable
    * @param width - width and height of the diamonds.
    */
    public static void drawDiamond(Graphics g, int topX, int topY, int width) {
        Polygon diamond = new Polygon();
        diamond.addPoint( topX, topY);
        diamond.addPoint(topX - (width / 2), topY + (width / 2));
        diamond.addPoint( topX, topY + width); 
        diamond.addPoint (topX + (width / 2), topY + (width / 2));
        g.setColor(Color.WHITE);
        g.fillPolygon(diamond);
        g.setColor(Color.BLACK);
        g.drawPolygon(diamond);
    }
}