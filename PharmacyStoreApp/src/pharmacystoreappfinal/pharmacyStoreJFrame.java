package pharmacystoreappfinal;

import java.sql.*;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.*;  


/**
 *
 * @author Papazoglou, Petikopoulos
 */

public class pharmacyStoreJFrame extends javax.swing.JFrame {
    
    public static Connection con;
    public String selectEmpID = null;
    public int checker;
    int cnt = 1;

    public String getSelectEmpID() {
        return selectEmpID;
    }

    public void setSelectEmpID(String selectEmpID) {
        this.selectEmpID = selectEmpID;
    }
    
    public int getChecker() {
        return checker;
    }

    public void setChecker(int checker) {
        this.checker = checker;
    }
    
    
    
    
    /**
     * Creates new form pharmacyStoreJFrame
     */
    
     public pharmacyStoreJFrame() {
        con = null;
        initComponents();
        
    }
     
    
    
     //Creates connection with the database
    public static Connection getCon() {
        return con;
    }
    
    //connects the program with database
    public void connectAction(){                                                                                 //Creates the connection
        try{                                                                                                     // with the database
            Class.forName("oracle.jdbc.driver.OracleDriver");                                                    
            con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "Maives", "1234");    //Change with your own information
        }
        catch (ClassNotFoundException | SQLException ex) {
                  showMessageDialog(this, ex.getMessage());
            }
        }
    //makes visual logout from the system 
    public void Logout(){
        jStorekeeperMenu.setEnabled(false);
        jSellerMenu.setEnabled(false);
        jCourierMenu.setEnabled(false);
        jAcountantMenu.setEnabled(false);
        showMessageDialog(this, "Επιτυχής Αποσύνδεση!!!");
        jCreateAccMenuItem.setEnabled(true);
        jLoginMenuItem.setEnabled(true);
        
        
    }
    //checks if the password and username are in database and if they are correct and checks the speciality of the employee and opens the right window
    public int checkLogIn(){
        
        Statement selectStmt = null;
        boolean trueUserName = false;
        boolean truePassWord = false;
        
        try {
            selectStmt = pharmacyStoreJFrame.getCon().createStatement();
            ResultSet rsUsername = selectStmt.executeQuery("SELECT USERNAME FROM EMPLOYEE");
            
            while (rsUsername.next()) {
                if (jUserNameLogInTxt.getText().equals(rsUsername.getString(cnt))){
                    trueUserName =true;
                    ResultSet rsPassword = selectStmt.executeQuery("SELECT PASSWORD FROM EMPLOYEE");
                    while (rsPassword.next()){
                    if (jPasswordFieldTxt.getText().equals(rsPassword.getString(cnt))){
                        truePassWord = true;
                        }
                    }
                    
                }
                if (trueUserName && truePassWord){
                    String query="SELECT SPECIALITY " +
                " FROM EMPLOYEE "+
                " WHERE USERNAME = "+jUserNameLogInTxt.getText()+""+
                " AND PASSWORD = "+jPasswordFieldTxt.getText()+"";
                    //System.out.println(query);
                    ResultSet rsSpeciality = selectStmt.executeQuery(query);
                    
                    
                    
                    while (rsSpeciality.next()){
                    if (rsSpeciality.getString(cnt).equals("Αποθηκάριος")){
                        jLoginDialog.setVisible(false);
                        jLogoutMenuItem.setEnabled(true);
                        jCreateAccMenuItem.setEnabled(false);
                        jLoginMenuItem.setEnabled(false);
                        
                        
                        return 1;
                    }
                    else if (rsSpeciality.getString(cnt).equals("Πωλητής")){
                        
                        jLoginDialog.setVisible(false);
                        jLogoutMenuItem.setEnabled(true);
                        jCreateAccMenuItem.setEnabled(false);
                        jLoginMenuItem.setEnabled(false);
                        
                        
                        return 2;
                    }
                    else if (rsSpeciality.getString(cnt).equals("Διανομέας")){                      
                        jLoginDialog.setVisible(false);
                        jLogoutMenuItem.setEnabled(true);
                        jCreateAccMenuItem.setEnabled(false);
                        jLoginMenuItem.setEnabled(false);
                        
                        return 3;
                        
                    }
                    else if (rsSpeciality.getString(cnt).equals("Λογιστής")){                       
                        
                        jLoginDialog.setVisible(false);
                        jLogoutMenuItem.setEnabled(true);
                        jCreateAccMenuItem.setEnabled(false);
                        jLoginMenuItem.setEnabled(false);
                        
                        return 4;
                    }
                } 
            }
                
        }
            
            //cnt++;
        } catch (SQLException ex) {
            showMessageDialog(this, ex.getMessage());
        }
        return 0;
    }
  
    //creates an employee from a form and makes an account
    public void createEmployeeAction(){
        String query="INSERT INTO EMPLOYEE(EMPID,USERNAME,PASSWORD,FIRSTNAME,LASTNAME,SPECIALITY) VALUES(" + empIdCnt() +",'"+jUsernameTxt.getText()+"','"+jPasswordTxt.getText()+"','"+jFirstNameTxt.getText()+"','"+jLastNameTxt.getText()+"','"+jSpecialityBox.getSelectedItem().toString()+"')";
        //System.out.println("Query:\t" + query);
        Statement insertStatement; 
        jUsernameTxt.setText("");
        jPasswordTxt.setText("");
        jFirstNameTxt.setText("");
        jLastNameTxt.setText("");
        
        try {
            insertStatement= pharmacyStoreJFrame.getCon().createStatement();
            insertStatement.executeUpdate(query);
            insertStatement.close();
        } 
        catch (SQLException ex) {
            showMessageDialog(this, ex.getMessage());        
        }       
    }
      //makes automatic id for employee creation
      public int empIdCnt() {
        
        Statement selectStmt = null;
        int cnt = 0;

        try {
            selectStmt = pharmacyStoreJFrame.getCon().createStatement();
            ResultSet rs = selectStmt.executeQuery("SELECT MAX(EMPID) FROM EMPLOYEE");
            
            
            while (rs.next()) {
                    selectEmpID = rs.getString(1);
                      
                }
            
            if (selectEmpID == null) {
                selectEmpID = "1";
                cnt = Integer.parseInt(selectEmpID.trim());
                return cnt;
            }
            
            
        } catch (SQLException ex) {
            showMessageDialog(this, ex.getMessage());
        }
        
        cnt = Integer.parseInt(selectEmpID.trim());
        return ++cnt;
    }
    
   
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLoginDialog = new javax.swing.JDialog();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jUserNameLogInTxt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPasswordFieldTxt = new javax.swing.JPasswordField();
        jCreateDialog = new javax.swing.JDialog();
        jCreateBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jUsernameTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPasswordTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jSpecialityBox = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jFirstNameTxt = new javax.swing.JTextField();
        jLastNameTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jMenuBar = new javax.swing.JMenuBar();
        jAccountMenu = new javax.swing.JMenu();
        jLoginMenuItem = new javax.swing.JMenuItem();
        jCreateAccMenuItem = new javax.swing.JMenuItem();
        jLogoutMenuItem = new javax.swing.JMenuItem();
        jStorekeeperMenu = new javax.swing.JMenu();
        jAddProductMenuItem = new javax.swing.JMenuItem();
        jEditProductMenuItem = new javax.swing.JMenuItem();
        jPrintProductMenuItem = new javax.swing.JMenuItem();
        jDeleteProductMenuItem = new javax.swing.JMenuItem();
        jShowOrderMenuItem = new javax.swing.JMenuItem();
        jSellerMenu = new javax.swing.JMenu();
        jClienteleCreationMenuItem = new javax.swing.JMenuItem();
        jOrderCreationMenuItem = new javax.swing.JMenuItem();
        jPrintClienteleMenuItem = new javax.swing.JMenuItem();
        jPrintOrderMenuItem = new javax.swing.JMenuItem();
        jCourierMenu = new javax.swing.JMenu();
        jConfirmOrderMenuItem = new javax.swing.JMenuItem();
        jPrintOrdersMenuItem = new javax.swing.JMenuItem();
        jAcountantMenu = new javax.swing.JMenu();
        jPrintTziroMenuItem = new javax.swing.JMenuItem();
        jPrintInvoiceMenuItem = new javax.swing.JMenuItem();

        jLoginDialog.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jLoginDialog.setMinimumSize(new java.awt.Dimension(300, 200));

        jButton2.setText("Είσοδος");
        jButton2.setToolTipText("");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel6.setText("Όνομα Χρήστη:");

        jLabel7.setText("Κωδικός:");

        jPasswordFieldTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordFieldTxtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jLoginDialogLayout = new javax.swing.GroupLayout(jLoginDialog.getContentPane());
        jLoginDialog.getContentPane().setLayout(jLoginDialogLayout);
        jLoginDialogLayout.setHorizontalGroup(
            jLoginDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLoginDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLoginDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jLoginDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jUserNameLogInTxt)
                    .addComponent(jPasswordFieldTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jLoginDialogLayout.setVerticalGroup(
            jLoginDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLoginDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLoginDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jUserNameLogInTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jLoginDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jPasswordFieldTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jButton2)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jCreateDialog.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jCreateDialog.setMinimumSize(new java.awt.Dimension(500, 600));

        jCreateBtn.setText("Δημιουργία");
        jCreateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCreateBtnActionPerformed(evt);
            }
        });

        jLabel2.setText("Όνομα");

        jUsernameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jUsernameTxtActionPerformed(evt);
            }
        });

        jLabel3.setText("Κωδικός:");

        jPasswordTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordTxtActionPerformed(evt);
            }
        });

        jLabel1.setText("Ειδικότητα");

        jSpecialityBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Αποθηκάριος", "Πωλητής", "Διανομέας", "Λογιστής" }));

        jLabel15.setText("Όνομα χρήστη:");

        jLabel16.setText("Επώνυμο");

        jFirstNameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFirstNameTxtActionPerformed(evt);
            }
        });

        jLastNameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLastNameTxtActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel4.setText("(έως 8 αριθμούς)");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel5.setText("(έως 8 αριθμούς)");

        javax.swing.GroupLayout jCreateDialogLayout = new javax.swing.GroupLayout(jCreateDialog.getContentPane());
        jCreateDialog.getContentPane().setLayout(jCreateDialogLayout);
        jCreateDialogLayout.setHorizontalGroup(
            jCreateDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jCreateDialogLayout.createSequentialGroup()
                .addGroup(jCreateDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addGroup(jCreateDialogLayout.createSequentialGroup()
                        .addGroup(jCreateDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jCreateDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jCreateDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jCreateDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jCreateDialogLayout.createSequentialGroup()
                                            .addContainerGap()
                                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jCreateDialogLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jCreateDialogLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jCreateDialogLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jCreateDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jFirstNameTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(jSpecialityBox, 0, 193, Short.MAX_VALUE)
                            .addComponent(jUsernameTxt)
                            .addComponent(jLastNameTxt)
                            .addComponent(jPasswordTxt, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCreateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jCreateDialogLayout.setVerticalGroup(
            jCreateDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jCreateDialogLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jCreateDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jFirstNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jCreateDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLastNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jCreateDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jUsernameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(jCreateDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jCreateDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpecialityBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addComponent(jCreateBtn)
                .addGap(15, 15, 15))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jAccountMenu.setText("Λογαριασμός");

        jLoginMenuItem.setText("Είσοδος");
        jLoginMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLoginMenuItemActionPerformed(evt);
            }
        });
        jAccountMenu.add(jLoginMenuItem);

        jCreateAccMenuItem.setText("Δημιουργία");
        jCreateAccMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCreateAccMenuItemActionPerformed(evt);
            }
        });
        jAccountMenu.add(jCreateAccMenuItem);

        jLogoutMenuItem.setText("Αποσύνδεση");
        jLogoutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLogoutMenuItemActionPerformed(evt);
            }
        });
        jAccountMenu.add(jLogoutMenuItem);

        jMenuBar.add(jAccountMenu);

        jStorekeeperMenu.setText("Αποθηκάριος");

        jAddProductMenuItem.setText("Προσθήκη προϊόντος");
        jAddProductMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAddProductMenuItemActionPerformed(evt);
            }
        });
        jStorekeeperMenu.add(jAddProductMenuItem);

        jEditProductMenuItem.setText("Επεξεργασία προϊόντος");
        jEditProductMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEditProductMenuItemActionPerformed(evt);
            }
        });
        jStorekeeperMenu.add(jEditProductMenuItem);

        jPrintProductMenuItem.setText("Εμφάνιση στοιχείων προϊόντος");
        jPrintProductMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPrintProductMenuItemActionPerformed(evt);
            }
        });
        jStorekeeperMenu.add(jPrintProductMenuItem);

        jDeleteProductMenuItem.setText("Διαγραφή προϊόντος");
        jDeleteProductMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDeleteProductMenuItemActionPerformed(evt);
            }
        });
        jStorekeeperMenu.add(jDeleteProductMenuItem);

        jShowOrderMenuItem.setText("Ποβολή Παραγγελιών");
        jShowOrderMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jShowOrderMenuItemActionPerformed(evt);
            }
        });
        jStorekeeperMenu.add(jShowOrderMenuItem);

        jMenuBar.add(jStorekeeperMenu);

        jSellerMenu.setText("Πωλητής");

        jClienteleCreationMenuItem.setText("Δημιουργία Πελατολόγιου");
        jClienteleCreationMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jClienteleCreationMenuItemActionPerformed(evt);
            }
        });
        jSellerMenu.add(jClienteleCreationMenuItem);

        jOrderCreationMenuItem.setText("Δημιουργία Παραγγελίας");
        jOrderCreationMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jOrderCreationMenuItemActionPerformed(evt);
            }
        });
        jSellerMenu.add(jOrderCreationMenuItem);

        jPrintClienteleMenuItem.setText("Προβολή Πελατολόγιου");
        jPrintClienteleMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPrintClienteleMenuItemActionPerformed(evt);
            }
        });
        jSellerMenu.add(jPrintClienteleMenuItem);

        jPrintOrderMenuItem.setText("Προβολή Παραγγελιών");
        jPrintOrderMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPrintOrderMenuItemActionPerformed(evt);
            }
        });
        jSellerMenu.add(jPrintOrderMenuItem);

        jMenuBar.add(jSellerMenu);

        jCourierMenu.setText("Διανομέας");

        jConfirmOrderMenuItem.setText("Επιβεβαίωση Παράδωσης");
        jConfirmOrderMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jConfirmOrderMenuItemActionPerformed(evt);
            }
        });
        jCourierMenu.add(jConfirmOrderMenuItem);

        jPrintOrdersMenuItem.setText("Προβολή Παραγγελιών");
        jPrintOrdersMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPrintOrdersMenuItemActionPerformed(evt);
            }
        });
        jCourierMenu.add(jPrintOrdersMenuItem);

        jMenuBar.add(jCourierMenu);

        jAcountantMenu.setText("Λογιστής");

        jPrintTziroMenuItem.setText("Προβολή Τζίρου");
        jPrintTziroMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPrintTziroMenuItemActionPerformed(evt);
            }
        });
        jAcountantMenu.add(jPrintTziroMenuItem);

        jPrintInvoiceMenuItem.setText("Προβολή Τιμολογίων");
        jPrintInvoiceMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPrintInvoiceMenuItemActionPerformed(evt);
            }
        });
        jAcountantMenu.add(jPrintInvoiceMenuItem);

        jMenuBar.add(jAcountantMenu);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 402, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 308, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCreateAccMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCreateAccMenuItemActionPerformed
        // TODO add your handling code here:
        //myUserCreation.setVisible(true);
        jCreateDialog.setVisible(true);
    }//GEN-LAST:event_jCreateAccMenuItemActionPerformed

    private void jLoginMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLoginMenuItemActionPerformed
        // TODO add your handling code here:
        //myLogIn.setVisible(true);
        jLoginDialog.setVisible(true);
        
        
    }//GEN-LAST:event_jLoginMenuItemActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        jStorekeeperMenu.setEnabled(false);
        jSellerMenu.setEnabled(false);
        jCourierMenu.setEnabled(false);
        jAcountantMenu.setEnabled(false);
        jLogoutMenuItem.setEnabled(false);
    }//GEN-LAST:event_formComponentShown

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        checkLogIn();
        setChecker(checkLogIn());
        if (getChecker()==1)   jStorekeeperMenu.setEnabled(true); 
        else if (getChecker()==2)   jSellerMenu.setEnabled(true);
        else if (getChecker()==3)   jCourierMenu.setEnabled(true);
        else if (getChecker()==4)   jAcountantMenu.setEnabled(true);
        
        

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jPasswordFieldTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordFieldTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordFieldTxtActionPerformed

    private void jCreateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCreateBtnActionPerformed
        createEmployeeAction();
        jCreateDialog.setVisible(false);

    }//GEN-LAST:event_jCreateBtnActionPerformed

    private void jUsernameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jUsernameTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jUsernameTxtActionPerformed

    private void jPasswordTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordTxtActionPerformed

    private void jFirstNameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFirstNameTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFirstNameTxtActionPerformed

    private void jLastNameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLastNameTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLastNameTxtActionPerformed

    private void jAddProductMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAddProductMenuItemActionPerformed
        // TODO add your handling code here:
        AddNewProductJDialog pDlg = new AddNewProductJDialog(this, true);
        pDlg.setVisible(true);
        
    }//GEN-LAST:event_jAddProductMenuItemActionPerformed

    private void jLogoutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLogoutMenuItemActionPerformed
        // TODO add your handling code here:
        Logout();
        jLogoutMenuItem.setEnabled(false);
    }//GEN-LAST:event_jLogoutMenuItemActionPerformed

    private void jEditProductMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEditProductMenuItemActionPerformed
        // TODO add your handling code here:
        EditProductJDialog eDlg = new EditProductJDialog(this, true);
        eDlg.setVisible(true);
    }//GEN-LAST:event_jEditProductMenuItemActionPerformed

    private void jPrintProductMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPrintProductMenuItemActionPerformed
        // TODO add your handling code here:
        PrintProductJDialog prDlg = new PrintProductJDialog(this, true);
        prDlg.setVisible(true);
    }//GEN-LAST:event_jPrintProductMenuItemActionPerformed

    private void jDeleteProductMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDeleteProductMenuItemActionPerformed
        // TODO add your handling code here:
        DeleteProductJDialog dDlg = new DeleteProductJDialog(this, true);
        dDlg.setVisible(true);
    }//GEN-LAST:event_jDeleteProductMenuItemActionPerformed

    private void jClienteleCreationMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jClienteleCreationMenuItemActionPerformed
        // TODO add your handling code here:
        ClienteleCreationJDialog CCDlg = new ClienteleCreationJDialog(this, true);
        CCDlg.setVisible(true);
    }//GEN-LAST:event_jClienteleCreationMenuItemActionPerformed

    private void jPrintClienteleMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPrintClienteleMenuItemActionPerformed
        // TODO add your handling code here:
        PrintClienteleJDialog PCDlg = new PrintClienteleJDialog(this, true);
        PCDlg.setVisible(true);
    }//GEN-LAST:event_jPrintClienteleMenuItemActionPerformed

    private void jOrderCreationMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jOrderCreationMenuItemActionPerformed
        // TODO add your handling code here:
        OrderCreationJDialog OCDlg = new OrderCreationJDialog(this, true);
        OCDlg.setVisible(true);
        
    }//GEN-LAST:event_jOrderCreationMenuItemActionPerformed

    private void jPrintOrderMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPrintOrderMenuItemActionPerformed
        // TODO add your handling code here:
        PrintOrderJDialog PoDlg = new PrintOrderJDialog(this, true);
        PoDlg.setVisible(true);
    }//GEN-LAST:event_jPrintOrderMenuItemActionPerformed

    private void jConfirmOrderMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jConfirmOrderMenuItemActionPerformed
        // TODO add your handling code here:
        ConfirmOrderJDialog CoDlg = new ConfirmOrderJDialog(this, true);
        CoDlg.setVisible(true);
    }//GEN-LAST:event_jConfirmOrderMenuItemActionPerformed

    private void jPrintTziroMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPrintTziroMenuItemActionPerformed
        // TODO add your handling code here
        PrintTziroJDialog PtDlg = new PrintTziroJDialog(this, true);
        PtDlg.setVisible(true);
        
    }//GEN-LAST:event_jPrintTziroMenuItemActionPerformed

    private void jPrintInvoiceMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPrintInvoiceMenuItemActionPerformed
        // TODO add your handling code here:
        PrintΙnvoiceJDialog PiDlg = new PrintΙnvoiceJDialog(this, true);
        PiDlg.setVisible(true);
    }//GEN-LAST:event_jPrintInvoiceMenuItemActionPerformed

    private void jPrintOrdersMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPrintOrdersMenuItemActionPerformed
        // TODO add your handling code here:
        ShowOrdersJDialog SoDlg = new ShowOrdersJDialog(this, true);
        SoDlg.setVisible(true);
    }//GEN-LAST:event_jPrintOrdersMenuItemActionPerformed

    private void jShowOrderMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jShowOrderMenuItemActionPerformed
        // TODO add your handling code here:
        showOrderforStoreKeeperJDialog SofSDlg = new showOrderforStoreKeeperJDialog(this, true);
        SofSDlg.setVisible(true);
    }//GEN-LAST:event_jShowOrderMenuItemActionPerformed

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
            java.util.logging.Logger.getLogger(pharmacyStoreJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pharmacyStoreJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pharmacyStoreJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pharmacyStoreJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pharmacyStoreJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jAccountMenu;
    private javax.swing.JMenu jAcountantMenu;
    private javax.swing.JMenuItem jAddProductMenuItem;
    private javax.swing.JButton jButton2;
    private javax.swing.JMenuItem jClienteleCreationMenuItem;
    private javax.swing.JMenuItem jConfirmOrderMenuItem;
    private javax.swing.JMenu jCourierMenu;
    private javax.swing.JMenuItem jCreateAccMenuItem;
    private javax.swing.JButton jCreateBtn;
    private javax.swing.JDialog jCreateDialog;
    private javax.swing.JMenuItem jDeleteProductMenuItem;
    private javax.swing.JMenuItem jEditProductMenuItem;
    private javax.swing.JTextField jFirstNameTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jLastNameTxt;
    private javax.swing.JDialog jLoginDialog;
    private javax.swing.JMenuItem jLoginMenuItem;
    private javax.swing.JMenuItem jLogoutMenuItem;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenuItem jOrderCreationMenuItem;
    private javax.swing.JPasswordField jPasswordFieldTxt;
    private javax.swing.JTextField jPasswordTxt;
    private javax.swing.JMenuItem jPrintClienteleMenuItem;
    private javax.swing.JMenuItem jPrintInvoiceMenuItem;
    private javax.swing.JMenuItem jPrintOrderMenuItem;
    private javax.swing.JMenuItem jPrintOrdersMenuItem;
    private javax.swing.JMenuItem jPrintProductMenuItem;
    private javax.swing.JMenuItem jPrintTziroMenuItem;
    private javax.swing.JMenu jSellerMenu;
    private javax.swing.JMenuItem jShowOrderMenuItem;
    private javax.swing.JComboBox<String> jSpecialityBox;
    private javax.swing.JMenu jStorekeeperMenu;
    private javax.swing.JTextField jUserNameLogInTxt;
    private javax.swing.JTextField jUsernameTxt;
    // End of variables declaration//GEN-END:variables
}
