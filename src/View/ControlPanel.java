package View;

import Controller.StartGameActionListener;
import Model.Model;

import javax.swing.*;
import java.awt.*;

public class ControlPanel {
    private static final Insets regularInsets = new Insets(10, 10, 0, 10); //sets padding
    private GameFrame frame;
    private Model model;
    private JPanel panel;

    public ControlPanel(GameFrame frame, Model model) {
        this.frame = frame;
        this.model = model;
        createPartControl();
    }

    private void createPartControl() {
        StartGameActionListener listener = new StartGameActionListener(frame, model);
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        int gridY = 0;

        JButton startGameButton = new JButton("START GAME");
        startGameButton.addActionListener(listener);

        addComponent(panel, startGameButton, 0, gridY++, 1, 1, regularInsets, GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);
    }

    private void addComponent(Container container, Component component, int gridX, int gridY, int gridWidth, int gridHeight,
            Insets insets, int anchor, int fill) {
        GridBagConstraints gbc = new GridBagConstraints(gridX, gridY, gridWidth, gridHeight, 1, 1, anchor, fill, insets, 0, 0);
        container.add(component, gbc);
    }

    public JPanel getPanel() {return panel;}
}
