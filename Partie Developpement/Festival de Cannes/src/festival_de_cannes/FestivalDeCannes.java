
package festival_de_cannes;

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
    
    
    static PagePlanning p;
    private static MariaDbClasseMetierDAO classeMetierDAO=null;
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
        //int nbFilms=-1;
        MariaDbDataSource mds=null;
        FileInputStream fichier=null;
        Properties props=new Properties();
        
        try{
            
            fichier=new FileInputStream(".\\src\\festival_de_cannes\\connection.properties");
            props.load(fichier);
            mds = new MariaDbDataSource(); 
            mds.setDatabaseName(props.getProperty("DbName"));
            mds.setPortNumber(Integer.parseInt(props.getProperty("portNumber")));
            mds.setServerName(props.getProperty("server"));
            mds.setUserName(props.getProperty("user"));
            mds.setPassword(props.getProperty("pwd"));
            
            dataSourceDAO = MariaDbDataSourceDAO.getOracleDataSourceDAO();
            classeMetierDAO = new MariaDbClasseMetierDAO();
            classeMetierDAO.setDataSource(dataSourceDAO);
            classeMetierDAO.setConnection(connexionBD);
            
            connexionBD=dataSourceDAO.getConnection("root","");  // Erreur ici

            System.out.println("Connexion établie !!!");
            stmt=connexionBD.createStatement();
            rset=stmt.executeQuery("SELECT titre from cpoa_film where numFilm=0;");

            rset.next();
            str = rset.getString("titre");
        }
        catch(SQLException e){
            System.out.println("Erreur SQL");
        }

        //p=new PagePlanning();
            
            System.out.println("Nom du premier film : "+str);
    }
}
