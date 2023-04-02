package pharmacystoreappfinal;

import java.sql.*;
import static javax.swing.JOptionPane.showMessageDialog;
/**
 *
 * @author Papazoglou, Petikopoulos
 */
public class ClienteleCreationJDialog extends javax.swing.JDialog {

    
    public ClienteleCreationJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    
    public void createClienteleAction(){
        String query="INSERT INTO CLIENT(CLIENTID,EMPID,CUSTOMERLASTNAME,ROAD,ADDRESS,CITY,TK) VALUES(" + jclientIdTxt.getText()+","+jEmpIdTxt.getText()+",'"+jCustomersNameTxt.getText()+"','"+jRoadTxt.getText()+"',"+jRoadNumberTxt.getText()+",'"+jCityTxt.getText()+"',"+jTkTxt.getText()+")";
        //System.out.println("Query:\t" + query);
        Statement insertStatement;
        
        jclientIdTxt.setText("");
        jEmpIdTxt.setText("");
        jCustomersNameTxt.setText("");
        jRoadTxt.setText("");
        jRoadNumberTxt.setText("");
        jCityTxt.setText("");
        jTkTxt.setText("");
        
        try {
            insertStatement= pharmacyStoreJFrame.getCon().createStatement();
            insertStatement.executeUpdate(query);
            insertStatement.close();
        } 
        catch (SQLException ex) {
            showMessageDialog(this, ex.getMessage());        
        }
        
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel17 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jEmpIdTxt = new javax.swing.JTextField();
        jclientIdTxt = new javax.swing.JTextField();
        jRoadTxt = new javax.swing.JTextField();
        jCustomersNameTxt = new javax.swing.JTextField();
        jAddProductBtn1 = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jRoadNumberTxt = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jCityTxt = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jTkTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel17.setText("ID Υπαλλήλου :");

        jLabel23.setText("ID Πελάτη :");

        jLabel24.setText("Όνομα Πελάτη :");

        jLabel25.setText("Διεύθυνση :");

        jRoadTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRoadTxtActionPerformed(evt);
            }
        });

        jAddProductBtn1.setText("Προσθήκη");
        jAddProductBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAddProductBtn1ActionPerformed(evt);
            }
        });

        jLabel27.setText("Αριθμός :");

        jRoadNumberTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRoadNumberTxtActionPerformed(evt);
            }
        });

        jLabel28.setText("Πόλη :");

        jCityTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCityTxtActionPerformed(evt);
            }
        });

        jLabel29.setText("Ταχυδρομικός Κώδικας :");

        jTkTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTkTxtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                                .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jRoadTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jCustomersNameTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jEmpIdTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jclientIdTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel27)
                            .addGap(136, 136, 136)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jRoadNumberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(79, 79, 79)
                                    .addComponent(jAddProductBtn1))
                                .addComponent(jCityTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTkTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel28))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jclientIdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jEmpIdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCustomersNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRoadTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRoadNumberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(jCityTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel29)
                    .addComponent(jTkTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(jAddProductBtn1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRoadTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRoadTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRoadTxtActionPerformed

    private void jAddProductBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAddProductBtn1ActionPerformed
        // TODO add your handling code here:
        createClienteleAction();
    }//GEN-LAST:event_jAddProductBtn1ActionPerformed

    private void jRoadNumberTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRoadNumberTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRoadNumberTxtActionPerformed

    private void jCityTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCityTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCityTxtActionPerformed

    private void jTkTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTkTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTkTxtActionPerformed

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
            java.util.logging.Logger.getLogger(ClienteleCreationJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteleCreationJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteleCreationJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteleCreationJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ClienteleCreationJDialog dialog = new ClienteleCreationJDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jAddProductBtn1;
    private javax.swing.JTextField jCityTxt;
    private javax.swing.JTextField jCustomersNameTxt;
    private javax.swing.JTextField jEmpIdTxt;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JTextField jRoadNumberTxt;
    private javax.swing.JTextField jRoadTxt;
    private javax.swing.JTextField jTkTxt;
    private javax.swing.JTextField jclientIdTxt;
    // End of variables declaration//GEN-END:variables
}
