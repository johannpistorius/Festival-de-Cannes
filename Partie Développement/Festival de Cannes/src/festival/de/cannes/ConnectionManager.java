/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package festival.de.cannes;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;

/**
 *
 * @author Johann
 */
public class ConnectionManager {
    Connection conn;
    ResultSetMetaData rsmd;
    public ConnectionManager() throws IOException, ClassNotFoundException, SQLException{
        init();
    }
    public void init() throws IOException, ClassNotFoundException, SQLException{
        try{
            Class.forName("org.mariadb.jdbc.Driver");
        }catch(Exception e){
            System.out.println("Can't load the charger");
            return;
        }
        conn=ConfigureConnection.getConnection("connection.properties");
    }
    public void closeConnexion() throws SQLException{
        conn.close();
    }
    public void afficherResultSet(ResultSet rset) throws SQLException {
        rsmd = rset.getMetaData();
        while (rset.next()) {
            int i = 1;
            switch (rsmd.getColumnType(i)) {
                case Types.CHAR:
                    System.out.println(rset.getString(i));
                    break;
                case Types.DATE:
                    System.out.println(rset.getDate(i));
                    break;
                case Types.DOUBLE:
                    System.out.println(rset.getDouble(i));
                    break;
                case Types.FLOAT:
                    System.out.println(rset.getDouble(i));
                    break;
                case Types.INTEGER:
                    System.out.println(rset.getInt(i));
                    break;
                case Types.TIME:
                    System.out.println(rset.getTime(i));
                    break;
                case Types.TIMESTAMP:
                    System.out.println(rset.getTimestamp(i));
                    break;
                case Types.VARCHAR:
                    System.out.println(rset.getString(i));
                    break;
                default:
                    System.out.println("This type of column doesn't work");
            }
            i++;
        }
    }
}
