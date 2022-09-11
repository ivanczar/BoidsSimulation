/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.Hashtable;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

/**
 *
 * @author Ivan
 */
public class ButtonPanel extends JPanel {

    protected JButton addBoid;
    protected JButton removeBoid;
    protected JSlider sepWeight;
    protected JSlider alignWeight;
    protected JSlider cohesionWeight;
    protected JSlider radDetect;

    public ButtonPanel() {

        super(new GridLayout());
//        super(new GridBagLayout());
//
//        GridBagConstraints gbc = new GridBagConstraints();
//        gbc.insets = new Insets(30, 0, 30, 0); // external padding

        removeBoid = new JButton("REMOVE BOID");
        addBoid = new JButton("ADD BOID");

        sepWeight = new JSlider(0, 20, 0);
        alignWeight = new JSlider(0, 20, 0);
        cohesionWeight = new JSlider(0, 10, 0); 
        radDetect = new JSlider(0, 100, 0);
        sepWeight.setBorder(BorderFactory.createTitledBorder("Separation Weight"));
        alignWeight.setBorder(BorderFactory.createTitledBorder("Alignment Weight"));
        cohesionWeight.setBorder(BorderFactory.createTitledBorder("Cohesion Weight"));
        radDetect.setBorder(BorderFactory.createTitledBorder("Radius Detection"));

        add(sepWeight);
        add(alignWeight);
        add(cohesionWeight);
        add(radDetect);
        add(addBoid);
        add(removeBoid);

    }

}
