/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIChat;

import static GUIChat.ChatServer.dout;
import java.awt.event.ActionEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.AbstractAction;
import javax.swing.Action;

/**
 *
 * @author User
 */
public class ChatClient extends javax.swing.JFrame {

    static Socket s ;
    static DataInputStream din ;
    static DataOutputStream dout;
    
    public ChatClient() {
        initComponents();
        jText.addActionListener(action);
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chat Client");
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jText, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Save();
    }//GEN-LAST:event_jButton1ActionPerformed

    public void Save(){
        String msgOut = jText.getText();
        
        String pattern = "MM/dd h:mm";
        DateFormat df = new SimpleDateFormat(pattern);
        Date date = Calendar.getInstance().getTime();
        String time = df.format(date);
        
        if(msgOut != ""){
            try
        {
            msgOut= time + " Amara : " + (jText.getText().trim());
            dout.writeUTF(msgOut);
            jText.setText("");
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        } 
    }
    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChatClient().setVisible(true);
            }
        });
        String msgIn="";
        try{
            s = new Socket("localhost", 3333);
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
    // End of variables declaration//GEN-END:variables
}
