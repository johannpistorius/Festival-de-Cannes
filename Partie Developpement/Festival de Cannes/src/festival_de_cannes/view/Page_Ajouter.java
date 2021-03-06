package festival_de_cannes.view;

import festival_de_cannes.model.MariaDbDataSourceDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;


/**
 *
 * @author Alexis
 * @author Johann
 */
public class Page_Ajouter extends javax.swing.JFrame {
    private static DataSource dataSourceDAO=null;
    private static Connection connexionBD=null;
    private Page_Principale parent;

    
    public Page_Ajouter(Page_Principale parent) {
        initComponents();
        this.parent = parent; 
        dataSourceDAO = MariaDbDataSourceDAO.getDataSource();
        try {
            connexionBD=dataSourceDAO.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Page_Principale.class.getName()).log(Level.SEVERE, null, ex);
        }
        remplirListeFilms();
        remplirListeSalles();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cb_films = new javax.swing.JComboBox<>();
        l_titre = new javax.swing.JLabel();
        tf_date = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tf_heure = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cb_salles = new javax.swing.JComboBox<>();
        b_valider = new javax.swing.JButton();
        b_annuler = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ajouter une projection");

        l_titre.setText("Titre :");

        tf_date.setToolTipText("");

        jLabel1.setText("Date :");

        jLabel2.setText("Heure Début :");

        jLabel3.setText("Salle :");

        b_valider.setText("Valider");
        b_valider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_validerActionPerformed(evt);
            }
        });

        b_annuler.setText("Annuler");
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
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(l_titre)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(tf_date, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cb_films, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cb_salles, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tf_heure)))
                .addContainerGap(174, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(b_valider)
                .addGap(18, 18, 18)
                .addComponent(b_annuler)
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_titre)
                    .addComponent(cb_films, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cb_salles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tf_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tf_heure, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_valider)
                    .addComponent(b_annuler))
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b_validerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_validerActionPerformed
        try {
            ResultSet rset=connexionBD.createStatement().executeQuery("SELECT duree FROM cpoa_film WHERE titre='"+cb_films.getSelectedItem().toString()+"';");
                    rset.next();
            parent.ajouterProjection(cb_films.getSelectedItem().toString(),
                    cb_salles.getSelectedItem().toString(),
                    tf_date.getText(),tf_heure.getText(),
                    rset.getInt("duree"));
        } catch (SQLException ex) {
            Logger.getLogger(Page_Ajouter.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_b_validerActionPerformed

    private void b_annulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_annulerActionPerformed
        this.dispose();
    }//GEN-LAST:event_b_annulerActionPerformed

    /**
     * @param args the command line arguments
     */

    
    public void remplirListeFilms(){
        ResultSet rset=null;
        Statement stmt=null;
        
        try {
            stmt=connexionBD.createStatement();
            rset=stmt.executeQuery("SELECT titre FROM cpoa_film");
            while (rset.next()) {
                String item = rset.getString("titre");
                cb_films.addItem(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Page_Ajouter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void remplirListeSalles(){
        ResultSet rset=null;
        Statement stmt=null;
        
        try {
            stmt=connexionBD.createStatement();
            rset=stmt.executeQuery("SELECT nom FROM cpoa_salle");
            while (rset.next()) {
                String item = rset.getString("nom");
                cb_salles.addItem(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Page_Ajouter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

            
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_annuler;
    private javax.swing.JButton b_valider;
    private javax.swing.JComboBox<String> cb_films;
    private javax.swing.JComboBox<String> cb_salles;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel l_titre;
    private javax.swing.JTextField tf_date;
    private javax.swing.JTextField tf_heure;
    // End of variables declaration//GEN-END:variables
}
