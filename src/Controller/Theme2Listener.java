package Controller;

import Model.Model;
import View.GameFrame;
import Model.Board;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Theme2Listener implements ActionListener{
    private GameFrame frame;
    private Model model;

    public Theme2Listener(GameFrame frame, Model model) {
        this.frame = frame;
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        model.setTheme(2);
        frame.repaintGridPanel();
    }
}
