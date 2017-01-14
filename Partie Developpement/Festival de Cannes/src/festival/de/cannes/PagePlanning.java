/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package festival.de.cannes;

import java.awt.*;
import javax.swing.*;

/**
 *La page avec les projections
 * @author johann
 */
public class PagePlanning extends JFrame{
    JFrame frame;
    JPanel panel;
    JTable table;
    JScrollPane tableContainer;
    String[] columnNames;
    Object[][] data;
    /**
     * Constructeur
     */
    public PagePlanning(){
        super();
        init();
    }
    public final void init(){
        this.columnNames = new String[]{"Jour", "Heure", "Titre", "Type", "Realisateur"};
        this.data= new Object[][]{{"hello","hello","hello","hello","hello"}};
        panel=new JPanel();
        frame=new JFrame("Planning Projection");
        table=new JTable(data,columnNames);
        tableContainer=new JScrollPane(table);
        panel.setLayout(new BorderLayout());
        panel.add(tableContainer,BorderLayout.CENTER);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
