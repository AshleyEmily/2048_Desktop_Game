package Controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import Model.Board;
import Model.Model;
import View.GameFrame;

public class UpAction extends AbstractAction {

    private GameFrame frame;
    private Model model;
    private Board board;

    public UpAction(GameFrame frame, Model model, Board board){
        this.frame = frame;
        this.model = model;
        this.board = board;
    }

    public void actionPerformed(ActionEvent event){
        if (model.isGameOver()){

        }else {
        	System.out.println("UP before");
            model.printCellGridandBoard();
            
            model.modelMoveUp();
            
        	System.out.println("UP after");
            model.printCellGridandBoard();

            frame.updateScorePanel();
            frame.repaintGridPanel();
            
            model.addNewCell();
            frame.updateScorePanel();
            frame.repaintGridPanel();

        }

    }
}
