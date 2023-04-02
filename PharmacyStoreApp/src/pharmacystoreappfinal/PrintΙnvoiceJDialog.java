package pharmacystoreappfinal;

import java.sql.*;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Papazoglou,petikopoulos
 */
public class PrintΙnvoiceJDialog extends javax.swing.JDialog {

    
    public PrintΙnvoiceJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    //loads infomation from database and shows it in the table
    public void loadInvoice() {
        clearTable( (DefaultTableModel) jInvoiceTable.getModel() );
        
        String query="SELECT CLIENT.CUSTOMERLASTNAME, ORDERS.ORDERID, SUM(ORDERS.ORDERSUM) AS ORDERSUM " 
                   + " FROM CLIENT,ORDERS"
                   + " WHERE CLIENT.CLIENTID = ORDERS.CLIENTID"
                   + " GROUP BY ORDERID, CUSTOMERLASTNAME" ;
        //System.out.println("Query:\t" + query);

        Statement searchStatement; 
        ResultSet searchRS;
        try {
            searchStatement= pharmacyStoreJFrame.getCon().createStatement(java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE, java.sql.ResultSet.CONCUR_READ_ONLY);
            searchRS=searchStatement.executeQuery(query);
            while (searchRS.next()) {
                String CUSTOMERLASTNAME=searchRS.getString("CUSTOMERLASTNAME");
                String ORDERID=searchRS.getString("ORDERID");
                String ORDERSUM=searchRS.getString("ORDERSUM");
                
               
                
                
                DefaultTableModel model=(DefaultTableModel)jInvoiceTable.getModel();
                model.addRow(
                    new Object[] {CUSTOMERLASTNAME,ORDERID,ORDERSUM}
                );
                
                
            }
            
            if (searchRS.first()) {
                jInvoiceTable.changeSelection(0, 0, false, false);
            }
            
            searchRS.close();
            searchStatement.close();
        }
        catch (SQLException ex) {
            showMessageDialog(this, ex.getMessage());        
        }
        
    }
    /**
     * Σβησιμο των γραμμων του Model του πινακα
     * @param model 
     */
    public void clearTable(DefaultTableModel model) {
        int numrows=model.getRowCount();
        for (int i=numrows -1; i>=0; i--) {
            model.removeRow(i);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane5 = new javax.swing.JScrollPane();
        jInvoiceTable = new javax.swing.JTable();
        jButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jInvoiceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Client Name", "Order ID", "Total Price", "Paid"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jInvoiceTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jInvoiceTableMouseClicked(evt);
            }
        });
        jInvoiceTable.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jInvoiceTableComponentShown(evt);
            }
        });
        jScrollPane5.setViewportView(jInvoiceTable);

        jButton.setText("Προβολή");
        jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(201, Short.MAX_VALUE)
                .addComponent(jButton)
                .addGap(165, 165, 165))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jInvoiceTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jInvoiceTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jInvoiceTableMouseClicked

    private void jInvoiceTableComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jInvoiceTableComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_jInvoiceTableComponentShown

    private void jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActionPerformed
        // TODO add your handling code here:
        loadInvoice();
    }//GEN-LAST:event_jButtonActionPerformed

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
            java.util.logging.Logger.getLogger(PrintΙnvoiceJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrintΙnvoiceJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrintΙnvoiceJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrintΙnvoiceJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PrintΙnvoiceJDialog dialog = new PrintΙnvoiceJDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton;
    private javax.swing.JTable jInvoiceTable;
    private javax.swing.JScrollPane jScrollPane5;
    // End of variables declaration//GEN-END:variables
}
