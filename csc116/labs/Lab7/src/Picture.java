import java.awt.*;

/**
 * Program that will be used to show the basics for learning graphics
 * 
 * @author Jamea Speight
 * @author Taylor Earnhardt 
 */
public class Picture {
    /**
     * Declares the variables, computes the position, and prints the results.
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        DrawingPanel panel = new DrawingPanel(500, 500);

       
        Graphics g = panel.getGraphics();
        g.setColor(Color.CYAN);
        g.fillRect(150, 130, 115, 200);

        g.setColor(Color.GREEN);
        g.fillOval(220, 140, 115, 100);

        g.drawString("Taylor", 30, 25);
        g.drawString("Jamea",75, 30);
        g.drawString("This is Art", 100,15 );
    }
}
