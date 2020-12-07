package LineProject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class JFrameGraphics extends JPanel{
    public void paint(Graphics g){
        Graphics2D g2D = (Graphics2D) g;
        g.drawOval(115, 115, 150, 150);
        g2D.setPaint(Color.MAGENTA);
        g.fillOval(115, 115, 150, 150);
        
        g.drawOval(115, 115, 150, 150);
    }
    
    public static void main(String[] args){
        JFrame frame= new JFrame("JavaTutorial.net");    
        frame.getContentPane().add(new JFrameGraphics());
        frame.setSize(400, 400);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);        
    }
}
