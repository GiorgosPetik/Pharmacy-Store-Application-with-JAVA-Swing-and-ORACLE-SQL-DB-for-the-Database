
package pharmacystoreappfinal;

import java.sql.*;
import static javax.swing.JOptionPane.showMessageDialog;
/**
 *
 * @author papazoglou,petikopoulos
 */
public class ConfirmOrderJDialog extends javax.swing.JDialog {

    /**
     * Creates new form ConfirmOrderJDialog
     */
    public ConfirmOrderJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public void deleteorderAction() {
            
        String query="DELETE ORDERS WHERE ORDERID='" + jorderidTxt.getText()+"'";
        
        //System.out.println("Query:\t" + query);
        
        Statement deleteStatement;
        jorderidTxt.setText("");
        //showMessageDialog(this, "Επιτυχής Διαγραφή!!!");
        
        
        try {
            deleteStatement= pharmacyStoreJFrame.getCon().createStatement();
            deleteStatement.executeUpdate(query);
            deleteStatement.close();
        } 
        catch (SQLException ex) {
            showMessageDialog(this, ex.getMessage());        
        }
        this.dispose();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel30 = new javax.swing.JLabel();
        jorderidTxt = new javax.swing.JTextField();
        jAddProductBtn2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel30.setText("ID Παραγγελίας :");

        jAddProductBtn2.setText("Παραδόθηκε!");
        jAddProductBtn2.setActionCommand("");
        jAddProductBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAddProductBtn2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel30)
                .addGap(137, 137, 137)
                .addComponent(jorderidTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jAddProductBtn2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addGap(60, 60, 60))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jorderidTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jAddProductBtn2)
                        .addGap(10, 10, 10)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jAddProductBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAddProductBtn2ActionPerformed
        // TODO add your handling code here:
        deleteorderAction();
    }//GEN-LAST:event_jAddProductBtn2ActionPerformed

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
            java.util.logging.Logger.getLogger(ConfirmOrderJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConfirmOrderJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConfirmOrderJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConfirmOrderJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ConfirmOrderJDialog dialog = new ConfirmOrderJDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jAddProductBtn2;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JTextField jorderidTxt;
    // End of variables declaration//GEN-END:variables
}
