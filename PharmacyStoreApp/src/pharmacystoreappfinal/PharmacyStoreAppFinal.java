package pharmacystoreappfinal;

/**
 *
 * @author Petikopoulos, Papazoglou
 */

public class PharmacyStoreAppFinal {

    
    public static void main(String[] args) {
        
       pharmacyStoreJFrame pharmacyStoreFrame = new pharmacyStoreJFrame();      //JFrame creation
       new pharmacyStoreJFrame().setVisible(true);
       pharmacyStoreFrame.connectAction();
       
       
       
    }
    
}
