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
    JPanel panel=new JPanel();
    /**
     * Constructeur
     */
    public PagePlanning(){
        super();
        init();
    }
    public final void init(){
        setSize(1000, 700);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel.setLayout(null);
        setContentPane(panel);
        setVisible(true);
    }
}
