/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cristi.lab6_pa;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author crist
 */
public class DrawingPanel extends JPanel{
    final MainFrame frame;
    final static int W = 800, H = 600;
    BufferedImage image;
    Graphics2D graphics; 
    List<Shape> shapes = new ArrayList<>();
    List<Color> colors = new ArrayList<>();
    public DrawingPanel(MainFrame frame) {
        this.frame = frame; 
        createOffscreenImage(); 
        init();
    }
    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, W, H);
    }
    private void init() {
        setPreferredSize(new Dimension(W, H)); 
        setBorder(BorderFactory.createEtchedBorder()); 
        this.addMouseListener(new MouseAdapter() { 
            @Override
            public void mousePressed(MouseEvent e) {
                drawShape(e.getX(), e.getY()); 
                repaint();
            }
        });
    }
    
    private void drawShape(int x, int y){
        int radius = (int)frame.configPanel.sidesField[1].getValue();
        int sides = (int)frame.configPanel.sidesField[0].getValue();
        Color color;
        final Random r = new Random();
        if(frame.configPanel.getDataComboBoxColor() == "Black")
                color = Color.BLACK;
        else
                color = new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256),r.nextInt(256));
        graphics.setColor(color);
        if(frame.configPanel.getDataComboBoxShapes() == "Ellipse")
            shapes.add(new NodeShape(x, y, radius));
        else
            shapes.add(new RegularPolygon(x, y, radius, sides));
        colors.add(color);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
        Graphics2D g2d = (Graphics2D) g;
        if(!shapes.isEmpty())
            for(int i = 0; i < shapes.size(); i++){
                g2d.setColor(colors.get(i));
                g2d.fill(shapes.get(i));
            }
        g2d.dispose();
    }
    
    public void clearShape(){
        if(!shapes.isEmpty()){
            shapes.remove(shapes.size()-1);
            colors.remove(colors.size()-1);
        }
    }
}
