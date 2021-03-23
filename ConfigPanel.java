/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cristi.lab6_pa;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author crist
 */
public class ConfigPanel extends JPanel{
    final MainFrame frame;
    JLabel[] sidesLabel = new JLabel[3];
    JSpinner[] sidesField = new JSpinner[3];
    JComboBox colorCombo;
    String[] randOrBlack = {"Random", "Black"};
    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init(){
        sidesLabel [0] = new JLabel("Number of sides: ");
        sidesField [0] = new JSpinner (new SpinnerNumberModel(0, 0, 100, 1));
        sidesField[0].setValue(6);
        
        sidesLabel [1] = new JLabel("Size number: ");
        sidesField [1] = new JSpinner (new SpinnerNumberModel(0, 0, 100, 1));
        sidesField[1].setValue(6);
        
        sidesLabel [2] = new JLabel("Stroke size: ");
        sidesField [2] = new JSpinner (new SpinnerNumberModel(0, 0, 100, 1));
        sidesField[2].setValue(6);
        //TODO
        colorCombo = new JComboBox(randOrBlack);
        
        //this.addActionListener();
        
        for(int i = 0; i < 3; i++){
            add(sidesLabel[i]);
            add(sidesField[i]);
        }
        add(colorCombo);
    }
}
