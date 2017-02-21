

/**
 * adds the panel containing the Game board to a frame so it is visible
 * 
 * @author (Jonathan Ho) 
 * @version (1/19/16)
 */
import javax.swing.*;
import java.awt.*;
public class driver
{
    public static void main(String [] args)// code from splat program
    {
        JFrame frame = new JFrame("Sorry!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.add(new tempBoard());
        
        frame.pack();
        frame.setVisible(true);
    }
}
