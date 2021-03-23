/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cristi.lab6_pa;

import static java.awt.BorderLayout.SOUTH;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
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
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");
    //TODO
    
    public ControlPanel(MainFrame frame){
        this.frame = frame;
        init();
    }
    private void init(){
        setLayout(new GridLayout(1,4));
        //TODO
        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        resetBtn.addActionListener(this::reset);
        exitBtn.addActionListener(this::exit);
        //TODO
        add(saveBtn, SOUTH);
        add(loadBtn, SOUTH);
        add(resetBtn, SOUTH);
        add(exitBtn, SOUTH);
    }
    private void save(ActionEvent e){
        try {
            ImageIO.write(frame.canvas.image, "PNG", new File("D:/test.png"));
        } catch (IOException ex) { System.err.println(ex); }
    }
    private void load(ActionEvent e){
        try {
            frame.canvas.image = ImageIO.read(new File("D:/test.png"));
        } catch (IOException ex) { System.err.println(ex); }
    }
    private void reset(ActionEvent e){
        frame.canvas.image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
    }
    private void exit(ActionEvent e){
        
    }
    //TODO
}
