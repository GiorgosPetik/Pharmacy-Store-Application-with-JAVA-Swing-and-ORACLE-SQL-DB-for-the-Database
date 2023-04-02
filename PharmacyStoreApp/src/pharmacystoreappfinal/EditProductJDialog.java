package pharmacystoreappfinal;

import java.sql.*;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Papazoglou, Petikopoulos
 */
public class EditProductJDialog extends javax.swing.JDialog {

    /**
     * Creates new form EditProductJDialog
     */
    public EditProductJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    //the user can edit the product valus by typing the name of the product(the user writes the new values in the textfields)
    public void updateProductAction() {
        String query="UPDATE PRODUCT " +
                " SET QUANTITY="+jChangeMinValueTxt.getText()+","+
                " QUALITY='"+jQualityBox.getSelectedItem().toString()+"',"+
                " PRICE="+jCostValueTxt.getText()+","+
                " SELLPRICE="+jSellValueTxt.getText()+","+
                " EXPIREDATE=TO_DATE('"+jExpireDateTxt.getText()+"','DD/MM/YYYY')," +
                " SUPPLIER='"+jSupplierTxt.getText()+"'"+
                " WHERE NAME='" + jProductNameTxt.getText()+"'";
        
        //System.out.println("Query:\t" + query);
        Statement updateStatement; 
        
        
        jCostValueTxt.setText("");
        jSellValueTxt.setText("");
        jExpireDateTxt.setText("");
        jSupplierTxt.setText("");
        jProductNameTxt.setText("");
        jChangeMinValueTxt.setText("");
        
        
        try {
            updateStatement= pharmacyStoreJFrame.con.createStatement();
            updateStatement.executeUpdate(query);
            updateStatement.close();
        } 
        catch (SQLException ex) {
            showMessageDialog(this, ex.getMessage());        
        }
    }
    
    public void loadProduct() {
        clearTable( (DefaultTableModel) jProductTable.getModel() );
        
        String query="SELECT PRODUCTID, NAME, QUANTITY, QUALITY, PRICE, SELLPRICE, TO_CHAR(EXPIREDATE,'DD/MM/YYYY') AS MR, SUPPLIER " 
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
                String EXPIREDATE=searchRS.getString("MR");
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
    
   
    public void productTableMouseClickedAction() {
        jProductNameTxt.setText(""+jProductTable.getModel().getValueAt(jProductTable.getSelectedRow(), 1));
        jExpireDateTxt.setText(""+jProductTable.getModel().getValueAt(jProductTable.getSelectedRow(), 6));
        jCostValueTxt.setText(""+jProductTable.getModel().getValueAt(jProductTable.getSelectedRow(), 4));
        jSellValueTxt.setText(""+jProductTable.getModel().getValueAt(jProductTable.getSelectedRow(), 5));
        jChangeMinValueTxt.setText(""+jProductTable.getModel().getValueAt(jProductTable.getSelectedRow(), 2));
        jSupplierTxt.setText(""+jProductTable.getModel().getValueAt(jProductTable.getSelectedRow(), 7));
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel17 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jExpireDateTxt = new javax.swing.JTextField();
        jProductNameTxt = new javax.swing.JTextField();
        jSellValueTxt = new javax.swing.JTextField();
        jCostValueTxt = new javax.swing.JTextField();
        jQualityBox = new javax.swing.JComboBox<>();
        jAddProductBtn = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jChangeMinValueTxt = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jSupplierTxt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jProductTable = new javax.swing.JTable();
        jRefreshButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jLabel17.setText("Ημερομηνία λήξης:");

        jLabel23.setText("Όνομα προϊόντος:");

        jLabel24.setText("Κόστος αγοράς:");

        jLabel25.setText("Τιμή πώλησης:");

        jLabel26.setText("Ποιότητα:");

        jSellValueTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSellValueTxtActionPerformed(evt);
            }
        });

        jQualityBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Πραγματικό Φάρμακο", "Φασόν" }));
        jQualityBox.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jQualityBoxComponentShown(evt);
            }
        });

        jAddProductBtn.setText("Ολοκλήρωση");
        jAddProductBtn.setActionCommand("");
        jAddProductBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAddProductBtnActionPerformed(evt);
            }
        });

        jLabel27.setText("Εισαγωγή κατώτατου ορίου:");

        jChangeMinValueTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChangeMinValueTxtActionPerformed(evt);
            }
        });

        jLabel28.setText("Όνομα προμηθευτή:");

        jSupplierTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSupplierTxtActionPerformed(evt);
            }
        });

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

        jRefreshButton.setText("Ανανέωση");
        jRefreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRefreshButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel1.setText("(DD/MM/YYYY)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                                .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jProductNameTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jExpireDateTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jCostValueTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jSellValueTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel27)
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(79, 79, 79)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jAddProductBtn)
                                        .addComponent(jQualityBox, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jSupplierTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(1, 1, 1))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jChangeMinValueTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jLabel28)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
                        .addGap(7, 7, 7))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jRefreshButton)
                        .addGap(238, 238, 238))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel23)
                            .addComponent(jProductNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(jExpireDateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCostValueTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSellValueTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jChangeMinValueTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(jSupplierTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jQualityBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRefreshButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43)
                .addComponent(jAddProductBtn)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jSellValueTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSellValueTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jSellValueTxtActionPerformed

    private void jAddProductBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAddProductBtnActionPerformed
        // TODO add your handling code here:
        updateProductAction();
    }//GEN-LAST:event_jAddProductBtnActionPerformed

    private void jChangeMinValueTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChangeMinValueTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jChangeMinValueTxtActionPerformed

    private void jSupplierTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSupplierTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jSupplierTxtActionPerformed

    private void jProductTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jProductTableMouseClicked
        // TODO add your handling code here:
        productTableMouseClickedAction();

    }//GEN-LAST:event_jProductTableMouseClicked

    private void jProductTableComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jProductTableComponentShown
        // TODO add your handling code here:

    }//GEN-LAST:event_jProductTableComponentShown

    private void jRefreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRefreshButtonActionPerformed
        // TODO add your handling code here:
        loadProduct();
    }//GEN-LAST:event_jRefreshButtonActionPerformed

    private void jQualityBoxComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jQualityBoxComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_jQualityBoxComponentShown

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        loadProduct();
        productTableMouseClickedAction();
    }//GEN-LAST:event_formComponentShown

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
            java.util.logging.Logger.getLogger(EditProductJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditProductJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditProductJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditProductJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EditProductJDialog dialog = new EditProductJDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jAddProductBtn;
    private javax.swing.JTextField jChangeMinValueTxt;
    private javax.swing.JTextField jCostValueTxt;
    private javax.swing.JTextField jExpireDateTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JTextField jProductNameTxt;
    private javax.swing.JTable jProductTable;
    private javax.swing.JComboBox<String> jQualityBox;
    private javax.swing.JButton jRefreshButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jSellValueTxt;
    private javax.swing.JTextField jSupplierTxt;
    // End of variables declaration//GEN-END:variables
}
