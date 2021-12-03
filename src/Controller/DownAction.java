package Controller;

import Model.Model;
import View.GameFrame;


import javax.swing.*;
import java.awt.event.ActionEvent;

public class DownAction extends AbstractAction {

    private GameFrame frame;
    private Model model;

    /**
     * @param frame View
     * @param model Model
     */
    public DownAction(GameFrame frame, Model model){
        this.frame = frame;
        this.model = model;
    }

    /**
     * Method runs when user press down arrow key
     * @param event for key action
     */
    public void actionPerformed(ActionEvent event){
        if(model.ArrowActive()){
            if (model.isGameOver() == true){
                model.setArrowActive(false);
                System.out.println("GAME OVER");
            }else {
                model.modelMoveDown();

                frame.updateScorePanel();
                frame.repaintGridPanel();

                model.addNewCell();
                frame.repaintGridPanel();

            }
        }

    }


}
