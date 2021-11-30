package Controller;

import Model.Model;
import View.GameFrame;
import Model.Board;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class DownAction extends AbstractAction {

    private GameFrame frame;
    private Model model;
    private Board board;

    public DownAction(GameFrame frame, Model model, Board board){
        this.frame = frame;
        this.model = model;
        this.board = board;
    }

    public void actionPerformed(ActionEvent event){
        if (model.isGameOver()){

        }else {
            model.addNewCell();

            board.populateTiles();
            frame.updateScorePanel();
            frame.repaintGridPanel();
        }

    }


}
