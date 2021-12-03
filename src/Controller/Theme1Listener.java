package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Board;
import Model.Model;
import View.GameFrame;

public class Theme1Listener implements ActionListener{
    private GameFrame frame;
    private Model model;

    /**
     * @param frame View
     * @param model Model
     */
    public Theme1Listener(GameFrame frame, Model model) {
        this.frame = frame;
        this.model = model;
    }

    /**
     * Method runs when user click "CLASSIC THEME" button
     * @param e is an instance of ActionEvent class
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        model.setTheme(1);
        frame.repaintGridPanel();
    }
}
