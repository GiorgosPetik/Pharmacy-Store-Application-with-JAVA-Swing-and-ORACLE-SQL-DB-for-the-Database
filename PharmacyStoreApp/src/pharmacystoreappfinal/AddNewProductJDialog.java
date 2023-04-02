package pharmacystoreappfinal;

import java.sql.*;
import static javax.swing.JOptionPane.showMessageDialog;
/**
 *
 * @author papazoglou,petikopoulos
 */
public class AddNewProductJDialog extends javax.swing.JDialog {
    private String selectProductID = null;
    
    public AddNewProductJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
       
    }

    //creates new product 
    public void createProductAction(){
        String query="INSERT INTO PRODUCT(PRODUCTID,NAME,QUANTITY,QUALITY,PRICE,SELLPRICE,EXPIREDATE,SUPPLIER) VALUES(" + productIdCnt() +",'"+jProductNameTxt.getText()+"',"+jChangeMinValueTxt.getText()+",'"+jQualityBox.getSelectedItem().toString()+"',"+jCostValueTxt.getText()+","+jSellValueTxt.getText()+",TO_DATE('"+jExpireDateTxt.getText()+"','DD/MM/YYYY'),'"+jSupplierTxt.getText()+"')";
        //System.out.println("Query:\t" + query);
        Statement insertStatement;
        
        jProductNameTxt.setText("");
        jChangeMinValueTxt.setText("");
        jCostValueTxt.setText("");
        jSellValueTxt.setText("");
        jExpireDateTxt.setText("");
        jSupplierTxt.setText("");
        
        try {
            insertStatement= pharmacyStoreJFrame.getCon().createStatement();
            insertStatement.executeUpdate(query);
            insertStatement.close();
        } 
        catch (SQLException ex) {
            showMessageDialog(this, ex.getMessage());        
        }
        
    }
    
    //makes automatic id for product creation
    public int productIdCnt() {
        
        Statement selectStmt = null;
        int cnt = 0;

        try {
            selectStmt = pharmacyStoreJFrame.getCon().createStatement();
            ResultSet rs = selectStmt.executeQuery("SELECT MAX(PRODUCTID) FROM PRODUCT");
            
            //System.out.println(selectProductID);
            while (rs.next()) {
                    selectProductID = rs.getString(1);
                    //System.out.println(selectProductID);  
                }
            
            if (selectProductID == null) {
                selectProductID = "1";
                cnt = Integer.parseInt(selectProductID.trim());
                return cnt;
            }
            
        } catch (SQLException ex) {
            showMessageDialog(this, ex.getMessage());
        }
        
        cnt = Integer.parseInt(selectProductID.trim());
        return ++cnt;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jExpireDateTxt = new javax.swing.JTextField();
        jProductNameTxt = new javax.swing.JTextField();
        jSellValueTxt = new javax.swing.JTextField();
        jCostValueTxt = new javax.swing.JTextField();
        jQualityBox = new javax.swing.JComboBox<>();
        jAddProductBtn = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jChangeMinValueTxt = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jSupplierTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel15.setText("Ημερομηνία λήξης:");

        jLabel16.setText("Όνομα προϊόντος:");

        jLabel18.setText("Κόστος αγοράς:");

        jLabel19.setText("Τιμή πώλησης:");

        jLabel20.setText("Ποιότητα:");

        jSellValueTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSellValueTxtActionPerformed(evt);
            }
        });

        jQualityBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Πραγματικό Φάρμακο", "Φασόν" }));

        jAddProductBtn.setText("Προσθήκη");
        jAddProductBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAddProductBtnActionPerformed(evt);
            }
        });

        jLabel21.setText("Εισαγωγή κατώτατου ορίου:");

        jChangeMinValueTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChangeMinValueTxtActionPerformed(evt);
            }
        });

        jLabel22.setText("Όνομα προμηθευτή:");

        jSupplierTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSupplierTxtActionPerformed(evt);
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
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(83, 83, 83)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jProductNameTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jExpireDateTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jCostValueTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jSellValueTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel21)
                                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(80, 80, 80)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jChangeMinValueTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jQualityBox, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jSupplierTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel22))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jAddProductBtn, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jProductNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jExpireDateTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSellValueTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jCostValueTxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jChangeMinValueTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jSupplierTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jQualityBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addGap(37, 37, 37)
                .addComponent(jAddProductBtn)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jSellValueTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSellValueTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jSellValueTxtActionPerformed

    private void jAddProductBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAddProductBtnActionPerformed
        // TODO add your handling code here:
        createProductAction();
        
    }//GEN-LAST:event_jAddProductBtnActionPerformed

    private void jChangeMinValueTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChangeMinValueTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jChangeMinValueTxtActionPerformed

    private void jSupplierTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSupplierTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jSupplierTxtActionPerformed

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
            java.util.logging.Logger.getLogger(AddNewProductJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddNewProductJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddNewProductJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddNewProductJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddNewProductJDialog dialog = new AddNewProductJDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JTextField jProductNameTxt;
    private javax.swing.JComboBox<String> jQualityBox;
    private javax.swing.JTextField jSellValueTxt;
    private javax.swing.JTextField jSupplierTxt;
    // End of variables declaration//GEN-END:variables
}
