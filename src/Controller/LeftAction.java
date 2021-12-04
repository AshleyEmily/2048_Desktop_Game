package Controller;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

import Model.Model;
import View.GameFrame;

public class LeftAction extends AbstractAction {

    private GameFrame frame;
    private Model model;

    /**
     * @param frame View
     * @param model Model
     */
    public LeftAction(GameFrame frame, Model model){
        this.frame = frame;
        this.model = model;
    }

    /**
     * Method runs when user press left arrow key
     * @param event for key action
     */
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
