/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author apurva
 */
public class CheckIn extends javax.swing.JFrame {

    /**
     * Creates new form CheckIn
     */
    
    int loan_id;
    public CheckIn() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Check_book = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        Check_book.setText("See issued Book");
        Check_book.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Check_bookActionPerformed(evt);
            }
        });

        jLabel1.setText("Enter ISBN or borrower ID to check in book:");

        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        jLabel2.setText("Issued books are:");

        jButton1.setText("Check in");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Loan_id", "Card_id", "Name", "ISBN", "Title", "Due_date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jScrollPane1.setVisible(false);

        jLabel3.setText("Enter Loan_id:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(Check_book))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(215, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(Check_book)
                .addGap(67, 67, 67))
        );

        jLabel2.setVisible(false);
        jButton1.setVisible(false);
        jLabel3.setVisible(false);
        jTextField1.setVisible(false);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Check_bookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Check_bookActionPerformed
        // TODO add your handling code here:
        jLabel2.setVisible(true);
        jButton1.setVisible(true);
        jLabel3.setVisible(true);
        jTextField1.setVisible(true);
       
        Connection conn=null;
        try{
            conn=ConnUtil.getConnection();
            Statement stmt=conn.createStatement();
            String value=search.getText();
            if(value.equals("")){
                JOptionPane.showMessageDialog(this,"Enter valid search field","Error",JOptionPane.ERROR_MESSAGE);
            }
            else{
                ResultSet rs=stmt.executeQuery("select bl.Loan_id,bo.card_id,bo.fname,bo.lname,b.isbn,b.title,bl.Due_date from book b, book_loans bl ,borrower bo where bl.isbn=b.isbn and  (bl.card_id="+value+" OR b.ISBN ='"+value+"') and bl.card_id=bo.card_id and bl.Date_in is null;");
                if(rs.next()==false){
                
                    JOptionPane.showMessageDialog(this,"You dont have any books issued.","Error",JOptionPane.ERROR_MESSAGE);
                }
                else{
                    rs.previous();
                    Check_book.setVisible(false);
                    jScrollPane1.setVisible(true);
                    System.out.println("in else");
                    DefaultTableModel model1 = (DefaultTableModel) jTable1.getModel();
                while(rs.next())
                {
                    
                    int loanid=rs.getInt("bl.Loan_id");
                    System.out.println("loan"+loanid);
                    String bookISBN=rs.getString("b.isbn");
                    int cardid=rs.getInt("bo.card_id");
                    Date due_date=rs.getDate("bl.Due_date");
                    String book_title = rs.getString("b.title");
                    String name = rs.getString("bo.fname")+" "+rs.getString("bo.lname");
                    
                    System.out.println(loanid+bookISBN+cardid+book_title+name+due_date);
                    model1.addRow(new Object[]{loanid,cardid,name,bookISBN,book_title,due_date});
                    
                }
                
                  
                   
                   
                            
                
            }
        } 
        stmt.close();
      //  stmt1.close();
        }catch (SQLException se){
            se.printStackTrace();
        }
        finally{
        ConnUtil.closeConnection(conn);
        
        }
        
        
    }//GEN-LAST:event_Check_bookActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_formWindowClosed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String loan=jTextField1.getText();
                 System.out.println("loan"+loan);
                 loan_id=Integer.parseInt(loan);
                 
        Connection conn=null;
        try {
            conn=ConnUtil.getConnection();
            Statement stmt=conn.createStatement();
            
            ResultSet rs4= stmt.executeQuery("select loan_id,ISBN,card_id,Due_date, datediff(curdate(),Due_date) as diffdate from book_loans where loan_id="+loan_id+";");
            
            while(rs4.next()){
            
                int loanid = rs4.getInt("loan_id");
                System.out.println("loan_id"+loan_id);
                String ISBN=rs4.getString("ISBN");
                String card_id=rs4.getString("card_id");
                Date due_date=rs4.getDate("Due_date");
                System.out.println("Date"+due_date);
               int diffdate= rs4.getInt("diffdate");
                System.out.print(diffdate);
                Statement stmt1=conn.createStatement();
                            if (diffdate>0){
                                
                                String prepare="select paid from fines where loan_id="+loanid+";";
                                //Statement stmt1=conn.createStatement();
                                
                                       
                                ResultSet rs3 = stmt1.executeQuery(prepare);
                                
                                if(rs3.next()==false){
                                
                                     double amount=Math.abs(diffdate)*0.25;
                                    System.out.println("amount"+amount);
                                    stmt1.executeUpdate("insert into fines values("+loanid+","+amount+",0);");
                                    JOptionPane.showMessageDialog(this,"You have some unpaid fine!","Error",JOptionPane.ERROR_MESSAGE);
                                   
                                
                                }
                                else{
                                    rs3.previous();
                                while(rs3.next()){
                                    int paid=rs3.getInt("paid");
                                    if(paid==1){
                                    stmt1.executeUpdate("update book_loans set date_in=curdate() where loan_id="+loanid+";");
                                    stmt1.executeUpdate("update book set Available_count=1 where isbn='"+ISBN+"';");
                                    JOptionPane.showMessageDialog(this, "Checkin Completed", "General", JOptionPane.PLAIN_MESSAGE);
                                   
                                    }
                                    else{
                                    
                                        JOptionPane.showMessageDialog(this,"You have some unpaid fine!","Error",JOptionPane.ERROR_MESSAGE);
                                    
                                    }
                                    }
                                    
                                    rs3.close();
                                
                                }
                            }
                            else{
                                stmt1.executeUpdate("update book_loans set date_in=curdate() where loan_id="+loanid+";");
                                    stmt1.executeUpdate("update book set Available_count=1 where isbn='"+ISBN+"';");
                                    JOptionPane.showMessageDialog(this, "Checkin Completed", "General", JOptionPane.PLAIN_MESSAGE);
                                }
                            
                        }
            // rs4.close();
                       // rs2.close();
                    
            
            stmt.close();
           
            } catch (SQLException ex) {
            Logger.getLogger(CheckIn.class.getName()).log(Level.SEVERE, null, ex);
        
            }
            
            
        
        
        finally{
        ConnUtil.closeConnection(conn);
        
        }
         
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    
    
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
            java.util.logging.Logger.getLogger(CheckIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CheckIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CheckIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CheckIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CheckIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Check_book;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField search;
    // End of variables declaration//GEN-END:variables
}