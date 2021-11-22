import View.GameFrame;
import Model.Model;

import javax.swing.*;

public class GameRunner implements Runnable {

    @Override
    public void run() {
        new GameFrame(new Model());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new GameRunner());
    }
}
