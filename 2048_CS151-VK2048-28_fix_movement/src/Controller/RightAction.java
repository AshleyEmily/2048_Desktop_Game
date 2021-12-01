package Controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import Model.Board;
import Model.Model;
import View.GameFrame;

public class RightAction extends AbstractAction {

    private GameFrame frame;
    private Model model;
    private Board board;

    public RightAction(GameFrame frame, Model model, Board board){
        this.frame = frame;
        this.model = model;
        this.board = board;
    }

    public void actionPerformed(ActionEvent event){
        if(model.ArrowActive()){
            if (model.isGameOver()){
                model.setArrowActive(false);
            }else {
                model.modelMoveRight();

                frame.updateScorePanel();
                frame.repaintGridPanel();

                model.addNewCell();
                frame.repaintGridPanel();
            }
        }

    }
}
