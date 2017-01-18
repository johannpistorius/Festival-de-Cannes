package festival_de_cannes.model;

import org.mariadb.jdbc.MariaDbDataSource;
import java.io.FileInputStream;
import java.io.IOException; 
import java.sql.*; 
import java.util.*;
import javax.sql.DataSource;


/**
 *
 * @author Alexis
 * @author Johann
 */
public class MariaDbDataSourceDAO {
    private static MariaDbDataSource mds;
    private MariaDbDataSourceDAO() throws SQLException{
        
    }
    public static DataSource getDataSource(){
        FileInputStream fichier=null;
        Properties props=new Properties();
        try{         
            fichier=new FileInputStream(".\\src\\festival_de_cannes\\controller\\connection.properties");
            props.load(fichier);
            mds = new MariaDbDataSource(); 
            mds.setDatabaseName(props.getProperty("DbName"));
            mds.setPortNumber(Integer.parseInt(props.getProperty("portNumber")));
            mds.setServerName(props.getProperty("server"));
            mds.setUserName(props.getProperty("user"));
            mds.setPassword(props.getProperty("pwd"));
            
            return mds;
        }catch(IOException e){
            System.out.println("Erreur lors de l'ouverture du fichier");
        }
        finally{
            try{
                fichier.close();
            }catch(IOException e){
                System.out.println("Erreur dans la fermeture du fichier");
            }
        }
        return mds;
    }
}