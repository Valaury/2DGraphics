package RotatingImage;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class MovingLabel extends JFrame implements ActionListener {
   private JLabel label;
   public MovingLabel() {
      setTitle("MovingLabel");
      label= new JLabel("           bob was not the imposter ");
      label.setFont(new Font("Arial", 0, 25));
      add(label, BorderLayout.CENTER);
      Timer t = new Timer(200, this); // set a timer
      t.start();
      setSize(100, 100);
      setVisible(true);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   public void actionPerformed(ActionEvent e) {
      String oldText = label.getText();
      String newText= oldText.substring(1)+ oldText.substring(0,1);
      label.setText(newText);
   }
   public static void main (String[] args) {
      new MovingLabel();
   }
}
