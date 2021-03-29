/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cristi.lab6_pa;

import java.awt.Shape;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author crist
 */
public class ShapesList {
    List<Class> shapes = new ArrayList<>();

    public ShapesList() {
        shapes.add(RegularPolygon.class);
        shapes.add(NodeShape.class);
    }

    public Class getShapesAt(int index) {
        return shapes.get(index);
    }
    
}
