package pharmacystoreappfinal;

import java.sql.*;
import static javax.swing.JOptionPane.showMessageDialog;
/**
 *
 * @author papazoglou,petikopoulos
 */
public class OrderCreationJDialog extends javax.swing.JDialog {

    
    public OrderCreationJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public void CalculatePrice(){
        
        jLabel1.setText(Double.toString(totalPrice()));
    }

    public double productPrice(){
        double price = 0;
        String query = "SELECT PRICE FROM PRODUCT WHERE NAME='"+jproductnameTxt.getText()+"'";
        //System.out.println("Query:\t" + query);
        Statement selectStatement;
        ResultSet resultSet;
        
        try{
            selectStatement = pharmacyStoreJFrame.getCon().createStatement();
            resultSet = selectStatement.executeQuery(query);
            while(resultSet.next()){
                price = resultSet.getDouble("PRICE");
            }
           
            
        }
        catch (SQLException ex) {
            showMessageDialog(this, ex.getMessage());        
        }
        return price;
    }

    public double totalPrice(){
        
        double quantity = Double.parseDouble(jquantityTxt.getText());
        double price = productPrice();
        double totalPrice = quantity * price;
        return totalPrice;
        
    }
    
    public void createOrderAction(){
        String query="INSERT INTO ORDERS(ORDERID,SELLERID,CLIENTID,PRODUCTNAME,QUANTITY,ORDERSUM) VALUES(" + jorderidTxt.getText()+","+jsellerIdTxt.getText()+","+jclientidTxt.getText()+",'"+jproductnameTxt.getText()+"',"+jquantityTxt.getText()+","+totalPrice()+")";
        //System.out.println("Query:\t" + query);
        Statement insertStatement;
        
        jorderidTxt.setText("");
        jsellerIdTxt.setText("");
        jclientidTxt.setText("");
        jproductnameTxt.setText("");
        jquantityTxt.setText("");
        jLabel1.setText("");
        
        
        
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

        jLabel18 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jsellerIdTxt = new javax.swing.JTextField();
        jorderidTxt = new javax.swing.JTextField();
        jclientidTxt = new javax.swing.JTextField();
        jAddProductBtn = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        jproductnameTxt = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jquantityTxt = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setFocusCycleRoot(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jLabel18.setText("ID Πωλητή :");

        jLabel26.setText("ID Παραγγελίας :");

        jLabel30.setText("ID Πελάτη :");

        jorderidTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jorderidTxtActionPerformed(evt);
            }
        });

        jAddProductBtn.setText("Προσθήκη");
        jAddProductBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAddProductBtnActionPerformed(evt);
            }
        });

        jLabel32.setText("Όνομα προϊόντος :");

        jproductnameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jproductnameTxtActionPerformed(evt);
            }
        });

        jLabel33.setText("Ποσότητα :");

        jquantityTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jquantityTxtActionPerformed(evt);
            }
        });

        jLabel34.setText("Συνολικό ποσό :");

        jButton1.setText("Υπολογισμός");
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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jquantityTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel34)
                                .addGap(179, 179, 179)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                                    .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jorderidTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jsellerIdTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jclientidTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(122, 122, 122)
                                        .addComponent(jButton1)
                                        .addGap(18, 18, 18)
                                        .addComponent(jAddProductBtn)
                                        .addGap(1, 1, 1))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jproductnameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jorderidTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jsellerIdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jclientidTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jproductnameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(jquantityTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel34)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jAddProductBtn)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jAddProductBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAddProductBtnActionPerformed
        // TODO add your handling code here:
        createOrderAction();
    }//GEN-LAST:event_jAddProductBtnActionPerformed

    private void jproductnameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jproductnameTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jproductnameTxtActionPerformed

    private void jquantityTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jquantityTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jquantityTxtActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        CalculatePrice();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jorderidTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jorderidTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jorderidTxtActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        
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
            java.util.logging.Logger.getLogger(OrderCreationJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrderCreationJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrderCreationJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrderCreationJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                OrderCreationJDialog dialog = new OrderCreationJDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JTextField jclientidTxt;
    private javax.swing.JTextField jorderidTxt;
    private javax.swing.JTextField jproductnameTxt;
    private javax.swing.JTextField jquantityTxt;
    private javax.swing.JTextField jsellerIdTxt;
    // End of variables declaration//GEN-END:variables
}
