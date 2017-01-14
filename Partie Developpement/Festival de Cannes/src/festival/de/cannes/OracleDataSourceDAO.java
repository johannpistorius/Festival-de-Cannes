/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package festival.de.cannes;

import java.io.FileInputStream;
import java.io.IOException; 
import java.sql.*; 
import java.util.*;
import oracle.jdbc.pool.OracleDataSource;

/**
 *
 * @author p1511158
 */
public class OracleDataSourceDAO {
    private static OracleDataSource ods;
    private OracleDataSourceDAO() throws SQLException{
        
    }
    public static OracleDataSource getOracleDataSourceDAO(){
        FileInputStream fichier=null;
        try{
            Properties props=new Properties();
            fichier=new FileInputStream(".\\src\\nompackage\\dao\\oracle\\connexion.properties");
            props.load(fichier);
            ods = new OracleDataSource(); 
            ods.setDriverType(props.getProperty("pilote")); 
            ods.setPortNumber(new Integer(props.getProperty("port")).intValue()); 
            ods.setServiceName(props.getProperty("service")); 
            ods.setUser(props.getProperty("user")); 
            ods.setPassword(props.getProperty("pwd")); 
            ods.setServerName(props.getProperty("serveur"));
        }catch(SQLException | IOException ex){
            
        }finally{
            /*try{
                fichier.close();
            }catch(IOException ex){
                
            }*/
        }
        return ods;
    }
}
