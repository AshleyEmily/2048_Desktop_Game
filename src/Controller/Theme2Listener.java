package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Model;
import View.GameFrame;

/**
 * ActionListener Class which changes the theme of the game to theme 1 or "Sky Theme."
 * Communicates between the Model and the View.
 */
public class Theme2Listener implements ActionListener{
    private GameFrame frame;
    private Model model;

    /**
     * Constructor which instantiates the action listener with the view and model.
     * Allows for communication between the view and model.
     * @param frame the graphical interface for the 2048 game, part of View.
     * @param model handles the data and logic of the 2048 game, part of Model.
     */
    public Theme2Listener(GameFrame frame, Model model) {
        this.frame = frame;
        this.model = model;
    }

    /**
     * Method runs when user click "SKY THEME" button
     * @param e is an instance of ActionEvent class
     */
    @Override
    /**
     * Method which changes theme of the 2048 board.
     * @param e the action which triggers this event to occur.
     */
    public void actionPerformed(ActionEvent e) {
        model.setTheme(2);
        frame.repaintGridPanel();
    }
}
