/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package festival.de.cannes;

import java.sql.Connection;
import java.sql.SQLException;
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
        // TODO code application logic here
        try{
        dataSourceDAO = OracleDataSourceDAO.getOracleDataSourceDAO();
        classeMetierDAO = new OracleClasseMetierDAO();
        classeMetierDAO.setDataSource(dataSourceDAO);
        connexionBD=dataSourceDAO.getConnection("p1511158","246652");
        classeMetierDAO.setConnection(connexionBD);
        }catch(SQLException e){}

        p=new PagePlanning();
        System.out.println("Nombre de VIP : "+classeMetierDAO.getNbPersonne());
    }
    
}
