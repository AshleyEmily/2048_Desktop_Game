package Controller;

import Model.Model;
import View.GameFrame;
import Model.Board;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartGameActionListener implements ActionListener {
    private GameFrame frame;

    private Model model;

    private Board board;

    public StartGameActionListener(GameFrame frame, Model model, Board board) {
        this.frame = frame;
        this.model = model;
        this.board = board;
//        board.populateTiles();
//        board.populateTiles();
//        board.getGameScore();
//        board.getGameStatus();
//        board.isBoardFull();
//        board.getHighCell();

    }

    @Override
    public void actionPerformed(ActionEvent event) {
//        model.getHighScore();
//        model.setArrowActive(true);
//        model.cell();
        board.populateTiles();
        board.populateTiles();
        board.getGameScore();
        board.getGameStatus();
        board.isBoardFull();
        board.getHighCell();
        model.addNewCell();
        model.addNewCell();

        frame.repaintGridPanel();
        frame.updateScorePanel();
    }
}
