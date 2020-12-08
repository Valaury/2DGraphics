package GUIChat;

import static GUIChat.ChatClient.dout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import java.awt.*;  


public class ChatServer extends javax.swing.JFrame {
    static ServerSocket ss ;
    static Socket s ;
    static DataInputStream din ;
    static DataOutputStream dout;
    
    public ChatServer() {
        initComponents();
        jText.addActionListener(action);
        ImageIcon icon= new ImageIcon("Yahoo Logo.png");
        
        this.setIconImage(icon.getImage());
        this.getContentPane().setBackground(Color.getColor("5B00C1"));
        
        String datepattern = "dd/M/yyyy";
        DateFormat df1 = new SimpleDateFormat(datepattern);
        Date date1 = Calendar.getInstance().getTime();
        String today = df1.format(date1);
        lblDate.setText(today);
    }
    
    Action action = new AbstractAction(){
    @Override
    public void actionPerformed(ActionEvent e)
    {
        Save();
        System.out.println("Enter Pressed");
    }
    };

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jText = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        lbl = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chat Server");
        setBackground(new java.awt.Color(71, 0, 193));
        setMaximumSize(new java.awt.Dimension(418, 325));
        setMinimumSize(new java.awt.Dimension(418, 325));
        setPreferredSize(new java.awt.Dimension(418, 325));

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jText.setFocusCycleRoot(true);
        jText.setSelectionStart(1);

        jButton1.setText("Send");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUIChat/Yahoo.png"))); // NOI18N

        lblDate.setForeground(new java.awt.Color(255, 255, 255));
        lblDate.setText("DD/MM/YYYY");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl)
                        .addGap(240, 240, 240)
                        .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jText, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lblDate))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Save();
    }//GEN-LAST:event_jButton1ActionPerformed

    public void Save(){
        String msgOut = jText.getText();
        
        String pattern = "h:mm a";
        DateFormat df = new SimpleDateFormat(pattern);
        Date date = Calendar.getInstance().getTime();
        String time = df.format(date);
        
        if(msgOut != ""){
            try
        {
            msgOut= time + " Jason : " + (jText.getText().trim());
            dout.writeUTF(msgOut);
            jText.setText("");
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        } 
    }
    public static void main(String args[]) throws IOException {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChatServer().setVisible(true);
            }
        });
        
        String msgIn="";
        try
        {
            ss = new ServerSocket(3333);
            s = ss.accept();
            din = new DataInputStream(s.getInputStream());
            dout = new DataOutputStream(s.getOutputStream());
            
            while (!msgIn.equals("exit")) 
            {
            msgIn = din.readUTF();
            jTextArea1.setText(jTextArea1.getText().trim()+ "\n"+msgIn);
            
            }
          
        }catch(Exception e)
         {
             e.printStackTrace();
         }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jText;
    private static javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lbl;
    private javax.swing.JLabel lblDate;
    // End of variables declaration//GEN-END:variables
}
