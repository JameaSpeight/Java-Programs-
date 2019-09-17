import java.awt.Color;
import java.awt.Graphics;

/**
 * Tests the drawDiamond() method
 * @author Suzanne Balik
 */
public class DiamondPatternTest {
    /**
     * Draws small, medium, and large white diamonds
     * on a white background
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        DrawingPanel panel = new DrawingPanel(400, 400);
        //panel.setBackground(Color.BLUE);
        Graphics g = panel.getGraphics();
        DiamondPattern.drawDiamond(g, 50, 50, 50); 
        DiamondPattern.drawDiamond(g, 100, 100, 100);
        DiamondPattern.drawDiamond(g, 180, 180, 200);
        
        System.out.println("*CLOSE the Drawing Panel to exit the program*");           
    }
}