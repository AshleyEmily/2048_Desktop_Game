package View;

import Controller.Cell;
import Model.Model;


import java.awt.*;
import java.util.Random;
import javax.swing.*;
public class GridPanel extends JPanel{

//    Board game;
    private static final int FRAME_THICKNESS = 16;
    private static final int GRID_WIDTH = 4;

    private Cell[][] grid;
//    private Random random;
    private Model model;

    public GridPanel(Model model) {
        this.model = model;
        this.setPreferredSize(model.getPreferredSize());
//         this.image = new GameOverImage(model);
//         this.image.run();
        this.grid = model.getGrid();
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

        if (model.isGameOver()) {
            //g.drawImage(image.getImage(), 0, 0, null);
        }
    }
}
