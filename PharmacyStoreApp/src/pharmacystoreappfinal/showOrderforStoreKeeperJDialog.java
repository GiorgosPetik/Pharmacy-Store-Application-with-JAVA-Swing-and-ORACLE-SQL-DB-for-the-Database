package pharmacystoreappfinal;

import java.sql.*;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author papazoglou,petikopoulos
 */
public class showOrderforStoreKeeperJDialog extends javax.swing.JDialog {

    /**
     * Creates new form showOrderforStoreKeeperJDialog
     */
    public showOrderforStoreKeeperJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    //shows a message 
    public void prepareOrder(){
        
        showMessageDialog(this, "Οι μηχανές ετοιμάζουν την/τις παραγγελία/ες!!!");
    }
    
    //loads the orders from the database and shows it in the table
    public void loadOrder() {
        clearTable( (DefaultTableModel) jOrderTable.getModel() );
        
        String query="SELECT ORDERID, SELLERID, CLIENTID, PRODUCTNAME, QUANTITY, ORDERSUM " 
                   + " FROM ORDERS"
                   + " ORDER BY ORDERID" ;
        //System.out.println("Query:\t" + query);

        Statement searchStatement; 
        ResultSet searchRS;
        try {
            searchStatement= pharmacyStoreJFrame.getCon().createStatement(java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE, java.sql.ResultSet.CONCUR_READ_ONLY);
            searchRS=searchStatement.executeQuery(query);
            while (searchRS.next()) {
                String ORDERID=searchRS.getString("ORDERID");
                String SELLERID=searchRS.getString("SELLERID");
                String CLIENTID=searchRS.getString("CLIENTID");
                String PRODUCTNAME=searchRS.getString("PRODUCTNAME");
                String QUANTITY=searchRS.getString("QUANTITY");
                String ORDERSUM=searchRS.getString("ORDERSUM");
               
                
                
                DefaultTableModel model=(DefaultTableModel)jOrderTable.getModel();
                model.addRow(
                    new Object[] {ORDERID,SELLERID,CLIENTID,PRODUCTNAME,QUANTITY,ORDERSUM}
                );
                
                
            }
            
            if (searchRS.first()) {
                jOrderTable.changeSelection(0, 0, false, false);
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
        jOrderTable = new javax.swing.JTable();
        jButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jOrderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order ID", "Seller ID", "Client ID", "Product name", "Product quantity", "Total pirce"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jOrderTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jOrderTableMouseClicked(evt);
            }
        });
        jOrderTable.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jOrderTableComponentShown(evt);
            }
        });
        jScrollPane5.setViewportView(jOrderTable);

        jButton.setText("Εμφάνιση");
        jButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActionPerformed(evt);
            }
        });

        jButton2.setText("Ετοιμασία Παραγγελίών");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(136, 136, 136))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jOrderTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jOrderTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jOrderTableMouseClicked

    private void jOrderTableComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jOrderTableComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_jOrderTableComponentShown

    private void jButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActionPerformed
        // TODO add your handling code here:
        loadOrder();
    }//GEN-LAST:event_jButtonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        prepareOrder();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(showOrderforStoreKeeperJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(showOrderforStoreKeeperJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(showOrderforStoreKeeperJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(showOrderforStoreKeeperJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                showOrderforStoreKeeperJDialog dialog = new showOrderforStoreKeeperJDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton2;
    private javax.swing.JTable jOrderTable;
    private javax.swing.JScrollPane jScrollPane5;
    // End of variables declaration//GEN-END:variables
}
