
package festival_de_cannes.view;

import festival_de_cannes.model.MariaDbDataSourceDAO;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;
import oracle.jdbc.pool.OracleDataSource;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException; 
import java.sql.*; 
import java.util.*;
import javax.sql.DataSource;
import oracle.jdbc.pool.OracleDataSource;
import org.mariadb.jdbc.MariaDbDataSource;

/**
 *Main
 * 
 * @author johann
 */
public class FestivalDeCannes {
    
    
    static Page_Principale p;
    private static DataSource dataSourceDAO=null;
    private static Connection connexionBD=null;
    
    
    public FestivalDeCannes(){
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, SQLException {
        ResultSet rset=null;
        Statement stmt=null;
        String str="";

        
        try{
            dataSourceDAO = MariaDbDataSourceDAO.getDataSource();
            connexionBD=dataSourceDAO.getConnection();
            
            /*System.out.println("Connexion établie !!!");
            stmt=connexionBD.createStatement();
            rset=stmt.executeQuery("SELECT titre from cpoa_film where numFilm=1;");

            rset.next();
            str = rset.getString("titre");
            System.out.println("Nom du film : "+str);*/
        }
        catch(SQLException e){
            System.out.println("Erreur SQL");
        }

        p=new Page_Principale();
            
            
    }
}
