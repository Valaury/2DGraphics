package RotatingImage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Imposter extends JPanel{
    
    public static void main(String args[]){
        JFrame F = new JFrame("Rotating Item");
        F.add(new Imposter());
        F.setSize(1000, 1000);
        F.setBackground(Color.black);
        F.setVisible(true);
        F.setLocationRelativeTo(null);
        F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    int i = 1;
    public void paintComponent(Graphics g){
        
        BufferedImage character = LoadImage("Red.png");
        AffineTransform at = AffineTransform.getTranslateInstance(500, 500);
        at.rotate(Math.toRadians(i++));
        at.scale(1, 1);
        
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(character, at, null);
        repaint();
    }
    
    BufferedImage LoadImage(String FileName){
        BufferedImage img =null;
        try{
            img = ImageIO.read(new File(FileName));
        }
        catch(IOException e)
        {
            System.out.println("No Image found");
        }    
        return img;
    }
   }
