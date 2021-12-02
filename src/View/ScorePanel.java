package View;
import Model.Model;

import javax.swing.*;
import java.awt.*;
import java.text.NumberFormat;

public class ScorePanel {
    private static final Insets regularInsets   =
            new Insets(10, 10, 0, 10);
    private static final Insets spaceInsets =
            new Insets(10, 10, 10, 10);

    private static final NumberFormat nf =
            NumberFormat.getInstance();
    private Model model;
    private JPanel panel;

    private JTextField highScoreField;
    private JTextField highCellField;
    private JTextField currentScoreField;
    private JTextField currentCellField;

    public ScorePanel(Model model) {
        this.model = model;
        createPartControl();
        updatePartControl();
    }
    private void createPartControl() {
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        int gridy = 0;

        JLabel highScoreLabel = new JLabel("High Score:");
        addComponent(panel, highScoreLabel, 0, gridy, 1, 1,
                regularInsets, GridBagConstraints.LINE_START,
                GridBagConstraints.HORIZONTAL);

        highScoreField = new JTextField(6);
        highScoreField.setEditable(false);
        highScoreField.setHorizontalAlignment(JTextField.RIGHT);
        addComponent(panel, highScoreField, 1, gridy++, 1, 1,
                regularInsets, GridBagConstraints.LINE_START,
                GridBagConstraints.HORIZONTAL);

        JLabel highCellLabel = new JLabel("High Cell:");
        addComponent(panel, highCellLabel, 0, gridy, 1, 1,
                spaceInsets, GridBagConstraints.LINE_START,
                GridBagConstraints.HORIZONTAL);

        highCellField = new JTextField(6);
        highCellField.setEditable(false);
        highCellField.setHorizontalAlignment(JTextField.RIGHT);
        addComponent(panel, highCellField, 1, gridy++, 1, 1,
                spaceInsets, GridBagConstraints.LINE_START,
                GridBagConstraints.HORIZONTAL);

        JLabel currentScoreLabel = new JLabel("Current Score:");
        addComponent(panel, currentScoreLabel, 0, gridy, 1, 1,
                regularInsets, GridBagConstraints.LINE_START,
                GridBagConstraints.HORIZONTAL);

        currentScoreField = new JTextField(6);
        currentScoreField.setEditable(false);
        currentScoreField.setHorizontalAlignment(JTextField.RIGHT);
        addComponent(panel, currentScoreField, 1, gridy++, 1, 1,
                regularInsets, GridBagConstraints.LINE_START,
                GridBagConstraints.HORIZONTAL);
    }

    private void addComponent(Container container, Component component,
                              int gridx, int gridy, int gridwidth, int gridheight,
                              Insets insets, int anchor, int fill) {
        GridBagConstraints gbc = new GridBagConstraints(gridx, gridy,
                gridwidth, gridheight, 1.0D, 1.0D, anchor, fill,
                insets, 0, 0);
        container.add(component, gbc);
    }

    public void updatePartControl() {
         highScoreField.setText(nf.format(model.getModelHighScore()));
         highCellField.setText(nf.format(model.getHighCell()));
         currentScoreField.setText(nf.format(model.getScore()));
    }

    public JPanel getPanel() {
        return panel;
    }

}
