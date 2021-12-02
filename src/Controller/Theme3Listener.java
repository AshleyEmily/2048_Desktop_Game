package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Board;
import Model.Model;
import View.GameFrame;

public class Theme3Listener implements ActionListener{
    private GameFrame frame;
    private Model model;

    public Theme3Listener(GameFrame frame, Model model) {
        this.frame = frame;
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        model.setTheme(3);
        frame.repaintGridPanel();
    }
}
