package View;

import Model.Model;

import java.awt.*;
import javax.swing.*;
public class GridPanel extends JPanel{

    private Model model;

    public GridPanel(Model model) {
        this.model = model;
        this.setPreferredSize(model.getPreferredSize());
//        this.image = new GameOverImage(model);
//        this.image.run();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        model.draw(g);

        if (model.isGameOver()) {
//            g.drawImage(image.getImage(), 0, 0, null);
        }
    }
}
