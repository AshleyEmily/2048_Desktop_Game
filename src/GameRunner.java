import View.GameFrame;
import Model.Model;
import Model.Board;

import javax.swing.*;

public class GameRunner implements Runnable {

    @Override
    public void run() {
    	Model game = new Model();
        new GameFrame(game, game.getBoard());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new GameRunner());
    }
}
