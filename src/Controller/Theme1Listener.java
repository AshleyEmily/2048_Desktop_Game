package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Board;
import Model.Model;
import View.GameFrame;

public class Theme1Listener implements ActionListener{
    private GameFrame frame;
    private Model model;
    private Board board;

    public Theme1Listener(GameFrame frame, Model model, Board board) {
        this.frame = frame;
        this.model = model;
        this.board = board;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //System.out.println("changed to theme2");
        model.setTheme(1);
        frame.repaintGridPanel();
    }
}
