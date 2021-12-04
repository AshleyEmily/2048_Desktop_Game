package Controller;

import Model.Model;
import View.GameFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartGameActionListener implements ActionListener {
	
    private GameFrame frame;
    private Model model;

    /**
     * @param frame View
     * @param model Model
     */
    public StartGameActionListener(GameFrame frame, Model model) {
        this.frame = frame;
        this.model = model;
    }

    /**
     * Method runs when user click "START GAME" button
     * @param event
     */
    @Override
    public void actionPerformed(ActionEvent event) {
    	model.resetModel();
        model.setArrowActive(true);
        
        model.addNewCell();
        model.addNewCell();
        
        frame.repaintGridPanel();
        frame.updateScorePanel();
    }
}
