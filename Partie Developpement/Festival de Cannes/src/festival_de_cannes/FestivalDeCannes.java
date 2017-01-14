/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package festival_de_cannes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;

/**
 *Main
 * 
 * @author johann
 */
public class FestivalDeCannes {
    
    
    static PagePlanning p;
    private static OracleClasseMetierDAO classeMetierDAO;
    private static DataSource dataSourceDAO;
    private static Connection connexionBD;
    
    
    public FestivalDeCannes(){
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ResultSet rset=null;
        Statement stmt=null;
        String str;
        int nbFilms=-1;
        try{
        dataSourceDAO = OracleDataSourceDAO.getOracleDataSourceDAO();
        classeMetierDAO = new OracleClasseMetierDAO();
        classeMetierDAO.setDataSource(dataSourceDAO);
        connexionBD=dataSourceDAO.getConnection("p1511158","246652");  // Erreur ici

        classeMetierDAO.setConnection(connexionBD);
        System.out.println("Erreur SQL");
        stmt=connexionBD.createStatement();
            rset=stmt.executeQuery("SELECT count(*) from CPOA_Film");
            str = rset.getString("count(*)");
            nbFilms = Integer.parseInt(str);
        }catch(SQLException e){
            System.out.println("Erreur SQL");
        }

        p=new PagePlanning();
        System.out.println("Nombre de Films : "+nbFilms);
    }
    
}
