/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package festival_de_cannes;

import org.mariadb.jdbc.MariaDbDataSource;
import java.io.FileInputStream;
import java.io.IOException; 
import java.sql.*; 
import java.util.*;
import javax.sql.DataSource;
import oracle.jdbc.pool.OracleDataSource;


/**
 *
 * @author p1511158
 */
public class MariaDbDataSourceDAO {
    private static MariaDbDataSource mds;
    private MariaDbDataSourceDAO() throws SQLException{
        
    }
    public static DataSource getOracleDataSourceDAO(){
        FileInputStream fichier=null;
        try{
            Properties props=new Properties();
            
            
            
            // indice sur l'arborescence :   fichier=new FileInputStream(".\\src\\nompackage\\dao\\oracle\\connexion.properties");
            

            fichier=new FileInputStream(".\\src\\festival_de_cannes\\connection.properties");
            props.load(fichier);
            mds = new MariaDbDataSource(); 
            mds.setDatabaseName(props.getProperty("DbName"));
            mds.setPortNumber(Integer.parseInt(props.getProperty("portNumber")));
            mds.setServerName(props.getProperty("server"));
            mds.setUserName(props.getProperty("user"));
            mds.setPassword(props.getProperty("pwd"));
            
            
            /*
            ods.setDriverType(props.getProperty("driver")); 
            ods.setPortNumber(new Integer(props.getProperty("port")).intValue()); 
            ods.setServiceName(props.getProperty("service")); 
            ods.setUser(props.getProperty("user")); 
            ods.setPassword(props.getProperty("pwd")); 
            ods.setServerName(props.getProperty("serveur"));
            ods.setURL(props.getProperty("url"));
            */
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
