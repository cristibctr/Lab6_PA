/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cristi.lab6_pa;

import static java.awt.BorderLayout.SOUTH;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
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
        final JFileChooser fc = new JFileChooser();
        int returnVal = fc.showSaveDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION)
            try {
                ImageIO.write(frame.canvas.image, "png", new File(fc.getSelectedFile().getAbsolutePath() + ".png"));
            } catch (IOException ex) { System.err.println(ex); }
    }
    private void load(ActionEvent e){
        final JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION)
            try {
                frame.canvas.image = ImageIO.read(fc.getSelectedFile());
                frame.canvas.repaint();
            } catch (IOException ex) { System.err.println(ex); }
    }
    private void reset(ActionEvent e){
        frame.canvas.image = new BufferedImage(frame.canvas.W, frame.canvas.H, BufferedImage.TYPE_INT_ARGB);
        frame.canvas.graphics = frame.canvas.image.createGraphics();
        frame.canvas.graphics.setColor(Color.WHITE);
        frame.canvas.graphics.fillRect(0, 0, frame.canvas.W, frame.canvas.H);
        frame.canvas.repaint();
    }
    private void exit(ActionEvent e){
        System.exit(0);
    }
    //TODO
}
