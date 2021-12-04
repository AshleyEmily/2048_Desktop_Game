package View;
import Controller.Cell;
import Model.Model;


import java.awt.*;
import javax.swing.*;

/**
 * 
 * @author Samantha Guanzon
 *
 */
public class GridPanel extends JPanel{
    private static final int FRAME_THICKNESS = 16;
    private static final int GRID_WIDTH = 4;

    private Model model;

    public GridPanel(Model model) {
        this.model = model;
        this.setPreferredSize(model.getPreferredSize());
    }

    public Dimension getPreferredSize() {
        int width = GRID_WIDTH * Cell.getCellWidth() +
                FRAME_THICKNESS * 5;
        return new Dimension(width, width);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        model.draw(g);
    }
}
