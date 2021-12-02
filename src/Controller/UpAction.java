package Controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import Model.Board;
import Model.Model;
import View.GameFrame;

public class UpAction extends AbstractAction {

    private GameFrame frame;
    private Model model;

    public UpAction(GameFrame frame, Model model){
        this.frame = frame;
        this.model = model;
    }

    public void actionPerformed(ActionEvent event){
        if(model.ArrowActive()){
            if (model.isGameOver() == true){
                model.setArrowActive(false);
                System.out.println("GAME OVER");
            }else {
                model.modelMoveUp();

                frame.updateScorePanel();
                frame.repaintGridPanel();

                model.addNewCell();
                frame.repaintGridPanel();
            }
        }

    }
}
