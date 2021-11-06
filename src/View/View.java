package View;

import Model.Board;

import javax.swing.*;
import java.awt.*;

public class View extends JPanel {

    protected Board boardModel;
    protected JPanel controlPanel;
    protected JPanel gamePanel;
    protected JFrame frame;

    //grid specs
    private JLabel[][] grid;
    private static final int SIDES = 4;
    private static final int SIDE_LENGTH = 100;
    private static final int GAP = 1;
    private static final Color CELL_COLOR = Color.decode("#cb997e");

    //frame specs
    public static int FRAME_WIDTH = 1000;
    public static int FRAME_HEIGHT = 500;

    public View() {
        // Interface will consist of two panels: controlPanel for Score and Settings,
        // and gamePanel for the game's grid
        controlPanel = new JPanel();
        gamePanel = new JPanel();

        controlPanel.setBackground(Color.decode("#ddbea9"));
        gamePanel.setBackground(Color.decode("#ddbea9"));

        JLabel scoreDisplay = new JLabel("SCORE: ", SwingConstants.CENTER);
        scoreDisplay.setPreferredSize(new Dimension(300, 100));
        scoreDisplay.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        controlPanel.add(scoreDisplay);

        setLayout((new GridLayout(1, 2)));
        add(controlPanel);
        add(gamePanel);

        // setup for JFrame where both JPanels will be
        frame = new JFrame();
        Container cp = frame.getContentPane();
        cp.add(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);


        //creating the game grid
        grid = new JLabel[SIDES][SIDES];
        setBorder(BorderFactory.createLineBorder(Color.BLACK, GAP));
//        setLayout(new GridLayout(SIDES, SIDES));
        Dimension prefSize = new Dimension(SIDE_LENGTH, SIDE_LENGTH);
        for (int i = 0; i < SIDES; i++) {
            for (int j = 0; j < SIDES; j++) {
                grid[i][j] = new JLabel("?", SwingConstants.CENTER);
                grid[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                grid[i][j].setBackground(CELL_COLOR);
                grid[i][j].setOpaque(true);
                grid[i][j].setPreferredSize(prefSize);
                gamePanel.add(grid[i][j]); // adds game grid to the right side of the View
            }
        }
    }

    public void display() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        View panel = new View();
        panel.display();

    }
} //end AppPanel class
