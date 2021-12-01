package Controller;

import Model.Model;
import View.GameFrame;
import Model.Board;

import java.awt.event.ActionEvent;

public class Theme2Listener extends Settings{
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
        setTheme(2);
        frame.repaintGridPanel();
    }
}
