package festival_de_cannes.view;

import festival_de_cannes.model.MariaDbDataSourceDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static java.time.LocalDateTime.now;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alexis
 * @author Johann
 */
public class Page_Principale extends javax.swing.JFrame {
    
    private static DataSource dataSourceDAO=null;
    private static Connection connexionBD=null;
    DefaultTableModel modele;
    
    public Page_Principale() {
        initComponents();
        
        
        modele = (DefaultTableModel) t_planning.getModel();
        
        dataSourceDAO = MariaDbDataSourceDAO.getDataSource();
        try {
            connexionBD=dataSourceDAO.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Page_Principale.class.getName()).log(Level.SEVERE, null, ex);
        }
        remplirProjections();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_planning = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_planning = new javax.swing.JTable();
        b_ajouter = new javax.swing.JButton();
        b_generer = new javax.swing.JButton();
        b_supprimer = new javax.swing.JButton();
        l_retour = new javax.swing.JLabel();
        menuBar_header = new javax.swing.JMenuBar();
        menu_fichier = new javax.swing.JMenu();
        menuItem_Sauvegarder = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Festival De Cannes");

        panel_planning.setBorder(javax.swing.BorderFactory.createTitledBorder("Planning Actuel"));

        t_planning.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Titre", "Salle", "Date", "Heure début", "Durée (minutes)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        t_planning.setEditingColumn(1);
        jScrollPane1.setViewportView(t_planning);

        javax.swing.GroupLayout panel_planningLayout = new javax.swing.GroupLayout(panel_planning);
        panel_planning.setLayout(panel_planningLayout);
        panel_planningLayout.setHorizontalGroup(
            panel_planningLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_planningLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_planningLayout.setVerticalGroup(
            panel_planningLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_planningLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
                .addContainerGap())
        );

        b_ajouter.setText("Ajouter une projection");
        b_ajouter.setToolTipText("Ajoute une projection pour un film et un horaire choisis");
        b_ajouter.setPreferredSize(new java.awt.Dimension(200, 60));
        b_ajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_ajouterActionPerformed(evt);
            }
        });

        b_generer.setText("Générer un planning");
        b_generer.setToolTipText("Génère automatiquement le planning à partir des films enregistrés sur une plage horaire choisie");
        b_generer.setPreferredSize(new java.awt.Dimension(200, 60));
        b_generer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_genererActionPerformed(evt);
            }
        });

        b_supprimer.setText("Supprimer Projection");
        b_supprimer.setToolTipText("Supprime la projection sélectionnée");
        b_supprimer.setPreferredSize(new java.awt.Dimension(200, 60));
        b_supprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_supprimerActionPerformed(evt);
            }
        });

        menu_fichier.setText("Fichier");
        menu_fichier.setToolTipText("");

        menuItem_Sauvegarder.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        menuItem_Sauvegarder.setText("Sauvegarder");
        menuItem_Sauvegarder.setToolTipText("Ecrase l'ancien planning sur la base de données avec le planning actuel");
        menuItem_Sauvegarder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_SauvegarderActionPerformed(evt);
            }
        });
        menu_fichier.add(menuItem_Sauvegarder);

        menuBar_header.add(menu_fichier);

        setJMenuBar(menuBar_header);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(219, 219, 219)
                        .addComponent(l_retour)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panel_planning, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(b_ajouter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b_generer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b_supprimer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(b_generer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(b_ajouter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(b_supprimer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(panel_planning, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37)
                .addComponent(l_retour)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b_supprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_supprimerActionPerformed
        if(t_planning.getSelectedRowCount()>0){
            Page_Supprimer page = new Page_Supprimer(this);
            page.setVisible(true);
        }
    }//GEN-LAST:event_b_supprimerActionPerformed

    private void b_ajouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_ajouterActionPerformed
        Page_Ajouter page = new Page_Ajouter(this);
        page.setVisible(true);
    }//GEN-LAST:event_b_ajouterActionPerformed

    private void b_genererActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_genererActionPerformed
        Page_Generer page = new Page_Generer();
        page.setVisible(true);
    }//GEN-LAST:event_b_genererActionPerformed

    private void menuItem_SauvegarderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_SauvegarderActionPerformed
        Statement stmt=null;
        ResultSet rset=null;
        try {
            stmt=connexionBD.createStatement();
            stmt.executeQuery("DELETE FROM cpoa_projection;");
            int nbProjections = modele.getRowCount();
            for(int i=0;i<nbProjections;i++){
                int numProjection=i;
                rset=stmt.executeQuery("SELECT numFilm FROM cpoa_film WHERE cpoa_film.titre ='"+modele.getValueAt(i,0)+"';");
                rset.next();
                int numFilm=rset.getInt("numFilm");
                String jour=modele.getValueAt(i,2).toString();
                String heure=modele.getValueAt(i,3).toString();
                String dateDebut=jour.substring(6,10)+'-'+jour.substring(3,5)+'-'+jour.substring(0,2)+' '+heure+":00";
                rset=stmt.executeQuery("SELECT numSalle FROM cpoa_salle WHERE cpoa_salle.nom ='"+modele.getValueAt(i,1)+"';");
                rset.next();
                int numSalle=rset.getInt("numSalle");
                stmt.executeQuery("INSERT INTO cpoa_projection VALUES("+numProjection+","+numFilm+",'"+dateDebut+"',"+numSalle+")");
                l_retour.setText("Sauvegarde effectuée ("+now().toString().substring(0,10)+' '+now().toString().substring(11,19)+")");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Page_Principale.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuItem_SauvegarderActionPerformed

    public void remplirProjections(){
        ResultSet rset=null;
        Statement stmt=null;
        String titre="";
        String salle ="";
        String date ="";
        String heureDebut ="";
        String dateTemp="";
        int duree=0;
            
        try {
            stmt=connexionBD.createStatement();
            rset=stmt.executeQuery("SELECT titre,nom,dateDebut,duree FROM cpoa_projection, cpoa_film, cpoa_salle WHERE cpoa_projection.numfilm=cpoa_film.numfilm AND cpoa_projection.numsalle=cpoa_salle.numsalle;");
            while(rset.isLast()!=true){
                rset.next();
                titre = rset.getString("titre");
                salle = rset.getString("nom");
                dateTemp=rset.getString("dateDebut");
                date = dateTemp.substring(8,10)+'/'+dateTemp.substring(5,7)+'/'+dateTemp.substring(0,4);
                heureDebut = rset.getString("dateDebut").substring(11,16);
                duree = rset.getInt("duree");
                modele.addRow(new Object[]{titre, salle, date, heureDebut, duree});
            }
        } catch (SQLException ex) {
            Logger.getLogger(Page_Principale.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void supprimerProjection(){
        modele.removeRow(t_planning.getSelectedRow());
    }
    
    public void ajouterProjection(String titre,String salle,String date,String heure,int duree){
        modele.addRow(new Object[]{titre, salle, date, heure, duree});
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_ajouter;
    private javax.swing.JButton b_generer;
    private javax.swing.JButton b_supprimer;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel l_retour;
    private javax.swing.JMenuBar menuBar_header;
    private javax.swing.JMenuItem menuItem_Sauvegarder;
    private javax.swing.JMenu menu_fichier;
    private javax.swing.JPanel panel_planning;
    private javax.swing.JTable t_planning;
    // End of variables declaration//GEN-END:variables
}
