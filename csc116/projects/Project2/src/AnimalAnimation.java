import java.awt.*;
import java.util.*;
/**
 * This program prints the image of an animal moving across a screen
 *
 * @author Jamea Speight
 */
public class AnimalAnimation {
    /**
    * The width.
    */
    public static final int WIDTH = 500;
    /**
    * The height.
    */
    public static final int HEIGHT = 400;
    /**
    * The height.
    */
    public static final int SLEEP_TIME = 200;
    /**
    * The initial x coordinate.
    */
    public static final int INITIAL_X = 10;
    /**
    * The initial y coordinate.
    */
    public static final int INITIAL_Y = 200;
    /**
    * The number of updates.
    */
    public static final int NUMBER_OF_UPDATES = 80;
    /**
    * The change of x.
    */
    public static final int DX = 5;
    /**
    * Declares the variables, calls the draw methods.
    * 
    * @param args command line arguments
    */
    public static void main (String[] args) {
        
        DrawingPanel panel = new DrawingPanel(WIDTH, HEIGHT);
        Graphics g = panel.getGraphics();
        
        int x = INITIAL_X;
        int y = INITIAL_Y;
        for (int i = 0; i < NUMBER_OF_UPDATES; i++) {
            drawBackground(g);
            drawAnimal(g, x + DX * i, y);
            panel.sleep(SLEEP_TIME);
            drawAnimal2(g, x + DX * i, y);
            panel.sleep(SLEEP_TIME);
        } 
         
        System.out.println("\n*CLOSE the Drawing Panel to exit the program*");
    }
    /**
    * Draws the background.
    *
    * @param g - Graphics variable to call the Drawing Panel
    */
    public static void drawBackground (Graphics g) {
        g.setColor(Color.CYAN);
        g.fillRect(0,0,WIDTH,HEIGHT - 100);
        g.setColor(Color.GREEN);
        g.fillRect(0,HEIGHT - 100,WIDTH, HEIGHT  - 300);
        g.setColor(Color.YELLOW);
        g.fillOval(350, 20, 100, 100);
    }
    /**
    * Draws the first animal picture.
    *
    * @param g - Graphics variable to call the Drawing Panel
    * @param x - x coordinate variable
    * @param y - y coordinate variable
    */
    public static void drawAnimal (Graphics g, int x, int y) {
        Color brown = new Color(168,101,9);
        g.setColor(brown);
        g.fillOval(x + 60, y - 15 , 80, 55);
        g.fillOval(x, y + 15  ,110,60);
        g.fillOval(x + 10, y + 85, 25, 15);
        g.fillOval(x + 70, y + 85, 25, 15);
        g.fillRect(x + 10, y + 55 , 10 , 40);
        g.fillRect(x + 70, y + 55 , 10 , 40);
        g.fillRect(x + 75, y - 30 , 10 , 40);
        g.fillOval(x + 60, y - 30, 25, 15);
        g.setColor(Color.BLACK);
        g.fillOval(x + 127, y + 2 , 20, 17);
        g.fillOval(x + 100, y - 10, 10, 20);
    } 
    /**
    * Draws the second animal picture.
    *
    * @param g - Graphics variable to call the Drawing Panel
    * @param x - x coordinate variable
    * @param y - y coordinate variable
    */
    public static void drawAnimal2 (Graphics g, int x, int y) {
        Color brown = new Color(168,101,9);
        g.setColor(brown);
        g.fillOval(x + 60, y - 15 , 80, 55);
        g.fillOval(x, y + 15  ,110,60); 
        g.fillOval(x + 30, y + 85, 25, 15);
        g.fillOval(x + 90, y + 85, 25, 15);
        g.fillRect(x + 30, y + 55 , 10 , 40);
        g.fillRect(x + 90, y + 55 , 10 , 40);
        g.fillRect(x + 75, y - 30 , 10 , 40);
        g.fillOval(x + 60, y - 30, 25, 15);
        g.setColor(Color.BLACK);
        g.fillOval(x + 127, y + 2 , 20, 17);
        g.fillOval(x + 100, y - 10, 10, 20);
    }
}