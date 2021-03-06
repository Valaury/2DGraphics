package DragAndDrop;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DragAndDrop extends JFrame{
    JLabel pic1, pic2, pic3, pic4;
    public DragAndDrop(){
        super("Drag and Drop Image");
        
        pic1 = new JLabel();
        pic2 = new JLabel();
        pic3 = new JLabel();
        pic4 = new JLabel();
        
        pic1.setBounds(150, 100,200,200);
        pic2.setBounds(300,100,200,200);
        pic3.setBounds(150,300,200,200);
        pic4.setBounds(100,300,200,200);
        
        pic1.setIcon(new ImageIcon("Red.png"));
        pic2.setIcon(new ImageIcon("Red Dead.png"));
        pic3.setIcon(new ImageIcon("Orange.png"));
        pic4.setIcon(new ImageIcon("Orange Dead.png"));
        
        MouseListener ml = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
                JComponent jc = (JComponent)e.getSource();
                TransferHandler th = jc.getTransferHandler();
                th.exportAsDrag(jc, e, TransferHandler.COPY);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                
            }};
        
        pic1.addMouseListener(ml);
        pic2.addMouseListener(ml);
        pic3.addMouseListener(ml);
        pic4.addMouseListener(ml);
        
        pic1.setTransferHandler(new TransferHandler("icon"));
        pic2.setTransferHandler(new TransferHandler("icon"));
        pic3.setTransferHandler(new TransferHandler("icon"));
        pic4.setTransferHandler(new TransferHandler("icon"));
        
        add(pic1);
        add(pic2);
        add(pic3);
        add(pic4);
        
        setSize(600,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }
    public static void main(String[] args) {
        new DragAndDrop();
    }
    
}
