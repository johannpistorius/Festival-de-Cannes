/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package festival.de.cannes;

import java.sql.*;
import java.io.*;
import java.util.*;
import java.net.URL;

/**
 *
 * @author Johann
 */
public class ConfigureConnection {
    public static Connection getConnection(String nomFichierProp)
            throws IOException, ClassNotFoundException, SQLException {
        Properties props = new Properties();
        URL urlFichierProp = ConfigureConnection.class.getResource(nomFichierProp);
        BufferedInputStream bis = null;
        try {
            bis = new BufferedInputStream(urlFichierProp.openStream());
            props.load(bis);
            String driver = props.getProperty("driver");
            String url = props.getProperty("url");
            String utilisateur = props.getProperty("utilisateur");
            String mdp = props.getProperty("mdp");
            Class.forName(driver);
            return DriverManager.getConnection(url, utilisateur, mdp);
        } finally {
            if (bis != null) {
                bis.close();
            }
        }
    }
    public static Connection getConnection(String nomFichierProp,
            String utilisateur,
            String mdp)
            throws IOException, ClassNotFoundException, SQLException {
        Properties props = new Properties();
        URL urlFichierProp = ConfigureConnection.class.getResource(nomFichierProp);
        try (BufferedInputStream bis = new BufferedInputStream(urlFichierProp.openStream())) {
            props.load(bis);
            String driver = props.getProperty("driver");
            String url = props.getProperty("url");
            Class.forName(driver);
            return DriverManager.getConnection(url, utilisateur, mdp);
        }
    }
}
