/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package festival_de_cannes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.*;
import javax.sql.DataSource;

/**
 *
 * @author p1511158
 */
public class MariaDbClasseMetierDAO /*implements IClasseMetierDAO*/{
    private static DataSource ds;
    private static Connection connexionBD;
    
    
    
    public MariaDbClasseMetierDAO(){
        System.out.println("test");
    }
    
    
    
    //@Override
    public void setDataSource(DataSource ds){
        MariaDbClasseMetierDAO.ds=ds;
    }
    //@Override
    public void setConnection(Connection c){
        MariaDbClasseMetierDAO.connexionBD=c;
    }
    /*//@Override
    public List<ClasseMetier> getLesObjetsClasseMetier(){
        ResultSet rset=null;
        Statement stmt=null;
        List<ClasseMetier> listeClasseMetier=null;
        try{
            stmt=connexionBD.createStatement();
            listeClasseMetier=new ArrayList<>();
            rset=stmt.executeQuery("SELECT * from ClasseMetier");
            while(rset.next()){
                ...
            }
        }catch(SQLException exc){
            
        }finally{
            try{
                //la clause finally est toujours executee, quoi qu'il arrive
                if(stmt!=null)stmt.close();
                if(rset!=null)rset.close();
            }catch(SQLException ex){
                
            }
        }
        return listeClasseMetier;
    }*/
    public int getNbPersonne(){
        ResultSet rset=null;
        Statement stmt=null;
        int nbPersonne=0;
        String str;
        try{
            this.setConnection(connexionBD);
            stmt=connexionBD.createStatement();
            rset=stmt.executeQuery("SELECT count(*) from CPOA_Personne");
            str = rset.getString("count(*)");
            nbPersonne = Integer.parseInt(str);
        }catch(SQLException exc){
            System.out.println("Erreur SQL 1");
        }finally{
            try{
                //la clause finally est toujours executee, quoi qu'il arrive
                if(stmt!=null)stmt.close();
                if(rset!=null)rset.close();
            }catch(SQLException ex){
                System.out.println("Erreur SQL 2");
            }
        }
        return nbPersonne;
    }
    
}
