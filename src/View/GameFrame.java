package View;

import Controller.DownAction;
import Controller.LeftAction;
import Controller.RightAction;
import Controller.UpAction;
import Model.Board;
import Model.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameFrame extends JPanel {

    private ControlPanel controlPanel;
    private Model model;
    private GridPanel gridPanel;
    private JFrame frame;
    private ScorePanel scorePanel;
    private Board board;

    public GameFrame(Model model, Board board) {
        this.model = model;
        this.board = board;

//        this.highScoreProperties = new HighScoreProperties(model);
//        this.highScoreProperties.loadProperties();
        createPartControl();
    }

    private void createPartControl() {
        gridPanel = new GridPanel(model);
        scorePanel = new ScorePanel(model);
        controlPanel = new ControlPanel(this, model, board);

        frame = new JFrame();
        frame.setTitle("2048");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                exitProcedure();
            }
        });

        setKeyBindings();

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout());

        mainPanel.add(createSidePanel());
        mainPanel.add(gridPanel);

        frame.add(mainPanel);
        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);
    }

    private JPanel createSidePanel() {
        JPanel sidePanel = new JPanel();
        sidePanel.setLayout(new BoxLayout(sidePanel,
                BoxLayout.PAGE_AXIS));
        sidePanel.add(scorePanel.getPanel());
        sidePanel.add(Box.createVerticalStrut(30));
        sidePanel.add(controlPanel.getPanel());
        return sidePanel;
    }

    private void setKeyBindings() {
        InputMap inputMap =
                gridPanel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(KeyStroke.getKeyStroke("W"), "up arrow");
        inputMap.put(KeyStroke.getKeyStroke("S"), "down arrow");
        inputMap.put(KeyStroke.getKeyStroke("A"), "left arrow");
        inputMap.put(KeyStroke.getKeyStroke("D"), "right arrow");

        inputMap.put(KeyStroke.getKeyStroke("UP"), "up arrow");
        inputMap.put(KeyStroke.getKeyStroke("DOWN"), "down arrow");
        inputMap.put(KeyStroke.getKeyStroke("LEFT"), "left arrow");
        inputMap.put(KeyStroke.getKeyStroke("RIGHT"), "right arrow");

        inputMap = gridPanel.getInputMap(JPanel.WHEN_FOCUSED);
        inputMap.put(KeyStroke.getKeyStroke("UP"), "up arrow");
        inputMap.put(KeyStroke.getKeyStroke("DOWN"), "down arrow");
        inputMap.put(KeyStroke.getKeyStroke("LEFT"), "left arrow");
        inputMap.put(KeyStroke.getKeyStroke("RIGHT"), "right arrow");


        gridPanel.getActionMap().put("up arrow",
                new UpAction(this, model, board));
        gridPanel.getActionMap().put("down arrow",
                new DownAction(this, model, board));
        gridPanel.getActionMap().put("left arrow",
                new LeftAction(this, model, board));
        gridPanel.getActionMap().put("right arrow",
                new RightAction(this, model, board));
    }

    public void exitProcedure() {
//        model.setHighScores();
//        highScoreProperties.saveProperties();
        frame.dispose();
        System.exit(0);
    }

    public void repaintGridPanel() {
        gridPanel.repaint();
    }

    public void updateScorePanel() {
        scorePanel.updatePartControl();
    }


} //end GameFrame class
