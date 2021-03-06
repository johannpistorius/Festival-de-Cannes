package festival_de_cannes.view;

/**
 *
 * @author Alexis
 * @author Johann
 */
public class Page_Supprimer extends javax.swing.JFrame {

    /**
     * Creates new form Page_Supprimer
     */
    private Page_Principale parent;
    
    public Page_Supprimer(Page_Principale parent) {
        initComponents();
        this.parent = parent; 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        l_message = new javax.swing.JLabel();
        b_Oui = new javax.swing.JButton();
        b_annuler = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Supprimer une projection");

        l_message.setText("Voulez-vous vraiment supprimer cette projection ?");

        b_Oui.setText("Oui");
        b_Oui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_OuiActionPerformed(evt);
            }
        });

        b_annuler.setText("Annuler");
        b_annuler.setToolTipText("");
        b_annuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_annulerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(l_message)
                        .addContainerGap(66, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(b_Oui)
                        .addGap(18, 18, 18)
                        .addComponent(b_annuler)
                        .addGap(43, 43, 43))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(l_message)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_annuler)
                    .addComponent(b_Oui))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b_OuiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_OuiActionPerformed
        parent.supprimerProjection();
        this.dispose();
    }//GEN-LAST:event_b_OuiActionPerformed

    private void b_annulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_annulerActionPerformed
        this.dispose();
    }//GEN-LAST:event_b_annulerActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_Oui;
    private javax.swing.JButton b_annuler;
    private javax.swing.JLabel l_message;
    // End of variables declaration//GEN-END:variables
}
