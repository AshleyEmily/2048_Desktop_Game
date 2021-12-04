package Controller;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

import Model.Model;
import View.GameFrame;

public class LeftAction extends AbstractAction {

    private GameFrame frame;
    private Model model;
    

    public LeftAction(GameFrame frame, Model model){
        this.frame = frame;
        this.model = model;
    }

    public void actionPerformed(ActionEvent event){
        if(model.ArrowActive()){
            if (model.isGameOver() == true){
                model.setArrowActive(false);
                System.out.println("GAME OVER");
            }else {
                model.modelMoveLeft();

                frame.updateScorePanel();
                frame.repaintGridPanel();

                model.addNewCell();
                frame.repaintGridPanel();
            }
        }

    }
}
