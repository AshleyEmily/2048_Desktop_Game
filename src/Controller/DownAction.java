package Controller;

import Model.Model;
import View.GameFrame;


import javax.swing.*;
import java.awt.event.ActionEvent;

public class DownAction extends AbstractAction {

    private GameFrame frame;
    private Model model;
    
    public DownAction(GameFrame frame, Model model){
        this.frame = frame;
        this.model = model;
    }

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
