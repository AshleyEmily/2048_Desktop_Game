package Controller;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

import Model.Model;
import View.GameFrame;

public class RightAction extends AbstractAction {

    private GameFrame frame;
    private Model model;

    /**
     * @param frame View
     * @param model Model
     */
    public RightAction(GameFrame frame, Model model){
        this.frame = frame;
        this.model = model;
    }

    /**
     * Method runs when user press right arrow key
     * @param event for key action
     */
    public void actionPerformed(ActionEvent event){
        if(model.ArrowActive()){
            if (model.isGameOver() == true){
                model.setArrowActive(false);
                System.out.println("GAME OVER");
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
