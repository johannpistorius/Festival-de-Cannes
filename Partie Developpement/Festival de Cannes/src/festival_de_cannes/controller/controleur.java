package festival_de_cannes.controller;

import festival_de_cannes.view.Page_Principale;

/**
 *
 * @author Alexis
 * @author Johann
 */
public class controleur {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Page_Principale().setVisible(true);
            }
        });
    }
    
}
