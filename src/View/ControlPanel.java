package View;

import Controller.*;
import Controller.StartGameActionListener;
import Controller.Theme1Listener;
import Model.Model;
import javax.swing.*;
import java.awt.*;

/**
 * 
 * @author Samantha Guanzon
 *
 */

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
        Theme1Listener theme1Listener = new Theme1Listener(frame, model);
        Theme2Listener theme2Listener = new Theme2Listener(frame, model);
        Theme3Listener theme3Listener = new Theme3Listener(frame, model);

        panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        int gridY = 0;

        JButton startGameButton = new JButton("START GAME");
        startGameButton.addActionListener(listener);
        addComponent(panel, startGameButton, 0, gridY++, 1, 1, regularInsets, GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        // need to figure out how to make the listener do a popup
        JButton theme1Button = new JButton("CLASSIC THEME");
        theme1Button.addActionListener(theme1Listener);
        addComponent(panel, theme1Button, 0, gridY++, 1, 1, regularInsets, GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JButton theme2Button = new JButton("SKY THEME");
        theme2Button.addActionListener(theme2Listener);
        addComponent(panel, theme2Button, 0, gridY++, 1, 1, regularInsets, GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JButton theme3Button = new JButton("FOREST THEME");
        theme3Button.addActionListener(theme3Listener);
        addComponent(panel, theme3Button, 0, gridY++, 1, 1, regularInsets, GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);
    }


    private void addComponent(Container container, Component component, int gridX, int gridY, int gridWidth, int gridHeight,
            Insets insets, int anchor, int fill) {
        GridBagConstraints gbc = new GridBagConstraints(gridX, gridY, gridWidth, gridHeight, 1, 1, anchor, fill, insets, 0, 0);
        container.add(component, gbc);
    }

    public JPanel getPanel() {return panel;}
}
