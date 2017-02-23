/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.sql.Connection;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author apurva
 */
public class Checkout extends javax.swing.JFrame {

    /**
     * Creates new form Checkout
     */
    String isbn;
    
    public Checkout() {
        initComponents();
        
    }
    public Checkout (String value){
        initComponents();
        this.isbn=value;
        
        jTextField1.setText(isbn);
    }
    /**
     * This method i\s called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        checkout_book = new javax.swing.JButton();
        ISBN_change = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel1.setText("ISBN:");

        checkout_book.setText("Checkout book");
        checkout_book.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkout_bookActionPerformed(evt);
            }
        });

        ISBN_change.setText("Enter another ISBN");
        ISBN_change.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ISBN_changeActionPerformed(evt);
            }
        });

        jLabel2.setText("Enter Card_id:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(checkout_book)
                        .addGap(48, 48, 48)
                        .addComponent(ISBN_change, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                        .addGap(65, 65, 65))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                            .addComponent(jTextField1))
                        .addGap(41, 41, 41))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkout_book)
                    .addComponent(ISBN_change))
                .addContainerGap(300, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void checkout_bookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkout_bookActionPerformed
        // TODO add your handling code here:
        Connection conn = null;
        Statement stmt=null;
        try{
             conn=ConnUtil.getConnection();
             stmt=conn.createStatement();
            
            String card_id=jTextField2.getText();
            String query = "select count(*) as count from book_loans where card_id="+card_id+";";
        
            ResultSet rs2= stmt.executeQuery(query);
               rs2.next();
                int count= rs2.getInt("count");
                
                
                if(count>=3)
                {
                    JOptionPane.showMessageDialog(this,"You cannot checkout more than 3 books!","Error",JOptionPane.ERROR_MESSAGE);
                }
                
                else{
                    if (count==0){
                        stmt.executeUpdate("insert into book_loans (isbn,card_id,date_out,due_date) values ("+isbn+","+card_id+",CURDATE(),DATE_ADD(CURDATE(),INTERVAL 14 DAY));");
                    
                        stmt.executeUpdate("update book set available_count=0 where isbn="+isbn+";");
                        JOptionPane.showMessageDialog(this, "Checkout Completed", "General", JOptionPane.PLAIN_MESSAGE);
                    }
                    else{
                        int datediff=0;
                        ResultSet rs1=stmt.executeQuery("select datediff(curdate(),due_date) as diffdate from book_loans where card_id="+card_id+";");  
                        while (rs1.next()){
                           datediff =rs1.getInt("diffdate");
                        }
                    
                        System.out.println("datediff"+datediff);
                    
                   /* long ddate= (due_date.getTime()/(24*60*60*1000)) ;
                    long ccdate = (current_date.getTime()/(24*60*60*1000)) ;*/
                       // long datediff =(current_date.getTime()/(24*60*60*1000))-(due_date.getTime()/(24*60*60*1000));
                        
                        if(datediff<0){
                        
                       
                            ResultSet rs3=stmt.executeQuery("select f.paid from fines f, book_loans b where b.loan_id=f.loan_id and b.card_id="+card_id+";");
                            boolean flag=false;
                    
                            while (rs3.next()){
                       
                                String paid=rs3.getString("f.paid");
                                if(paid==null)
                                {
                                    flag=true;
                                    break;
                                }
                        
                        
                            }
                    
                            if(flag==true){
                                JOptionPane.showMessageDialog(this,"You have unpaid fine! please pay the fine!","Error",JOptionPane.ERROR_MESSAGE);
                    
                            }
                             else{
                        
                                stmt.executeUpdate("insert into book_loans (isbn,card_id,date_out,due_date) values ("+isbn+","+card_id+",CURDATE(),DATE_ADD(CURDATE(),INTERVAL 14 DAY));");
                    
                                stmt.executeUpdate("update book set available_count=0 where isbn="+isbn+";");
                                JOptionPane.showMessageDialog(this, "Checkout Completed", "General", JOptionPane.PLAIN_MESSAGE);
                                
                                //JOptionPane.showMessageDialog(this, "Checkout Completed", "General", JOptionPane.PLAIN_MESSAGE);
                        
                            }
                       
                        }   
                       
                       
                   }
                   
                   
                  //  JOptionPane.showMessageDialog(this, "Checkout Completed", "General", JOptionPane.PLAIN_MESSAGE);
                       
                }
                
          
        
                stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(Checkout.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            
        
        ConnUtil.closeConnection(conn);
        }
        
        
    }//GEN-LAST:event_checkout_bookActionPerformed

    private void ISBN_changeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ISBN_changeActionPerformed
        // TODO add your handling code here:
        jTextField1.setText("");
        
    }//GEN-LAST:event_ISBN_changeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Checkout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Checkout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Checkout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Checkout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Checkout().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ISBN_change;
    private javax.swing.JButton checkout_book;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}