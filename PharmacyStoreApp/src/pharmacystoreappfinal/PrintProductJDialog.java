package pharmacystoreappfinal;

import java.sql.*;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Papazoglou, Petikopoulos
 */
public class PrintProductJDialog extends javax.swing.JDialog {

    
    public PrintProductJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    //loads the product from the database and shows it in the table
    public void loadProduct() {
        clearTable( (DefaultTableModel) jProductTable.getModel() );
        
        String query="SELECT PRODUCTID, NAME, QUANTITY, QUALITY, PRICE, SELLPRICE, EXPIREDATE, SUPPLIER " 
                   + " FROM PRODUCT"
                   + " ORDER BY PRODUCTID" ;
        //System.out.println("Query:\t" + query);

        Statement searchStatement; 
        ResultSet searchRS;
        try {
            searchStatement= pharmacyStoreJFrame.getCon().createStatement(java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE, java.sql.ResultSet.CONCUR_READ_ONLY);
            searchRS=searchStatement.executeQuery(query);
            while (searchRS.next()) {
                String PRODUCTID=searchRS.getString("PRODUCTID");
                String NAME=searchRS.getString("NAME");
                String QUANTITY=searchRS.getString("QUANTITY");
                String QUALITY=searchRS.getString("QUALITY");
                String PRICE=searchRS.getString("PRICE");
                String SELLPRICE=searchRS.getString("SELLPRICE");
                String EXPIREDATE=searchRS.getString("EXPIREDATE");
                String SUPPLIER=searchRS.getString("SUPPLIER");
                
                DefaultTableModel model=(DefaultTableModel)jProductTable.getModel();
                model.addRow(
                    new Object[] {PRODUCTID,NAME,QUANTITY,QUALITY,PRICE,SELLPRICE,EXPIREDATE,SUPPLIER}
                );
                
                
            }
            
            if (searchRS.first()) {
                jProductTable.changeSelection(0, 0, false, false);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jProductTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jProductTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "productID", "name", "quantity", "quality", "cost", "sellPrice", "expireDate", "supplier"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jProductTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jProductTableMouseClicked(evt);
            }
        });
        jProductTable.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jProductTableComponentShown(evt);
            }
        });
        jScrollPane1.setViewportView(jProductTable);

        jButton1.setText("Εμφάνιση");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(256, 256, 256))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jProductTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jProductTableMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jProductTableMouseClicked

    private void jProductTableComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jProductTableComponentShown
        // TODO add your handling code here:
         
    }//GEN-LAST:event_jProductTableComponentShown

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        loadProduct();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(PrintProductJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrintProductJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrintProductJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrintProductJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PrintProductJDialog dialog = new PrintProductJDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JTable jProductTable;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
