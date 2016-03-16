package elevens.game;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.io.IOException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
/*
 * Project Elevens
 * By Chris Bigge
*/
public class GUIDriver
{
    public static void main(String[] args) throws IOException 
    {
        ElevensPanel ePanel = new ElevensPanel();
        JFrame frame = new JFrame();
        frame.add(ePanel);
        frame.setTitle("Elevens Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        ePanel.start();
   }
}