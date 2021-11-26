import View.GameFrame;
import Model.Model;
import Model.Board;

import javax.swing.*;

public class GameRunner implements Runnable {

    @Override
    public void run() {
        new GameFrame(new Model(), new Board());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new GameRunner());
    }
}
