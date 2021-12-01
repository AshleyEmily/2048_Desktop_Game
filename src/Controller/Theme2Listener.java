package Controller;

import Model.Model;
import View.GameFrame;
import Model.Board;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Theme2Listener implements ActionListener{
    private GameFrame frame;
    private Model model;
    private Board board;

    public Theme2Listener(GameFrame frame, Model model, Board board) {
        this.frame = frame;
        this.model = model;
        this.board = board;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("changed to theme2");
        model.setTheme(2);
        frame.repaintGridPanel();
    }
}
