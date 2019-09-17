import java.awt.*;
/**
 * Draws a face
 * 
 * @author Jamea Speight
 * @author Taylor Earnhardt 
 */
public class Face2 {
    /**
     * Declares the variables, computes the position, and prints the results.
     * 
     * @param args
     *            command line arguments
     */
    public static void main(String[] args) {
        DrawingPanel panel = new DrawingPanel(520, 180);
        Graphics g = panel.getGraphics();

        //Max and min x coordinate values
        final int MAX = 410;
        final int MIN = 10;

        //Loop to make the 5 faces 
        for(int i = MIN; i <= MAX; i += 100) {
            drawFace(g,i,30);
        }
        
    }
    /**
     *Creates the face visualization method 
     *
     *@param g - Graphics variable to call the Drawing Panel
     *@param x - x cooridinate variable
     *@param y - y coordinate variable 
     */
    public static void drawFace(Graphics g, int x, int y) {
        g.setColor(Color.BLACK);
        g.drawOval(x, y, 100, 100); // face outline

        g.setColor(Color.BLUE);
        g.fillOval(x + 20, y + 30 , 20, 20); // eyes
        g.fillOval(x + 60, y + 30, 20, 20);

        g.setColor(Color.RED); // mouth
        g.drawLine(x + 30, y + 70, x + 70, y + 70);
    }    
}
