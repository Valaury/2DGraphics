package LineProject;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.*;

public class Lines extends JFrame{
 
 LinesPanel panel;
 
 Lines(){
  
  panel = new LinesPanel();
  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  this.add(panel);
  this.pack();
  this.setLocationRelativeTo(null);
  this.setVisible(true);
 }  
 public static void main(String[] args){
          new Lines();
    }
}
