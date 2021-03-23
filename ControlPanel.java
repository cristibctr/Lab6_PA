/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cristi.lab6_pa;

import static java.awt.BorderLayout.SOUTH;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author crist
 */
public class ControlPanel extends JPanel{
    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    //TODO
    
    public ControlPanel(MainFrame frame){
        this.frame = frame;
        init();
    }
    private void init(){
        setLayout(new GridLayout(1,4));
        //TODO
        saveBtn.addActionListener(this::save);
        //TODO
        add(saveBtn, SOUTH);
    }
    private void save(ActionEvent e){
        try {
            ImageIO.write(frame.canvas.image, "PNG", new File("D:/test.png"));
        } catch (IOException ex) { System.err.println(ex); }
    }
    //TODO
}
